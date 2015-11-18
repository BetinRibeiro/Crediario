package Painel.Dinamico;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTextField;

public class JPnlEquipeVendaComissao extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;

	/**
	 * Create the panel.
	 */
	public JPnlEquipeVendaComissao() {
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBounds(0, 0, 1075, 570);
		setLayout(null);
		
		JLabel lblRelaoDasVendas = new JLabel("Rela\u00E7\u00E3o das Vendas e Comiss\u00F5es ");
		lblRelaoDasVendas.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblRelaoDasVendas.setBounds(10, 10, 597, 26);
		add(lblRelaoDasVendas);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 213, 1055, 171);
		add(scrollPane);
		
		JLabel lblCdigo = new JLabel("C\u00F3digo");
		lblCdigo.setBounds(10, 45, 46, 14);
		add(lblCdigo);
		
		JLabel lblNome = new JLabel("Nome ");
		lblNome.setBounds(90, 45, 46, 14);
		add(lblNome);
		
		JButton btnNewButton = new JButton("Inserir");
		btnNewButton.setBounds(233, 156, 89, 23);
		add(btnNewButton);
		
		textField = new JTextField();
		textField.setEnabled(false);
		textField.setBackground(new Color(255, 250, 205));
		textField.setBounds(86, 65, 237, 20);
		add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setEnabled(false);
		textField_1.setBackground(new Color(255, 250, 205));
		textField_1.setColumns(10);
		textField_1.setBounds(10, 65, 63, 20);
		add(textField_1);
		
		JLabel lblPromissoria = new JLabel("Promissoria");
		lblPromissoria.setBounds(10, 97, 90, 14);
		add(lblPromissoria);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(10, 115, 90, 20);
		add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(115, 115, 90, 20);
		add(textField_3);
		
		JLabel lblVenda = new JLabel("Vale");
		lblVenda.setBounds(115, 97, 90, 14);
		add(lblVenda);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(10, 157, 90, 20);
		add(textField_4);
		
		JLabel lblPercentual = new JLabel("Venda");
		lblPercentual.setBounds(10, 139, 90, 14);
		add(lblPercentual);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(233, 115, 90, 20);
		add(textField_5);
		
		JLabel lblComisso = new JLabel("% Comiss\u00E3o");
		lblComisso.setBounds(233, 97, 90, 14);
		add(lblComisso);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(333, 64, 89, 23);
		add(btnBuscar);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(115, 159, 90, 20);
		add(textField_6);
		
		JLabel lblEntradas = new JLabel("Entradas");
		lblEntradas.setBounds(115, 141, 90, 14);
		add(lblEntradas);

	}
}
