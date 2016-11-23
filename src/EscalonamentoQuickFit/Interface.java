package EscalonamentoQuickFit;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import FIFO.Fila;

public class Interface extends JFrame {


	static Fila f = new Fila();

	//Processo processo = new Processo(); // RETIRANDO PROCESSO DESNECESSARIO

	public JTextField caixaProcessos;
	public JTextField caixaQuantun;
	public String quant;
	private JTextField caixaCores;
	private JTextField numListaTop; // CAIXA DE TEXTO ONDE IRÁ INDICAR O NUMERO DE LISTAS TOPS
	private JTextField tamMinBloco; // VAIXA DE TEXTO ONDE IRÁ INDICAR O TAMANHO MINIMO DOS BLOCOS
	private JTextField tamMaxBloco; // CAIXA DE TEXTO ONDE IRÁ INDICAR O TAMANHO MAXIMO DOS BLOCOS
	private JTextField nPrscssF; // CAIXA DE TEXTO ONDE IRÁ INDICAR O NUMERO DE PROCESSOS CRIADOS PARA PODER GERAR A FILA TOP
	private JTextField qtdMemoria;

	public Interface(){

		getContentPane().setLayout(null);

		setTitle("Escalonador de Processos");
		setVisible(true);
		setSize(509, 417);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);


		JPanel panelRR = new JPanel();
		panelRR.setBackground(new Color(0, 153, 153));
		panelRR.setBounds(-177, -51, 806, 440);
		panelRR.setLayout(null);		

		caixaProcessos = new JTextField();
		caixaProcessos.setBounds(543, 134, 86, 20);
		panelRR.add(caixaProcessos);
		caixaProcessos.setColumns(10);

		caixaQuantun = new JTextField();
		caixaQuantun.setBounds(543, 197, 86, 20);
		panelRR.add(caixaQuantun);
		caixaQuantun.setColumns(10);
		quant = caixaQuantun.getText();	

		caixaCores = new JTextField();
		caixaCores.setBounds(543, 165, 86, 20);
		panelRR.add(caixaCores);
		caixaCores.setColumns(10);

		JLabel lblProcessos = new JLabel("Processos");
		lblProcessos.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblProcessos.setForeground(new Color(255, 255, 255));
		lblProcessos.setBounds(444, 134, 86, 14);
		panelRR.add(lblProcessos);

		JLabel lblQuantum = new JLabel("Quantum");
		lblQuantum.setForeground(Color.WHITE);
		lblQuantum.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblQuantum.setBounds(452, 197, 78, 14);
		panelRR.add(lblQuantum);	

		getContentPane().add(panelRR);

		JLabel lblCores = new JLabel("Cores");
		lblCores.setForeground(Color.WHITE);
		lblCores.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblCores.setBounds(476, 166, 63, 20);
		panelRR.add(lblCores);

		JLabel lblRoundRobin = new JLabel("Quick Fit");
		lblRoundRobin.setForeground(Color.WHITE);
		lblRoundRobin.setHorizontalAlignment(JLabel.CENTER);
		lblRoundRobin.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblRoundRobin.setBounds(182, 65, 499, 57);
		panelRR.add(lblRoundRobin);
		
