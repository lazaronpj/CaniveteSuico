package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

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
		frame.setSize(500, 270);
		frame.setLayout(new BorderLayout());

		JPanel norte = new JPanel(new FlowLayout(FlowLayout.LEFT, 15, 10));
		JLabel dica = new JLabel("Digite apenas algarismos numéricos!");
		norte.add(dica);
		
		JPanel centro = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 10));
		JLabel pergunta = new JLabel("Qual operação matemática deseja fazer?");
		centro.add(pergunta);
		
		String [] operacao = {"Adição", "Subtração", "Multiplicação", "Divisão", "Resto da Divisão", "Porcentagem", "Potenciação", "Radiciação", "Exponencial", "Logaritmico"};
		JComboBox <String> comboOperacao = new JComboBox<>(operacao);
		comboOperacao.setToolTipText("Qual operação matemática deseja realizar?");
		centro.add(comboOperacao);
		
		JLabel primeiroNumero = new JLabel("Digite o primeiro número: ");
		JTextField num1 = new JTextField(8);

		num1.addKeyListener(new KeyAdapter() {
		    @Override
		    public void keyReleased(KeyEvent e) {
		        String txt = num1.getText();
		        txt = txt.replaceAll("[^0-9.,-]", "");
		        txt = txt.replace(",", ".");
		        num1.setText(txt);
		    }
		});

		JPanel linha1 = new JPanel();
		linha1.add(primeiroNumero);
		linha1.add(num1);
		
		JPanel linha2 = new JPanel();
		JLabel segundoNumero = new JLabel("Digite o segundo número: ");
		JTextField num2 = new JTextField(8);
		
	
		num2.addKeyListener(new KeyAdapter() {
		    @Override
		    public void keyReleased(KeyEvent e) {
		    	String txt = num2.getText();
		        txt = txt.replaceAll("[^0-9.,-]", "");
		        txt = txt.replace(",", ".");
		        num2.setText(txt);
		    }
		});
		
		comboOperacao.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        String op = (String) comboOperacao.getSelectedItem();

		        if (op.equals("Radiciação")) {
		        	num2.setText("0");
		            num2.setEditable(false); 
		        }else if(op.equals("Exponencial")) {
		        	num2.setText("0");
		            num2.setEditable(false); 
		        }else if(op.equals("Logaritmico")) {
		        	num2.setText("0");
		            num2.setEditable(false); 
		        }
		        else {
		            num2.setText("");
		            num2.setEditable(true); 
		        }
		    }
		});

		linha2.add(segundoNumero);
		linha2.add(num2);
	
		centro.add(linha1);
		centro.add(linha2);
		
		JPanel botoes = new JPanel(new FlowLayout(FlowLayout.CENTER));
		
		JButton calcular = new JButton("Calcular");
		calcular.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String textoNum1 = num1.getText().trim();
				String textoNum2 = num2.getText().trim();
				
				try{
					double valor1 = Double.parseDouble(textoNum1);
					double valor2 = Double.parseDouble(textoNum2);

					String op = (String) comboOperacao.getSelectedItem();
					
					if(op.equals("Adição")) {
						double resultado =  LogicaCalculadora.somar(valor1, valor2);
						String resultadoFormatado = String.format("%.4f", resultado);
					    JOptionPane.showMessageDialog(null, "<html>O resultado é: <span style='color:red;'><b>" + resultadoFormatado, "</b></span>Resultado</html>", JOptionPane.INFORMATION_MESSAGE);
						comboOperacao.setSelectedIndex(0);
						num1.setText("");
						num2.setText("");
					} else if(op.equals("Subtração")) {
						double resultado =  LogicaCalculadora.subtrair(valor1, valor2);
						String resultadoFormatado = String.format("%.4f", resultado);
					    JOptionPane.showMessageDialog(null, "<html>O resultado é: <span style='color:red;'><b>" + resultadoFormatado, "</b></span>Resultado</html>", JOptionPane.INFORMATION_MESSAGE);
						comboOperacao.setSelectedIndex(0);
						num1.setText("");
						num2.setText("");
					} else if(op.equals("Multiplicação")) {
						double resultado =  LogicaCalculadora.multiplicar(valor1, valor2);
						String resultadoFormatado = String.format("%.4f", resultado);
					    JOptionPane.showMessageDialog(null, "<html>O resultado é: <span style='color:red;'><b>" + resultadoFormatado, "</b></span>Resultado</html>", JOptionPane.INFORMATION_MESSAGE);
						comboOperacao.setSelectedIndex(0);
						num1.setText("");
						num2.setText("");
					} else if(op.equals("Divisão")) {
						    Double resultado = LogicaCalculadora.dividir(valor1, valor2);
						    if(resultado == null) {
						        JOptionPane.showMessageDialog(null, "Não pode-se dividir um número por zero!", "Erro", JOptionPane.ERROR_MESSAGE);
						        return;
						    }
						    
						    String resultadoFormatado = String.format("%.4f", resultado);
						    JOptionPane.showMessageDialog(null, "<html>O resultado é: <span style='color:red;'><b>" + resultadoFormatado, "</b></span>Resultado</html>", JOptionPane.INFORMATION_MESSAGE);
							comboOperacao.setSelectedIndex(0);
							num1.setText("");
							num2.setText("");					
					} else if(op.equals("Resto da Divisão")) {
						double resultado = LogicaCalculadora.restoDaDivisao(valor1, valor2);
						String resultadoFormatado = String.format("%.4f", resultado);
					    JOptionPane.showMessageDialog(null, "<html>O resultado é: <span style='color:red;'><b>" + resultadoFormatado, "</b></span>Resultado</html>", JOptionPane.INFORMATION_MESSAGE);
						comboOperacao.setSelectedIndex(0);
						num1.setText("");
						num2.setText("");					
					} else if(op.equals("Porcentagem")) {
						double resultado = LogicaCalculadora.porcentagem(valor1, valor2);
						String resultadoFormatado = String.format("%.4f", resultado);
					    JOptionPane.showMessageDialog(null, "<html>O resultado é: <span style='color:red;'><b>" + resultadoFormatado, "</b></span>Resultado</html>", JOptionPane.INFORMATION_MESSAGE);
						comboOperacao.setSelectedIndex(0);
						num1.setText("");
						num2.setText("");					
					} else if(op.equals("Potenciação")) {
						double resultado = LogicaCalculadora.potenciacao(valor1, valor2);
						String resultadoFormatado = String.format("%.4f", resultado);
					    JOptionPane.showMessageDialog(null, "<html>O resultado é: <span style='color:red;'><b>" + resultadoFormatado, "</b></span>Resultado</html>", JOptionPane.INFORMATION_MESSAGE);
						comboOperacao.setSelectedIndex(0);
						num1.setText("");
						num2.setText("");	
					} else if(op.equals("Radiciação")) {
						double resultado = LogicaCalculadora.radiciacao(valor1);
						String resultadoFormatado = String.format("%.4f", resultado);
					    JOptionPane.showMessageDialog(null, "<html>O resultado é: <span style='color:red;'><b>" + resultadoFormatado, "</b></span>Resultado</html>", JOptionPane.INFORMATION_MESSAGE);
						comboOperacao.setSelectedIndex(0);
						num1.setText("");
						num2.setText("");	
					} else if(op.equals("Exponencial")) {
						double resultado = LogicaCalculadora.exponencial(valor1);
						String resultadoFormatado = String.format("%.4f", resultado);
					    JOptionPane.showMessageDialog(null, "<html>O resultado é: <span style='color:red;'><b>" + resultadoFormatado, "</b></span>Resultado</html>", JOptionPane.INFORMATION_MESSAGE);
						comboOperacao.setSelectedIndex(0);
						num1.setText("");
						num2.setText("");						
					} else if(op.equals("Logaritmico")) {
						double resultado = LogicaCalculadora.logaritmico(valor1);
						String resultadoFormatado = String.format("%.4f", resultado);
					    JOptionPane.showMessageDialog(null, "<html>O resultado é: <span style='color:red;'><b>" + resultadoFormatado, "</b></span>Resultado</html>", JOptionPane.INFORMATION_MESSAGE);
						comboOperacao.setSelectedIndex(0);
						num1.setText("");
						num2.setText("");
					}
					
				} catch(NumberFormatException ex) {
					JOptionPane.showMessageDialog(frame, "Digite um número válido!", "Erro", JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		
		JButton limparCampos = new JButton("Limpar campos");
		limparCampos.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				comboOperacao.setSelectedIndex(0);
				num1.setText("");
				num2.setText("");
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