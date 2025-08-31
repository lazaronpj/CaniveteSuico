package controller;

import javax.swing.JOptionPane;

public class LogicaEquacaoInequacao {

	public static Double equacaoPrimeiroGrau(double a, double b) {
		if (a == 0) {
			JOptionPane.showMessageDialog(null, "O valor do coeficiente A não pode ser zero!", "Erro", JOptionPane.ERROR_MESSAGE);
			return null;
		}
		return -b / a;
	}

	public static Double equacaoSegundoGrauX1(double a, double b, double c) {
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

	public static Double equacaoSegundoGrauX2(double a, double b, double c) {
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
}
