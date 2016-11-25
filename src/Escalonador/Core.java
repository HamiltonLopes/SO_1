package Escalonador;

import java.awt.Color;

import javax.swing.JTextArea;

public abstract class Core extends Thread {

	private static int idUniversal = 0;
	private Processo processoEmAndamento;
	public boolean processamento;
	private boolean prontoParaReceberProcesso;
	private int id;
	protected JTextArea textAreaProcessos = new JTextArea(6,16);

	public Core() {
		this.id = idUniversal++;
		processoEmAndamento = null;
		processamento = true;
		prontoParaReceberProcesso = true;
		
		
		textAreaProcessos.setBackground(new Color(153, 255, 102));
		textAreaProcessos.setEditable(false);
		interAddPanel();
		textAreaProcessos.setText(this.toString());			
	}
	
	protected abstract void interAddPanel(); //METODO PARA SER IMPLEMENTADO NAS CLASSES QUE VAO EXTENDER, ONDE SER� ALIMENTADO A INTERFACE COM O TEXT AREA DOS PROCESSOS

	public long getId() {
		return id;
	}

	public Processo getProcessoEmAndamento() {
		return processoEmAndamento;
	}

	public void setProcessoEmAndamento(Processo processo) {
		this.processoEmAndamento = processo;
	}

	public boolean prontoParaReceberProcesso() {
		return prontoParaReceberProcesso;
	}

	public void setProntoParaReceberProcesso(boolean pronto) {
		this.prontoParaReceberProcesso = pronto;
	}

	public void finalizar() {
		processamento = false;
	}

	public void run() {
		while (processamento) {
			textAreaProcessos.setText(this.toString());
			if (processoEmAndamento != null && !prontoParaReceberProcesso) {
				textAreaProcessos.setBackground(processoEmAndamento.executando);
				processoEmAndamento.estado = "executando";
				int quantum = processoEmAndamento.quantum;
				while ((processoEmAndamento.getTempoDeExecucao() > 0) && quantum > 0) {
					
					
					processoEmAndamento.setTempoDeExecucao(processoEmAndamento.getTempoDeExecucao() - 1);
					quantum--;
					try {
						Thread.sleep(1000);
					} catch (Exception e) {
					}
					textAreaProcessos.setText(this.toString());
					
				}

				if (processoEmAndamento.getTempoDeExecucao() == 0) {
					processoEmAndamento.estado = "terminado";

				} else {
					processoEmAndamento.estado = "Esperando";
				}
				prontoParaReceberProcesso = true;
			}

		}
	}

	public String toString() {
		String retornoCore = " ID DO CORE = " + id;
		if(processoEmAndamento != null){
			retornoCore+= processoEmAndamento.toString() ;
		}else{
			retornoCore += "\n Ocioso";
		}
		return retornoCore;
	}

}
