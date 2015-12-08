package Painel.Dinamico;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;


import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;
import com.toedter.calendar.JDateChooser;

import Bin.Equipe.Equipe;
import Persistence.Dao;

import java.util.Date;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionEvent;

public class JPnlEquipePrestacaoCobranca extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtQuantDias;
	private JTextField txtCobradorNome;
	private JTextField txtValorDiaria;
	private JTextField txtRecebido;
	private JTextField txtDevolvido;
	private JTextField txtPerdido;
	private JTextField txtPercCobrado;
	private JTextField txtPercDevolvido;
	private JTextField txtPercPerdido;
	private JTextField txtTotalVenda;
	private JTextField txtAdiantamento;
	private JTextField txtCobrado;
	private JTextField txtValorReal;
	private JTextField txtPromissoria;
	private JTextField txtDiferenca;
	private JTextField txtTotalDepositos;
	private JTextField txtDespesasTotal;
	private JTextField txtValorPresente;
	private JTextField txtDeespcomNota;
	private JTextField txtDeespSemNota;
	private JTextField txtManutencao;
	private JTextField txtGasolina;
	private JTextField txtDiarias;
	private JTextField txtTotalDesp;
	private JTextField txtPercDesp;
	private JTextField txtDinheDevolvido;
	private JTextField txtComissaoValor;
	private JTextField txtSaldo;
	private JTextField txtPercentualComissaoCobr;
	private Equipe equipe;
	private JDateChooser dataSaida;
	private JDateChooser dataChegada;
	private JTextField txtEntradas;
	private JButton btnAlterar;
	private JButton btnSalvar;
	private Dao banco= new Dao();

	/**
	 * Create the panel.
	 */
	public JPnlEquipePrestacaoCobranca(Equipe equipe) {
		this.equipe = equipe;
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBounds(0, 0, 1075, 570);
		setLayout(null);

		JLabel label = new JLabel("DEPOSITOS DA COBRAN\u00C7A");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label.setBounds(10, 11, 1055, 25);
		add(label);

		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(10, 40, 340, 513);
		add(panel);
		panel.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(10, 10, 320, 140);
		panel.add(panel_1);
		panel_1.setLayout(null);

		dataSaida = new JDateChooser((Date) null);
		dataSaida.setBounds(120, 35, 122, 20);
		panel_1.add(dataSaida);

		JLabel lblDataSaida = new JLabel("DATA SAIDA");
		lblDataSaida.setBounds(10, 35, 110, 20);
		panel_1.add(lblDataSaida);

		dataChegada = new JDateChooser((Date) null);
		dataChegada.setBounds(120, 60, 122, 20);
		panel_1.add(dataChegada);

		JLabel lblDataChegada = new JLabel("DATA CHEGADA");
		lblDataChegada.setBounds(10, 60, 110, 20);
		panel_1.add(lblDataChegada);

		JLabel label_3 = new JLabel("QUANT. DIAS");
		label_3.setBounds(10, 85, 110, 20);
		panel_1.add(label_3);

		txtQuantDias = new JTextField("0");
		txtQuantDias.setHorizontalAlignment(SwingConstants.CENTER);
		txtQuantDias.setForeground(new Color(255, 250, 205));
		txtQuantDias.setEnabled(false);
		txtQuantDias.setDisabledTextColor(Color.BLACK);
		txtQuantDias.setColumns(10);
		txtQuantDias.setBackground(new Color(255, 250, 205));
		txtQuantDias.setBounds(120, 85, 122, 20);
		panel_1.add(txtQuantDias);

		txtCobradorNome = new JTextField("0");
		txtCobradorNome.setHorizontalAlignment(SwingConstants.CENTER);
		txtCobradorNome.setForeground(new Color(255, 250, 205));
		txtCobradorNome.setEnabled(false);
		txtCobradorNome.setDisabledTextColor(Color.BLACK);
		txtCobradorNome.setColumns(10);
		txtCobradorNome.setBackground(new Color(255, 250, 205));
		txtCobradorNome.setBounds(10, 10, 232, 20);
		panel_1.add(txtCobradorNome);

		JLabel lblValorDiaria = new JLabel("VALOR DIARIA");
		lblValorDiaria.setBounds(10, 110, 110, 20);
		panel_1.add(lblValorDiaria);

		txtValorDiaria = new JTextField("0");
		txtValorDiaria.setHorizontalAlignment(SwingConstants.CENTER);
		txtValorDiaria.setForeground(new Color(255, 250, 205));
		txtValorDiaria.setEnabled(false);
		txtValorDiaria.setDisabledTextColor(Color.BLACK);
		txtValorDiaria.setColumns(10);
		txtValorDiaria.setBackground(Color.WHITE);
		txtValorDiaria.setBounds(120, 110, 122, 20);
		panel_1.add(txtValorDiaria);

		JButton btnBuscar = new JButton("");
		btnBuscar.setIcon(new ImageIcon(JPnlEquipePrestacaoCobranca.class.getResource("/Imagens/001.png")));
		btnBuscar.setFont(new Font("Tahoma", Font.PLAIN, 8));
		btnBuscar.setBounds(247, 9, 63, 46);
		panel_1.add(btnBuscar);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_2.setBounds(10, 285, 320, 121);
		panel.add(panel_2);
		panel_2.setLayout(null);

		JLabel lblAdiantamento = new JLabel("ADIANTAMENTO");
		lblAdiantamento.setBounds(10, 11, 110, 20);
		panel_2.add(lblAdiantamento);

		txtAdiantamento = new JTextField("0,00");
		txtAdiantamento.setHorizontalAlignment(SwingConstants.CENTER);
		txtAdiantamento.setForeground(new Color(255, 250, 205));
		txtAdiantamento.setEnabled(false);
		txtAdiantamento.setDisabledTextColor(Color.BLACK);
		txtAdiantamento.setColumns(10);
		txtAdiantamento.setBackground(Color.WHITE);
		txtAdiantamento.setBounds(120, 11, 122, 20);
		panel_2.add(txtAdiantamento);

		txtCobrado = new JTextField("0,00");
		txtCobrado.setHorizontalAlignment(SwingConstants.CENTER);
		txtCobrado.setForeground(new Color(255, 250, 205));
		txtCobrado.setEnabled(false);
		txtCobrado.setDisabledTextColor(Color.BLACK);
		txtCobrado.setColumns(10);
		txtCobrado.setBackground(new Color(255, 250, 205));
		txtCobrado.setBounds(120, 36, 122, 20);
		panel_2.add(txtCobrado);

		JLabel label_2 = new JLabel("COBRADO");
		label_2.setBounds(10, 36, 110, 20);
		panel_2.add(label_2);

		JLabel lblDinheiroReal = new JLabel("VALOR REAL");
		lblDinheiroReal.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDinheiroReal.setBounds(10, 85, 110, 20);
		panel_2.add(lblDinheiroReal);

		txtValorReal = new JTextField("0,00");
		txtValorReal.setHorizontalAlignment(SwingConstants.CENTER);
		txtValorReal.setForeground(new Color(255, 250, 205));
		txtValorReal.setEnabled(false);
		txtValorReal.setDisabledTextColor(Color.BLACK);
		txtValorReal.setColumns(10);
		txtValorReal.setBackground(new Color(255, 250, 205));
		txtValorReal.setBounds(120, 85, 122, 20);
		panel_2.add(txtValorReal);

		txtEntradas = new JTextField("0,00");
		txtEntradas.setHorizontalAlignment(SwingConstants.CENTER);
		txtEntradas.setForeground(new Color(255, 250, 205));
		txtEntradas.setEnabled(false);
		txtEntradas.setDisabledTextColor(Color.BLACK);
		txtEntradas.setColumns(10);
		txtEntradas.setBackground(new Color(255, 250, 205));
		txtEntradas.setBounds(120, 60, 122, 20);
		panel_2.add(txtEntradas);

		JLabel lblEntradas = new JLabel("ENTRADAS");
		lblEntradas.setBounds(10, 60, 110, 20);
		panel_2.add(lblEntradas);

		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_3.setBounds(10, 160, 320, 115);
		panel.add(panel_3);

		txtRecebido = new JTextField("0,00");
		txtRecebido.setHorizontalAlignment(SwingConstants.CENTER);
		txtRecebido.setForeground(new Color(255, 250, 205));
		txtRecebido.setEnabled(false);
		txtRecebido.setDisabledTextColor(Color.BLACK);
		txtRecebido.setColumns(10);
		txtRecebido.setBackground(new Color(255, 250, 205));
		txtRecebido.setBounds(120, 35, 122, 20);
		panel_3.add(txtRecebido);

		JLabel lblCobrado = new JLabel("COBRADO");
		lblCobrado.setBounds(10, 35, 110, 20);
		panel_3.add(lblCobrado);

		txtDevolvido = new JTextField("0,00");
		txtDevolvido.setHorizontalAlignment(SwingConstants.CENTER);
		txtDevolvido.setForeground(new Color(255, 250, 205));
		txtDevolvido.setEnabled(false);
		txtDevolvido.setDisabledTextColor(Color.BLACK);
		txtDevolvido.setColumns(10);
		txtDevolvido.setBackground(new Color(255, 250, 205));
		txtDevolvido.setBounds(120, 60, 122, 20);
		panel_3.add(txtDevolvido);

		JLabel lblDevolvido = new JLabel("DEVOLVIDO");
		lblDevolvido.setBounds(10, 60, 110, 20);
		panel_3.add(lblDevolvido);

		txtPerdido = new JTextField("0,00");
		txtPerdido.setHorizontalAlignment(SwingConstants.CENTER);
		txtPerdido.setForeground(new Color(255, 250, 205));
		txtPerdido.setEnabled(false);
		txtPerdido.setDisabledTextColor(Color.BLACK);
		txtPerdido.setColumns(10);
		txtPerdido.setBackground(new Color(255, 250, 205));
		txtPerdido.setBounds(120, 85, 122, 20);
		panel_3.add(txtPerdido);

		JLabel lblPerdido = new JLabel("PERDIDO");
		lblPerdido.setBounds(10, 85, 110, 20);
		panel_3.add(lblPerdido);

		txtPercCobrado = new JTextField("0,00");
		txtPercCobrado.setHorizontalAlignment(SwingConstants.CENTER);
		txtPercCobrado.setForeground(new Color(255, 250, 205));
		txtPercCobrado.setEnabled(false);
		txtPercCobrado.setDisabledTextColor(Color.BLACK);
		txtPercCobrado.setColumns(10);
		txtPercCobrado.setBackground(new Color(255, 250, 205));
		txtPercCobrado.setBounds(252, 35, 59, 20);
		panel_3.add(txtPercCobrado);

		txtPercDevolvido = new JTextField("0,00");
		txtPercDevolvido.setHorizontalAlignment(SwingConstants.CENTER);
		txtPercDevolvido.setForeground(new Color(255, 250, 205));
		txtPercDevolvido.setEnabled(false);
		txtPercDevolvido.setDisabledTextColor(Color.BLACK);
		txtPercDevolvido.setColumns(10);
		txtPercDevolvido.setBackground(new Color(255, 250, 205));
		txtPercDevolvido.setBounds(252, 60, 59, 20);
		panel_3.add(txtPercDevolvido);

		txtPercPerdido = new JTextField("0,00");
		txtPercPerdido.setHorizontalAlignment(SwingConstants.CENTER);
		txtPercPerdido.setForeground(new Color(255, 250, 205));
		txtPercPerdido.setEnabled(false);
		txtPercPerdido.setDisabledTextColor(Color.BLACK);
		txtPercPerdido.setColumns(10);
		txtPercPerdido.setBackground(new Color(255, 250, 205));
		txtPercPerdido.setBounds(252, 85, 59, 20);
		panel_3.add(txtPercPerdido);

		JLabel lblTotalVenda = new JLabel("TOTAL VENDA");
		lblTotalVenda.setBounds(10, 10, 110, 20);
		panel_3.add(lblTotalVenda);

		txtTotalVenda = new JTextField("0,00");
		txtTotalVenda.setHorizontalAlignment(SwingConstants.CENTER);
		txtTotalVenda.setForeground(new Color(255, 250, 205));
		txtTotalVenda.setEnabled(false);
		txtTotalVenda.setDisabledTextColor(Color.BLACK);
		txtTotalVenda.setColumns(10);
		txtTotalVenda.setBackground(new Color(255, 250, 205));
		txtTotalVenda.setBounds(120, 10, 122, 20);
		panel_3.add(txtTotalVenda);

		JTextField txtPercVenda = new JTextField("0,00");
		txtPercVenda.setHorizontalAlignment(SwingConstants.CENTER);
		txtPercVenda.setForeground(new Color(255, 250, 205));
		txtPercVenda.setEnabled(false);
		txtPercVenda.setDisabledTextColor(Color.BLACK);
		txtPercVenda.setColumns(10);
		txtPercVenda.setBackground(new Color(255, 250, 205));
		txtPercVenda.setBounds(252, 10, 59, 20);
		panel_3.add(txtPercVenda);

		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_4.setBounds(10, 445, 320, 57);
		panel.add(panel_4);

		JPanel panel_5 = new JPanel();
		panel_5.setLayout(null);
		panel_5.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_5.setBounds(725, 40, 340, 513);
		add(panel_5);

		JPanel panel_6 = new JPanel();
		panel_6.setLayout(null);
		panel_6.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_6.setBounds(10, 10, 320, 120);
		panel_5.add(panel_6);

		JLabel lblComisso = new JLabel("COMISS\u00C3O");
		lblComisso.setBounds(10, 10, 110, 20);
		panel_6.add(lblComisso);

		JLabel lblPromissoria = new JLabel("PROMISSORIA");
		lblPromissoria.setBounds(10, 35, 110, 20);
		panel_6.add(lblPromissoria);

		txtPromissoria = new JTextField("0");
		txtPromissoria.setHorizontalAlignment(SwingConstants.CENTER);
		txtPromissoria.setForeground(new Color(255, 250, 205));
		txtPromissoria.setEnabled(false);
		txtPromissoria.setDisabledTextColor(Color.BLACK);
		txtPromissoria.setColumns(10);
		txtPromissoria.setBackground(new Color(255, 250, 205));
		txtPromissoria.setBounds(120, 35, 122, 20);
		panel_6.add(txtPromissoria);

		JLabel lblDiferna = new JLabel("DIFER\u00CAN\u00C7A");
		lblDiferna.setBounds(10, 60, 110, 20);
		panel_6.add(lblDiferna);

		txtDiferenca = new JTextField("0");
		txtDiferenca.setHorizontalAlignment(SwingConstants.CENTER);
		txtDiferenca.setForeground(new Color(255, 250, 205));
		txtDiferenca.setEnabled(false);
		txtDiferenca.setDisabledTextColor(Color.BLACK);
		txtDiferenca.setColumns(10);
		txtDiferenca.setBackground(new Color(255, 250, 205));
		txtDiferenca.setBounds(120, 60, 122, 20);
		panel_6.add(txtDiferenca);

		txtComissaoValor = new JTextField("0");
		txtComissaoValor.setHorizontalAlignment(SwingConstants.CENTER);
		txtComissaoValor.setForeground(new Color(255, 250, 205));
		txtComissaoValor.setEnabled(false);
		txtComissaoValor.setDisabledTextColor(Color.BLACK);
		txtComissaoValor.setColumns(10);
		txtComissaoValor.setBackground(new Color(255, 250, 205));
		txtComissaoValor.setBounds(120, 10, 122, 20);
		panel_6.add(txtComissaoValor);

		JLabel lblSaldo = new JLabel("SALDO");
		lblSaldo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSaldo.setBounds(10, 85, 110, 20);
		panel_6.add(lblSaldo);

		txtSaldo = new JTextField("0");
		txtSaldo.setHorizontalAlignment(SwingConstants.CENTER);
		txtSaldo.setForeground(new Color(255, 250, 205));
		txtSaldo.setEnabled(false);
		txtSaldo.setDisabledTextColor(Color.BLACK);
		txtSaldo.setColumns(10);
		txtSaldo.setBackground(new Color(255, 250, 205));
		txtSaldo.setBounds(120, 85, 122, 20);
		panel_6.add(txtSaldo);

		txtPercentualComissaoCobr = new JTextField("0,00");
		txtPercentualComissaoCobr.setHorizontalAlignment(SwingConstants.CENTER);
		txtPercentualComissaoCobr.setForeground(Color.BLACK);
		txtPercentualComissaoCobr.setDisabledTextColor(Color.BLACK);
		txtPercentualComissaoCobr.setColumns(10);
		txtPercentualComissaoCobr.setBackground(new Color(255, 250, 205));
		txtPercentualComissaoCobr.setBounds(252, 10, 59, 20);
		panel_6.add(txtPercentualComissaoCobr);

		JPanel panel_7 = new JPanel();
		panel_7.setLayout(null);
		panel_7.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_7.setBounds(10, 325, 320, 112);
		panel_5.add(panel_7);

		JLabel lblDeposito = new JLabel("DEPOSITOS");
		lblDeposito.setBounds(10, 11, 110, 20);
		panel_7.add(lblDeposito);

		txtTotalDepositos = new JTextField("0,00");
		txtTotalDepositos.setHorizontalAlignment(SwingConstants.CENTER);
		txtTotalDepositos.setForeground(new Color(255, 250, 205));
		txtTotalDepositos.setEnabled(false);
		txtTotalDepositos.setDisabledTextColor(Color.BLACK);
		txtTotalDepositos.setColumns(10);
		txtTotalDepositos.setBackground(new Color(255, 250, 205));
		txtTotalDepositos.setBounds(120, 11, 122, 20);
		panel_7.add(txtTotalDepositos);

		txtDespesasTotal = new JTextField("0,00");
		txtDespesasTotal.setHorizontalAlignment(SwingConstants.CENTER);
		txtDespesasTotal.setForeground(new Color(255, 250, 205));
		txtDespesasTotal.setEnabled(false);
		txtDespesasTotal.setDisabledTextColor(Color.BLACK);
		txtDespesasTotal.setColumns(10);
		txtDespesasTotal.setBackground(new Color(255, 250, 205));
		txtDespesasTotal.setBounds(120, 36, 122, 20);
		panel_7.add(txtDespesasTotal);

		JLabel lblDespesa = new JLabel("DESPESAS");
		lblDespesa.setBounds(10, 36, 110, 20);
		panel_7.add(lblDespesa);

		JLabel lblDinhApresentado = new JLabel("VALOR APRESENTADO");
		lblDinhApresentado.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDinhApresentado.setBounds(30, 85, 110, 20);
		panel_7.add(lblDinhApresentado);

		txtValorPresente = new JTextField("0,00");
		txtValorPresente.setHorizontalAlignment(SwingConstants.CENTER);
		txtValorPresente.setForeground(new Color(255, 250, 205));
		txtValorPresente.setEnabled(false);
		txtValorPresente.setDisabledTextColor(Color.BLACK);
		txtValorPresente.setColumns(10);
		txtValorPresente.setBackground(new Color(255, 250, 205));
		txtValorPresente.setBounds(141, 85, 101, 20);
		panel_7.add(txtValorPresente);

		JLabel lblDevolvido_1 = new JLabel("DEVOLVIDO");
		lblDevolvido_1.setBounds(10, 62, 110, 20);
		panel_7.add(lblDevolvido_1);

		txtDinheDevolvido = new JTextField("0,00");
		txtDinheDevolvido.setHorizontalAlignment(SwingConstants.CENTER);
		txtDinheDevolvido.setForeground(Color.BLACK);
		txtDinheDevolvido.setEnabled(false);
		txtDinheDevolvido.setDisabledTextColor(Color.BLACK);
		txtDinheDevolvido.setColumns(10);
		txtDinheDevolvido.setBackground(Color.WHITE);
		txtDinheDevolvido.setBounds(120, 60, 122, 20);
		panel_7.add(txtDinheDevolvido);

		JPanel panel_8 = new JPanel();
		panel_8.setLayout(null);
		panel_8.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_8.setBounds(10, 140, 320, 179);
		panel_5.add(panel_8);

		txtDeespcomNota = new JTextField("0,00");
		txtDeespcomNota.setHorizontalAlignment(SwingConstants.CENTER);
		txtDeespcomNota.setForeground(Color.BLACK);
		txtDeespcomNota.setEnabled(false);
		txtDeespcomNota.setDisabledTextColor(Color.BLACK);
		txtDeespcomNota.setColumns(10);
		txtDeespcomNota.setBackground(Color.WHITE);
		txtDeespcomNota.setBounds(120, 35, 122, 20);
		panel_8.add(txtDeespcomNota);

		JLabel lblCNota = new JLabel("DESP. C/ NOTA");
		lblCNota.setBounds(10, 35, 110, 20);
		panel_8.add(lblCNota);

		txtDeespSemNota = new JTextField("0,00");
		txtDeespSemNota.setHorizontalAlignment(SwingConstants.CENTER);
		txtDeespSemNota.setForeground(Color.BLACK);
		txtDeespSemNota.setEnabled(false);
		txtDeespSemNota.setDisabledTextColor(Color.BLACK);
		txtDeespSemNota.setColumns(10);
		txtDeespSemNota.setBackground(Color.WHITE);
		txtDeespSemNota.setBounds(120, 60, 122, 20);
		panel_8.add(txtDeespSemNota);

		JLabel lblDespSNota = new JLabel("DESP. S/ NOTA");
		lblDespSNota.setBounds(10, 60, 110, 20);
		panel_8.add(lblDespSNota);

		txtManutencao = new JTextField("0,00");
		txtManutencao.setHorizontalAlignment(SwingConstants.CENTER);
		txtManutencao.setForeground(Color.BLACK);
		txtManutencao.setEnabled(false);
		txtManutencao.setDisabledTextColor(Color.BLACK);
		txtManutencao.setColumns(10);
		txtManutencao.setBackground(Color.WHITE);
		txtManutencao.setBounds(120, 85, 122, 20);
		panel_8.add(txtManutencao);

		JLabel lblManuteno = new JLabel("MANUTEN\u00C7\u00C3O");
		lblManuteno.setBounds(10, 85, 110, 20);
		panel_8.add(lblManuteno);

		JLabel lblGasolina = new JLabel("GASOLINA");
		lblGasolina.setBounds(10, 10, 110, 20);
		panel_8.add(lblGasolina);

		txtGasolina = new JTextField("0,00");
		txtGasolina.setHorizontalAlignment(SwingConstants.CENTER);
		txtGasolina.setForeground(Color.BLACK);
		txtGasolina.setEnabled(false);
		txtGasolina.setDisabledTextColor(Color.BLACK);
		txtGasolina.setColumns(10);
		txtGasolina.setBackground(Color.WHITE);
		txtGasolina.setBounds(120, 10, 122, 20);
		panel_8.add(txtGasolina);

		JLabel label_14 = new JLabel("PERDIDO");
		label_14.setHorizontalAlignment(SwingConstants.RIGHT);
		label_14.setBounds(10, 135, 110, 20);
		panel_8.add(label_14);

		JLabel lblDiarias = new JLabel("DIARIAS");
		lblDiarias.setBounds(10, 110, 110, 20);
		panel_8.add(lblDiarias);

		txtDiarias = new JTextField("0,00");
		txtDiarias.setHorizontalAlignment(SwingConstants.CENTER);
		txtDiarias.setForeground(Color.BLACK);
		txtDiarias.setEnabled(false);
		txtDiarias.setDisabledTextColor(Color.BLACK);
		txtDiarias.setColumns(10);
		txtDiarias.setBackground(Color.WHITE);
		txtDiarias.setBounds(120, 110, 122, 20);
		panel_8.add(txtDiarias);

		txtTotalDesp = new JTextField("0,00");
		txtTotalDesp.setHorizontalAlignment(SwingConstants.CENTER);
		txtTotalDesp.setForeground(new Color(255, 250, 205));
		txtTotalDesp.setEnabled(false);
		txtTotalDesp.setDisabledTextColor(Color.BLACK);
		txtTotalDesp.setColumns(10);
		txtTotalDesp.setBackground(new Color(255, 250, 205));
		txtTotalDesp.setBounds(120, 135, 122, 20);
		panel_8.add(txtTotalDesp);

		txtPercDesp = new JTextField("0,00");
		txtPercDesp.setHorizontalAlignment(SwingConstants.CENTER);
		txtPercDesp.setForeground(new Color(255, 250, 205));
		txtPercDesp.setEnabled(false);
		txtPercDesp.setDisabledTextColor(Color.BLACK);
		txtPercDesp.setColumns(10);
		txtPercDesp.setBackground(new Color(255, 250, 205));
		txtPercDesp.setBounds(250, 135, 59, 20);
		panel_8.add(txtPercDesp);

		JPanel panel_9 = new JPanel();
		panel_9.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_9.setBounds(10, 448, 320, 54);
		panel_5.add(panel_9);

		JPanel panel_10 = new JPanel();
		panel_10.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_10.setBounds(360, 72, 358, 319);
		add(panel_10);
		panel_10.setLayout(null);

		JLabel lblGrafico = new JLabel("GRAFICO");
		lblGrafico.setFont(new Font("Tahoma", Font.PLAIN, 47));
		lblGrafico.setBounds(83, 129, 241, 62);
		panel_10.add(lblGrafico);

		btnAlterar = new JButton("ALTERAR");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				alterar(true);
			}

		});
		btnAlterar.setBounds(360, 40, 175, 25);
		add(btnAlterar);

		btnSalvar = new JButton("SALVAR");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				salvar();
			}

		});
		btnSalvar.setEnabled(false);
		btnSalvar.setBounds(545, 40, 175, 25);
		add(btnSalvar);
		atualizar();
	}

	private void alterar(Boolean a) {
		txtValorDiaria.setEnabled(a);
		txtAdiantamento.setEnabled(a);
		txtDeespcomNota.setEnabled(a);
		txtDeespSemNota.setEnabled(a);
		txtManutencao.setEnabled(a);
		txtGasolina.setEnabled(a);
		txtDiarias.setEnabled(a);
		txtDinheDevolvido.setEnabled(a);
		dataSaida.setEnabled(a);
		dataChegada.setEnabled(a);
		btnAlterar.setEnabled(!a);
		btnSalvar.setEnabled(a);

	}

	private void salvar() {
		equipe.getCobranca().setDataSaida(dataSaida.getDate());

		equipe.getCobranca().setDataChegada(dataChegada.getDate());
		equipe.getCobranca().setValorDiaria(Float.parseFloat(txtValorDiaria.getText().replace(",", ".")));

		equipe.getCobranca().setDinheiroDevolvido(Float.parseFloat(txtValorDiaria.getText().replace(",", ".")));

		equipe.getCobranca().getDespesa().setDespComNota(Float.parseFloat(txtDeespcomNota.getText().replace(",", ".")));

		equipe.getCobranca().getDespesa().setDespSemNota(Float.parseFloat(txtDeespSemNota.getText().replace(",", ".")));

		equipe.getCobranca().getDespesa().setDiarias(Float.parseFloat(txtDiarias.getText().replace(",", ".")));

		equipe.getCobranca().getDespesa().setGasolina(Float.parseFloat(txtGasolina.getText().replace(",", ".")));

		equipe.getCobranca().getDespesa().setManutencao(Float.parseFloat(txtManutencao.getText().replace(",", ".")));

		equipe.getCobranca().setAdiantamento(Float.parseFloat(txtAdiantamento.getText().replace(",", ".")));
		
		banco.salvarOuAtualizarObjeto(equipe.getCobranca());
		atualizar();
		alterar(false);
		

	}

	private void atualizar() {
		equipe = (Equipe) banco.buscarPorId(Equipe.class, equipe.getId());
		System.out.println("Atualizou");
		txtCobradorNome.setText(equipe.getCobranca().getCobrador().getCobrador().getNome());
		dataSaida.setDate(equipe.getCobranca().getDataSaida());
		dataChegada.setDate(equipe.getCobranca().getDataChegada());
		txtValorDiaria.setText(String.valueOf(equipe.getCobranca().getValorDiaria()));
		txtTotalVenda.setText(String.valueOf(equipe.getVenda().getVendaPraso()));
		txtCobrado.setText(String.valueOf(equipe.getCobranca().getRecebidoTotal()));
		txtDevolvido.setText(String.valueOf(equipe.getCobranca().getDevolvido()));
		txtPerdido.setText(String.valueOf(equipe.getCobranca().getPerdidoTotal()));
		float adiantamento = equipe.getCobranca().getAdiantamento();
		txtAdiantamento.setText(String.valueOf(adiantamento));
		float recebido = equipe.getCobranca().getRecebidoTotal();
		txtRecebido.setText(String.valueOf(recebido));
		float entradas = equipe.getVenda().getEntradas();
		txtEntradas.setText(String.valueOf(entradas));
		float vlrReal = recebido + adiantamento - entradas;
		txtValorReal.setText(String.valueOf(vlrReal));

		float comissao = equipe.getCobranca().getCobrador().getPercComissao() * equipe.getCobranca().getRecebidoTotal();
		txtComissaoValor.setText(String.valueOf(comissao));

		float promissoria = equipe.getCobranca().getCobrador().getValeCobrador();
		txtPromissoria.setText(String.valueOf(promissoria));

		float gasolina = equipe.getCobranca().getDespesa().getGasolina();
		txtGasolina.setText(String.valueOf(gasolina));
		float despC = equipe.getCobranca().getDespesa().getDespComNota();
		txtDeespcomNota.setText(String.valueOf(despC));
		float despS = equipe.getCobranca().getDespesa().getDespSemNota();
		txtDeespSemNota.setText(String.valueOf(despS));
		float manutencao = equipe.getCobranca().getDespesa().getManutencao();
		txtManutencao.setText(String.valueOf(manutencao));
		float diarias = equipe.getCobranca().getDespesa().getDiarias();
		txtDiarias.setText(String.valueOf(diarias));
		float totalDesp = gasolina + despC + despS + manutencao + diarias;
		txtDespesasTotal.setText(String.valueOf(totalDesp));

		float depositos = equipe.getCobranca().getDepositos();
		System.out.println("TOTAL DEPOSITOS ииииииииииииииииииии"+depositos);
		txtTotalDepositos.setText(String.valueOf(depositos));

		txtTotalDesp.setText(String.valueOf(totalDesp));

		float dinheDevolvido = equipe.getCobranca().getDinheiroDevolvido();
		txtDinheDevolvido.setText(String.valueOf(dinheDevolvido));

		float vlrPresente = depositos + totalDesp + dinheDevolvido;
		txtValorPresente.setText(String.valueOf(vlrPresente));

		float diferenca = vlrReal - vlrPresente;
		txtDiferenca.setText(String.valueOf(diferenca));
		float saldo = comissao - promissoria - diferenca;
		txtSaldo.setText(String.valueOf(saldo));
	}
}
