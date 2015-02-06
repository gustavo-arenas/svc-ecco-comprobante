package ar.com.ecco.esb.procesos.solicitud;

import java.text.MessageFormat;

import org.apache.camel.CamelException;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.component.sql.SqlConstants;
import org.apache.log4j.Logger;

import ar.com.ecco.esb.procesos.declaraciones.Constantes;

public class SolECCOComprobantesCount implements Processor {

	Logger logger = Logger.getLogger(getClass());

	public void process(Exchange exchange) throws CamelException {
		// SE VALIDA ERRORES
		String query = null;
		String nroCliente = null;
//		String entidadJuridica = null;
//		String unidadNegocio = null;
		String codigoBarra = null;
		String criterio = null;



			query = Constantes.getQuerySoleccocomprobantescount();

			nroCliente = (String) exchange.getIn().getHeader(
					Constantes.getNroCliente());
			if ((nroCliente != null) && (!nroCliente.equals("")))  {
				criterio = "RM00101.CUSTNMBR = ''{0}'' ";
			}

			// NO SE TIENE DEFINIDO LAS COLUMNAS DONDE OBTENER Y FILTRAR LOS
			// DATOS
			// entidadJuridicaH = (String) exchange.getIn().getHeader(
			// "entidadJuridica");
			// if (entidadJuridicaH != null) {
			// if (criterio != null) {
			// criterio = " AND " + criterio;
			// }
			// criterio = "RM00101.CUSTNMBR = ''{1}'' ";
			// }
			//
			// unidadNegocioH = (String) exchange.getIn().getHeader(
			// "unidadNegocio");
			// if (unidadNegocioH != null) {
			// if (criterio != null) {
			// criterio = " AND " + criterio;
			// }
			// criterio = "RM00101.CUSTNMBR = ''{2}'' ";
			// }
			// NO SE TIENE DEFINIDO LAS COLUMNAS DONDE OBTENER Y FILTRAR LOS
			// DATOS

			codigoBarra = (String) exchange.getIn().getHeader(
					Constantes.getCodigoBarra());
			if ((codigoBarra != null) && (!codigoBarra.equals(""))) {
				if (criterio != null) {
					criterio = Constantes.getAnd() + criterio;
				}
				criterio = "RM00101.CUSTNMBR = ''{3}'' ";
			}

			if (criterio != null) {
				query = query + Constantes.getWhere() + criterio;
			}

			//query = MessageFormat.format(query, nroCliente, entidadJuridica, unidadNegocio, codigoBarra);
			query = MessageFormat.format(query, nroCliente, "", "", codigoBarra);

			logger.debug(Constantes.getApp() + Constantes.getSep()
					+ Constantes.getMetodoSoleccoporcodbarrahistorico()
					+ Constantes.getSep() + Constantes.getDetLog() + query);
			exchange.setProperty("CamelSqlQuery", query);

		exchange.setOut(exchange.getIn());
		exchange.getOut().setHeader(SqlConstants.SQL_QUERY, query);
		
	}

}
