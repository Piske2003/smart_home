package br.furb.analise.algoritmos.smarthome.Interfaces;

public interface ArCondicionado {
    void ligar();
    void desligar();

    void aumentarTemperatura();
    void diminuirTemperatura();

    void definirTemperatura(int temperatura);
}
