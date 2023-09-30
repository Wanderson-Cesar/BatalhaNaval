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
//lembrar de tirar comentarios antes da apresentação


public class Tabuleiro {
	private Bloco[][] tabuleiro;
	private Navio[] navios;
	private int totalNavios;
	/*	Construtor que cria a matriz e chama um metodo para colocar Celulas nessa matriz,
		pois criar a matriz apenas cria uma matriz de nulls
		O construtor tambem cria os navios 
	*/
	public Tabuleiro (){
		int tamanho = 8;
		tabuleiro=new Bloco[tamanho][tamanho];
		carregarBlocos(tamanho);
		carregarNavios();
	}
	public Bloco getBloco(int linha, int coluna){
		return tabuleiro[linha][coluna];
	}
	/*	Retorna a quantidade de navios que ainda restam 
	*/
	public Navio[] getNavio(){
		return navios;
	}	

	public int gettotalNavios(){
		return totalNavios;
	}
	
	public int tamanhoTabuleiro(){
		return tabuleiro.length;
	}
	/*	Esse metodo  apenas cria celulas e as põe na matriz
	*/
	public void carregarBlocos(int tamanho){
		for(int i=0;i<tamanho;i++)
			for(int j=0;j<tamanho;j++)
				tabuleiro[i][j]=new Bloco();
	}
	/*	Esse metodo apenas cria os navios
	*/
	public void carregarNavios(){
		navios=new Navio[6];
		int i=0;
		for(i=0;i<3;i++)
                    navios[i]=new Submarino();
		for(i=3;i<5;i++)
                    navios[i]=new Cruzador();
		for(i=5;i<6;i++)
                    navios[i]=new PortaAvioes();
		totalNavios=6;
	}
	/*	Metodo que pergunta se o navio passado como parametro foi afundado: se foi ele decrementa o 
		numero de navios ativos
	*/
	public void naviosAbatidos(Navio navio){
		if(navio.naviosAbatidos()){
			totalNavios--;
			System.out.println(navio.getTipo()+" abatido!");
		}
               
	}
	/*	Ao darmos um tiro devemos saber qual navio atingimos. O metodo abaixo faz isso: procura a 
		qual navio a bloco passada como parametro pertence, de outra forma, vê se a bloco do parametro
		bate com alguma ocupada pelo navio. Isso e feito pra cada navio do jogo, isto e, para cada navio 
		no vetor navios
	*/
	public Navio alvo(Bloco bloco){
		int i;
		for(i=0;i<navios.length;i++){
			if(navios[i].blocosOcupados(bloco))
				break;
		}
		return navios[i];
	}
	/*	Aqui sabemos que a bloco do parametro e de algum navio. Entao procuramos esse navio alvo, depois 
		diminuimos o numero de celulas ativas dele, pois acertamos uma, e por ultimo checamos se ele afundou
		com esse tiro
	*/
	public void atirar(Bloco bloco){
		Navio navioAux=alvo(bloco);
		navioAux.decrementablocos();
		naviosAbatidos(navioAux);
	}
	/*	Metodo para auxiliar na hora de dar um tiro: o metodo dar tiro ficara numa classe diferente
		poir isso que temos que conseguir passar a celula para tal classe
	*/
	

}