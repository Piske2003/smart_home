package br.furb.analise.algoritmos.smarthome.adapters;

import br.furb.analise.algoritmos.LampadaShoyuMi;
import br.furb.analise.algoritmos.smarthome.Interfaces.Lampada;

public class LampadaShoyuMiAdapter implements Lampada {

    private final LampadaShoyuMi lampada;

    public LampadaShoyuMiAdapter(LampadaShoyuMi lampada) {
        this.lampada = lampada;
    }

    @Override
    public void Ligar() {
        lampada.ligar();
    }

    @Override
    public void Desligar() {
        lampada.desligar();
    }
}
