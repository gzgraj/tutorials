package hsbclearn.simpleapp.resources;

import javax.jms.ConnectionFactory;
import javax.jms.Queue;
import javax.naming.Context;
import javax.naming.InitialContext;

public class JMSResources {

	private ConnectionFactory connFactory;
	private Queue defaultQueue;
	private Queue responseQueue;
	private Queue requestQueue;

	public void init() {
		try {
			System.out.println("JMSResources::init()");
			Context ctx = new InitialContext();
			connFactory = (ConnectionFactory) ctx.lookup("jms/simpleAppConnectionFactory");
			String admDestName = "jms/SimpleAppDefaultQueue";
			defaultQueue = (Queue) ctx.lookup(admDestName);
			String admResponseName = "jms/simpleAppResponseQueue";
			responseQueue = (Queue) ctx.lookup(admResponseName);
			String admRequestName = "jms/simpleAppRequestQueue";
			requestQueue = (Queue) ctx.lookup(admRequestName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ConnectionFactory getConnFactory() {
		return connFactory;
	}

	public Queue getDefaultQueue() {
		return defaultQueue;
	}
	
	public Queue getRequestQueue() {
		return requestQueue;
	}
	
	public Queue getResponseQueue() {
		return responseQueue;
	}

}
