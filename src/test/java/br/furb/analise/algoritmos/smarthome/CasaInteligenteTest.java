package br.furb.analise.algoritmos.smarthome;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import br.furb.analise.algoritmos.ArCondicionadoGellaKaza;
import br.furb.analise.algoritmos.LampadaShoyuMi;
import br.furb.analise.algoritmos.PersianaNatLight;
import br.furb.analise.algoritmos.smarthome.adapters.ArCondicionadoGellaKazaAdapter;
import br.furb.analise.algoritmos.smarthome.adapters.LampadaShoyuMiAdapter;
import br.furb.analise.algoritmos.smarthome.adapters.PersianaNatLightAdapter;
import org.junit.jupiter.api.Test;

class CasaInteligenteTest {

    @Test
    void modoTrabalhoDevePrepararTodosOsDispositivos() {
        LampadaShoyuMi lampada = new LampadaShoyuMi();
        PersianaNatLight persiana = new PersianaNatLight();
        ArCondicionadoGellaKaza arCondicionado = new ArCondicionadoGellaKaza();
        CasaInteligente casa = criarCasa(lampada, persiana, arCondicionado);

        casa.modoSono();
        casa.modoTrabalho();

        assertTrue(lampada.estaLigada());
        assertTrue(arCondicionado.estaLigado());
        assertEquals(25, arCondicionado.getTemperatura());
        assertTrue(persiana.estaPalhetaAberta());
        assertTrue(persiana.estaPalhetaErguida());
    }

    @Test
    void modoSonoDeveDesligarEFecharTodosOsDispositivos() {
        LampadaShoyuMi lampada = new LampadaShoyuMi();
        PersianaNatLight persiana = new PersianaNatLight();
        ArCondicionadoGellaKaza arCondicionado = new ArCondicionadoGellaKaza();
        CasaInteligente casa = criarCasa(lampada, persiana, arCondicionado);

        casa.modoTrabalho();
        casa.modoSono();

        assertFalse(lampada.estaLigada());
        assertFalse(arCondicionado.estaLigado());
        assertFalse(persiana.estaPalhetaAberta());
        assertFalse(persiana.estaPalhetaErguida());
    }

    private CasaInteligente criarCasa(
            LampadaShoyuMi lampada,
            PersianaNatLight persiana,
            ArCondicionadoGellaKaza arCondicionado) {
        return new CasaInteligente(
                new LampadaShoyuMiAdapter(lampada),
                new PersianaNatLightAdapter(persiana),
                new ArCondicionadoGellaKazaAdapter(arCondicionado));
    }
}
