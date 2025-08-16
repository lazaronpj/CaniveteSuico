package controller;

/**
 * Classe responsável pela lógica dos cálculos financeiros.
 * 
 * @author Lazaro Nogueira
 * @version 1.1
 * @since 2025-08-13
 */
public class LogicaFinanceira {

	/**
	 * Calcula o valor futuro em juros simples.
	 * 
	 * @param valorPresente
	 *            Valor presente
	 * @param taxaDeJuros
	 *            Taxa de juros (em decimal, ex: 0.05 para 5%...)
	 * @param tempo
	 *            Período de tempo
	 * @return Valor futuro calculado
	 */
	public static Double valorFuturoSimples(double valorPresente, double taxaDeJuros, double tempo) {
		return valorPresente * (1 + taxaDeJuros * tempo);
	}

	/**
	 * Calcula o valor futuro em juros compostos.
	 * 
	 * @param valorPresente
	 *            Valor presente
	 * @param taxaDeJuros
	 *            Taxa de juros (em decimal, ex: 0.05 para 5%)
	 * @param tempo
	 *            Período de tempo
	 * @return Valor futuro calculado
	 */
	public static Double valorFuturoComposto(double valorPresente, double taxaDeJuros, double tempo) {
		return valorPresente * Math.pow(1 + taxaDeJuros, tempo);
	}

	/**
	 * Calcula o valor presente em juros simples.
	 * 
	 * @param valorFuturo
	 *            Valor futuro
	 * @param taxaDeJuros
	 *            Taxa de juros
	 * @param tempo
	 *            Período de tempo
	 * @return Valor presente calculado ou retorna nulo caso haja entradas
	 *         inválidas
	 */
	public static Double valorPresenteSimples(double valorFuturo, double taxaDeJuros, double tempo) {
		if (taxaDeJuros == 0 || tempo == 0) {
			return null;
		} else {
			return valorFuturo / (1 + taxaDeJuros * tempo);
		}
	}

	/**
	 * Calcula o valor presente em juros compostos.
	 * 
	 * @param valorFuturo
	 *            Valor futuro
	 * @param taxaDeJuros
	 *            Taxa de juros
	 * @param tempo
	 *            Período de tempo
	 * @return Valor presente calculado ou retorna nulo caso haja entradas
	 *         inválidas
	 */
	public static Double valorPresenteComposto(double valorFuturo, double taxaDeJuros, double tempo) {
		if (taxaDeJuros <= -1 || tempo == 0) {
			return null;
		} else {
			return valorFuturo / Math.pow(1 + taxaDeJuros, tempo);
		}
	}

	/**
	 * Calcula o total de juros simples.
	 * 
	 * @param valorPresente
	 *            Valor presente
	 * @param taxaDeJuros
	 *            Taxa de juros
	 * @param tempo
	 *            Período de tempo
	 * @return Juros simples acumulados
	 */
	public static Double jurosSimples(double valorPresente, double taxaDeJuros, double tempo) {
		return valorPresente * taxaDeJuros * tempo;
	}

	/**
	 * Calcula o total de juros compostos.
	 * 
	 * @param valorPresente
	 *            Valor presente
	 * @param taxaDeJuros
	 *            Taxa de juros
	 * @param tempo
	 *            Período de tempo
	 * @return Juros compostos acumulados
	 */
	public static Double jurosCompostos(double valorPresente, double taxaDeJuros, double tempo) {
		return valorPresente * (Math.pow(1 + taxaDeJuros, tempo) - 1);
	}

	/**
	 * Calcula o tempo em juros simples.
	 * 
	 * @param valorPresente
	 *            Valor presente
	 * @param valorFuturo
	 *            Valor futuro
	 * @param taxaDeJuros
	 *            Taxa de juros
	 * @return Tempo calculado ou retorna nulo caso haja entradas inválidas
	 */
	public static Double tempoSimples(double valorPresente, double valorFuturo, double taxaDeJuros) {
		if (valorPresente == 0 || taxaDeJuros == 0) {
			return null;
		} else {
			return ((valorFuturo / valorPresente) - 1) / taxaDeJuros;
		}
	}

	/**
	 * Calcula o tempo em juros compostos.
	 * 
	 * @param valorPresente
	 *            Valor presente
	 * @param valorFuturo
	 *            Valor futuro
	 * @param taxaDeJuros
	 *            Taxa de juros
	 * @return Tempo calculado ou retorna nulo caso haja entradas inválidas
	 */
	public static Double tempoComposto(double valorPresente, double valorFuturo, double taxaDeJuros) {
		if (valorPresente == 0 || taxaDeJuros <= -1 || valorFuturo <= 0) {
			return null;
		} else {
			return Math.log(valorFuturo / valorPresente) / Math.log(1 + taxaDeJuros);
		}
	}

	/**
	 * Calcula a taxa em juros simples.
	 * 
	 * @param valorPresente
	 *            Valor presente
	 * @param valorFuturo
	 *            Valor futuro
	 * @param tempo
	 *            Período de tempo
	 * @return Taxa calculada ou retorna nulo caso haja entradas inválidas
	 */
	public static Double taxaSimples(double valorPresente, double valorFuturo, double tempo) {
		if (valorPresente == 0 || tempo == 0) {
			return null;
		} else {
			return ((valorFuturo / valorPresente) - 1) / tempo;
		}
	}

	/**
	 * Calcula a taxa em juros compostos.
	 * 
	 * @param valorPresente
	 *            Valor presente
	 * @param valorFuturo
	 *            Valor futuro
	 * @param tempo
	 *            Período de tempo
	 * @return Taxa calculada ou retorna nulo caso haja entradas inválidas
	 */
	public static Double taxaComposta(double valorPresente, double valorFuturo, double tempo) {
		if (valorPresente == 0 || tempo == 0) {
			return null;
		} else {
			return Math.pow(valorFuturo / valorPresente, 1.0 / tempo) - 1;
		}
	}

	/**
	 * Regra de três direta.
	 * 
	 * @param valor1
	 *            Primeira grandeza
	 * @param valor2
	 *            Segunda grandeza
	 * @param valor3
	 *            Terceira grandeza
	 * @return Resultado da regra de três direta ou retorna nulo caso haja
	 *         entradas inválidas
	 */
	public static Double regraDeTresDireta(double valor1, double valor2, double valor3) {
		if (valor1 == 0) {
			return null;
		} else {
			return (valor2 * valor3) / valor1;
		}
	}

	/**
	 * Regra de três inversa.
	 * 
	 * @param valor1
	 *            Primeira grandeza
	 * @param valor2
	 *            Segunda grandeza
	 * @param valor3
	 *            Terceira grandeza
	 * @return Resultado da regra de três inversa ou retorna nulo caso haja
	 *         entradas inválidas
	 */
	public static Double regraDeTresInversa(double valor1, double valor2, double valor3) {
		if (valor3 == 0) {
			return null;
		} else {
			return (valor1 * valor2) / valor3;
		}
	}
}