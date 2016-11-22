package EscalonamentoRoundRobin;

import java.awt.Color;

import javax.swing.JTextArea;

public class Core extends Thread {

	private static int idUniversal = 0;
	private Processo processoEmAndamento;
	 boolean processamento;
	private boolean prontoParaReceberProcesso;
	private int id;
	JTextArea textAreaProcessos = new JTextArea(6,16);

	public Core() {
		this.id = idUniversal++;
		processoEmAndamento = null;
		processamento = true;
		prontoParaReceberProcesso = true;
		
		
		textAreaProcessos.setBackground(new Color(153, 255, 102));
		textAreaProcessos.setEditable(false);
		InterfaceRR.panelProcessos.add(textAreaProcessos);
		textAreaProcessos.setText(this.toString());			
	}

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
