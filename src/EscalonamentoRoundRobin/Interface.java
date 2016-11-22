package EscalonamentoRoundRobin;

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

	public Interface(){

		getContentPane().setLayout(null);

		setTitle("Escalonador de Processos");
		setVisible(true);
		setSize(370, 366);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);


		JPanel panelRR = new JPanel();
		panelRR.setBackground(new Color(0, 153, 153));
		panelRR.setBounds(-177, -51, 531, 378);
		panelRR.setLayout(null);		

		caixaProcessos = new JTextField();
		caixaProcessos.setBounds(349, 142, 86, 20);
		panelRR.add(caixaProcessos);
		caixaProcessos.setColumns(10);

		caixaQuantun = new JTextField();
		caixaQuantun.setBounds(349, 205, 86, 20);
		panelRR.add(caixaQuantun);
		caixaQuantun.setColumns(10);
		quant = caixaQuantun.getText();	

		caixaCores = new JTextField();
		caixaCores.setBounds(349, 173, 86, 20);
		panelRR.add(caixaCores);
		caixaCores.setColumns(10);

		JLabel lblProcessos = new JLabel("Processos");
		lblProcessos.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblProcessos.setForeground(new Color(255, 255, 255));
		lblProcessos.setBounds(253, 143, 86, 14);
		panelRR.add(lblProcessos);

		JLabel lblQuantum = new JLabel("Quantum");
		lblQuantum.setForeground(Color.WHITE);
		lblQuantum.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblQuantum.setBounds(261, 206, 78, 14);
		panelRR.add(lblQuantum);	

		getContentPane().add(panelRR);

		JLabel lblCores = new JLabel("Cores");
		lblCores.setForeground(Color.WHITE);
		lblCores.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblCores.setBounds(285, 175, 63, 20);
		panelRR.add(lblCores);

		JButton btnComecar = new JButton("comecar");
		btnComecar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnComecar.setBounds(200, 243, 89, 23);
		panelRR.add(btnComecar);
		//EVENTO
		btnComecar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MainRoundRobin.processos = Integer.parseInt(caixaProcessos.getText());
				MainRoundRobin.cores = Integer.parseInt(caixaCores.getText());
				MainRoundRobin.quantum = Integer.parseInt(caixaQuantun.getText());
				MainRoundRobin mrr = new MainRoundRobin();
				mrr.start();
				fechar();
				//mrr.iniciar();

			}
		});
		btnComecar.setBounds(305, 259, 89, 23);

		JLabel lblRoundRobin = new JLabel("Round Robin");
		lblRoundRobin.setForeground(Color.WHITE);
		lblRoundRobin.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblRoundRobin.setBounds(253, 70, 290, 57);
		panelRR.add(lblRoundRobin);
	}
	
	public void fechar(){
		this.setVisible(false);
	}

//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Interface frame = new Interface();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//
//	}


}
