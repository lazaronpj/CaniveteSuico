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

import controller.LogicaFinanceira;

public class Financeiro {

	public static void financeiro() {
		JFrame frame = new JFrame("Canivete Suíço - Financeiro");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setSize(550, 350);
		frame.setResizable(false);
		frame.setLayout(new BorderLayout());

		JPanel norte = new JPanel(new FlowLayout(FlowLayout.LEFT, 15, 10));
		JLabel dica = new JLabel("Digite apenas algorítimos numéricos!");
		norte.add(dica);

		JPanel centro = new JPanel();
		centro.setLayout(new BoxLayout(centro, BoxLayout.Y_AXIS));
		centro.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

		JLabel pergunta = new JLabel("Qual operação de cálculo financeiro deseja fazer?");
		pergunta.setAlignmentX(JLabel.LEFT_ALIGNMENT);
		centro.add(pergunta);

		String[] opFinanceira = {"Selecione uma opção", "Valor Futuro Simples", "Valor Futuro Composto", "Valor Presente Simples", "Valor Presente Composto", "Juros Simples", "Juros Compostos",
				"Tempo Juros Simples", "Tempo Juros Compostos", "Taxa Juros Simples", "Taxa Juros Compostos"};
		JComboBox<String> comboFinanceiro = new JComboBox<>(opFinanceira);
		comboFinanceiro.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));
		centro.add(comboFinanceiro);

		JPanel campos = new JPanel();
		campos.setLayout(new BoxLayout(campos, BoxLayout.Y_AXIS));

		JPanel linha1 = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 5));
		JLabel valorPresente = new JLabel("Valor Presente:");
		valorPresente.setPreferredSize(new Dimension(120, 25));
		JTextField vp = new JTextField();
		vp.setPreferredSize(new Dimension(200, 25));
		linha1.add(valorPresente);
		linha1.add(vp);

		JPanel linha2 = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 5));
		JLabel valorFuturo = new JLabel("Valor Futuro:");
		valorFuturo.setPreferredSize(new Dimension(120, 25));
		JTextField vf = new JTextField();
		vf.setPreferredSize(new Dimension(200, 25));
		linha2.add(valorFuturo);
		linha2.add(vf);

		JPanel linha3 = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 5));
		JLabel taxaJuros = new JLabel("Taxa de Juros: ");
		taxaJuros.setPreferredSize(new Dimension(120, 25));
		JTextField tj = new JTextField();
		tj.setPreferredSize(new Dimension(200, 25));
		tj.setToolTipText("Digite a taxa como número decimal (ex: 0.20) ou porcentagem (ex: 20). Não use % ou valores negativos.");
		linha3.add(taxaJuros);
		linha3.add(tj);

		JPanel linha4 = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 5));
		JLabel tempo = new JLabel("Tempo:");
		tempo.setPreferredSize(new Dimension(120, 25));
		JTextField tmp = new JTextField();
		tmp.setPreferredSize(new Dimension(200, 25));
		linha4.add(tempo);
		linha4.add(tmp);

		campos.add(linha1);
		campos.add(linha2);
		campos.add(linha3);
		campos.add(linha4);
		centro.add(campos);

		vp.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				String txt1 = vp.getText().trim().replaceAll("[^0-9.,-]", "").replace(",", ".");
				vp.setText(txt1);
			}
		});

		vf.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				String txt2 = vf.getText().trim().replaceAll("[^0-9.,-]", "").replace(",", ".");
				vf.setText(txt2);
			}
		});

		tj.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				String txt3 = tj.getText().trim().replaceAll("[^0-9.,-]", "").replace(",", ".");
				tj.setText(txt3);

			}
		});

		tmp.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				String txt4 = tmp.getText().trim().replaceAll("[^0-9.,-]", "").replace(",", ".");
				tmp.setText(txt4);
			}
		});

		comboFinanceiro.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String op = (String) comboFinanceiro.getSelectedItem();

				vp.setEditable(true);
				vf.setEditable(true);
				tj.setEditable(true);
				tmp.setEditable(true);

				if (op.equals("Valor Futuro Simples")) {
					vf.setEditable(false);
					vf.setText("0");
				} else if (op.equals("Valor Futuro Composto")) {
					vf.setEditable(false);
					vf.setText("0");
				} else if (op.equals("Valor Presente Simples")) {
					vp.setEditable(false);
					vp.setText("0");
				} else if (op.equals("Valor Presente Composto")) {
					vp.setEditable(false);
					vp.setText("0");
				} else if (op.equals("Juros Simples")) {
					vf.setEditable(false);
					vf.setText("0");
				} else if (op.equals("Juros Compostos")) {
					vf.setEditable(false);
					vf.setText("0");
				} else if (op.equals("Tempo Juros Simples")) {
					tmp.setEditable(false);
					tmp.setText("0");
				} else if (op.equals("Tempo Juros Compostos")) {
					tmp.setEditable(false);
					tmp.setText("0");
				} else if (op.equals("Taxa Juros Simples")) {
					tj.setEditable(false);
					tj.setText("0");
				} else if (op.equals("Taxa Juros Compostos")) {
					tj.setEditable(false);
					tj.setText("0");
				}
			}
		});

		JPanel botoes = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
		JButton calcular = new JButton("Calcular");
		calcular.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String op = (String) comboFinanceiro.getSelectedItem();

				try {
					String vlp = vp.getText().trim();
					String vlf = vf.getText().trim();
					String txj = tj.getText().trim();
					String tp = tmp.getText().trim();

					double valorVlp = Double.parseDouble(vlp);
					double valorVlf = Double.parseDouble(vlf);
					double valorTxj = Double.parseDouble(txj);
					double valorTp = Double.parseDouble(tp);

					if (valorTxj < 0) {
						JOptionPane.showMessageDialog(frame, "O sistema não aceita taxa com valores negativos!", "Erro", JOptionPane.ERROR_MESSAGE);
						return;
					}

					if (valorTxj > 1) {
						valorTxj /= 100.0;
					}

					if (op.equals("Valor Futuro Simples")) {
						double resultado = LogicaFinanceira.valorFuturoSimples(valorVlp, valorTxj, valorTp);
						String formatado = String.format("%.4f", resultado);
						JOptionPane.showMessageDialog(frame, "O resultado é: R$ " + formatado, "Resultado", JOptionPane.INFORMATION_MESSAGE);
						vp.setText("");
						vf.setText("");
						tj.setText("");
						tmp.setText("");
					} else if (op.equals("Valor Futuro Composto")) {
						double resultado = LogicaFinanceira.valorFuturoComposto(valorVlp, valorTxj, valorTp);
						String formatado = String.format("%.4f", resultado);
						JOptionPane.showMessageDialog(frame, "O resultado é: R$ " + formatado, "Resultado", JOptionPane.INFORMATION_MESSAGE);
						vp.setText("");
						vf.setText("");
						tj.setText("");
						tmp.setText("");
					} else if (op.equals("Valor Presente Simples")) {
						double resultado = LogicaFinanceira.valorPresenteSimples(valorVlf, valorTxj, valorTp);
						String formatado = String.format("%.4f", resultado);
						JOptionPane.showMessageDialog(frame, "O resultado é: R$ " + formatado, "Resultado", JOptionPane.INFORMATION_MESSAGE);
						vp.setText("");
						vf.setText("");
						tj.setText("");
						tmp.setText("");
					} else if (op.equals("Valor Presente Composto")) {
						double resultado = LogicaFinanceira.valorPresenteComposto(valorVlf, valorTxj, valorTp);
						String formatado = String.format("%.4f", resultado);
						JOptionPane.showMessageDialog(frame, "O resultado é: R$ " + formatado, "Resultado", JOptionPane.INFORMATION_MESSAGE);
						vp.setText("");
						vf.setText("");
						tj.setText("");
						tmp.setText("");
					} else if (op.equals("Juros Simples")) {
						double resultado = LogicaFinanceira.jurosSimples(valorVlp, valorTxj, valorTp);
						String formatado = String.format("%.4f", resultado);
						JOptionPane.showMessageDialog(frame, "O resultado é: R$ " + formatado, "Resultado", JOptionPane.INFORMATION_MESSAGE);
						vp.setText("");
						vf.setText("");
						tj.setText("");
						tmp.setText("");
					} else if (op.equals("Juros Compostos")) {
						double resultado = LogicaFinanceira.jurosCompostos(valorVlp, valorTxj, valorTp);
						String formatado = String.format("%.4f", resultado);
						JOptionPane.showMessageDialog(frame, "O resultado é: R$ " + formatado, "Resultado", JOptionPane.INFORMATION_MESSAGE);
						vp.setText("");
						vf.setText("");
						tj.setText("");
						tmp.setText("");
					} else if (op.equals("Tempo Juros Simples")) {
						double resultado = LogicaFinanceira.tempoSimples(valorVlp, valorVlf, valorTxj);
						String formatado = String.format("%.4f", resultado);
						JOptionPane.showMessageDialog(frame, "O resultado é: " + formatado, "Resultado", JOptionPane.INFORMATION_MESSAGE);
						vp.setText("");
						vf.setText("");
						tj.setText("");
						tmp.setText("");
					} else if (op.equals("Tempo Juros Compostos")) {
						double resultado = LogicaFinanceira.tempoComposto(valorVlp, valorVlf, valorTxj);
						String formatado = String.format("%.4f", resultado);
						JOptionPane.showMessageDialog(frame, "O resultado é: " + formatado, "Resultado", JOptionPane.INFORMATION_MESSAGE);
						vp.setText("");
						vf.setText("");
						tj.setText("");
						tmp.setText("");
					} else if (op.equals("Taxa Juros Simples")) {
						double resultado = LogicaFinanceira.taxaSimples(valorVlp, valorVlf, valorTp);
						String formatado = String.format("%.4f", resultado);
						JOptionPane.showMessageDialog(frame, "O resultado é: " + formatado, "Resultado", JOptionPane.INFORMATION_MESSAGE);
						vp.setText("");
						vf.setText("");
						tj.setText("");
						tmp.setText("");
					} else if (op.equals("Taxa Juros Compostos")) {
						double resultado = LogicaFinanceira.taxaComposta(valorVlp, valorVlf, valorTp);
						String formatado = String.format("%.4f", resultado);
						JOptionPane.showMessageDialog(frame, "O resultado é: " + formatado, "Resultado", JOptionPane.INFORMATION_MESSAGE);
						vp.setText("");
						vf.setText("");
						tj.setText("");
						tmp.setText("");
					}
				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(null, "Digite um número válido e não deixe campos em branco!", "Erro", JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		JButton limparCampos = new JButton("Limpar Campos");
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
