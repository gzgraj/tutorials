package hsbclearn.simpleapp.JMS;

import java.util.SortedSet;
import java.util.TreeSet;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Stateful;
import javax.enterprise.context.Dependent;


//@Dependent
public class CorrelationData { //implements ICorrelationData {
	static SortedSet<String> correlationIDs = new TreeSet<String>();
static public boolean isOurMessage( String givenCorrelationID) {
	System.out.println("SortedSet::isOurMessage:"+givenCorrelationID);
	System.out.println("SortedSet::correlationIDs:"+((correlationIDs == null) ? "null":"not null"));
	return  (correlationIDs != null && givenCorrelationID != null) ?  correlationIDs.contains(givenCorrelationID) : false;
}
	
static public void addCorrelationID(String givenCorrelationID) {
	System.out.println("SortedSet::addCorrelationID:"+givenCorrelationID);
	correlationIDs.add(givenCorrelationID);
	
}
/*
 // GDZIE to czyścić ?
@PostConstruct void init() {
	correlationIDs = new TreeSet<String>();
	System.out.println("SortedSet::@PostConstruct");
}
@PreDestroy void reset() {
	correlationIDs = null;  // trzeba usuwać ?
	System.out.println("SortedSet::@PreDestroy");
}
*/
}
