package com.example.drinkhub.classes;

import java.io.Serializable;
import java.util.List;

public class Carrello implements Serializable {

    List<Prodotto> lista;
    private Utente utente;

    public List<Prodotto> getCarrello() { return lista; }
    public void setLista(List<Prodotto> lista) { this.lista = lista; }
    public Utente getUtente() { return utente; }
    public void setUtente(Utente utente) { this.utente = utente; }

    public Carrello(List<Prodotto> lista, Utente utente) {
        this.lista = lista;
        this.utente = utente;
    }

}
