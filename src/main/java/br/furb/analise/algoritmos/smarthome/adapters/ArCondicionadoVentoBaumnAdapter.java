package br.furb.analise.algoritmos.smarthome.adapters;

import br.furb.analise.algoritmos.ArCondicionadoVentoBaumn;
import br.furb.analise.algoritmos.smarthome.Interfaces.ArCondicionado;

public class ArCondicionadoVentoBaumnAdapter implements ArCondicionado {

    private final ArCondicionadoVentoBaumn arCondicionado;

    public ArCondicionadoVentoBaumnAdapter(ArCondicionadoVentoBaumn arCondicionado) {
        this.arCondicionado = arCondicionado;
    }

    @Override
    public void ligar() {
        arCondicionado.ligar();
    }

    @Override
    public void desligar() {
        arCondicionado.desligar();
    }

    @Override
    public void aumentarTemperatura() {
        int temperaturaAtual = arCondicionado.getTemperatura();
        arCondicionado.definirTemperatura(temperaturaAtual + 1);
    }

    @Override
    public void diminuirTemperatura() {
        int temperaturaAtual = arCondicionado.getTemperatura();
        arCondicionado.definirTemperatura(temperaturaAtual - 1);
    }

    @Override
    public void definirTemperatura(int temperatura) {
        arCondicionado.definirTemperatura(temperatura);
    }
}
