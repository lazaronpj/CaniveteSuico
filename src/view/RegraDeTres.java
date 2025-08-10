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

import controller.LogicaRegraDeTres;

public class RegraDeTres {

	public static void regraDeTres() {

		JFrame frame = new JFrame("Canivete Suíço - Regra de Três");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setSize(480, 280);
		frame.setResizable(false);
		frame.setLayout(new BorderLayout());

		JPanel norte = new JPanel(new FlowLayout(FlowLayout.LEFT, 15, 10));
		JLabel dica = new JLabel("Digite apenas algorítimos numéricos!");
		norte.add(dica);

		JPanel centro = new JPanel();
		centro.setLayout(new BoxLayout(centro, BoxLayout.Y_AXIS));
		centro.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

		JLabel pergunta = new JLabel("Qual operação de regra de três você deseja fazer?");
		pergunta.setAlignmentX(JLabel.LEFT_ALIGNMENT);
		centro.add(pergunta);

		String[] opRegraDeTres = {"Selecione uma opção", "Regra de Três Diretamente Proporcional", "Regra de Três Inversamente Proporcional"};
		JComboBox<String> comboRegraDeTres = new JComboBox<>(opRegraDeTres);
		comboRegraDeTres.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));
		centro.add(comboRegraDeTres);

		JPanel campos = new JPanel();
		campos.setLayout(new BoxLayout(campos, BoxLayout.Y_AXIS));
		campos.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

		JPanel linha1 = new JPanel();
		JLabel labelA = new JLabel("Digite o valor A: ");
		JTextField a = new JTextField();
		a.setPreferredSize(new Dimension(200, 25));
		linha1.add(labelA);
		linha1.add(a);

		JPanel linha2 = new JPanel();
		JLabel labelB = new JLabel("Digite o valor B: ");
		JTextField b = new JTextField();
		b.setPreferredSize(new Dimension(200, 25));
		linha2.add(labelB);
		linha2.add(b);

		JPanel linha3 = new JPanel();
		JLabel labelC = new JLabel("Digite o valor C: ");
		JTextField c = new JTextField();
		c.setPreferredSize(new Dimension(200, 25));
		linha3.add(labelC);
		linha3.add(c);

		centro.add(linha1);
		centro.add(linha2);
		centro.add(linha3);

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

					if (op.equals("Regra de Três Diretamente Proporcional")) {
						double resultado = LogicaRegraDeTres.regraDeTresDireta(valorCampoA, valorCampoB, valorCampoC);
						String formatado = String.format("%.4f", resultado);

						JOptionPane.showMessageDialog(frame, "<html>O resultado é: <font color='red'>" + formatado + "</font></html>", "Resultado", JOptionPane.INFORMATION_MESSAGE);
						a.setText("");
						b.setText("");
						c.setText("");
					} else if (op.equals("Regra de Três Inversamente Proporcional")) {
						double resultado = LogicaRegraDeTres.regraDeTresInversa(valorCampoA, valorCampoB, valorCampoC);
						String formatado = String.format("%.4f", resultado);
						JOptionPane.showMessageDialog(frame, "<html>O resultado é: <font color='red'>" + formatado + "</font></html>", "Resultado", JOptionPane.INFORMATION_MESSAGE);
						a.setText("");
						b.setText("");
						c.setText("");
					}
				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(null, "Digite um número válido e não deixe campos em branco!", "Erro", JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		JButton limparCampos = new JButton("Limpar Campos");
		limparCampos.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
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
