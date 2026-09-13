package br.furb.analise.algoritmos.smarthome;

import br.furb.analise.algoritmos.ArCondicionadoGellaKaza;
import br.furb.analise.algoritmos.ArCondicionadoVentoBaumn;
import br.furb.analise.algoritmos.LampadaPhellipes;
import br.furb.analise.algoritmos.LampadaShoyuMi;
import br.furb.analise.algoritmos.PersianaNatLight;
import br.furb.analise.algoritmos.PersianaSolarius;
import br.furb.analise.algoritmos.smarthome.Interfaces.ArCondicionado;
import br.furb.analise.algoritmos.smarthome.Interfaces.Lampada;
import br.furb.analise.algoritmos.smarthome.Interfaces.Persiana;
import br.furb.analise.algoritmos.smarthome.adapters.ArCondicionadoGellaKazaAdapter;
import br.furb.analise.algoritmos.smarthome.adapters.ArCondicionadoVentoBaumnAdapter;
import br.furb.analise.algoritmos.smarthome.adapters.LampadaPhellipesAdapter;
import br.furb.analise.algoritmos.smarthome.adapters.LampadaShoyuMiAdapter;
import br.furb.analise.algoritmos.smarthome.adapters.PersianaNatLightAdapter;
import br.furb.analise.algoritmos.smarthome.adapters.PersianaSolariusAdapter;

public final class Main {

    private Main() {
    }

    public static void main(String[] args) {
        executarCenarioUm();
        executarCenarioDois();
    }

    private static void executarCenarioUm() {
        LampadaShoyuMi dispositivoLampada = new LampadaShoyuMi();
        PersianaNatLight dispositivoPersiana = new PersianaNatLight();
        ArCondicionadoGellaKaza dispositivoAr = new ArCondicionadoGellaKaza();

        Lampada lampada = new LampadaShoyuMiAdapter(dispositivoLampada);
        Persiana persiana = new PersianaNatLightAdapter(dispositivoPersiana);
        ArCondicionado arCondicionado = new ArCondicionadoGellaKazaAdapter(dispositivoAr);
        CasaInteligente casa = new CasaInteligente(lampada, persiana, arCondicionado);

        System.out.println("=== CENÁRIO 1: CONTROLE INDIVIDUAL ===");
        casa.ligarLampada();
        System.out.println("Lâmpada após ligar: " + dispositivoLampada.estaLigada());
        casa.desligarLampada();
        System.out.println("Lâmpada após desligar: " + dispositivoLampada.estaLigada());

        casa.abrirPersiana();
        System.out.println("Persiana após abrir:");
        mostrarEstadoNatLight(dispositivoPersiana);
        casa.fecharPersiana();
        System.out.println("Persiana após fechar:");
        mostrarEstadoNatLight(dispositivoPersiana);

        casa.ligarArCondicionado();
        System.out.println("Ar-condicionado após ligar: " + dispositivoAr.estaLigado());
        casa.aumentarTemperatura();
        System.out.println("Temperatura após aumentar: " + dispositivoAr.getTemperatura() + "°C");
        casa.diminuirTemperatura();
        System.out.println("Temperatura após diminuir: " + dispositivoAr.getTemperatura() + "°C");
        casa.definirTemperatura(23);
        System.out.println("Temperatura definida: " + dispositivoAr.getTemperatura() + "°C");

        System.out.println("\n=== CENÁRIO 1: MODO TRABALHO ===");
        casa.modoTrabalho();
        mostrarEstadoCenarioUm(dispositivoLampada, dispositivoPersiana, dispositivoAr);

        System.out.println("\n=== CENÁRIO 1: MODO SONO ===");
        casa.modoSono();
        mostrarEstadoCenarioUm(dispositivoLampada, dispositivoPersiana, dispositivoAr);
    }

    private static void executarCenarioDois() {
        LampadaPhellipes dispositivoLampada = new LampadaPhellipes();
        PersianaSolarius dispositivoPersiana = new PersianaSolarius();
        ArCondicionadoVentoBaumn dispositivoAr = new ArCondicionadoVentoBaumn();

        Lampada lampada = new LampadaPhellipesAdapter(dispositivoLampada);
        Persiana persiana = new PersianaSolariusAdapter(dispositivoPersiana);
        ArCondicionado arCondicionado = new ArCondicionadoVentoBaumnAdapter(dispositivoAr);
        CasaInteligente casa = new CasaInteligente(lampada, persiana, arCondicionado);

        System.out.println("\n=== CENÁRIO 2: MODO TRABALHO ===");
        casa.modoTrabalho();
        mostrarEstadoCenarioDois(dispositivoLampada, dispositivoPersiana, dispositivoAr);

        System.out.println("\n=== CENÁRIO 2: MODO SONO ===");
        casa.modoSono();
        mostrarEstadoCenarioDois(dispositivoLampada, dispositivoPersiana, dispositivoAr);
    }

    private static void mostrarEstadoNatLight(PersianaNatLight persiana) {
        System.out.println("  Persiana erguida: " + persiana.estaPalhetaErguida());
        System.out.println("  Palhetas abertas: " + persiana.estaPalhetaAberta());
    }

    private static void mostrarEstadoCenarioUm(
            LampadaShoyuMi lampada,
            PersianaNatLight persiana,
            ArCondicionadoGellaKaza arCondicionado) {
        System.out.println("Lâmpada ligada: " + lampada.estaLigada());
        System.out.println("Ar-condicionado ligado: " + arCondicionado.estaLigado());
        System.out.println("Temperatura: " + arCondicionado.getTemperatura() + "°C");
        mostrarEstadoNatLight(persiana);
    }

    private static void mostrarEstadoCenarioDois(
            LampadaPhellipes lampada,
            PersianaSolarius persiana,
            ArCondicionadoVentoBaumn arCondicionado) {
        System.out.println("Intensidade da lâmpada: " + lampada.getIntensidade());
        System.out.println("Persiana aberta: " + persiana.estaAberta());
        System.out.println("Temperatura: " + arCondicionado.getTemperatura() + "°C");
        System.out.println("Estado ligado do VentoBaumn não é exposto pela biblioteca.");
    }
}
