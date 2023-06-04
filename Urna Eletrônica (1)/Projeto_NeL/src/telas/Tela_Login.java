package telas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JFormattedTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class Tela_Login extends JFrame {

	private JPanel contentPane;
	private JPasswordField txtSenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela_Login frame = new Tela_Login();
					frame.setVisible(true);
					//frame.add(panel_1, BorderLayout.NORTH);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Tela_Login() {
		
		setTitle("\u00C1rea de Acesso");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 663, 499);
		contentPane = new JPanel();
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(230, 230, 250));
		panel.setBounds(0, 176, 657, 294);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblLogin.setBounds(219, 75, 95, 36);
		panel.add(lblLogin);
		
		JFormattedTextField txtLogin = new JFormattedTextField();
		txtLogin.setBounds(219, 106, 230, 20);
		panel.add(txtLogin);
		
		JLabel lblNewLabel = new JLabel("Senha");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(219, 136, 57, 23);
		panel.add(lblNewLabel);
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(checkLogin(txtLogin.getText(),new String(txtSenha.getPassword()))) {
					new Tela_Candidato().setVisible(true);
					dispose();
				} else {
					JOptionPane.showMessageDialog(null, "Dados inválidos!", "Erro", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		btnEntrar.setForeground(new Color(255, 255, 255));
		btnEntrar.setBackground(new Color(0, 102, 255));
		btnEntrar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnEntrar.setBounds(360, 192, 89, 23);
		panel.add(btnEntrar);
		
		txtSenha = new JPasswordField();
		txtSenha.setBounds(219, 159, 230, 20);
		panel.add(txtSenha);

		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 102, 255));
		panel_1.setBounds(0, 0, 657, 177);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(Tela_Login.class.getResource("/imagens/user.png")));
		lblNewLabel_1.setBounds(303, 32, 69, 74);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblreaDeAcesso = new JLabel("\u00C1rea de Acesso");
		lblreaDeAcesso.setForeground(new Color(255, 255, 255));
		lblreaDeAcesso.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblreaDeAcesso.setBounds(273, 116, 146, 33);
		panel_1.add(lblreaDeAcesso);
		
		
	
		
	}
	public boolean checkLogin(String login, String senha) {
		return login.equals("SocorroDeus") && senha.equals("12345");
	}
}