package FIFO;

import Escalonador.Processo;
import EscalonamentoQuickFit.CoreQuick;

public class No {

	Processo processo;
	CoreQuick core;
	No anterior;



	public No(){}
	public No(Processo processo, No proximo) {
		this.processo = processo;
		this.anterior = anterior;
	}
	public No(CoreQuick core, No proximo) {
		this.core = core;
		this.anterior = anterior;
	}



	public CoreQuick getCore() {
		return core;
	}
	public void setCore(CoreQuick core) {
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

