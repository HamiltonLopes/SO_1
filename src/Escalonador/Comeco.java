package Escalonador;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import EscalonamentoBestFit.InterfaceInicialBF;
import EscalonamentoMergeFit.InterfaceInicialMF;
import EscalonamentoQuickFit.InterfaceInicialQF;

public class Comeco extends JFrame {

	private JPanel contentPane;
	
	public Comeco() {
		
		getContentPane().setLayout(null);
		
		setTitle("Escalonadores de Processos");
		setVisible(true);
		setSize(565, 351);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);		
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 153, 153));
		panel.setBounds(0, 0, 567, 327);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnBestFit = new JButton("Best Fit"); // BOTAO INICIO
		btnBestFit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				callBF();
			}
		});
		btnBestFit.setBounds(211, 138, 134, 23);
		panel.add(btnBestFit);
		
//		JButton btnLtg = new JButton("LTG");
//		btnLtg.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent arg0) {
//			}
//		});
//		btnLtg.setBounds(108, 139, 134, 23);
//		panel.add(btnLtg);
		
		JLabel lblEscalonadorDeProcessos = new JLabel("ESCALONADOR DE PROCESSOS"); // LABEL DO TITULO
		lblEscalonadorDeProcessos.setForeground(new Color(255, 255, 255));
		lblEscalonadorDeProcessos.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblEscalonadorDeProcessos.setBounds(20, 11, 535, 81);
		lblEscalonadorDeProcessos.setHorizontalAlignment(JLabel.CENTER);
		panel.add(lblEscalonadorDeProcessos);
		
		JButton btnMergeFit = new JButton("Merge Fit");
		btnMergeFit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				callMF();
			}
		});
		
		btnMergeFit.setBounds(211, 181, 134, 23);
		panel.add(btnMergeFit);
		
		JButton btnQuickFit = new JButton("Quick Fitness");
		btnQuickFit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				callQF();
			}
		});
		btnQuickFit.setBounds(211, 225, 134, 23);
		panel.add(btnQuickFit);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	public void callQF(){
		this.setVisible(false);
		InterfaceInicialQF inter = new InterfaceInicialQF();
		inter.setVisible(true);
	}
	
	public void callMF(){
		this.setVisible(false);
		InterfaceInicialMF inter = new InterfaceInicialMF();
		inter.setVisible(true);
	}
	
	public void callBF(){
		this.setVisible(false);
		InterfaceInicialBF inter = new InterfaceInicialBF();
		inter.setVisible(true);
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Comeco frame = new Comeco();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
