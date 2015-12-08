package Model.Tabela;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import Bin.Retorno.ItemRetorno;


@SuppressWarnings("serial")
public class ModelTabelaItemRetorno extends AbstractTableModel {

	private List<ItemRetorno> dados;
	private String[] colunas = { "C�digo", "Descri��o", "Quant", "Custo", "Pre�o", "Total Custo", "Total Pre�o" };

	DecimalFormat df = new DecimalFormat("0.00");
	SimpleDateFormat dt = new SimpleDateFormat("dd/MM/yyyy");

	public List<ItemRetorno> getDados() {
		return dados;
	}

	public void setDados(List<ItemRetorno> dados) {
		this.dados = dados;
	}

	// voc� precisar que os dados tamb�m sejam imediatamente alterados no banco
	// de dados por exemplo,
	// voc� vai precisar adicionar um TableModelListener ao seu model que
	// executar� o m�todo
	// tableChanged toda vez que os dados da JTable forem alterados.
	public ModelTabelaItemRetorno() {
		dados = new ArrayList<ItemRetorno>();

	}

	public void addRow(ItemRetorno p) {

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
			return dados.get(linha).getProduto().getId();
		case 1:
			return (dados.get(linha).getProduto().getDescricao());
		case 2:
			return (dados.get(linha).getQuantidade());
		case 3:
			return (dados.get(linha).getCusto());
		case 4:
			return (dados.get(linha).getValor());
		case 5:
			return (dados.get(linha).getCusto() * (dados.get(linha).getQuantidade()));
		case 6:
			return (dados.get(linha).getValor() * (dados.get(linha).getQuantidade()));

		}
		return null;
	}
	public Object getObj(int linha ) {
		return dados.get(linha);
	}

}