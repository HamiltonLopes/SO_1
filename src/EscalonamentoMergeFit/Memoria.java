package EscalonamentoMergeFit;

import java.util.ArrayList;

import Escalonador.Bloco;



public class Memoria {
	static int MEMORIA_TOTAL = 10000; // MEMORIA TOTAL
//	private static int memoriaDisponivel = MEMORIA_TOTAL; // MEMORIA DISPONIVEL QUE INICIALMENTE É IGUAL A MEMORIA TOTAL
	private static ArrayList<Bloco> listaDeBlocos = new ArrayList<Bloco>(); // LISTA INICIAL DOS BLOCOS QUE VÃO SENDO CRIADOS ANTES DAS LISTAS TOP
	private static Bloco superBloco = new Bloco(MEMORIA_TOTAL);
//	private static ArrayList<Lista> listaDeListas = new ArrayList<Lista>(); // LISTA DE TOPS + LISTA RESTO
	
//	public static Bloco criarBloco(int bytes){ // CRIA UM BLOCO NA MEMORIA
//		if(superBloco.getTamanho() >= bytes){ // VERIFICA SE TEM MEMORIA DISPONIVEL
//			Bloco novoBloco = new Bloco(bytes);  // CASO TENHA CRIA UM NOVO BLOCO A SER ADICIONADO
//			Memoria.listaDeBlocos.add(novoBloco);  // ADICIONA ESSE BLOCO NA LISTA INICIAL
////			if(Memoria.existeListaTop()){ // VERIFICA SE A LISTA DE TOPS JA FOI CRIADA
////				for (int i = 0; i < Memoria.listaDeListas.size(); i++) { // SE JA TIVER SIDO, VOU PERCORRER TODAS AS LISTAS 
////					if(Memoria.listaDeListas.get(i).getBytes() == bytes || i == Memoria.listaDeListas.size()-1){ 
////						// VERIFICO SE O TAMANHO DO BLOCO NOVO É UM DOS TAMANHOS TOPS, CASO SEJA ENTRA, CASO NAO SEJA ENTRA TAMBÉM MAS COMO LISTA DE RESTO
////						Memoria.listaDeListas.get(i).addBloco(novoBloco); // ADICIONO NA LISTA O NOVO BLOCO
////						return novoBloco;
////					}
////				}
////			}
//			return novoBloco; // RETORNA O BLOCO NOVO QUE FOI ADICIONADO 
//		}
//		return null; // SE NAO TIVER MEMORIA DISPONIVEL RETORNA NULL
//	}
	
	public static Bloco splitSuperBloco(int bytesNewBloco){ // REALIZA O SPLIT DO SUPERBLOCO PARA GERAR O NOVO BLOCO
		if(superBloco.getTamanho() >= bytesNewBloco){ // VERIFICA SE O SUPERBLOCO TEM TAMANHO SUFICIENTE PARA SER DIVIDIDO
			Bloco novoSuperBloco = new Bloco(superBloco.getTamanho()-bytesNewBloco); // CRIA UM NOVO SUPERBLOCO COM O TAMANHO DIVIDIDO
			Bloco novoBloco = new Bloco(bytesNewBloco); // CRIA O NOVO BLOCO COM O TAMANHO DESEJADO
			setSuperBloco(novoSuperBloco); // ATUALIZA O SUPERBLOCO
			Memoria.listaDeBlocos.add(novoBloco); // ADICIONA O NOVO BLOCO NA LISTA DE BLOCOS
			return novoBloco; // RETORNA ESSE NOVO BLOCO
		} 
		return null; // RETORNA NULL CASO O NAO TENHA MEMORIA SUFICIENTE
	}
	
