package EscalonamentoRoundRobin;

import java.util.ArrayList;


public class Lista { // LISTA TOP

	private int bytes; // BYTES CORRESPONDENTE A LISTA TOP
	private ArrayList<Bloco> blocos= new ArrayList<Bloco>(); //BLOCOS ALOCADOS COM ESSA QUANTIDADE DE BYTES
	
	public Lista(Estatistica e) { // RECEBE UMA ESTATISTICA COMO PARAMETRO
		super();
		this.bytes = e.getBytes(); // CRIA UMA LISTA DE ACORDO COM UMA ESTATISTICA
	}
	
	public Lista(int e) { // RECEBE UMA QUANTIDADE DE BYTES EM UM INTEIRO
		super();
		this.bytes = e; // CRIA UMA LISTA DE ACORDO COM ESSE INTEIRO
	}

	public int getBytes() { // RETORNA A QUANTIDADE DE BYTES DOS BLOCOS DESSA LISTA TOP
		return bytes;
	}
	
	public boolean addBloco(Bloco bloco){ // ADICIONA UM BLOCO NA LISTA DE BLOCOS ALOCADOS
		if(bloco.getTamanho() == this.bytes){ //VERIFICA SE A QUANTIDADE DE BYTES DO BLOCO É CORRESPONDENTE COM A LISTA TOP
			blocos.add(bloco); // SE SIM ADCICIONA
			return true;	// E RETORNA TRUE PQ DEU CERTO
		}else{
			return false; // SE NÃO, NÃO FAZ NADA E RETORNA FALSE
		}
	}
	
	public ArrayList<Bloco> getBlocos(){ // RETORNA A LISTA DE BLOCOS DA LISTA TOP
		return blocos;
	}

	
	
}