package ar.com.ecco.esb.procesos.primitiva;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.camel.CamelException;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;

import ar.com.ecco.esb.procesos.declaraciones.Constantes;

public class RecuperoCantidadRegistros implements Processor {

	public void process(Exchange exchange) throws CamelException {

		//
		@SuppressWarnings("unchecked")
		Map<String, Object> body = (HashMap<String, Object>) ((ArrayList<?>) exchange.getIn().getBody()).get(0);
		//se obtiene la cantidad total de registros de la consulta sin paginar.
		String totalRegistrosConsultados =  body.get("CantidadComprobantes").toString();
		exchange.getIn().setHeader(Constantes.getTotalRegistrosConsultados(), totalRegistrosConsultados);
		exchange.setOut(exchange.getIn());
	}
}
