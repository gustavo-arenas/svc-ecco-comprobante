package ar.com.ecco.esb.procesos.primitiva;

import java.util.Set;

import org.apache.camel.CamelException;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.log4j.Logger;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import ar.com.ecco.esb.procesos.declaraciones.Constantes;

public class TomaDatosBODY implements Processor {

	Logger logger = Logger.getLogger(getClass());

	public void process(Exchange exchange) throws CamelException,
			ParseException {

		/*
		 * Toma los parametros que viene en el path/object y los vuelca en el
		 * exchange para luego trabajarlos en los siguientes pasos
		 */

		// try {
		JSONObject json = (JSONObject) new JSONParser().parse((String) exchange
				.getIn().getBody());
		Set<?> clavesJson = json.keySet();

		while (clavesJson.iterator().hasNext()) {
			String valorJson = (String) clavesJson.iterator().next();
			exchange.setProperty(valorJson, json.get(valorJson));
			clavesJson.remove(valorJson);
		}

		logger.debug(Constantes.getApp() + Constantes.getSep()
				+ Constantes.getMetodoTomadatosbody() + Constantes.getSep()
				+ Constantes.getDetLog());
		exchange.setOut(exchange.getIn());

		// } catch (Exception ExceptionCamel) {
		// logger.debug(Constantes.getApp() + Constantes.getSep()
		// + Constantes.getMetodoTomadatosbody() + Constantes.getSep()
		// + Constantes.getDetLogErr());
		// throw new CamelException(Constantes.getApp() + Constantes.getSep()
		// + Constantes.getMetodoTomadatosbody() + Constantes.getSep()
		// + Constantes.getDetLogErr() + ExceptionCamel);
		// }

	}

}
