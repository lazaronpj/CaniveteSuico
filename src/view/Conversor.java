package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.LogicaConversor;

/**
 * Essa classe é responsável pela interface gráfica do conversor de temperatura
 * 
 * @author Lazaro Nogueira
 * @version 1.1
 * @since 2025-08-13
 */

public class Conversor {

	/**
	 * Exibe a interface gráfica do conversor de temperatura.
	 * 
	 * *
	 * <p>
	 * Esse método cria a janela principal dessa classe, configura todos os
	 * componentes e trata os eventos de interação com o usuário.
	 * </p>
	 * 
	 * As operações nessa classe são delegadas para os métodos que contém as
	 * lógicas na classe {@link controller.LogicaConversor}.
	 */

	public static void conversor() {
		JFrame frame = new JFrame("Canivete Suíço - Conversor de Temperatura");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setSize(500, 260);
		frame.setResizable(false);
		frame.setLayout(new BorderLayout());

		JPanel norte = new JPanel(new FlowLayout(FlowLayout.LEFT, 15, 10));
		JLabel dica = new JLabel("Digite apenas algarismos numéricos!");
		norte.add(dica);

		JPanel centro = new JPanel();
		centro.setLayout(new BoxLayout(centro, BoxLayout.Y_AXIS));
		centro.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

		JLabel pergunta = new JLabel("Qual tipo de conversão você deseja fazer?");
		pergunta.setAlignmentX(JLabel.LEFT_ALIGNMENT);
		centro.add(pergunta);

		String[] opcoesConversor = {"Selecione uma opção", "Celsius para Fahrenheit", "Fahrenheit para Celsius"};
		JComboBox<String> comboConversor = new JComboBox<>(opcoesConversor);
		comboConversor.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));
		centro.add(comboConversor);

		JPanel linha1 = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 10));
		JLabel rotuloTemperatura = new JLabel("Temperatura:");
		rotuloTemperatura.setPreferredSize(new Dimension(120, 25));
		JTextField campoTemperatura = new JTextField();
		campoTemperatura.setPreferredSize(new Dimension(200, 25));
		campoTemperatura.setToolTipText("Digite a temperatura que você deseja converter!");
		linha1.add(rotuloTemperatura);
		linha1.add(campoTemperatura);
		centro.add(linha1);

		JPanel botoes = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
		JButton converter = new JButton("Converter");
		converter.setToolTipText("Clique aqui para efetuar a conversão de temperatura!");
		JButton limparCampos = new JButton("Limpar campos");
		limparCampos.setToolTipText("Clique aqui para limpar todos os campos!");

		converter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String valor = campoTemperatura.getText().trim();
				try {
					int valorConvertido = Integer.parseInt(valor);
					String op = (String) comboConversor.getSelectedItem();

					int resultado;
					String unidade;

					if (op.equals("Celsius para Fahrenheit")) {
						resultado = LogicaConversor.conversorTempCelsiusEmFahrenheit(valorConvertido);
						unidade = "Fahrenheit";
					} else {
						resultado = LogicaConversor.conversorTempFahrenheitEmCelsius(valorConvertido);
						unidade = "Celsius";
					}

					JOptionPane.showMessageDialog(null, "<html>O resultado da conversão é <font color='red'>" + resultado + "</font> graus</html> " + unidade + "!", "Resultado", JOptionPane.INFORMATION_MESSAGE);

				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(frame, "Entrada inválida! Digite apenas números!", "Erro", JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		limparCampos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				campoTemperatura.setText("");
			}
		});

		botoes.add(converter);
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
