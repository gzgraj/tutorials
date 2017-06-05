package hsbclearn.simpleapp.examples;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.jms.JMSException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import hsbclearn.simpleapp.XMLProcessController;
//import example.cdi.app.GUIContoller;



@WebServlet("/ExampleServlet")
public class ExampleServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	@Inject
	XMLProcessController executor;
	public ExampleServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*BEZ CDI
		IDataOutput jmsOut = new JMSDataOutput();
		
		//JMSDataInput jmsIn = new JMSDataInput();
		IDataInput jmsIn = new JMSDataInput();
		IDataOutput consoleOut = new DataOutput();
		IDataInput input = new XMLDataInput();
		IDataProcessor processor = new IncrementalDataProcessor();
		
        System.out.println("Wysyłam...");
        jmsOut.writeData(processor.processData(input.getData()));
       
	
		System.out.println("Odbieram...");
		System.out.println(consoleOut.writeData(processor.processData(jmsIn.getData())).toString());
		
		response.getWriter()
		.append("Served at ala ma kota i psa 5: ")
		.append(request.getContextPath());
		*/
		
		System.out.println("wwwwqqqqCzekam...");
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Run...");
		executor.run();
		System.out.println("After Run...");
		response.getWriter()
		.append(executor.getdataReaded())
		.append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}	
	
}
