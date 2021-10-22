package PUJ.vjezba3;
import org.eclipse.paho.client.mqttv3.MqttClient;

public class App 
{
    public static MqttClient myClient;

	public static void main( String[] args ) throws Exception
    {
		new MQTT(6);
		new MQTT(5);
		
	}
}
