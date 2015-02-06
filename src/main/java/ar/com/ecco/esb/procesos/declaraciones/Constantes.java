package ar.com.ecco.esb.procesos.declaraciones;

public final class Constantes {
	private Constantes() {
	}

	private static final String APP = "ECCO";
	private static final String DET_APP = "Comprobonte de pago: ";
	private static final String SEP = " - ";
	private static final String DET_LOG = "Fin de proceso - OK";
	private static final String DET_LOG_ERR = "Fin de proceso - NoOK";
	private static final String OK = "OK";
	private static final String NO_OK = "No OK";

	private static final String CODIF_ERROR = "codifError";
	private static final String ESTADO_ERROR = "EstadoError";
	private static final String COD_ERROR = "CodError";
	private static final String DESC_ERROR = "DescError";
	
	private static final String CAMEL_SQL_ROW_COUNT = "CamelSqlRowCount";
	private static final String CANTIDAD_REGISTRO = "cantidadRegistros"; 
	
	private static final String WHERE = " WHERE ";
	private static final String AND = " AND ";
	
	private static final String NRO_PAGINA = "nroPagina";
	private static final String NRO_FILAS = "nroFilas";
	private static final String NRO_CLIENTE = "nroCliente";
	private static final String CODIGO_BARRA = "codigoBarra";

	private static final String NRO_PAGINA_H = "nroPaginaH";
	private static final String NRO_FILAS_H = "nroFilasH";
	private static final String NRO_CLIENTE_H = "nroClienteH";
	private static final String CODIGO_BARRA_H = "codigoBarraH";	
	
	private static final String COMPROBANTE = "comprobante";
	private static final String CTECOMPROBANTES = "comprobantes";
	private static final String CTEESTADO = "estado";
	private static final String CTECODIGORESPUESTA = "codigorespuesta";
	private static final String CTEMENSAJERESPUESTA = "mensajerespuesta";
	private static final String CTEDATOSESTADO = "datosestado";
	private static final String CTEDATOSRESPUESTA = "datosrespuesta";
	private static final String CTE0 = "0";
	private static final String CTE1 = "1";
	private static final String CTE99 = "99";
	private static final String TOTAL_REGISTROS_CONSULTADOS = "totalregistrosconsultados";
	
	// DESCRIPCIONES DE MENSAJES
	private static final String MSJ_ERROR_QUERYPARAM_PAGINADO = "Error en queryparam, nroPaginaH y nroFilasH son requerido";
	private static final String MSJ_AVISO_FINOK = "Finalizo srv-ecco-comprobante";	
	
	//CONSULTAS SQL DE METODOS
	private static final String METODO_SOLECCOPORCODBARRA = "";
	private static final String METODO_SOLECCOPORCODBARRAHISTORICO = "";
	private static final String METODO_SOLECCOPORCOMPROBANTE = "";
	private static final String METODO_SOLECCOPORCOMPROBANTEHISTORICO = "";

	private static final String METODO_TOMADATOSBODY = "Toma Datos BODY";
	private static final String METODO_TOMADATOSHTTP = "Toma Datos HTTP";

	// CLIENT ERROR
	private static final String STATUSCOD_BADREQUEST = "400";
	private static final String STATUSCOD_UNAUTHORIZED = "401";
	private static final String STATUSCOD_PAYMENTREQUIRED = "402";
	private static final String STATUSCOD_FORBIDDEN = "403";
	private static final String STATUSCOD_NOTFOUND = "404";
	private static final String STATUSCOD_METHODNOTALLOWED = "405";
	private static final String STATUSCOD_NOTACCEPTABLE = "406";
	private static final String STATUSCOD_REQUESTTIMEOUT = "408";
	private static final String STATUSCOD_CONFLICT = "409";
	private static final String STATUSCOD_GONE = "410";
	private static final String STATUSCOD_LENGTHREQUIRED = "411";
	private static final String STATUSCOD_PRECONDITIONFAILED = "412";
	private static final String STATUSCOD_REQUESTENTITYTOOLARGE = "413";
	private static final String STATUSCOD_REQUESTURITOOLONG = "414";
	private static final String STATUSCOD_UNSUPPORTEDMEDIATYPE = "415";
	private static final String STATUSCOD_REQUESTEDRANGENOTSATISFIABLE = "416";
	private static final String STATUSCOD_EXPECTATIONFAILED = "417";
	private static final String STATUSCOD_LOCKED = "423";

