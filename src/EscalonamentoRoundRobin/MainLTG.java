package EscalonamentoRoundRobin;

import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JTextArea;

public class MainLTG extends Thread {

	static ArrayList<Processo> processosOrdenados = new ArrayList<Processo>();
	static ArrayList<Processo> listaTerminados = new ArrayList<Processo>();
	static ArrayList<Processo> listaAbortados = new ArrayList<Processo>();
	static ArrayList<CoreLTG> listaCores = new ArrayList<CoreLTG>();

	public static int processos = 0;
	public static int cores = 0;

	public static int tempoAleatorio() {
		int n = (int) (Math.random() * 17 + 4);
		return n;
	}

	public static int deadlineAleatoria() {
		int n = (int) (Math.random() * 17 + 4);
		return n;
	}

	public static void inserirProcessos(int nProcessos) {

		for (int i = 0; i < nProcessos; i++) {
			int deadline = deadlineAleatoria();
			int tempo = tempoAleatorio();
			String estado = "pronto";

			adicionarProcesso(new Processo(tempo, deadline, estado));
		}
	}

	public static void adicionarProcesso(Processo processo) {

		if (temProcesso()) {
			for (int i = 0; i < processosOrdenados.size(); i++) {
				if (processo.getDeadline() < processosOrdenados.get(i).getDeadline()) {
					processosOrdenados.add(processo);
					Collections.sort(processosOrdenados);
				}
			}

		} else {
			processosOrdenados.add(processo);
		}
	}

	public static boolean temProcesso() {
		if (processosOrdenados.size() > 0) {
			return true;
		} else {
			return false;
		}
	}

	public void run() {
		inserirProcessos(processos);

		for (int i = 0; i < cores; i++) {
			CoreLTG a = new CoreLTG();
			a.start();
			listaCores.add(a);
		}

		if (temProcesso() || aindaTemCore(listaCores)) {

			for (int i = 0; i < listaCores.size(); i++) {

				if (listaCores.get(i).prontoParaReceberProcesso()) { //SE.CORE.TIVER.OCIOSO

					if (listaCores.get(i).getProcessoEmAndamento() != null) { //TIRA.PRCESSO.DO.CORE

						if (listaCores.get(i).getProcessoEmAndamento().estado.equalsIgnoreCase("Terminado")) {

							listaTerminados.add(listaCores.get(i).getProcessoEmAndamento());

						}
					}

					if (temProcesso()) {
						listaCores.get(i).setProcessoEmAndamento(processosOrdenados.remove(0)); // REMOVE.O.PRIMEIRO

					}
				}
			}
		}

		for (int i = 0; i < processosOrdenados.size(); i++) {
			if (processosOrdenados.get(i).getEstado().equalsIgnoreCase("Abortado")) {
				listaTerminados.add(processosOrdenados.get(i));
				processosOrdenados.remove(i);

			}
		}

	}

	public static boolean aindaTemCore(ArrayList<CoreLTG> cores) {
		for (int i = 0; i < cores.size(); i++) {
			if (cores.get(i).getProcessoEmAndamento() != null) {
				return true;
			}
		}
		return false;
	}

}
