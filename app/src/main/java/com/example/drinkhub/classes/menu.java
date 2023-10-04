package com.example.drinkhub.classes;

import java.io.Serializable;

public class menu implements Serializable {
    private bevanda[] lista;
    public bevanda[] getLista() {
        return lista;
    }

    public void setLista(bevanda[] lista) {
        this.lista = lista;
    }
    public menu(bevanda[] lista) {
        this.lista = lista;
    }
}
