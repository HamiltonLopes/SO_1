package EscalonamentoMergeFit;

import Escalonador.Core;

public class CoreMerge extends Core {
	@Override
	protected void interAddPanel(){ // IMPLEMENTANDO O METODO DA CLASSE PAI
		InterfaceRR.panelProcessos.add(super.textAreaProcessos); // ALIMENTANDO A INTERFACE COM O TXTAREA DOS PROCESSOS
	}
}
