package EscalonamentoQuickFit;

import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextField;


public class Lista { // LISTA TOP ( SE A QUANTIDADE DE BYTES FOR 999 INDICA FILA RESTO )

	private int bytes; // BYTES CORRESPONDENTE A LISTA TOP
	private ArrayList<Bloco> blocos= new ArrayList<Bloco>(); //BLOCOS ALOCADOS COM ESSA QUANTIDADE DE BYTES
	private JScrollPane scrollListaTop = new JScrollPane(); // CRIA O SCROLL DA LISTA
	private JPanel panelListaTop = new JPanel(); // CRIA O PANEL
	private JTextField txtFieldNomeLista = new JTextField(16); // CRIA UM TEXTFIELD PARA SER O TITULO DA LISTA
	
	public Lista(Estatistica e) { // RECEBE UMA ESTATISTICA COMO PARAMETRO
		super();
		this.bytes = e.getBytes(); // CRIA UMA LISTA DE ACORDO COM UMA ESTATISTICA
		this.scrollListaTop.setBounds(0, 0, 100, 342); // POE O TAMANHO DO SCROLL
		this.scrollListaTop.setViewportView(panelListaTop); // ADICIONA O PANEL COMO VIEWPORT DO SCROLL
		this.panelListaTop.setLayout(new BoxLayout(panelListaTop, BoxLayout.Y_AXIS)); // ADICIONA O LAYOUT VERTICAL AO PANEL (PARA EXIBIR OS BLOCOS UM ABAIXO DO OUTRO)
		this.txtFieldNomeLista.setBackground(new Color(102, 204, 102)); // COLOCA UMA COR NO TEXTFIELD
		this.txtFieldNomeLista.setEditable(false); // TIRA O EDITABLE PARA NÃO PODER EDITAR QUANDO ESTIVER EXECUTANDO
		this.panelListaTop.add(txtFieldNomeLista); // ADICIONA O TEXTFIELD NO TOPO DA LISTA, PARA EXIBIR COMO UM TITULO
		// --------------------------- COLOCAR O NOME DA LISTA ------------------------
		if(bytes != 999){// VERIFICA SE A QUANTIDADE DE BYTES É 999, POIS SE FOR QUER DIZER Q ELA É A FILA RESTO
			txtFieldNomeLista.setText("Lista Top "+this.bytes+" Bytes"); // SE FOR UMA DAS FILAS TOPS, ADICIONA O TITULO "FILA TOP + NUMERO DA FILA"
		}else{
			txtFieldNomeLista.setText("Lista Resto"); // SE NÃO FOR UMA DAS FILAS TOPS, ENTÃO ADICOINA O TITULO "FILA RESTO"
		}
		this.txtFieldNomeLista.setHorizontalAlignment(JTextField.CENTER); // POE O TITULO CENTRALIZADO
		JSeparator sep2 = new JSeparator(); // CRIA UM SEPARADOR, PARA ADICIONAR ENTRE O TITULO E O PROXIMO BLOCO
	    sep2.setMaximumSize(new Dimension((int) sep2.getMaximumSize().getWidth(), 50)); // SETA O TAMANHO DO SEPARADOR
	    this.panelListaTop.add(sep2); // ADICIONA O SEPARADOR NO PANEL DA LISTA
	    InterfaceRR.panelListadeLista.add(scrollListaTop); // ADICIONA O SCROLL DA LISTA NO PANEL VIEWPORT DO SCROLL DA LISTA DE LISTAS
	}
	
