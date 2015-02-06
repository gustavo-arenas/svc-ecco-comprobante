package ar.com.ecco.esb.procesos.primitiva;

import java.util.ArrayList;

import org.apache.camel.Exchange;

public final class Comunes {
	private Comunes() {
	}

	@SuppressWarnings("unchecked")
	public static String getDato(Exchange exchange, String dato) {

		String tmp = null;

		if (exchange.getProperty(dato) != null) {
			tmp = ((ArrayList<String>) exchange.getProperty(dato)).get(0);

		}
		return tmp;
	}

	public static boolean esNumerico(String cadena) {

		try {
			Integer.parseInt(cadena);
			return true;
		} catch (NumberFormatException nfe) {
			return false;
		}
	}

	public static boolean contieneDato(String cadena) {

		String strCadena = cadena.trim();
		boolean strRta = false;

		if (!strCadena.equals("")) {
			strRta = true;
		}
		return strRta;
	}

	public static String concatenaDato(String cadena1, String cadena2,
			String condicionTrue) {

		try {
			if ((condicionTrue != null) && (!condicionTrue.trim().equals(""))) {
				return cadena1 + cadena2;
			} else {
				return "";
			}

		} catch (NumberFormatException nfe) {
			return "";
		}

	}
}