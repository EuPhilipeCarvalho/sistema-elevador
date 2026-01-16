package com.philipecarvalho.exercicioelevador.service;
import com.philipecarvalho.exercicioelevador.domain.Elevador;

public class ElevadorService {
    //Classe de delegar chamadas
    private final Elevador elevador;

    public ElevadorService(Elevador elevador) {
        this.elevador = elevador;
    }

    //Metodos
    public void subir() {
        elevador.subirUmAndar();
    }

    public void descer() {
        elevador.descerUmAndar();
    }

    public void entrar() {
        elevador.entrarPassageiro();
    }

    public void sair() {
        elevador.sairPassageiro();
    }

    public int andarAtual() {
        return elevador.getAndarAtual();
    }

    public int passageirosPresentes() {
        return elevador.getPassageirosPresentes();
    }
}
