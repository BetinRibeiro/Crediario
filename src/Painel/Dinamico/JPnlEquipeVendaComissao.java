package Painel.Dinamico;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.table.TableModel;

import Model.Tabela.ModelTabelaVendedorEquipe;

import java.awt.Color;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTable;

public class JPnlEquipeVendaComissao extends JPanel {
	private JTable table;
	private ModelTabelaVendedorEquipe model = new ModelTabelaVendedorEquipe();

	/**
	 * Create the panel.
	 */
	public JPnlEquipeVendaComissao() {
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBounds(0, 0, 1075, 570);
		setLayout(null);
		
		JLabel lblRelaoDasVendas = new JLabel("Rela\u00E7\u00E3o das Vendas e Comiss\u00F5es ");
		lblRelaoDasVendas.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblRelaoDasVendas.setBounds(10, 10, 280, 25);
		add(lblRelaoDasVendas);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 40, 1055, 226);
		add(scrollPane);
		
		table = new JTable(model);
		scrollPane.setViewportView(table);
		
		JButton btnInserir = new JButton("Inserir");
		btnInserir.setBounds(945, 10, 120, 25);
		add(btnInserir);

	}
}
