package controller;

public class LogicaConversor {

	public static Integer conversorTempCelsiusEmFahrenheit(Integer valor1) {
		return (int) Math.round((valor1 * 1.8) + 32);
	}
	
	public static Integer conversorTempFahrenheitEmCelsius(Integer valor1) {
		return (int) Math.round((valor1 - 32) / 1.8);
	}
}
