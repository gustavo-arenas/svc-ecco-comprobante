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

public class RtaECCOComprobantesHistorico implements Processor {

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void process(Exchange exchange) throws CamelException {

		// SE VALIDA ERRORES
		LinkedHashMap mapaRepuesta = new LinkedHashMap();

		ArrayList listaArray = new ArrayList();
		LinkedHashMap mapCampo = new LinkedHashMap();
		LinkedHashMap mapRegistro = new LinkedHashMap();

		LinkedHashMap mapCampoEstado = new LinkedHashMap();

		Integer cantidadRegistros = (Integer) exchange.getIn().getHeader(
				Constantes.getCamelSqlRowCount());
		if (cantidadRegistros == 0) {
			mapCampoEstado.put(Constantes.getCteestado(), Constantes.getOk());
			
			mapCampoEstado.put(Constantes.getCtecodigorespuesta(),
					Constantes.getCte99());
			
			mapCampoEstado.put(Constantes.getCtemensajerespuesta(),
					Constantes.getMsjAvisoFinok());
			
			String totalRegistros =  (String) exchange.getIn().getHeader(Constantes.getTotalRegistrosConsultados());
			mapCampoEstado.put("totalRegistros",totalRegistros);
			mapCampoEstado.put("cantidadRegistrosRecividos",cantidadRegistros);
			Integer pag = Integer.parseInt( (String) exchange.getIn().getHeader(Constantes.getNroFilasH()));
			Integer intTotalPaginas = (int) Math.ceil(Double.parseDouble(totalRegistros) / Double.parseDouble(pag.toString()));
			mapCampoEstado.put("cantidadpaginas",intTotalPaginas);

			mapaRepuesta.put(Constantes.getCtedatosestado(), mapCampoEstado);
			mapaRepuesta.put(Constantes.getCtedatosrespuesta(), " ");
			//mapRegistro = new LinkedHashMap();

		} else {

			mapCampoEstado.put(Constantes.getCteestado(), Constantes.getOk());
			mapCampoEstado.put(Constantes.getCtecodigorespuesta(), Constantes.getCte0());

			String totalRegistros =  (String) exchange.getIn().getHeader(Constantes.getTotalRegistrosConsultados());
			mapCampoEstado.put("totalRegistros",totalRegistros);
			mapCampoEstado.put("cantidadRegistrosRecividos",cantidadRegistros);
			Integer pag = Integer.parseInt( (String) exchange.getIn().getHeader(Constantes.getNroFilasH()));
			Integer intTotalPaginas = (int) Math.ceil(Double.parseDouble(totalRegistros) / Double.parseDouble(pag.toString()));
			mapCampoEstado.put("cantidadpaginas",intTotalPaginas);
			
			mapCampoEstado.put(Constantes.getCtemensajerespuesta(), Constantes.getMsjAvisoFinok());

			for (int i = 0; i < cantidadRegistros; i++) {

				Map<String, Object> body = (HashMap) ((ArrayList<?>) exchange
						.getIn().getBody()).get(i);

				for (Entry<String, Object> miset : body.entrySet()) {
					mapCampo.put(miset.getKey(), miset.getValue());
				}

				listaArray.add(mapCampo);
				mapRegistro.put(Constantes.getCtecomprobantes(), listaArray);

			}

			mapaRepuesta.put(Constantes.getCtedatosestado(), mapCampoEstado);
			mapaRepuesta.put(Constantes.getCtedatosrespuesta(), mapRegistro);
			//mapRegistro = new LinkedHashMap();

		}
		exchange.getIn().setBody(mapaRepuesta);
		exchange.setOut(exchange.getIn());
	}
}
