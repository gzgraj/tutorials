package hsbclearn.simpleapp;

import javax.ejb.Stateless;
import javax.jms.Message;

import javax.jms.MessageListener;
@Stateless
public class XStatetless implements MessageListener {

	@Override
	public void onMessage(Message arg0) {
		// TODO Auto-generated method stub

	}

}
