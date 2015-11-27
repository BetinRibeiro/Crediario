package Painel.Dinamico;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;

public class JPnlDRE extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTextField textField_14;
	private JTextField textField_15;
	private JTextField textField_16;

	/**
	 * Create the panel.
	 */
	public JPnlDRE() {
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBounds(0, 0, 1075, 570);
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 46, 280, 513);
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		add(panel);
		panel.setLayout(null);
		
		JLabel lblVista = new JLabel("\u00C0 VISTA");
		lblVista.setBounds(10, 11, 110, 20);
		panel.add(lblVista);
		
		JLabel lblPraso = new JLabel("\u00C0 PRASO");
		lblPraso.setBounds(10, 36, 110, 20);
		panel.add(lblPraso);
		
		textField = new JTextField("0,00");
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setColumns(10);
		textField.setBounds(120, 36, 122, 20);
		panel.add(textField);
		
		JLabel lblReceita = new JLabel("OUTRAS");
		lblReceita.setBounds(10, 61, 110, 20);
		panel.add(lblReceita);
		
		textField_1 = new JTextField("0,00");
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setColumns(10);
		textField_1.setBounds(120, 61, 122, 20);
		panel.add(textField_1);
		
		textField_2 = new JTextField("0,00");
		textField_2.setHorizontalAlignment(SwingConstants.CENTER);
		textField_2.setColumns(10);
		textField_2.setBounds(120, 11, 122, 20);
		panel.add(textField_2);
		
		JLabel lblTotal = new JLabel("TOTAL");
		lblTotal.setBounds(10, 85, 110, 20);
		panel.add(lblTotal);
		
		JLabel lblCompra = new JLabel("COMPRA");
		lblCompra.setBounds(10, 116, 110, 20);
		panel.add(lblCompra);
		
		textField_3 = new JTextField("0,00");
		textField_3.setHorizontalAlignment(SwingConstants.CENTER);
		textField_3.setColumns(10);
		textField_3.setBounds(120, 116, 122, 20);
		panel.add(textField_3);
		
		JLabel lblRetorno = new JLabel("RETORNO");
		lblRetorno.setBounds(10, 141, 110, 20);
		panel.add(lblRetorno);
		
		textField_4 = new JTextField("0,00");
		textField_4.setHorizontalAlignment(SwingConstants.CENTER);
		textField_4.setColumns(10);
		textField_4.setBounds(120, 141, 122, 20);
		panel.add(textField_4);
		
		textField_5 = new JTextField("0,00");
		textField_5.setHorizontalAlignment(SwingConstants.CENTER);
		textField_5.setColumns(10);
		textField_5.setBounds(120, 85, 122, 20);
		panel.add(textField_5);
		
		JLabel lblCusto = new JLabel("CUSTO");
		lblCusto.setBounds(10, 165, 110, 20);
		panel.add(lblCusto);
		
		textField_6 = new JTextField("0,00");
		textField_6.setHorizontalAlignment(SwingConstants.CENTER);
		textField_6.setColumns(10);
		textField_6.setBounds(120, 165, 122, 20);
		panel.add(textField_6);
		
		JLabel lblVendedores = new JLabel("VENDEDORES");
		lblVendedores.setBounds(10, 196, 110, 20);
		panel.add(lblVendedores);
		
		JLabel lblChefeEquipe = new JLabel("CHEFE EQUIPE");
		lblChefeEquipe.setBounds(10, 221, 110, 20);
		panel.add(lblChefeEquipe);
		
		textField_7 = new JTextField("0,00");
		textField_7.setHorizontalAlignment(SwingConstants.CENTER);
		textField_7.setColumns(10);
		textField_7.setBounds(120, 221, 122, 20);
		panel.add(textField_7);
		
		JLabel lblCobrador = new JLabel("COBRADOR");
		lblCobrador.setBounds(10, 246, 110, 20);
		panel.add(lblCobrador);
		
		textField_8 = new JTextField("0,00");
		textField_8.setHorizontalAlignment(SwingConstants.CENTER);
		textField_8.setColumns(10);
		textField_8.setBounds(120, 246, 122, 20);
		panel.add(textField_8);
		
		textField_9 = new JTextField("0,00");
		textField_9.setHorizontalAlignment(SwingConstants.CENTER);
		textField_9.setColumns(10);
		textField_9.setBounds(120, 196, 122, 20);
		panel.add(textField_9);
		
		JLabel label_4 = new JLabel("TOTAL");
		label_4.setBounds(10, 270, 110, 20);
		panel.add(label_4);
		
		textField_10 = new JTextField("0,00");
		textField_10.setHorizontalAlignment(SwingConstants.CENTER);
		textField_10.setColumns(10);
		textField_10.setBounds(120, 270, 122, 20);
		panel.add(textField_10);
		
		JLabel lblBruto = new JLabel("BRUTO");
		lblBruto.setBounds(10, 301, 110, 20);
		panel.add(lblBruto);
		
		textField_11 = new JTextField("0,00");
		textField_11.setHorizontalAlignment(SwingConstants.CENTER);
		textField_11.setColumns(10);
		textField_11.setBounds(120, 301, 122, 20);
		panel.add(textField_11);
		
		JLabel lblDespLocal = new JLabel("DESP. LOCAL");
		lblDespLocal.setBounds(10, 332, 110, 20);
		panel.add(lblDespLocal);
		
		JLabel lblDespVenda = new JLabel("DESP. VENDA");
		lblDespVenda.setBounds(10, 357, 110, 20);
		panel.add(lblDespVenda);
		
		textField_12 = new JTextField("0,00");
		textField_12.setHorizontalAlignment(SwingConstants.CENTER);
		textField_12.setColumns(10);
		textField_12.setBounds(120, 357, 122, 20);
		panel.add(textField_12);
		
		JLabel lblDespCobrana = new JLabel("DESP. COBRAN\u00C7A");
		lblDespCobrana.setBounds(10, 382, 110, 20);
		panel.add(lblDespCobrana);
		
		textField_13 = new JTextField("0,00");
		textField_13.setHorizontalAlignment(SwingConstants.CENTER);
		textField_13.setColumns(10);
		textField_13.setBounds(120, 382, 122, 20);
		panel.add(textField_13);
		
		textField_14 = new JTextField("0,00");
		textField_14.setHorizontalAlignment(SwingConstants.CENTER);
		textField_14.setColumns(10);
		textField_14.setBounds(120, 332, 122, 20);
		panel.add(textField_14);
		
		JLabel label_5 = new JLabel("TOTAL");
		label_5.setBounds(10, 406, 110, 20);
		panel.add(label_5);
		
		textField_15 = new JTextField("0,00");
		textField_15.setHorizontalAlignment(SwingConstants.CENTER);
		textField_15.setColumns(10);
		textField_15.setBounds(120, 406, 122, 20);
		panel.add(textField_15);
		
		JLabel lblLiquido = new JLabel("LIQUIDO");
		lblLiquido.setBounds(10, 437, 110, 20);
		panel.add(lblLiquido);
		
		textField_16 = new JTextField("0,00");
		textField_16.setHorizontalAlignment(SwingConstants.CENTER);
		textField_16.setColumns(10);
		textField_16.setBounds(120, 437, 122, 20);
		panel.add(textField_16);
		
		JLabel label = new JLabel("PRESTA\u00C7\u00C3O DE CONTAS COM O CHEFE DA EQUIPE");
		label.setBounds(10, 10, 1055, 25);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Tahoma", Font.PLAIN, 16));
		add(label);
	}

}