	// SUCCESS
	private static final String STATUSCOD_OK = "200";
	private static final String STATUSCOD_CREATED = "201";
	private static final String STATUSCOD_ACCEPTED = "202";
	private static final String STATUSCOD_NON_AUTHORITATIVEINFORMATION = "203";
	private static final String STATUSCOD_NOCONTENT = "204";
	private static final String STATUSCOD_RESETCONTENT = "205";
	private static final String STATUSCOD_PARTIALCONTENT = "206";
	private static final String STATUSCOD_IMUSED = "226";

//CONSULTAS SQL
	private static final String QUERY_SOLECCOPORCOMPROBANTE = "select  "
			+ "''ECCO(3)'' as entidad_negocio,  "
			+ "''73'' as origen,  "
			+ "''ECCO'' as emisor,  "
			+ "RM20101.DOCNUMBR as comprobante,  "
			+ "RM00101.COMMENT1 as cliente_tipo,  "
			+ "null as entidad,  "
			+ "RM00101.CUSTNMBR as cliente,  "
			+ "RM00101.CUSTNAME as razon_soc,  "
			+ "RM20101.CURNCYID as moneda,  "
			+ "RM20101.DUEDATE as pri_vto,  "
			+ "RM20101.ORTRXAMT as pri_importe,  "
			+ "''campo no definido'' as pri_minimo,  "
			+ "''campo no definido'' as seg_vto,  "
			+ "''campo no definido'' as seg_importe,  "
			+ "''campo no definido'' as seg_minimo,  "
			+ "''campo no definido'' as ter_importe,  "
			+ "''campo no definido'' as ter_minimo,  "
			+ "RM20101.DOCDATE as emision_fecha,  " 
			+ "RM20101.GLPOSTDT as periodo,  "
			+ "0 as tipo_proceso,  "
			+ "''campo no definido'' as alta_fecha,  "
			+ "''campo no definido'' as modi_fecha,  "
			+ "''campo no definido'' as baja_fecha,  "
			+ "AW_T_REPFACT_CABECERA.COD_BARRAS as codigo_barra,  "
			+ "''campo no definido'' as lote,  "
			+ "''Ecco SA.nro de cuitas'' as entidad_juridica,  "
			+ "RM20101.CURTRXAM as saldo  "
			+ "from RM20101	 "
			+ "inner join AW_T_REPFACT_CABECERA on RM20101.DOCNUMBR = AW_T_REPFACT_CABECERA.SOPNUMBE  "
			+ "inner join RM00101 on RM20101.CUSTNMBR = RM00101.CUSTNMBR  "
			+ "where RM20101.DOCNUMBR = ''{0}'' ";

	private static final String QUERY_SOLECCOPORCOMPROBANTEHISTORICO = "select ''ECCO(3)'' as entidad_negocio, "
			+ "''73'' as origen, "
			+ "''ECCO'' as emisor, RM30101.DOCNUMBR as comprobante, "
			+ "RM00101.COMMENT1 as cliente_tipo, "
			+ "null as entidad, "
			+ "RM00101.CUSTNMBR as cliente, "
			+ "RM00101.CUSTNAME as razon_soc, "
			+ "RM30101.CURNCYID as moneda, "
			+ "RM30101.DUEDATE as pri_vto, "
			+ "RM30101.ORTRXAMT as pri_importe, "
			+ "''campo no definido'' as pri_minimo, "
			+ "''campo no definido'' as seg_vto, "
			+ "''campo no definido'' as seg_importe, "
			+ "''campo no definido'' as seg_minimo, "
			+ "''campo no definido'' as ter_importe, "
			+ "''campo no definido'' as ter_minimo, "
			+ "RM30101.DOCDATE as emision_fecha, "
			+ "RM30101.GLPOSTDT as periodo, "
			+ "0 as tipo_proceso, "
			+ "''campo no definido'' as alta_fecha, "
			+ "''campo no definido'' as modi_fecha, "
			+ "''campo no definido'' as baja_fecha, "
			+ "AW_T_REPFACT_CABECERA.COD_BARRAS as codigo_barra, "
			+ "''campo no definido'' as lote, "
			+ "''Ecco SA.nro de cuitas'' as entidad_juridica, "
			+ "RM30101.CURTRXAM as saldo "
			+ "from RM30101	"
			+ "inner join AW_T_REPFACT_CABECERA on RM30101.DOCNUMBR = AW_T_REPFACT_CABECERA.SOPNUMBE "
			+ "inner join RM00101 on RM30101.CUSTNMBR = RM00101.CUSTNMBR "
			+ "where RM30101.DOCNUMBR = ''{0}''";
	
