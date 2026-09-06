package br.furb.analise.algoritmos.smarthome.adapters;

import br.furb.analise.algoritmos.LampadaPhellipes;
import br.furb.analise.algoritmos.smarthome.Interfaces.Lampada;

public class LampadaPhellipesAdapter implements Lampada {

    private final LampadaPhellipes lampada;

    public LampadaPhellipesAdapter(LampadaPhellipes lampada) {
        this.lampada = lampada;
    }

    @Override
    public void Ligar() {
        lampada.setIntensidade(100);
    }

    @Override
    public void Desligar() {
        lampada.setIntensidade(0);
    }
}
