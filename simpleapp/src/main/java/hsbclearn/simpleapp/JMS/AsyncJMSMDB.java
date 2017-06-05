package hsbclearn.simpleapp.JMS;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.ejb.MessageDriven;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import java.util.List;

import javax.ejb.ActivationConfigProperty;
import javax.jms.MessageListener;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import hsbclearn.simpleapp.IMessageParser;
import hsbclearn.simpleapp.IntegerWrapper;
import hsbclearn.simpleapp.JAXB.MessageParser;
import hsbclearn.simpleapp.resources.JMSResources;

/**
 * @author gzgraj
 *
 */
@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
@MessageDriven(                                     // Message-driven bean (MDB)
		activationConfig = { @ActivationConfigProperty(   // activation configuration (more)
								propertyName = "destinationType", 
								propertyValue = "javax.jms.Queue"
							),
							@ActivationConfigProperty(
								propertyName = "destination", 
								//propertyValue = "jms/simpleAppSpec"        // destination's JNDI name
								propertyValue = "jms/simpleAppRequestQueue"
								//propertyValue = getName() // zrobić/zapytac i jeszcze messageSelector
								
							) 
		})

public class AsyncJMSMDB implements MessageListener {
	public void onMessage(Message message) {          
	TextMessage textMsg = (TextMessage) message;
	try {
	  System.out.println("AsyncJMSMDB::Komunikat: " + textMsg.getText());
	 
	}
	catch (JMSException e) {
	  System.out.println("Błąd pobierania komunikatu");
	    }
	  }
	private String getName() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	
	public void sendMessage(Message message)  {
		JMSResources jmsRes = new JMSResources();
		Connection conn;
		Session  session;	
		String messageBody;
		jmsRes.init(); 
		try {
			ConnectionFactory connFactory = jmsRes.getConnFactory();
			conn = connFactory.createConnection();
			session = conn.createSession(false, Session.AUTO_ACKNOWLEDGE);
			Destination destination =  message.getJMSReplyTo();
			MessageProducer producer = session.createProducer(destination);
			IMessageParser parser = new MessageParser();
	        
			Message request = session.createTextMessage(((TextMessage) message).getText() );
		    producer.send(request,  Message.DEFAULT_DELIVERY_MODE,
                    Message.DEFAULT_PRIORITY,
                    Message.DEFAULT_TIME_TO_LIVE);
		    System.out.println("AsyncJMSMDB::Wysyłam: " + ((TextMessage)message).getText());
		    session.close();
			conn.close();
			producer.close();
		   
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		

		//conn.createConnection().
		
	}


	
	
}