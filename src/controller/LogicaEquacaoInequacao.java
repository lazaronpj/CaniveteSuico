package controller;

import javax.swing.JOptionPane;

/**
 * Classe responsável pela lógica de cálculos de equações e inequações.
 * 
 * Recebe valores já validados pela interface gráfica e executa os devidos cálculos de equações e inequações do 1º, 2º grau conforme a opção
 * selecionada pelo usuário.
 * 
 * @author Lazaro Nogueira
 * @version 1.1
 * @since 2025-08-13
 */

public class LogicaEquacaoInequacao {

	/**
	 * Realiza o cálculo de equação do primeiro grau
	 * 
	 * @param double
	 *            a - primeiro número responsável pelo cálculo
	 * @param double
	 *            b - Segundo número responsável pelo cálculo
	 * 
	 * @return Retorna o cálculo feito da equação do primeiro grau.
	 */

	public Double equacaoPrimeiroGrau(double a, double b) {
		if (a == 0) {
			JOptionPane.showMessageDialog(null, "O valor do coeficiente A não pode ser zero!", "Erro", JOptionPane.ERROR_MESSAGE);
			return null;
		}
		return -b / a;
	}

	/**
	 * Realiza o cálculo de equação do segundo grau X1 (Já calcula o delta)
	 * 
	 * @param double
	 *            a - primeiro número responsável pelo cálculo
	 * @param double
	 *            b - Segundo número responsável pelo cálculo
	 * @param double
	 *            c - terceiro número responsável pelo cálculo
	 * 
	 * @return Retorna o cálculo feito da equação do segundo grau.
	 */

	public Double equacaoSegundoGrauX1(double a, double b, double c) {
		if (a == 0) {
			JOptionPane.showMessageDialog(null, "O valor do coeficiente A não pode ser zero!", "Erro", JOptionPane.ERROR_MESSAGE);
			return null;
		}

		double delta = Math.pow(b, 2) - 4 * a * c;
		if (delta < 0) {
			JOptionPane.showMessageDialog(null, "A equação não possui raízes reais!", "Aviso", JOptionPane.WARNING_MESSAGE);
			return null;
		}

		return (-b + Math.sqrt(delta)) / (2 * a);
	}

	/**
	 * Realiza o cálculo de equação do segundo grau X2 (Já calcula o delta)
	 * 
	 * @param double
	 *            a - primeiro número responsável pelo cálculo
	 * @param double
	 *            b - Segundo número responsável pelo cálculo
	 * @param double
	 *            c - terceiro número responsável pelo cálculo
	 * 
	 * @return Retorna o cálculo feito da equação do segundo grau.
	 */

	public Double equacaoSegundoGrauX2(double a, double b, double c) {
		if (a == 0) {
			JOptionPane.showMessageDialog(null, "O valor do coeficiente A não pode ser zero!", "Erro", JOptionPane.ERROR_MESSAGE);
			return null;
		}

		double delta = Math.pow(b, 2) - 4 * a * c;
		if (delta < 0) {
			JOptionPane.showMessageDialog(null, "A equação não possui raízes reais!", "Aviso", JOptionPane.WARNING_MESSAGE);
			return null;
		}

		return (-b - Math.sqrt(delta)) / (2 * a);
	}

	public Double inequacaoPrimeiroGrau(double a, double b, String sinalIgualdade) {
		if (a == 0) {
			if (sinalIgualdade.equals("> 'Maior'")) {
				if (b > 0) {
					return (double) 1;
				}
				return (double) 0;

			} else if (sinalIgualdade.equals("< 'Menor'")) {
				if (b < 0) {
					return (double) 1;
				}
				return (double) 0;

			} else if (sinalIgualdade.equals("≥ 'Maior ou igual'")) {
				if (b >= 0) {
					return (double) 1;
				}
				return (double) 0;

			} else if (sinalIgualdade.equals("≤ 'Menor ou igual'")) {
				if (b <= 0) {
					return (double) 1;
				}
				return (double) 0;
			}

			double x = -b / a;

		}

	}
}

//
// public static double inequacao1(double a, double b, String sinal) {
// if (a == 0) {
// if (sinal.equals(">")) {
// if (b > 0) return 1;
// return 0;
// }
// if (sinal.equals(">=")) {
// if (b >= 0) return 1;
// return 0;
// }
// if (sinal.equals("<")) {
// if (b < 0) return 1;
// return 0;
// }
// if (sinal.equals("<=")) {
// if (b <= 0) return 1;
// return 0;
// }
// return 0;
// }
//
// double x = -b / a;
//
// if (sinal.equals(">") || sinal.equals(">=")) {
// if (a > 0) return x;
// return -x;
// }
//
// if (sinal.equals("<") || sinal.equals("<=")) {
// if (a > 0) return -x;
// return x;
// }
//
// return 0;
// }
//
// public static double inequacao2(double a, double b, double c, String sinal) {
// if (a == 0) return 0;
//
// double delta = b * b - 4 * a * c;
//
// if (delta < 0) {
// if (a > 0 && (sinal.equals(">") || sinal.equals(">="))) return 1;
// if (a < 0 && (sinal.equals("<") || sinal.equals("<="))) return 1;
// return 0;
// }
//
// if (delta == 0) {
// if (sinal.equals(">=") && a > 0) return 1;
// if (sinal.equals("<=") && a < 0) return 1;
// if (sinal.equals(">") && a > 0) return 1;
// if (sinal.equals("<") && a < 0) return 1;
// return 0;
// }
//
// return 1;
// }