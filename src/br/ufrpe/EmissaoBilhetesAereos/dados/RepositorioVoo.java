/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufrpe.EmissaoBilhetesAereos.dados;

import br.ufrpe.EmissaoBilhetesAereos.negocio.beans.Voo;
import java.time.LocalDateTime;
import java.util.*;
/**
 *
 * @author fight
 */
public class RepositorioVoo {
    ArrayList<Voo> voos;
    
    public RepositorioVoo(){
        voos = new ArrayList();
    }
    
    public boolean cadastrar(Voo v){
        boolean cadastrado = false;
        if(!voos.contains(v)){
            if(v.getDataHoraPartida().compareTo(v.getDataHoraEstimada()) < 0){
               voos.add(v);
               cadastrado = true;
            }
            
        }
        return cadastrado;
    }
    
    public ArrayList listar(){
        return voos;
    }
    public Voo localizarVoo(LocalDateTime partida , String cidadeOrigem, String cidadeDestino){
        Voo encontrado = null;
        LocalDateTime qualquer = LocalDateTime.now();
        Voo v2 = new Voo(partida, qualquer, cidadeOrigem, cidadeDestino);
        int tam = voos.size();
        Voo[] lista = voos.toArray(new Voo[tam]);
        for(int i =0; i < tam; i++){
            if(lista[i].equals(v2)){
                encontrado = lista[i];
            }
        }
        return encontrado;
    }
}
