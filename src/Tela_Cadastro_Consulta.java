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
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JCheckBox;

/**
 * Classe: Tela_Cadastro_Consulta
 * 
 * DESC: Essa classe recebe os dados da classe Consulta e salva-os num arquivo Consultas.bin.
 * 		
 * */

public class Tela_Cadastro_Consulta extends JFrame {

	private JPanel contentPane;
	
	/**
	 * Os text_field representam os atributos da classe Consulta. 
	 * Eles recebem os dados digitados pelo usuário (todos em formato texto).
	 * Os JButton são os botões da tela.
	 * E o atributo Consulta é o objeto que vamos cadastrar.
	 * 
	 * */
	
	private JTextField txt_data;
	private JTextField txt_hora;
	
	private Consulta consulta = new Consulta();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela_Cadastro_Consulta frame = new Tela_Cadastro_Consulta();
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
	public Tela_Cadastro_Consulta() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 491, 351);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel data = new JLabel("Data");
		data.setBounds(12, 12, 70, 15);
		contentPane.add(data);
		
		txt_data = new JTextField();
		txt_data.setBounds(221, 10, 253, 19);
		contentPane.add(txt_data);
		txt_data.setColumns(10);
		
		JLabel hora = new JLabel("Hora");
		hora.setBounds(12, 39, 70, 15);
		contentPane.add(hora);
		
		txt_hora = new JTextField();
		txt_hora.setBounds(221, 37, 253, 19);
		contentPane.add(txt_hora);
		txt_hora.setColumns(10);
		
		/**
		 * Os botões Salvar e Cancelar fecham a tela quando clicados.
		 *
		 */
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (coletaDados())
				    salvar();
				dispose();
				
			}
		});
		btnSalvar.setBounds(221, 261, 117, 25);
		contentPane.add(btnSalvar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancelar.setBounds(357, 261, 117, 25);
		contentPane.add(btnCancelar);
		
		JButton btnMdico = new JButton("Médico");
		btnMdico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Tela_Lista_Medicos lista = new Tela_Lista_Medicos(consulta);
				lista.setVisible(true);
			}
		});
		btnMdico.setBounds(221, 132, 253, 25);
		contentPane.add(btnMdico);
		
		JButton btnpaciente = new JButton("Paciente");
		btnpaciente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Tela_Lista_Pacientes lista = new Tela_Lista_Pacientes(consulta);
				lista.setVisible(true);
			}
		});
		btnpaciente.setBounds(221, 169, 253, 25);
		contentPane.add(btnpaciente);
	}
	
	/**
	 * O método coletaDados(), pega os valores dos text_field e os atribui as variáveis corretas,
	 * fazendo as devidas conversões. Note que os text_field só recebem Strings, logo,
	 * variáveis do tipo Date, por exemplo, vão precisar passar por um tratamento antes de recebererem o dado.
	 * 
	 * */
	
	public boolean coletaDados() {

        Medico md = consulta.getMedico();

        try{
            if(!md.checkAgenda(txt_hora.getText()+"h")){
                JOptionPane.showMessageDialog(null, "alerta", "Erro ao selecionar o horário do atendimento!",
                JOptionPane.ERROR_MESSAGE);
                return false;
            }
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "alerta", "Erro ao selecionar o médico!",
            JOptionPane.ERROR_MESSAGE);
            return false;
        }
		
		Date data = null;
			
		
		try {
			data = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss").parse(txt_data.getText()+" "+txt_hora.getText()+":00");

            if(!md.checkDisponibilidade(data)){
                JOptionPane.showMessageDialog(null, "alerta", "Erro ao selecionar o dia e horário. Tente outra combinação.",
                JOptionPane.ERROR_MESSAGE);
                return false;
            }
		}catch(Exception e1){
			JOptionPane.showMessageDialog(null, "alerta", "Os formato da Data deve ser dd/MM/yyyy !",
            JOptionPane.ERROR_MESSAGE);
            return false;
		}
		
		consulta.setDataHora(data);
        return true;
	}
	
	/**
	 * O método salvar(), declara um objeto da classe DadosConsultas
	 * para salvar o objeto Consulta no arquivo Consultas.bin
	 * 
	 * */
	
	public void salvar() {
        Medico auxM;
        Medico medicoConsulta = consulta.getMedico();
        Paciente auxP;
        Paciente pacienteConsulta = consulta.getPaciente();
        pacienteConsulta.addVetorConsulta(consulta);
        medicoConsulta.registrarConsulta(consulta);

        DadosMedico dM = new DadosMedico();
        DadosPaciente dP = new DadosPaciente();

        auxM = dM.getMedico(medicoConsulta.getCpf());
        auxM.addConsulta(consulta);
        auxP = dP.getPaciente(pacienteConsulta.getCpf());
        auxP.addVetorConsulta(consulta);

        dM.remover(medicoConsulta.getCpf());
        dM.addMedico(auxM);
        dM.salvar();
        
        dP.remover(pacienteConsulta.getCpf());
        dP.addPaciente(auxP);
        dP.salvar();
		
	}
}
