package Model.Tabela;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import Bin.Equipe.VendedorEquipe;



@SuppressWarnings("serial")
public class ModelTabelaVendedorEquipe extends AbstractTableModel {

	private List<VendedorEquipe> dados;
	private String[] colunas = { "CÓDIGO", "NOME", "VENDA", "COMISSÃO", "PROMISSORIA", "CADERNO", "SALDO"};
	
	DecimalFormat df = new DecimalFormat("0.00");
    SimpleDateFormat dt = new SimpleDateFormat("dd/MM/yyyy" );

	// você precisar que os dados também sejam imediatamente alterados no banco
	// de dados por exemplo,
	// você vai precisar adicionar um TableModelListener ao seu model que
	// executará o método
	// tableChanged toda vez que os dados da JTable forem alterados.
	public ModelTabelaVendedorEquipe() {
		dados = new ArrayList<VendedorEquipe>();

	}

	public void addRow(VendedorEquipe p) {

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
			return dados.get(linha).getId();
		case 1:
			return (dados.get(linha).getVendedor().getNome());
		case 2:
			return df.format(dados.get(linha).getvenda());
		case 3:
			return df.format(dados.get(linha).getVlrComissaoVenda());
		case 4:
			return df.format(dados.get(linha).getValeLocal());
		case 5:
			return df.format(dados.get(linha).getValeViagem());
		case 6:
			return df.format(dados.get(linha).getSaldoVenda());

		}
		return null;
	}

	public VendedorEquipe getObj(int selectedRow) {
		// TODO Auto-generated method stub
		return dados.get(selectedRow);
	}

}