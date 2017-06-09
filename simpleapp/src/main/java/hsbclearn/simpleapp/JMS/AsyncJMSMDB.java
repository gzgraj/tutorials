package hsbclearn.simpleapp.JMS;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.ejb.MessageDriven;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

import java.util.List;

import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJBContext;
import javax.jms.MessageListener;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.transaction.TransactionManager;

import hsbclearn.simpleapp.IMessageParser;
import hsbclearn.simpleapp.IntegerWrapper;
import hsbclearn.simpleapp.JAXB.MessageParser;
import hsbclearn.simpleapp.resources.JMSResources;

/**
 * @author gzgraj
 *
 */

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
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class AsyncJMSMDB implements MessageListener {
	//@Inject
	//EJBContext  tm;
	public void onMessage(Message message) {  
	System.out.println("AsyncJMSMDB::OnMessage"); 	
	TextMessage textMsg = (TextMessage) message;
	if (message instanceof TextMessage) {
		try {
		  System.out.println("AsyncJMSMDB::Komunikat: " + textMsg.getText());
		  sendMessage( message );
		}
		catch (JMSException e) {
		  System.out.println("Błąd pobierania komunikatu");
		  // tm.setRollbackOnly(); // to raczej niepotrzebne bo wyjątek
		}
	} 
	else {
		System.out.println("Błąd pobierania komunikatu");
	}
}
	private String getName() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	
	public void sendMessage(Message message)  {
		JMSResources jmsRes = new JMSResources();
		Connection conn = null;
		Session  session = null;;	
		String messageBody;
		jmsRes.init(); 
		try {
			ConnectionFactory connFactory = jmsRes.getConnFactory();
			conn = connFactory.createConnection();
			session = conn.createSession(false, Session.AUTO_ACKNOWLEDGE);
			Destination destination =  message.getJMSReplyTo();
			MessageProducer producer = null;
			if (destination == null) {
				System.out.println("destination == null");
				destination = jmsRes.getResponseQueue();
			}
			
			producer = session.createProducer(destination);
	        
			Message request = session.createTextMessage(((TextMessage) message).getText() );
			if (destination != null)
				System.out.println("AsyncJMSMDB::Wysyłam destitantion -> " + destination.toString() +" komunikat :"+ ((TextMessage)message).getText());
			request.setJMSCorrelationID(message.getJMSCorrelationID());
		    producer.send(request,  Message.DEFAULT_DELIVERY_MODE,
                    Message.DEFAULT_PRIORITY,
                    Message.DEFAULT_TIME_TO_LIVE);
		    
		    session.close();
			conn.close();
			producer.close();
		   
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				session.close();
			} catch (JMSException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				conn.close();
			} catch (JMSException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}