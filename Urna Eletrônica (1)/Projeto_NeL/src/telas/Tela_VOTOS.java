package telas;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.TextArea;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.text.AbstractDocument.Content;
import javax.swing.ImageIcon;

public class Tela_VOTOS extends JFrame{

	private JPanel contentPane;
	private TextArea tx;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela_VOTOS frame = new Tela_VOTOS();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public Tela_VOTOS() {
		setTitle("Urna");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 362, 430);
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 102, 255));
		panel.setBounds(0, 0, 354, 170);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel label = new JLabel("CONTAGEM DE VOTOS");
		label.setFont(new Font("Tahoma", Font.BOLD, 18));
		label.setForeground(new Color(255, 255, 255));
		label.setBounds(80, 74, 800, 50);
		panel.add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(Tela_VOTOS.class.getResource("/imagens/urna.png")));
		label_1.setBounds(140, 11, 81, 70);
		panel.add(label_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(240, 255, 255));
		panel_1.setBounds(0, 168, 354, 233);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(230, 230, 250));
		panel_2.setBounds(10, 11, 334, 204);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		tx = new TextArea();
		tx.setBounds(10, 10, 300, 190);
		
		StringBuilder sb = new StringBuilder();
		
		ArrayList<String> aw = new ArrayList<>();
   	 	Set<String> candidatos = new LinkedHashSet<>();
   	 	Set<String> candidatos1 = new LinkedHashSet<>();
   	 	
    	Scanner leitor;
		try {
			leitor = new Scanner(new FileReader("Candidatos.txt"));
			while(leitor.hasNext()) {
				String linha = leitor.nextLine();
	 			aw.add(linha);
	 			}
	 			for (int i = 0; i < aw.size(); i++) {
	 				
	 				String[] azinho = aw.get(i).split(";");
	 				candidatos.add(azinho[2]);
	 				candidatos1.add(azinho[0]+" "+azinho[1]+" "+azinho[2]);
	 			}
	 			
	 			Integer[] a = new Integer[candidatos.size()];
	 			for (int i = 0; i < a.length; i++) {
					a[i]=0;
				}
	 			leitor = new Scanner(new FileReader("DadosUrna.txt"));
	 			ArrayList<String> urna = new ArrayList<>();
	 			ArrayList<String> urna1 = new ArrayList<>();
	 			while(leitor.hasNext()) {
					String linha = leitor.nextLine();
		 			urna.add(linha);
		 			}
		 			for (int i = 0; i < urna.size(); i++) {
		 				
		 				String[] azinho = urna.get(i).split(";");
			 		
		 				urna1.add(azinho[2].toString());
		 			}
	 				
		 			int i=0;
	 			for (String string : candidatos) {
	 				for (String string1 : urna1) {
	 					if(string.equalsIgnoreCase(string1)) {
	 						
	 						a[i]++;
	 					}
	 					
					}
	 				i++;
				}
	    
	 			StringBuilder sb1 = new StringBuilder();
	 			int i1=0;
	 			for (String string : candidatos1) {
					sb1.append(string +" obteve: "+a[i1]+" votos\n");
					i1++;
				}
	 			tx.setText(sb1.toString());
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
 		
		
		panel_2.add(tx);
		
	}
}
