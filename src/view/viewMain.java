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
import javax.swing.JDialog;

import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.io.IOException;
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
import java.awt.Dimension;

import javax.swing.JTextArea;
import javax.swing.JTable;
import javax.swing.JMenu;
import javax.swing.table.DefaultTableModel;

import src.MV.Instrucao;
import src.MV.InstrucoesTableModel;

import javax.swing.JFileChooser;

public class viewMain extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected static final Component Component = null;
	private JPanel contentPane;
	private JScrollPane EntradaScrollPane;
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
	private ArrayList<Instrucao> instrucoes;
	private InstrucoesTableModel tm;
	private Path caminho;
	private File file;
	private String filePath;
	private JMenuItem mi;
	private JButton btnOpen;

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
		instrucoes = new ArrayList<Instrucao>();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1062, 600);

		menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		btnOpen = new JButton("Arquivo");
		btnOpen.addActionListener(this);
		menuBar.add(btnOpen);

		fileChooser = new JFileChooser();
		fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

		mnExecutar = new JMenu("Executar");
		menuBar.add(mnExecutar);

		mnExit = new JMenu("Exit");
		menuBar.add(mnExit);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		EntradaScrollPane = new JScrollPane();
		EntradaScrollPane.setViewportBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null),
				"Janela de entrada", TitledBorder.CENTER, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
		EntradaScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

		table = new JTable();

		table_1 = new JTable();

		JScrollPane InstrucoesExecutarscrollPane = new JScrollPane();

		ConteudoPilhascrollPane = new JScrollPane();

		SaindascrollPane = new JScrollPane();
		SaindascrollPane.setViewportBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Janela de Sa\u00EDda", TitledBorder.CENTER, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
		SaindascrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

		BreakPointscrollPane = new JScrollPane();
		BreakPointscrollPane.setViewportBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null),
				"Janela de Break Point", TitledBorder.CENTER, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
		BreakPointscrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
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
							.addComponent(table_1, GroupLayout.PREFERRED_SIZE, 321, GroupLayout.PREFERRED_SIZE)))
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
					.addPreferredGap(ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(EntradaScrollPane, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE)
						.addComponent(BreakPointscrollPane, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE)
						.addComponent(SaindascrollPane, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE))
					.addGap(59))
		);

		table_Pilha = new JTable();
		table_Pilha.setModel(
				new DefaultTableModel(new Object[][] { { null, null }, }, new String[] { "Valor", "Endere\u00E7o" }));
		ConteudoPilhascrollPane.setViewportView(table_Pilha);

		table_Instrucoes = new JTable();
		tm = new InstrucoesTableModel();
		table_Instrucoes.setModel(tm);

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

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == btnOpen) {
			int returnVal = fileChooser.showOpenDialog(viewMain.this);

			if (returnVal == JFileChooser.APPROVE_OPTION) {
				file = fileChooser.getSelectedFile();
				filePath = file.getAbsolutePath();
				caminho = Paths.get(filePath);
				System.out.println("Opening: " + file.getName() + ".");

				String instrucao = null;
				String atributo2 = null;
				String atributo1 = null;

				Instrucao ins;

				List<String> linhas;
				try {
					linhas = Files.readAllLines(caminho);
					for (int i = 0; i < linhas.size(); i++) {
						String x[] = linhas.get(i).split(" ");
		
						if(x.length > 1) {
							instrucao = x[0];
							atributo1 = x[1];
	
							if (atributo1.indexOf(",") != -1) { // contem mais de 1 atributo1 na instrucao
								String y[] = atributo1.split(",");
								atributo1 = y[0];
								atributo2 = y[1];
								ins = new Instrucao(instrucao, atributo1, atributo2);
							}
	
							else {
								ins = new Instrucao(instrucao, atributo1);
							}
	
						}
						else {
							instrucao = x[0];
							ins = new Instrucao(instrucao);
						}
						instrucoes.add(ins);
					}
				} catch (IOException e1) {
					e1.printStackTrace();
				}

				tm = new InstrucoesTableModel(instrucoes);
				table_Instrucoes.setModel(tm);
				tm.addRows();

			}
		}

	}
}
