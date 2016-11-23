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
		
		JButton btnRoundRobin = new JButton("Quick Fitness"); // BOTAO INICIO
		btnRoundRobin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				fechar();
			}
		});
		btnRoundRobin.setBounds(211, 138, 134, 23);
		panel.add(btnRoundRobin);
		
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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	public void fechar(){
		this.setVisible(false);
		Interface inter = new Interface();
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
