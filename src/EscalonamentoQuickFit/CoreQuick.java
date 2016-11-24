package EscalonamentoQuickFit;

import Escalonador.Core;

public class CoreQuick extends Core {
	@Override
	protected void interAddPanel(){  // IMPLEMENTANDO O METODO DA CLASSE PAI
		InterfaceQF.panelProcessos.add(super.textAreaProcessos); // ALIMENTANDO A INTERFACE COM O TXTAREA DOS PROCESSOS
	}
}
