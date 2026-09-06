package br.furb.analise.algoritmos.smarthome.adapters;

import br.furb.analise.algoritmos.PersianaNatLight;
import br.furb.analise.algoritmos.smarthome.Interfaces.Persiana;

public class PersianaNatLightAdapter implements Persiana {

    private final PersianaNatLight persiana;

    public PersianaNatLightAdapter(PersianaNatLight persiana) {
        this.persiana = persiana;
    }

    @Override
    public void Abrir() {
        if (!persiana.estaPalhetaAberta()) {
            persiana.abrirPalheta();
        }

        if (!persiana.estaPalhetaErguida()) {
            try {
                persiana.subirPalheta();
            } catch (Exception exception) {
                throw new IllegalStateException("Não foi possível abrir a persiana NatLight.", exception);
            }
        }
    }

    @Override
    public void Fechar() {
        if (persiana.estaPalhetaErguida()) {
            persiana.descerPalheta();
        }

        if (persiana.estaPalhetaAberta()) {
            try {
                persiana.fecharPalheta();
            } catch (Exception exception) {
                throw new IllegalStateException("Não foi possível fechar a persiana NatLight.", exception);
            }
        }
    }
}
