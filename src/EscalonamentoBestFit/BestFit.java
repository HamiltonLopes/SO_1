package EscalonamentoBestFit;

import java.awt.Color;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JTextArea;

import Escalonador.Processo;
import FIFO.Fila;

public class BestFit extends Thread {

	static ArrayList<Processo> listaTerminados = new ArrayList<Processo>();
	static ArrayList<CoreBest> listaCores = new ArrayList<CoreBest>();

	static Fila q4 = new Fila();
	static Fila q3 = new Fila();
	static Fila q2 = new Fila();
	static Fila q = new Fila();

	private static int auxPosteriorDoUltimo = 0;
	public static int cores = 0;
	public static int processos = 0;
	public static int quantum = 0;
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
					InterfaceBF.textArea_1.setBackground(q.getHead().getProcesso().pronto);
				} else {
					InterfaceBF.textArea_1.setBackground(q.getHead().getProcesso().esperando);
				}
				InterfaceBF.textArea_1.setText(q.getHead().getProcesso().toString());

			} else {
				InterfaceBF.textArea_1.setText("\n    FILA\n    VAZIA");
				InterfaceBF.textArea_1.setBackground(new Color(204, 255, 204));

			}
		}

		if (q2 != null) {
			if (q2.getQnt() > 0) {
				if (q2.getHead().getProcesso().getEstado().equalsIgnoreCase("Pronto")) {
					InterfaceBF.textArea_2.setBackground(q2.getHead().getProcesso().pronto);
				} else {
					InterfaceBF.textArea_2.setBackground(q2.getHead().getProcesso().esperando);
				}
				InterfaceBF.textArea_2.setText(q2.getHead().getProcesso().toString());

			} else {
				InterfaceBF.textArea_2.setText("\n    FILA\n    VAZIA");
				InterfaceBF.textArea_2.setBackground(new Color(204, 255, 204));
			}
		}

		if (q3 != null) {
			if (q3.getQnt() > 0) {
				if (q3.getHead().getProcesso().getEstado().equalsIgnoreCase("Pronto")) {
					InterfaceBF.textArea_3.setBackground(q3.getHead().getProcesso().pronto);
				} else {
					InterfaceBF.textArea_3.setBackground(q3.getHead().getProcesso().esperando);
				}
				InterfaceBF.textArea_3.setText(q3.getHead().getProcesso().toString());

			} else {
				InterfaceBF.textArea_3.setText("\n    FILA\n    VAZIA");
				InterfaceBF.textArea_3.setBackground(new Color(204, 255, 204));

			}
		}

		if (q4 != null) {
			if (q4.getQnt() > 0) {
				if (q4.getHead().getProcesso().getEstado().equalsIgnoreCase("Pronto")) {
					InterfaceBF.textArea_4.setBackground(q4.getHead().getProcesso().pronto);
				} else {
					InterfaceBF.textArea_4.setBackground(q4.getHead().getProcesso().esperando);
				}
				InterfaceBF.textArea_4.setText(q4.getHead().getProcesso().toString());

			} else {
				InterfaceBF.textArea_4.setText("\n    FILA\n    VAZIA");
				InterfaceBF.textArea_4.setBackground(new Color(204, 255, 204));

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
			CoreBest a = new CoreBest();
			a.start();
			listaCores.add(a);
		}

		EventQueue.invokeLater(new Runnable() { // CHAMA A TELA DO RR
			public void run() {
				try {
					InterfaceBF frame = new InterfaceBF(q, q2, q3, q4, listaCores, listaTerminados);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

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
								InterfaceBF.panelTerminados.add(textAreaTerminados);
								
								//DESALOCA BLOCO DO PROCESSO
								desalocarBloco(listaCores.get(i).getProcessoEmAndamento()); 
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

										Processo novoProcesso = q.removerDaFila();// PEGA A REF DO PROX PROCESSO E INSERE NA VAR AUX NOVOPROCESSO
										if(processoJaTemBloco(novoProcesso)){ // VERIFICA SE O PROCESSO JA TEM UM BLOCO ALOCADO
											listaCores.get(i).setProcessoEmAndamento(novoProcesso); // SE JA TEM BLOCO ENTAO ADICIONA O PROCESSO NO CORE
											inseriCorretamente = true; // ALIMENTA A VAR DE CONTROLE, AVISANDO QUE INSERIU
										}else{// SE NAO TIVER BLOCO ENTRA,
											if(alocarBloco(novoProcesso)){ //TENTA ALOCAR UM BLOCO PARA O NOVO PROCESSO, SE NAO ALOCAR DESCARTA
												listaCores.get(i).setProcessoEmAndamento(novoProcesso); // SE ALOCOU O BLOCO ENTAO ADICIONA O PROCESSO NO CORE
												inseriCorretamente = true;// ALIMENTA A VAR DE CONTROLE, AVISANDO QUE INSERIU
											}
										}
										
										if (q != null) {
											if (q.getQnt() > 0) {
												if (q.getHead().getProcesso().getEstado().equalsIgnoreCase("Pronto")) {
													InterfaceBF.textArea_1
													.setBackground(q.getHead().getProcesso().pronto);
												} else {
													InterfaceBF.textArea_1
													.setBackground(q.getHead().getProcesso().esperando);
												}
												InterfaceBF.textArea_1.setText(q.getHead().getProcesso().toString());
											} else {
												InterfaceBF.textArea_1.setText("\n    FILA\n    VAZIA");
												InterfaceBF.textArea_1.setBackground(new Color(204, 255, 204));

											}
										}

									}
									auxPosteriorDoUltimo = 1;
								} else {
									if (auxPosteriorDoUltimo == 1) {
										if (q2.getQnt() > 0) {
											
											Processo novoProcesso = q2.removerDaFila();// PEGA A REF DO PROX PROCESSO E INSERE NA VAR AUX NOVOPROCESSO
											if(processoJaTemBloco(novoProcesso)){ // VERIFICA SE O PROCESSO JA TEM UM BLOCO ALOCADO
												listaCores.get(i).setProcessoEmAndamento(novoProcesso); // SE JA TEM BLOCO ENTAO ADICIONA O PROCESSO NO CORE
												inseriCorretamente = true; // ALIMENTA A VAR DE CONTROLE, AVISANDO QUE INSERIU
											}else{// SE NAO TIVER BLOCO ENTRA,
												if(alocarBloco(novoProcesso)){ //TENTA ALOCAR UM BLOCO PARA O NOVO PROCESSO, SE NAO ALOCAR DESCARTA
													listaCores.get(i).setProcessoEmAndamento(novoProcesso); // SE ALOCOU O BLOCO ENTAO ADICIONA O PROCESSO NO CORE
													inseriCorretamente = true;// ALIMENTA A VAR DE CONTROLE, AVISANDO QUE INSERIU
												}
											}

											if (q2 != null) {
												if (q2.getQnt() > 0) {
													if (q2.getHead().getProcesso().getEstado()
															.equalsIgnoreCase("Pronto")) {
														InterfaceBF.textArea_2
														.setBackground(q2.getHead().getProcesso().pronto);
													} else {
														InterfaceBF.textArea_2
														.setBackground(q2.getHead().getProcesso().esperando);
													}
													InterfaceBF.textArea_2
													.setText(q2.getHead().getProcesso().toString());

												} else {
													InterfaceBF.textArea_2.setText("\n    FILA\n    VAZIA");
													InterfaceBF.textArea_2.setBackground(new Color(204, 255, 204));

												}
											}

										}
										auxPosteriorDoUltimo = 2;
									} else {
										if (auxPosteriorDoUltimo == 2) {
											if (q3.getQnt() > 0) {
												Processo novoProcesso = q3.removerDaFila();// PEGA A REF DO PROX PROCESSO E INSERE NA VAR AUX NOVOPROCESSO
												if(processoJaTemBloco(novoProcesso)){ // VERIFICA SE O PROCESSO JA TEM UM BLOCO ALOCADO
													listaCores.get(i).setProcessoEmAndamento(novoProcesso); // SE JA TEM BLOCO ENTAO ADICIONA O PROCESSO NO CORE
													inseriCorretamente = true; // ALIMENTA A VAR DE CONTROLE, AVISANDO QUE INSERIU
												}else{// SE NAO TIVER BLOCO ENTRA,
													if(alocarBloco(novoProcesso)){ //TENTA ALOCAR UM BLOCO PARA O NOVO PROCESSO, SE NAO ALOCAR DESCARTA
														listaCores.get(i).setProcessoEmAndamento(novoProcesso); // SE ALOCOU O BLOCO ENTAO ADICIONA O PROCESSO NO CORE
														inseriCorretamente = true;// ALIMENTA A VAR DE CONTROLE, AVISANDO QUE INSERIU
													}
												}
												if (q3 != null) {
													if (q3.getQnt() > 0) {
														if (q3.getHead().getProcesso().getEstado()
																.equalsIgnoreCase("Pronto")) {
															InterfaceBF.textArea_3
															.setBackground(q3.getHead().getProcesso().pronto);
														} else {
															InterfaceBF.textArea_3.setBackground(
																	q3.getHead().getProcesso().esperando);
														}
														InterfaceBF.textArea_3
														.setText(q3.getHead().getProcesso().toString());

													} else {
														InterfaceBF.textArea_3.setText("\n    FILA\n    VAZIA");
														InterfaceBF.textArea_3.setBackground(new Color(204, 255, 204));

													}
												}

											}
											auxPosteriorDoUltimo = 3;
										} else {
											if (auxPosteriorDoUltimo == 3) {
												if (q4.getQnt() > 0) {
													
													Processo novoProcesso = q4.removerDaFila();// PEGA A REF DO PROX PROCESSO E INSERE NA VAR AUX NOVOPROCESSO
													if(processoJaTemBloco(novoProcesso)){ // VERIFICA SE O PROCESSO JA TEM UM BLOCO ALOCADO
														listaCores.get(i).setProcessoEmAndamento(novoProcesso); // SE JA TEM BLOCO ENTAO ADICIONA O PROCESSO NO CORE
														inseriCorretamente = true; // ALIMENTA A VAR DE CONTROLE, AVISANDO QUE INSERIU
													}else{// SE NAO TIVER BLOCO ENTRA,
														if(alocarBloco(novoProcesso)){ //TENTA ALOCAR UM BLOCO PARA O NOVO PROCESSO, SE NAO ALOCAR DESCARTA
															listaCores.get(i).setProcessoEmAndamento(novoProcesso); // SE ALOCOU O BLOCO ENTAO ADICIONA O PROCESSO NO CORE
															inseriCorretamente = true;// ALIMENTA A VAR DE CONTROLE, AVISANDO QUE INSERIU
														}
													}
													if (q4 != null) {
														if (q4.getQnt() > 0) {
															if (q4.getHead().getProcesso().getEstado()
																	.equalsIgnoreCase("Pronto")) {
																InterfaceBF.textArea_4.setBackground(
																		q4.getHead().getProcesso().pronto);
															} else {
																InterfaceBF.textArea_4.setBackground(
																		q4.getHead().getProcesso().esperando);
															}
															InterfaceBF.textArea_4
															.setText(q4.getHead().getProcesso().toString());

														} else {
															InterfaceBF.textArea_4.setText("\n    FILA\n    VAZIA");
															InterfaceBF.textArea_4
															.setBackground(new Color(204, 255, 204));

														}
													}

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

	public static boolean aindaTemCore(ArrayList<CoreBest> cores) {
		for (int i = 0; i < cores.size(); i++) {
			if (cores.get(i).getProcessoEmAndamento() != null) {
				return true; // PQ ELE TA RODANDO
			}
		}
		return false;
	}
	
	public boolean alocarBloco(Processo processo){ // TENTA ALOCAR UM BLOCO PARA O PROCESSO 
		if(MemoriaBest.getMemoriaDisponivel() >= processo.getRequisicao()){ // VERIFICA SE TEM MEMORIA DISPONIVEL
			if(MemoriaBest.temBloco()){ // VERIFICA SE JA TEM BLOCO CRIADOS, SE TIVER ENTRA
				for(BlocoBest bloco:MemoriaBest.getListaDeBlocos()){ // PERCORRE OS BLOCOS
					if(bloco.getTamanhoLivre() == processo.getRequisicao()){ // VERIFICA SE TEM UM BLOCO PERFEITO PRA ELE LIVRE
						bloco.alocarProcesso(processo); // ALOCA O PROCESSO AO BLOCO
						MemoriaBest.decrementarMemoria(processo.getRequisicao()); // DECREMENTA A MEMORIA
						return true; // RETORNA TRUE PQ DEU TD CERTO
					}
				}
				
				for(BlocoBest bloco: MemoriaBest.getListaDeBlocos()){ // PERCORRE OS BLOCOS DNV SE NAO TIVER INSERIDO
					if(bloco.getTamanhoLivre() > processo.getRequisicao()){  // VERIFICA SE TEM UM BLOCO Q DE CERTO NELE MESMO Q NAO SEJA O PERFEITO
						bloco.alocarProcesso(processo); // ALOCA O PROCESSO NO BLOCO
						MemoriaBest.decrementarMemoria(processo.getRequisicao());// DECREMENTA A MEMORIA
						return true; // RETORNA TRUE PQ DEU CERTO
					}
				}
			}
			// ========== CHEGOU ATE AQUI PQ NAO ALOCOU AINDA ================
			BlocoBest novo = MemoriaBest.criarBloco(processo.getRequisicao());  // TENTA CRIA UM NOVO BLOCO
			if(!(novo == null)){ // SE CIROU O BLOCO, ENTRA
				novo.alocarProcesso(processo); // ALOCA O PROCESSO
				MemoriaBest.decrementarMemoria(processo.getRequisicao()); // DECREMENTA A MEMORIA
				return true; // RETORNA TRUE PQ DEU CERTO
			}
			
		} 
		return false; // CHEGAR AQUI E PQ N TINHA MEMORIA DISPONIVEL OU TENHA POREM MAL DIVIDIDA ENTRE OS BLOCOS
	}
	
	public boolean desalocarBloco(Processo processo){ // TENTA DESALOCAR O BLOCO DO PROCESSO
		if(MemoriaBest.temBloco()){ // VERIFICA SE TEM BLOCOS CRIADOS NA MEMORIA
			for(BlocoBest bloco: MemoriaBest.getListaDeBlocos()){ // PERCORRE OS BLOCOS
				if(bloco.desalocarProcesso(processo)){ // TENTA DESALOCAR O PROCESSO
					return true; // SE DESALOCAR SAI DO METODO E RETORNA TRUE;
				}
			}
		}
		return false; // NAO TEM BLOCOS NA MEMORIA OU O PROCESSO NAO POSSUI BLOCO ALOCADO
	}
	
	public boolean processoJaTemBloco(Processo processo){ // VERIFICA SE O PROCESSO JA TEM UM BLOCO ALOCADO
		for(BlocoBest b:MemoriaBest.getListaDeBlocos()){ // PERCORRE TODOS OS BLOCOS
			for(Processo p : b.getProcessos()){ // PERCORRE TODOS OS PROCESSOS DO BLOCO
				if(p.equals(processo)){ // VEIRIFICA SE O BLOCO TEM O PROCESSO EM QUESTAO
					return true; // SE TIVER RETORNA TRUE
				}
			}
		}
		return false; // SE NAO TIVER UM BLOCO RETORNA FALSO
	}
	

}
