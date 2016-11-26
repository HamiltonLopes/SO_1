package EscalonamentoBestFit;

import Escalonador.Core;

public class CoreBest extends Core {
	@Override
	protected void interAddPanel(){ // IMPLEMENTANDO O METODO DA CLASSE PAI
		InterfaceBF.panelProcessos.add(super.textAreaProcessos); // ALIMENTANDO A INTERFACE COM O TXTAREA DOS PROCESSOS
	}
}
