package ar.com.ecco.esb.procesos.solicitud;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.camel.CamelException;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.component.sql.SqlConstants;
import org.apache.log4j.Logger;

import ar.com.ecco.esb.procesos.declaraciones.Constantes;

public class SolECCOporComprobanteHistorico implements Processor {

	Logger logger = Logger.getLogger(getClass());
	
	@SuppressWarnings({ "unchecked" })
	public void process(Exchange exchange) throws CamelException {

		String query = null;
		String comprobante = null;

		query = Constantes.getQuerySoleccoporcomprobantehistorico();
		
		if (exchange.getIn().getBody() != null) {
			List<String> body = ((ArrayList<String>) exchange.getIn().getBody());
			comprobante = body.get(0);


		query = MessageFormat.format(query, comprobante);
		logger.debug(Constantes.getApp() + Constantes.getSep()
				+ Constantes.getMetodoSoleccoporcomprobante()
				+ Constantes.getSep() + Constantes.getDetLog() + query);
		exchange.setProperty("CamelSqlQuery", query);
		}
		
		exchange.setOut(exchange.getIn());
		exchange.getOut().setHeader(SqlConstants.SQL_QUERY, query);

	}

}