	private static final String QUERY_SOLECCOCOMPROBANTESCOUNT = "select COUNT(1) as CantidadComprobantes "
			+ "from RM20101	"
			+ "inner join AW_T_REPFACT_CABECERA on RM20101.DOCNUMBR = AW_T_REPFACT_CABECERA.SOPNUMBE "
			+ "inner join RM00101 on RM20101.CUSTNMBR = RM00101.CUSTNMBR";
	
	private static final String QUERY_SOLECCOCOMPROBANTES = "select "
			+ "ROW_NUMBER() Over (Order by RM20101.DOCNUMBR) As nroRegistro, "
			+ "''ECCO(3)'' as entidad_negocio, "
			+ "''73'' as origen, "
			+ "''ECCO'' as emisor, "
			+ "RM20101.DOCNUMBR as comprobante, "
			+ "RM00101.COMMENT1 as cliente_tipo, "
			+ "null as entidad, "
			+ "RM00101.CUSTNMBR as cliente, "
			+ "RM00101.CUSTNAME as razon_soc, "
			+ "RM20101.CURNCYID as moneda, "
			+ "RM20101.DUEDATE as pri_vto, "
			+ "RM20101.ORTRXAMT as pri_importe, "
			+ "''campo no definido'' as pri_minimo, "
			+ "''campo no definido'' as seg_vto, "
			+ "''campo no definido'' as seg_importe, "
			+ "''campo no definido'' as seg_minimo, "
			+ "''campo no definido'' as ter_importe, "
			+ "''campo no definido'' as ter_minimo, "
			+ "RM20101.DOCDATE as emision_fecha, "
			+ "RM20101.GLPOSTDT as periodo, "
			+ "0 as tipo_proceso, "
			+ "''campo no definido'' as alta_fecha, "
			+ "''campo no definido'' as modi_fecha, "
			+ "''campo no definido'' as baja_fecha, "
			+ "AW_T_REPFACT_CABECERA.COD_BARRAS as codigo_barra, "
			+ "''campo no definido'' as lote, "
			+ "''Ecco SA.nro de cuitas'' as entidad_juridica, "
			+ "RM20101.CURTRXAM as saldo "
			+ "from RM20101	"
			+ "inner join AW_T_REPFACT_CABECERA on RM20101.DOCNUMBR = AW_T_REPFACT_CABECERA.SOPNUMBE "
			+ "inner join RM00101 on RM20101.CUSTNMBR = RM00101.CUSTNMBR";

	private static final String QUERY_SOLECCOCOMPROBANTESHISTORICOCOUNT = "select "
			+ "COUNT(1) as CantidadComprobantes "
			+ "from RM30101	"
			+ "inner join AW_T_REPFACT_CABECERA on RM30101.DOCNUMBR = AW_T_REPFACT_CABECERA.SOPNUMBE "
			+ "inner join RM00101 on RM30101.CUSTNMBR = RM00101.CUSTNMBR";
	
