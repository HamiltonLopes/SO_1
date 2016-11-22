package EscalonamentoRoundRobin;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import java.awt.Font;

public class Comeco extends JFrame {

	private JPanel contentPane;
	
	public Comeco() {
	
		
		getContentPane().setLayout(null);
		
		setTitle("Escalonadores de Processos");
		setVisible(true);
		setSize(370, 366);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);		
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 153, 153));
		panel.setBounds(0, 0, 354, 327);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnRoundRobin = new JButton("Round Robin");
		btnRoundRobin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				fechar();
			}
		});
		btnRoundRobin.setBounds(108, 87, 134, 23);
		panel.add(btnRoundRobin);
		
		JButton btnLtg = new JButton("LTG");
		btnLtg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnLtg.setBounds(108, 139, 134, 23);
		panel.add(btnLtg);
		
		JLabel lblEscalonadorDeProcessos = new JLabel("ESCALONADOR DE PROCESSOS");
		lblEscalonadorDeProcessos.setForeground(new Color(255, 255, 255));
		lblEscalonadorDeProcessos.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblEscalonadorDeProcessos.setBounds(20, 11, 334, 81);
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
