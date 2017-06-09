package hsbclearn.simpleapp.JMS;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
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
		MessageConsumer consumer = null;
		String responseMsg = null;
		String resultXML = null;
		Message response = null;
		
		
		List <IntegerWrapper> tmpresult = new ArrayList<IntegerWrapper>();
		
		ConnectionFactory connFactory = jmsRes.getConnFactory();
		try {
			conn = connFactory.createConnection();
		} catch (JMSException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		try {
			session = conn.createSession(true, Session.AUTO_ACKNOWLEDGE);
		} catch (JMSException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		try {
			
			
			consumer = session.createConsumer(jmsRes.getResponseQueue());
			
			conn.start();
			
			while  (true) {
				response = (TextMessage) consumer.receive();
				if (response == null) {
					System.out.println("JMSDataInput response == null!");
					break;
				}

				if (!CorrelationData.isOurMessage(response.getJMSCorrelationID())) {
					System.out.println("JMSDataInput Nie mój ci On!");
					continue;
				}
				else
					System.out.println("JMSDataInput Mój ci On!");;
					
				responseMsg = ((TextMessage) response).getText();
				System.out.println("response->getDataAsString:["+responseMsg+"]");
				if (responseMsg.equals("11") && !response.getJMSRedelivered()) {
					System.out.println("Jeden JMSDataInput testowy rollback");
					try {
						session.rollback();
					} catch (JMSException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
				//bb = ((BytesMessage)response).readInt();
				tmpresult.add(new IntegerWrapper(Integer.valueOf(responseMsg)));
			}
			System.out.println("przed commit");
			session.commit();
			System.out.println("po commit");
			IMessageParser parser = new MessageParser();
			
			resultXML = parser.saveAsXML(tmpresult);
			
		} 
		catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				session.rollback();
			} catch (JMSException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
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
		
		System.out.println("JMSDataInput::resultXML"+resultXML);
				
		return resultXML;
		
	}

}
