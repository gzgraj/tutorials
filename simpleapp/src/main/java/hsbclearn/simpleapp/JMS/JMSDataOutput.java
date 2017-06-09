package hsbclearn.simpleapp.JMS;

import java.util.List;
import java.util.UUID;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TemporaryQueue;

//import com.ibm.rmi.iiop.Connection;

import hsbclearn.simpleapp.IDataOutput;
import hsbclearn.simpleapp.IMessageParser;
import hsbclearn.simpleapp.IntegerWrapper;
import hsbclearn.simpleapp.JAXB.MessageParser;
import hsbclearn.simpleapp.resources.JMSResources;

@JmsInputOutput
@Dependent
public class JMSDataOutput implements IDataOutput {
	
	JMSResources jmsRes;
	Connection conn;
	Session  session;	
	String messageBody;
	JMSDataOutput() {  System.out.println("JMSDataOutput inited"); jmsRes = new JMSResources();	jmsRes.init(); }
	
	@Override
	public String writeData(List<IntegerWrapper> data)  {
		
		try {
			ConnectionFactory connFactory = jmsRes.getConnFactory();
			conn = connFactory.createConnection();
			session = conn.createSession(false, Session.AUTO_ACKNOWLEDGE);
			MessageProducer producer = session.createProducer(jmsRes.getRequestQueue());
			IMessageParser parser = new MessageParser();
	        
	        // messageBody = parser.saveAsXML(data);
			for(IntegerWrapper i : data) {
				messageBody = Integer.toString(i.getData());
		        System.out.println("JMSDataOutput::messageBody->request:"+messageBody);
				Message request = session.createTextMessage(messageBody );
				request.setJMSReplyTo(jmsRes.getResponseQueue());
				String correlationID = UUID.randomUUID().toString();
				CorrelationData.addCorrelationID(correlationID);
				request.setJMSCorrelationID(correlationID);
			    producer.send(request,  Message.DEFAULT_DELIVERY_MODE,
	                    Message.DEFAULT_PRIORITY,
	                    Message.DEFAULT_TIME_TO_LIVE);
			    //session.commit(); // chyba jak transakcyjne wysylanie
			}   

		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				session.close();
			} catch (JMSException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				conn.close();
			} catch (JMSException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return messageBody;
		
	}

}