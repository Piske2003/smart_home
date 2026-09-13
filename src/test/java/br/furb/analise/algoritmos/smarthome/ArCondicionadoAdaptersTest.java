package br.furb.analise.algoritmos.smarthome;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import br.furb.analise.algoritmos.ArCondicionadoGellaKaza;
import br.furb.analise.algoritmos.ArCondicionadoVentoBaumn;
import br.furb.analise.algoritmos.smarthome.Interfaces.ArCondicionado;
import br.furb.analise.algoritmos.smarthome.adapters.ArCondicionadoGellaKazaAdapter;
import br.furb.analise.algoritmos.smarthome.adapters.ArCondicionadoVentoBaumnAdapter;
import org.junit.jupiter.api.Test;

class ArCondicionadoAdaptersTest {

    @Test
    void deveLigarEDesligarGellaKaza() {
        ArCondicionadoGellaKaza dispositivo = new ArCondicionadoGellaKaza();
        ArCondicionado arCondicionado = new ArCondicionadoGellaKazaAdapter(dispositivo);

        arCondicionado.ligar();
        assertTrue(dispositivo.estaLigado());

        arCondicionado.desligar();
        assertFalse(dispositivo.estaLigado());
    }

    @Test
    void deveAumentarEDiminuirUmGrauNoGellaKaza() {
        ArCondicionadoGellaKaza dispositivo = new ArCondicionadoGellaKaza();
        ArCondicionado arCondicionado = new ArCondicionadoGellaKazaAdapter(dispositivo);
        int temperaturaInicial = dispositivo.getTemperatura();

        arCondicionado.aumentarTemperatura();
        assertEquals(temperaturaInicial + 1, dispositivo.getTemperatura());

        arCondicionado.diminuirTemperatura();
        assertEquals(temperaturaInicial, dispositivo.getTemperatura());
    }

    @Test
    void deveDefinirTemperaturaAumentandoOuDiminuindoNoGellaKaza() {
        ArCondicionadoGellaKaza dispositivo = new ArCondicionadoGellaKaza();
        ArCondicionado arCondicionado = new ArCondicionadoGellaKazaAdapter(dispositivo);

        arCondicionado.definirTemperatura(30);
        assertEquals(30, dispositivo.getTemperatura());

        arCondicionado.definirTemperatura(25);
        assertEquals(25, dispositivo.getTemperatura());
    }

    @Test
    void deveManterTemperaturaQuandoGellaKazaJaEstaNoValorDesejado() {
        ArCondicionadoGellaKaza dispositivo = new ArCondicionadoGellaKaza();
        ArCondicionado arCondicionado = new ArCondicionadoGellaKazaAdapter(dispositivo);
        int temperaturaInicial = dispositivo.getTemperatura();

        arCondicionado.definirTemperatura(temperaturaInicial);

        assertEquals(temperaturaInicial, dispositivo.getTemperatura());
    }

    @Test
    void deveLigarEDesligarVentoBaumnSemErros() {
        ArCondicionadoVentoBaumn dispositivo = new ArCondicionadoVentoBaumn();
        ArCondicionado arCondicionado = new ArCondicionadoVentoBaumnAdapter(dispositivo);

        assertDoesNotThrow(arCondicionado::ligar);
        assertDoesNotThrow(arCondicionado::desligar);
    }

    @Test
    void deveAumentarEDiminuirUmGrauNoVentoBaumn() {
        ArCondicionadoVentoBaumn dispositivo = new ArCondicionadoVentoBaumn();
        ArCondicionado arCondicionado = new ArCondicionadoVentoBaumnAdapter(dispositivo);
        arCondicionado.ligar();
        int temperaturaInicial = dispositivo.getTemperatura();

        arCondicionado.aumentarTemperatura();
        assertEquals(temperaturaInicial + 1, dispositivo.getTemperatura());

        arCondicionado.diminuirTemperatura();
        assertEquals(temperaturaInicial, dispositivo.getTemperatura());
    }

    @Test
    void deveDefinirTemperaturaDiretamenteNoVentoBaumn() {
        ArCondicionadoVentoBaumn dispositivo = new ArCondicionadoVentoBaumn();
        ArCondicionado arCondicionado = new ArCondicionadoVentoBaumnAdapter(dispositivo);
        arCondicionado.ligar();

        arCondicionado.definirTemperatura(25);

        assertEquals(25, dispositivo.getTemperatura());
    }
}
