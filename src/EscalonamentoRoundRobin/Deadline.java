package EscalonamentoRoundRobin;

public class Deadline extends Thread {

	public Processo processo;

	public void run() {
		processo.deadline--;
		
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
		}
		
			if(processo.deadline == 0){
				//textAreaProcessos.setBackground(vermelho);
				processo.estado = "Abortado";
			}else{
				//textAreaProcessos.setBackground(laranja);
			}
		
	}

}
