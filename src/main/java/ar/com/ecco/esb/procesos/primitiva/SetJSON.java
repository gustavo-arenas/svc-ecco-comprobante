package ar.com.ecco.esb.procesos.primitiva;

import java.io.IOException;

import org.apache.camel.CamelException;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class SetJSON implements Processor {

	@Override
	public void process(Exchange exchange) throws CamelException, IOException {

		// LinkedHashMap mapaLocalidades = new LinkedHashMap();
		// LinkedHashMap mapPK = new LinkedHashMap();
		// ArrayList listaArray = new ArrayList();
		// LinkedHashMap mapaID = new LinkedHashMap();
		//
		// Integer cantidadReg = Integer.parseInt(exchange.getIn()
		// .getHeader(Constantes.getCamelSqlRowCount()).toString());
		//
		// for (int i = 0; i < cantidadReg; i++) {
		//
		// Map<String, Object> body = (HashMap) ((ArrayList<?>) exchange
		// .getIn().getBody()).get(i);
		// boolean paso = true;
		// for (Entry<String, Object> miset : body.entrySet()) {
		//
		// if (paso) {
		// mapaID.put(miset.getKey(), miset.getValue());
		// // mapaID.put(miset.getKey().toString(), miset.getValue());
		//
		// mapPK.put(Constantes.getPk(), mapaID);
		// paso = false;
		// } else {
		// mapPK.put(miset.getKey(), miset.getValue());
		// // mapPK.put(miset.getKey().toString(), miset.getValue());
		// }
		// }
		//
		// listaArray.add(mapPK);
		// mapPK = new LinkedHashMap();
		// mapaID = new LinkedHashMap();
		// }
		//
		// mapaLocalidades.put(Constantes.getLocalidades(), listaArray);
		//
		// String s = JSONValue.toJSONString(mapaLocalidades);
		//
		// exchange.getIn().setBody(s);
		// exchange.setOut(exchange.getIn());

	}
}
