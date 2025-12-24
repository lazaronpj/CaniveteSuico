package view.telaCalculos;

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

import controller.LogicaEquacaoInequacao;
import view.telaPrincipal.TelaPrincipal;

/**
 * Essa classe é responsável pela interface gráfica do cálculo de equações e inequações
 * 
 * @author Lazaro Nogueira
 * @version 1.1
 * @since 2025-08-29
 */

public class EquacaoInequacao {

	/**
	 * Exibe a interface gráfica da calculadora de equações e inequações do primeiro e do segundo grau.
	 * 
	 * *
	 * <p>
	 * Esse método cria a janela principal dessa classe, configura todos os componentes e trata os eventos de interação com o usuário.
	 * </p>
	 * 
	 * As operações nessa classe são delegadas para os métodos que contém as lógicas na classe {@link controller.LogicaEquacaoInequacao}.
	 */

	public static void equacaoInequacao() {
		JFrame frame = new JFrame("Canivete Suíço - Calculadora de Equações e Inaquações");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setSize(500, 460);
		frame.setResizable(false);
		frame.setLayout(new BorderLayout());

		JPanel norte = new JPanel(new FlowLayout(FlowLayout.LEFT, 15, 10));
		JLabel dica = new JLabel("Digite apenas algarismos numéricos!");
		norte.add(dica);

		JPanel centro = new JPanel();
		centro.setLayout(new BoxLayout(centro, BoxLayout.Y_AXIS));
		centro.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

		JLabel pergunta = new JLabel("Qual tipo de cálculo você deseja fazer?");
		pergunta.setAlignmentX(JLabel.LEFT_ALIGNMENT);
		centro.add(pergunta);

		String[] opcoesEqIn = {"Selecione uma opção", "Equação do primeiro grau", "Equação do segundo grau X1",
				"Equação do segundo grau X2", "Inequação do primeiro grau", "Inequação do segundo grau"};
		JComboBox<String> comboOp = new JComboBox<>(opcoesEqIn);
		comboOp.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));
		centro.add(comboOp);

		JPanel linha1 = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 10));
		JLabel rotuloA = new JLabel("Valor A:");
		rotuloA.setPreferredSize(new Dimension(120, 30));
		JTextField campoA = new JTextField();
		campoA.setPreferredSize(new Dimension(200, 30));
		campoA.setToolTipText("Digite o valor correspondente a 'A'! ");
		linha1.add(rotuloA);
		linha1.add(campoA);
		centro.add(linha1);

		JPanel linha2 = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 10));
		JLabel rotuloB = new JLabel("Valor B:");
		rotuloB.setPreferredSize(new Dimension(120, 30));
		JTextField campoB = new JTextField();
		campoB.setPreferredSize(new Dimension(200, 30));
		campoB.setToolTipText("Digite o valor correspondente a 'B'! ");
		linha2.add(rotuloB);
		linha2.add(campoB);
		centro.add(linha2);

		JPanel linha3 = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 10));
		JLabel rotuloC = new JLabel("Valor C:");
		rotuloC.setPreferredSize(new Dimension(120, 30));
		JTextField campoC = new JTextField();
		campoC.setPreferredSize(new Dimension(200, 30));
		campoC.setToolTipText("Digite o valor correspondente a 'C'! ");
		linha3.add(rotuloC);
		linha3.add(campoC);
		centro.add(linha3);

		JPanel linha4 = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 10));
		JLabel rotuloSinal = new JLabel("Valor desigualdade:");
		rotuloSinal.setPreferredSize(new Dimension(120, 30));
		String[] opcoesDesigualdade = {"Selecione uma opção", "> 'Maior'", "< 'Menor'", "≥ 'Maior ou igual'", "≤ 'Menor ou igual'"};
		JComboBox<String> comboDesigualdade = new JComboBox<>(opcoesDesigualdade);
		comboDesigualdade.setPreferredSize(new Dimension(200, 30));
		comboDesigualdade.setToolTipText("Selecione o sinal correspondente a desigualdade! ");
		linha4.add(rotuloSinal);
		linha4.add(comboDesigualdade);
		centro.add(linha4);

		campoA.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				String txt = campoA.getText().trim().replaceAll("[^0-9.-]", "");
				campoA.setText(txt);
			}
		});

		campoB.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				String txt = campoB.getText().trim().replaceAll("[^0-9.-]", "");
				campoB.setText(txt);
			}
		});

		campoC.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				String txt = campoC.getText().trim().replaceAll("[^0-9.-]", "");
				campoC.setText(txt);
			}
		});

		comboOp.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String opSelecionada = (String) comboOp.getSelectedItem();

				if (("Equação do primeiro grau".equals(opSelecionada)) || ("Equação do segundo grau X1".equals(opSelecionada))
						|| ("Equação do segundo grau X2".equals(opSelecionada))) {
					comboDesigualdade.setEnabled(false);

				} else {
					comboDesigualdade.setEnabled(true);
				}
				if ("Equação do primeiro grau".equals(opSelecionada) || ("Inequação do primeiro grau".equals(opSelecionada))) {
					campoC.setEditable(false);
					campoC.setText("0");

				} else {
					campoC.setEditable(true);
				}

			}
		});
		// se o campo c for liberado ele nao deve conter o numero 0

		JPanel botoes = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
		JButton calcular = new JButton("Calcular");
		calcular.setToolTipText("Clique aqui para efetuar o cálculo de equação ou inequação!");
		JButton limparCampos = new JButton("Limpar campos");
		limparCampos.setToolTipText("Clique aqui para limpar todos os campos!");

		calcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String a = campoA.getText().trim();
					String b = campoB.getText().trim();
					String c = campoC.getText().trim();

					double valorA = Double.parseDouble(a);
					double valorB = Double.parseDouble(b);
					double valorC = Double.parseDouble(c);

					String opSelecionada = (String) comboOp.getSelectedItem();

					if (comboOp.getSelectedIndex() == 0) {
						JOptionPane.showMessageDialog(frame, "Selecione alguma opção antes de continuar!", "Erro",
								JOptionPane.ERROR_MESSAGE);
					} else {
						LogicaEquacaoInequacao le = new LogicaEquacaoInequacao();

						if ("Equação do primeiro grau".equals(opSelecionada)) {
							Double resultado = le.equacaoPrimeiroGrau(valorA, valorB);
							if (resultado != null) {
								String formatado = String.format("%.4f", resultado);
								JOptionPane.showMessageDialog(frame, "O resultado é: X = " + formatado, "Resultado",
										JOptionPane.INFORMATION_MESSAGE);
								comboOp.setSelectedIndex(0);
								campoA.setText("");
								campoB.setText("");
								comboDesigualdade.setSelectedIndex(0);
							}
						} else if ("Equação do segundo grau X1".equals(opSelecionada)) {
							Double resultado = le.equacaoSegundoGrauX1(valorA, valorB, valorC);
							if (resultado != null) {
								String formatado = String.format("%.4f", resultado);
								JOptionPane.showMessageDialog(frame, "O resultado é: X1 = " + formatado, "Resultado",
										JOptionPane.INFORMATION_MESSAGE);
								comboOp.setSelectedIndex(0);
								campoA.setText("");
								campoB.setText("");
								campoC.setText("");
								comboDesigualdade.setSelectedIndex(0);
							}
						} else if ("Equação do segundo grau X2".equals(opSelecionada)) {
							Double resultado = le.equacaoSegundoGrauX2(valorA, valorB, valorC);
							if (resultado != null) {
								String formatado = String.format("%.4f", resultado);
								JOptionPane.showMessageDialog(frame, "O resultado é: X2 = " + formatado, "Resultado",
										JOptionPane.INFORMATION_MESSAGE);
								comboOp.setSelectedIndex(0);
								campoA.setText("");
								campoB.setText("");
								campoC.setText("");
								comboDesigualdade.setSelectedIndex(0);
							}
						} else if ("Inequação do primeiro grau".equals(opSelecionada)) {

							// "> 'Maior'", "< 'Menor'", "≥ 'Maior ou igual'", "≤ 'Menor ou igual'"
							comboOp.setSelectedIndex(0);
							campoA.setText("");
							campoB.setText("");
							campoC.setText("");
							comboDesigualdade.setSelectedIndex(0);
						} else if ("Inequação do segundo grau".equals(opSelecionada)) {

							comboOp.setSelectedIndex(0);
							campoA.setText("");
							campoB.setText("");
							campoC.setText("");
							comboDesigualdade.setSelectedIndex(0);
						}

						// Falta completar a implementação dos cálculos das inequações.
					}
				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(frame, "Entrada inválida! Digite apenas números e preencha todos os campos!", "Erro",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		limparCampos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comboOp.setSelectedIndex(0);
				campoA.setText("");
				campoB.setText("");
				campoC.setText("");
				comboDesigualdade.setSelectedIndex(0);
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
