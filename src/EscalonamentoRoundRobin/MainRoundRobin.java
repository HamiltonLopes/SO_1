package EscalonamentoRoundRobin;

import java.awt.Color;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JTextArea;

import FIFO.Fila;

public class MainRoundRobin extends Thread {

	static ArrayList<Processo> listaTerminados = new ArrayList<Processo>();
	static ArrayList<Core> listaCores = new ArrayList<Core>();

	static Fila q4 = new Fila();
	static Fila q3 = new Fila();
	static Fila q2 = new Fila();
	static Fila q = new Fila();

	private static int auxPosteriorDoUltimo = 0;
	public static int cores = 0;
	public static int processos = 0;
	public static int quantum = 0;
	public static int numListasTop = 0; // QUANTIDADE DE LISTAS TOP
	public static int prioridadeQuatum;
	public static int quantidadeDeCore;
	public static boolean programaON;

	public int getQuantidadeDeCore() {
		return quantidadeDeCore;
	}

	public void setQuantidadeDeCore(int quantidadeDeCore) {
		this.quantidadeDeCore = quantidadeDeCore;
	}

	public static int tempoAleatorio() {
		int n = (int) (Math.random() * 17 + 4);
		return n;
	}

	public static int prioridade() {
		prioridadeQuatum = (int) (Math.random() * 4);
		return prioridadeQuatum;
	}

	public static void adicionarProcessos(int nProcessos, Color pronto, Color esperando, Color terminado,
			Color executando) {

		for (int i = 0; i < nProcessos; i++) {
			int tempo = tempoAleatorio();
			int prioridade = prioridade();
			String estado = "pronto";

			if (prioridade == 0) {
				q.adicionarNaFila(
						new Processo(tempo, prioridade, estado, quantum, pronto, esperando, terminado, executando));
			}

			if (prioridade == 1) {
				q2.adicionarNaFila(new Processo(tempo, prioridade, estado, (quantum * 2), pronto, esperando, terminado,
						executando));
			}

			if (prioridade == 2) {
				q3.adicionarNaFila(new Processo(tempo, prioridade, estado, (quantum * 3), pronto, esperando, terminado,
						executando));
			}

			if (prioridade == 3) {
				q4.adicionarNaFila(new Processo(tempo, prioridade, estado, (quantum * 4), pronto, esperando, terminado,
						executando));
			}

		}
	}

	public static void voltarParaFila(Processo processo) {
		if (processo.getPrioridade() == 0) {
			q.adicionarNaFila(processo);
		}

		if (processo.getPrioridade() == 1) {
			q2.adicionarNaFila(processo);
		}

		if (processo.getPrioridade() == 2) {
			q3.adicionarNaFila(processo);
		}

		if (processo.getPrioridade() == 3) {
			q4.adicionarNaFila(processo);
		}

	}

	public static void imprimirListas() {
		System.out.println("\n===== LISTA PRIORIDADE 1 ======");
		for (int i = 0; i < q.getQnt(); i++) {
			Processo aux = q.removerDaFila();
			System.out.println(aux);
			q.adicionarNaFila(aux);
		}
		System.out.println("\n===== LISTA PRIORIDADE 2 ======");
		for (int i = 0; i < q2.getQnt(); i++) {
			Processo aux = q2.removerDaFila();
			System.out.println(aux);
			q2.adicionarNaFila(aux);
		}
		System.out.println("\n===== LISTA PRIORIDADE 3 ======");
		for (int i = 0; i < q3.getQnt(); i++) {
			Processo aux = q3.removerDaFila();
			System.out.println(aux);
			q3.adicionarNaFila(aux);
		}
		System.out.println("\n===== LISTA PRIORIDADE 4 ======");
		for (int i = 0; i < q4.getQnt(); i++) {
			Processo aux = q4.removerDaFila();
			System.out.println(aux);
			q4.adicionarNaFila(aux);
		}
	}

