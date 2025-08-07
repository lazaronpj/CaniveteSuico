package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.LogicaConversor;

public class Conversor {

	public static void conversor() {

		JFrame frame = new JFrame("Canivete Suíço - Conversor de Temperatura");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setSize(500, 270);
		frame.setLayout(new BorderLayout());

		JPanel norte = new JPanel(new FlowLayout(FlowLayout.LEFT, 15, 10));
		JLabel dica = new JLabel("Digite apenas algarismos numéricos!");
		norte.add(dica);

		JPanel centro = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 10));
		JLabel pergunta = new JLabel("Qual tipo de conversão você deseja fazer?");
		centro.add(pergunta);

		String[] opcoesConversor = { "Celsius para Fahrenheit", "Fahrenheit para Celsius" };
		JComboBox<String> comboConversor = new JComboBox<>(opcoesConversor);
		comboConversor.setToolTipText("Qual tipo de conversão você deseja fazer?");
		centro.add(comboConversor);

		JPanel linha1 = new JPanel();
		JLabel primeiroNumero = new JLabel("Digite a temperatura a ser convertida: ");
		JTextField num1 = new JTextField(8);

		linha1.add(primeiroNumero);
		linha1.add(num1);

		centro.add(linha1);

		JPanel botoes = new JPanel(new FlowLayout(FlowLayout.CENTER));

		JButton converter = new JButton("Converter");
		JButton limparCampo = new JButton("Limpar Campo");

		converter.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String valor = num1.getText().trim();

				try {
					Integer valorConvertido = Integer.parseInt(valor);
					String op = (String) comboConversor.getSelectedItem();

					if (op.equals("Celsius para Fahrenheit")) {
						int resultado = LogicaConversor.conversorTempCelsiusEmFahrenheit(valorConvertido);
						JOptionPane.showMessageDialog(null,
							    "<html>O resultado da conversão é <span style='color:red;'><b>" + resultado + "</b></span> graus Fahrenheit!</html>",
							    "Resultado",
							    JOptionPane.INFORMATION_MESSAGE);


					} else if (op.equals("Fahrenheit para Celsius")) {
						int resultado = LogicaConversor.conversorTempFahrenheitEmCelsius(valorConvertido);
						JOptionPane.showMessageDialog(null,
							    "<html>O resultado da conversão é <span style='color:red;'><b>" + resultado + "</b></span> graus Celsius!</html>",
							    "Resultado",
							    JOptionPane.INFORMATION_MESSAGE);
					}

				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(frame, "Digite um número válido!", "Erro", JOptionPane.ERROR_MESSAGE);
				}

			}
		});

		limparCampo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				num1.setText("");
			}
		});

		botoes.add(converter);
		botoes.add(limparCampo);

		centro.add(botoes);

		JPanel sul = new JPanel(new BorderLayout());

		JPanel painelCopyright = new JPanel(new FlowLayout(FlowLayout.CENTER));
		painelCopyright.add(TelaPrincipal.criarCopyright());
		sul.add(painelCopyright);

		frame.add(norte, BorderLayout.NORTH);
		frame.add(centro, BorderLayout.CENTER);
		frame.add(sul, BorderLayout.SOUTH);

		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
}
