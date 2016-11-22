package EscalonamentoRoundRobin;


public class Estatistica {

	private int bytes; // BYTES CORRESPONDENTE DESSA ESTATISTICA
	private int hit; // HITS É O NUMERO DE BLOCOS EXISTENTES NESSA ESTATISTICA
	
	public Estatistica(int bytes) { // RECEBE UMA QUANTIDADE DE BYTES EM INTEIRO
		super();
		this.bytes = bytes;
		this.hit = 0;
	}

	public int getBytes() { // RETORNA A QUANTIDADE DE BYTES CORRESPONDENTE DESSA ESTATISTICA
		return bytes;
	}


	public int getHit() { // RETORNA O NUMERO DE HITS DESSA ESTATISTICA
		return hit;
	}

	public void hit() { // DA UM HIT NA ESTATISTICA, ADICIONA + 1 BLOCO 
		this.hit++;
	}
	
	public void zerarHit(){ // ZERA OS HITS DA ESTATISSTICA
		this.hit = 0;
	}
	
	public String toString(){ // CRIA O TOSTRING, VERSAO STRING DA ESTATISTICA
		return "(Bytes = "+this.bytes+" | hits = "+this.hit+")";
	}
	
	
	
}
