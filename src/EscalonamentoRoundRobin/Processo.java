package EscalonamentoRoundRobin;

import java.awt.Color;

public class Processo implements Comparable<Processo> {
	private static int idProcesso;
	int id;
	int tempoDeExecucao; //TEMPO RESTANTE
	int tempoTotal;
	int prioridade;
	String estado;
	int quantum;
	int deadline;
	
	Color esperando;
	Color pronto;
	Color terminado;
	Color executando;
	
	public Processo(){}
	public Processo(int tempoDeExecucao, int deadline, String estado){}
	public Processo(int tempoDeExecucao,int prioridade, String estado, int quantum, Color pronto, Color esperando, Color terminado, Color executando){
		this.id = idProcesso++;
		this.tempoDeExecucao = this.tempoTotal = tempoDeExecucao;
		this.prioridade = prioridade;
		this.estado = estado;
		this.quantum = quantum;
		this.pronto = pronto;
		this.esperando = esperando;
		this.executando = executando;
		this.terminado = terminado;
	}
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getTempoDeExecucao() {
		return tempoDeExecucao;
	}

	public void setTempoDeExecucao(int tempoDeExecucao) {
		this.tempoDeExecucao = tempoDeExecucao;
	}

	public int getPrioridade() {
		return prioridade;
	}

	public void setPrioridade(int prioridade) {
		this.prioridade = prioridade;
	}
		public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
		
	public int getDeadline() {
		return deadline;
	}
	public void setDeadline(int deadeline) {
		this.deadline = deadeline;
	}
	public String toString(){
		String retorno = "\n ID = " + id + "\n ESTADO = " + estado + "\n TEMPO = " + tempoTotal +"\n TEMPO RESTANTE =" + tempoDeExecucao +"\n PRIORIDADE = " + prioridade + "\n QUANTUM =  " + quantum ;
		return retorno;
	}
	
	public int compareTo(Processo arg0) {
		if (this.deadline < arg0.deadline) {
            return -1;
        }
        if (this.deadline > arg0.deadline) {
            return 1;
        }
        return 0;
	}

}
