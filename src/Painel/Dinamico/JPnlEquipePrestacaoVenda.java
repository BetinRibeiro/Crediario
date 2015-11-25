package Painel.Dinamico;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.TextField;

import javax.swing.SwingConstants;
import com.toedter.calendar.JDateChooser;
import java.util.Date;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class JPnlEquipePrestacaoVenda extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_8;
	private JTextField textField_12;
	private JTextField textField_14;
	private JTextField textField_16;
	private JTextField textField_11;
	private JTextField textField_13;
	private JTextField textField_15;
	private JTextField textField_17;
	private JTextField textField_18;
	private JTextField textField_19;
	private JTextField textField_20;
	private JTextField textField_21;
	private JTextField textField_22;
	private JTextField textField_23;
	private JTextField textField_24;
	private JTextField textField_25;
	private JTextField textField_26;
	private JTextField textField_27;
	private JTextField textField_28;
	private JTextField textField_29;

	/**
	 * Create the panel.
	 */
	public JPnlEquipePrestacaoVenda() {
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBounds(0, 0, 1075, 570);
		setLayout(null);
		
		JLabel lblPrestaoDeContas = new JLabel("PRESTA\u00C7\u00C3O DE CONTAS COM O CHEFE DA EQUIPE");
		lblPrestaoDeContas.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrestaoDeContas.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPrestaoDeContas.setBounds(10, 11, 1055, 25);
		add(lblPrestaoDeContas);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(10, 50, 340, 510);
		add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(10, 40, 321, 95);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblDataSaida = new JLabel("DATA SAIDA");
		lblDataSaida.setBounds(10, 10, 110, 20);
		panel_1.add(lblDataSaida);
		
		JDateChooser dateChooser = new JDateChooser((Date) null);
		dateChooser.setBounds(120, 10, 122, 20);
		panel_1.add(dateChooser);
		
		JDateChooser dateChooser_1 = new JDateChooser((Date) null);
		dateChooser_1.setBounds(120, 35, 122, 20);
		panel_1.add(dateChooser_1);
		
		JLabel lblDataChegada = new JLabel("DATA CHEGADA");
		lblDataChegada.setBounds(10, 35, 110, 20);
		panel_1.add(lblDataChegada);
		
		JLabel lblDiasViajados = new JLabel("QUANT. DIAS");
		lblDiasViajados.setBounds(10, 65, 110, 20);
		panel_1.add(lblDiasViajados);
		
		textField = new JTextField("0");
		textField.setBackground(new Color(255, 250, 205));
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setDisabledTextColor(new Color(0, 0, 0));
		textField.setForeground(new Color(255, 250, 205));
		textField.setEnabled(false);
		textField.setBounds(120, 65, 122, 20);
		panel_1.add(textField);
		textField.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_2.setBounds(10, 145, 321, 140);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		textField_1 = new JTextField("0,00");
		textField_1.setBackground(new Color(255, 250, 205));
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setDisabledTextColor(new Color(0, 0, 0));
		textField_1.setForeground(new Color(255, 250, 205));
		textField_1.setEnabled(false);
		textField_1.setBounds(120, 10, 122, 20);
		panel_2.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblValorCarrada = new JLabel("TOTAL CARRADAS");
		lblValorCarrada.setBounds(10, 10, 110, 20);
		panel_2.add(lblValorCarrada);
		
		textField_2 = new JTextField("0,00");
		textField_2.setBackground(new Color(255, 250, 205));
		textField_2.setHorizontalAlignment(SwingConstants.CENTER);
		textField_2.setDisabledTextColor(new Color(0, 0, 0));
		textField_2.setForeground(new Color(255, 250, 205));
		textField_2.setEnabled(false);
		textField_2.setColumns(10);
		textField_2.setBounds(120, 35, 122, 20);
		panel_2.add(textField_2);
		
		JLabel lblVendaPraso = new JLabel("VENDA \u00C0 PRASO");
		lblVendaPraso.setBounds(10, 35, 110, 20);
		panel_2.add(lblVendaPraso);
		
		textField_3 = new JTextField("0,00");
		textField_3.setBackground(new Color(255, 250, 205));
		textField_3.setHorizontalAlignment(SwingConstants.CENTER);
		textField_3.setDisabledTextColor(new Color(0, 0, 0));
		textField_3.setForeground(new Color(255, 250, 205));
		textField_3.setEnabled(false);
		textField_3.setColumns(10);
		textField_3.setBounds(120, 60, 122, 20);
		panel_2.add(textField_3);
		
		JLabel lblRetorno = new JLabel("RETORNO");
		lblRetorno.setBounds(10, 60, 110, 20);
		panel_2.add(lblRetorno);
		
		textField_4 = new JTextField("0,00");
		textField_4.setBackground(new Color(255, 250, 205));
		textField_4.setHorizontalAlignment(SwingConstants.CENTER);
		textField_4.setDisabledTextColor(new Color(0, 0, 0));
		textField_4.setForeground(new Color(255, 250, 205));
		textField_4.setEnabled(false);
		textField_4.setColumns(10);
		textField_4.setBounds(175, 85, 135, 20);
		panel_2.add(textField_4);
		
		JLabel lblDiferna = new JLabel("DIFER\u00CAN\u00C7A");
		lblDiferna.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDiferna.setBounds(60, 85, 110, 20);
		panel_2.add(lblDiferna);
		
		textField_5 = new JTextField("0,00");
		textField_5.setBackground(new Color(255, 250, 205));
		textField_5.setHorizontalAlignment(SwingConstants.CENTER);
		textField_5.setDisabledTextColor(new Color(0, 0, 0));
		textField_5.setForeground(new Color(255, 250, 205));
		textField_5.setEnabled(false);
		textField_5.setColumns(10);
		textField_5.setBounds(252, 10, 59, 20);
		panel_2.add(textField_5);
		
		textField_6 = new JTextField("0,00");
		textField_6.setBackground(new Color(255, 250, 205));
		textField_6.setHorizontalAlignment(SwingConstants.CENTER);
		textField_6.setDisabledTextColor(new Color(0, 0, 0));
		textField_6.setForeground(new Color(255, 250, 205));
		textField_6.setEnabled(false);
		textField_6.setColumns(10);
		textField_6.setBounds(252, 35, 59, 20);
		panel_2.add(textField_6);
		
		textField_7 = new JTextField("0,00");
		textField_7.setBackground(new Color(255, 250, 205));
		textField_7.setHorizontalAlignment(SwingConstants.CENTER);
		textField_7.setDisabledTextColor(new Color(0, 0, 0));
		textField_7.setForeground(new Color(255, 250, 205));
		textField_7.setEnabled(false);
		textField_7.setColumns(10);
		textField_7.setBounds(252, 60, 59, 20);
		panel_2.add(textField_7);
		
		JLabel lblVendaVista = new JLabel("VENDA \u00C0 VISTA");
		lblVendaVista.setBounds(10, 110, 110, 20);
		panel_2.add(lblVendaVista);
		
		textField_9 = new JTextField("0,00");
		textField_9.setBackground(new Color(255, 250, 205));
		textField_9.setHorizontalAlignment(SwingConstants.CENTER);
		textField_9.setDisabledTextColor(new Color(0, 0, 0));
		textField_9.setForeground(new Color(255, 250, 205));
		textField_9.setEnabled(false);
		textField_9.setColumns(10);
		textField_9.setBounds(120, 110, 122, 20);
		panel_2.add(textField_9);
		
		textField_10 = new JTextField("0,00");
		textField_10.setBackground(new Color(255, 250, 205));
		textField_10.setHorizontalAlignment(SwingConstants.CENTER);
		textField_10.setDisabledTextColor(new Color(0, 0, 0));
		textField_10.setForeground(new Color(255, 250, 205));
		textField_10.setEnabled(false);
		textField_10.setColumns(10);
		textField_10.setBounds(252, 110, 59, 20);
		panel_2.add(textField_10);
		
		JLabel lblDescrioDaPrestao = new JLabel("DESCRI\u00C7\u00C3O DA PRESTA\u00C7\u00C3O");
		lblDescrioDaPrestao.setHorizontalAlignment(SwingConstants.CENTER);
		lblDescrioDaPrestao.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDescrioDaPrestao.setBounds(10, 10, 321, 25);
		panel.add(lblDescrioDaPrestao);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_3.setBounds(10, 295, 321, 115);
		panel.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblAdiantamento = new JLabel("ADIANTAMENTO");
		lblAdiantamento.setBounds(10, 10, 110, 20);
		panel_3.add(lblAdiantamento);
		
		textField_8 = new JTextField("0,00");
		textField_8.setHorizontalAlignment(SwingConstants.CENTER);
		textField_8.setColumns(10);
		textField_8.setBounds(120, 10, 122, 20);
		panel_3.add(textField_8);
		
		JLabel lblVendaVista_1 = new JLabel("VENDA \u00C0 VISTA");
		lblVendaVista_1.setBounds(10, 35, 110, 20);
		panel_3.add(lblVendaVista_1);
		
		textField_12 = new JTextField("0,00");
		textField_12.setBackground(new Color(255, 250, 205));
		textField_12.setHorizontalAlignment(SwingConstants.CENTER);
		textField_12.setDisabledTextColor(new Color(0, 0, 0));
		textField_12.setForeground(new Color(0, 0, 0));
		textField_12.setEnabled(false);
		textField_12.setColumns(10);
		textField_12.setBounds(120, 35, 122, 20);
		panel_3.add(textField_12);
		
		JLabel lblEntradas = new JLabel("ENTRADAS");
		lblEntradas.setBounds(10, 60, 110, 20);
		panel_3.add(lblEntradas);
		
		textField_14 = new JTextField("0,00");
		textField_14.setBackground(new Color(255, 250, 205));
		textField_14.setHorizontalAlignment(SwingConstants.CENTER);
		textField_14.setDisabledTextColor(new Color(0, 0, 0));
		textField_14.setForeground(new Color(0, 0, 0));
		textField_14.setEnabled(false);
		textField_14.setColumns(10);
		textField_14.setBounds(120, 60, 122, 20);
		panel_3.add(textField_14);
		
		JLabel lblValorReal = new JLabel("VALOR REAL");
		lblValorReal.setHorizontalAlignment(SwingConstants.RIGHT);
		lblValorReal.setBounds(10, 85, 102, 20);
		panel_3.add(lblValorReal);
		
		textField_16 = new JTextField("0,00");
		textField_16.setBackground(new Color(255, 250, 205));
		textField_16.setHorizontalAlignment(SwingConstants.CENTER);
		textField_16.setDisabledTextColor(new Color(0, 0, 0));
		textField_16.setForeground(new Color(0, 0, 0));
		textField_16.setEnabled(false);
		textField_16.setColumns(10);
		textField_16.setBounds(120, 85, 122, 20);
		panel_3.add(textField_16);
		
		JPanel panel_9 = new JPanel();
		panel_9.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_9.setBounds(10, 420, 320, 45);
		panel.add(panel_9);
		panel_9.setLayout(null);
		
		JLabel lblDividaVendedor = new JLabel("DIVIDA VENDEDOR");
		lblDividaVendedor.setBounds(10, 11, 110, 20);
		panel_9.add(lblDividaVendedor);
		
		textField_26 = new JTextField("0,00");
		textField_26.setBackground(new Color(255, 250, 205));
		textField_26.setHorizontalAlignment(SwingConstants.CENTER);
		textField_26.setForeground(new Color(0, 0, 0));
		textField_26.setEnabled(false);
		textField_26.setDisabledTextColor(Color.BLACK);
		textField_26.setColumns(10);
		textField_26.setBounds(120, 11, 122, 20);
		panel_9.add(textField_26);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_4.setBounds(725, 50, 340, 510);
		add(panel_4);
		panel_4.setLayout(null);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_5.setBounds(10, 145, 321, 195);
		panel_4.add(panel_5);
		panel_5.setLayout(null);
		
		JLabel lblGasolina = new JLabel("GASOLINA");
		lblGasolina.setBounds(10, 11, 110, 20);
		panel_5.add(lblGasolina);
		
		JLabel lblDiesel = new JLabel("DIESEL");
		lblDiesel.setBounds(10, 36, 110, 20);
		panel_5.add(lblDiesel);
		
		textField_11 = new JTextField("0,00");
		textField_11.setHorizontalAlignment(SwingConstants.CENTER);
		textField_11.setColumns(10);
		textField_11.setBounds(120, 36, 122, 20);
		panel_5.add(textField_11);
		
		JLabel lblDespCNota = new JLabel("DESP. C/ NOTA");
		lblDespCNota.setBounds(10, 61, 110, 20);
		panel_5.add(lblDespCNota);
		
		textField_13 = new JTextField("0,00");
		textField_13.setHorizontalAlignment(SwingConstants.CENTER);
		textField_13.setColumns(10);
		textField_13.setBounds(120, 61, 122, 20);
		panel_5.add(textField_13);
		
		textField_15 = new JTextField("0,00");
		textField_15.setHorizontalAlignment(SwingConstants.CENTER);
		textField_15.setColumns(10);
		textField_15.setBounds(120, 11, 122, 20);
		panel_5.add(textField_15);
		
		JLabel lblDespSNota = new JLabel("DESP. S/ NOTA");
		lblDespSNota.setBounds(10, 85, 110, 20);
		panel_5.add(lblDespSNota);
		
		JLabel lblMenuteno = new JLabel("MENUTEN\u00C7\u00C3O");
		lblMenuteno.setBounds(10, 110, 110, 20);
		panel_5.add(lblMenuteno);
		
		textField_17 = new JTextField("0,00");
		textField_17.setHorizontalAlignment(SwingConstants.CENTER);
		textField_17.setColumns(10);
		textField_17.setBounds(120, 110, 122, 20);
		panel_5.add(textField_17);
		
		JLabel lblDiarias = new JLabel("DIARIAS");
		lblDiarias.setBounds(10, 135, 110, 20);
		panel_5.add(lblDiarias);
		
		textField_18 = new JTextField("0,00");
		textField_18.setHorizontalAlignment(SwingConstants.CENTER);
		textField_18.setColumns(10);
		textField_18.setBounds(120, 135, 122, 20);
		panel_5.add(textField_18);
		
		textField_19 = new JTextField("0,00");
		textField_19.setHorizontalAlignment(SwingConstants.CENTER);
		textField_19.setColumns(10);
		textField_19.setBounds(120, 85, 122, 20);
		panel_5.add(textField_19);
		
		JLabel lblTotal = new JLabel("TOTAL");
		lblTotal.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTotal.setBounds(10, 160, 60, 20);
		panel_5.add(lblTotal);
		
		textField_20 = new JTextField("0,00");
		textField_20.setBackground(new Color(255, 250, 205));
		textField_20.setHorizontalAlignment(SwingConstants.CENTER);
		textField_20.setEnabled(false);
		textField_20.setDisabledTextColor(new Color(0, 0, 0));
		textField_20.setColumns(10);
		textField_20.setBounds(80, 160, 90, 20);
		panel_5.add(textField_20);
		
		textField_25 = new JTextField("0 %");
		textField_25.setBackground(new Color(255, 250, 205));
		textField_25.setHorizontalAlignment(SwingConstants.CENTER);
		textField_25.setEnabled(false);
		textField_25.setDisabledTextColor(new Color(0, 0, 0));
		textField_25.setColumns(10);
		textField_25.setBounds(180, 160, 62, 20);
		panel_5.add(textField_25);
		
		JPanel panel_6 = new JPanel();
		panel_6.setLayout(null);
		panel_6.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_6.setBounds(10, 350, 321, 115);
		panel_4.add(panel_6);
		
		JLabel lblDespesas = new JLabel("DESPESAS");
		lblDespesas.setBounds(10, 10, 110, 20);
		panel_6.add(lblDespesas);
		
		textField_21 = new JTextField("0,00");
		textField_21.setDisabledTextColor(new Color(0, 0, 0));
		textField_21.setForeground(new Color(0, 0, 0));
		textField_21.setEnabled(false);
		textField_21.setBackground(new Color(255, 250, 205));
		textField_21.setHorizontalAlignment(SwingConstants.CENTER);
		textField_21.setColumns(10);
		textField_21.setBounds(120, 10, 122, 20);
		panel_6.add(textField_21);
		
		JLabel lblCadernoVendedor = new JLabel("VALES CADERNOS");
		lblCadernoVendedor.setBounds(10, 35, 110, 20);
		panel_6.add(lblCadernoVendedor);
		
		textField_22 = new JTextField("0,00");
		textField_22.setForeground(new Color(0, 0, 0));
		textField_22.setEnabled(false);
		textField_22.setBackground(new Color(255, 250, 205));
		textField_22.setHorizontalAlignment(SwingConstants.CENTER);
		textField_22.setDisabledTextColor(new Color(0, 0, 0));
		textField_22.setColumns(10);
		textField_22.setBounds(120, 35, 122, 20);
		panel_6.add(textField_22);
		
		JLabel lblDinhDevolvido = new JLabel("DINH. DEVOLVIDO");
		lblDinhDevolvido.setBounds(10, 60, 110, 20);
		panel_6.add(lblDinhDevolvido);
		
		textField_23 = new JTextField("0,00");
		textField_23.setHorizontalAlignment(SwingConstants.CENTER);
		textField_23.setColumns(10);
		textField_23.setBounds(120, 60, 122, 20);
		panel_6.add(textField_23);
		
		JLabel lblValorApresentado = new JLabel("VALOR APRESENTADO");
		lblValorApresentado.setHorizontalAlignment(SwingConstants.RIGHT);
		lblValorApresentado.setBounds(10, 90, 136, 20);
		panel_6.add(lblValorApresentado);
		
		textField_24 = new JTextField("0,00");
		textField_24.setBackground(new Color(255, 250, 205));
		textField_24.setHorizontalAlignment(SwingConstants.CENTER);
		textField_24.setEnabled(false);
		textField_24.setDisabledTextColor(new Color(0, 0, 0));
		textField_24.setColumns(10);
		textField_24.setBounds(156, 85, 86, 20);
		panel_6.add(textField_24);
		
		JLabel label = new JLabel("DESCRI\u00C7\u00C3O DA PRESTA\u00C7\u00C3O");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label.setBounds(10, 11, 321, 25);
		panel_4.add(label);
		
		JPanel panel_8 = new JPanel();
		panel_8.setLayout(null);
		panel_8.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_8.setBounds(10, 40, 321, 95);
		panel_4.add(panel_8);
		
		JLabel lblDataCobrana = new JLabel("DATA COBRAN\u00C7A");
		lblDataCobrana.setBounds(10, 10, 110, 20);
		panel_8.add(lblDataCobrana);
		
		JDateChooser dateChooser_2 = new JDateChooser((Date) null);
		dateChooser_2.setBounds(120, 10, 122, 20);
		panel_8.add(dateChooser_2);
		
		TextField dateChooser_3 = new TextField();
		dateChooser_3.setBounds(120, 35, 191, 20);
		panel_8.add(dateChooser_3);
		
		JLabel lblCidade = new JLabel("PRIMEIRA CIDADE");
		lblCidade.setBounds(10, 35, 110, 20);
		panel_8.add(lblCidade);
		
		JLabel lblEstado = new JLabel("ESTADO");
		lblEstado.setBounds(10, 65, 110, 20);
		panel_8.add(lblEstado);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(120, 65, 64, 20);
		panel_8.add(comboBox);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_7.setBounds(360, 90, 355, 380);
		add(panel_7);
		panel_7.setLayout(null);
		
		JLabel lblGrafico = new JLabel("GRAFICO");
		lblGrafico.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblGrafico.setBounds(109, 68, 160, 65);
		panel_7.add(lblGrafico);
		
		JButton btnNewButton = new JButton("ALTERAR");
		btnNewButton.setBounds(355, 50, 175, 25);
		add(btnNewButton);
		
		JButton btnSalvar = new JButton("SALVAR");
		btnSalvar.setBounds(540, 50, 175, 25);
		add(btnSalvar);
		
		JPanel panel_10 = new JPanel();
		panel_10.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_10.setBounds(360, 481, 355, 79);
		add(panel_10);
		panel_10.setLayout(null);
		
		JLabel lblVendaPraso_1 = new JLabel("P.E");
		lblVendaPraso_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblVendaPraso_1.setBounds(10, 10, 50, 20);
		panel_10.add(lblVendaPraso_1);
		
		textField_27 = new JTextField("0,00");
		textField_27.setBackground(new Color(255, 250, 205));
		textField_27.setHorizontalAlignment(SwingConstants.CENTER);
		textField_27.setForeground(new Color(255, 250, 205));
		textField_27.setEnabled(false);
		textField_27.setDisabledTextColor(Color.BLACK);
		textField_27.setColumns(10);
		textField_27.setBounds(70, 10, 90, 20);
		panel_10.add(textField_27);
		
		JLabel lblResultado = new JLabel("RESULTADO");
		lblResultado.setHorizontalAlignment(SwingConstants.RIGHT);
		lblResultado.setBounds(20, 40, 135, 20);
		panel_10.add(lblResultado);
		
		textField_28 = new JTextField("0,00");
		textField_28.setBackground(new Color(255, 250, 205));
		textField_28.setHorizontalAlignment(SwingConstants.CENTER);
		textField_28.setForeground(new Color(255, 250, 205));
		textField_28.setEnabled(false);
		textField_28.setDisabledTextColor(Color.BLACK);
		textField_28.setColumns(10);
		textField_28.setBounds(165, 40, 122, 20);
		panel_10.add(textField_28);
		
		textField_29 = new JTextField("0,00");
		textField_29.setBackground(new Color(255, 250, 205));
		textField_29.setHorizontalAlignment(SwingConstants.CENTER);
		textField_29.setForeground(new Color(255, 250, 205));
		textField_29.setEnabled(false);
		textField_29.setDisabledTextColor(Color.BLACK);
		textField_29.setColumns(10);
		textField_29.setBounds(230, 10, 90, 20);
		panel_10.add(textField_29);
		
		JLabel lblMb = new JLabel("M.B");
		lblMb.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMb.setBounds(170, 10, 50, 20);
		panel_10.add(lblMb);

	}
}
