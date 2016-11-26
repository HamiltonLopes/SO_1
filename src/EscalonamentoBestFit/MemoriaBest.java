package EscalonamentoBestFit;

import java.util.ArrayList;

import Escalonador.Memoria;

public class MemoriaBest extends Memoria {
	public static int MEMORIA_DISPONIVEL = MEMORIA_TOTAL; // MEMORIA DISPONIVEL PARA ALOCAR PROCESSOS
	public static int MEMORIA_BLOCOS_CRIADOS = 0; // TAMANHO TOTAL DE TODOS OS BLOCOS CRIADOS
	private static ArrayList<BlocoBest> listaDeBlocos = new ArrayList<BlocoBest>(); // LISTA INICIAL DOS BLOCOS
	
	
	
	public static ArrayList<BlocoBest> getListaDeBlocos(){ // RETORNA A LISTA INICIAL DOS BLOCOS
		return listaDeBlocos;
	}
	
	public static BlocoBest criarBloco(int bytes){ // CRIA UM BLOCO
		if((MEMORIA_BLOCOS_CRIADOS + bytes) <= MEMORIA_TOTAL){ // VERIFICA SE TEM MEMORIA PARA CRIAR O BLOCO, SE TIVER ENTRA
			BlocoBest novoBloco = new BlocoBest(bytes); // CRIA O BLOCO
			listaDeBlocos.add(novoBloco);  // ADICIONA O BLOCO NA LISTA
			InterfaceBF.panelListadeBlocos.add(novoBloco.getJTextArea()); // ADICIONA NA INTERFACE O TXTAREA DO BLOCO
			InterfaceBF.repaintPanelTBloco(); // REPINTA A INETERFACE
			MEMORIA_BLOCOS_CRIADOS += bytes;  // AUMENTA O VALOR DA MEMORIA TOTAL DE BLOCOS CRIADOS
			return novoBloco; // RETORNA O BLOCO CRIADO
		}
		
		return null; // CASO N TENHA MEMORIA SUFICIENTE RETORNA NULL
	}
	
	public static boolean temBloco(){ // RETORNA TRUE CASO TENHA ALGUM BLOCO CRIADO
		return !listaDeBlocos.isEmpty();
	}
	public static int getMemoriaDisponivel(){ // RETORNA A MEMORIA DISPONIVEL PARA ALOCAR PROCESSOS
		return MEMORIA_DISPONIVEL;
	}
	
	public static boolean decrementarMemoria(int bytesUsados) { // DECREMENTAR MEMORIA, OU SEJA INSERE UM NOVO PROCESSO 
		if(MemoriaBest.MEMORIA_DISPONIVEL >= bytesUsados){	// SE A MEMORIA DISPONIVEL FOR SUFICIENTE PARA ALOCAR O PROCESSO, ENTRA
			MemoriaBest.MEMORIA_DISPONIVEL -= bytesUsados; // RETIRA DA MEMORIA O TAMANHO DO PROCESSO
			return true; // RETORNA VERDADEIRO SE FOI POSSIVEL RETIRAR A MEMORIA
		}
		return false; // RETORNA FALSO CASO A MEMORIA SEJA MENOR DO QUE A NECESSARIA
	}
	
	public static boolean restaurarMemoria(int bytesLivres){ // RESTAURA A MEMORIA OU SEJA, DESALOCA O PROCESSO
		if(MemoriaBest.MEMORIA_DISPONIVEL != MemoriaBest.MEMORIA_TOTAL){ // SE A MEMORIA DISPONIVEL FOR DIFERENTE DA TOTAL, ENTRA
			MemoriaBest.MEMORIA_DISPONIVEL += bytesLivres; // ADICIONA OS BYTES DO PROCESSO QUANDO ELE VAI DESALOCAR O BLOCO
			return true; // RETORNA VERDADEIRO SE DER CERTO
		}
		return false; // SE CASO A MEMORIA JA ESTEJA DO TAMANHO MAXIMO, ENTAO NAO VAI ADICIONAR POIS OUVE ALGO ERRADO
	}

}