		JButton btnComear = new JButton("Inicio");
		btnComear.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				QuickFit.processos = Integer.parseInt(caixaProcessos.getText());
				QuickFit.cores = Integer.parseInt(caixaCores.getText());
				QuickFit.quantum = Integer.parseInt(caixaQuantun.getText());
				QuickFit.NUM_LISTA_TOP = Integer.parseInt(numListaTop.getText()); // ALIMENTAR A VARIAVEL PARA SABER O NUMERO DE LISTAS TOP
				QuickFit.VALOR_MINIMO = Integer.parseInt(tamMinBloco.getText());// ALIMENTA A VARIAVEL PARA SABER O TAMANHO MINIMO DOS BLOCOS
				QuickFit.VALOR_MAXIMO = Integer.parseInt(tamMaxBloco.getText());// ALIMENTA A VARIAVEL PARA SABER O TAMANHO MAXIMO DOS BLOCOS
				QuickFit.NUM_PROCESSOS_PARA_CRIAR_LISTAS_TOP = Integer.parseInt(nPrscssF.getText()); // ALIMENTA A VARIAVEL PARA SABER O NUMERO DE PROCESSOS QUE PRECISARÃO SER CRIADOS PARA INICIALIZAR AS LISTAS TOP
				Memoria.MEMORIA_TOTAL = Integer.parseInt(qtdMemoria.getText());// ALIMENTA A VARIAVEL PARA SABER O TAMANHO TOTAL DA MEMORIA EM BYTES
				QuickFit mrr = new QuickFit();
				mrr.start();
				fechar();
				//mrr.iniciar();
			}
		});
		btnComear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnComear.setBounds(387, 389, 117, 25);
		panelRR.add(btnComear);
		
		numListaTop = new JTextField(); // INICIALIZAR A CAIXA
		numListaTop.setBounds(543, 229, 86, 20); // POSICIONAR A CAIXA
		panelRR.add(numListaTop); // ADICIONANDO A CAIXA NO PANEL
		numListaTop.setColumns(10); // MAIS UMA CONFIGURAÇÃO DE POSIÇÃO
		
		tamMinBloco = new JTextField(); // INICIALIZAR A CAIXA
		tamMinBloco.setColumns(10);// MAIS UMA CONFIGURAÇÃO DE POSIÇÃO
		tamMinBloco.setBounds(543, 261, 86, 20);// POSICIONAR A CAIXA
		panelRR.add(tamMinBloco);// ADICIONANDO A CAIXA NO PANEL
		
		tamMaxBloco = new JTextField(); // INICIALIZAR A CAIXA
		tamMaxBloco.setColumns(10);// MAIS UMA CONFIGURAÇÃO DE POSIÇÃO
		tamMaxBloco.setBounds(543, 293, 86, 20); // POSICIONAR A CAIXA
		panelRR.add(tamMaxBloco);// ADICIONANDO A CAIXA NO PANEL
		
		nPrscssF = new JTextField(); // INICIALIZAR A CAIXA
		nPrscssF.setColumns(10);// MAIS UMA CONFIGURAÇÃO DE POSIÇÃO
		nPrscssF.setBounds(543, 322, 86, 20); // POSICIONAR A CAIXA
		panelRR.add(nPrscssF);// ADICIONANDO A CAIXA NO PANEL
		
		JLabel labelNLista = new JLabel("Numero de listas top"); //LABEL QUE IRÁ INFORMAR AO USUARIO OQ ELE DEVE PREENCHER NO CAMPO
		labelNLista.setForeground(Color.WHITE); // FONTE BRANCA
		labelNLista.setFont(new Font("Dialog", Font.BOLD, 15)); // CONFIGURACAO DE FONTE
		labelNLista.setBounds(348, 231, 177, 14); // CONFIGURACAO DE POSICAO
		panelRR.add(labelNLista); // ADICIONANDO O LABEL NO PANEL
		
		JLabel lblTamMin = new JLabel("Tamanho min bloco em bytes");//LABEL QUE IRÁ INFORMAR AO USUARIO OQ ELE DEVE PREENCHER NO CAMPO
		lblTamMin.setForeground(Color.WHITE);// FONTE BRANCA
		lblTamMin.setFont(new Font("Dialog", Font.BOLD, 15));// CONFIGURACAO DE FONTE
		lblTamMin.setBounds(282, 261, 257, 14);// CONFIGURACAO DE POSICAO
		panelRR.add(lblTamMin); // ADICIONANDO O LABEL NO PANEL
		
		JLabel lblNEstatistica = new JLabel("N processos necessarios para criar listas");//LABEL QUE IRÁ INFORMAR AO USUARIO OQ ELE DEVE PREENCHER NO CAMPO
		lblNEstatistica.setForeground(Color.WHITE);// FONTE BRANCA
		lblNEstatistica.setFont(new Font("Dialog", Font.BOLD, 15));// CONFIGURACAO DE FONTE
		lblNEstatistica.setBounds(195, 324, 344, 14);// CONFIGURACAO DE POSICAO
		panelRR.add(lblNEstatistica); // ADICIONANDO O LABEL NO PANEL
		
		JLabel lblTamMaxBloco = new JLabel("Tamanho max bloco em bytes");//LABEL QUE IRÁ INFORMAR AO USUARIO OQ ELE DEVE PREENCHER NO CAMPO
		lblTamMaxBloco.setForeground(Color.WHITE);// FONTE BRANCA
		lblTamMaxBloco.setFont(new Font("Dialog", Font.BOLD, 15));// CONFIGURACAO DE FONTE
		lblTamMaxBloco.setBounds(280, 293, 259, 14);// CONFIGURACAO DE POSICAO
		panelRR.add(lblTamMaxBloco); // ADICIONANDO O LABEL NO PANEL
		
		qtdMemoria = new JTextField();// INICIALIZAR A CAIXA
		qtdMemoria.setColumns(10); // MAIS UMA CONFIGURAÇÃO DE POSIÇÃO
		qtdMemoria.setBounds(543, 348, 86, 20);// POSICIONAR A CAIXA
		panelRR.add(qtdMemoria); // ADICIONANDO A CAIXA NO PANEL

		JLabel lblqtdMemoria = new JLabel("Memoria total"); //LABEL QUE IRÁ INFORMAR AO USUARIO OQ ELE DEVE PREENCHER NO CAMPO
		lblqtdMemoria.setForeground(Color.WHITE); // FONTE BRANCA
		lblqtdMemoria.setFont(new Font("Dialog", Font.BOLD, 15)); // CONFIGURACAO DE FONTE
		lblqtdMemoria.setBounds(413, 350, 117, 14); // CONFIGURACAO DE POSICAO
		panelRR.add(lblqtdMemoria);// ADICIONANDO O LABEL NO PANEL
	}
	
	public void fechar(){
		this.setVisible(false);
	}
}
