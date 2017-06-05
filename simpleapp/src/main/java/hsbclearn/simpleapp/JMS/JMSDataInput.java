package hsbclearn.simpleapp.JMS;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.jms.TextMessage;

import hsbclearn.simpleapp.IDataInput;
import hsbclearn.simpleapp.IMessageParser;
import hsbclearn.simpleapp.IntegerWrapper;
import hsbclearn.simpleapp.JAXB.MessageParser;
import hsbclearn.simpleapp.resources.JMSResources;


//@ApplicationScoped
//@RequestScoped

@JmsInputOutput
@Dependent
public class JMSDataInput implements IDataInput {
	JMSResources jmsRes;
	Connection conn;
	Session  session;	
	
	JMSDataInput() {  jmsRes = new JMSResources(); jmsRes.init(); }
	
	@Override
	public List<IntegerWrapper> getData() {
		IMessageParser parser = new MessageParser();
		return parser.readXML(getDataAsString());
		
	}
	@Override
	public String getDataAsString() {
		MessageConsumer consumer;
		String responseMsg = null;
		TextMessage response = null;
		try {
			
			ConnectionFactory connFactory = jmsRes.getConnFactory();
			conn = connFactory.createConnection();
			session = conn.createSession(false, Session.AUTO_ACKNOWLEDGE);
			consumer = session.createConsumer(jmsRes.getResponseQueue());
			conn.start();
			response = (TextMessage) consumer.receive();
			responseMsg = ((TextMessage) response).getText();
			
			System.out.println("getDataAsString: "+responseMsg);
			
			session.close();
			conn.close();
			consumer.close();
		} 
		catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
				
		return responseMsg;
		
	}

}
