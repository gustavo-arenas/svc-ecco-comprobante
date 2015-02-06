package ar.com.ecco.esb.procesos.solicitud;

import java.text.MessageFormat;

import org.apache.camel.CamelException;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.component.sql.SqlConstants;
import org.apache.log4j.Logger;

import ar.com.ecco.esb.procesos.declaraciones.Constantes;

public class SolECCOComprobantesHistoricoCount implements Processor {

	Logger logger = Logger.getLogger(getClass());

	public void process(Exchange exchange) throws CamelException {
		// SE VALIDA ERRORES
		String query = null;
		String nroClienteH = null;
//		String entidadJuridicaH = null;
//		String unidadNegocioH = null;
		String codigoBarraH = null;
		String criterio = null;



			query = Constantes.getQuerySoleccocomprobanteshistoricocount();

			nroClienteH = (String) exchange.getIn().getHeader(
					Constantes.getNroClienteH());
			if ((nroClienteH != null) && (!nroClienteH.equals(""))) {
				criterio = "RM00101.CUSTNMBR = ''{0}'' ";
			}

			// NO SE TIENE DEFINIDO LAS COLUMNAS DONDE OBTENER Y FILTRAR LOS
			// DATOS
			// entidadJuridicaH = (String) exchange.getIn().getHeader(
			// "entidadJuridicaH");
			// if (entidadJuridicaH != null) {
			// if (criterio != null) {
			// criterio = " AND " + criterio;
			// }
			// criterio = "RM00101.CUSTNMBR = ''{1}'' ";
			// }
			//
			// unidadNegocioH = (String) exchange.getIn().getHeader(
			// "unidadNegocioH");
			// if (unidadNegocioH != null) {
			// if (criterio != null) {
			// criterio = " AND " + criterio;
			// }
			// criterio = "RM00101.CUSTNMBR = ''{2}'' ";
			// }
			// NO SE TIENE DEFINIDO LAS COLUMNAS DONDE OBTENER Y FILTRAR LOS
			// DATOS

			codigoBarraH = (String) exchange.getIn().getHeader(
					Constantes.getCodigoBarraH());
			if ((codigoBarraH != null) && (!codigoBarraH.equals(""))) {
				if (criterio != null) {
					criterio = Constantes.getAnd() + criterio;
				}
				criterio = "RM00101.CUSTNMBR = ''{3}'' ";
			}

			if (criterio != null) {
				query = query + Constantes.getWhere() + criterio;
			}

			//query = MessageFormat.format(query, nroClienteH, entidadJuridicaH, unidadNegocioH, codigoBarraH);
			query = MessageFormat.format(query, nroClienteH, "", "", codigoBarraH);

			logger.debug(Constantes.getApp() + Constantes.getSep()
					+ Constantes.getMetodoSoleccoporcodbarrahistorico()
					+ Constantes.getSep() + Constantes.getDetLog() + query);
			exchange.setProperty("CamelSqlQuery", query);

		exchange.setOut(exchange.getIn());
		exchange.getOut().setHeader(SqlConstants.SQL_QUERY, query);
		
	}

}
