/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufrpe.EmissaoBilhetesAereos.dados;

import br.ufrpe.EmissaoBilhetesAereos.negocio.beans.Bilhete;
import java.util.*;
/**
 *
 * @author fight
 */
public class RepositorioBilhete {
    ArrayList<Bilhete> bilhetes;
    
    public RepositorioBilhete(){
        bilhetes = new ArrayList();
    }
    
    public void cadastrar(Bilhete b){
        if(!bilhetes.contains(b)){
            bilhetes.add(b);
        }
    }
    public ArrayList listar(){
        return bilhetes;
    }
}
