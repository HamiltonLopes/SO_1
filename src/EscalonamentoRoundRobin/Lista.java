package EscalonamentoRoundRobin;

import java.util.ArrayList;


public class Lista { // LISTA TOP ( SE A QUANTIDADE DE BYTES FOR 999 INDICA FILA RESTO )

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
		}
		return false; // SE NÃO, NÃO FAZ NADA E RETORNA FALSE
	}
	
	public ArrayList<Bloco> getBlocos(){ // RETORNA A LISTA DE BLOCOS DA LISTA TOP
		return blocos;
	}
	
	public boolean temBlocoLivre(){ // RETORNA TRUE CASO A LISTA TOP TENHA PELO MENOS UM BLOCO LIVRE
		for(Bloco bloco : blocos){ // PERCORRE OS BLOCOS
			if(bloco.isLivre()) return true; // CASO O BLOCO SEJA LIVRE RETORNA TRUE
		}
		return false; // SE CHEGOU AQUI � PQ NENHUM BLOCO � LIVRE, LOGO � FALSO
	}
	
	public String toString(){ // TO STRING DA LISTA 
		String retorno = "(";
		if(this.bytes != 999){
			retorno += "Bytes = "+this.bytes;
		}else{
			retorno += "Lista Resto";
		}
		
		return retorno += " "+blocos+")"; // RETORNA A LISTA EM UMA STRING
		
	}

	
	
}