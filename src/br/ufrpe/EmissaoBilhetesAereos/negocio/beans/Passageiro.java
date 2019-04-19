/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufrpe.EmissaoBilhetesAereos.negocio.beans;

import java.time.*;

/**
 *
 * @author fight
 */
public class Passageiro {
    private String nome;
    private long cpf;
    private LocalDateTime dataNascimento;
    
    public Passageiro(String nome, long cpf, LocalDateTime nascimento){
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = nascimento;
    }

    public long getCpf() {
        return cpf;
    }

    public String toString() {
        return "Passageiro{" + "nome: " + nome + ", cpf: " + cpf + ", dataNascimento: " + dataNascimento + '}';
    }
    
}
