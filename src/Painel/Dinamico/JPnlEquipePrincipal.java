package Painel.Dinamico;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JLabel;
import java.awt.Font;
import com.toedter.calendar.JDateChooser;
import java.util.Date;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class JPnlEquipePrincipal extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTextField textField_14;
	private JTextField textField_15;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;

	/**
	 * Create the panel.
	 */
	public JPnlEquipePrincipal() {
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBounds(0, 0, 1075, 570);
		setLayout(null);
		
		JLabel lblInformaesDaEquipe = new JLabel("Informa\u00E7\u00F5es da Equipe");
		lblInformaesDaEquipe.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblInformaesDaEquipe.setBounds(10, 10, 347, 25);
		add(lblInformaesDaEquipe);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(20, 45, 295, 300);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblDataSaida = new JLabel("Data Saida");
		lblDataSaida.setBounds(20, 40, 120, 20);
		panel.add(lblDataSaida);
		lblDataSaida.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JDateChooser dateChooser = new JDateChooser((Date) null);
		dateChooser.setBounds(20, 65, 120, 20);
		panel.add(dateChooser);
		
		textField = new JTextField();
		textField.setBounds(20, 115, 122, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblValorCarradas = new JLabel("Valor Carradas");
		lblValorCarradas.setBounds(20, 90, 122, 20);
		panel.add(lblValorCarradas);
		lblValorCarradas.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JLabel lblValorPraso = new JLabel("Valor \u00E0 Praso");
		lblValorPraso.setBounds(20, 140, 122, 20);
		panel.add(lblValorPraso);
		lblValorPraso.setHorizontalAlignment(SwingConstants.RIGHT);
		
		textField_1 = new JTextField();
		textField_1.setBounds(20, 165, 122, 20);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblValorVista = new JLabel("Valor \u00E0 Vista");
		lblValorVista.setBounds(20, 240, 122, 20);
		panel.add(lblValorVista);
		lblValorVista.setHorizontalAlignment(SwingConstants.RIGHT);
		
		textField_2 = new JTextField();
		textField_2.setBounds(20, 265, 122, 20);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(20, 215, 122, 20);
		panel.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblValorRetorno = new JLabel("Valor Retorno");
		lblValorRetorno.setBounds(20, 190, 122, 20);
		panel.add(lblValorRetorno);
		lblValorRetorno.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JLabel lblValorCompra = new JLabel("Custo Carradas");
		lblValorCompra.setBounds(150, 90, 122, 20);
		panel.add(lblValorCompra);
		lblValorCompra.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JLabel lblCustoRetorno = new JLabel("Custo Retorno");
		lblCustoRetorno.setBounds(150, 190, 122, 20);
		panel.add(lblCustoRetorno);
		lblCustoRetorno.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JLabel lblCustoPraso = new JLabel("Custo Praso");
		lblCustoPraso.setBounds(150, 140, 122, 20);
		panel.add(lblCustoPraso);
		lblCustoPraso.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JLabel lblCustoVista = new JLabel("Custo \u00E0 Vista");
		lblCustoVista.setBounds(150, 240, 122, 20);
		panel.add(lblCustoVista);
		lblCustoVista.setHorizontalAlignment(SwingConstants.RIGHT);
		
		textField_12 = new JTextField();
		textField_12.setBounds(150, 115, 122, 20);
		panel.add(textField_12);
		textField_12.setColumns(10);
		
		textField_13 = new JTextField();
		textField_13.setBounds(150, 165, 122, 20);
		panel.add(textField_13);
		textField_13.setColumns(10);
		
		textField_14 = new JTextField();
		textField_14.setBounds(150, 215, 122, 20);
		panel.add(textField_14);
		textField_14.setColumns(10);
		
		textField_15 = new JTextField();
		textField_15.setBounds(150, 265, 122, 20);
		panel.add(textField_15);
		textField_15.setColumns(10);
		
		JLabel lblMercadoriaEVendas = new JLabel("Mercadoria e Vendas");
		lblMercadoriaEVendas.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblMercadoriaEVendas.setBounds(20, 10, 252, 20);
		panel.add(lblMercadoriaEVendas);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(325, 45, 295, 205);
		add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblDespesaVenda = new JLabel("Despesa Venda");
		lblDespesaVenda.setBounds(20, 90, 120, 20);
		panel_1.add(lblDespesaVenda);
		lblDespesaVenda.setHorizontalAlignment(SwingConstants.RIGHT);
		
		textField_8 = new JTextField();
		textField_8.setBounds(20, 115, 122, 20);
		panel_1.add(textField_8);
		textField_8.setColumns(10);
		
		JLabel lblDespesaLocal = new JLabel("Despesa Local");
		lblDespesaLocal.setBounds(150, 90, 120, 20);
		panel_1.add(lblDespesaLocal);
		lblDespesaLocal.setHorizontalAlignment(SwingConstants.RIGHT);
		
		textField_11 = new JTextField();
		textField_11.setBounds(150, 115, 122, 20);
		panel_1.add(textField_11);
		textField_11.setColumns(10);
		
		JLabel lblDespesasEComisso = new JLabel("Despesas e Comiss\u00E3o");
		lblDespesasEComisso.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDespesasEComisso.setBounds(20, 10, 220, 20);
		panel_1.add(lblDespesasEComisso);
		
		textField_9 = new JTextField();
		textField_9.setBounds(152, 165, 122, 20);
		panel_1.add(textField_9);
		textField_9.setColumns(10);
		
		JLabel lblTotalVales = new JLabel("Total Comiss\u00E3o");
		lblTotalVales.setBounds(152, 140, 120, 20);
		panel_1.add(lblTotalVales);
		lblTotalVales.setHorizontalAlignment(SwingConstants.RIGHT);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(20, 165, 122, 20);
		panel_1.add(textField_4);
		
		JLabel lblDespesaComisso = new JLabel("Despesa Cobran\u00E7a");
		lblDespesaComisso.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDespesaComisso.setBounds(22, 140, 120, 20);
		panel_1.add(lblDespesaComisso);
		
		JLabel lblDataChegada = new JLabel("Data Chegada");
		lblDataChegada.setBounds(20, 40, 120, 20);
		panel_1.add(lblDataChegada);
		lblDataChegada.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JDateChooser dateChooser_1 = new JDateChooser((Date) null);
		dateChooser_1.setBounds(20, 65, 122, 20);
		panel_1.add(dateChooser_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_2.setBounds(630, 45, 295, 205);
		add(panel_2);
		panel_2.setLayout(null);
		
		textField_10 = new JTextField();
		textField_10.setBounds(10, 115, 122, 20);
		panel_2.add(textField_10);
		textField_10.setColumns(10);
		
		JLabel lblPontoDeEquilibrio = new JLabel("Ponto de Equilibrio");
		lblPontoDeEquilibrio.setBounds(10, 90, 122, 20);
		panel_2.add(lblPontoDeEquilibrio);
		lblPontoDeEquilibrio.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JLabel lblCobrana = new JLabel("Recebimento Cobran\u00E7a");
		lblCobrana.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCobrana.setBounds(10, 11, 252, 20);
		panel_2.add(lblCobrana);
		
		JDateChooser dateChooser_2 = new JDateChooser((Date) null);
		dateChooser_2.setBounds(10, 65, 122, 20);
		panel_2.add(dateChooser_2);
		
		JLabel lblDataCobrana = new JLabel("Dia da Cobran\u00E7a");
		lblDataCobrana.setBounds(10, 40, 122, 20);
		panel_2.add(lblDataCobrana);
		lblDataCobrana.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JLabel lblFinalCobrana = new JLabel("Final Cobran\u00E7a");
		lblFinalCobrana.setBounds(150, 40, 101, 20);
		panel_2.add(lblFinalCobrana);
		lblFinalCobrana.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JDateChooser dateChooser_3 = new JDateChooser((Date) null);
		dateChooser_3.setBounds(150, 65, 122, 20);
		panel_2.add(dateChooser_3);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(150, 115, 122, 20);
		panel_2.add(textField_5);
		
		JLabel lblValorDepositado = new JLabel("Valor Depositado");
		lblValorDepositado.setHorizontalAlignment(SwingConstants.RIGHT);
		lblValorDepositado.setBounds(150, 90, 122, 20);
		panel_2.add(lblValorDepositado);
		
		JLabel lblValorCobrado = new JLabel("Valor Cobrado");
		lblValorCobrado.setHorizontalAlignment(SwingConstants.RIGHT);
		lblValorCobrado.setBounds(10, 140, 122, 20);
		panel_2.add(lblValorCobrado);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(10, 165, 122, 20);
		panel_2.add(textField_6);
		
		JLabel lblResultado = new JLabel("Resultado");
		lblResultado.setHorizontalAlignment(SwingConstants.RIGHT);
		lblResultado.setBounds(150, 140, 122, 20);
		panel_2.add(lblResultado);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(150, 165, 122, 20);
		panel_2.add(textField_7);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_3.setBounds(325, 265, 730, 300);
		add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblGraficoDeBarra = new JLabel("Grafico de Barra");
		lblGraficoDeBarra.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblGraficoDeBarra.setBounds(196, 117, 287, 54);
		panel_3.add(lblGraficoDeBarra);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(20, 360, 295, 199);
		add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblGraficoDePizza = new JLabel("Grafico de Pizza");
		lblGraficoDePizza.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblGraficoDePizza.setBounds(86, 88, 136, 54);
		panel_4.add(lblGraficoDePizza);

	}
}
