package PUJ.vjezba3;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttMessage;

public class MyMQTTCallback implements MqttCallback{

	public void connectionLost(Throwable cause) {
		// TODO Auto-generated method stub
		System.out.println("Connection lost");
	}

	public void messageArrived(String topic, MqttMessage message) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("MEssage arrived");

	}

	public void deliveryComplete(IMqttDeliveryToken token) {
		// TODO Auto-generated method stub
		System.out.println("delivery complete");
		
	}

}
