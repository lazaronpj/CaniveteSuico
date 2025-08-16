package controller;

/**
 * Essa classe é responsável pela lógica da regra de três.
 * 
 * @author Lazaro Nogueira
 * @version 1.1
 * @since 2025-08-13
 */

public class LogicaRegraDeTres {

	/**
	 * Realiza o cálculo de regra de três diretamente proporcional.
	 * 
	 * @param a
	 *            responsável pela primeira grandeza.
	 * @param b
	 *            responsável pela segunda grandeza.
	 * @param c
	 *            responsével pela terceira grandeza.
	 * @return O valor do cálculo da regra de três direta.
	 */
	public static Double regraDeTresDireta(double a, double b, double c) {
		return (b * c) / a;
	}

	/**
	 * Realiza o cálculo de regra de três inversamente proporcional.
	 * 
	 * @param a
	 *            responsável pela primeira grandeza.
	 * @param b
	 *            responsável pela segunda grandeza.
	 * @param c
	 *            responsével pela terceira grandeza.
	 * @return O valor do cálculo da regra de três inversamente proporcional.
	 */
	public static Double regraDeTresInversa(double a, double b, double c) {
		return (a * b) / c;
	}

}
