package Model.Tabela;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JFormattedTextField;
import javax.swing.table.AbstractTableModel;
import javax.swing.text.MaskFormatter;

import Bin.Transporte.*;

@SuppressWarnings("serial")
public class ModelTabelaTransporte extends AbstractTableModel {

	private List<Transporte> dados;
	private String[] colunas = { "C�digo", "Modelo", "Cor", "Placa"};
	// voc� precisar que os dados tamb�m sejam imediatamente alterados no banco
	// de dados por exemplo,
	// voc� vai precisar adicionar um TableModelListener ao seu model que
	// executar� o m�todo
	// tableChanged toda vez que os dados da JTable forem alterados.
	public ModelTabelaTransporte() {
		dados = new ArrayList<Transporte>();

	}

	public void addRow(Transporte p) {

		this.dados.add(p);
		this.fireTableDataChanged();
	}

	public void removeTudo() {

		this.dados.clear();
		this.fireTableDataChanged();
	}

	public String getColumnName(int num) {
		return this.colunas[num];
	}

	// Tamb�m iremos precisar de um m�todo que remova uma linha da tabela
	public int removeRow(int linha) {
		int id = this.dados.get(linha).getId();
		this.dados.remove(linha);
		this.fireTableRowsDeleted(linha, linha);
		return id;
	}

	// Se voc� deve lembrar quando utiliz�vamos o DefaultTableModel pod�amos
	// alterar a tabela
	// simplesmente dando um duplo clique em cima e alguma c�lula e ela
	// permitiria a edi��o.
	// Isso acontecia porque no DefaultTableModel o m�todo isCellEditable(int
	// linha, int coluna)
	// que � chamado para saber se uma c�lula � edit�vel sempre retornava true,
	// mas no AbstractTableModel
	// ele retorna sempre false, ent�o devemos sobrescreve-lo
	public boolean isCellEditable(int linha, int coluna) {
		return true;
	}

	// Estes m�todos devem retornar respectivamente o numero de linhas, o numero
	// de colunas
	// e o valor da c�lula correspondente aos valores de linha e coluna
	// fornecidos por par�metro.
	@Override
	public int getColumnCount() {
		return colunas.length;
	}

	@Override
	public int getRowCount() {
		return dados.size();
	}

	@Override
	public Object getValueAt(int linha, int coluna) {

		switch (coluna) {

		case 0:
			return dados.get(linha).getId();
		case 1:
			return dados.get(linha).getModelo();
		case 2:
			return (dados.get(linha).getCor());

		case 3:
			return (dados.get(linha).getPlaca().substring(0, 3)+"-"+dados.get(linha).getPlaca().substring(3, 7) );

		}
		return null;
	}

}