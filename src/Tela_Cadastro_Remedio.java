import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.border.EmptyBorder;

/**
 * Classe: Tela_Cadastro_Remedio
 * 
 * DESC: Essa classe recebe os dados da classe PacientesemPlano e salva-os num arquivo Pacientes.bin.
 * 		
 * */
public class Tela_Cadastro_Remedio extends JFrame {

	private JPanel contentPane;
	
	/**
	 * Os text_field representam os atributos da classe PacientesemPlano. 
	 * Eles recebem os dados digitados pelo usuário (todos em formato texto).
	 * E o atributo PacientesemPlano é o objeto que vamos cadastrar.
	 * 
	 * */
	
	private JTextField txt_nome;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela_Cadastro_Remedio frame = new Tela_Cadastro_Remedio();
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
	public Tela_Cadastro_Remedio() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 486, 200);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

        JLabel titulo = new JLabel("Cadastro Remedio");
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
		btnSalvar.setBounds(221, 100, 117, 25);
		contentPane.add(btnSalvar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancelar.setBounds(345, 100, 117, 25);
		contentPane.add(btnCancelar);
		
	}
	
	/**
	 * O método coletaDados(), pega os valores dos text_field e os atribui as variáveis corretas,
	 * fazendo as devidas conversões. Note que os text_field só recebem Strings, logo,
	 * variáveis do tipo Date, por exemplo, vão precisar passar por um tratamento antes de recebererem o dado.
	 * 
	 * */
	
	public boolean coletaDados() {
		
		//Dados Remedio
		String nome = txt_nome.getText();		
		
	    Remedio remedio = new Remedio(nome);
        return salvar(remedio);
	}
	
	public boolean salvar(Remedio r) {
		//Salvando em arquivo
		DadosRemedio dadosRemedio = new DadosRemedio();

        dadosRemedio.addRemedio(r);

		return (dadosRemedio.salvar());
	}

}
