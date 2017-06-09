package hsbclearn.simpleapp.JMS;

public interface ICorrelationData {
	boolean isOurMessage( String givenCorrelationID) ;
	void addCorrelationID( String givenCorrelationID );
}
