/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufrpe.EmissaoBilhetesAereos.negocio.beans;

import java.time.LocalDateTime;
import java.util.*;

/**
 *
 * @author fight
 */
public class Voo {
    private LocalDateTime dataHoraPartida;
    private LocalDateTime dataHoraEstimada;
    private String cidadeOrigem;
    private String cidadeDestino;
    private ArrayList<String> listaAssentosOcupados;

    public Voo(LocalDateTime dataHoraPartida, LocalDateTime dataHoraEstimada, String cidadeOrigem, String cidadeDestino) {
        this.dataHoraPartida = dataHoraPartida;
        this.dataHoraEstimada = dataHoraEstimada;
        this.cidadeOrigem = cidadeOrigem;
        this.cidadeDestino = cidadeDestino;
        this.listaAssentosOcupados = new ArrayList();
    }
    public boolean ocuparAssento(String assento){
        boolean ocupou;
        if(!listaAssentosOcupados.contains(assento)){
           listaAssentosOcupados.add(assento);
           ocupou = true;
        }
        else{
           ocupou = false;
        }
        return ocupou;
    }

    public LocalDateTime getDataHoraPartida() {
        return dataHoraPartida;
    }

    public LocalDateTime getDataHoraEstimada() {
        return dataHoraEstimada;
    }

    public String getCidadeOrigem() {
        return cidadeOrigem;
    }

    public String getCidadeDestino() {
        return cidadeDestino;
    }

    

    public boolean equals(Voo v) {
        boolean resultado = false;
        if(v != null){
           if(this.cidadeOrigem.equals(v.getCidadeOrigem()) && this.cidadeDestino.equals(v.getCidadeDestino())){
               if(this.dataHoraPartida.equals(v.getDataHoraPartida())){
                   resultado = true;
               }
           }
        }
        return resultado;
    }

    @Override 
    public String toString() {
        return "Voo{" + "Partida: " + dataHoraPartida + ", ChegadaEstimada: " + dataHoraEstimada + ", cidadeOrigem: " + cidadeOrigem + ", cidadeDestino: " + cidadeDestino + ", AssentosOcupados: " + listaAssentosOcupados + '}';
    }
    
    
    
    
}
