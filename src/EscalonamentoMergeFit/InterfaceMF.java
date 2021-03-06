package EscalonamentoMergeFit;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;

import Escalonador.Processo;
import FIFO.Fila;

public class InterfaceMF extends JFrame {
	JFrame frame;
	public static JPanel panelProcessos = new JPanel();

	static JTextArea textArea_1 = new JTextArea();
	static JTextArea textArea_2 = new JTextArea();
	static JTextArea textArea_3 = new JTextArea();
	static JTextArea textArea_4 = new JTextArea();
	static JPanel panelTerminados = new JPanel();
	static JScrollPane scrollListaBlocos = new JScrollPane(); // CRIA O SCROLL
	static JPanel panelListadeBlocos = new JPanel(); // CRIA O PANEL
	static JPanel panel = new JPanel();

	public InterfaceMF(Fila q, Fila q2, Fila q3, Fila q4, ArrayList<CoreMerge> cores, ArrayList<Processo> terminados) {
		setSize(889, 783);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		setTitle("Merge Fit");
		getContentPane().setLayout(null);

		panel.setForeground(new Color(153, 153, 204));
		textArea_1.setBounds(38, 245, 130, 126);
		textArea_2.setBounds(194, 245, 130, 126);
		textArea_3.setBounds(352, 245, 130, 126);
		textArea_4.setBounds(509, 245, 130, 126);

		panel.add(textArea_1);
		panel.add(textArea_2);
		panel.add(textArea_3);
		panel.add(textArea_4);

		panel.setBackground(new Color(0, 153, 153));
		panel.setBounds(0, 0, 974, 845);
		getContentPane().add(panel);
		panel.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(28, 24, 846, 153);
		panel.add(scrollPane);

		panelProcessos.setBackground(Color.WHITE);
		scrollPane.setViewportView(panelProcessos);
		panelProcessos.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		
		
		
		/*		 M�TODO DE MOSTRAR AS LISTAS		*/
		// ------------------------------------- CRIANDO O PANEL E SCROLL DA LISTA DE LISTAS ---------------------------
		 
		panel.add(scrollListaBlocos); // ADICIONA O SCROLL NO PANEL PRINCIPAL
		scrollListaBlocos.setBounds(28, 586, 788, 120); // POE O TAMANHO DO SCROLL
		panelListadeBlocos.setBounds(0, 0, 10, 10); // POE O TAMANHO DO PANEL
		scrollListaBlocos.setViewportView(panelListadeBlocos); // ADICIONA O PANEL COMO VIEWPORT DO SCROLL
		panelListadeBlocos.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5)); // ADICIONA O LAYOUT HORIZONTAL AO PANEL (PARA EXIBIR AS LISTAS UMA DO LADO DA OUTRA)
		

		JButton btnAdicionarProcesso = new JButton("Adicionar Processo");
		btnAdicionarProcesso.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				MergeFit.adicionarProcessos(1, new Color(204, 204, 204), new Color(204, 204, 204), new Color(204, 204, 204), new Color(204, 204, 204));
				MergeFit.attFilas();
				revalidate();
			}
		});
		btnAdicionarProcesso.setBounds(723, 188, 151, 23);
		panel.add(btnAdicionarProcesso);

		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(28, 398, 622, 152);
		panel.add(scrollPane_2);

		panelTerminados.setBackground(new Color(245, 245, 245));
		scrollPane_2.setViewportView(panelTerminados);
		panelTerminados.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));

		for (int i = 0; i < terminados.size(); i++) {
			JTextArea textAreaTerminados = new JTextArea(3, 16);
			textAreaTerminados.setBackground(new Color(255, 99, 71));
			panelTerminados.add(textAreaTerminados);
			textAreaTerminados.setText(terminados.get(i).toString());
		}

		JTextPane textPane1 = new JTextPane();
		textPane1.setForeground(Color.WHITE);
		textPane1.setFont(new Font("Tahoma", Font.BOLD, 11));
		textPane1.setBackground(new Color(0, 153, 153));
		textPane1.setText("        FILA \r\nPRIORIDADE 0\r\n");
		textPane1.setBounds(49, 214, 105, 36);
		panel.add(textPane1);

		JTextPane textPane2 = new JTextPane();
		textPane2.setText("        FILA \r\nPRIORIDADE 1\r\n");
		textPane2.setForeground(Color.WHITE);
		textPane2.setFont(new Font("Tahoma", Font.BOLD, 11));
		textPane2.setBackground(new Color(0, 153, 153));
		textPane2.setBounds(213, 214, 90, 36);
		panel.add(textPane2);

		JTextPane textPane3 = new JTextPane();
		textPane3.setText("        FILA \r\nPRIORIDADE 2\r\n");
		textPane3.setForeground(Color.WHITE);
		textPane3.setFont(new Font("Tahoma", Font.BOLD, 11));
		textPane3.setBackground(new Color(0, 153, 153));
		textPane3.setBounds(375, 214, 107, 36);
		panel.add(textPane3);

		JTextPane textPane4 = new JTextPane();
		textPane4.setText("        FILA \r\nPRIORIDADE 3\r\n");
		textPane4.setForeground(Color.WHITE);
		textPane4.setFont(new Font("Tahoma", Font.BOLD, 11));
		textPane4.setBackground(new Color(0, 153, 153));
		textPane4.setBounds(529, 214, 90, 36);
		panel.add(textPane4);
		
		JButton btnTerminar = new JButton("Terminar");
		btnTerminar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				MergeFit.terminar();
				mostrarUltimoBloco(); // CHAMA O ULTIMO BLOCO
			}
		});
		btnTerminar.setBounds(727, 504, 89, 23);
		panel.add(btnTerminar);
		
		JLabel lblCores = new JLabel("Cores");
		lblCores.setForeground(new Color(153, 255, 204));
		lblCores.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCores.setBounds(30, 11, 46, 14);
		panel.add(lblCores);
		
		JLabel lblFilaTerminados = new JLabel("Fila Terminados");
		lblFilaTerminados.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblFilaTerminados.setForeground(new Color(153, 255, 204));
		lblFilaTerminados.setBounds(31, 382, 157, 14);
		panel.add(lblFilaTerminados);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(153, 255, 102));
		panel_1.setBounds(695, 245, 34, 36);
		panel.add(panel_1);
		
		JTextPane txtpnProcesso = new JTextPane();
		txtpnProcesso.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtpnProcesso.setForeground(new Color(255, 255, 255));
		txtpnProcesso.setBackground(new Color(0, 153, 153));
		txtpnProcesso.setText("PROCESSO\r\nEXECUTANDO\r\n");
		txtpnProcesso.setBounds(739, 244, 90, 36);
		panel.add(txtpnProcesso);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(153, 204, 204));
		panel_2.setBounds(695, 292, 34, 36);
		panel.add(panel_2);
		
		JTextPane txtpnProcessoPronto = new JTextPane();
		txtpnProcessoPronto.setText("PROCESSO\r\nPRONTO\r\n");
		txtpnProcessoPronto.setForeground(Color.WHITE);
		txtpnProcessoPronto.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtpnProcessoPronto.setBackground(new Color(0, 153, 153));
		txtpnProcessoPronto.setBounds(739, 292, 90, 36);
		panel.add(txtpnProcessoPronto);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(255, 204, 102));
		panel_3.setBounds(695, 339, 34, 36);
		panel.add(panel_3);
		
		JTextPane txtpnProcessoEmEspera = new JTextPane();
		txtpnProcessoEmEspera.setText("PROCESSO\r\nEM ESPERA\r\n");
		txtpnProcessoEmEspera.setForeground(Color.WHITE);
		txtpnProcessoEmEspera.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtpnProcessoEmEspera.setBackground(new Color(0, 153, 153));
		txtpnProcessoEmEspera.setBounds(739, 339, 90, 36);
		panel.add(txtpnProcessoEmEspera);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(255, 99, 71));
		panel_4.setBounds(695, 387, 34, 36);
		panel.add(panel_4);
		
		JTextPane txtpnProcessoTerminado = new JTextPane();
		txtpnProcessoTerminado.setText("PROCESSO\r\nTERMINADO\r\n");
		txtpnProcessoTerminado.setForeground(Color.WHITE);
		txtpnProcessoTerminado.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtpnProcessoTerminado.setBackground(new Color(0, 153, 153));
		txtpnProcessoTerminado.setBounds(739, 387, 90, 36);
		panel.add(txtpnProcessoTerminado);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(204, 204, 204));
		panel_5.setBounds(695, 436, 34, 36);
		panel.add(panel_5);
		
		JTextPane txtpnProcessoAdicionado = new JTextPane();
		txtpnProcessoAdicionado.setText("PROCESSO\r\nADICIONADO  \r\n");
		txtpnProcessoAdicionado.setForeground(Color.WHITE);
		txtpnProcessoAdicionado.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtpnProcessoAdicionado.setBackground(new Color(0, 153, 153));
		txtpnProcessoAdicionado.setBounds(739, 436, 90, 36);
		panel.add(txtpnProcessoAdicionado);
		
		JLabel lblListasTop = new JLabel("Lista de blocos"); // LABEL QUE INDICA QUE O CAMPO ABAIXO SÃO OS BLOCOS
		lblListasTop.setForeground(new Color(153, 255, 204)); // CONFIGURAÇÃO DE COR DE FONTE
		lblListasTop.setFont(new Font("Dialog", Font.BOLD, 11)); // CONFIGURAÇÃO DE FONTE
		lblListasTop.setBounds(28, 572, 157, 14); // CONFIGURAÇÃO DE POSIÇÃO
		panel.add(lblListasTop); // ADICIONANDO NO PANEL PRINCIPAL O LABEL

	}
	
	public static void repaintPanelListaBloco(){ // REPINTA O PANEL DO SCROLL DAS LISTAS
		panelListadeBlocos.repaint();
	}
	
	public void mostrarUltimoBloco(){ //APARECER O ULTIMO BLOCO
		JScrollPane novo = new JScrollPane(); // CRIA UM NOVO SCROLL PRA MOSTRAR O UTLIMO BLOCO
		JPanel novo2 = new JPanel(); // CRIA UM NOVO PANEL PRA MOSTRAR O ULTIMO BLOCO
		panel.remove(scrollListaBlocos); // REMOVE O SCROLL ANTIGO Q NA HORA Q CHAMAR O METODO VAI TA BUGADO
		panel.add(novo); // ADICIONA O NOVO SCROLL NO PANEL PRINCIPAL
		novo.setBounds(28, 586, 788, 120); // POE O TAMANHO DO SCROLL
		novo2.setBounds(0, 0, 10, 10); // POE O TAMANHO DO PANEL
		novo.setViewportView(panelListadeBlocos); // ADICIONA O NOVO PANEL COMO VIEWPORT DO NOVO SCROLL
		novo2.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5)); // ADICIONA O LAYOUT HORIZONTAL AO PANEL (PARA EXIBIR AS LISTAS UMA DO LADO DA OUTRA)
		JTextArea txtAreaBlocos = new JTextArea(4,16); //CRIA UM TXTAREA Q REPRESENTA O ULTIMO BLOCO
		txtAreaBlocos.setText("Bytes = "+MemoriaMerge.MEMORIA_TOTAL+"\nProcesso = Sem processo\nEstado = Livre"); // POE AS INFORMA��ES DO ULTIMO BLOCO
		txtAreaBlocos.setBackground(new Color(102, 204, 102)); /// ADICIONA UMA COR AO TXTAREA DO BLOCO
		txtAreaBlocos.setEditable(false); // TIRA O EDITABLE PARA NÃO PODER EDITAR QUANDO ESTIVER EXECUTANDO
		novo.add(txtAreaBlocos); // ADICIONA O TXTAREA NO PANEL
		novo.repaint(); // REPINTA O PANEL
	}
	
}
