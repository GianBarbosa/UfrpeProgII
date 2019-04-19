/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufrpe.EmissaoBilhetesAereos;

import br.ufrpe.EmissaoBilhetesAereos.negocio.ControladorEmissaoBilhetes;
import br.ufrpe.EmissaoBilhetesAereos.negocio.beans.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author fight
 */
public class Principal {
    private static LocalDateTime novaData(){
        Scanner ler = new Scanner(System.in);
        int ano;
        int mes;
        int dia;
        int hora;
        int minuto;
        System.out.println("Ano: ");
        ano = ler.nextInt();
        System.out.println("Mês: ");
        mes = ler.nextInt();
        System.out.println("Dia: ");
        dia = ler.nextInt();
        System.out.println("Hora: ");
        hora = ler.nextInt();
        System.out.println("Minutos: ");
        minuto = ler.nextInt();
        LocalDateTime data = LocalDateTime.of(ano, mes, dia, hora, minuto);
        return data;
    }
    
    public static void main(String[] args) {
        ControladorEmissaoBilhetes sistema = new ControladorEmissaoBilhetes();
        Scanner ler = new Scanner(System.in);
        boolean status = true;
        while(status == true){
            System.out.println("Menu");
            System.out.println("1 - Cadastrar novo voo.");
            System.out.println("2 - Listar todos os voos.");
            System.out.println("3 - Cadastrar novo passageiro.");
            System.out.println("4 - Listar todos os passageiros.");
            System.out.println("5 - Emitir um bilhete de passagem.");
            System.out.println("6 - Listar os passageiros de um voo.");
            System.out.println("7 - Encerrar sistema.");

            int opcao = ler.nextInt();
            ler.nextLine();

            switch(opcao){
                    case 1:
                        System.out.print("Cidade de Partida: ");
                        String cidadeOrigem = ler.nextLine();
                        System.out.print("Cidade de Destino: ");
                        String cidadeDestino = ler.nextLine();
                        System.out.println("Data de Partida");
                        LocalDateTime dataHoraPartida = novaData();
                        System.out.println("Data Estimada de Chegada");
                        LocalDateTime dataHoraEstimada = novaData();

                        Voo v = new Voo(dataHoraPartida, dataHoraEstimada, cidadeOrigem, cidadeDestino);
                        sistema.cadastrarVoo(v); break;
                    case 2:
                        System.out.println(sistema.listarVoo());break;
                    case 3: 
                        System.out.print("Nome: ");
                        String nome = ler.nextLine();
                        System.out.print("CPF:");
                        long cpf = ler.nextLong();
                        System.out.println("Data de Nascimento");
                        LocalDateTime nascimento = novaData();
                        Passageiro p = new Passageiro(nome, cpf, nascimento);
                        sistema.cadastrarPassageiro(p); break;
                    case 4:
                        System.out.println(sistema.listarPassageiro()); break;
                    case 5:
                        System.out.println(sistema.listarPassageiro());
                        System.out.println("CPF do passageiro: ");
                        cpf = ler.nextLong();
                        Passageiro p2 = sistema.locPassageiro(cpf);
                        if(p2 !=null){
                            int tam = sistema.listarVoo().size();
                            ArrayList<Voo> voos = sistema.listarVoo();
                            Voo[] arrayVoos = voos.toArray(new Voo[tam]);
                            for(int i = 1 ; i <= tam; i++){
                                System.out.println(i + arrayVoos[i-1].toString());
                            }
                            int escolhido = ler.nextInt();
                            ler.nextLine();
                            Voo v2 = arrayVoos[escolhido-1];
                            if(v2!= null){
                                System.out.println("Assento: ");
                                String assento = ler.nextLine();
                                sistema.emitirBilhete(v2, p2, assento);
                            }

                        } break;
                    case 6:
                        int tam = sistema.listarVoo().size();
                        ArrayList<Voo> voos = sistema.listarVoo();
                        Voo[] arrayVoos = voos.toArray(new Voo[tam]);
                        for(int i = 1 ; i <= tam; i++){
                            System.out.println(i + arrayVoos[i-1].toString());
                        }
                        int escolhido = ler.nextInt();
                        Voo v3 = arrayVoos[escolhido-1];
                        if(v3!= null){
                            System.out.println(sistema.listarPassageeiroVoo(v3)); break;
                        }
                    case 7: 
                        status = false; break;      
            }
        }
    }
    
}
