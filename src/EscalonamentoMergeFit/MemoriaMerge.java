package EscalonamentoMergeFit;

import java.util.ArrayList;

import Escalonador.Bloco;
import Escalonador.Memoria;



public class MemoriaMerge extends Memoria{
	private static ArrayList<Bloco> listaDeBlocos = new ArrayList<Bloco>(); // LISTA INICIAL DOS BLOCOS QUE VÃƒO SENDO CRIADOS ANTES DAS LISTAS TOP
	private static Bloco superBloco = new Bloco(MEMORIA_TOTAL); // CRIA O SUPER BLOCO COM A MEMORIA TOTAL
	
	public static Bloco splitSuperBloco(int bytesNewBloco){ // REALIZA O SPLIT DO SUPERBLOCO PARA GERAR O NOVO BLOCO
		if(superBloco.getTamanho() >= bytesNewBloco){ // VERIFICA SE O SUPERBLOCO TEM TAMANHO SUFICIENTE PARA SER DIVIDIDO
			Bloco novoSuperBloco = new Bloco(superBloco.getTamanho()-bytesNewBloco); // CRIA UM NOVO SUPERBLOCO COM O TAMANHO DIVIDIDO
			Bloco novoBloco = new Bloco(bytesNewBloco); // CRIA O NOVO BLOCO COM O TAMANHO DESEJADO
			setSuperBloco(novoSuperBloco); // ATUALIZA O SUPERBLOCO
			MemoriaMerge.listaDeBlocos.add(novoBloco); // ADICIONA O NOVO BLOCO NA LISTA DE BLOCOS
			return novoBloco; // RETORNA ESSE NOVO BLOCO
		} 
		return null; // RETORNA NULL CASO O NAO TENHA MEMORIA SUFICIENTE
	}
	
	public static boolean mergeSuperBloco(Bloco blocoExcluido){ // REALIZA O MERGE DO SUPERBLOCO COM O BLOCO ANTIGO
		if(superBloco.getTamanho() < MEMORIA_TOTAL){ // VERIFICA SE O SUPERBLOCO NAO ESTÃ� COM O TAMANHO MAXIMO
			Bloco novoSuperBloco = new Bloco(superBloco.getTamanho()+blocoExcluido.getTamanho()); // SE NAO FOR O TAMANHO MAXIMO, CRIA O NOVO SUPERBLOCO COM A SOMA DO ANTIGO E O SUPERBLOCO ATUAL
			setSuperBloco(novoSuperBloco); // ATUALIZA O NOVO SUPERBLOCO
			blocoExcluido.desalocarProcesso(); // DESALOCA O PROCESSO DO BLOCO
			MemoriaMerge.listaDeBlocos.remove(blocoExcluido); // REMOVE O BLOCO EXCLUIDO DA LISTA DE BLOCOS
			return true; // RETORNA VERDADEIRO PQ FEZ O MERGE COM SUCESSO
		}
		return false; // RETORNA FALSE SE O BLOCO JA ESTA COM MEMORIA TOTAL
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

	private static void setSuperBloco(Bloco superBloco) { // ATUALIZA O SUPERBLOCO
		MemoriaMerge.superBloco = superBloco;
	}
	
}
