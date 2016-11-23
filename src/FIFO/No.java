package FIFO;

import EscalonamentoQuickFit.Core;
import EscalonamentoQuickFit.Processo;

public class No {

	Processo processo;
	Core core;
	No anterior;



	public No(){}
	public No(Processo processo, No proximo) {
		this.processo = processo;
		this.anterior = anterior;
	}
	public No(Core core, No proximo) {
		this.core = core;
		this.anterior = anterior;
	}



	public Core getCore() {
		return core;
	}
	public void setCore(Core core) {
		this.core = core;
	}
		
	
	public Processo getProcesso() {
		return processo;
	}
	public void setProcesso(Processo processo) {
		this.processo = processo;
	}


	public No getAnterior() {
		return anterior;
	}
	public void setAnterior(No anterior) {
		this.anterior = anterior;
	}







}

