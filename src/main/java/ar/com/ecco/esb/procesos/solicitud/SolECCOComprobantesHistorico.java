package ar.com.ecco.esb.procesos.solicitud;

import java.text.MessageFormat;

import javax.ws.rs.WebApplicationException;

import ar.com.ecco.esb.procesos.declaraciones.*;
import ar.com.ecco.esb.procesos.primitiva.Comunes;

import org.apache.camel.CamelException;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.component.sql.SqlConstants;
import org.apache.log4j.Logger;

public class SolECCOComprobantesHistorico implements Processor {

	Logger logger = Logger.getLogger(getClass());

	public void process(Exchange exchange) throws CamelException {
		// SE VALIDA ERRORES
		String query = null;
		String nroClienteH = null;
//		String entidadJuridicaH = null;
//		String unidadNegocioH = null;
		String codigoBarraH = null;
		String criterio = null;
		String strNroPaginaH = null;
		String strNroFilasH = null;

		// int nroPagina = 0;
		// int nroFilas = 0;

		strNroPaginaH = (String) exchange.getIn().getHeader(
				Constantes.getNroPaginaH());
		strNroFilasH = (String) exchange.getIn().getHeader(
				Constantes.getNroFilasH());

		if ((strNroPaginaH != null) && (strNroFilasH != null)
				&& (Comunes.esNumerico(strNroPaginaH))
				&& (Comunes.esNumerico(strNroFilasH))) {

			query = Constantes.getQuerySoleccocomprobanteshistorico();

			nroClienteH = (String) exchange.getIn().getHeader(
					Constantes.getNroClienteH());
			if (nroClienteH != null) {
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

			query = "select * from ("
					+ query
					+ ") tabla_1 where tabla_1.nroRegistro between ({4} * {5}) and (({4} + 1) * {5})";

			//query = MessageFormat.format(query, nroClienteH, entidadJuridicaH, unidadNegocioH, codigoBarraH, strNroPaginaH, strNroFilasH);
			query = MessageFormat.format(query, nroClienteH, "", "", codigoBarraH, strNroPaginaH, strNroFilasH);
			
			logger.debug(Constantes.getApp() + Constantes.getSep()
					+ Constantes.getMetodoSoleccoporcodbarrahistorico()
					+ Constantes.getSep() + Constantes.getDetLog() + query);
			exchange.setProperty("CamelSqlQuery", query);
			// valida errores
		} else {
			exchange.getIn().setHeader(Constantes.getCodError(),
					Constantes.getStatuscodBadrequest());
			exchange.getIn().setHeader(Constantes.getDescError(),
					Constantes.getMsjErrorQueryparamPaginado());
			throw new WebApplicationException();
			// valida errores
		}
		exchange.setOut(exchange.getIn());
		exchange.getOut().setHeader(SqlConstants.SQL_QUERY, query);

	}

}
