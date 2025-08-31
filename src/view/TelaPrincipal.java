package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Essa classe é responsável pela interface gráfica principal do programa
 * 
 * @author Lazaro Nogueira
 * @version 1.1
 * @since 2025-08-13
 */

public class TelaPrincipal {

	/**
	 * Exibe a interface gráfica principal desse programa.
	 * 
	 * *
	 * <p>
	 * Esse método cria a janela principal dessa classe, configura todos os
	 * componentes e trata os eventos de interação com o usuário.
	 * </p>
	 * 
	 */

	public static JLabel criarCopyright() {
		return new JLabel("<html><div style='text-align:center; color:#808080;'>" + "© 2025 Lazaro Coder <span style='color:#C0C0C0;'>v1.1</span>" + "</div></html>");
	}

	public static void main(String[] args) {

		JFrame frame = new JFrame("Canivete Suíço - Faz de tudo um pouco!");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800, 180);
		frame.setResizable(false);
		frame.setLayout(new BorderLayout());

		JPanel norte = new JPanel(new FlowLayout(FlowLayout.LEFT, 15, 10));
		JLabel bemVindo = new JLabel("Seja sempre bem-vindo(a)!");
		norte.add(bemVindo);

		JPanel centro = new JPanel(new BorderLayout());
		JPanel botoes = new JPanel(new FlowLayout(FlowLayout.CENTER));

		JButton calculadora = new JButton("Calculadora");
		calculadora.setToolTipText("Clique aqui se deseja realizar algum cálculo!");
		calculadora.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Calculadora.calcular();
			}
		});

		JButton conversorDeTemperatura = new JButton("Conversor de Temperatura");
		conversorDeTemperatura.setToolTipText("Clique aqui se deseja realizar alguma conversão de temperatura!");
		conversorDeTemperatura.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Conversor.conversor();
			}
		});

		JButton assistenteFinanceiro = new JButton("Assistente Financeiro");
		assistenteFinanceiro.setToolTipText("Clique aqui se deseja realizar algum cálculo financeiro!");
		assistenteFinanceiro.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Financeiro.financeiro();
			}
		});

		JButton regraDeTres = new JButton("Regra de três");
		regraDeTres.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				RegraDeTres.regraDeTres();
			}
		});

		JButton equacaoInequacao = new JButton("Equação e Inequação");
		equacaoInequacao.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				EquacaoInequacao.equacaoInequacao();
			}
		});

		botoes.add(calculadora);
		botoes.add(conversorDeTemperatura);
		botoes.add(assistenteFinanceiro);
		botoes.add(regraDeTres);
		botoes.add(equacaoInequacao);

		centro.add(botoes);

		JPanel sul = new JPanel(new BorderLayout());

		JPanel painelCopyright = new JPanel(new FlowLayout(FlowLayout.CENTER));
		painelCopyright.add(criarCopyright());
		sul.add(painelCopyright);

		frame.add(norte, BorderLayout.NORTH);
		frame.add(centro, BorderLayout.CENTER);
		frame.add(sul, BorderLayout.SOUTH);

		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
}