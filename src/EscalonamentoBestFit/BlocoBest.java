package EscalonamentoBestFit;

import java.awt.Color;
import java.util.ArrayList;

import Escalonador.Bloco;
import Escalonador.Processo;

public class BlocoBest extends Bloco {
	private ArrayList<Processo> processos = new ArrayList<Processo>(); // LISTA DE PROCESSOS DO BLOCO
	private int tamanhoLivre = tamanho; // TAMANHO LIVRE DO BLOCO
	public BlocoBest(int bytes) {
		super(bytes); // CHAMA O CONSTRUTOR DE BLOCO
	}
	
	public boolean alocarProcesso(Processo processoASerAlocado){ // ALOCAR PROCESSO NO BLOCO
		tamanhoLivre -= processoASerAlocado.getRequisicao(); // DIMINUI O TAMANHO DISPONIVEL
		processos.add(processoASerAlocado); // ADICIONA O PROCESSO ALOCADO
		txtAreaBlocos.setText(toString()); // ATUALIZA AS INFO DO BLOCO QUANDO ALOCA O PROCESSO
		txtAreaBlocos.setBackground(new Color(255, 99, 71)); // POE COR VERMELHA NO BLOCO
		return true; // RETORNA VERDADEIRO PQ INSERIU COM SUCESSO
	}
	
	public boolean desalocarProcesso(Processo processoASerDesalocado){ //DESALOCA O PROCESSO DO BLOCO
		for(Processo processo: processos){ // PERCORRE TODOS OS PROCESSOS 
			if(processo.equals(processoASerDesalocado)){ // VERIFICA SE O PROCESSO É O PROCESSO QUE QUERO DESALOCAR
				tamanhoLivre += processoASerDesalocado.getRequisicao(); // AUMENTA O TAMANHO LIVRE POIS É UM PROCESSO A MENOS
				processos.remove(processo); // REMOVE O PROCESSO DA LISTA
				if(processos.size() == 0) { // VEIRIFICA SE É O ULTIMO PROCESSO, SE FOR ENTRA
					this.txtAreaBlocos.setText(toString()); // ATUALIZA AS INFO DO BLOCO QUANDO DESALOCA O PROCESSO
					this.txtAreaBlocos.setBackground(new Color(102, 204, 102)); // RETORNA A COR VERDE AO BLOCO
				}
				return true; // RETORNA TRUE SE DESALOCOU
			}
		}
		
		return false; // RETORNA FALSE SE CASO N TENHA DESALOCADO
	}
	public int getTamanhoLivre() { // RETORNA O TAMANHO LIVRE DO BLOCO
		return tamanhoLivre;
	}
	
	public ArrayList<Processo> getProcessos(){ // RETORNA A LISTA DE PROCESSOS
		return processos;
	}
	
	public String toString(){  // STATUS DO BLOCO EM FORMATO DE STRING 
		String retorno = "Bytes = "+tamanho+"\nProcesso = "; // CRIA UMA STRING RETORNO E ADICIONA O TAMANHO DO BLOCO
		if(processos != null){ // VERIFICA SE A LISTA TA CRIADA ( CORRECAO DE UM ERRO AI )
			if(!processos.isEmpty()) { // VERIFICA SE A LISTA ESTA VAZIA
				for(Processo processo: processos) retorno += processo.id+" | "; // ADICIONA TODOS OS ID DOS PROCESSOS DO BLOCO
			}		else{
				retorno += "Sem processo"; // SE NAO TIVER PROCESSO ADICIONA NULO
			}

		}
		else{ // SE NAO TIVER CRIADA ENTRA,
			retorno += "Sem processo"; // SE NAO TIVER PROCESSO ADICIONA NULO
		}
		retorno += "\nTamanho Disponivel: "+tamanhoLivre; // POE O TAMANHO DISPONIVEL NA STRING
		return retorno; // RETORNA A STRING RETORNO
	}
	
	public boolean temProcessos(){ // RETORNA TRUE CASO TENHA PROCESSOS NO BLOCO
		return !processos.isEmpty();
	}

}
