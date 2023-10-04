package com.example.drinkhub.classes;
import java.io.Serializable;
import java.util.Date;

public class ordine implements Serializable {

    private int idOrdine;
    private String tipoPagamento;
    private Date data;
    public ordine(int idOrdine, String tipoPagamento, Date data) {
        this.idOrdine = idOrdine;
        this.tipoPagamento = tipoPagamento;
        this.data = data;
    }

    public int getIdOrdine() {
        return idOrdine;
    }

    public void setIdOrdine(int idOrdine) {
        this.idOrdine = idOrdine;
    }

    public String getTipoPagamento() {
        return tipoPagamento;
    }

    public void setTipoPagamento(String tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
}
