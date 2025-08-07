package controller;


public class LogicaCalculadora {
	
	public static Double somar(double numero1, double numero2) {
		return numero1 + numero2;
	}
	
	public static Double subtrair(double numero1, double numero2) {
		return numero1 - numero2;
	}
	
	public static Double multiplicar(double numero1, double numero2) {
		return numero1 * numero2;
	}
	
	public static Double dividir(double numero1, double numero2) {
		if(numero2 == 0) {
			return null;
		}
	    return numero1 / numero2;
	}
	
	public static Double restoDaDivisao(double numero1, double numero2) {
		return numero1 % numero2;
	}
	
	public static Double porcentagem(double numero1, double percentual) {
		return (numero1 * percentual) / 100;
	}
	
	public static Double potenciacao(double numero1, double numero2) {
	 return	Math.pow(numero1, numero2);
	}
	
	public static Double radiciacao(double numero1) {
		return Math.sqrt(numero1);
	}
	
	public static Double logaritmico(double numero1) {
		return Math.log(numero1);
	}
	
	public static Double exponencial(double numero1) {
		return Math.exp(numero1);
	}

}
