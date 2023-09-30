/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.batalhanaval;

/**
 *
 * @author Marcus
 */
public class Jogadores extends BatalhaNaval {

  public Jogadores() {
    criaTabuleiros();
  }

  public void jogar() {
    posicionaNaviosTabuleiros();
    while (true) {
      atirar(1);
      imprimir(1);
      if (checaFimDeJogo()) {
        System.out.println("-----Jogador 1 ganhou!------");
        break;
      }
      atirar(2);
      imprimir(2);
      if (checaFimDeJogo()) {
        System.out.println("-----Jogador 2 ganhou!------");
        break;
      }
    }
  }

  public void posicionaNaviosTabuleiros() {
    System.out.println("-------Posicionamento de navios: Jogador 1-------");
    posicionaNavios(getTabuleiro(1), 1, 1);
    System.out.println("-------Posicionamento de navios: Jogador 2-------");
    posicionaNavios(getTabuleiro(2), 2, 2);
   
  }

}
