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
import javax.swing.SwingConstants;

public class JPnlEquipeVendaComissao extends JPanel {
	private JTable table;
	private ModelTabelaVendedorEquipe model = new ModelTabelaVendedorEquipe();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	/**
	 * Create the panel.
	 */
	public JPnlEquipeVendaComissao() {
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBounds(0, 0, 1075, 570);
		setLayout(null);
		
		JLabel lblRelaoDasVendas = new JLabel("RELA\u00C7\u00C3O DE VANDAS E COMISS\u00D5ES");
		lblRelaoDasVendas.setBounds(10, 10, 1055, 25);
		lblRelaoDasVendas.setHorizontalAlignment(SwingConstants.CENTER);
		lblRelaoDasVendas.setFont(new Font("Tahoma", Font.PLAIN, 16));
		add(lblRelaoDasVendas);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 45, 1055, 296);
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 41, 1035, 193);
		panel.add(scrollPane);
		
		table = new JTable(model);
		scrollPane.setViewportView(table);
		
		JButton btnInserir = new JButton("Inserir");
		btnInserir.setBounds(925, 11, 120, 25);
		panel.add(btnInserir);
		
		textField = new JTextField();
		textField.setBounds(10, 265, 270, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(290, 265, 120, 20);
		panel.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(420, 265, 120, 20);
		panel.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(550, 265, 120, 20);
		panel.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(680, 265, 120, 20);
		panel.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(810, 265, 120, 20);
		panel.add(textField_5);
		
		JLabel lblChefeDaEquipe = new JLabel("CHEFE DA EQUIPE");
		lblChefeDaEquipe.setBounds(10, 245, 270, 14);
		panel.add(lblChefeDaEquipe);
		
		JLabel lblTotalVenda = new JLabel("TOTAL VENDA");
		lblTotalVenda.setBounds(290, 245, 120, 14);
		panel.add(lblTotalVenda);
		
		JLabel lblComisso = new JLabel("COMISS\u00C3O");
		lblComisso.setBounds(420, 245, 120, 14);
		panel.add(lblComisso);
		
		JLabel lblPromissoria = new JLabel("PROMISSORIA");
		lblPromissoria.setBounds(550, 245, 120, 14);
		panel.add(lblPromissoria);
		
		JLabel lblDiferna = new JLabel("DIFER\u00CAN\u00C7A");
		lblDiferna.setBounds(680, 245, 120, 14);
		panel.add(lblDiferna);
		
		JLabel lblSaldo = new JLabel("SALDO");
		lblSaldo.setBounds(810, 245, 120, 14);
		panel.add(lblSaldo);
		
		JLabel lblSaldoDeVenda = new JLabel("SALDO DE VENDA DOS VENDEDORES");
		lblSaldoDeVenda.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSaldoDeVenda.setBounds(10, 11, 364, 25);
		panel.add(lblSaldoDeVenda);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 352, 1055, 207);
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblGrafico = new JLabel("Grafico");
		lblGrafico.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblGrafico.setBounds(58, 54, 311, 57);
		panel_1.add(lblGrafico);

	}
}
