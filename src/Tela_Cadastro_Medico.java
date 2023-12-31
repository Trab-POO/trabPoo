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
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import javax.swing.JCheckBox;
import java.util.List;
import java.util.ArrayList;

public class Tela_Cadastro_Medico extends JFrame {

	private JPanel contentPane;
	
	/**
	 * Os text_field representam os atributos da classe PacientesemPlano. 
	 * Eles recebem os dados digitados pelo usuário (todos em formato texto).
	 * E o atributo PacientesemPlano é o objeto que vamos cadastrar.
	 * 
	 * */
	
	private JTextField txt_nome;
	private JTextField txt_cpf;
	private JTextField txt_expecialidade;
	private JTextField txt_dataNascimento;
	private JTextField txt_logradouro;
	private JTextField txt_numero;
	private JTextField txt_bairro;
	private List<Convenio> conveniosDisponiveis;
	private List<JCheckBox> checkboxesConvenios;
	private List<JCheckBox> checkboxesAgenda;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela_Cadastro_Medico frame = new Tela_Cadastro_Medico();
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
	public Tela_Cadastro_Medico() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 586, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

        JLabel titulo = new JLabel("Cadastro Médico");
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
		
		JLabel especialidade = new JLabel("Especialidade");
		especialidade.setBounds(12, 96, 191, 15);
		contentPane.add(especialidade);
		
		txt_expecialidade = new JTextField();
		txt_expecialidade.setBounds(221, 94, 245, 19);
		contentPane.add(txt_expecialidade);
		txt_expecialidade.setColumns(10);

		JLabel dataDeNascimento = new JLabel("Data de Nascimento");
		dataDeNascimento.setBounds(12, 123, 191, 15);
		contentPane.add(dataDeNascimento);
		
		txt_dataNascimento = new JTextField();
		txt_dataNascimento.setBounds(221, 121, 245, 19);
		contentPane.add(txt_dataNascimento);
		txt_dataNascimento.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Logradouro");
		lblNewLabel_5.setBounds(12, 150, 102, 15);
		contentPane.add(lblNewLabel_5);
		
		txt_logradouro = new JTextField();
		txt_logradouro.setBounds(221, 148, 245, 19);
		contentPane.add(txt_logradouro);
		txt_logradouro.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Número");
		lblNewLabel_6.setBounds(12, 177, 70, 15);
		contentPane.add(lblNewLabel_6);
		
		txt_numero = new JTextField();
		txt_numero.setBounds(221, 175, 245, 19);
		contentPane.add(txt_numero);
		txt_numero.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Bairro");
		lblNewLabel_7.setBounds(12, 204, 70, 15);
		contentPane.add(lblNewLabel_7);
		
		txt_bairro = new JTextField();
		txt_bairro.setBounds(221, 202, 245, 19);
		contentPane.add(txt_bairro);
		txt_bairro.setColumns(10);
		checkboxesConvenios = new ArrayList<>();

		// Adicione os JCheckBoxes representando os convênios
		checkboxesConvenios = new ArrayList<>();
		List<Convenio> conveniosDisponiveis = LeituraArquivoConvenios.obterConveniosDisponiveis(); // Obtendo a lista de convênios
		JLabel lblConvenios = new JLabel("Convênios Participantes");
		lblConvenios.setBounds(10, 230, 150, 15);
		contentPane.add(lblConvenios);

		int yPos = 230;

		for (Convenio convenio : conveniosDisponiveis) {
			JCheckBox checkBox = new JCheckBox(convenio.getNome());
			checkBox.setBounds(221, yPos, 150, 15);
			contentPane.add(checkBox);
			checkboxesConvenios.add(checkBox);
			yPos += 20;
		}

		yPos += 10;
		int xPos = 221;

		checkboxesAgenda = new ArrayList<>();
		JLabel lblAgenda = new JLabel("Agenda:");
		lblAgenda.setBounds(10, yPos, 150, 15);
		contentPane.add(lblAgenda);

		for (int i = 8; i < 18; i++) {

			String x;
			if(i < 10)
				x = "0"+i;
			else
				x = String.valueOf(i);
			
			x += ":00h";

			if(i != 12){
				JCheckBox checkBox = new JCheckBox(x);
				checkBox.setBounds(xPos, yPos, 150, 15);
				contentPane.add(checkBox);
				checkboxesAgenda.add(checkBox);
				if(xPos == 380){
					yPos += 20;
					xPos = 221;
				}
				else 
					xPos = 380;
			}

		}

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
		btnSalvar.setBounds(221, 400, 117, 25);
		contentPane.add(btnSalvar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancelar.setBounds(345, 400, 117, 25);
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
		String especialidade = txt_expecialidade.getText();
		
		Date dtNascimento = null;
			
		//Dados Paciente
		try {
			SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy"); 
			dtNascimento = formato.parse(txt_dataNascimento.getText());
		}catch(ParseException e1){
			JOptionPane.showMessageDialog(null, "O formato da Data deve ser dd/MM/yyyy !", "alerta",
            JOptionPane.ERROR_MESSAGE);
		}
		
		
	    Medico medico = new Medico(nome, CPF, logradouro, numero, bairro, dtNascimento, "123456", especialidade);
	    Pessoa pessoa = new Pessoa(nome, CPF, logradouro, numero, bairro, dtNascimento, "123456");

		// Adicione a seguinte seção para lidar com os JCheckBox
		for (JCheckBox checkBox : checkboxesConvenios) {
			if (checkBox.isSelected()) {
				String nomeConvenio = checkBox.getText();
				Convenio convenioSelecionado = obterConvenioPorNome(nomeConvenio);

				if (convenioSelecionado != null) {
					medico.adicionarConvenio(convenioSelecionado);
				}
			}
		}

		for (JCheckBox checkBox : checkboxesAgenda) {
			if (checkBox.isSelected()) {
				String horarioAgenda = checkBox.getText();

				medico.setAgenda(horarioAgenda);
			}
		}

		return salvar(medico, pessoa);
	}

	// Método para obter o convênio a partir do nome

	private Convenio obterConvenioPorNome(String nome) {
		List<Convenio> conveniosDisponiveis = LeituraArquivoConvenios.obterConveniosDisponiveis();
		for (Convenio convenio : conveniosDisponiveis) {
			if (convenio.getNome().equals(nome)) {
				return convenio;
			}
		}
		return null;
	}

	
	public boolean salvar(Medico p, Pessoa pe) {
		//Salvando em arquivo
		DadosMedico dadosMedico = new DadosMedico();
		DadosPessoa dadosPessoa = new DadosPessoa();

        dadosPessoa.addPessoa(pe);
        dadosMedico.addMedico(p);

		return (dadosMedico.salvar() && dadosPessoa.salvar());
	}

}
