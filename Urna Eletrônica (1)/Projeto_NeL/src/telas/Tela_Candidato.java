package telas;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import classe.Candidato;

public class Tela_Candidato extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	private JPanel contentPane;
	private JTextField tfNome;
	private JTextField ftNumero;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela_Candidato frame = new Tela_Candidato();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Tela_Candidato() {
		
		
		Candidato candidato = new Candidato();
			
		setTitle("Candidato");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 433, 450);
		contentPane = new JPanel();
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 102, 255));
		panel.setBounds(0, 0, 427, 177);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Tela_Candidato.class.getResource("/imagens/candidatos.png")));
		label.setBounds(175, 29, 90, 80);
		panel.add(label);
		
		JLabel lblCandidato = new JLabel("Candidato");
		lblCandidato.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblCandidato.setForeground(new Color(255, 255, 255));
		lblCandidato.setBounds(160, 108, 121, 30);
		panel.add(lblCandidato);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(230, 230, 250));
		panel_1.setForeground(new Color(255, 255, 255));
		panel_1.setBounds(0, 177, 427, 244);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNome.setBounds(98, 30, 46, 14);
		panel_1.add(lblNome);
		
		JLabel lblNewLabel = new JLabel("Partido");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(98, 77, 74, 14);
		panel_1.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("N\u00FAmero");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(98, 131, 114, 14);
		panel_1.add(lblNewLabel_1);
		
		JComboBox escolhedor = new JComboBox();
		escolhedor.setFont(new Font("Tahoma", Font.PLAIN, 12));
		escolhedor.setModel(new DefaultComboBoxModel(new String[] {"", "PT", "MDB", "PSOL", "PSdoB", "PMDB", "PHS", "REDE", "PROS", "PMN", "PSL", "NOVO", "PCO"}));
		escolhedor.setBounds(98, 102, 208, 20);
		panel_1.add(escolhedor);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tfNome.getText().equals("") || escolhedor.getSelectedItem().equals("") || ftNumero.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Informe todos os dados", "Alerta", JOptionPane.WARNING_MESSAGE);
				} else {
					
					try {
						String linha;
						int posicao;
						ArrayList<String> cands = new ArrayList<String>();
						FileReader arquivoFisico = new FileReader("Candidatos.txt");
						BufferedReader arquivoLogico = new BufferedReader(arquivoFisico);
						linha = arquivoLogico.readLine();

						while (linha != null) {
							cands.add(linha);
							linha = arquivoLogico.readLine();
						}
						candidato.salvarDados(tfNome.getText().toString(), escolhedor.getSelectedItem().toString(), ftNumero.getText().toString());
							
						JOptionPane.showMessageDialog(null, "Salvo com sucesso!");				

					} catch (Exception e1) {
						PrintWriter gravador;
						try {
							gravador = new PrintWriter("Candidatos.txt");
							gravador.close();
						} catch (FileNotFoundException e2) {
							// TODO Auto-generated catch block
							e2.printStackTrace();
						}
						
						
					}
			}
			}
		});
		btnSalvar.setBackground(new Color(0, 102, 255));
		btnSalvar.setForeground(new Color(255, 255, 255));
		btnSalvar.setIcon(new ImageIcon(Tela_Candidato.class.getResource("/imagens/btn-salvar.png")));
		btnSalvar.setBounds(306, 196, 99, 23);
		panel_1.add(btnSalvar);
		
		
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				    tfNome.setText("");
					ftNumero.setText("");	
					escolhedor.setModel(new DefaultComboBoxModel(new String[] {"", "PT", "MDB", "PSOL", "PSdoB", "PMDB", "PHS", "REDE", "PROS", "PMN", "PSL", "NOVO", "PCO"}));
						
		}});
		btnExcluir.setIcon(new ImageIcon(Tela_Candidato.class.getResource("/imagens/btn-excluir.png")));
		btnExcluir.setBackground(new Color(0, 102, 255));
		btnExcluir.setForeground(new Color(255, 255, 255));
		btnExcluir.setBounds(197, 196, 99, 23);
		panel_1.add(btnExcluir);
		
		tfNome = new JTextField();
		tfNome.setFont(new Font("Tahoma", Font.PLAIN, 12));
		tfNome.setBounds(98, 46, 208, 20);
		panel_1.add(tfNome);
		tfNome.setColumns(10);
		
		ftNumero = new JTextField();
		ftNumero.setFont(new Font("Tahoma", Font.PLAIN, 12));
		ftNumero.setColumns(10);
		ftNumero.setBounds(98, 146, 208, 20);
		panel_1.add(ftNumero);
		
		JButton btnNewButton_2 = new JButton("Finalizar");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Tela_Eleitor eleitor = null;
				try {
					eleitor = new Tela_Eleitor();
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				eleitor.setVisible(true);
				dispose();
			}
		});
		btnNewButton_2.setForeground(new Color(255, 255, 255));
		btnNewButton_2.setBackground(new Color(0, 102, 255));
		btnNewButton_2.setBounds(98, 196, 89, 23);
		panel_1.add(btnNewButton_2);
		
	
	}
}
