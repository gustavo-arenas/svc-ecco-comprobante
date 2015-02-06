package ar.com.ecco.esb.procesos.brms;

import java.util.ArrayList;

import org.apache.camel.Exchange;

public final class Regla1 {
	private Regla1() {
	}

	@SuppressWarnings("unchecked")
	public static String getDato(Exchange exchange, String dato) {

		String tmp = null;

		if (exchange.getProperty(dato) != null) {
			tmp = ((ArrayList<String>) exchange.getProperty(dato)).get(0);

		}
		return tmp;
	}

	public static boolean EsNumerico(String cadena) {

		try {
			Integer.parseInt(cadena);
			return true;
		} catch (NumberFormatException nfe) {
			return false;
		}
	}

}