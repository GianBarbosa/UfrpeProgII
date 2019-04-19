/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufrpe.EmissaoBilhetesAereos.negocio;

import br.ufrpe.EmissaoBilhetesAereos.negocio.beans.Bilhete;
import br.ufrpe.EmissaoBilhetesAereos.negocio.beans.Passageiro;
import br.ufrpe.EmissaoBilhetesAereos.negocio.beans.Voo;
import br.ufrpe.EmissaoBilhetesAereos.dados.RepositorioVoo;
import br.ufrpe.EmissaoBilhetesAereos.dados.RepositorioBilhete;
import br.ufrpe.EmissaoBilhetesAereos.dados.RepositorioPassageiro;
import java.time.LocalDateTime;
import java.util.*;

/**
 *
 * @author fight
 */
public class ControladorEmissaoBilhetes {
    RepositorioPassageiro repPassageiro;
    RepositorioVoo repVoo;
    RepositorioBilhete repBilhete;
    
    public ControladorEmissaoBilhetes(){
        repPassageiro = new RepositorioPassageiro();
        repVoo = new RepositorioVoo();
        repBilhete = new RepositorioBilhete();
    }
    
    public void cadastrarVoo(Voo v){
        if(!repVoo.cadastrar(v)){
            System.out.println("Não foi possivel cadastrar voo.");
        }
    }
    public ArrayList listarVoo(){
        return repVoo.listar();
    }
    public void cadastrarPassageiro(Passageiro p){
        repPassageiro.cadastrar(p);
    }
    public ArrayList listarPassageiro(){
        return repPassageiro.listar();
    }
    public void emitirBilhete(Voo v, Passageiro p, String assento){
        boolean emitido = false;
        if(v.getDataHoraPartida().compareTo(LocalDateTime.now()) > 0){
            if(v.ocuparAssento(assento)){
               Bilhete b = new Bilhete(v, p, assento);
               repBilhete.cadastrar(b);
               emitido = true;
            }
        }
        if(emitido = false){
            System.out.println("Não foi possivel emitir bilhete.");
        }
    }
    public ArrayList listarPassageeiroVoo(Voo v){
        ArrayList<Passageiro> passageirosVoo = new ArrayList();
        
        int tam = repBilhete.listar().size();
        ArrayList<Bilhete> bilhetes = repBilhete.listar();
        Bilhete[] bilhete = bilhetes.toArray(new Bilhete[tam]);
        
        for(int i = 0; i < bilhete.length; i++){
            if(bilhete[i].getVoo().equals(v)){
                passageirosVoo.add(bilhete[i].getPassageiro());
            }
        }
        return passageirosVoo;
    }
    public Passageiro locPassageiro(long cpf){
        return repPassageiro.localizar(cpf);
    }
    public Voo locVoo(LocalDateTime partida, String cidadeOrigem, String cidadeDestino){
        return repVoo.localizarVoo(partida, cidadeOrigem, cidadeDestino);
    }
}
