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
public class Bloco {
  /*
   * O atributo nuvem ajuda na impressao:
   */
  private String nuvem = "   ";
  private String conteudo;
  private boolean tiro;

  public Bloco() {
    tiro = false;
    setConteudo("xXx");
  }

  /*
   * Aqui vamos ter agua (~~~) ou navio ( N ), ou ate mesmo x ( X ) que indica um
   * navio afundado.
   */
  public void setConteudo(String conteudo) {
    this.conteudo = conteudo;
  }

  public String getConteudo() {
    return conteudo;
  }

  public boolean getTiro() {
    return tiro;
  }

  public void setTiro() {
    if (conteudo != "xXx")
      conteudo = " O ";
    tiro = true;
  }

  public String getNuvem() {
    return nuvem;
  }

  /*
   * Ha dois metodos de impressao, pois devemos conseguir ver nosso tabuleiro e
   * tambem
   * ter um tabuleiro suporte para ver onde ja atiramos pra nao dar tiro no mesmo
   * lugar
   */
  public void imprimir() {
    System.out.print(getConteudo());
  }

  public void imprimirAuxiliar() {
    if (tiro)
      System.out.print(getConteudo());
    else
      System.out.print(getNuvem());
  }
}
