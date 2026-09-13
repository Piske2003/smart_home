package br.furb.analise.algoritmos.smarthome;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import br.furb.analise.algoritmos.PersianaNatLight;
import br.furb.analise.algoritmos.PersianaSolarius;
import br.furb.analise.algoritmos.smarthome.Interfaces.Persiana;
import br.furb.analise.algoritmos.smarthome.adapters.PersianaNatLightAdapter;
import br.furb.analise.algoritmos.smarthome.adapters.PersianaSolariusAdapter;
import org.junit.jupiter.api.Test;

class PersianaAdaptersTest {

    @Test
    void deveAbrirEFecharPersianaSolarius() {
        PersianaSolarius dispositivo = new PersianaSolarius();
        Persiana persiana = new PersianaSolariusAdapter(dispositivo);

        persiana.Fechar();
        assertFalse(dispositivo.estaAberta());

        persiana.Abrir();
        assertTrue(dispositivo.estaAberta());
    }

    @Test
    void deveFecharPersianaNatLightNaOrdemPermitida() {
        PersianaNatLight dispositivo = new PersianaNatLight();
        Persiana persiana = new PersianaNatLightAdapter(dispositivo);

        persiana.Fechar();

        assertFalse(dispositivo.estaPalhetaErguida());
        assertFalse(dispositivo.estaPalhetaAberta());
    }

    @Test
    void deveAbrirPersianaNatLightNaOrdemPermitida() {
        PersianaNatLight dispositivo = new PersianaNatLight();
        Persiana persiana = new PersianaNatLightAdapter(dispositivo);
        persiana.Fechar();

        persiana.Abrir();

        assertTrue(dispositivo.estaPalhetaAberta());
        assertTrue(dispositivo.estaPalhetaErguida());
    }

    @Test
    void devePermitirRepetirOperacoesNaPersianaNatLight() {
        PersianaNatLight dispositivo = new PersianaNatLight();
        Persiana persiana = new PersianaNatLightAdapter(dispositivo);

        persiana.Abrir();
        persiana.Abrir();
        assertTrue(dispositivo.estaPalhetaAberta());
        assertTrue(dispositivo.estaPalhetaErguida());

        persiana.Fechar();
        persiana.Fechar();
        assertFalse(dispositivo.estaPalhetaAberta());
        assertFalse(dispositivo.estaPalhetaErguida());
    }
}
