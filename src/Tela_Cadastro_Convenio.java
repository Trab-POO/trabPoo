import java.awt.EventQueue;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.util.ArrayList;


public class Tela_Cadastro_Convenio extends JFrame {
    private JPanel contentPane;
    private JTextField txt_nome;
    private JTextArea txt_descricao;
    private List<Convenio> convenios = new ArrayList<>();

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Tela_Cadastro_Convenio frame = new Tela_Cadastro_Convenio();
                    frame.setVisible(true);
                } catch (Exception var2) {
                    var2.printStackTrace();
                }

            }
        });
    }

    public Tela_Cadastro_Convenio() {
        this.setDefaultCloseOperation(3);
        this.setBounds(100, 100, 486, 606);
        this.contentPane = new JPanel();
        this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        this.setContentPane(this.contentPane);
        this.contentPane.setLayout((LayoutManager)null);
        JLabel lblNome = new JLabel("Nome:");
        lblNome.setBounds(12, 12, 70, 15);
        this.contentPane.add(lblNome);
        this.txt_nome = new JTextField();
        this.txt_nome.setBounds(221, 10, 253, 19);
        this.contentPane.add(this.txt_nome);
        this.txt_nome.setColumns(10);
        JLabel lblDescricao = new JLabel("Descrição:");
        lblDescricao.setBounds(12, 42, 150, 15);
        this.contentPane.add(lblDescricao);
        this.txt_descricao = new JTextArea();
        this.txt_descricao.setBounds(221, 40, 253, 80);
        this.contentPane.add(this.txt_descricao);
        JButton btnSalvar = new JButton("Salvar");
        btnSalvar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Tela_Cadastro_Convenio.this.coletaDados();

                // Chame o método salvarConvenios e passe a lista de convênios e o caminho do arquivo
                LeituraArquivoConvenios.salvarConvenios(convenios, "Convenios.bin");

                Tela_Cadastro_Convenio.this.dispose();
            }
        });
        btnSalvar.setBounds(221, 516, 117, 25);
        this.contentPane.add(btnSalvar);
        JButton btnCancelar = new JButton("Cancelar");
        btnCancelar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Tela_Cadastro_Convenio.this.dispose();
            }
        });
        btnCancelar.setBounds(357, 516, 117, 25);
        this.contentPane.add(btnCancelar);
    }

    public void coletaDados() {
        String nome = this.txt_nome.getText();
        String descricao = this.txt_descricao.getText();
        Convenio convenio = new Convenio(nome, descricao);
        this.convenios.add(convenio);
    }

    public void salvar() {
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("Convenios.bin"));
            out.writeObject(this.convenios);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
