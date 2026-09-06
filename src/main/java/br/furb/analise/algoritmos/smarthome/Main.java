package br.furb.analise.algoritmos.smarthome;

import br.furb.analise.algoritmos.LampadaShoyuMi;

/**
 * Ponto de entrada temporário usado para validar a integração com a biblioteca.
 */
public final class Main {

    public static void main(String[] args) {
        LampadaShoyuMi lampada = new LampadaShoyuMi();

        lampada.ligar();
        System.out.println("Após ligar: " + lampada.estaLigada());

        lampada.desligar();
        System.out.println("Após desligar: " + lampada.estaLigada());
    }
}
