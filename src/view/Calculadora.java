package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.LogicaCalculadora;

public class Calculadora {

	public static void calcular() {
		JFrame frame = new JFrame("Canivete Suíço - Calculadora");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setSize(520, 300);
		frame.setResizable(false);
		frame.setLayout(new BorderLayout());

		JPanel norte = new JPanel(new FlowLayout(FlowLayout.LEFT, 15, 10));
		norte.add(new JLabel("Digite apenas algarismos numéricos!"));

		JPanel centro = new JPanel();
		centro.setLayout(new BoxLayout(centro, BoxLayout.Y_AXIS));
		centro.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

		JLabel pergunta = new JLabel("Qual operação matemática deseja fazer?");
		pergunta.setAlignmentX(JLabel.LEFT_ALIGNMENT);
		centro.add(pergunta);

		String[] operacoes = {"Selecione uma opção", "Adição", "Subtração", "Multiplicação", "Divisão", "Resto da Divisão", "Porcentagem", "Potenciação", "Radiciação", "Exponencial", "Logaritmico"};
		JComboBox<String> comboOperacao = new JComboBox<>(operacoes);
		comboOperacao.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));
		centro.add(comboOperacao);

		JPanel campos = new JPanel();
		campos.setLayout(new BoxLayout(campos, BoxLayout.Y_AXIS));

		JPanel linha1 = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 5));
		JLabel lblNum1 = new JLabel("Digite o primeiro número:");
		lblNum1.setPreferredSize(new Dimension(180, 25));
		JTextField num1 = new JTextField();
		num1.setPreferredSize(new Dimension(200, 25));
		linha1.add(lblNum1);
		linha1.add(num1);

		JPanel linha2 = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 5));
		JLabel lblNum2 = new JLabel("Digite o segundo número:");
		lblNum2.setPreferredSize(new Dimension(180, 25));
		JTextField num2 = new JTextField();
		num2.setPreferredSize(new Dimension(200, 25));
		linha2.add(lblNum2);
		linha2.add(num2);

		campos.add(linha1);
		campos.add(linha2);
		centro.add(campos);

		num1.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				String txt1 = num1.getText().trim().replaceAll("[^0-9.,-]", "").replace(",", ".");
				num1.setText(txt1);
			}
		});

		num2.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				String txt2 = num2.getText().trim().replaceAll("[^0-9.,-]", "").replace(",", ".");
				num2.setText(txt2);
			}
		});

		comboOperacao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String op = (String) comboOperacao.getSelectedItem();
				if ((op.equals("Radiciação") || op.equals("Exponencial") || op.equals("Logaritmico"))) {
					num2.setText("0");
					num2.setEditable(false);
				} else {
					num2.setEditable(true);
				}
			}
		});

		JPanel botoes = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
		JButton calcular = new JButton("Calcular");
		JButton limparCampos = new JButton("Limpar campos");

		calcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String textoNum1 = num1.getText().trim();
				String textoNum2 = num2.getText().trim();

				try {
					double valor1 = Double.parseDouble(textoNum1);
					double valor2 = Double.parseDouble(textoNum2);
					String op = (String) comboOperacao.getSelectedItem();

					if (op.equals("Adição")) {
						double resultado = LogicaCalculadora.somar(valor1, valor2);
						String formatado = String.format("%.4f", resultado);
						JOptionPane.showMessageDialog(frame, "<html>O resultado é: <font color='red'>" + formatado + "</font></html>", "Resultado", JOptionPane.INFORMATION_MESSAGE);
						num1.setText("");
						num2.setText("");
					} else if (op.equals("Subtração")) {
						double resultado = LogicaCalculadora.subtrair(valor1, valor2);
						String formatado = String.format("%.4f", resultado);
						JOptionPane.showMessageDialog(frame, "<html>O resultado é: <font color='red'>" + formatado + "</font></html>", "Resultado", JOptionPane.INFORMATION_MESSAGE);
						num1.setText("");
						num2.setText("");
					} else if (op.equals("Multiplicação")) {
						double resultado = LogicaCalculadora.multiplicar(valor1, valor2);
						String formatado = String.format("%.4f", resultado);
						JOptionPane.showMessageDialog(frame, "<html>O resultado é: <font color='red'>" + formatado + "</font></html>", "Resultado", JOptionPane.INFORMATION_MESSAGE);
						num1.setText("");
						num2.setText("");
					} else if (op.equals("Divisão")) {
						double resultado = LogicaCalculadora.dividir(valor1, valor2);

						if (valor1 == 0 || valor2 == 0) {
							JOptionPane.showMessageDialog(frame, "Não pode-se dividir por zero!", "Erro", JOptionPane.ERROR_MESSAGE);
							return;
						} else {
							String formatado = String.format("%.4f", resultado);
							JOptionPane.showMessageDialog(frame, "<html>O resultado é: <font color='red'>" + formatado + "</font></html>", "Resultado", JOptionPane.INFORMATION_MESSAGE);
							num1.setText("");
							num2.setText("");
						}

					} else if (op.equals("Resto da Divisão")) {
						double resultado = LogicaCalculadora.restoDaDivisao(valor1, valor2);
						String formatado = String.format("%.4f", resultado);
						JOptionPane.showMessageDialog(frame, "<html>O resultado é: <font color='red'>" + formatado + "</font></html>", "Resultado", JOptionPane.INFORMATION_MESSAGE);
						num1.setText("");
						num2.setText("");
					} else if (op.equals("Porcentagem")) {
						double resultado = LogicaCalculadora.porcentagem(valor1, valor2);
						String formatado = String.format("%.4f", resultado);
						JOptionPane.showMessageDialog(frame, "<html>O resultado é: <font color='red'>" + formatado + "</font></html>", "Resultado", JOptionPane.INFORMATION_MESSAGE);
						num1.setText("");
						num2.setText("");
					} else if (op.equals("Potenciação")) {
						double resultado = LogicaCalculadora.potenciacao(valor1, valor2);
						String formatado = String.format("%.4f", resultado);
						JOptionPane.showMessageDialog(frame, "<html>O resultado é: <font color='red'>" + formatado + "</font></html>", "Resultado", JOptionPane.INFORMATION_MESSAGE);
						num1.setText("");
						num2.setText("");
					} else if (op.equals("Radiciação")) {
						double resultado = LogicaCalculadora.radiciacao(valor1);
						String formatado = String.format("%.4f", resultado);
						JOptionPane.showMessageDialog(frame, "<html>O resultado é: <font color='red'>" + formatado + "</font></html>", "Resultado", JOptionPane.INFORMATION_MESSAGE);
						num1.setText("");
						num2.setText("");
					} else if (op.equals("Exponencial")) {
						double resultado = LogicaCalculadora.exponencial(valor1);
						String formatado = String.format("%.4f", resultado);
						JOptionPane.showMessageDialog(frame, "<html>O resultado é: <font color='red'>" + formatado + "</font></html>", "Resultado", JOptionPane.INFORMATION_MESSAGE);
						num1.setText("");
						num2.setText("");
					} else if (op.equals("Logaritmico")) {
						double resultado = LogicaCalculadora.logaritmico(valor1);
						String formatado = String.format("%.4f", resultado);
						JOptionPane.showMessageDialog(frame, "<html>O resultado é: <font color='red'>" + formatado + "</font></html>", "Resultado", JOptionPane.INFORMATION_MESSAGE);
						num1.setText("");
						num2.setText("");
					}

				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(frame, "Digite um número válido e não deixe campos em branco!", "Erro", JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		limparCampos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comboOperacao.setSelectedIndex(0);
				num1.setText("");
				num2.setText("");
				num2.setEditable(true);
			}
		});

		botoes.add(calcular);
		botoes.add(limparCampos);
		centro.add(botoes);

		JPanel sul = new JPanel(new FlowLayout(FlowLayout.CENTER));
		sul.add(TelaPrincipal.criarCopyright());

		frame.add(norte, BorderLayout.NORTH);
		frame.add(centro, BorderLayout.CENTER);
		frame.add(sul, BorderLayout.SOUTH);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
}
