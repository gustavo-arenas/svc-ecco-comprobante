package ar.com.ecco.esb.procesos.primitiva;

import org.apache.camel.CamelException;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.log4j.Logger;

public class DefaultProcessor implements Processor {
	
	Logger logger = Logger.getLogger(getClass());

	@Override
	public void process(Exchange arg0) throws CamelException {

	
		logger.debug("Entro en el processor");
		logger.debug("getIn" +  arg0.getFromRouteId() + " - " + arg0.getFromEndpoint() + arg0.getIn());
		logger.debug("getOut" + arg0.getFromRouteId() + " - " + arg0.getFromEndpoint() + arg0.getOut());
		arg0.setOut(arg0.getIn());
		logger.debug("getOut" + arg0.getFromRouteId() + " - " + arg0.getFromEndpoint() + arg0.getOut());


		
	}

}
