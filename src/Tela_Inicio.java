import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

/**
 * Classe: Tela_Cadastro_Médico
 * 
 * DESC: Essa classe recebe os dados da classe Medico e salva-os num arquivo Funcionarios.bin.
 * 		
 * */

public class Tela_Inicio extends JFrame {

	private JPanel contentPane;
	
	/**
	 * Os text_field representam os atributos da classe Medico. 
	 * Eles recebem os dados digitados pelo usuário (todos em formato texto).
	 * Os JButton são os botões da tela.
	 * E o atributo Medico é o objeto que vamos cadastrar.
	 * 
	 * */

	private JTextField txt_nome;
	private JPasswordField txt_senha;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela_Inicio frame = new Tela_Inicio();
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
	public Tela_Inicio() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 486, 606);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nome");
		lblNewLabel.setBounds(12, 12, 70, 15);
		contentPane.add(lblNewLabel);
		
		txt_nome = new JTextField();
		txt_nome.setBounds(221, 10, 253, 19);
		contentPane.add(txt_nome);
		txt_nome.setColumns(10);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBounds(12, 198, 70, 15);
		contentPane.add(lblSenha);
		
		txt_senha = new JPasswordField();
		txt_senha.setBounds(221, 196, 253, 19);
		contentPane.add(txt_senha);
		txt_senha.setColumns(10);
		
		/**
		 * Os botões Salvar e Cancelar fecham a tela quando clicados.
		 * 
		 * Note que a classe Médico tem um atributo ArrayList de Planos de Saúde. Para setá-lo clicamos no botão Planos.
		 * É exibido, então, uma lista com os nomes de planos de saúde cadastrados.
		 */
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				coletaDados();
				salvar();
				dispose();
				
			}
		});
		btnSalvar.setBounds(221, 516, 117, 25);
		contentPane.add(btnSalvar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancelar.setBounds(357, 516, 117, 25);
		contentPane.add(btnCancelar);
	}
	
	/**
	 * O método coletaDados(), pega os valores dos text_field e os atribui as variáveis corretas,
	 * fazendo as devidas conversões. Note que os text_field só recebem Strings, logo,
	 * variáveis do tipo Date, por exemplo, vão precisar passar por um tratamento antes de recebererem o dado.
	 * 
	 * */
	
	public void coletaDados() {
		
		//Dados para Login
		String nome = txt_nome.getText();
		String senha = txt_senha.getText();
		
		
		//Setando dados do médico
		medico.setNome(nome);
		medico.setCpf(CPF);
		medico.setRg(RG);
		medico.setEstadoCivil(EstadoCivil);
		medico.setEndereco(endereco);
		medico.setAdmissão(dataDeAdmissao);
		medico.setCarteira(carteira);
		medico.setUsuario(usuario);
		medico.setSenha(senha);
		medico.setCRM(CRM);
		medico.setEspecialidade(especialidade);
		medico.setSomaConsultasMes(soma);

	}
	
	/**
	 * O método salvar(), declara um objeto da classe DadosFuncionarios
	 * para salvar o objeto Medico no arquivo Funcionarios.bin
	 * 
	 * */
	
	public void salvar() {
		DadosFuncionarios dados = new DadosFuncionarios();
		dados.cadastrar((Funcionario)medico);
		dados.salvar();
		
	}
}
