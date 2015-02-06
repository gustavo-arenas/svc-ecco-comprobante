package ar.com.ecco.esb.procesos.respuesta;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.camel.CamelException;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;

import ar.com.ecco.esb.procesos.declaraciones.Constantes;

public class RtaECCOporComprobanteHistorico implements Processor {

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void process(Exchange exchange) throws CamelException {

		LinkedHashMap mapaRepuesta = new LinkedHashMap();

		LinkedHashMap mapCampo = new LinkedHashMap();

		LinkedHashMap mapCampoEstado = new LinkedHashMap();

		Integer cantidadRegistros = (Integer) exchange.getIn().getHeader(
				Constantes.getCamelSqlRowCount());
		if (cantidadRegistros == 0) {
			mapCampoEstado.put(Constantes.getCteestado(), Constantes.getOk());
			mapCampoEstado.put(Constantes.getCtecodigorespuesta(),
					Constantes.getCte99());
			mapCampoEstado.put(Constantes.getCtemensajerespuesta(),
					Constantes.getMsjAvisoFinok());

			mapaRepuesta.put(Constantes.getCtedatosestado(), mapCampoEstado);
			mapaRepuesta.put(Constantes.getCtedatosrespuesta(), " ");

		} else {
			mapCampoEstado.put(Constantes.getCteestado(), Constantes.getOk());
			mapCampoEstado.put(Constantes.getCtecodigorespuesta(),
					Constantes.getCte0());
			mapCampoEstado.put(Constantes.getCtemensajerespuesta(),
					Constantes.getMsjAvisoFinok());

			for (int i = 0; i < cantidadRegistros; i++) {

				Map<String, Object> body = (HashMap) ((ArrayList<?>) exchange
						.getIn().getBody()).get(i);

				for (Entry<String, Object> miset : body.entrySet()) {
					mapCampo.put(miset.getKey(), miset.getValue());
				}

			}

			mapaRepuesta.put(Constantes.getCtedatosestado(), mapCampoEstado);
			mapaRepuesta.put(Constantes.getCtedatosrespuesta(), mapCampo);

		}
		exchange.getIn().setBody(mapaRepuesta);
		exchange.setOut(exchange.getIn());
	}

}
