package ar.com.ecco.esb.procesos.primitiva;

import java.util.List;
import java.util.Map;

import javax.ws.rs.core.MultivaluedMap;

import org.apache.camel.CamelException;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.cxf.jaxrs.utils.JAXRSUtils;

import ar.com.ecco.esb.procesos.declaraciones.Constantes;

public class TomaDatosHTTPQUERY implements Processor {

	public void process(Exchange exchange) throws CamelException {

		try {

			String queryString = exchange.getIn().getHeader(
					Exchange.HTTP_QUERY, String.class);

			MultivaluedMap<String, String> queryMap = JAXRSUtils
					.getStructuredParams(queryString, "&", false, false);

			for (Map.Entry<String, List<String>> eachQueryParam : queryMap
					.entrySet()) {

				exchange.setProperty(eachQueryParam.getKey(),
						eachQueryParam.getValue());

				exchange.setOut(exchange.getIn());
			}
		} catch (Exception exceptionCamel) {
			throw new CamelException(Constantes.getApp()
					+ Constantes.getMetodoTomadatoshttp()
					+ Constantes.getNoOk() + exceptionCamel);

		}

	}

}
