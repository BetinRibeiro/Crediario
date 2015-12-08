package Model.Tabela;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import Bin.Funcionario.*;

@SuppressWarnings("serial")
public class ModelTabelaFuncionario extends AbstractTableModel {

	private List<Funcionario> dados;
	private String[] colunas = { "C�DIGO", "NOME", "TELEFONE", "TELEFONE2"};
	

	// voc� precisar que os dados tamb�m sejam imediatamente alterados no banco
	// de dados por exemplo,
	// voc� vai precisar adicionar um TableModelListener ao seu model que
	// executar� o m�todo
	// tableChanged toda vez que os dados da JTable forem alterados.
	public ModelTabelaFuncionario() {
		dados = new ArrayList<Funcionario>();

	}

	public void addRow(Funcionario p) {

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
			return dados.get(linha).getNome()+" "+dados.get(linha).getSobrenome();
		case 2:
			String fone = String.valueOf(dados.get(linha).getTelefone1());
			return ("("+fone.substring(0, 2)+") "+fone.substring(2, 6)+" - "+fone.substring(6, fone.length()));
//					(String.valueOf(dados.get(linha).getTelefone1())dados.get(linha).getTelefone1()String.valueOf(dados.get(linha).getTelefone1()).substring(2, 6)+" - "+String.valueOf(dados.get(linha).getTelefone1()).substring(6, 10) );

		case 3:
			String fone2 = String.valueOf(dados.get(linha).getTelefone2());
			return ("("+fone2.substring(0, 2)+") "+fone2.substring(2, 6)+" - "+fone2.substring(6, fone2.length()));

		}
		return null;
	}

}