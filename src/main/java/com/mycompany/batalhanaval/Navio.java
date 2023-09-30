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
public class Navio {
  private String tipoNavio;
  private Bloco[] blocosOcupados;
  private int blocosAtivos;
  private String representacao;

  public Navio(String tipoNavio, int numeroBlocosOcupados, String representacao) {
      carregaNavio(tipoNavio,numeroBlocosOcupados, representacao);
  }

  public void decrementablocos(){
      blocosAtivos--;
  }

  public void carregaNavio(String tipoNavio, int numeroBlocosOcupados, String representacao) {
      this.tipoNavio = tipoNavio;
      blocosOcupados = new Bloco[numeroBlocosOcupados];
      blocosAtivos = numeroBlocosOcupados;
      this.representacao = representacao;
  }
  
  public int getBlocosAtivos(){
      return blocosAtivos;
  }
  
  public int tamanhoNavio(){
      return blocosOcupados.length;
  }
  
  public boolean naviosAbatidos(){
  if(blocosAtivos==0)
          return true;
      return false;
  }
  
  public String getTipo(){
      return tipoNavio;
  }

  public void posicionaNavio(int linha, int coluna, char orientacao, Tabuleiro tabuleiro) throws Exception{
      int tamanho = 8;
      orientacao = 'h';
      if(coluna>tamanho || linha>tamanho || linha<1 || coluna<1)
          throw new Exception ("Posição ultrapassa o tabuleiro, tente novamente!");
      
      
      if(orientacao=='h'){
          if (coluna+blocosOcupados.length-1>tamanho){
              throw new Exception ("Posição ultrapassa o tabuleiro, tente novamente!");
          }
          for(int i=0;i<blocosAtivos;i++){
              Bloco blocoAuxiliar=tabuleiro.getBloco(linha-1,coluna+i-1);
              if (!blocoAuxiliar.getConteudo().equals("xXx")){
                  throw new Exception("Posição ocupada no tabuleiro, tente novamente!");                 
              }
          }
          for(int i=0;i<blocosAtivos;i++){
              Bloco blocoAuxiliar=tabuleiro.getBloco(linha-1,coluna+i-1);
              blocoAuxiliar.setConteudo(representacao);
              blocosOcupados[i]=blocoAuxiliar;
          }        
      }
  else
    throw new Exception("Orientação inválida, tente novamente!");
  }

  public boolean blocosOcupados(Bloco bloco){
      for(int i=0;i<blocosOcupados.length;i++)
          if(blocosOcupados[i]==bloco)
              return true;
      return false;
  }


}
