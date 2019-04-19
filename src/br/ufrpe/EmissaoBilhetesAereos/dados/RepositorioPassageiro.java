/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufrpe.EmissaoBilhetesAereos.dados;

import br.ufrpe.EmissaoBilhetesAereos.negocio.beans.Passageiro;
import java.util.*;


/**
 *
 * @author fight
 */
public class RepositorioPassageiro {
    private ArrayList<Passageiro> passageiros;
    
    public RepositorioPassageiro(){
        passageiros = new ArrayList();
    }
    
    public void cadastrar(Passageiro p){
        if(!passageiros.contains(p)){
            passageiros.add(p);
        }
    }
    public ArrayList listar(){
        return passageiros;
    }
    public Passageiro localizar(long cpf){
        Passageiro encontrado = null;
        int tam = passageiros.size();
        Passageiro[] lista = passageiros.toArray(new Passageiro[tam]);
        for(int i =0; i < tam; i++){
            if(lista[i].getCpf() == cpf){
                encontrado = lista[i];
            }
        }
        return encontrado;
    }
}
