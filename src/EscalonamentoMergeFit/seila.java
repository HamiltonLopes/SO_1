package EscalonamentoMergeFit;

public class seila extends Thread{
	public void run(){
		while(true){
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			InterfaceRR.repaintPanelTopLista();
			System.out.println("COMPONENTES = "+InterfaceRR.panelListadeBlocos.getComponentCount());
		}
	}
}
