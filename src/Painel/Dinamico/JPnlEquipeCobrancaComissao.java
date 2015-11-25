package Painel.Dinamico;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import Model.Tabela.ModelTabelaVendedorEquipeCobranca;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class JPnlEquipeCobrancaComissao extends JPanel {
private ModelTabelaVendedorEquipeCobranca model= new  ModelTabelaVendedorEquipeCobranca();
private JTable table;
private JTextField textField;
private JTextField textField_1;
private JTextField textField_2;
private JTextField textField_3;
private JTextField textField_4;
private JTextField textField_5;
	/**
	 * Create the panel.
	 */
	public JPnlEquipeCobrancaComissao() {
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBounds(0, 0, 1075, 570);
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(10, 50, 1055, 280);
		add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 43, 1035, 166);
		panel.add(scrollPane);
		
		table = new JTable(model);
		scrollPane.setViewportView(table);
		
		JLabel lblSaldoDaCobrana = new JLabel("SALDO DA COBRAN\u00C7A");
		lblSaldoDaCobrana.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSaldoDaCobrana.setBounds(10, 11, 364, 25);
		panel.add(lblSaldoDaCobrana);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(10, 239, 270, 20);
		panel.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(290, 239, 120, 20);
		panel.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(420, 239, 120, 20);
		panel.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(550, 239, 120, 20);
		panel.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(680, 239, 120, 20);
		panel.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(810, 239, 120, 20);
		panel.add(textField_5);
		
		JLabel label = new JLabel("CHEFE DA EQUIPE");
		label.setBounds(10, 219, 270, 14);
		panel.add(label);
		
		JLabel label_1 = new JLabel("TOTAL VENDA");
		label_1.setBounds(290, 219, 120, 14);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("COMISS\u00C3O");
		label_2.setBounds(420, 219, 120, 14);
		panel.add(label_2);
		
		JLabel lblCobrana = new JLabel("COBRAN\u00C7A");
		lblCobrana.setBounds(550, 219, 120, 14);
		panel.add(lblCobrana);
		
		JLabel lblComisso = new JLabel("COMISS\u00C3O");
		lblComisso.setBounds(680, 219, 120, 14);
		panel.add(lblComisso);
		
		JLabel label_5 = new JLabel("SALDO");
		label_5.setBounds(810, 219, 120, 14);
		panel.add(label_5);
		
		JLabel lblRelaoDeCobrana = new JLabel("RELA\u00C7\u00C3O DE COBRAN\u00C7A E SALDO");
		lblRelaoDeCobrana.setHorizontalAlignment(SwingConstants.CENTER);
		lblRelaoDeCobrana.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblRelaoDeCobrana.setBounds(10, 11, 1055, 25);
		add(lblRelaoDeCobrana);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(10, 341, 1055, 218);
		add(panel_1);

	}
}
