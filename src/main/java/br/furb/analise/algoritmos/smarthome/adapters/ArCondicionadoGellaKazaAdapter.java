package br.furb.analise.algoritmos.smarthome.adapters;

import br.furb.analise.algoritmos.ArCondicionadoGellaKaza;
import br.furb.analise.algoritmos.smarthome.Interfaces.ArCondicionado;

public class ArCondicionadoGellaKazaAdapter implements ArCondicionado {

    private final ArCondicionadoGellaKaza arCondicionado;

    public ArCondicionadoGellaKazaAdapter(ArCondicionadoGellaKaza arCondicionado) {
        this.arCondicionado = arCondicionado;
    }

    @Override
    public void ligar() {
        arCondicionado.ativar();
    }

    @Override
    public void desligar() {
        arCondicionado.desativar();
    }

    @Override
    public void aumentarTemperatura() {
        arCondicionado.aumentarTemperatura();
    }

    @Override
    public void diminuirTemperatura() {
        arCondicionado.diminuirTemperatura();
    }

    @Override
    public void definirTemperatura(int temperatura) {
        while (arCondicionado.getTemperatura() < temperatura) {
            arCondicionado.aumentarTemperatura();
        }

        while (arCondicionado.getTemperatura() > temperatura) {
            arCondicionado.diminuirTemperatura();
        }
    }
}
