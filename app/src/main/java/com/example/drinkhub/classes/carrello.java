package com.example.drinkhub.classes;

import java.io.Serializable;

public class carrello implements Serializable {
    private bevanda[] lista;
    public bevanda[] getLista() {
        return lista;
    }

    public void setLista(bevanda[] lista) {
        this.lista = lista;
    }

    public carrello(bevanda[] lista) {
        this.lista = lista;
    }
}
