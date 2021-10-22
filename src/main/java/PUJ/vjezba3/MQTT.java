package PUJ.vjezba3;

import java.awt.Color;

import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import java.io.IOException;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;


public class MQTT implements MqttCallback  {
	private JFrame frame;
	private JTextArea text1;
	private JTextArea text2;
	private JTextArea text3;
	private JTextArea text4;
	private JLabel label1;
	private JLabel label2;
	private JLabel label3;
	private JLabel label4;
	private MainController SensorList = new Reader().configureSensors();
	private String broker = "tcp://localhost:1883";
	private static String topic = "Sensor/#";
	
    public MQTT(int exercise) throws Exception {
		
		createFrame();
        this.subscribe(topic);
        if(exercise == 5) {
        	System.out.println("Pokrenuta 5 vjezba");  
        	new MainController().Start(broker);
        }
        else if (exercise == 6) {
        	System.out.println("Pokrenuta 6 vjezba");
        	new MainController().Threading(broker);
        }
        else
        	System.out.println("wrong selection");
	}
	
	 public void subscribe(String topic) {
		try
		{
			@SuppressWarnings("resource")
			MqttClient mqttClient;
    		mqttClient = new MainController().connect(broker);
			mqttClient.setCallback(this);
			mqttClient.subscribe(topic);
			
		} catch (MqttException me) {
			System.out.println(me);
		}   
	}

	 
	 public void createFrame() throws IOException {
		 
		 frame = new JFrame();
	   	 String[] names = SensorList.GetNames();
	 	 frame.setLayout(new GridLayout(4,2));
         frame.setSize(500, 100*names.length);
         frame.setVisible(true);
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 
		 label1 = new JLabel(names[0]);
		 label1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		 label1.setLayout(null);
		 label1.setVisible(true);
         frame.add(label1);
         
         text1 = new JTextArea();
         text1.setBorder(BorderFactory.createLineBorder(Color.BLUE));
         text1.setLayout(null);
         text1.setVisible(true);
         frame.add(text1);
         
         label2 = new JLabel(names[1]);
         label2.setBorder(BorderFactory.createLineBorder(Color.BLUE));
         label2.setLayout(null);
         label2.setVisible(true);
         frame.add(label2);
         
         text2 = new JTextArea();
         text2.setBorder(BorderFactory.createLineBorder(Color.BLUE));
         text2.setLayout(null);
         text2.setVisible(true);
         frame.add(text2);
         
         label3 = new JLabel(names[2]);
         label3.setBorder(BorderFactory.createLineBorder(Color.BLUE));
         label3.setLayout(null);
         label3.setVisible(true);
         frame.add(label3);
         
         text3 = new JTextArea();
         text3.setBorder(BorderFactory.createLineBorder(Color.BLUE));
         text3.setLayout(null);
         text3.setVisible(true);
         frame.add(text3);
         
         label4 = new JLabel(names[3]);
         label4.setBorder(BorderFactory.createLineBorder(Color.BLUE));
         label4.setLayout(null);
         label4.setVisible(true);
         frame.add(label4);
         
         text4 = new JTextArea();
         text4.setBorder(BorderFactory.createLineBorder(Color.BLUE));
         text4.setLayout(null);
         text4.setVisible(true);
         frame.add(text4);
	 } 

	 
	 
	@Override
	public void connectionLost(Throwable cause) {
		System.out.println("disconnected");
		
	}

	@Override
	public void messageArrived(String topic, MqttMessage message) throws Exception {
		
		if(topic.equals(label1.getText())) {
			text1.setText(message.toString());
		}
		else if(topic.equals(label2.getText())) {
			text2.setText(message.toString());
		}
		else if(topic.equals(label3.getText())) {
			text3.setText(message.toString());
		}
		else {
			text4.setText(message.toString());
		}
	}

	@Override
	public void deliveryComplete(IMqttDeliveryToken token) {
		// TODO Auto-generated method stub
	}

}