	public static void attFilas() {
		if (q != null) {
			if (q.getQnt() > 0) {
				if (q.getHead().getProcesso().getEstado().equalsIgnoreCase("Pronto")) {
					InterfaceRR.textArea_1.setBackground(q.getHead().getProcesso().pronto);
				} else {
					InterfaceRR.textArea_1.setBackground(q.getHead().getProcesso().esperando);
				}
				InterfaceRR.textArea_1.setText(q.getHead().getProcesso().toString());

			} else {
				InterfaceRR.textArea_1.setText("\n    FILA\n    VAZIA");
				InterfaceRR.textArea_1.setBackground(new Color(204, 255, 204));

			}
		}

		if (q2 != null) {
			if (q2.getQnt() > 0) {
				if (q2.getHead().getProcesso().getEstado().equalsIgnoreCase("Pronto")) {
					InterfaceRR.textArea_2.setBackground(q2.getHead().getProcesso().pronto);
				} else {
					InterfaceRR.textArea_2.setBackground(q2.getHead().getProcesso().esperando);
				}
				InterfaceRR.textArea_2.setText(q2.getHead().getProcesso().toString());

			} else {
				InterfaceRR.textArea_2.setText("\n    FILA\n    VAZIA");
				InterfaceRR.textArea_2.setBackground(new Color(204, 255, 204));
			}
		}

		if (q3 != null) {
			if (q3.getQnt() > 0) {
				if (q3.getHead().getProcesso().getEstado().equalsIgnoreCase("Pronto")) {
					InterfaceRR.textArea_3.setBackground(q3.getHead().getProcesso().pronto);
				} else {
					InterfaceRR.textArea_3.setBackground(q3.getHead().getProcesso().esperando);
				}
				InterfaceRR.textArea_3.setText(q3.getHead().getProcesso().toString());

			} else {
				InterfaceRR.textArea_3.setText("\n    FILA\n    VAZIA");
				InterfaceRR.textArea_3.setBackground(new Color(204, 255, 204));

			}
		}

		if (q4 != null) {
			if (q4.getQnt() > 0) {
				if (q4.getHead().getProcesso().getEstado().equalsIgnoreCase("Pronto")) {
					InterfaceRR.textArea_4.setBackground(q4.getHead().getProcesso().pronto);
				} else {
					InterfaceRR.textArea_4.setBackground(q4.getHead().getProcesso().esperando);
				}
				InterfaceRR.textArea_4.setText(q4.getHead().getProcesso().toString());

			} else {
				InterfaceRR.textArea_4.setText("\n    FILA\n    VAZIA");
				InterfaceRR.textArea_4.setBackground(new Color(204, 255, 204));

			}
		}

	}

