package ar.com.ecco.esb.procesos.solicitud;

import java.text.MessageFormat;

import javax.ws.rs.WebApplicationException;

import ar.com.ecco.esb.procesos.declaraciones.Constantes;
import ar.com.ecco.esb.procesos.primitiva.Comunes;

import org.apache.camel.CamelException;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.component.sql.SqlConstants;
import org.apache.log4j.Logger;

public class SolECCOComprobantes implements Processor {

	Logger logger = Logger.getLogger(getClass());

	public void process(Exchange exchange) throws CamelException {
		// SE VALIDA ERRORES
		String query = null;
		String nroCliente = null;
//		String entidadJuridica = null;
//		String unidadNegocio = null;
		String codigoBarra = null;
		String criterio = null;

		String strNroPagina = null;
		String strNroFilas = null;
		String tmp = null;


		strNroPagina = (String) exchange.getIn().getHeader(Constantes.getNroPagina());
		strNroFilas = (String) exchange.getIn().getHeader(Constantes.getNroFilas());

//		if ((strNroPagina != null) && (strNroFilas != null)
//				&& (Comunes.EsNumerico(strNroPagina))
//				&& (Comunes.EsNumerico(strNroFilas))) {
			
			
		if ((Comunes.contieneDato(strNroPagina)) &&
			(Comunes.contieneDato(strNroFilas)) &&
			(Comunes.esNumerico(strNroPagina)) &&
			(Comunes.esNumerico(strNroFilas))) {

			query = Constantes.getQuerySoleccocomprobantes();

			nroCliente = (String) exchange.getIn().getHeader(Constantes.getNroCliente());
			
			criterio  = "";
			criterio = Comunes.concatenaDato(criterio, "RM00101.CUSTNMBR = ''{0}'' ", nroCliente);

			
			// NO SE TIENE DEFINIDO LAS COLUMNAS DONDE OBTENER Y FILTRAR LOS
			// DATOS
			// entidadJuridica = (String) exchange.getIn().getHeader(
			// "entidadJuridica");
			// if (entidadJuridica != null) {
			// if (criterio != null) {
			// criterio += " AND ";
			// }
			// criterio += "RM00101.CUSTNMBR = ''{1}'' ";
			// }
			//
			// unidadNegocio = (String) exchange.getIn()
			// .getHeader("unidadNegocio");
			// if (unidadNegocio != null) {
			// if (criterio != null) {
			// criterio += " AND ";
			// }
			// criterio += "RM00101.CUSTNMBR = ''{2}'' ";
			// }
			// NO SE TIENE DEFINIDO LAS COLUMNAS DONDE OBTENER Y FILTRAR LOS
			// DATOS

			codigoBarra = (String) exchange.getIn().getHeader(Constantes.getCodigoBarra());
			
			tmp = Comunes.concatenaDato(Constantes.getAnd(), " RM00101.CUSTNMBR = ''{3}'' ", codigoBarra);
			criterio += Comunes.concatenaDato(criterio, tmp, tmp);
			
			query = Comunes.concatenaDato(query,  Constantes.getWhere(), criterio);
			query = Comunes.concatenaDato(query,  criterio, criterio);
			
			query = "select * from ("
					+ query
					+ ") tabla_1 where tabla_1.nroRegistro between ({4} * {5}) and (({4} + 1) * {5})";
			
			//query = MessageFormat.format(query, nroCliente, entidadJuridica, unidadNegocio, codigoBarra, strNroPagina, strNroFilas);
			query = MessageFormat.format(query, nroCliente, "",
					"", codigoBarra, strNroPagina, strNroFilas);

			logger.debug(Constantes.getApp() + Constantes.getSep()
					+ Constantes.getMetodoSoleccoporcodbarrahistorico()
					+ Constantes.getSep() + Constantes.getDetLog() + query);

			exchange.setProperty("CamelSqlQuery", query);

			exchange.setOut(exchange.getIn());
			exchange.getOut().setHeader(SqlConstants.SQL_QUERY, query);

		} else {
			exchange.getIn().setHeader(Constantes.getCodError(),
					Constantes.getStatuscodBadrequest());
			exchange.getIn().setHeader(Constantes.getDescError(),
					Constantes.getMsjErrorQueryparamPaginado());
			throw new WebApplicationException();

		}
		exchange.setOut(exchange.getIn());
		exchange.getOut().setHeader(SqlConstants.SQL_QUERY, query);

	}

}
