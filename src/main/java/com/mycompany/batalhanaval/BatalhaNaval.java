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
import java.util.Scanner;

public class BatalhaNaval {
    private Tabuleiro tabuleiro1;
    protected Tabuleiro tabuleiro2;
    private boolean fimDeJogo;
	
	
    public void posicionaNavios(Tabuleiro tabuleiro, int numTabuleiro, int jogador){

        boolean continuaExcecao;
        System.out.println("ATENÇÃO: Você tem direito a 3 Submarinos, 2 Cruzadores e 1 Porta-aviões");
        int linha;
        int coluna;
        char orientacao;
        Navio[] naviosAuxiliar=tabuleiro.getNavio();
        for(int i=0;i<naviosAuxiliar.length;i++){
            continuaExcecao=true;
			
            while (continuaExcecao){
				try{
					System.out.println("Posicione um " + naviosAuxiliar[i].getTipo()+ ", que ocupa " + naviosAuxiliar[i].tamanhoNavio()+" bloco(s) no tabuleiro.");
					Scanner teclado=new Scanner(System.in);
					try {	
                                            	System.out.println("Linha(1-8):  ");
						linha=teclado.nextInt();
                                                System.out.println("Coluna(1-8): ");
						coluna=teclado.nextInt();
					} catch (Exception e) {
						System.out.println("Digite apenas números para posicionar o navio, tente novamente.");
						continue;
					}
                                        System.out.println(""+ naviosAuxiliar[i].getTipo()+ " posicionado com sucesso!");
					orientacao = 'h';
					naviosAuxiliar[i].posicionaNavio(linha,coluna,orientacao,tabuleiro);
					continuaExcecao = false;
					imprimir(numTabuleiro);
				} catch (Exception e) {
					System.out.println(e.getMessage());    
				}        
			}
        }
    }  
    
    public void setTabuleiro(int numTabuleiro,Tabuleiro tabuleiro){
		if(numTabuleiro==1)
			tabuleiro1=tabuleiro;
		else
			tabuleiro2=tabuleiro;
	}
	
	public void setFimDeJogo(boolean fimDeJogo){
		this.fimDeJogo=fimDeJogo;
	}
	
	public void criaTabuleiros(){
		boolean continuaExcecao=true;
        while (continuaExcecao){
			try{
				setTabuleiro(1,new Tabuleiro());
				setTabuleiro(2,new Tabuleiro());
				setFimDeJogo(false);
				continuaExcecao=false;
			}
			catch (Exception e){
				System.out.println(e.getMessage());
			}
		}
	}

	public Tabuleiro escolherTabuleiro(int tabuleiro){
		if(tabuleiro==1)
			return tabuleiro1;
		return tabuleiro2;
	}
	
	public void atirarNoBloco(int linha, int coluna, Tabuleiro tabuleiro)throws Exception{
		Bloco celula=tabuleiro.getBloco(linha-1,coluna-1);
		if(celula.getTiro())
			throw new Exception("Este bloco já foi atingido, tente novamente!");
		celula.setTiro();
		if(celula.getConteudo().equals(" O "))
			tabuleiro.atirar(celula);
	}
	
    public void darTiro(int linha, int coluna,int tabuleiro) throws Exception{
        Tabuleiro tabuleiroAuxiliar=escolherTabuleiro(tabuleiro);
        if (coluna>tabuleiroAuxiliar.tamanhoTabuleiro() || linha>tabuleiroAuxiliar.tamanhoTabuleiro() || linha<1 || coluna<1){
			throw new Exception ("Alvo fora do tabuleiro, tente novamente!");
		}
        atirarNoBloco(linha,coluna,tabuleiroAuxiliar);
        checaNumeroNavios(tabuleiro);
    }
	
