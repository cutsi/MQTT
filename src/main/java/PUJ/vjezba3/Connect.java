package PUJ.vjezba3;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttSecurityException;

public class Connect {
	private String Broker;
	
	Connect(){
		
	}
	
	@SuppressWarnings("resource")
	public MqttClient ConnectWithBroker(String broker) throws MqttSecurityException, MqttException {
		MqttClient mqttClient;
		mqttClient = new MqttClient(broker, String.valueOf(System.nanoTime()));
		MqttConnectOptions connOpts = new MqttConnectOptions();
		connOpts.setCleanSession(true); // no persistent session
		connOpts.setKeepAliveInterval(1000);
		mqttClient.connect(connOpts); // connects the broker with connect options
		return mqttClient;
	} 
}
