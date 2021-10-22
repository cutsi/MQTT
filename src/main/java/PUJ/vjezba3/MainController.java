package PUJ.vjezba3;

import java.io.IOException;
import java.util.LinkedList;

import org.eclipse.paho.client.mqttv3.MqttAsyncClient;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttPersistenceException;


public class MainController {
	
	
	public LinkedList<Sensor> SensorList;

	public MainController() {
	}

	public LinkedList<Sensor> getSensorList() {
		return SensorList;
	}

	public void setSensorList(LinkedList<Sensor> sensorList) {
		SensorList = sensorList;
	}
	
	public int GetSensorListLenght() throws IOException {
		MainController mc = new Reader().configureSensors();
		int len = 0;
		for(Sensor s: mc.SensorList) {
			len++;
		}
		return len;
	}
	public MqttClient connect(String broker) throws MqttException {
		@SuppressWarnings("resource")
		MqttClient mqttClient = new MqttClient(broker,String.valueOf(System.nanoTime()));
		MqttConnectOptions connOpts = new MqttConnectOptions();
	    connOpts.setCleanSession(true); 
	    connOpts.setKeepAliveInterval(1000);
	    mqttClient.connect(connOpts); 
	    return mqttClient;
	}
	public String[] GetNames() throws IOException {
		MainController mc = new Reader().configureSensors();
		String[] StringSensorList = new String[mc.GetSensorListLenght()];
		int cnt = 0;
		for(Sensor s: mc.SensorList) {
			StringSensorList[cnt] = s.getTopic();
			cnt++;
		}
		return StringSensorList;
	}
	public void Start(String broker) throws IOException, MqttPersistenceException, MqttException, InterruptedException {
		MainController mc = new Reader().configureSensors();
		while (true){
	    	for(Sensor s: mc.SensorList) {
	    		MqttClient mqttClient = new MainController().connect(broker);
	    		byte[] a = Short.toString(s.GenerateRandomRange()).getBytes();
		    	mqttClient.publish(s.getTopic(), a, 1, true);
		    	Thread.sleep(2000);
		    	//System.out.println(a.);
		    	//Thread.sleep(1000);
		    	
		    }
		}
		
	}
	@SuppressWarnings("unused")
	public void Threading(String broker) throws IOException {
		MainController mc = new Reader().configureSensors();

		for(Sensor s:mc.SensorList) {
			//System.out.println(s.getTopic());
			Thread t = new Thread(new Runnable() {
				@Override
				public void run() {
					while(true) {
						try {
							MqttClient mqttClient;
				    		mqttClient = new Connect().ConnectWithBroker(broker); 
					    	mqttClient.publish(s.getTopic(), Short.toString(s.GenerateRandomRange()).getBytes(), 1, true);
							Thread.sleep(2000);
						} catch (InterruptedException | MqttException e) {
							e.printStackTrace();
						}
						
					}
					
				}
			});
			t.start();
		}
	}
	
	
	
	
	
	
	
	
	
//	MainController(){
//		SensorList = new LinkedList<Sensor>();
//		try {
//		Sensor s1 = new Sensor((short)10,"C",(short) -32668,(short) 32668, "sensor/Water temperature");
//		SensorList.add(s1);
//	    Sensor s2 = new Sensor((short)1000,"C",(short) 0,(short) 32666, "sensor/Water pressure");
//	    SensorList.add(s2);
//	    Sensor s3 = new Sensor((short)0,"L",(short) 0,(short) 32666, "sensor/Consumption/min");
//	    SensorList.add(s3);
//	    Sensor s4 = new Sensor((short)0,"L",(short) 0,(short) 32666, "sensor/Consumption/hr");
//	    SensorList.add(s4);
//	    Sensor s5 = new Sensor((short)0,"L",(short) 0,(short) 32666, "sensor/Consumption/day");
//	    SensorList.add(s5);
//	    Sensor s6 = new Sensor((short)0,"L",(short) 0,(short) 32666, "sensor/Consumption/week");
//	    SensorList.add(s6);
//	    Sensor s7 = new Sensor((short)0,"L",(short) 0,(short) 32666, "sensor/Consumption/month");
//	    SensorList.add(s7);
//	    Sensor s8 = new Sensor((short)0,"L",(short) 0,(short) 32666, "sensor/Consumption/year");
//	    SensorList.add(s8);
//		}
//		catch(NullPointerException e) 
//        { 
//            System.out.print("NullPointerException Caught"); 
//            
//        } 
//	}
}
