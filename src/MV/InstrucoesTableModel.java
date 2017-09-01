package src.MV;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import src.MV.Instrucao;

public class InstrucoesTableModel extends AbstractTableModel {
	
	private ArrayList<Instrucao> instrucoes;
	private String [] colunas = {"Linha", "Instrução", "#atributo1", "#atributo2", "Comentário" }; 
	
	public InstrucoesTableModel() {
		instrucoes = new ArrayList<Instrucao>();
	}
	
	public InstrucoesTableModel(ArrayList<Instrucao> i) {
		instrucoes = i;
	}
	
	public void addRow(Instrucao i) {
		this.instrucoes.add(i);
		this.fireTableDataChanged();
	}
	
	public void addRows() {
		this.fireTableDataChanged();
	}

	public String getColumnName(int num) {
		return this.colunas[num];
	}
	
	@Override
	public int getRowCount() {
		return instrucoes.size();
	}

	@Override
	public int getColumnCount() {
		return colunas.length;
	}
	
	public Instrucao get(int linha) {
		return this.instrucoes.get(linha);
	}

	@Override
	public Object getValueAt(int linha, int coluna) {
		switch(coluna) {
			case 0: return linha;
			case 1: return instrucoes.get(linha).getInstrucao();
			case 2: return instrucoes.get(linha).getAtributo1();
			case 3: return instrucoes.get(linha).getAtributo2();
			//VER COM MURILO OQ FAZER DO COMENTARIO
		}
		return null;
	}
	
	public void removeRow(int linha) {
		this.instrucoes.remove(linha);
		this.fireTableRowsDeleted(linha, linha);
	}

}
