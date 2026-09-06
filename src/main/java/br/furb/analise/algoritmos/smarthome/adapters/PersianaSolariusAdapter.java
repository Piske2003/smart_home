package br.furb.analise.algoritmos.smarthome.adapters;

import br.furb.analise.algoritmos.PersianaSolarius;
import br.furb.analise.algoritmos.smarthome.Interfaces.Persiana;

public class PersianaSolariusAdapter implements Persiana {

    private final PersianaSolarius persiana;

    public PersianaSolariusAdapter(PersianaSolarius persiana) {
        this.persiana = persiana;
    }

    @Override
    public void Abrir() {
        persiana.subirPersiana();
    }

    @Override
    public void Fechar() {
        persiana.descerPersiana();
    }
}
