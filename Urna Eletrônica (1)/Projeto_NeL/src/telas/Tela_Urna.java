package telas;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import classe.Urna;

public class Tela_Urna extends JFrame {
	
	private JPanel contentPane;
	private JTextField txNumeroCandidato ;
	private JTextField txCandidato;
	private JTextField txPartido;
	private Urna durna;
	String pesquisa;
	private int posicao;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela_Urna frame = new Tela_Urna();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	


	
	/**
	 * Create the frame.
	 * @throws ParseException 
	 */
	public Tela_Urna() throws ParseException {
	
	
		
		setTitle("Urna");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 690, 430);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 102, 255));
		panel.setBounds(0, 0, 684, 177);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(240, 255, 255));
		panel_1.setBounds(0, 177, 684, 224);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(230, 230, 250));
		panel_2.setBounds(10, 11, 334, 204);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		MaskFormatter cpf = new MaskFormatter("###.###.###-##");
		cpf.setPlaceholderCharacter('_');
		
		JLabel lblNewLabel_1 = new JLabel("N\u00FAmero do Candidato");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(70, 40, 167, 14);
		panel_2.add(lblNewLabel_1);
		
		txNumeroCandidato = new JTextField();
		txNumeroCandidato.setBounds(49, 65, 206, 23);
		panel_2.add(txNumeroCandidato);
		txNumeroCandidato.setColumns(10);
		
		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			if(txNumeroCandidato.getText().equals("")) {
				int b = 0;
				durna.setVoto(b++);
				JOptionPane.showMessageDialog(null, "Informe um número", "Alerta", JOptionPane.WARNING_MESSAGE);
				} else {
				
				try {
					BufferedReader br = new BufferedReader(new FileReader("DadosUrna.txt")); // cria o objeto que vai ler o arquivo
					FileReader arquivoFisico = new FileReader("Candidatos.txt");
					BufferedReader arquivoLogico = new BufferedReader(arquivoFisico);
					String c;
			        ArrayList<String> linhas = new ArrayList<String>(); // cria uma coleção para adicionar as linhas que já estão no arquivo
			        while ((c = br.readLine()) != null) {
			            linhas.add(c); // lê cada linha do arquivo e adiciona a coleção
			        }
			        br.close();
			        PrintWriter pw = new PrintWriter("DadosUrna.txt");
			        for (String a: linhas) {
			            pw.println(a); // percorre a coleção e ja vai escrevendo o conteudo no arquivo
			        }
			        pw.printf("%s;%s;%s", txCandidato.getText(), txPartido.getText(),txNumeroCandidato.getText());
			        pw.flush();
			        pw.close();
				} catch (Exception erro) {
					
				}
				Tela_Eleitor eleitor = null;
				try {
					eleitor = new Tela_Eleitor();
			  /* */
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				eleitor.setVisible(true);
				dispose();
				
				}
				
			}
		});
		btnConfirmar.setForeground(new Color(0, 0, 0));
		btnConfirmar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnConfirmar.setBackground(new Color(0, 204, 51));
		btnConfirmar.setBounds(226, 170, 98, 23);
		panel_2.add(btnConfirmar);
		
		JButton btnCorrigir = new JButton("Corrigir");
		btnCorrigir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txNumeroCandidato.setText("");
			}
		});
		btnCorrigir.setBackground(new Color(255, 102, 0));
		btnCorrigir.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnCorrigir.setBounds(127, 171, 89, 23);
		panel_2.add(btnCorrigir);
		
		KeyStroke stroke = KeyStroke.getKeyStroke(KeyEvent.VK_ENTER,0);
		txNumeroCandidato.getInputMap(JTextField.WHEN_FOCUSED).put(stroke, new AbstractAction() {
		     @Override
		     public void actionPerformed(ActionEvent e) {
		    	ArrayList<String> aw = new ArrayList<>();
		    	 Boolean achou = false;
		    	Scanner leitor;
				try {
					leitor = new Scanner(new FileReader("Candidatos.txt"));
					while(leitor.hasNext()) {
						String linha = leitor.nextLine();
			 			aw.add(linha);
			 			System.out.println(linha);
			 			}
					
					if(aw.isEmpty()) {
						JOptionPane.showMessageDialog(null, "SEM CANDIDATOS REGISTRADOS");
					}else {
			 			for (int i = 0; i < aw.size(); i++) {
			 				
			 				System.out.println(aw.get(i));
			 				String[] azinho = aw.get(i).split(";");
			 				
			 				if(azinho[2].trim().equalsIgnoreCase(txNumeroCandidato.getText())) {
			 					txCandidato.setText(azinho[0]);
			 					txPartido.setText(azinho[1]);
			 					achou = true;
			 				}
			 			}
				} 
					if(!achou) {
						JOptionPane.showMessageDialog(null, "NÃO ENCONTRADO");
					}
				}catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		 		
		}
		     
		});
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(230, 230, 250));
		panel_3.setBounds(354, 11, 320, 204);
		panel_1.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Candidato");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(118, 38, 90, 14);
		panel_3.add(lblNewLabel_2);
		
		txCandidato = new JTextField();
		txCandidato.setEnabled(false);
		txCandidato.setBounds(48, 64, 219, 26);
		panel_3.add(txCandidato);
		txCandidato.setColumns(10);
		
		
		JLabel lblNewLabel = new JLabel("Partido");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(129, 101, 65, 17);
		panel_3.add(lblNewLabel);
		
		txPartido = new JTextField();
		txPartido.setEnabled(false);
		txPartido.setBounds(48, 124, 219, 26);
		panel_3.add(txPartido);
		txPartido.setColumns(10);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Tela_Urna.class.getResource("/imagens/urna.png")));
		label.setBounds(306, 28, 77, 71);
		panel.add(label);
		
		JLabel lblUrna = new JLabel("Urna");
		lblUrna.setForeground(new Color(255, 255, 255));
		lblUrna.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblUrna.setBounds(316, 110, 56, 27);
		panel.add(lblUrna);
		
	
		
		
	}
}
