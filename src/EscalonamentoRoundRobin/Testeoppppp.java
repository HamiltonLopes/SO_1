package EscalonamentoRoundRobin;

import java.util.ArrayList;

public class Testeoppppp {
	public static int numListasTop = 3;
	static ArrayList<Lista> simulation = new ArrayList<Lista>();
	static ArrayList<Bloco> listaInicial = new ArrayList<Bloco>();
	public static void main(String[] args){
		ArrayList<Estatistica> estatisticas = new ArrayList<Estatistica>();
		estatisticas.add(new Estatistica(32));
		estatisticas.add(new Estatistica(64));
		estatisticas.add(new Estatistica(128));
		estatisticas.add(new Estatistica(256));
		estatisticas.add(new Estatistica(512));
		
		estatisticas.get(0).hit();
		estatisticas.get(0).hit();
		estatisticas.get(0).hit();
		estatisticas.get(0).hit();
		estatisticas.get(0).hit();
		listaInicial.add(new Bloco(32));
		listaInicial.add(new Bloco(32));
		listaInicial.add(new Bloco(32));
		listaInicial.add(new Bloco(32));
		listaInicial.add(new Bloco(32));
		
		estatisticas.get(1).hit();
		estatisticas.get(1).hit();
		estatisticas.get(1).hit();
		estatisticas.get(1).hit();
		listaInicial.add(new Bloco(64));
		listaInicial.add(new Bloco(64));
		listaInicial.add(new Bloco(64));
		listaInicial.add(new Bloco(64));
		
		estatisticas.get(2).hit();
		estatisticas.get(2).hit();
		estatisticas.get(2).hit();
		estatisticas.get(2).hit();
		estatisticas.get(2).hit();
		estatisticas.get(2).hit();
		estatisticas.get(2).hit();
		estatisticas.get(2).hit();
		estatisticas.get(2).hit();
		listaInicial.add(new Bloco(128));
		listaInicial.add(new Bloco(128));
		listaInicial.add(new Bloco(128));
		listaInicial.add(new Bloco(128));
		listaInicial.add(new Bloco(128));
		listaInicial.add(new Bloco(128));
		listaInicial.add(new Bloco(128));
		listaInicial.add(new Bloco(128));
		listaInicial.add(new Bloco(128));
		
		
		estatisticas.get(3).hit();
		estatisticas.get(3).hit();
		estatisticas.get(3).hit();
		estatisticas.get(3).hit();
		estatisticas.get(3).hit();
		estatisticas.get(3).hit();
		estatisticas.get(3).hit();
		estatisticas.get(3).hit();
		estatisticas.get(3).hit();
		listaInicial.add(new Bloco(256));
		listaInicial.add(new Bloco(256));
		listaInicial.add(new Bloco(256));
		listaInicial.add(new Bloco(256));
		listaInicial.add(new Bloco(256));
		listaInicial.add(new Bloco(256));
		listaInicial.add(new Bloco(256));
		listaInicial.add(new Bloco(256));
		listaInicial.add(new Bloco(256));
		
		estatisticas.get(4).hit();
		estatisticas.get(4).hit();
		estatisticas.get(4).hit();
		listaInicial.add(new Bloco(512));
		listaInicial.add(new Bloco(512));
		listaInicial.add(new Bloco(512));
		System.out.println(estatisticas);
		
		montarListaTop(estatisticas);
//		System.out.println(estatisticas);
		System.out.println(simulation);
		
//		montarListaTop(estatisticas);
//		System.out.println(simulation);
//		System.out.println(estatisticas);
		
	}
	public static void montarListaTop(ArrayList<Estatistica> estatisticas){
		//TESTAR CASO EU REMOVA ALGO DO ARRAY LOCAL SE MUDA O QUE FOI PASSADO POR PARAMETRO (TEORICAMENTE N DEVERIA)
		ArrayList<Lista> listaDeLista = new ArrayList<Lista>();
		for(int i = 0; i < numListasTop; i++){
			Estatistica maior = maiorEstatistica(estatisticas);
			listaDeLista.add(new Lista(maior));
			maior.zerarHit();
		}
		listaDeLista.add(new Lista(999));
		
		for(int i = 0; i < listaInicial.size(); i++){
			for(int k = 0; k < listaDeLista.size(); k++){
				if(listaInicial.get(i).getTamanho() == listaDeLista.get(k).getBytes() || k == listaDeLista.size()-1){
					listaDeLista.get(k).addBloco(listaInicial.get(i));
					k = listaDeLista.size();
				}
			}
		}
		
		
		simulation = listaDeLista;
		for(int i = 0; i < estatisticas.size(); i++){
			estatisticas.get(i).zerarHit();
		}
	}
	
	public static Estatistica maiorEstatistica(ArrayList<Estatistica> lista){
		Estatistica maior = null;
		for (int i = 0; i < lista.size(); i++) {
			if(maior != null){
				if(lista.get(i).getHit() > maior.getHit()){
					maior = lista.get(i);
				}
			}else{
				maior = lista.get(i);
			}
		}
		return maior;
	}

}
