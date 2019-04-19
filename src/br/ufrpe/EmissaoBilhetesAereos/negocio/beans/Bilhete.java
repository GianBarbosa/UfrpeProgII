/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufrpe.EmissaoBilhetesAereos.negocio.beans;

/**
 *
 * @author fight
 */
public class Bilhete {
    private Voo voo;
    private Passageiro passageiro;
    private String assento;

    public Bilhete(Voo voo, Passageiro passageiro, String assento) {
        this.voo = voo;
        this.passageiro = passageiro;
        this.assento = assento;
    }

    public Voo getVoo() {
        return voo;
    }

    public Passageiro getPassageiro() {
        return passageiro;
    }
    
    
}
