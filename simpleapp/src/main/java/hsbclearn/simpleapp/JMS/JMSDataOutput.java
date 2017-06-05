package hsbclearn.simpleapp.JMS;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Dependent;
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
	        
	       // conn.start();

	        messageBody = parser.saveAsXML(data);
	        System.out.println("JMSDataOutput::messageBody:"+messageBody);
			Message request = session.createTextMessage(messageBody );
			request.setJMSReplyTo(jmsRes.getResponseQueue());
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
		
		return messageBody;
		

		//conn.createConnection().
		
	}



	
}