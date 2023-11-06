//import java.awt.Color;
//import java.awt.EventQueue;
//import java.util.*;
//
//import javax.swing.JFrame;
//import javax.swing.JLabel;
//import javax.swing.JPanel;
//import javax.swing.JSeparator;
//import javax.swing.SwingConstants;
//import java.awt.Font;
//import java.awt.SystemColor;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
//import javax.swing.JButton;
//
//
//public class Tela_Principal {
//
//	private JPanel contentPane;
//	private JFrame frame;
//
//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Tela_Principal window = new Tela_Principal();
//					window.frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
//
//	/**
//	 * Create the application.
//	 */
//	public Tela_Principal() {
//		initialize();
//
//
//	}
//
//	/**
//	 * Initialize the contents of the frame.
//	 */
//	private void initialize() {
//		frame = new JFrame();
//		frame.setBounds(100, 100, 960, 660);
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.getContentPane().setLayout(null);
//
//		JLabel lblNewLabel = new JLabel("Clínica Médica");
//		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 18));
//		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
//		lblNewLabel.setBounds(6, 6, 948, 22);
//		frame.getContentPane().add(lblNewLabel);
//
//		JSeparator separator = new JSeparator();
//		separator.setBackground(Color.BLACK);
//		separator.setBounds(6, 26, 948, 16);
//		frame.getContentPane().add(separator);
//
//		JLabel lblNewLabel_1 = new JLabel("Bem Vindo!");
//		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 24));
//		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
//		lblNewLabel_1.setBounds(6, 54, 948, 29);
//		frame.getContentPane().add(lblNewLabel_1);
//
//		JButton cadPacienteBtn = new JButton("Cadastro Paciente");
//		cadPacienteBtn.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent a) {
//				Tela_Cadastro_PacientecomPlano tela = new Tela_Cadastro_PacientecomPlano();
//				tela.setVisible(true);
//			}
//		});
//		cadPacienteBtn.setBounds(44, 171, 169, 29);
//		frame.getContentPane().add(cadPacienteBtn);
//
//		JButton cadPacienteBtn_1_1 = new JButton("Cadastro Médicos");
//		cadPacienteBtn_1_1.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent a) {
//				Tela_Cadastro_Médico tela = new Tela_Cadastro_Médico();
//				tela.setVisible(true);
//			}
//		});
//		cadPacienteBtn_1_1.setBounds(44, 216, 169, 29);
//		frame.getContentPane().add(cadPacienteBtn_1_1);
//
//		JButton btnListaPaciente = new JButton("Lista Pacientes");
//		btnListaPaciente.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				Tela_ListaPacientes tela = new Tela_ListaPacientes();
//				tela.setVisible(true);
//			}
//		});
//		btnListaPaciente.setBounds(391, 171, 169, 29);
//		frame.getContentPane().add(btnListaPaciente);
//
//		JButton cadPacienteBtn_1_1_2 = new JButton("Lista Médicos");
//		cadPacienteBtn_1_1_2.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				Tela_ListaMedicos tela = new Tela_ListaMedicos();
//				tela.setVisible(true);
//			}
//		});
//		cadPacienteBtn_1_1_2.setBounds(391, 216, 169, 29);
//		frame.getContentPane().add(cadPacienteBtn_1_1_2);
//
//		JButton btnRegistraConsulta = new JButton("Registra Consulta");
//		btnRegistraConsulta.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				Tela_Registra_Consulta tela = new Tela_Registra_Consulta();
//				tela.setVisible(true);
//			}
//		});
//		btnRegistraConsulta.setBounds(738, 171, 169, 29);
//		frame.getContentPane().add(btnRegistraConsulta);
//
//		JSeparator separator_1 = new JSeparator();
//		separator_1.setOrientation(SwingConstants.VERTICAL);
//		separator_1.setBackground(Color.BLACK);
//		separator_1.setBounds(225, 143, 12, 271);
//		frame.getContentPane().add(separator_1);
//
//		JSeparator separator_2 = new JSeparator();
//		separator_2.setBackground(Color.BLACK);
//		separator_2.setBounds(95, 135, 135, 16);
//		frame.getContentPane().add(separator_2);
//
//		JSeparator separator_2_1 = new JSeparator();
//		separator_2_1.setBackground(Color.BLACK);
//		separator_2_1.setBounds(30, 408, 200, 16);
//		frame.getContentPane().add(separator_2_1);
//
//		JSeparator separator_1_1 = new JSeparator();
//		separator_1_1.setOrientation(SwingConstants.VERTICAL);
//		separator_1_1.setBackground(Color.BLACK);
//		separator_1_1.setBounds(20, 153, 12, 261);
//		frame.getContentPane().add(separator_1_1);
//
//		JLabel lblNewLabel_2 = new JLabel("Cadastro");
//		lblNewLabel_2.setBounds(30, 135, 61, 16);
//		frame.getContentPane().add(lblNewLabel_2);
//
//		JSeparator separator_1_2 = new JSeparator();
//		separator_1_2.setOrientation(SwingConstants.VERTICAL);
//		separator_1_2.setBackground(Color.BLACK);
//		separator_1_2.setBounds(567, 143, 12, 271);
//		frame.getContentPane().add(separator_1_2);
//
//		JSeparator separator_2_2 = new JSeparator();
//		separator_2_2.setBackground(Color.BLACK);
//		separator_2_2.setBounds(437, 135, 135, 16);
//		frame.getContentPane().add(separator_2_2);
//
//		JSeparator separator_2_1_1 = new JSeparator();
//		separator_2_1_1.setBackground(Color.BLACK);
//		separator_2_1_1.setBounds(372, 408, 200, 16);
//		frame.getContentPane().add(separator_2_1_1);
//
//		JSeparator separator_1_1_1 = new JSeparator();
//		separator_1_1_1.setOrientation(SwingConstants.VERTICAL);
//		separator_1_1_1.setBackground(Color.BLACK);
//		separator_1_1_1.setBounds(362, 153, 12, 261);
//		frame.getContentPane().add(separator_1_1_1);
//
//		JLabel lblNewLabel_2_1 = new JLabel("Listagem");
//		lblNewLabel_2_1.setBounds(372, 135, 61, 16);
//		frame.getContentPane().add(lblNewLabel_2_1);
//
//		JSeparator separator_1_3 = new JSeparator();
//		separator_1_3.setOrientation(SwingConstants.VERTICAL);
//		separator_1_3.setBackground(Color.BLACK);
//		separator_1_3.setBounds(917, 143, 12, 271);
//		frame.getContentPane().add(separator_1_3);
//
//		JSeparator separator_2_3 = new JSeparator();
//		separator_2_3.setBackground(Color.BLACK);
//		separator_2_3.setBounds(797, 135, 125, 16);
//		frame.getContentPane().add(separator_2_3);
//
//		JSeparator separator_2_1_2 = new JSeparator();
//		separator_2_1_2.setBackground(Color.BLACK);
//		separator_2_1_2.setBounds(722, 408, 200, 16);
//		frame.getContentPane().add(separator_2_1_2);
//
//		JSeparator separator_1_1_2 = new JSeparator();
//		separator_1_1_2.setOrientation(SwingConstants.VERTICAL);
//		separator_1_1_2.setBackground(Color.BLACK);
//		separator_1_1_2.setBounds(712, 153, 12, 261);
//		frame.getContentPane().add(separator_1_1_2);
//
//		JLabel lblNewLabel_2_2 = new JLabel("Consultas");
//		lblNewLabel_2_2.setBounds(722, 135, 74, 16);
//		frame.getContentPane().add(lblNewLabel_2_2);
//
//		JButton btnEfetivaConsulta = new JButton("Efetiva Consulta");
//		btnEfetivaConsulta.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				Tela_Efetiva tela = new Tela_Efetiva();
//				tela.setVisible(true);
//			}
//		});
//		btnEfetivaConsulta.setBounds(738, 216, 169, 29);
//		frame.getContentPane().add(btnEfetivaConsulta);
//
////		class chamaTela implements ActionListener {
////			public void actionPerformed(ActionEvent e) {
////				if (e.getSource() == cadPacienteBtn) {
////					CadPacientePlano.setVisible(true);
////				}
////			}
////		}
//
//	}
//
//
//}