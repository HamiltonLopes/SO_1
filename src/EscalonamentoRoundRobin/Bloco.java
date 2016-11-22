package EscalonamentoRoundRobin;

public class Bloco { 
	private int tamanho; // TAMANHO DO BLOCO EM BYTES
	private Processo processoDoBloco; // PROCESSO NO BLOCO ( SE TIVER )
	
	public Bloco (int bytes){ // AO CRIAR UM BLOCO RECEBE UM TAMANHO EM BYTES
		this.tamanho = bytes; // ALIMENTA O TAMANHO
		this.processoDoBloco = null; // INICIA A VARIAVEL PROCESSO NO BLOCO COM NULL
	}
	
	public boolean alocarProcesso(Processo processoASerAlocado){ // RECEBE UM PROCESSO PARA OCUPAR O BLOCO
		if(this.processoDoBloco == null){ // SE O PROCESSO FOR NULO, ENTRA 
			processoDoBloco = processoASerAlocado; // ALOCA O PROCESSO NO BLOCO
			return true; // RETORNA TRUE PQ DEU CERTO
		}
		return false; // SE JA TIVER PROCESSO NO BLOCO ELE RETORNA FALSO, PQ ANTES TEM Q DESALOCAR
	}
	
	public Processo getProcesso(){ // RETORNA O PROCESSO ALOCADO NO BLOCO
		return processoDoBloco; // RETORNA NULL CASO N�O TENHA UM PROCESSO ALOCADO NO BLOCO
	}
	
	public boolean desalocarProcesso(){ // DESALOCA O PROCESSO DO BLOCO (DEIXA ELE LIVRE)
		if(this.processoDoBloco != null){ // SE EXISTIR UM PROCESSO NO BLOCO, ENTRA
			processoDoBloco = null; // COLOCA O PROCESSO PARA NULO (LIBERA)
			return true; // RETORNA TRUE PQ DEU TD CERTO
		}
		return false; // SE NÃO TIVER PROCESSO NO BLOCO RETORNA FALSO, PQ N TEM PROCESSO PARA DESALOCAR
	}

	public int getTamanho() { // RETORNA O TAMANHO DO BLOCO
		return tamanho; // EM BYTES
	}
	
	public boolean isLivre(){ // RETORNA VERDADEIRO SE O BLOCO ESTIVER LIVRE
		return processoDoBloco == null; // SE O PROCESSO FOR NULO ENTÃO É PQ O BLOCO TA LIVRE
	}
	
	public String toString(){ // RETORNA O BLOCO EM FORMATO DE STRING
		String retorno = "Bytes = "+tamanho+"\nProcesso = "; // CRIA UMA STRING RETORNO E ADICIONA O TAMANHO DO BLOCO
		if(processoDoBloco != null) retorno += processoDoBloco.id; // ADICIONA O ID DO PROCESSO SE TIVER PROCESSO
		else retorno += "null"; // SE NAO TIVER PROCESSO ADICIONA NULO
		retorno += "\nEstado = "; // ADICIONA O ESTADO DO PROCESSO
		if(this.isLivre()) retorno += "Livre"; // SE ESTIVER LIVRE ADICIONA LIVRE
		else retorno += "Ocupado"; // CASO NAO ESTEJA ADICIONA OCUPADO
		
		return retorno; // RETORNA A STRING RETORNO
	}

}
