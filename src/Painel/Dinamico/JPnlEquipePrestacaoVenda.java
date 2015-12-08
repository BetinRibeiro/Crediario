package Painel.Dinamico;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.SwingConstants;
import com.toedter.calendar.JDateChooser;

import Bin.Equipe.Equipe;
import Persistence.Dao;

import java.util.Date;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class JPnlEquipePrestacaoVenda extends JPanel implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtDiasViagem;
	private JTextField txtTotalCarrada;
	private JTextField txtVendaPraso;
	private JTextField txtTotalRetorno;
	private JTextField txtDiferenca;
	private JTextField txtPercCarrada;
	private JTextField txtPercPraso;
	private JTextField txtPercRetorno;
	private JTextField txtVendaVista;
	private JTextField txtPercVista;
	private JTextField txtAdiantamento;
	private JTextField txtVendaAVista;
	private JTextField txtEntradas;
	private JTextField txtValorReal;
	private JTextField txtDieasel;
	private JTextField txtDesNota;
	private JTextField txtGasolina;
	private JTextField txtManutena;
	private JTextField txtDiarias;
	private JTextField txtDespSNota;
	private JTextField txtTotalDesp;
	private JTextField txtDespTotal;
	private JTextField txtDinheiroDevovlido;
	private JTextField txtValorPresent;
	private JTextField txtParcDesp;
	private JTextField txtPontEquili;
	private JTextField txtResult;
	private JTextField txtMargBrut;
	private JButton btnAlterar;
	private JButton btnSalvar;
	DecimalFormat df = new DecimalFormat("0.00");
	DecimalFormat dfp = new DecimalFormat("0.0");

	private Equipe equipe;
	private JDateChooser dateSaida;
	private JDateChooser datechegada;
	private JDateChooser dateUltima;
	private JDateChooser dateCobranca;
	private JComboBox<String> boxEstado;
	private JTextField txtValesCaderno;
	private Dao banco = new Dao();
	private JTextField txtCidade;
	private JPanel painelGrafico;
	private JLabel lblDataSaida;
	private JLabel lblDataChegada;

	/**
	 * Create the panel.
	 */
	public JPnlEquipePrestacaoVenda(Equipe equipe) {
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBounds(0, 0, 1075, 570);
		setLayout(null);
		this.equipe = equipe;

		JLabel lblPrestaoDeContas = new JLabel("PRESTA\u00C7\u00C3O DE CONTAS COM O CHEFE DA EQUIPE");
		lblPrestaoDeContas.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrestaoDeContas.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPrestaoDeContas.setBounds(10, 10, 1055, 25);
		add(lblPrestaoDeContas);

		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(10, 40, 340, 510);
		add(panel);
		panel.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(10, 40, 320, 95);
		panel.add(panel_1);
		panel_1.setLayout(null);

		lblDataSaida = new JLabel("DATA SAIDA");
		lblDataSaida.setBounds(10, 10, 110, 20);
		panel_1.add(lblDataSaida);

		dateSaida = new JDateChooser((Date) null);
		dateSaida.setBounds(120, 10, 122, 20);
		panel_1.add(dateSaida);

		datechegada = new JDateChooser((Date) null);
		datechegada.setBounds(120, 35, 122, 20);
		panel_1.add(datechegada);

		lblDataChegada = new JLabel("DATA CHEGADA");
		lblDataChegada.setBounds(10, 35, 110, 20);
		panel_1.add(lblDataChegada);

		JLabel lblDiasViajados = new JLabel("QUANT. DIAS");
		lblDiasViajados.setBounds(10, 65, 110, 20);
		panel_1.add(lblDiasViajados);

		txtDiasViagem = new JTextField("0");
		txtDiasViagem.setBackground(new Color(255, 250, 205));
		txtDiasViagem.setHorizontalAlignment(SwingConstants.CENTER);
		txtDiasViagem.setDisabledTextColor(new Color(0, 0, 0));
		txtDiasViagem.setForeground(new Color(255, 250, 205));
		txtDiasViagem.setEnabled(false);
		txtDiasViagem.setBounds(120, 65, 122, 20);
		panel_1.add(txtDiasViagem);
		txtDiasViagem.setColumns(10);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_2.setBounds(10, 145, 320, 140);
		panel.add(panel_2);
		panel_2.setLayout(null);

		txtTotalCarrada = new JTextField("0,00");
		txtTotalCarrada.setBackground(new Color(255, 250, 205));
		txtTotalCarrada.setHorizontalAlignment(SwingConstants.CENTER);
		txtTotalCarrada.setDisabledTextColor(new Color(0, 0, 0));
		txtTotalCarrada.setForeground(new Color(255, 250, 205));
		txtTotalCarrada.setEnabled(false);
		txtTotalCarrada.setBounds(120, 10, 122, 20);
		panel_2.add(txtTotalCarrada);
		txtTotalCarrada.setColumns(10);

		JLabel lblValorCarrada = new JLabel("TOTAL CARRADAS");
		lblValorCarrada.setBounds(10, 10, 110, 20);
		panel_2.add(lblValorCarrada);

		txtVendaPraso = new JTextField("0,00");
		txtVendaPraso.setBackground(new Color(255, 250, 205));
		txtVendaPraso.setHorizontalAlignment(SwingConstants.CENTER);
		txtVendaPraso.setDisabledTextColor(new Color(0, 0, 0));
		txtVendaPraso.setForeground(new Color(255, 250, 205));
		txtVendaPraso.setEnabled(false);
		txtVendaPraso.setColumns(10);
		txtVendaPraso.setBounds(120, 35, 122, 20);
		panel_2.add(txtVendaPraso);

		JLabel lblVendaPraso = new JLabel("VENDA \u00C0 PRASO");
		lblVendaPraso.setBounds(10, 35, 110, 20);
		panel_2.add(lblVendaPraso);

		txtTotalRetorno = new JTextField("0,00");
		txtTotalRetorno.setBackground(new Color(255, 250, 205));
		txtTotalRetorno.setHorizontalAlignment(SwingConstants.CENTER);
		txtTotalRetorno.setDisabledTextColor(new Color(0, 0, 0));
		txtTotalRetorno.setForeground(new Color(255, 250, 205));
		txtTotalRetorno.setEnabled(false);
		txtTotalRetorno.setColumns(10);
		txtTotalRetorno.setBounds(120, 60, 122, 20);
		panel_2.add(txtTotalRetorno);

		JLabel lblRetorno = new JLabel("RETORNO");
		lblRetorno.setBounds(10, 60, 110, 20);
		panel_2.add(lblRetorno);

		txtDiferenca = new JTextField("0,00");
		txtDiferenca.setBackground(new Color(255, 250, 205));
		txtDiferenca.setHorizontalAlignment(SwingConstants.CENTER);
		txtDiferenca.setDisabledTextColor(new Color(0, 0, 0));
		txtDiferenca.setForeground(new Color(255, 250, 205));
		txtDiferenca.setEnabled(false);
		txtDiferenca.setColumns(10);
		txtDiferenca.setBounds(175, 85, 135, 20);
		panel_2.add(txtDiferenca);

		JLabel lblDiferna = new JLabel("DIFER\u00CAN\u00C7A");
		lblDiferna.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDiferna.setBounds(60, 85, 110, 20);
		panel_2.add(lblDiferna);

		txtPercCarrada = new JTextField("0,00");
		txtPercCarrada.setBackground(new Color(255, 250, 205));
		txtPercCarrada.setHorizontalAlignment(SwingConstants.CENTER);
		txtPercCarrada.setDisabledTextColor(new Color(0, 0, 0));
		txtPercCarrada.setForeground(new Color(255, 250, 205));
		txtPercCarrada.setEnabled(false);
		txtPercCarrada.setColumns(10);
		txtPercCarrada.setBounds(252, 10, 59, 20);
		panel_2.add(txtPercCarrada);

		txtPercPraso = new JTextField("0,00");
		txtPercPraso.setBackground(new Color(255, 250, 205));
		txtPercPraso.setHorizontalAlignment(SwingConstants.CENTER);
		txtPercPraso.setDisabledTextColor(new Color(0, 0, 0));
		txtPercPraso.setForeground(new Color(255, 250, 205));
		txtPercPraso.setEnabled(false);
		txtPercPraso.setColumns(10);
		txtPercPraso.setBounds(252, 35, 59, 20);
		panel_2.add(txtPercPraso);

		txtPercRetorno = new JTextField("0,00");
		txtPercRetorno.setBackground(new Color(255, 250, 205));
		txtPercRetorno.setHorizontalAlignment(SwingConstants.CENTER);
		txtPercRetorno.setDisabledTextColor(new Color(0, 0, 0));
		txtPercRetorno.setForeground(new Color(255, 250, 205));
		txtPercRetorno.setEnabled(false);
		txtPercRetorno.setColumns(10);
		txtPercRetorno.setBounds(252, 60, 59, 20);
		panel_2.add(txtPercRetorno);

		JLabel lblVendaVista = new JLabel("VENDA \u00C0 VISTA");
		lblVendaVista.setBounds(10, 110, 110, 20);
		panel_2.add(lblVendaVista);

		txtVendaVista = new JTextField("0,00");
		txtVendaVista.setBackground(new Color(255, 250, 205));
		txtVendaVista.setHorizontalAlignment(SwingConstants.CENTER);
		txtVendaVista.setDisabledTextColor(new Color(0, 0, 0));
		txtVendaVista.setForeground(new Color(255, 250, 205));
		txtVendaVista.setEnabled(false);
		txtVendaVista.setColumns(10);
		txtVendaVista.setBounds(120, 110, 122, 20);
		panel_2.add(txtVendaVista);

		txtPercVista = new JTextField("0,00");
		txtPercVista.setBackground(new Color(255, 250, 205));
		txtPercVista.setHorizontalAlignment(SwingConstants.CENTER);
		txtPercVista.setDisabledTextColor(new Color(0, 0, 0));
		txtPercVista.setForeground(new Color(255, 250, 205));
		txtPercVista.setEnabled(false);
		txtPercVista.setColumns(10);
		txtPercVista.setBounds(252, 110, 59, 20);
		panel_2.add(txtPercVista);

		JLabel lblDescrioDaPrestao = new JLabel("DESCRI\u00C7\u00C3O DA PRESTA\u00C7\u00C3O");
		lblDescrioDaPrestao.setHorizontalAlignment(SwingConstants.CENTER);
		lblDescrioDaPrestao.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDescrioDaPrestao.setBounds(10, 10, 321, 25);
		panel.add(lblDescrioDaPrestao);

		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_3.setBounds(10, 295, 320, 115);
		panel.add(panel_3);
		panel_3.setLayout(null);

		JLabel lblAdiantamento = new JLabel("ADIANTAMENTO");
		lblAdiantamento.setBounds(10, 10, 110, 20);
		panel_3.add(lblAdiantamento);

		txtAdiantamento = new JTextField("0,00");
		txtAdiantamento.setHorizontalAlignment(SwingConstants.CENTER);
		txtAdiantamento.setColumns(10);
		txtAdiantamento.setBounds(120, 10, 122, 20);
		panel_3.add(txtAdiantamento);

		JLabel lblVendaVista_1 = new JLabel("VENDA \u00C0 VISTA");
		lblVendaVista_1.setBounds(10, 35, 110, 20);
		panel_3.add(lblVendaVista_1);

		txtVendaAVista = new JTextField("0,00");
		txtVendaAVista.setBackground(new Color(255, 250, 205));
		txtVendaAVista.setHorizontalAlignment(SwingConstants.CENTER);
		txtVendaAVista.setDisabledTextColor(new Color(0, 0, 0));
		txtVendaAVista.setForeground(new Color(0, 0, 0));
		txtVendaAVista.setEnabled(false);
		txtVendaAVista.setColumns(10);
		txtVendaAVista.setBounds(120, 35, 122, 20);
		panel_3.add(txtVendaAVista);

		JLabel lblEntradas = new JLabel("ENTRADAS");
		lblEntradas.setBounds(10, 60, 110, 20);
		panel_3.add(lblEntradas);

		txtEntradas = new JTextField("0,00");
		txtEntradas.setBackground(new Color(255, 250, 205));
		txtEntradas.setHorizontalAlignment(SwingConstants.CENTER);
		txtEntradas.setDisabledTextColor(new Color(0, 0, 0));
		txtEntradas.setForeground(new Color(0, 0, 0));
		txtEntradas.setEnabled(false);
		txtEntradas.setColumns(10);
		txtEntradas.setBounds(120, 60, 122, 20);
		panel_3.add(txtEntradas);

		JLabel lblValorReal = new JLabel("VALOR REAL");
		lblValorReal.setHorizontalAlignment(SwingConstants.RIGHT);
		lblValorReal.setBounds(10, 85, 102, 20);
		panel_3.add(lblValorReal);

		txtValorReal = new JTextField("0,00");
		txtValorReal.setBackground(new Color(255, 250, 205));
		txtValorReal.setHorizontalAlignment(SwingConstants.CENTER);
		txtValorReal.setDisabledTextColor(new Color(0, 0, 0));
		txtValorReal.setForeground(new Color(0, 0, 0));
		txtValorReal.setEnabled(false);
		txtValorReal.setColumns(10);
		txtValorReal.setBounds(120, 85, 122, 20);
		panel_3.add(txtValorReal);

		JPanel panel_9 = new JPanel();
		panel_9.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_9.setBounds(10, 420, 320, 45);
		panel.add(panel_9);
		panel_9.setLayout(null);

		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_4.setBounds(725, 40, 340, 510);
		add(panel_4);
		panel_4.setLayout(null);

		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_5.setBounds(10, 175, 321, 195);
		panel_4.add(panel_5);
		panel_5.setLayout(null);

		JLabel lblGasolina = new JLabel("GASOLINA");
		lblGasolina.setBounds(10, 11, 110, 20);
		panel_5.add(lblGasolina);

		JLabel lblDiesel = new JLabel("DIESEL");
		lblDiesel.setBounds(10, 36, 110, 20);
		panel_5.add(lblDiesel);

		txtDieasel = new JTextField("0,00");
		txtDieasel.setHorizontalAlignment(SwingConstants.CENTER);
		txtDieasel.setColumns(10);
		txtDieasel.setBounds(120, 36, 122, 20);
		panel_5.add(txtDieasel);

		JLabel lblDespCNota = new JLabel("DESP. C/ NOTA");
		lblDespCNota.setBounds(10, 61, 110, 20);
		panel_5.add(lblDespCNota);

		txtDesNota = new JTextField("0,00");
		txtDesNota.setHorizontalAlignment(SwingConstants.CENTER);
		txtDesNota.setColumns(10);
		txtDesNota.setBounds(120, 61, 122, 20);
		panel_5.add(txtDesNota);

		txtGasolina = new JTextField("0,00");
		txtGasolina.setHorizontalAlignment(SwingConstants.CENTER);
		txtGasolina.setColumns(10);
		txtGasolina.setBounds(120, 11, 122, 20);
		panel_5.add(txtGasolina);

		JLabel lblDespSNota = new JLabel("DESP. S/ NOTA");
		lblDespSNota.setBounds(10, 85, 110, 20);
		panel_5.add(lblDespSNota);

		JLabel lblMenuteno = new JLabel("MENUTEN\u00C7\u00C3O");
		lblMenuteno.setBounds(10, 110, 110, 20);
		panel_5.add(lblMenuteno);

		txtManutena = new JTextField("0,00");
		txtManutena.setHorizontalAlignment(SwingConstants.CENTER);
		txtManutena.setColumns(10);
		txtManutena.setBounds(120, 110, 122, 20);
		panel_5.add(txtManutena);

		JLabel lblDiarias = new JLabel("DIARIAS");
		lblDiarias.setBounds(10, 135, 110, 20);
		panel_5.add(lblDiarias);

		txtDiarias = new JTextField("0,00");
		txtDiarias.setHorizontalAlignment(SwingConstants.CENTER);
		txtDiarias.setColumns(10);
		txtDiarias.setBounds(120, 135, 122, 20);
		panel_5.add(txtDiarias);

		txtDespSNota = new JTextField("0,00");
		txtDespSNota.setHorizontalAlignment(SwingConstants.CENTER);
		txtDespSNota.setColumns(10);
		txtDespSNota.setBounds(120, 85, 122, 20);
		panel_5.add(txtDespSNota);

		JLabel lblTotal = new JLabel("TOTAL");
		lblTotal.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTotal.setBounds(10, 160, 60, 20);
		panel_5.add(lblTotal);

		txtTotalDesp = new JTextField("0,00");
		txtTotalDesp.setBackground(new Color(255, 250, 205));
		txtTotalDesp.setHorizontalAlignment(SwingConstants.CENTER);
		txtTotalDesp.setEnabled(false);
		txtTotalDesp.setDisabledTextColor(new Color(0, 0, 0));
		txtTotalDesp.setColumns(10);
		txtTotalDesp.setBounds(80, 160, 90, 20);
		panel_5.add(txtTotalDesp);

		txtParcDesp = new JTextField("0 %");
		txtParcDesp.setBackground(new Color(255, 250, 205));
		txtParcDesp.setHorizontalAlignment(SwingConstants.CENTER);
		txtParcDesp.setEnabled(false);
		txtParcDesp.setDisabledTextColor(new Color(0, 0, 0));
		txtParcDesp.setColumns(10);
		txtParcDesp.setBounds(180, 160, 62, 20);
		panel_5.add(txtParcDesp);

		JPanel panel_6 = new JPanel();
		panel_6.setLayout(null);
		panel_6.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_6.setBounds(10, 375, 321, 115);
		panel_4.add(panel_6);

		JLabel lblDespesas = new JLabel("DESPESAS");
		lblDespesas.setBounds(10, 10, 110, 20);
		panel_6.add(lblDespesas);

		txtDespTotal = new JTextField("0,00");
		txtDespTotal.setDisabledTextColor(new Color(0, 0, 0));
		txtDespTotal.setForeground(new Color(0, 0, 0));
		txtDespTotal.setEnabled(false);
		txtDespTotal.setBackground(new Color(255, 250, 205));
		txtDespTotal.setHorizontalAlignment(SwingConstants.CENTER);
		txtDespTotal.setColumns(10);
		txtDespTotal.setBounds(120, 10, 122, 20);
		panel_6.add(txtDespTotal);

		JLabel lblCadernoVendedor = new JLabel("VALES CADERNOS");
		lblCadernoVendedor.setBounds(10, 35, 110, 20);
		panel_6.add(lblCadernoVendedor);

		txtValesCaderno = new JTextField("0,00");
		txtValesCaderno.setForeground(new Color(0, 0, 0));
		txtValesCaderno.setEnabled(false);
		txtValesCaderno.setBackground(new Color(255, 250, 205));
		txtValesCaderno.setHorizontalAlignment(SwingConstants.CENTER);
		txtValesCaderno.setDisabledTextColor(new Color(0, 0, 0));
		txtValesCaderno.setColumns(10);
		txtValesCaderno.setBounds(120, 35, 122, 20);
		panel_6.add(txtValesCaderno);

		JLabel lblDinhDevolvido = new JLabel("DINH. DEVOLVIDO");
		lblDinhDevolvido.setBounds(10, 60, 110, 20);
		panel_6.add(lblDinhDevolvido);

		txtDinheiroDevovlido = new JTextField("0,00");
		txtDinheiroDevovlido.setHorizontalAlignment(SwingConstants.CENTER);
		txtDinheiroDevovlido.setColumns(10);
		txtDinheiroDevovlido.setBounds(120, 60, 122, 20);
		panel_6.add(txtDinheiroDevovlido);

		JLabel lblValorApresentado = new JLabel("VALOR APRESENTADO");
		lblValorApresentado.setHorizontalAlignment(SwingConstants.RIGHT);
		lblValorApresentado.setBounds(10, 90, 136, 20);
		panel_6.add(lblValorApresentado);

		txtValorPresent = new JTextField("0,00");
		txtValorPresent.setBackground(new Color(255, 250, 205));
		txtValorPresent.setHorizontalAlignment(SwingConstants.CENTER);
		txtValorPresent.setEnabled(false);
		txtValorPresent.setDisabledTextColor(new Color(0, 0, 0));
		txtValorPresent.setColumns(10);
		txtValorPresent.setBounds(156, 85, 86, 20);
		panel_6.add(txtValorPresent);

		JLabel label = new JLabel("DESCRI\u00C7\u00C3O DA PRESTA\u00C7\u00C3O");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label.setBounds(10, 11, 321, 25);
		panel_4.add(label);

		JPanel panel_8 = new JPanel();
		panel_8.setLayout(null);
		panel_8.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_8.setBounds(10, 40, 321, 130);
		panel_4.add(panel_8);

		JLabel lblDataCobrana = new JLabel("DATA COBRAN\u00C7A");
		lblDataCobrana.setBounds(10, 10, 110, 20);
		panel_8.add(lblDataCobrana);

		dateCobranca = new JDateChooser((Date) null);
		dateCobranca.setBounds(120, 10, 122, 20);
		panel_8.add(dateCobranca);

		JLabel lblCidade = new JLabel("PRIMEIRA CIDADE");
		lblCidade.setBounds(10, 35, 110, 20);
		panel_8.add(lblCidade);

		JLabel lblEstado = new JLabel("ESTADO");
		lblEstado.setBounds(10, 65, 110, 20);
		panel_8.add(lblEstado);
		String[] uf = { "AC", "AL", "AM", "AP", "BA", "CE", "DF", "ES", "GO", "MA", "MG", "MS", "MT", "PA", "PB", "PE",
				"PI", "PR", "RJ", "RN", "RO", "RR", "RS", "SC", "SE", "SP", "TO" };
		boxEstado = new JComboBox<String>(uf);
		boxEstado.setSelectedIndex(4);
		boxEstado.setEnabled(false);
		boxEstado.setBounds(120, 65, 64, 20);
		panel_8.add(boxEstado);

		JLabel lblUltimoDia = new JLabel("Ultimo Dia");
		lblUltimoDia.setBounds(10, 96, 110, 20);
		panel_8.add(lblUltimoDia);

		dateUltima = new JDateChooser((Date) null);
		dateUltima.setBounds(120, 96, 122, 20);
		panel_8.add(dateUltima);

		txtCidade = new JTextField("0.0");
		txtCidade.setHorizontalAlignment(SwingConstants.CENTER);
		txtCidade.setEnabled(false);
		txtCidade.setColumns(10);
		txtCidade.setBounds(120, 35, 191, 20);
		panel_8.add(txtCidade);

		painelGrafico = new JPanel();
		painelGrafico.setBorder(new LineBorder(new Color(0, 0, 0)));
		painelGrafico.setBounds(360, 80, 355, 380);
		add(painelGrafico);
		painelGrafico.setLayout(null);

		btnAlterar = new JButton("ALTERAR");
		btnAlterar.addActionListener(this);
		btnAlterar.setBounds(355, 40, 175, 25);
		add(btnAlterar);

		btnSalvar = new JButton("SALVAR");
		btnSalvar.addActionListener(this);
		btnSalvar.setEnabled(false);
		btnSalvar.setBounds(540, 40, 175, 25);
		add(btnSalvar);

		JPanel panel_10 = new JPanel();
		panel_10.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_10.setBounds(360, 470, 355, 79);
		add(panel_10);
		panel_10.setLayout(null);

		JLabel lblVendaPraso_1 = new JLabel("P.E");
		lblVendaPraso_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblVendaPraso_1.setBounds(10, 10, 50, 20);
		panel_10.add(lblVendaPraso_1);

		txtPontEquili = new JTextField("0,00");
		txtPontEquili.setBackground(new Color(255, 250, 205));
		txtPontEquili.setHorizontalAlignment(SwingConstants.CENTER);
		txtPontEquili.setForeground(new Color(255, 250, 205));
		txtPontEquili.setEnabled(false);
		txtPontEquili.setDisabledTextColor(Color.BLACK);
		txtPontEquili.setColumns(10);
		txtPontEquili.setBounds(70, 10, 90, 20);
		panel_10.add(txtPontEquili);

		JLabel lblResultado = new JLabel("RESULTADO");
		lblResultado.setHorizontalAlignment(SwingConstants.RIGHT);
		lblResultado.setBounds(20, 40, 135, 20);
		panel_10.add(lblResultado);

		txtResult = new JTextField("0,00");
		txtResult.setBackground(new Color(255, 250, 205));
		txtResult.setHorizontalAlignment(SwingConstants.CENTER);
		txtResult.setForeground(new Color(255, 250, 205));
		txtResult.setEnabled(false);
		txtResult.setDisabledTextColor(Color.BLACK);
		txtResult.setColumns(10);
		txtResult.setBounds(165, 40, 122, 20);
		panel_10.add(txtResult);

		txtMargBrut = new JTextField("0,00");
		txtMargBrut.setBackground(new Color(255, 250, 205));
		txtMargBrut.setHorizontalAlignment(SwingConstants.CENTER);
		txtMargBrut.setForeground(new Color(255, 250, 205));
		txtMargBrut.setEnabled(false);
		txtMargBrut.setDisabledTextColor(Color.BLACK);
		txtMargBrut.setColumns(10);
		txtMargBrut.setBounds(230, 10, 90, 20);
		panel_10.add(txtMargBrut);

		JLabel lblMb = new JLabel("M.B");
		lblMb.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMb.setBounds(170, 10, 50, 20);
		panel_10.add(lblMb);

		atualizar();
	}

	private void atualizar() {

		equipe = (Equipe) banco.buscarPorId(Equipe.class, equipe.getId());

		datechegada.setDate(equipe.getVenda().getDataChegada());
		dateCobranca.setDate(equipe.getVenda().getDiaCobranca());
		dateSaida.setDate(equipe.getVenda().getDataSaida());
		dateUltima.setDate(equipe.getVenda().getUltimoDiaCobranca());

		float totalCarrada = equipe.getVenda().getTotalCarradas();
		txtTotalCarrada.setText(String.valueOf(df.format(totalCarrada)));

		float vendaPraso = equipe.getVenda().getVendaPraso();
		txtVendaPraso.setText(String.valueOf(df.format(vendaPraso)));

		float retorno = equipe.getVenda().getRetorno();
		txtTotalRetorno.setText(String.valueOf(df.format(retorno)));

		float diferenca;
		if (vendaPraso > 0) {
			diferenca = totalCarrada - vendaPraso - retorno;

		} else {
			diferenca = 0;
		}
		txtDiferenca.setText(String.valueOf(df.format(diferenca)));

		float percCarrada = 100;
		txtPercCarrada.setText(String.valueOf(dfp.format(percCarrada)) + "%");

		float percPraso = vendaPraso / totalCarrada * 100;
		txtPercPraso.setText(String.valueOf(dfp.format(percPraso)) + "%");

		float percRetorno = retorno / totalCarrada * 100;
		txtPercRetorno.setText(String.valueOf(dfp.format(percRetorno)) + "%");

		float vendaVista = diferenca / 2;
		txtVendaVista.setText(String.valueOf(df.format(vendaVista)));

		float percVista = diferenca / totalCarrada * 100;
		txtPercVista.setText(String.valueOf(dfp.format(percVista)) + "%");

		float adiantamento = equipe.getVenda().getAdiantamento();
		txtAdiantamento.setText(String.valueOf(df.format(adiantamento)));
		txtVendaAVista.setText(String.valueOf(df.format(vendaVista)));

		float entradas = equipe.getVenda().getEntradas();
		txtEntradas.setText(String.valueOf(df.format(entradas)));

		float valorReal = adiantamento + vendaVista + entradas;
		txtValorReal.setText(String.valueOf(df.format(valorReal)));

		float diesel = equipe.getVenda().getDespesa().getDiesel();
		txtDieasel.setText(String.valueOf(df.format(diesel)));

		float despNota = equipe.getVenda().getDespesa().getDespComNota();
		txtDesNota.setText(String.valueOf(df.format(despNota)));

		float gasolina = equipe.getVenda().getDespesa().getGasolina();
		txtGasolina.setText(String.valueOf(df.format(gasolina)));

		float manutencao = equipe.getVenda().getDespesa().getManutencao();
		txtManutena.setText(String.valueOf(df.format(manutencao)));

		float diarias = equipe.getVenda().getDespesa().getDiarias();
		txtDiarias.setText(String.valueOf(df.format(diarias)));

		float despSnota = equipe.getVenda().getDespesa().getDespSemNota();
		txtDespSNota.setText(String.valueOf(df.format(despSnota)));

		float totalDesp = equipe.getVenda().getDespesa().getTotalDespesa();
		txtTotalDesp.setText(String.valueOf(df.format(totalDesp)));

		float desptotal = totalDesp;
		txtDespTotal.setText(String.valueOf(df.format(desptotal)));

		float dinheDevolvido = equipe.getVenda().getDinheiroDevolvido();
		txtDinheiroDevovlido.setText(String.valueOf(df.format(dinheDevolvido)));

		float valorPresent = totalDesp + equipe.getVenda().getValeCaderno() + equipe.getVenda().getDinheiroDevolvido();
		txtValorPresent.setText(String.valueOf(df.format(valorPresent)));

		float percDesp = totalDesp / vendaPraso * 100;
		txtParcDesp.setText(String.valueOf(df.format(percDesp)) + "%");

		float pontoEqui = equipe.getLucroLiquido();
		txtPontEquili.setText(String.valueOf(df.format(pontoEqui)));
		
		System.out.println(pontoEqui+" ponto de equilibrio ************");

		float resulta = valorReal - valorPresent;
		if (resulta<0) {
			JOptionPane.showMessageDialog(this, "Condição incomun, isso não pode acontecer, sobrou dinheiro!!");
			txtResult.setBackground(Color.RED);
		}
		txtResult.setText(String.valueOf(df.format(resulta)));
		

		float margBruta = (pontoEqui / vendaPraso * 100);
		System.out.println(margBruta+" margem bruta *****************");

		int diasviajados = 0;

		txtMargBrut.setText(String.valueOf(dfp.format(margBruta)) + "%");
		System.out.println(datechegada.getDate() + " - " + datechegada.getDate());
		if (datechegada.getDate() != null && dateSaida.getDate() != null) {
			diasviajados = (int) ((datechegada.getDate().getTime() - dateSaida.getDate().getTime()) / 86400000L);
		}

		txtDiasViagem.setText(String.valueOf(diasviajados));

		// Essa função não se preucupa com a integridade da veracidade dos dados
		// de outra classa como por exmplo vale do caderno
		float valecaderno = equipe.getVenda().getValeCaderno();
		txtValesCaderno.setText(String.valueOf(df.format(valecaderno)));

		txtCidade.setText(equipe.getVenda().getPrimeiraCidade());

		boxEstado.setSelectedItem(equipe.getVenda().getEstado());

		datechegada.setEnabled(false);
		dateCobranca.setEnabled(false);
		dateSaida.setEnabled(false);
		dateUltima.setEnabled(false);

		txtDiasViagem.setEnabled(false);
		txtTotalCarrada.setEnabled(false);
		txtVendaPraso.setEnabled(false);
		txtTotalRetorno.setEnabled(false);
		txtDiferenca.setEnabled(false);
		txtPercCarrada.setEnabled(false);
		txtPercPraso.setEnabled(false);
		txtPercRetorno.setEnabled(false);
		txtVendaVista.setEnabled(false);
		txtPercVista.setEnabled(false);
		txtAdiantamento.setEnabled(false);
		txtVendaAVista.setEnabled(false);
		txtEntradas.setEnabled(false);
		txtValorReal.setEnabled(false);
		txtDieasel.setEnabled(false);
		txtDesNota.setEnabled(false);
		txtGasolina.setEnabled(false);
		txtManutena.setEnabled(false);
		txtDiarias.setEnabled(false);
		txtDespSNota.setEnabled(false);
		txtTotalDesp.setEnabled(false);
		txtDespTotal.setEnabled(false);
		txtDinheiroDevovlido.setEnabled(false);
		txtValorPresent.setEnabled(false);
		txtParcDesp.setEnabled(false);
		txtPontEquili.setEnabled(false);
		txtResult.setEnabled(false);
		txtMargBrut.setEnabled(false);
		txtCidade.setEnabled(false);
		boxEstado.setEnabled(false);

		String[] lista = { String.valueOf(vendaVista), String.valueOf(desptotal), String.valueOf(retorno) };

		painelGrafico.removeAll();
		painelGrafico.repaint();
		grafico a = new grafico(lista, 0, 0, 355, 380);

		painelGrafico.add(a);
		painelGrafico.validate();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String acao = e.getActionCommand();

		switch (acao) {
		case "SALVAR":
			salvar();

			break;
		case "ALTERAR":
			alterar();
			break;
		default:
			break;
		}

	}

	private void salvar() {

		// o adiantamento jamais poderá ser menor que zero caso seja o valor
		// será alterado para zero
		float adiantamento = Float.parseFloat(txtAdiantamento.getText().replace(",", "."));
		if (adiantamento < 0) {
			adiantamento = 0;
		}
		equipe.getVenda().setAdiantamento(adiantamento);

		// a data da saida tem que ser uma das primeiras coisas a ser preenchida
		// caso seja nula marcamos com vermelho indicando que deverá ser
		// alterada, caso esta data seja maior que o dia atual uma mensagem
		// aparacerá avisando que não é permitido
		Date dataSaida = dateSaida.getDate();
		System.out.println(dataSaida + " datasaida");
		if (dataSaida == null) {
			lblDataSaida.setForeground(Color.RED);
			JOptionPane.showMessageDialog(this, "Preencha a data de saida");
		} else {
			int verificando = (int) (((new Date()).getTime() - dataSaida.getTime()) / 86400000L);
			if (verificando < 0) {
				JOptionPane.showMessageDialog(this, "A data da saida é maior que a data atual, isso não pode ocorrer.");
				dataSaida = null;
				lblDataSaida.setForeground(Color.RED);
			}
		}
		equipe.getVenda().setDataSaida(dataSaida);
		int diasDeVenda = 0;

		// a data da chagada não pode ser menor que a data da saida e caso a
		// data da saida seja nula a data de chegada tambem será e os dias
		// viajado será zero
		Date dataChegada = datechegada.getDate();
		if (dataChegada != null && dataSaida != null) {

			diasDeVenda = (int) ((dataChegada.getTime() - dataSaida.getTime()) / 86400000L);
			System.out.println("Dias de venda " + diasDeVenda);
			if (diasDeVenda <= 0) {
				JOptionPane.showMessageDialog(this, "O dia da chegada tem que ser maior que o dia da saia");
				dataChegada = null;
				lblDataChegada.setForeground(Color.RED);
				diasDeVenda = 0;
			}
		} else {
			dataChegada = null;
			diasDeVenda = 0;
		}

		equipe.getVenda().setDataChegada(dataChegada);

		txtDiasViagem.setText(String.valueOf(diasDeVenda));

		// caso alguma despesa seja inserida com o valor negativo colocaremos o
		// valor como zero
		float despCNota = Float.parseFloat(txtDesNota.getText().replace(",", "."));
		if (despCNota < 0) {
			JOptionPane.showMessageDialog(this, "Despesas não podem ter o valor negativo");
			despCNota = despCNota * (-1);
		}
		equipe.getVenda().getDespesa().setDespComNota(despCNota);
		;

		float despSNota = Float.parseFloat(txtDespSNota.getText().replace(",", "."));

		if (despSNota < 0) {
			JOptionPane.showMessageDialog(this, "Despesas não podem ter o valor negativo");
			despSNota = despSNota * (-1);
		}
		equipe.getVenda().getDespesa().setDespSemNota(despSNota);

		float diarias = Float.parseFloat(txtDiarias.getText().replace(",", "."));
		if (diarias < 0) {

			JOptionPane.showMessageDialog(this, "Despesas não podem ter o valor negativo");
			diarias = diarias * (-1);
		}
		equipe.getVenda().getDespesa().setDiarias(diarias);

		float diesel = Float.parseFloat(txtDieasel.getText().replace(",", "."));
		if (diesel < 0) {

			JOptionPane.showMessageDialog(this, "Despesas não podem ter o valor negativo");
			diesel = diesel * (-1);
		}

		equipe.getVenda().getDespesa().setDiesel(diesel);

		float gasolina = Float.parseFloat(txtGasolina.getText().replace(",", "."));
		if (gasolina < 0) {

			JOptionPane.showMessageDialog(this, "Despesas não podem ter o valor negativo");
			gasolina = gasolina * (-1);
		}
		equipe.getVenda().getDespesa().setGasolina(gasolina);

		float manutencao = Float.parseFloat(txtManutena.getText().replace(",", "."));
		if (manutencao < 0) {

			JOptionPane.showMessageDialog(this, "Despesas não podem ter o valor negativo");
			manutencao = manutencao * (-1);
		}
		equipe.getVenda().getDespesa().setManutencao(manutencao);

		Date dataCobranca = dateCobranca.getDate();
		if (dataCobranca != null) {
			if (dataSaida != null) {
				int verificacaoCobranca = (int) ((dataCobranca.getTime() - dataSaida.getTime()) / 86400000L);
				if (verificacaoCobranca < 0) {
					JOptionPane.showMessageDialog(this,
							"A data da cobrança não pode ser menor que a data da saida de venda");
					dataCobranca = null;
				}
			} else {
				JOptionPane.showMessageDialog(this, "Data da saida não foi preenchida");
				dataCobranca = null;
			}

		}
		equipe.getVenda().setDiaCobranca(dataCobranca);

		float dinheDevolvido = Float.parseFloat(txtDinheiroDevovlido.getText().replace(",", "."));
		if (dinheDevolvido < 0) {

			JOptionPane.showMessageDialog(this, "Dinheiro devolvido não podem ter o valor negativo");
			dinheDevolvido = dinheDevolvido * (-1);
		}
		equipe.getVenda().setDinheiroDevolvido(dinheDevolvido);

		equipe.getVenda().setEntradas(Float.parseFloat(txtEntradas.getText().replace(",", ".")));

		equipe.getVenda().setEstado(String.valueOf(boxEstado.getSelectedItem()));

		equipe.getVenda().setPrimeiraCidade(txtCidade.getText().toUpperCase());
		;

		equipe.getVenda().setRetorno(Float.parseFloat(txtTotalRetorno.getText().replace(",", ".")));
		;

		equipe.getVenda().setTotalCarradas(Float.parseFloat(txtTotalCarrada.getText().replace(",", ".")));
		;

		Date dataUltima = dateUltima.getDate();
		if (dataUltima != null) {
			if (dataCobranca != null) {
				int verificacaoultima = (int) ((dataUltima.getTime() - dataCobranca.getTime()) / 86400000L);
				if (verificacaoultima < 0) {
					JOptionPane.showMessageDialog(this,
							"A ultima data da cobrança não pode ser menor que a data da cobranca de venda");
					dataUltima = null;
				}
			} else {
				JOptionPane.showMessageDialog(this, "Data da cobranca não foi preenchida");
				dataUltima = null;
			}

		}

		equipe.getVenda().setUltimoDiaCobranca(dataUltima);
		;

		equipe.getVenda().setValeCaderno(Float.parseFloat(txtValesCaderno.getText().replace(",", ".")));
		;

		float vendaPraso = Float.parseFloat(txtVendaPraso.getText().replace(",", "."));

		equipe.getVenda().setVendaPraso(vendaPraso);
		;

		float vendaVista = Float.parseFloat(txtVendaAVista.getText().replace(",", "."));
		if (vendaPraso <= 0) {
			vendaVista = 0;
		}
		equipe.getVenda().setVendaVista(vendaVista);

		equipe.getVenda().setPrimeiraCidade(txtCidade.getText().toUpperCase());

		float lucroBruto = vendaVista + vendaPraso + equipe.getTotalreceitaExtra() - equipe.getCustoCarradas()
				+ equipe.getCustoRetornos() - equipe.getComissaoVendedores()
				- equipe.getChefe().getComissaoVenda(vendaPraso)
				- equipe.getCobranca().getCobrador().getComissao(equipe.getCobranca().getRecebidoTotal());
		equipe.setLucroBruto(lucroBruto);

		float lucroLiquido = lucroBruto - equipe.getTotalDespExtra() - equipe.getTotalDespLocal()
				- equipe.getVenda().getDespesa().getTotalDespesa()
				- equipe.getCobranca().getDespesa().getTotalDespesa();
		
		equipe.setLucroLiquido(lucroLiquido);
		
		

		banco.salvarOuAtualizarObjeto(equipe.getVenda());
		banco.salvarOuAtualizarObjeto(equipe);

		JOptionPane.showMessageDialog(this, "Salvo com sucesso!");
		atualizar();
		btnSalvar.setEnabled(false);
		btnAlterar.setEnabled(true);

	}

	private void alterar() {
		datechegada.setEnabled(true);
		dateCobranca.setEnabled(true);
		dateSaida.setEnabled(true);
		dateUltima.setEnabled(true);
		boxEstado.setEnabled(true);

		txtAdiantamento.setEnabled(true);
		txtDieasel.setEnabled(true);
		txtDesNota.setEnabled(true);
		txtGasolina.setEnabled(true);
		txtManutena.setEnabled(true);
		txtDiarias.setEnabled(true);
		txtDespSNota.setEnabled(true);
		txtDinheiroDevovlido.setEnabled(true);
		btnSalvar.setEnabled(true);
		btnAlterar.setEnabled(false);
		txtCidade.setEnabled(true);

	}
}
