package hsbclearn.simpleapp.examples;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Message;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.naming.Context;
import javax.naming.InitialContext;

public class ExampleJMS {

	public void init() {
		
		  try {
			  
		      Context ctx = new InitialContext();
		      ConnectionFactory fact = (ConnectionFactory) ctx.lookup("jms/simpleAppConnectionFactory");
		      String admDestName = "jms/SimpleAppDefaultQueue";
		      Queue queue = (Queue) ctx.lookup(admDestName);
		      
		      Connection conn = fact.createConnection();
		      Session session = conn.createSession(false, Session.AUTO_ACKNOWLEDGE);
		      conn.start();
		      
		      MessageProducer producer = session.createProducer(queue);
		      Message message = session.createTextMessage("test message");
		      producer.send(message);
		      
		      session.close();
		      conn.close();
		      
		  } catch (Exception e) {
			  e.printStackTrace();
		  }
		
	}
	
}
