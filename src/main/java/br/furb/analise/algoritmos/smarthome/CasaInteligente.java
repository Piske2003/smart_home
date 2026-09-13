package br.furb.analise.algoritmos.smarthome;

import br.furb.analise.algoritmos.smarthome.Interfaces.ArCondicionado;
import br.furb.analise.algoritmos.smarthome.Interfaces.Lampada;
import br.furb.analise.algoritmos.smarthome.Interfaces.Persiana;

public class CasaInteligente {

    private final Lampada lampada;
    private final Persiana persiana;
    private final ArCondicionado arCondicionado;

    public CasaInteligente(
            Lampada lampada,
            Persiana persiana,
            ArCondicionado arCondicionado) {
        this.lampada = lampada;
        this.persiana = persiana;
        this.arCondicionado = arCondicionado;
    }

    public void ligarLampada() {
        lampada.Ligar();
    }

    public void desligarLampada() {
        lampada.Desligar();
    }

    public void abrirPersiana() {
        persiana.Abrir();
    }

    public void fecharPersiana() {
        persiana.Fechar();
    }

    public void ligarArCondicionado() {
        arCondicionado.ligar();
    }

    public void desligarArCondicionado() {
        arCondicionado.desligar();
    }

    public void aumentarTemperatura() {
        arCondicionado.aumentarTemperatura();
    }

    public void diminuirTemperatura() {
        arCondicionado.diminuirTemperatura();
    }

    public void definirTemperatura(int temperatura) {
        arCondicionado.definirTemperatura(temperatura);
    }

    public void modoSono() {
        arCondicionado.desligar();
        lampada.Desligar();
        persiana.Fechar();
    }

    public void modoTrabalho() {
        lampada.Ligar();
        arCondicionado.ligar();
        arCondicionado.definirTemperatura(25);
        persiana.Abrir();
    }
}
