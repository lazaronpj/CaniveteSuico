package controller;

public class LogicaFinanceira {

    // Juros Simples - Montante (Valor Futuro)
    public static Double valorFuturoSimples(double valorPresente, double taxaDeJuros, double tempo) {
        return valorPresente * (1 + taxaDeJuros * tempo);
    }

    // Juros Compostos - Montante (Valor Futuro)
    public static Double valorFuturoComposto(double valorPresente, double taxaDeJuros, double tempo) {
        return valorPresente * Math.pow(1 + taxaDeJuros, tempo);
    }

    // Valor Presente (Desconto) - Juros Simples
    public static Double valorPresenteSimples(double valorFuturo, double taxaDeJuros, double tempo) {
        if (taxaDeJuros == 0 || tempo == 0) {
            return null;
        } else {
            return valorFuturo / (1 + taxaDeJuros * tempo);
        }
    }

    // Valor Presente (Desconto) - Juros Compostos
    public static Double valorPresenteComposto(double valorFuturo, double taxaDeJuros, double tempo) {
        if (taxaDeJuros <= -1 || tempo == 0) {
            return null;
        } else {
            return valorFuturo / Math.pow(1 + taxaDeJuros, tempo);
        }
    }

    // Juros Simples - Juros totais
    public static Double jurosSimples(double valorPresente, double taxaDeJuros, double tempo) {
        return valorPresente * taxaDeJuros * tempo;
    }

    // Juros Compostos - Juros totais
    public static Double jurosCompostos(double valorPresente, double taxaDeJuros, double tempo) {
        return valorPresente * (Math.pow(1 + taxaDeJuros, tempo) - 1);
    }

    // Tempo - Juros Simples
    public static Double tempoSimples(double valorPresente, double valorFuturo, double taxaDeJuros) {
        if (valorPresente == 0 || taxaDeJuros == 0) {
            return null;
        } else {
            return ((valorFuturo / valorPresente) - 1) / taxaDeJuros;
        }
    }

    // Tempo - Juros Compostos
    public static Double tempoComposto(double valorPresente, double valorFuturo, double taxaDeJuros) {
        if (valorPresente == 0 || taxaDeJuros <= -1 || valorFuturo <= 0) {
            return null;
        } else {
            return Math.log(valorFuturo / valorPresente) / Math.log(1 + taxaDeJuros);
        }
    }

    // Taxa - Juros Simples
    public static Double taxaSimples(double valorPresente, double valorFuturo, double tempo) {
        if (valorPresente == 0 || tempo == 0) {
            return null;
        } else {
            return ((valorFuturo / valorPresente) - 1) / tempo;
        }
    }

    // Taxa - Juros Compostos
    public static Double taxaComposta(double valorPresente, double valorFuturo, double tempo) {
        if (valorPresente == 0 || tempo == 0) {
            return null;
        } else {
            return Math.pow(valorFuturo / valorPresente, 1.0 / tempo) - 1;
        }
    }

    // Regra de 3 Direta
    public static Double regraDeTresDireta(double valor1, double valor2, double valor3) {
        if (valor1 == 0) {
            return null;
        } else {
            return (valor2 * valor3) / valor1;
        }
    }

    // Regra de 3 Inversa
    public static Double regraDeTresInversa(double valor1, double valor2, double valor3) {
        if (valor3 == 0) {
            return null;
        } else {
            return (valor1 * valor2) / valor3;
        }
    }
}