    public void checaNumeroNavios(int tabuleiro){
        Tabuleiro tabuleiroAuxiliar;
		if(tabuleiro==1)
			tabuleiroAuxiliar=tabuleiro1;
		else 
			tabuleiroAuxiliar=tabuleiro2;
		if(tabuleiroAuxiliar.gettotalNavios()==0){
			setFimDeJogo(true);
		}
    }

    public boolean checaFimDeJogo(){
        if(fimDeJogo)
            return true;
        return false;
    }
    
    public Tabuleiro getTabuleiro(int tabuleiro){
        if(tabuleiro == 1)
            return tabuleiro1;
        return tabuleiro2;
    }
    
	public int[] solicitaPosicao(int jogador){
		boolean pede=true;
		int[] coordenadas=new int[2];
		System.out.println("----Sua vez de atirar: Jogador " + jogador + "----");
		while(pede){
			try{
				Scanner teclado=new Scanner(System.in);
				System.out.println("Escolha a posição do seu alvo.");
                                System.out.println("Linha(1-8):  ");
				coordenadas[0]=teclado.nextInt();
                                System.out.println("Coluna(1-8): ");
				coordenadas[1]=teclado.nextInt();
				pede=false;
			} catch (Exception e){
				System.out.println("Digite apenas números para posição, tente novamente!");
			}
		}
		return coordenadas;		
	}

	public void atirar(int jogador){
		boolean continuaAtirando=true;
		int[] coordenadas=new int[2];
		while(continuaAtirando){
			try{
				coordenadas=solicitaPosicao(jogador);
				if(jogador==1)
					darTiro(coordenadas[0],coordenadas[1],2);
				else
					darTiro(coordenadas[0],coordenadas[1],1);
				continuaAtirando=false;
			} catch (Exception e){
				System.out.println(e.getMessage());
			}
		}
	}
	
    
    public void imprimirAuxiliar(){
        Tabuleiro tabuleiroAuxiliar=getTabuleiro(1);
		System.out.print("  ");
        for(int j=0;j<tabuleiroAuxiliar.tamanhoTabuleiro();j++)
                System.out.print("|---");
            System.out.print("|");
    }
    
    public void imprimir(){
        imprimirAuxiliar();
        System.out.print("  ");
        imprimirAuxiliar();
    }
	
	public void imprimir(int tabuleiro){
		System.out.println("      Seu Tabuleiro Jogador " + tabuleiro +"           Tabuleiro do Jogador Adversário");		
		if(tabuleiro==1){
			imprimirTabuleiro(tabuleiro1,tabuleiro2);
			System.out.println();
		}
		else{
			imprimirTabuleiro(tabuleiro2,tabuleiro1);
			System.out.println();
		}
	}
	
	public void imprimirTabuleiro(Tabuleiro tabuleiro,Tabuleiro tabuleiroAuxiliar){
		indicesSuperiores(tabuleiro.tamanhoTabuleiro());		
		for(int i=0;i<tabuleiro.tamanhoTabuleiro();i++){
			imprimir();
			System.out.println();
			System.out.print((i+1)+ " ");
			for(int j=0;j<tabuleiro.tamanhoTabuleiro();j++){
				System.out.print("|");
				tabuleiro.getBloco(i,j).imprimir();
			}
			System.out.print("|  ");
			System.out.print("  ");
			for(int j=0;j<tabuleiroAuxiliar.tamanhoTabuleiro();j++){
				System.out.print("|");
				tabuleiroAuxiliar.getBloco(i,j).imprimirAuxiliar();
			}
			System.out.println("|");
		}
		imprimir();
		System.out.println();
	}
	
	public void indicesSuperiores(int indiceMax){
		System.out.print("  ");		
		indiceSuperior(indiceMax);
		System.out.print("     ");
		indiceSuperior(indiceMax);
		System.out.println();
	}
	
	public void indiceSuperior(int indiceMax){
		for(int i=1;i<=indiceMax;i++)
			System.out.print("  "+ i + " ");
	}

	
	
	
}
