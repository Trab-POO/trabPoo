import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.border.EmptyBorder;

/**
 * Classe: Tela_Cadastro_Paciente
 * 
 * DESC: Essa classe recebe os dados da classe PacientesemPlano e salva-os num arquivo Pacientes.bin.
 * 		
 * */
public class Tela_Cadastro_Paciente extends JFrame {

	private JPanel contentPane;
	
	/**
	 * Os text_field representam os atributos da classe PacientesemPlano. 
	 * Eles recebem os dados digitados pelo usuário (todos em formato texto).
	 * E o atributo PacientesemPlano é o objeto que vamos cadastrar.
	 * 
	 * */
	
	private JTextField txt_nome;
	private JTextField txt_cpf;
	private JTextField txt_dataNascimento;
	private JTextField txt_logradouro;
	private JTextField txt_numero;
	private JTextField txt_bairro;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela_Cadastro_Paciente frame = new Tela_Cadastro_Paciente();
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
	public Tela_Cadastro_Paciente() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 486, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

        JLabel titulo = new JLabel("Cadastro Paciente");
		titulo.setFont(new Font("Arial", Font.BOLD, 18));
		titulo.setHorizontalAlignment(SwingConstants.CENTER);
		titulo.setBounds(6, 6, 486, 22);
		contentPane.add(titulo);
		
		JLabel lblNewLabel = new JLabel("Nome");
		lblNewLabel.setBounds(12, 42, 70, 15);
		contentPane.add(lblNewLabel);
		
		txt_nome = new JTextField();
		txt_nome.setBounds(221, 40, 245, 19);
		contentPane.add(txt_nome);
		txt_nome.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("CPF");
		lblNewLabel_1.setBounds(12, 69, 70, 15);
		contentPane.add(lblNewLabel_1);
		
		txt_cpf = new JTextField();
		txt_cpf.setBounds(221, 67, 245, 19);
		contentPane.add(txt_cpf);
		txt_cpf.setColumns(10);
		
		JLabel dataDeNascimento = new JLabel("Data de Nascimento");
		dataDeNascimento.setBounds(12, 96, 191, 15);
		contentPane.add(dataDeNascimento);
		
		txt_dataNascimento = new JTextField();
		txt_dataNascimento.setBounds(221, 94, 245, 19);
		contentPane.add(txt_dataNascimento);
		txt_dataNascimento.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Logradouro");
		lblNewLabel_5.setBounds(12, 123, 102, 15);
		contentPane.add(lblNewLabel_5);
		
		txt_logradouro = new JTextField();
		txt_logradouro.setBounds(221, 121, 245, 19);
		contentPane.add(txt_logradouro);
		txt_logradouro.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Número");
		lblNewLabel_6.setBounds(12, 150, 70, 15);
		contentPane.add(lblNewLabel_6);
		
		txt_numero = new JTextField();
		txt_numero.setBounds(221, 148, 245, 19);
		contentPane.add(txt_numero);
		txt_numero.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Bairro");
		lblNewLabel_7.setBounds(12, 177, 70, 15);
		contentPane.add(lblNewLabel_7);
		
		txt_bairro = new JTextField();
		txt_bairro.setBounds(221, 175, 245, 19);
		contentPane.add(txt_bairro);
		txt_bairro.setColumns(10);
		
		/**
		 * Os únicos botões dessa tela são Salvar e Cancelar.
		 * Ambos fecham a tela quando clicados.
		 */
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(coletaDados()){
                    dispose();
                }				
			}
		});
		btnSalvar.setBounds(221, 207, 117, 25);
		contentPane.add(btnSalvar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancelar.setBounds(345, 207, 117, 25);
		contentPane.add(btnCancelar);
		
	}
	
	/**
	 * O método coletaDados(), pega os valores dos text_field e os atribui as variáveis corretas,
	 * fazendo as devidas conversões. Note que os text_field só recebem Strings, logo,
	 * variáveis do tipo Date, por exemplo, vão precisar passar por um tratamento antes de recebererem o dado.
	 * 
	 * */
	
	public boolean coletaDados() {
		
		String logradouro = txt_logradouro.getText();
		
		int numero = 0;
		
		try {
			numero = Integer.parseInt(txt_numero.getText());
			
		}catch(NumberFormatException nfe){
			JOptionPane.showMessageDialog(null, "Os dados Número, CEP ou NroCarteira", "alerta",
					JOptionPane.ERROR_MESSAGE);
			
		}
		//Dados Endereço
		String bairro = txt_bairro.getText();
		
		//Dados Pessoa
		String nome = txt_nome.getText();
		String CPF = txt_cpf.getText();
		
		Date dtNascimento = null;
			
		//Dados Paciente
		try {
			SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy"); 
			dtNascimento = formato.parse(txt_dataNascimento.getText());
		}catch(ParseException e1){
			JOptionPane.showMessageDialog(null, "O formato da Data deve ser dd/MM/yyyy !", "alerta",
            JOptionPane.ERROR_MESSAGE);
		}
		
		
	    Paciente paciente = new Paciente(nome, CPF, logradouro, numero, bairro, dtNascimento, "123456");
	    Pessoa pessoa = new Pessoa(nome, CPF, logradouro, numero, bairro, dtNascimento, "123456");
        return salvar(paciente, pessoa);
	}
	
	public boolean salvar(Paciente p, Pessoa pe) {
		//Salvando em arquivo
		DadosPaciente dadosPaciente = new DadosPaciente();
		DadosPessoa dadosPessoa = new DadosPessoa();

        dadosPessoa.addPessoa(pe);
        dadosPaciente.addPaciente(p);

		return (dadosPaciente.salvar() && dadosPessoa.salvar());
	}

}
