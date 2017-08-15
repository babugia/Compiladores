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
import javax.swing.JMenu;
import javax.swing.table.DefaultTableModel;
import javax.swing.JFileChooser;

public class viewMain extends JFrame {

	protected static final Component Component = null;
	private JPanel contentPane;
	private JTextField txtName;
	private JScrollPane  EntradaScrollPane;
	private JTextArea textArea;
	private JMenuBar menuBar;
	private JMenu mnNewMenu_Arquivo;
	private JMenu mnExecutar;
	private JMenu mnExit;
	private JTable table;
	private JTable table_1;
	private JTable table_Instrucoes;
	private JScrollPane ConteudoPilhascrollPane;
	private JTable table_Pilha;
	private JScrollPane SaindascrollPane;
	private JScrollPane BreakPointscrollPane;
	private JFileChooser fileChooser;
	

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
		Path caminho = Paths.get("C:\\\\Users\\\\Murilo\\\\Documents\\\\Compiladores\\\\teste\\\\teste.txt");
		ArrayList<Instrucao> instrucoes = new ArrayList<Instrucao>();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1062, 600);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnNewMenu_Arquivo = new JMenu("Arquivo");
		menuBar.add(mnNewMenu_Arquivo);
		
		
		fileChooser = new JFileChooser();
		mnNewMenu_Arquivo.add(fileChooser);
		
		
		
		
		mnExecutar = new JMenu("Executar");
		menuBar.add(mnExecutar);
		
		mnExit = new JMenu("Exit");
		menuBar.add(mnExit);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
				
		JButton btnNewButton = new JButton("Ler");
		btnNewButton.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		mnNewMenu_Arquivo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					byte[] texto = Files.readAllBytes(caminho);
					List<String> teste = Files.readAllLines(caminho);
					
					String leitura = new String(texto);
					JOptionPane.showMessageDialog(null, leitura);
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
							
							
							//textArea.append(ins.instrucao+' '+ ins.atributo1 +'\n');		
							
						System.out.println(ins.instrucao+'\n');
					
					}
					
				} catch(Exception erro) {
					
				}
				//JOptionPane.showMessageDialog(null, "Nome: " +txtName.getText());
			}
			
		});
		
		txtName = new JTextField();
		txtName.setColumns(10);
		
		EntradaScrollPane = new JScrollPane();
		EntradaScrollPane.setViewportBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Janela de entrada", TitledBorder.CENTER, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
		EntradaScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		table = new JTable();
		
		table_1 = new JTable();
		
		JScrollPane InstrucoesExecutarscrollPane = new JScrollPane();
		
		ConteudoPilhascrollPane = new JScrollPane();
		
		SaindascrollPane = new JScrollPane();
		SaindascrollPane.setViewportBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Janela de Saída", TitledBorder.CENTER, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
		SaindascrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		BreakPointscrollPane = new JScrollPane();
		BreakPointscrollPane.setViewportBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Janela de Break Point", TitledBorder.CENTER, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
		BreakPointscrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
							.addGap(63)
							.addComponent(txtName, GroupLayout.DEFAULT_SIZE, 1185, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addContainerGap()
									.addComponent(EntradaScrollPane, GroupLayout.PREFERRED_SIZE, 195, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(SaindascrollPane, GroupLayout.PREFERRED_SIZE, 195, GroupLayout.PREFERRED_SIZE)
									.addGap(86)
									.addComponent(BreakPointscrollPane, GroupLayout.PREFERRED_SIZE, 195, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(4)
									.addComponent(InstrucoesExecutarscrollPane, GroupLayout.PREFERRED_SIZE, 767, GroupLayout.PREFERRED_SIZE)))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(ConteudoPilhascrollPane, GroupLayout.PREFERRED_SIZE, 249, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(table, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(44)
									.addComponent(table_1, GroupLayout.PREFERRED_SIZE, 321, GroupLayout.PREFERRED_SIZE)))))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addComponent(InstrucoesExecutarscrollPane, GroupLayout.DEFAULT_SIZE, 301, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(71)
							.addComponent(table, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE)
							.addGap(61)
							.addComponent(table_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(ConteudoPilhascrollPane, 0, 0, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(EntradaScrollPane, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE)
						.addComponent(BreakPointscrollPane, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE)
						.addComponent(SaindascrollPane, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtName, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton)))
		);
		
		table_Pilha = new JTable();
		table_Pilha.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null},
			},
			new String[] {
				"Valor", "Endere\u00E7o"
			}
		));
		ConteudoPilhascrollPane.setViewportView(table_Pilha);
		
		table_Instrucoes = new JTable();
		table_Instrucoes.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
			},
			new String[] {
				"Linha", "Instru\u00E7\u00E3o", "Atributo #1", "Atributo #2", "Coment\u00E1rio"
			}
		));
		table_Instrucoes.getColumnModel().getColumn(0).setPreferredWidth(40);
		table_Instrucoes.getColumnModel().getColumn(1).setPreferredWidth(65);
		table_Instrucoes.getColumnModel().getColumn(2).setPreferredWidth(82);
		table_Instrucoes.getColumnModel().getColumn(3).setPreferredWidth(82);
		table_Instrucoes.getColumnModel().getColumn(4).setPreferredWidth(100);
		table_Instrucoes.getColumnModel().getColumn(4).setMinWidth(22);
		InstrucoesExecutarscrollPane.setViewportView(table_Instrucoes);
		
		textArea = new JTextArea();
		EntradaScrollPane.setRowHeaderView(textArea);
		contentPane.setLayout(gl_contentPane);
	}
}