	private static final String QUERY_SOLECCOCOMPROBANTESHISTORICO = "select "
			+ "ROW_NUMBER() Over (Order by RM30101.DOCNUMBR) As nroRegistro, "
			+ "''ECCO(3)'' as entidad_negocio, "
			+ "''73'' as origen, "
			+ "''ECCO'' as emisor, "
			+ "RM30101.DOCNUMBR as comprobante, "
			+ "RM00101.COMMENT1 as cliente_tipo,	"
			+ "null as entidad, "
			+ "RM00101.CUSTNMBR as cliente, "
			+ "RM00101.CUSTNAME as razon_soc, "
			+ "RM30101.CURNCYID as moneda, "
			+ "RM30101.DUEDATE as pri_vto, "
			+ "RM30101.ORTRXAMT as pri_importe, "
			+ "''campo no definido'' as pri_minimo, "
			+ "''campo no definido'' as seg_vto, "
			+ "''campo no definido'' as seg_importe, "
			+ "''campo no definido'' as seg_minimo, "
			+ "''campo no definido'' as ter_importe, "
			+ "''campo no definido'' as ter_minimo, "
			+ "RM30101.DOCDATE as emision_fecha, "
			+ "RM30101.GLPOSTDT as periodo, "
			+ "0 as tipo_proceso, "
			+ "''campo no definido'' as alta_fecha, "
			+ "''campo no definido'' as modi_fecha, "
			+ "''campo no definido'' as baja_fecha, "
			+ "AW_T_REPFACT_CABECERA.COD_BARRAS as codigo_barra, "
			+ "''campo no definido'' as lote, "
			+ "''Ecco SA.nro de cuitas'' as entidad_juridica, "
			+ "RM30101.CURTRXAM as saldo "
			+ "from RM30101	"
			+ "inner join AW_T_REPFACT_CABECERA on RM30101.DOCNUMBR = AW_T_REPFACT_CABECERA.SOPNUMBE "
			+ "inner join RM00101 on RM30101.CUSTNMBR = RM00101.CUSTNMBR";

	// ////////////////////////////////////////////////////////////////////////

	public static String getApp() {
		return APP;
	}

	public static String getDetApp() {
		return DET_APP;
	}

	public static String getSep() {
		return SEP;
	}

	public static String getDetLog() {
		return DET_LOG;
	}

	public static String getDetLogErr() {
		return DET_LOG_ERR;
	}

	public static String getOk() {
		return OK;
	}

	public static String getNoOk() {
		return NO_OK;
	}

	public static String getCodifError() {
		return CODIF_ERROR;
	}

	public static String getEstadoError() {
		return ESTADO_ERROR;
	}

	public static String getDescError() {
		return DESC_ERROR;
	}

	public static String getMetodoTomadatosbody() {
		return METODO_TOMADATOSBODY;
	}

	public static String getCamelSqlRowCount() {
		return CAMEL_SQL_ROW_COUNT;
	}

	public static String getMetodoTomadatoshttp() {
		return METODO_TOMADATOSHTTP;
	}

	public static String getMetodoSoleccoporcodbarra() {
		return METODO_SOLECCOPORCODBARRA;
	}

	public static String getMetodoSoleccoporcodbarrahistorico() {
		return METODO_SOLECCOPORCODBARRAHISTORICO;
	}

	public static String getMetodoSoleccoporcomprobante() {
		return METODO_SOLECCOPORCOMPROBANTE;
	}

	public static String getMetodoSoleccoporcomprobantehistorico() {
		return METODO_SOLECCOPORCOMPROBANTEHISTORICO;
	}

	public static String getComprobante() {
		return COMPROBANTE;
	}

	public static String getQuerySoleccoporcomprobante() {
		return QUERY_SOLECCOPORCOMPROBANTE;
	}

	public static String getQuerySoleccoporcomprobantehistorico() {
		return QUERY_SOLECCOPORCOMPROBANTEHISTORICO;
	}

	public static String getQuerySoleccocomprobantes() {
		return QUERY_SOLECCOCOMPROBANTES;
	}

	public static String getQuerySoleccocomprobanteshistorico() {
		return QUERY_SOLECCOCOMPROBANTESHISTORICO;
	}

	public static String getStatuscodNonAuthoritativeinformation() {
		return STATUSCOD_NON_AUTHORITATIVEINFORMATION;
	}

	public static String getStatuscodBadrequest() {
		return STATUSCOD_BADREQUEST;
	}

	public static String getStatuscodForbidden() {
		return STATUSCOD_FORBIDDEN;
	}

	public static String getStatuscodUnauthorized() {
		return STATUSCOD_UNAUTHORIZED;
	}

	public static String getStatuscodPaymentrequired() {
		return STATUSCOD_PAYMENTREQUIRED;
	}

	public static String getStatuscodNotfound() {
		return STATUSCOD_NOTFOUND;
	}

	public static String getStatuscodMethodnotallowed() {
		return STATUSCOD_METHODNOTALLOWED;
	}

	public static String getStatuscodNotacceptable() {
		return STATUSCOD_NOTACCEPTABLE;
	}

