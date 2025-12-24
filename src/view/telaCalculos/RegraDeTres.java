package view.telaCalculos;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.LogicaRegraDeTres;
import view.telaPrincipal.TelaPrincipal;

/**
 * Essa classe é responsável pela interface gráfica da regra de três
 *
 * @author Lazaro Nogueira
 * @version 1.1
 * @since 2025-08-13
 */

public class RegraDeTres {

	/**
	 * Exibe a interface gráfica da regra de três.
	 *
	 * *
	 * <p>
	 * Esse método cria a janela principal dessa classe, configura todos os componentes e trata os eventos de interação com o usuário.
	 * </p>
	 *
	 * As operações nessa classe são delegadas para os métodos que contém as lógicas na classe {@link controller.LogicaRegraDeTres}.
	 */

	public static void regraDeTres() {
		JFrame frame = new JFrame("Canivete Suíço - Regra de Três");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setSize(480, 420);
		frame.setResizable(false);
		frame.setLayout(new BorderLayout());

		JPanel norte = new JPanel(new FlowLayout(FlowLayout.LEFT, 15, 10));
		JLabel dica = new JLabel("Digite apenas algarismos numéricos!");
		norte.add(dica);

		JPanel centro = new JPanel();
		centro.setLayout(new BoxLayout(centro, BoxLayout.Y_AXIS));
		centro.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

		JPanel dicas = new JPanel();
		dicas.setLayout(new BoxLayout(dicas, BoxLayout.Y_AXIS));
		dicas.setAlignmentX(JPanel.LEFT_ALIGNMENT);
		JLabel dica1 = new JLabel("Simples: A está para B, assim como C está para X");
		dica1.setAlignmentX(JLabel.LEFT_ALIGNMENT);
		JLabel dica2 = new JLabel("Inversa: A está para B, assim como X está para C");
		dica2.setAlignmentX(JLabel.LEFT_ALIGNMENT);
		dicas.add(dica1);
		dicas.add(dica2);
		centro.add(dicas);
		centro.add(Box.createRigidArea(new Dimension(0, 15)));

		JLabel pergunta = new JLabel("Qual operação de regra de três você deseja fazer?");
		pergunta.setAlignmentX(JLabel.LEFT_ALIGNMENT);
		centro.add(pergunta);
		centro.add(Box.createRigidArea(new Dimension(0, 5)));

		String[] opRegraDeTres = {"Selecione uma opção", "Regra de Três Diretamente Proporcional",
				"Regra de Três Inversamente Proporcional"};
		JComboBox<String> comboRegraDeTres = new JComboBox<>(opRegraDeTres);
		comboRegraDeTres.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));
		centro.add(comboRegraDeTres);
		centro.add(Box.createRigidArea(new Dimension(0, 20)));

		JPanel linha1 = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 5));
		JLabel labelA = new JLabel("Digite o valor A: ");
		JTextField a = new JTextField();
		a.setPreferredSize(new Dimension(200, 30));
		a.setToolTipText("Digite o valor da primeira grandeza!");
		linha1.add(labelA);
		linha1.add(a);

		JPanel linha2 = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 5));
		JLabel labelB = new JLabel("Digite o valor B: ");
		JTextField b = new JTextField();
		b.setPreferredSize(new Dimension(200, 30));
		b.setToolTipText("Digite o valor da segunda grandeza!");
		linha2.add(labelB);
		linha2.add(b);

		JPanel linha3 = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 5));
		JLabel labelC = new JLabel("Digite o valor C: ");
		JTextField c = new JTextField();
		c.setPreferredSize(new Dimension(200, 30));
		c.setToolTipText("Digite o valor da terceira grandeza!");
		linha3.add(labelC);
		linha3.add(c);

		centro.add(linha1);
		centro.add(Box.createRigidArea(new Dimension(0, 5)));
		centro.add(linha2);
		centro.add(Box.createRigidArea(new Dimension(0, 5)));
		centro.add(linha3);
		centro.add(Box.createRigidArea(new Dimension(0, 20)));

		a.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				String txt1 = a.getText().trim().replaceAll("[^0-9.,-]", "").replace(",", ".");
				a.setText(txt1);
			}
		});
		b.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				String txt2 = b.getText().trim().replaceAll("[^0-9.,-]", "").replace(",", ".");
				b.setText(txt2);
			}
		});
		c.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				String txt3 = c.getText().trim().replaceAll("[^0-9.,-]", "").replace(",", ".");
				c.setText(txt3);
			}
		});

		JPanel botoes = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
		JButton calcular = new JButton("Calcular");
		calcular.setToolTipText("Clique aqui para efetuar o cálculo da regra de três!");
		JButton limparCampos = new JButton("Limpar campos");
		limparCampos.setToolTipText("Clique aqui para limpar todos os campos!");

		calcular.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String op = (String) comboRegraDeTres.getSelectedItem();
				String campoA = a.getText();
				String campoB = b.getText();
				String campoC = c.getText();
				try {
					double valorCampoA = Double.parseDouble(campoA);
					double valorCampoB = Double.parseDouble(campoB);
					double valorCampoC = Double.parseDouble(campoC);
					if (comboRegraDeTres.getSelectedIndex() == 0) {
						JOptionPane.showMessageDialog(frame, "Selecione alguma opção antes de continuar!", "Erro",
								JOptionPane.ERROR_MESSAGE);
					} else {
						LogicaRegraDeTres lr = new LogicaRegraDeTres();
						if (op.equals("Regra de Três Diretamente Proporcional")) {
							double resultado = lr.regraDeTresDireta(valorCampoA, valorCampoB, valorCampoC);
							String formatado = String.format("%.4f", resultado);
							JOptionPane.showMessageDialog(frame,
									"<html>O resultado é <font color='red'>X</font>: <font color='red'>" + formatado + "</font></html>",
									"Resultado", JOptionPane.INFORMATION_MESSAGE);
							comboRegraDeTres.setSelectedIndex(0);
							a.setText("");
							b.setText("");
							c.setText("");
						} else if (op.equals("Regra de Três Inversamente Proporcional")) {
							double resultado = lr.regraDeTresInversa(valorCampoA, valorCampoB, valorCampoC);
							String formatado = String.format("%.4f", resultado);
							JOptionPane.showMessageDialog(frame,
									"<html>O resultado é <font color='red'>X</font>: <font color='red'>" + formatado + "</font></html>",
									"Resultado", JOptionPane.INFORMATION_MESSAGE);
							comboRegraDeTres.setSelectedIndex(0);
							a.setText("");
							b.setText("");
							c.setText("");
						}
					}
				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(frame, "Entrada inválida! Digite apenas números e preencha todos os campos!", "Erro",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		limparCampos.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				comboRegraDeTres.setSelectedIndex(0);
				a.setText("");
				b.setText("");
				c.setText("");
			}
		});
		botoes.add(calcular);
		botoes.add(limparCampos);
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