	public Lista(int e) { // RECEBE UMA QUANTIDADE DE BYTES EM UM INTEIRO
		super();
		this.bytes = e; // CRIA UMA LISTA DE ACORDO COM ESSE INTEIRO
		this.scrollListaTop.setBounds(0, 0, 100, 342); // POE O TAMANHO DO SCROLL
		this.scrollListaTop.setViewportView(panelListaTop); // ADICIONA O PANEL COMO VIEWPORT DO SCROLL
		this.panelListaTop.setLayout(new BoxLayout(panelListaTop, BoxLayout.Y_AXIS)); // ADICIONA O LAYOUT VERTICAL AO PANEL (PARA EXIBIR OS BLOCOS UM ABAIXO DO OUTRO)
		this.txtFieldNomeLista.setBackground(new Color(102, 204, 102)); // COLOCA UMA COR NO TEXTFIELD
		this.txtFieldNomeLista.setEditable(false); // TIRA O EDITABLE PARA NÃO PODER EDITAR QUANDO ESTIVER EXECUTANDO
		this.panelListaTop.add(txtFieldNomeLista); // ADICIONA O TEXTFIELD NO TOPO DA LISTA, PARA EXIBIR COMO UM TITULO
		// --------------------------- COLOCAR O NOME DA LISTA ------------------------
		if(bytes != 999){// VERIFICA SE A QUANTIDADE DE BYTES É 999, POIS SE FOR QUER DIZER Q ELA É A FILA RESTO
			txtFieldNomeLista.setText("Lista Top "+this.bytes+" Bytes"); // SE FOR UMA DAS FILAS TOPS, ADICIONA O TITULO "FILA TOP + NUMERO DA FILA"
		}else{
			txtFieldNomeLista.setText("Lista Resto"); // SE NÃO FOR UMA DAS FILAS TOPS, ENTÃO ADICOINA O TITULO "FILA RESTO"
		}
		this.txtFieldNomeLista.setHorizontalAlignment(JTextField.CENTER); // POE O TITULO CENTRALIZADO
		JSeparator sep2 = new JSeparator(); // CRIA UM SEPARADOR, PARA ADICIONAR ENTRE O TITULO E O PROXIMO BLOCO
	    sep2.setMaximumSize(new Dimension((int) sep2.getMaximumSize().getWidth(), 50)); // SETA O TAMANHO DO SEPARADOR
	    this.panelListaTop.add(sep2); // ADICIONA O SEPARADOR NO PANEL DA LISTA
	    InterfaceRR.panelListadeLista.add(scrollListaTop); // ADICIONA O SCROLL DA LISTA NO PANEL VIEWPORT DO SCROLL DA LISTA DE LISTAS
	}

	public int getBytes() { // RETORNA A QUANTIDADE DE BYTES DOS BLOCOS DESSA LISTA TOP
		return bytes;
	}
	
	public boolean addBloco(Bloco bloco){ // ADICIONA UM BLOCO NA LISTA DE BLOCOS ALOCADOS
		if(bloco.getTamanho() == this.bytes || this.bytes == 999){ //VERIFICA SE A QUANTIDADE DE BYTES DO BLOCO É CORRESPONDENTE COM A LISTA TOP OU ELA É A FILA DE RESTOS
			blocos.add(bloco); // SE SIM ADCICIONA
			this.panelListaTop.add(bloco.getJTextArea()); // ADICIONA O TXT AREA DO BLOCO NA LISTA TOP
			JSeparator sep = new JSeparator(); // CRIA UM SEPARADOR PARA SEPARAR OS BLOCOS UNS DOS OUTROS
		    sep.setMaximumSize(new Dimension((int) sep.getMaximumSize().getWidth(), 50)); // SETA O TAMANHO DO SEPARADOR
		    panelListaTop.add(sep); // ADICIONA O SEPARADOR NO PANEL DA LISTA
			return true;	// E RETORNA TRUE PQ DEU CERTO
		}
		return false; // SE NÃO, NÃO FAZ NADA E RETORNA FALSE
	}
	
	public ArrayList<Bloco> getBlocos(){ // RETORNA A LISTA DE BLOCOS DA LISTA TOP
		return blocos;
	}
	
	public boolean temBlocoLivre(){ // RETORNA TRUE CASO A LISTA TOP TENHA PELO MENOS UM BLOCO LIVRE
		for(Bloco bloco : blocos){ // PERCORRE OS BLOCOS
			if(bloco.isLivre()) return true; // CASO O BLOCO SEJA LIVRE RETORNA TRUE
		}
		return false; // SE CHEGOU AQUI � PQ NENHUM BLOCO � LIVRE, LOGO � FALSO
	}
	
	public String toString(){ // TO STRING DA LISTA 
		String retorno = "(";
		if(this.bytes != 999){
			retorno += "Bytes = "+this.bytes;
		}else{
			retorno += "Lista Resto";
		}
		
		return retorno += " "+blocos+")"; // RETORNA A LISTA EM UMA STRING
		
	}

	
	
}