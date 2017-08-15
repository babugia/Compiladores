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

public class viewMain extends JFrame {

	private JPanel contentPane;
	private JTextField txtName;
	private JTextField txtInstrucao;

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btnNewButton = new JButton("Ler");
		btnNewButton.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Path caminho = Paths.get("/Users/babugia/Documents/teste.txt");
				try {
					byte[] texto = Files.readAllBytes(caminho);
					List<String> teste = Files.readAllLines(caminho);
					
					String leitura = new String(texto);
//					JOptionPane.showMessageDialog(null, leitura);
					txtName.setText(leitura);
					
					String instrucao = null;
					String valor2 = null;
					String valor = null;
					
					Instrucao ins;
					ArrayList<Instrucao> instrucoes = new ArrayList<Instrucao>();
					
					
					for(int i=0;i<teste.size();i++) {
						String x[] = teste.get(i).split(" ");
						instrucao = x[0];
						valor = x[1];
						
						if(valor.indexOf(",") != -1) { //contem mais de 1 valor na instrucao
							String y[] = valor.split(",");
							valor = y[0];
							valor2 = y[1];	
							ins = new Instrucao(instrucao,Integer.parseInt(valor),Integer.parseInt(valor2));
						}
						
						else {
							valor2 = null;
							ins = new Instrucao(instrucao,Integer.parseInt(valor));
						}

						
//						if(valor2 != null) {
							instrucoes.add(ins);
							
//						}
						
//						StringTokenizer st = new StringTokenizer(teste.get(i));
//						instrucao = (String) st.nextElement();
						System.out.println(instrucao);
						
						
					}
					
//					txtInstrucao.setText(x);

					
				} catch(Exception erro) {
					
				}
//				JOptionPane.showMessageDialog(null, "Nome: " +txtName.getText());
			}
		});
		
		txtName = new JTextField();
		txtName.setColumns(10);
		
		JLabel labelTitle = new JLabel("Aprendendo");
		labelTitle.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		
		txtInstrucao = new JTextField();
		txtInstrucao.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		txtInstrucao.setColumns(10);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(147)
					.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
					.addGap(34)
					.addComponent(txtInstrucao, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(358))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(24)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(txtName, GroupLayout.DEFAULT_SIZE, 760, Short.MAX_VALUE)
						.addComponent(labelTitle, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(1)
					.addComponent(labelTitle, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
					.addGap(27)
					.addComponent(txtName, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
					.addGap(80)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(txtInstrucao, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(345, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
