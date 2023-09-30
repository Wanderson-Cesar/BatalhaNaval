/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.batalhanaval;

import java.util.Scanner;

/**
 *
 * @author Marcus
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		int contador = 0;
		while(contador >= 0){

			System.out.println("-----------------------------------------");
			System.out.println("          BATALHA NAVAL TABAJARA          ");
                        System.out.println("-----------------------------------------");
                        System.out.println("INSTRUÇÕES");
			System.out.println("Multiplayer: Jogador 1 vs Jogador 2");
                        System.out.println("Tabuleiro: 8x8 Linhas/Colunas");
                        System.out.println("Armas: Submarino(3), Cruzador(2), Porta-aviões(1) ");
			System.out.println("Tiros: 2 por rodada");
			System.out.println("-----------------------------------------");
                        System.out.println("Digite 1 para INICIAR o Jogo");
                        System.out.println("Digite 7 para SAIR do Jogo");

                        int estado = teclado.nextInt();

			if(estado == 1){
                                
                            Jogadores jogoJogadores = new Jogadores();

                            jogoJogadores.jogar();
			}
                        
			if(estado != 1 && estado != 7){
				System.out.println("Opção Inválida, tente novamente");}
                        if(estado == 7){
				break;
			}
                        
                        contador++;
		}
	}
       
    }
    

