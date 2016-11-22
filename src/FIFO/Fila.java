package FIFO;

import EscalonamentoRoundRobin.Core;
import EscalonamentoRoundRobin.Processo;

public class Fila {
	private int qnt;
	private No head;
	private No tail;

	public Fila() {
		this.head = null;
		this.tail = null;
	}

	public No getHead() {
		return head;
	}

	public void setHead(No head) {
		this.head = head;
	}

	public int getQnt() {
		return qnt;
	}

	public void setQnt(int qnt) {
		this.qnt = qnt;
	}

	public synchronized boolean estaVazia() {
		return (this.getQnt() == 0);
	}

	public synchronized void adicionarNaFila(Processo processo) {
		No aux = new No(processo, null);
		if (estaVazia()) {
			tail = aux;
			head = aux;
		} else {

			aux.setAnterior(tail);
			tail = aux;
		}
		this.setQnt(this.getQnt() + 1);
	}

	No removido = new No();

	public synchronized Processo removerDaFila() {

		if (estaVazia()) {
			return null;
		} else {
			removido = head;
			if (removido == tail) {
				this.head = null;
				this.tail = null;
			} else {
				No aux = tail;
				// -1 pq ja começa no ultimo e o outro -1 pq ta excluindo um
				for (int i = 0; i < getQnt() - 2; i++) {
					aux = aux.getAnterior();
				}
				head = aux;
			}
			qnt--;

			return removido.processo;
		}
	}


}