	public static boolean mergeSuperBloco(Bloco blocoExcluido){ // REALIZA O MERGE DO SUPERBLOCO COM O BLOCO ANTIGO
		if(superBloco.getTamanho() < MEMORIA_TOTAL){ // VERIFICA SE O SUPERBLOCO NAO ESTÁ COM O TAMANHO MAXIMO
			Bloco novoSuperBloco = new Bloco(superBloco.getTamanho()+blocoExcluido.getTamanho()); // SE NAO FOR O TAMANHO MAXIMO, CRIA O NOVO SUPERBLOCO COM A SOMA DO ANTIGO E O SUPERBLOCO ATUAL
			setSuperBloco(novoSuperBloco); // ATUALIZA O NOVO SUPERBLOCO
			blocoExcluido.desalocarProcesso(); // DESALOCA O PROCESSO DO BLOCO
			Memoria.listaDeBlocos.remove(blocoExcluido); // REMOVE O BLOCO EXCLUIDO DA LISTA DE BLOCOS
			return true; // RETORNA VERDADEIRO PQ FEZ O MERGE COM SUCESSO
		}
		return false; // RETORNA FALSE SE O BLOCO JA ESTA COM MEMORIA TOTAL
	}
	
//	public static int getMemoriaDisponivel() { 	// RETORNA A MEMORIA DISPONIVEL
//		return memoriaDisponivel;
//	}
//	public static boolean decrementarMemoria(int bytesUsados) { // DECREMENTAR MEMORIA, OU SEJA INSERE UM NOVO PROCESSO 
//		if(Memoria.memoriaDisponivel >= bytesUsados){	// SE A MEMORIA DISPONIVEL FOR SUFICIENTE PARA ALOCAR O PROCESSO, ENTRA
//			Memoria.memoriaDisponivel -= bytesUsados; // RETIRA DA MEMORIA O TAMANHO DO PROCESSO
//			return true; // RETORNA VERDADEIRO SE FOI POSSIVEL RETIRAR A MEMORIA
//		}
//		return false; // RETORNA FALSO CASO A MEMORIA SEJA MENOR DO QUE A NECESSARIA
//	}
	
//	public static boolean restaurarMemoria(int bytesLivres){ // RESTAURA A MEMORIA OU SEJA, DESALOCA O PROCESSO
//		if(Memoria.memoriaDisponivel != Memoria.MEMORIA_TOTAL){ // SE A MEMORIA DISPONIVEL FOR DIFERENTE DA TOTAL, ENTRA
//			Memoria.memoriaDisponivel += bytesLivres; // ADICIONA OS BYTES DO PROCESSO QUANDO ELE VAI DESALOCAR O BLOCO
//			return true; // RETORNA VERDADEIRO SE DER CERTO
//		}
//		return false; // SE CASO A MEMORIA JA ESTEJA DO TAMANHO MAXIMO, ENTAO NAO VAI ADICIONAR POIS OUVE ALGO ERRADO
//	}
	public static int getMemoriaTotal() { // RETORNA A MEMORIA TOTAL 
		return Memoria.MEMORIA_TOTAL;
	}
	
//	public static boolean existeListaTop(){ // RETORNA TRUE CASO A LISTA DE TOPS EXISTA
//		return !listaDeListas.isEmpty();
//	}
	
	public static boolean existeListaInicial(){ //RETORNA TRUE CASO A LISTA INICIAL JA EXXISTA
		return !listaDeBlocos.isEmpty();
	}
	
	public static ArrayList<Bloco> getListaDeBlocos(){ // RETORNA A LISTA INICIAL DOS BLOCOS
		return listaDeBlocos;
	}

	public static void start() { // STARTA A MEMORIA
		listaDeBlocos.add(superBloco); // ADICIONA O SUPERBLOCO NA LISTA
	}

	public static Bloco getSuperBloco() { // RETORNA O SUPERBLOCO
		return superBloco;
	}

	public static void setSuperBloco(Bloco superBloco) { // ATUALIZA O SUPERBLOCO
		Memoria.superBloco = superBloco;
	}
	
	
//	public static ArrayList<Lista> getListadeListas(){ // RETORNA A LISTA DE TOPS
//		return listaDeListas;
//	}
	
//	public static void setListaDeListas(ArrayList<Lista> listaDeListas){ // ALTERA A LISTA DE TOPS
//		Memoria.listaDeListas = listaDeListas;
//	}
}
