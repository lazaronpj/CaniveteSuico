package controller;

import javax.swing.JOptionPane;

/**
 * Classe responsável pela lógica do módulo de calculadora.
 * 
 * Recebe valores da interface gráfica e executa as operações matemáticas conforme a opção selecionada pelo usuário.
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
	 * @return Resultado da soma.
	 */
	public Double somar(double numero1, double numero2) {
		return numero1 + numero2;
	}

	/**
	 * Realiza a subtração de dois números.
	 * 
	 * @param numero1
	 *            Primeiro número responsável pelo cálculo,
	 * @param numero2
	 *            Segundo número responsável pelo cálculo.
	 * @return Resultado da sobtração.
	 */
	public Double subtrair(double numero1, double numero2) {
		return numero1 - numero2;
	}

	/**
	 * Realiza a multiplicação de dois números.
	 * 
	 * @param numero1
	 *            Primeiro número responsável pelo cálculo,
	 * @param numero2
	 *            Segundo número responsável pelo cálculo.
	 * @return Resultado da multiplicação.
	 */
	public Double multiplicar(double numero1, double numero2) {
		return numero1 * numero2;
	}

	/**
	 * Realiza a divisão de dois números.
	 * 
	 * @param numero1
	 *            Primeiro número responsável pelo cálculo,
	 * @param numero2
	 *            Segundo número responsável pelo cálculo.
	 * @return Resultado da divisão. Também verifica se o número2 é igual a 0.
	 */
	public Double dividir(double numero1, double numero2) {
		if (numero2 == 0) {
			JOptionPane.showMessageDialog(null, "O segundo campo não pode ser 0, favor corrigir!", "Aviso", JOptionPane.WARNING_MESSAGE);;
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
	 * @return Resultado do resto da divisão.
	 */
	public Double restoDaDivisao(double numero1, double numero2) {
		return numero1 % numero2;
	}

	/**
	 * Realiza o cálculo da porcentagem entre dois números.
	 * 
	 * @param numero1
	 *            Primeiro número responsável pelo cálculo,
	 * @param percentual
	 *            se refere ao número responsável pelo cálculo da taxa.
	 * @return O resultado do numero1 vezes o percentual em parênteses, dividido por 100.
	 */
	public Double porcentagem(double numero1, double percentual) {
		return (numero1 * percentual) / 100;
	}

	/**
	 * Realiza o cálculo da potenciação entre dois números.
	 * 
	 * @param numero1
	 *            Primeiro número responsável pelo cálculo,
	 * @param numero2
	 *            Segundo número responsável pelo cálculo.
	 * @return O resultado da potenciação utilizando a biblioteca Math.pow.
	 */
	public Double potenciacao(double numero1, double numero2) {
		return Math.pow(numero1, numero2);
	}

	/**
	 * Realiza o cálculo do resto da radiciação.
	 * 
	 * @param numero1
	 *            Primeiro número responsável pelo cálculo,
	 * @return O resultado da raiz quadrada, utilizando a biblioteca Math.pow.
	 */
	public Double radiciacao(double numero1) {
		return Math.sqrt(numero1);
	}

	/**
	 * Realiza o cálculo logarítmico.
	 * 
	 * @param numero1
	 *            Primeiro número responsável pelo cálculo,
	 * @return O número logarítmico, utilizando a biblioteca Math.log sobre o numero1.
	 */
	public Double logaritmico(double numero1) {
		return Math.log(numero1);
	}

	/**
	 * Realiza o cálculo exponencial.
	 * 
	 * @param numero1
	 *            Primeiro número responsável pelo cálculo,
	 * @return O número exponencial, utilizando a biblioteca Math.exp sobre o numero1.
	 */
	public Double exponencial(double numero1) {
		return Math.exp(numero1);
	}

}
