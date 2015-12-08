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
	private String[] colunas = { "Código", "Descrição", "Quant", "Custo", "Preço", "Total Custo", "Total Preço" };

	DecimalFormat df = new DecimalFormat("0.00");
	SimpleDateFormat dt = new SimpleDateFormat("dd/MM/yyyy");

	public List<ItemRetorno> getDados() {
		return dados;
	}

	public void setDados(List<ItemRetorno> dados) {
		this.dados = dados;
	}

	// você precisar que os dados também sejam imediatamente alterados no banco
	// de dados por exemplo,
	// você vai precisar adicionar um TableModelListener ao seu model que
	// executará o método
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

	// Também iremos precisar de um método que remova uma linha da tabela
	public int removeRow(int linha) {
		int id = this.dados.get(linha).getId();
		this.dados.remove(linha);
		this.fireTableRowsDeleted(linha, linha);
		return id;
	}

	// Se você deve lembrar quando utilizávamos o DefaultTableModel podíamos
	// alterar a tabela
	// simplesmente dando um duplo clique em cima e alguma célula e ela
	// permitiria a edição.
	// Isso acontecia porque no DefaultTableModel o método isCellEditable(int
	// linha, int coluna)
	// que é chamado para saber se uma célula é editável sempre retornava true,
	// mas no AbstractTableModel
	// ele retorna sempre false, então devemos sobrescreve-lo
	public boolean isCellEditable(int linha, int coluna) {
		return true;
	}

	// Estes métodos devem retornar respectivamente o numero de linhas, o numero
	// de colunas
	// e o valor da célula correspondente aos valores de linha e coluna
	// fornecidos por parâmetro.
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