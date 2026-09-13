package br.furb.analise.algoritmos.smarthome;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import br.furb.analise.algoritmos.LampadaPhellipes;
import br.furb.analise.algoritmos.LampadaShoyuMi;
import br.furb.analise.algoritmos.smarthome.Interfaces.Lampada;
import br.furb.analise.algoritmos.smarthome.adapters.LampadaPhellipesAdapter;
import br.furb.analise.algoritmos.smarthome.adapters.LampadaShoyuMiAdapter;
import org.junit.jupiter.api.Test;

class LampadaAdaptersTest {

    @Test
    void deveLigarEDesligarLampadaShoyuMi() {
        LampadaShoyuMi dispositivo = new LampadaShoyuMi();
        Lampada lampada = new LampadaShoyuMiAdapter(dispositivo);

        lampada.Ligar();
        assertTrue(dispositivo.estaLigada());

        lampada.Desligar();
        assertFalse(dispositivo.estaLigada());
    }

    @Test
    void deveLigarEDesligarLampadaPhellipesPelaIntensidade() {
        LampadaPhellipes dispositivo = new LampadaPhellipes();
        Lampada lampada = new LampadaPhellipesAdapter(dispositivo);

        lampada.Ligar();
        assertEquals(100, dispositivo.getIntensidade());

        lampada.Desligar();
        assertEquals(0, dispositivo.getIntensidade());
    }
}