	public static String getStatuscodConflict() {
		return STATUSCOD_CONFLICT;
	}

	public static String getStatuscodRequesttimeout() {
		return STATUSCOD_REQUESTTIMEOUT;
	}

	public static String getStatuscodGone() {
		return STATUSCOD_GONE;
	}

	public static String getStatuscodLengthrequired() {
		return STATUSCOD_LENGTHREQUIRED;
	}

	public static String getStatuscodPreconditionfailed() {
		return STATUSCOD_PRECONDITIONFAILED;
	}

	public static String getStatuscodRequestentitytoolarge() {
		return STATUSCOD_REQUESTENTITYTOOLARGE;
	}

	public static String getStatuscodRequesturitoolong() {
		return STATUSCOD_REQUESTURITOOLONG;
	}

	public static String getStatuscodUnsupportedmediatype() {
		return STATUSCOD_UNSUPPORTEDMEDIATYPE;
	}

	public static String getStatuscodRequestedrangenotsatisfiable() {
		return STATUSCOD_REQUESTEDRANGENOTSATISFIABLE;
	}

	public static String getStatuscodLocked() {
		return STATUSCOD_LOCKED;
	}

	public static String getStatuscodExpectationfailed() {
		return STATUSCOD_EXPECTATIONFAILED;
	}

	public static String getStatuscodOk() {
		return STATUSCOD_OK;
	}

	public static String getStatuscodCreated() {
		return STATUSCOD_CREATED;
	}

	public static String getStatuscodAccepted() {
		return STATUSCOD_ACCEPTED;
	}

	public static String getStatuscodNocontent() {
		return STATUSCOD_NOCONTENT;
	}

	public static String getStatuscodResetcontent() {
		return STATUSCOD_RESETCONTENT;
	}

	public static String getStatuscodPartialcontent() {
		return STATUSCOD_PARTIALCONTENT;
	}

	public static String getStatuscodImused() {
		return STATUSCOD_IMUSED;
	}

	public static String getMsjErrorQueryparamPaginado() {
		return MSJ_ERROR_QUERYPARAM_PAGINADO;
	}

	public static String getCodError() {
		return COD_ERROR;
	}

	public static String getNroPagina() {
		return NRO_PAGINA;
	}

	public static String getNroFilas() {
		return NRO_FILAS;
	}

	public static String getNroCliente() {
		return NRO_CLIENTE;
	}

	public static String getCodigoBarra() {
		return CODIGO_BARRA;
	}

	public static String getWhere() {
		return WHERE;
	}

	public static String getAnd() {
		return AND;
	}

	public static String getNroPaginaH() {
		return NRO_PAGINA_H;
	}

	public static String getNroFilasH() {
		return NRO_FILAS_H;
	}

	public static String getNroClienteH() {
		return NRO_CLIENTE_H;
	}

	public static String getCodigoBarraH() {
		return CODIGO_BARRA_H;
	}

	public static String getCteestado() {
		return CTEESTADO;
	}

	public static String getCtecodigorespuesta() {
		return CTECODIGORESPUESTA;
	}

	public static String getCtemensajerespuesta() {
		return CTEMENSAJERESPUESTA;
	}

	public static String getCtedatosestado() {
		return CTEDATOSESTADO;
	}

	public static String getCtedatosrespuesta() {
		return CTEDATOSRESPUESTA;
	}

	public static String getCte0() {
		return CTE0;
	}

	public static String getCte1() {
		return CTE1;
	}

	public static String getCte99() {
		return CTE99;
	}

	public static String getMsjAvisoFinok() {
		return MSJ_AVISO_FINOK;
	}

	public static String getCtecomprobantes() {
		return CTECOMPROBANTES;
	}

	public static String getQuerySoleccocomprobantescount() {
		return QUERY_SOLECCOCOMPROBANTESCOUNT;
	}

	public static String getQuerySoleccocomprobanteshistoricocount() {
		return QUERY_SOLECCOCOMPROBANTESHISTORICOCOUNT;
	}

	public static String getCantidadRegistro() {
		return CANTIDAD_REGISTRO;
	}

	public static String getTotalRegistrosConsultados() {
		return TOTAL_REGISTROS_CONSULTADOS;
	}

}