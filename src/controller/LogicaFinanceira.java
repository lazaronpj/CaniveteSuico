package controller;

import javax.swing.JOptionPane;

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
	public Double valorFuturoSimples(double valorPresente, double taxaDeJuros, double tempo) {
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
	public Double valorFuturoComposto(double valorPresente, double taxaDeJuros, double tempo) {
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
	 * @return Valor presente calculado ou retorna nulo caso haja entradas inválidas
	 */
	public Double valorPresenteSimples(double valorFuturo, double taxaDeJuros, double tempo) {
		if (taxaDeJuros == 0 || tempo == 0) {
			JOptionPane.showMessageDialog(null, "O valor da taxa de juros e o tempo não podem ser menor ou igual a 0!", "Aviso",
					JOptionPane.WARNING_MESSAGE);
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
	 * @return Valor presente calculado ou retorna nulo caso haja entradas inválidas
	 */
	public Double valorPresenteComposto(double valorFuturo, double taxaDeJuros, double tempo) {
		if (taxaDeJuros <= 0 || tempo <= 0) {
			JOptionPane.showMessageDialog(null, "A taxa de juros e o tempo não podem ser menor ou igual a 0!", "Aviso",
					JOptionPane.WARNING_MESSAGE);
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
	public Double jurosSimples(double valorPresente, double taxaDeJuros, double tempo) {
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
	public Double jurosCompostos(double valorPresente, double taxaDeJuros, double tempo) {
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
	public Double tempoSimples(double valorPresente, double valorFuturo, double taxaDeJuros) {
		if (valorPresente <= 0 || taxaDeJuros <= 0) {
			JOptionPane.showMessageDialog(null, "O valor presente e a taxa de juros não podem ser menor ou igual a 0!", "Aviso",
					JOptionPane.WARNING_MESSAGE);
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
	public Double tempoComposto(double valorPresente, double valorFuturo, double taxaDeJuros) {
		if (valorPresente <= 0 || taxaDeJuros <= 0 || valorFuturo <= 0) {
			JOptionPane.showMessageDialog(null, "O valor presente, da taxa de juros e o valor futuro não podem ser menor ou igual a 0!",
					"Aviso", JOptionPane.WARNING_MESSAGE);
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
	public Double taxaSimples(double valorPresente, double valorFuturo, double tempo) {
		if (valorPresente <= 0 || tempo <= 0) {
			JOptionPane.showMessageDialog(null, "O valor presente e o tempo não podem ser menor ou igual a 0!", "Aviso",
					JOptionPane.WARNING_MESSAGE);
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
	public Double taxaComposta(double valorPresente, double valorFuturo, double tempo) {
		if (valorPresente <= 0 || tempo <= 0) {
			JOptionPane.showMessageDialog(null, "O valor presente e o tempo não podem ser menor ou igual a 0!", "Aviso",
					JOptionPane.WARNING_MESSAGE);
			return null;
		} else {
			return Math.pow(valorFuturo / valorPresente, 1.0 / tempo) - 1;
		}
	}

}