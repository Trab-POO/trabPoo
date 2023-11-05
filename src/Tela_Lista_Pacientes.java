import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class Tela_Lista_Pacientes extends JFrame {
	
	private JList<String> listaPacientes;
	private List<String> selecionados;
	
	/**
	 * Essa Classe é responsável por listar todos os pacientes cadastrados
	 * Note que ela possui dois construtores.
	 * Num deles ela recebe como parâmetro um Object,
	 * isso nos auxilia a definir o paciente que atenderá a Consulta.
	 * Além de, indicar qual Paciente deve ser removido.
	 * 
	 * */
	
	/**
	 * Usamos o construtor padrão para remover Dados
	 * */
	public Tela_Lista_Pacientes() {
		
		DefaultListModel<String> listModel = new DefaultListModel<>();
        DadosPaciente pacientes = new DadosPaciente();
        ArrayList<Paciente> aux = pacientes.getPacientes();
        
        Iterator<Paciente> auxVet = aux.iterator();

        while(auxVet.hasNext()) {
        	listModel.addElement(auxVet.next().getNome());
		}
 
        //create the list
        listaPacientes = new JList<>(listModel);
        listaPacientes.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    final List<String> selectedValuesList = listaPacientes.getSelectedValuesList();
                    selecionados = selectedValuesList;
                    System.out.println(selectedValuesList);
                }
            }
        });
        getContentPane().setLayout(null);
 
        JScrollPane scrollPane = new JScrollPane(listaPacientes);
        scrollPane.setBounds(0, 0, 387, 170);
        getContentPane().add(scrollPane);
        
        /**
         * Note que o botão excluir chama o método removeDados();
         * */
        JButton excluir = new JButton("Excluir");
        excluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
        scrollPane.setColumnHeaderView(excluir);
        
        JButton btnCancelar = new JButton("Cancelar");
        btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
        scrollPane.setRowHeaderView(btnCancelar);
 
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Lista de Pacientes");
        this.setSize(399, 200);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
	}
	
	/**
	 * Usamos o segundo construtor para setar o Funcionário que registrou a Consulta
	 * 
	 * */
	
	public Tela_Lista_Pacientes(Consulta A) {
		
		DefaultListModel<String> listModel = new DefaultListModel<>();
        DadosPaciente pacientes = new DadosPaciente();
         ArrayList<Paciente> aux = pacientes.getPacientes();
        
        Iterator<Paciente> auxVet = aux.iterator();

        while(auxVet.hasNext()) {
        	listModel.addElement(auxVet.next().getNome());
		}
 
        //create the list
        listaPacientes = new JList<>(listModel);
        listaPacientes.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    final List<String> selectedValuesList = listaPacientes.getSelectedValuesList();
                    selecionados = selectedValuesList;
                    System.out.println(selectedValuesList);
                }
            }
        });
        getContentPane().setLayout(null);
 
        JScrollPane scrollPane = new JScrollPane(listaPacientes);
        scrollPane.setBounds(0, 0, 190, 170);
        getContentPane().add(scrollPane);
        
        JButton salvar = new JButton("Salvar");
        salvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				coletaDados(A);
				dispose();
			}
		});
        scrollPane.setColumnHeaderView(salvar);
        
        JButton btnCancelar = new JButton("Cancelar");
        btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
        scrollPane.setRowHeaderView(btnCancelar);
 
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Lista de Pacientes");
        this.setSize(200, 200);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela_Lista_Pacientes frame = new Tela_Lista_Pacientes();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
    /***
     * Método coletaDados(). Aqui ele recebe um Object e seta ele conforme a sua classe.
     * 
     * */
    public void coletaDados(Consulta A) {
    	DadosPaciente pacientes = new DadosPaciente();
        ArrayList<Paciente> aux = pacientes.getPacientes();
        
        Iterator<Paciente> auxVet = aux.iterator();
    	
    	ArrayList<Paciente> vetor = new ArrayList<Paciente>();
        
        for(int i = 0; i < selecionados.size(); i++) {
        	while(auxVet.hasNext()) {
        		if(selecionados.get(i).compareTo(auxVet.next().getNome()) == 0) {
        			vetor.add(auxVet.next());
        		}
        	}
        	
		}
        
        A.setPaciente(vetor.get(0));
    	
    }
    
    /**
     * Método removeDados(). Remove os Demais_Funcionarios selecionados.
     * */
    
    public void removeDados() {
    	DadosPaciente pacientes = new DadosPaciente();
        ArrayList<Paciente> aux = pacientes.getPacientes();
        
        Iterator<Paciente> auxVet = aux.iterator();
    	
        for(int i = 0; i < selecionados.size(); i++) {
        	while(auxVet.hasNext()) {
        		if(selecionados.get(i).compareTo(auxVet.next().getNome()) == 0) {
        			pacientes.remover(auxVet.next().getCpf());
        		}
        	}
        	
		}
        
    }



}
