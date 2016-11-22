package EscalonamentoRoundRobin;

public class CoreLTG extends Thread {

	private static int idUniversal = 0;
	private Processo processoEmAndamento;
	boolean processamento;
	private boolean prontoParaReceberProcesso;
	private int id;

	public CoreLTG() {
		this.id = idUniversal++;
		processoEmAndamento = null;
		processamento = true;
		prontoParaReceberProcesso = true;

	}

	public Processo getProcessoEmAndamento() {
		return processoEmAndamento;
	}

	public void setProcessoEmAndamento(Processo processoEmAndamento) {
		this.processoEmAndamento = processoEmAndamento;
	}

	public boolean isProcessamento() {
		return processamento;
	}

	public void setProcessamento(boolean processamento) {
		this.processamento = processamento;
	}

	public boolean prontoParaReceberProcesso() {
		return prontoParaReceberProcesso;
	}

	public void setProntoParaReceberProcesso(boolean prontoParaReceberProcesso) {
		this.prontoParaReceberProcesso = prontoParaReceberProcesso;
	}

	public void run() {
		while (processamento) {
			if (processoEmAndamento != null && !prontoParaReceberProcesso) {
				processoEmAndamento.estado = "executando";

				while (processoEmAndamento.getTempoDeExecucao() > 0) {
					processoEmAndamento.setTempoDeExecucao(processoEmAndamento.getTempoDeExecucao() - 1);
		
					try {
						Thread.sleep(1000);
					} catch (Exception e) {
					}

				}

				if (processoEmAndamento.getTempoDeExecucao() == 0) {
					processoEmAndamento.estado = "terminado";
				}
				prontoParaReceberProcesso = true;
			}
		}
	}

	// public String toString() {
	// String retornoCore = " ID DO CORE = " + id;
	// if(processoEmAndamento != null){
	// retornoCore+= processoEmAndamento.toString() ;
	// }else{
	// retornoCore += "\n Ocioso";
	// }
	// return retornoCore;
	// }

}