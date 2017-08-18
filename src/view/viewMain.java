package src.view;

import java.awt.BorderLayout;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JScrollPane;
import java.util.StringTokenizer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JScrollPane;
import java.util.StringTokenizer;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JTextArea;
import javax.swing.JTable;

public class viewMain extends JFrame {

	protected static final Component Component = null;
	private JPanel contentPane;
	private JTextField txtName;
	private JScrollPane  entradaScrollPane;
	private JTextArea textArea;
	private JTable table;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					viewMain frame = new viewMain();
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
	public viewMain() {
		Path caminho = Paths.get("/Users/babugia/Documents/teste.txt");
		ArrayList<Instrucao> instrucoes = new ArrayList<Instrucao>();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
				
		JButton btnNewButton = new JButton("Ler");
		btnNewButton.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					byte[] texto = Files.readAllBytes(caminho);
					List<String> teste = Files.readAllLines(caminho);
					
					String leitura = new String(texto);
//					JOptionPane.showMessageDialog(null, leitura);
					txtName.setText(leitura);
					
					String instrucao = null;
					String atributo2 = null;
					String atributo1 = null;
					
					Instrucao ins;
							
					for(int i=0;i<teste.size();i++) {
						String x[] = teste.get(i).split(" ");
						instrucao = x[0];
						atributo1 = x[1];
						
						if(atributo1.indexOf(",") != -1) { //contem mais de 1 atributo1 na instrucao
							String y[] = atributo1.split(",");
							atributo1 = y[0];
							atributo2 = y[1];	
							ins = new Instrucao(instrucao,Integer.parseInt(atributo1),Integer.parseInt(atributo2));
						}
						
						else {
							atributo2 = null;
							ins = new Instrucao(instrucao,Integer.parseInt(atributo1));
						}

							instrucoes.add(ins);
							
							
							textArea.append(ins.instrucao+' '+ ins.atributo1 +'\n');		
							
						System.out.println(ins.instrucao+'\n');
					
						
						
					}

					
				} catch(Exception erro) {
					
				}
//				JOptionPane.showMessageDialog(null, "Nome: " +txtName.getText());
			}
			
			
			
			
		});
		
		txtName = new JTextField();
		txtName.setColumns(10);
		
		JLabel labelTitle = new JLabel("Aprendendo");
		labelTitle.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		
		entradaScrollPane = new JScrollPane();
		entradaScrollPane.setViewportBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Janela de entrada", TitledBorder.CENTER, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
		entradaScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		table = new JTable();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(24)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(txtName, GroupLayout.DEFAULT_SIZE, 1551, Short.MAX_VALUE)
						.addComponent(labelTitle, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(147)
							.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGap(434))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(97)
							.addComponent(entradaScrollPane, GroupLayout.PREFERRED_SIZE, 195, GroupLayout.PREFERRED_SIZE)
							.addGap(71)
							.addComponent(table, GroupLayout.PREFERRED_SIZE, 280, GroupLayout.PREFERRED_SIZE)))
					.addGap(925))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(1)
					.addComponent(labelTitle, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
					.addGap(27)
					.addComponent(txtName, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(80)
							.addComponent(btnNewButton)
							.addPreferredGap(ComponentPlacement.RELATED, 117, Short.MAX_VALUE)
							.addComponent(entradaScrollPane, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE)
							.addGap(82))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(129)
							.addComponent(table, GroupLayout.PREFERRED_SIZE, 203, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())))
		);
		
		textArea = new JTextArea();
		entradaScrollPane.setViewportView(textArea);
		contentPane.setLayout(gl_contentPane);
	}
}
