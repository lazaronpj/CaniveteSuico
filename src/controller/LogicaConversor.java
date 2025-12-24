package controller;

/**
 * Classe responsável pela lógica de conversão de temperaturas.
 * 
 * Recebe valores já validados pela interface gráfica e executa as conversões de temperatura conforme a opção selecionada pelo usuário.
 * 
 * @author Lazaro Nogueira
 * @version 1.1
 * @since 2025-08-13
 */
public class LogicaConversor {

	/**
	 * Converte um valor em Celsius para Fahrenheit.
	 * 
	 * @param valor1
	 *            Temperatura em Celsius.
	 * @return Temperatura em Fahrenheit, arredondada para o número inteiro mais próximo.
	 */
	public Integer conversorTempCelsiusEmFahrenheit(Integer valor1) {
		return (int) Math.round((valor1 * 1.8) + 32);
	}

	/**
	 * Converte um valor em Fahrenheit para Celsius.
	 * 
	 * @param valor1
	 *            Temperatura em Fahrenheit.
	 * @return Temperatura em Celsius, arredondada para o número inteiro mais próximo.
	 */
	public Integer conversorTempFahrenheitEmCelsius(Integer valor1) {
		return (int) Math.round((valor1 - 32) / 1.8);
	}
}
