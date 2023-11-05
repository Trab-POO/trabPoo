import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;

public class Tela_Lista_Remedio extends JFrame {
	
	private JList<String> listaRemedio;
	
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
	public Tela_Lista_Remedio() {
		
		DefaultListModel<String> listModel = new DefaultListModel<>();
        DadosRemedio remedio = new DadosRemedio();
        ArrayList<Remedio> aux = remedio.getRemedios();
        
        Iterator<Remedio> auxVet = aux.iterator();

        while(auxVet.hasNext()) {
        	listModel.addElement(auxVet.next().getNome());
		}
 
        //create the list
        listaRemedio = new JList<>(listModel);
 
        JScrollPane scrollPane = new JScrollPane(listaRemedio);
        scrollPane.setBounds(0, 0, 387, 170);
        getContentPane().add(scrollPane);
 
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Lista de Remédios");
        this.setSize(399, 200);
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
					Tela_Lista_Remedio frame = new Tela_Lista_Remedio();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


}
