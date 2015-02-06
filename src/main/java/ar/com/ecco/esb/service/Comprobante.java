package ar.com.ecco.esb.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.apache.camel.CamelException;

@Path(value = "/")
public interface Comprobante {

	// URL Nro.1
	// LISTA COMPROBANTES
	@GET
	@Produces(value = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Path("")
	Object eccoComprobantes(
			@QueryParam("codigoBarra") String codigoBarra,
			@QueryParam("entidadJuridica") String entidadJuridica,
			@QueryParam("unidadNegocio") String unidadNegocio,
			@QueryParam("nroCliente") String nroCliente,
			@QueryParam("nroPagina") String nroPagina,
			@QueryParam("nroFilas") String nroFilas
			) throws CamelException;

	// URL Nro.2
	// LISTA COMPROBANTES HISTORICO
	@GET
	@Produces(value = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Path("/historicos")
	Object eccoComprobantesHistorico(
			@QueryParam("codigoBarraH") String codigoBarraH,
			@QueryParam("entidadJuridicaH") String entidadJuridicaH,
			@QueryParam("unidadNegocioH") String unidadNegocioH,
			@QueryParam("nroClienteH") String nroClienteH,
			@QueryParam("nroPaginaH") String nroPaginaH,
			@QueryParam("nroFilasH") String nroFilasH
			) throws CamelException;

	// URL Nro.3
	// COMPROBANTE
	//http://192.168.108.108:9292/ecco/api/comprobante/FC%20A0001-00000002
	@GET
	// @Produces(value = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces(value = { MediaType.APPLICATION_JSON })
	@Path("/{comprobante}")
	Object eccoPorComprobante(@PathParam("comprobante") String comprobante)
			throws CamelException;

	// URL Nro.4
	// COMPROBANTE HISTORICO
	//http://192.168.108.108:9292/ecco/api/comprobante/historico/FC%20A0001-00000007
	@GET
	//@Produces(value = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces(value = { MediaType.APPLICATION_JSON })
	@Path("/historicos/{comprobante-historico}")
	Object eccoPorComprobanteHistorico(
			@PathParam("comprobante-historico") String comprobanteHistorico)
			throws CamelException;
}