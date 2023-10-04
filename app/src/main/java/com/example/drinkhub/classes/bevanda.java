package com.example.drinkhub.classes;

import java.io.Serializable;

public class bevanda implements Serializable {
    private int idBevanda;
    private String nome;
    private float prezzo;
    private String tipo;
    private String descrizione;

    public int getIdBevanda() { return idBevanda; }

    public void setIdBevanda(int idBevanda) { this.idBevanda = idBevanda; }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(float prezzo) {
        this.prezzo = prezzo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public bevanda(int id, String nome, float prezzo, String tipo, String descrizione) {
        this.idBevanda = idBevanda;
        this.nome = nome;
        this.prezzo = prezzo;
        this.tipo = tipo;
        this.descrizione = descrizione;
    }




}
