package controller;

/**
 * Classe responsável pela lógica do módulo de calculadora.
 *
 * @author Lazaro Nogueira
 * @version 1.1
 * @since 2025-08-13
 */

public class LogicaCalculadora {

	/**
	 * Realiza a soma de dois números.
	 * 
	 * @param numero1
	 *            Primeiro número responsável pelo cálculo,
	 * @param numero2
	 *            Segundo número responsável pelo cálculo.
	 * @return A soma de numero1 mais numero2.
	 */
	public static Double somar(double numero1, double numero2) {
		return numero1 + numero2;
	}

	/**
	 * Realiza a subtração de dois números.
	 * 
	 * @param numero1
	 *            Primeiro número responsável pelo cálculo,
	 * @param numero2
	 *            Segundo número responsável pelo cálculo.
	 * @return A subtração do numero1 menos o numero2.
	 */
	public static Double subtrair(double numero1, double numero2) {
		return numero1 - numero2;
	}

	/**
	 * Realiza a multiplicação de dois números.
	 * 
	 * @param numero1
	 *            Primeiro número responsável pelo cálculo,
	 * @param numero2
	 *            Segundo número responsável pelo cálculo.
	 * @return A multiplicação do numero1 vezes o numero2.
	 */
	public static Double multiplicar(double numero1, double numero2) {
		return numero1 * numero2;
	}

	/**
	 * Realiza a divisão de dois números.
	 * 
	 * @param numero1
	 *            Primeiro número responsável pelo cálculo,
	 * @param numero2
	 *            Segundo número responsável pelo cálculo.
	 * @return A divisão do numero1 pelo o numero2. Também verifica se o número2
	 *         é nulo.
	 */
	public static Double dividir(double numero1, double numero2) {
		if (numero2 == 0) {
			return null;
		}
		return numero1 / numero2;
	}

	/**
	 * Realiza o cálculo do resto da divisão entre dois números.
	 * 
	 * @param numero1
	 *            Primeiro número responsável pelo cálculo,
	 * @param numero2
	 *            Segundo número responsável pelo cálculo.
	 * @return O resto da divisão do numero1 pelo o numero2.
	 */
	public static Double restoDaDivisao(double numero1, double numero2) {
		return numero1 % numero2;
	}

	/**
	 * Realiza o cálculo da porcentagem entre dois números.
	 * 
	 * @param numero1
	 *            Primeiro número responsável pelo cálculo,
	 * @param percentual
	 *            se refere ao número responsável pelo cálculo da taxa.
	 * @return O numero1 vezes o percentual em parênteses, dividido por 100.
	 */
	public static Double porcentagem(double numero1, double percentual) {
		return (numero1 * percentual) / 100;
	}

	/**
	 * Realiza o cálculo da potenciação entre dois números.
	 * 
	 * @param numero1
	 *            Primeiro número responsável pelo cálculo,
	 * @param numero2
	 *            Segundo número responsável pelo cálculo.
	 * @return A potenciação utilizando a biblioteca Math.pow do numero1 elevado
	 *         ao numero2.
	 */
	public static Double potenciacao(double numero1, double numero2) {
		return Math.pow(numero1, numero2);
	}

	/**
	 * Realiza o cálculo do resto da radiciação.
	 * 
	 * @param numero1
	 *            Primeiro número responsável pelo cálculo,
	 * @return A raiz quadrada, utilizando a biblioteca Math.pow sobre o
	 *         numero1.
	 */
	public static Double radiciacao(double numero1) {
		return Math.sqrt(numero1);
	}

	/**
	 * Realiza o cálculo logarítmico.
	 * 
	 * @param numero1
	 *            Primeiro número responsável pelo cálculo,
	 * @return O número logarítmico, utilizando a biblioteca Math.log sobre o
	 *         numero1.
	 */
	public static Double logaritmico(double numero1) {
		return Math.log(numero1);
	}

	/**
	 * Realiza o cálculo exponencial.
	 * 
	 * @param numero1
	 *            Primeiro número responsável pelo cálculo,
	 * @return O número exponencial, utilizando a biblioteca Math.exp sobre o
	 *         numero1.
	 */
	public static Double exponencial(double numero1) {
		return Math.exp(numero1);
	}

}
