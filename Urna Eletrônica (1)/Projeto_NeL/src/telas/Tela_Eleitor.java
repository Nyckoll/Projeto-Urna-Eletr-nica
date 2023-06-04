package telas;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.awt.event.ActionEvent;

public class Tela_Eleitor extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela_Eleitor frame = new Tela_Eleitor();
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
	public Tela_Eleitor() throws ParseException {
		setTitle("Eleitor");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 546, 476);
		contentPane = new JPanel();
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 102, 255));
		panel.setBounds(0, 0, 540, 177);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Tela_Eleitor.class.getResource("/imagens/eleitor.png")));
		label.setBounds(233, 30, 101, 78);
		panel.add(label);
		
		JLabel lblNewLabel = new JLabel("Eleitor");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(233, 119, 90, 22);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(230, 230, 250));
		panel_1.setBounds(0, 178, 540, 269);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNome.setBounds(111, 11, 57, 14);
		panel_1.add(lblNome);
		
		textField = new JTextField();
		textField.setBounds(111, 36, 326, 20);
		panel_1.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("CPF");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(111, 67, 46, 14);
		panel_1.add(lblNewLabel_1);
		

		MaskFormatter cpf = new MaskFormatter("###.###.###-##");
		//cpf.setPlaceholderCharacter('_');
		JFormattedTextField tfCpf = new JFormattedTextField(cpf);
		tfCpf.setFont(new Font("Tahoma", Font.PLAIN, 11));
		tfCpf.setBounds(111, 92, 326, 20);
		panel_1.add(tfCpf);
		
		JLabel lblCep = new JLabel("CEP");
		lblCep.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCep.setBounds(111, 134, 46, 14);
		panel_1.add(lblCep);
		
		MaskFormatter cep = new MaskFormatter("#####-###");
		//cep.setPlaceholderCharacter('_');
		JFormattedTextField tfCep = new JFormattedTextField(cep);
		tfCep.setFont(new Font("Tahoma", Font.PLAIN, 11));
		tfCep.setBounds(111, 159, 326, 20);
		panel_1.add(tfCep);
		
		
		JButton btnSalvar = new JButton("Prosseguir");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField.getText().equals("") || tfCpf.getText().trim().length() != 14 || tfCep.getText().trim().length() != 9) {
					JOptionPane.showMessageDialog(null, "Preencha todos os campos", "Alerta", JOptionPane.WARNING_MESSAGE);
				}
				else if(fechar(textField.getText(), tfCpf.getText(), tfCep.getText())) {
					Tela_VOTOS tv=new Tela_VOTOS();
					tv.setVisible(true);
					dispose();
				} else {
				Tela_Urna urna = null;
				try {
					urna = new Tela_Urna();
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				urna.setVisible(true);
				dispose();
			}
				
			}
		});
		btnSalvar.setBackground(new Color(0, 102, 255));
		btnSalvar.setIcon(new ImageIcon("C:\\Users\\Aluno\\Downloads\\btn-salvar.png"));
		btnSalvar.setForeground(new Color(255, 255, 255));
		btnSalvar.setBounds(399, 225, 116, 23);
		panel_1.add(btnSalvar);
		
		JButton btnNewButton = new JButton("Excluir");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
				tfCpf.setText("");
				tfCep.setText("");
			}
		});
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(0, 102, 255));
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\Aluno\\Downloads\\btn-excluir.png"));
		btnNewButton.setBounds(288, 225, 101, 23);
		panel_1.add(btnNewButton);
		
	}
	MaskFormatter cpf = new MaskFormatter("###.###.###-##");
	MaskFormatter cep = new MaskFormatter("#####-###");
	public boolean fechar(String nome, String cpf, String cep) {
		return nome.equals("eleitor") && cpf.equals("000.000.000-00") && cep.equals("00000-000");
	}
}