	////// E S C A L O N A M E N T O //////
	public void run() {

		programaON = true;
		adicionarProcessos(processos, new Color(153, 204, 204), new Color(255, 204, 102), new Color(255, 99, 71), new Color(153, 255, 102));

		attFilas();
		imprimirListas();

		for (int i = 0; i < cores; i++) {
			Core a = new Core();
			a.start();
			listaCores.add(a);
		}

		EventQueue.invokeLater(new Runnable() { // CHAMA A TELA DO RR
			public void run() {
				try {
					InterfaceRR frame = new InterfaceRR(q, q2, q3, q4, listaCores, listaTerminados);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		//FAZER UM METODO QUE CRIE AS ESTATISTICAS E ADICIONE EM UMA LISTA

		while (programaON) { // ENQUANTO.TIVER.PROCESSO.OU.ALGO.EXECUTANDO
			if (temProcesso() || aindaTemCore(listaCores)) {//CORE.RODANDO

				for (int i = 0; i < listaCores.size(); i++) {

					if (listaCores.get(i).prontoParaReceberProcesso()) {	

						if (listaCores.get(i).getProcessoEmAndamento() != null) { 

							if (listaCores.get(i).getProcessoEmAndamento().estado.equalsIgnoreCase("Terminado")) {
								
								listaTerminados.add(listaCores.get(i).getProcessoEmAndamento());

								JTextArea textAreaTerminados = new JTextArea(3, 16);
								textAreaTerminados.setBackground(listaCores.get(i).getProcessoEmAndamento().terminado);
								textAreaTerminados.setText(listaCores.get(i).getProcessoEmAndamento().toString());
								InterfaceRR.panelTerminados.add(textAreaTerminados);
							} else {
								voltarParaFila(listaCores.get(i).getProcessoEmAndamento()); // SE.NAO, VOLTA.PRAS.FILAS
								
							}
						}

						if (temProcesso()) {
							// VOU INSERIR DA LISTA POSTERIOR A LISTA DO ULTIMO
							// PROCESSO QUE EU INSERI
							boolean inseriCorretamente = false;
							while (!inseriCorretamente) {
								if (auxPosteriorDoUltimo == 0) {
									if (q.getQnt() > 0) {
										listaCores.get(i).setProcessoEmAndamento(q.removerDaFila()); 
										if (q != null) {
											if (q.getQnt() > 0) {
												if (q.getHead().getProcesso().getEstado().equalsIgnoreCase("Pronto")) {
													InterfaceRR.textArea_1
													.setBackground(q.getHead().getProcesso().pronto);
												} else {
													InterfaceRR.textArea_1
													.setBackground(q.getHead().getProcesso().esperando);
												}
												InterfaceRR.textArea_1.setText(q.getHead().getProcesso().toString());
											} else {
												InterfaceRR.textArea_1.setText("\n    FILA\n    VAZIA");
												InterfaceRR.textArea_1.setBackground(new Color(204, 255, 204));

											}
										}

										inseriCorretamente = true;
									}
									auxPosteriorDoUltimo = 1;
								} else {
									if (auxPosteriorDoUltimo == 1) {
										if (q2.getQnt() > 0) {
											listaCores.get(i).setProcessoEmAndamento(q2.removerDaFila());

											if (q2 != null) {
												if (q2.getQnt() > 0) {
													if (q2.getHead().getProcesso().getEstado()
															.equalsIgnoreCase("Pronto")) {
														InterfaceRR.textArea_2
														.setBackground(q2.getHead().getProcesso().pronto);
													} else {
														InterfaceRR.textArea_2
														.setBackground(q2.getHead().getProcesso().esperando);
													}
													InterfaceRR.textArea_2
													.setText(q2.getHead().getProcesso().toString());

												} else {
													InterfaceRR.textArea_2.setText("\n    FILA\n    VAZIA");
													InterfaceRR.textArea_2.setBackground(new Color(204, 255, 204));

												}
											}

											inseriCorretamente = true;
										}
										auxPosteriorDoUltimo = 2;
									} else {
										if (auxPosteriorDoUltimo == 2) {
											if (q3.getQnt() > 0) {
												listaCores.get(i).setProcessoEmAndamento(q3.removerDaFila());
												if (q3 != null) {
													if (q3.getQnt() > 0) {
														if (q3.getHead().getProcesso().getEstado()
																.equalsIgnoreCase("Pronto")) {
															InterfaceRR.textArea_3
															.setBackground(q3.getHead().getProcesso().pronto);
														} else {
															InterfaceRR.textArea_3.setBackground(
																	q3.getHead().getProcesso().esperando);
														}
														InterfaceRR.textArea_3
														.setText(q3.getHead().getProcesso().toString());

													} else {
														InterfaceRR.textArea_3.setText("\n    FILA\n    VAZIA");
														InterfaceRR.textArea_3.setBackground(new Color(204, 255, 204));

													}
												}

												inseriCorretamente = true;
											}
											auxPosteriorDoUltimo = 3;
										} else {
											if (auxPosteriorDoUltimo == 3) {
												if (q4.getQnt() > 0) {
													listaCores.get(i).setProcessoEmAndamento(q4.removerDaFila());
													if (q4 != null) {
														if (q4.getQnt() > 0) {
															if (q4.getHead().getProcesso().getEstado()
																	.equalsIgnoreCase("Pronto")) {
																InterfaceRR.textArea_4.setBackground(
																		q4.getHead().getProcesso().pronto);
															} else {
																InterfaceRR.textArea_4.setBackground(
																		q4.getHead().getProcesso().esperando);
															}
															InterfaceRR.textArea_4
															.setText(q4.getHead().getProcesso().toString());

														} else {
															InterfaceRR.textArea_4.setText("\n    FILA\n    VAZIA");
															InterfaceRR.textArea_4
															.setBackground(new Color(204, 255, 204));

														}
													}

													inseriCorretamente = true;
												}
												auxPosteriorDoUltimo = 0;
											}
										}
									}
								}
							} // FIM WHILE DE INSERIR O PROXIMO DO ANTERIOR

							// SE CHEGOU AQUI � PQ TINHA PROCESSO
							listaCores.get(i).setProntoParaReceberProcesso(false);
						} else {
							// NAO TEM MAIS PROCESSO
							listaCores.get(i).setProcessoEmAndamento(null);
						}
					}
				}

			} else {

				for (int i = 0; i < listaCores.size(); i++) {
					if (listaCores.get(i).getProcessoEmAndamento() != null) { // SE.TIVER.PROCESSO.AINDA
						listaTerminados.add(listaCores.get(i).getProcessoEmAndamento());
					}

				}
			}
		}

		for (int i = 0; i < listaCores.size(); i++) {
			listaCores.get(i).interrupt();
			listaCores.get(i).finalizar();
			listaCores.get(i).stop();
		}

		System.out.println("=============================== FINALIZADOS ====================================");
		imprimirfinalizados();
		for (int i = 0; i < listaCores.size(); i++) {
			System.out.println("core = " + listaCores.get(i).getId() + " vivo = " + listaCores.get(i).isAlive()
					+ " processamento = " + listaCores.get(i).processamento);
		}
	}

	/////////////////////////////// FIM DO RUN
	public static void terminar() {
		programaON = false;
	}

	public static void imprimirfinalizados() {
		for (int i = 0; i < listaTerminados.size(); i++) {
			System.out.println(listaTerminados.get(i));
		}
	}

	public static boolean temProcesso() {
		if (q.getQnt() > 0) {
			return true;
		} else {
			if (q2.getQnt() > 0) {
				return true;
			} else {
				if (q3.getQnt() > 0) {
					return true;
				} else {
					if (q4.getQnt() > 0) {
						return true;
					} else {
						return false;
					}
				}
			}
		}
	}

	public static boolean aindaTemCore(ArrayList<Core> cores) {
		for (int i = 0; i < cores.size(); i++) {
			if (cores.get(i).getProcessoEmAndamento() != null) {
				return true; // PQ ELE TA RODANDO
			}
		}
		return false;
	}
	
	// METODO PARA ALOCAR BLOCO PARA UM PROCESSO
	public boolean alocarBlocoParaProcesso(Processo processo){
		if(Memoria.getMemoriaDisponivel() >= processo.getRequisicao()){ // VERIFICA SE TEM MEMORIA SUFICIENTE
			if(Memoria.existeListaInicial()){ // VERIFICA SE JA EXISTE A LISTA INICIAL, SE EXISTIR, ENTRA
				// ---------------------------- EXISTE LISTA INICIAL ------------------------------
				if(Memoria.existeListaTop()){ // VERIFICA SE JA EXISTE A LISTA TOP, SE EXISTIR, ENTRA
					// ----------------------------- EXISTE LISTA TOP -----------------------------------
					for(int i = 0; i < Memoria.getListadeListas().size();i++ ){ // VAI PERCORRER AS LISTAS TOP
						// VERIFICA SE O TAMANHO DO PROCESSO � UMA DAS LISTA TOP, SE FOR ENTRA, SE N�O FOR ELE VAI ENTRAR MESMO ASSIM, S� QUE NA LISTA RESTO
						if(Memoria.getListadeListas().get(i).getBytes() == processo.getRequisicao() || i == Memoria.getListadeListas().size()-1 ){  
							if(Memoria.getListadeListas().get(i).temBlocoLivre()){ // VERIFICA SE A LISTA TEM BLOCO LIVRE
								for(Bloco b: Memoria.getListadeListas().get(i).getBlocos()){ // PERCORRE OS BLOCOS DA LISTA
									if(b.isLivre() && b.getTamanho() == processo.getRequisicao()){ // VERIFICA SE O BLOCO EST� LIVRE, E SE ELE � DO MESMO TAMANHO DO PROCESSO (CASO ESTEJA NA LISTA RESTO)
										b.alocarProcesso(processo); // ALOCA O PROCESSO NO BLOCO
										Memoria.decrementarMemoria(processo.getRequisicao()); // REDUZ A MEMORIA DISPONIVEL
										return true; //RETORNA TRUE PQ ALOCOU O PROCESSO COM SUCESSO
									}
								}
							}else{
								break;  // SE NAO TIVER BLOCO LIVRE NA LISTA ELE SAI DO FOR
							}
						}
					}
				}else{
					//----------------------------- NAO EXISTE LISTA TOP ---------------------
					for(Bloco bloco: Memoria.getListaInicialDeBlocos()){ // PERCORRE OS BLOCOS
						if(bloco.isLivre() && bloco.getTamanho()== processo.getRequisicao()){ // VERIFICA SE O � LIVRE E � DO MESMO TAMANHO DA REQUISICAO DO PROCESSO
							bloco.alocarProcesso(processo); // ALOCA O PROCESSO NO BLOCO
							Memoria.decrementarMemoria(processo.getRequisicao()); // DECREMENTA A MEMORIA
							return true; // RETORNA TRUE PQ ALOCOU O PROCESSO COM SUCESSO
						}
					}
				}
			}
			// -------------------------------- SE CHEGOU AT� AQUI � PQ N�O TINHA BLOCO LIVRE -----------------------------------
			Bloco novo = Memoria.criarBloco(processo.getRequisicao()); // CRIA O BLOCO ( JA ADICIONA NA LISTA TOP CASO ELA EXISTA)
			novo.alocarProcesso(processo); // ALOCA O PROCESSO NO BLOCO
			Memoria.decrementarMemoria(processo.getRequisicao()); // DECREMENTA MEMORIA
			return true; // RETORNA TRUE PQ FOI ALOCADO UM PROCESSO PARA O BLOCO COM SUCESSO
		}
		return false; // SE CHEGOU AQUI � PQ NAO TINHA MEMORIA SUFICIENTE, RETORNA FALSE 
	}
	
	//METODO PARA DESALOCAR PROCESSO DO BLOCO
	public boolean desalocarBlocoDoProcesso(Processo processo){
		if(Memoria.existeListaTop()){ // VERIFICA SE EXISTE AS LISTAS TOPS
			for(int i = 0; i < Memoria.getListadeListas().size(); i++){ // PERCORRE AS LISTAS TOP
				if(Memoria.getListadeListas().get(i).getBytes() == processo.getRequisicao() || i == Memoria.getListadeListas().size() - 1){
					// --------------- VERIFICOU SE EXISTE A LISTA TOP CORRESPONDENTE AOS BYTES DO PROCESSO OU ENTROU NA LISTA RESTO -----------
					for(Bloco bloco: Memoria.getListadeListas().get(i).getBlocos()){ // PERCORRE OS BLOCOS DA LISTA
						if((!bloco.isLivre()) && bloco.getTamanho() == processo.getRequisicao() ){ // VERIFICA SE O BLOCO NAO ESTA LIVRE E O TAMANHO � IGUAL AO DO PROCESSO (CASO ESTEJA NA LISTA RESTO)
							if(bloco.getProcesso().id == processo.id){ // VERIFICA SE O PROCESSO QUE TA NO BLOCO � O PROCESSO QUE QUEREMOS DESALOCAR
								bloco.desalocarProcesso(); // DESALOCA PROCESSO
								Memoria.restaurarMemoria(processo.getRequisicao()); // RESTAURA A MEMORIA
								return true; // RETORNA TRUE PQ DESALOCOU COM SUCESSO
							}
						}
					}
				}
			}
		}else{
			//-------------------------- NAO EXISTE LISTAS TOPS ---------------------------------
			for(Bloco bloco: Memoria.getListaInicialDeBlocos()){ // PERCORRE A LISTA INICIAL DE BLOCOS
				if((!bloco.isLivre()) && bloco.getTamanho() == processo.getRequisicao()){ //VERIFICA SE O BLOCO NAO TA VAZIO E SE O TAMANHO CORRESPONDE COM A QUANTIDADE DE BYTES DO PROCESSO
					if(bloco.getProcesso().id == processo.id){ // VERIFICA SE O PROCESSO ALOCADO NO BLOCO � O PROCESSO QUE QUEREMOS DESALOCAR
						bloco.desalocarProcesso(); // DESALOCA PROCESSO
						Memoria.restaurarMemoria(processo.getRequisicao()); //RESTAURA MEMORIA
						return true; // RETORNA TRUE POIS DESALOCOU COM SUCESSO
					}
				}
			}
		}
		
		return false; // SE CHEGOU AQUI � PQ O PROCESSO QUE TENTOU DESALOCAR, N�O TEM UM BLOCO ALOCADO, POR ISSO RETORNA FALSE
	}
	
	//MONTAR LISTA TOPS
	public void montarListaTop(ArrayList<Estatistica> estatisticas){ // RECEBE UMA LISTA DE ESTATISTICAS COMO PARAMETRO
		ArrayList<Lista> listaDeLista = new ArrayList<Lista>(); // LISTA AUXILIAR PARA ARMAZENAR AS LISTAS TOPS
		for(int i = 0; i < numListasTop; i++){ // PERCORRE UM FOR O NUMERO DE LISTAS TOPS 
			Estatistica maior = maiorEstatistica(estatisticas); // PEGA O TOP DA LISTA 
			listaDeLista.add(new Lista(maior)); // CRIA UMA LISTA TOP
			maior.zerarHit(); // ZERA O HIT DESSE TOP, PARA DA PROXIMA VEZ PEGAR O TOP 2 E ASSIM SUCESSIVAMENTE
		}
		listaDeLista.add(new Lista(999)); // CRIA A LISTA DE RESTO | CODIGO 999 = RESTO
		
		for(int i = 0; i < Memoria.getListaInicialDeBlocos().size(); i++){ // PERCORRE A LISTA INICIAL DE BLOCOS
			for(int k = 0; k < listaDeLista.size(); k++){ // PERCORRE AS LISTAS TOP
				if(Memoria.getListaInicialDeBlocos().get(i).getTamanho() == listaDeLista.get(k).getBytes() || k == listaDeLista.size()-1){ 
					// ---------- VERIFICA SE EXISTE UM TOP CORRESPONDENTE AO TAMANHO DO BLOCO DA LISTA INICIAL PARA ENTRAR OU SE NAO EXISTIR, ENTRA NA LISTA RESTO
					listaDeLista.get(k).addBloco(Memoria.getListaInicialDeBlocos().get(i)); // ADICIONA O BLOCO NA LISTA
					k = listaDeLista.size(); // SE ADICIONA O BLOCO ELE PULA O RESTO DO FOR
				}
			}
		}
		
		
		Memoria.setListaDeListas(listaDeLista); // ELE ATUALIZA QUEEM SAO AS LISTAS TOP
		for(int i = 0; i < estatisticas.size(); i++){ // PERCORRE TODAS AS ESTATISTICAS 
			estatisticas.get(i).zerarHit(); // ZERA O HIT DE TODAS ELAS
		}
	}
	
	//RETORNA A MAIOR ESTATISTICA DE UMA LISTA
	public Estatistica maiorEstatistica(ArrayList<Estatistica> lista){ // RECEBE UMA LISTA DE ESTATISTICAS COMO PARAMETRO
		Estatistica maior = null; // VARIAVEL AUXILIAR QUE DETERMINA A MAIOR ESTATISTICA
		for (int i = 0; i < lista.size(); i++) { // PERCORRE A LISTA DE ESTATISTICA
			if(maior != null){ // SE A VARIAVEL AUXILIAR JA ESTIVER SIDO ALIMENTADA, ENTRA
				if(lista.get(i).getHit() > maior.getHit()){ // VERIFICA SE A ESTATISTICA ATUAL TEM MAIS HITS DO QUE O MAIOR
					maior = lista.get(i); // SE SIM, ENTAO O MAOIR TEM QUE SER ATUALIZADO
				}
			}else{ // SE NAO, TEM Q ALIMENTAR A VARIAVEL
				maior = lista.get(i); // ALIMENTA COM O PRIMEIRO QUE VIER
			}
		}
		return maior; // RETORNA A VARIAVEL MAIOR
	}
	
	//CRIAR UM METODO QUE D� HIT ( 2 SOLUCOES, DEIXAR A LISTA DE ESTATISTICA PUBLICA (PIOR IMPLEMENTA��O), RETORNAR A ESTATISTICA E DAR UM HIT NELA ONDE O METODO FOI CHAMADO (MELHOR IMPLEMENTA��O)
	

}
