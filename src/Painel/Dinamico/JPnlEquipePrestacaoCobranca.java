package Painel.Dinamico;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import com.toedter.calendar.JDateChooser;
import java.util.Date;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class JPnlEquipePrestacaoCobranca extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTextField textField_6;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_14;
	private JTextField textField_16;
	private JTextField textField_17;
	private JTextField textField_18;
	private JTextField textField_19;
	private JTextField textField_20;
	private JTextField textField_21;
	private JTextField textField_22;
	private JTextField textField_26;
	private JTextField textField_28;
	private JTextField textField_29;
	private JTextField textField_23;
	private JTextField textField_24;
	private JTextField textField_25;
	private JTextField textField_27;
	private JTextField textField_15;

	/**
	 * Create the panel.
	 */
	public JPnlEquipePrestacaoCobranca() {
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
		
		JDateChooser dateChooser = new JDateChooser((Date) null);
		dateChooser.setBounds(120, 35, 122, 20);
		panel_1.add(dateChooser);
		
		JLabel lblDataSaida = new JLabel("DATA SAIDA");
		lblDataSaida.setBounds(10, 35, 110, 20);
		panel_1.add(lblDataSaida);
		
		JDateChooser dateChooser_1 = new JDateChooser((Date) null);
		dateChooser_1.setBounds(120, 60, 122, 20);
		panel_1.add(dateChooser_1);
		
		JLabel lblDataChegada = new JLabel("DATA CHEGADA");
		lblDataChegada.setBounds(10, 60, 110, 20);
		panel_1.add(lblDataChegada);
		
		JLabel label_3 = new JLabel("QUANT. DIAS");
		label_3.setBounds(10, 85, 110, 20);
		panel_1.add(label_3);
		
		textField = new JTextField("0");
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setForeground(new Color(255, 250, 205));
		textField.setEnabled(false);
		textField.setDisabledTextColor(Color.BLACK);
		textField.setColumns(10);
		textField.setBackground(new Color(255, 250, 205));
		textField.setBounds(120, 85, 122, 20);
		panel_1.add(textField);
		
		textField_1 = new JTextField("0");
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setForeground(new Color(255, 250, 205));
		textField_1.setEnabled(false);
		textField_1.setDisabledTextColor(Color.BLACK);
		textField_1.setColumns(10);
		textField_1.setBackground(new Color(255, 250, 205));
		textField_1.setBounds(10, 10, 232, 20);
		panel_1.add(textField_1);
		
		JLabel lblValorDiaria = new JLabel("VALOR DIARIA");
		lblValorDiaria.setBounds(10, 110, 110, 20);
		panel_1.add(lblValorDiaria);
		
		textField_2 = new JTextField("0");
		textField_2.setHorizontalAlignment(SwingConstants.CENTER);
		textField_2.setForeground(new Color(255, 250, 205));
		textField_2.setEnabled(false);
		textField_2.setDisabledTextColor(Color.BLACK);
		textField_2.setColumns(10);
		textField_2.setBackground(new Color(255, 250, 205));
		textField_2.setBounds(120, 110, 122, 20);
		panel_1.add(textField_2);
		
		JButton btnBuscar = new JButton("");
		btnBuscar.setIcon(new ImageIcon(JPnlEquipePrestacaoCobranca.class.getResource("/Imagens/Secuty-agent.png")));
		btnBuscar.setFont(new Font("Tahoma", Font.PLAIN, 8));
		btnBuscar.setBounds(247, 9, 63, 46);
		panel_1.add(btnBuscar);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_2.setBounds(10, 285, 320, 90);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblAdiantamento = new JLabel("ADIANTAMENTO");
		lblAdiantamento.setBounds(10, 11, 110, 20);
		panel_2.add(lblAdiantamento);
		
		textField_6 = new JTextField("0,00");
		textField_6.setHorizontalAlignment(SwingConstants.CENTER);
		textField_6.setForeground(new Color(255, 250, 205));
		textField_6.setEnabled(false);
		textField_6.setDisabledTextColor(Color.BLACK);
		textField_6.setColumns(10);
		textField_6.setBackground(new Color(255, 250, 205));
		textField_6.setBounds(120, 11, 122, 20);
		panel_2.add(textField_6);
		
		textField_10 = new JTextField("0,00");
		textField_10.setHorizontalAlignment(SwingConstants.CENTER);
		textField_10.setForeground(new Color(255, 250, 205));
		textField_10.setEnabled(false);
		textField_10.setDisabledTextColor(Color.BLACK);
		textField_10.setColumns(10);
		textField_10.setBackground(new Color(255, 250, 205));
		textField_10.setBounds(120, 36, 122, 20);
		panel_2.add(textField_10);
		
		JLabel label_2 = new JLabel("COBRADO");
		label_2.setBounds(10, 36, 110, 20);
		panel_2.add(label_2);
		
		JLabel lblDinheiroReal = new JLabel("VALOR REAL");
		lblDinheiroReal.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDinheiroReal.setBounds(10, 60, 110, 20);
		panel_2.add(lblDinheiroReal);
		
		textField_11 = new JTextField("0,00");
		textField_11.setHorizontalAlignment(SwingConstants.CENTER);
		textField_11.setForeground(new Color(255, 250, 205));
		textField_11.setEnabled(false);
		textField_11.setDisabledTextColor(Color.BLACK);
		textField_11.setColumns(10);
		textField_11.setBackground(new Color(255, 250, 205));
		textField_11.setBounds(120, 60, 122, 20);
		panel_2.add(textField_11);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_3.setBounds(10, 160, 320, 115);
		panel.add(panel_3);
		
		textField_3 = new JTextField("0,00");
		textField_3.setHorizontalAlignment(SwingConstants.CENTER);
		textField_3.setForeground(new Color(255, 250, 205));
		textField_3.setEnabled(false);
		textField_3.setDisabledTextColor(Color.BLACK);
		textField_3.setColumns(10);
		textField_3.setBackground(new Color(255, 250, 205));
		textField_3.setBounds(120, 35, 122, 20);
		panel_3.add(textField_3);
		
		JLabel lblCobrado = new JLabel("COBRADO");
		lblCobrado.setBounds(10, 35, 110, 20);
		panel_3.add(lblCobrado);
		
		textField_4 = new JTextField("0,00");
		textField_4.setHorizontalAlignment(SwingConstants.CENTER);
		textField_4.setForeground(new Color(255, 250, 205));
		textField_4.setEnabled(false);
		textField_4.setDisabledTextColor(Color.BLACK);
		textField_4.setColumns(10);
		textField_4.setBackground(new Color(255, 250, 205));
		textField_4.setBounds(120, 60, 122, 20);
		panel_3.add(textField_4);
		
		JLabel lblDevolvido = new JLabel("DEVOLVIDO");
		lblDevolvido.setBounds(10, 60, 110, 20);
		panel_3.add(lblDevolvido);
		
		textField_5 = new JTextField("0,00");
		textField_5.setHorizontalAlignment(SwingConstants.CENTER);
		textField_5.setForeground(new Color(255, 250, 205));
		textField_5.setEnabled(false);
		textField_5.setDisabledTextColor(Color.BLACK);
		textField_5.setColumns(10);
		textField_5.setBackground(new Color(255, 250, 205));
		textField_5.setBounds(120, 85, 122, 20);
		panel_3.add(textField_5);
		
		JLabel lblPerdido = new JLabel("PERDIDO");
		lblPerdido.setBounds(10, 85, 110, 20);
		panel_3.add(lblPerdido);
		
		textField_7 = new JTextField("0,00");
		textField_7.setHorizontalAlignment(SwingConstants.CENTER);
		textField_7.setForeground(new Color(255, 250, 205));
		textField_7.setEnabled(false);
		textField_7.setDisabledTextColor(Color.BLACK);
		textField_7.setColumns(10);
		textField_7.setBackground(new Color(255, 250, 205));
		textField_7.setBounds(252, 35, 59, 20);
		panel_3.add(textField_7);
		
		textField_8 = new JTextField("0,00");
		textField_8.setHorizontalAlignment(SwingConstants.CENTER);
		textField_8.setForeground(new Color(255, 250, 205));
		textField_8.setEnabled(false);
		textField_8.setDisabledTextColor(Color.BLACK);
		textField_8.setColumns(10);
		textField_8.setBackground(new Color(255, 250, 205));
		textField_8.setBounds(252, 60, 59, 20);
		panel_3.add(textField_8);
		
		textField_9 = new JTextField("0,00");
		textField_9.setHorizontalAlignment(SwingConstants.CENTER);
		textField_9.setForeground(new Color(255, 250, 205));
		textField_9.setEnabled(false);
		textField_9.setDisabledTextColor(Color.BLACK);
		textField_9.setColumns(10);
		textField_9.setBackground(new Color(255, 250, 205));
		textField_9.setBounds(252, 85, 59, 20);
		panel_3.add(textField_9);
		
		JLabel lblTotalVenda = new JLabel("TOTAL VENDA");
		lblTotalVenda.setBounds(10, 10, 110, 20);
		panel_3.add(lblTotalVenda);
		
		textField_12 = new JTextField("0,00");
		textField_12.setHorizontalAlignment(SwingConstants.CENTER);
		textField_12.setForeground(new Color(255, 250, 205));
		textField_12.setEnabled(false);
		textField_12.setDisabledTextColor(Color.BLACK);
		textField_12.setColumns(10);
		textField_12.setBackground(new Color(255, 250, 205));
		textField_12.setBounds(120, 10, 122, 20);
		panel_3.add(textField_12);
		
		textField_13 = new JTextField("0,00");
		textField_13.setHorizontalAlignment(SwingConstants.CENTER);
		textField_13.setForeground(new Color(255, 250, 205));
		textField_13.setEnabled(false);
		textField_13.setDisabledTextColor(Color.BLACK);
		textField_13.setColumns(10);
		textField_13.setBackground(new Color(255, 250, 205));
		textField_13.setBounds(252, 10, 59, 20);
		panel_3.add(textField_13);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_4.setBounds(10, 386, 320, 116);
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
		
		textField_14 = new JTextField("0");
		textField_14.setHorizontalAlignment(SwingConstants.CENTER);
		textField_14.setForeground(new Color(255, 250, 205));
		textField_14.setEnabled(false);
		textField_14.setDisabledTextColor(Color.BLACK);
		textField_14.setColumns(10);
		textField_14.setBackground(new Color(255, 250, 205));
		textField_14.setBounds(120, 35, 122, 20);
		panel_6.add(textField_14);
		
		JLabel lblDiferna = new JLabel("DIFER\u00CAN\u00C7A");
		lblDiferna.setBounds(10, 60, 110, 20);
		panel_6.add(lblDiferna);
		
		textField_16 = new JTextField("0");
		textField_16.setHorizontalAlignment(SwingConstants.CENTER);
		textField_16.setForeground(new Color(255, 250, 205));
		textField_16.setEnabled(false);
		textField_16.setDisabledTextColor(Color.BLACK);
		textField_16.setColumns(10);
		textField_16.setBackground(new Color(255, 250, 205));
		textField_16.setBounds(120, 60, 122, 20);
		panel_6.add(textField_16);
		
		textField_25 = new JTextField("0");
		textField_25.setHorizontalAlignment(SwingConstants.CENTER);
		textField_25.setForeground(new Color(255, 250, 205));
		textField_25.setEnabled(false);
		textField_25.setDisabledTextColor(Color.BLACK);
		textField_25.setColumns(10);
		textField_25.setBackground(new Color(255, 250, 205));
		textField_25.setBounds(120, 10, 122, 20);
		panel_6.add(textField_25);
		
		JLabel lblSaldo = new JLabel("SALDO");
		lblSaldo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSaldo.setBounds(10, 85, 110, 20);
		panel_6.add(lblSaldo);
		
		textField_27 = new JTextField("0");
		textField_27.setHorizontalAlignment(SwingConstants.CENTER);
		textField_27.setForeground(new Color(255, 250, 205));
		textField_27.setEnabled(false);
		textField_27.setDisabledTextColor(Color.BLACK);
		textField_27.setColumns(10);
		textField_27.setBackground(new Color(255, 250, 205));
		textField_27.setBounds(120, 85, 122, 20);
		panel_6.add(textField_27);
		
		textField_15 = new JTextField("0,00");
		textField_15.setHorizontalAlignment(SwingConstants.CENTER);
		textField_15.setForeground(Color.BLACK);
		textField_15.setEnabled(false);
		textField_15.setDisabledTextColor(Color.BLACK);
		textField_15.setColumns(10);
		textField_15.setBackground(Color.WHITE);
		textField_15.setBounds(252, 10, 59, 20);
		panel_6.add(textField_15);
		
		JPanel panel_7 = new JPanel();
		panel_7.setLayout(null);
		panel_7.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_7.setBounds(10, 325, 320, 112);
		panel_5.add(panel_7);
		
		JLabel lblDeposito = new JLabel("DEPOSITOS");
		lblDeposito.setBounds(10, 11, 110, 20);
		panel_7.add(lblDeposito);
		
		textField_17 = new JTextField("0,00");
		textField_17.setHorizontalAlignment(SwingConstants.CENTER);
		textField_17.setForeground(new Color(255, 250, 205));
		textField_17.setEnabled(false);
		textField_17.setDisabledTextColor(Color.BLACK);
		textField_17.setColumns(10);
		textField_17.setBackground(new Color(255, 250, 205));
		textField_17.setBounds(120, 11, 122, 20);
		panel_7.add(textField_17);
		
		textField_18 = new JTextField("0,00");
		textField_18.setHorizontalAlignment(SwingConstants.CENTER);
		textField_18.setForeground(new Color(255, 250, 205));
		textField_18.setEnabled(false);
		textField_18.setDisabledTextColor(Color.BLACK);
		textField_18.setColumns(10);
		textField_18.setBackground(new Color(255, 250, 205));
		textField_18.setBounds(120, 36, 122, 20);
		panel_7.add(textField_18);
		
		JLabel lblDespesa = new JLabel("DESPESAS");
		lblDespesa.setBounds(10, 36, 110, 20);
		panel_7.add(lblDespesa);
		
		JLabel lblDinhApresentado = new JLabel("VALOR APRESENTADO");
		lblDinhApresentado.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDinhApresentado.setBounds(30, 85, 110, 20);
		panel_7.add(lblDinhApresentado);
		
		textField_19 = new JTextField("0,00");
		textField_19.setHorizontalAlignment(SwingConstants.CENTER);
		textField_19.setForeground(new Color(255, 250, 205));
		textField_19.setEnabled(false);
		textField_19.setDisabledTextColor(Color.BLACK);
		textField_19.setColumns(10);
		textField_19.setBackground(new Color(255, 250, 205));
		textField_19.setBounds(141, 85, 101, 20);
		panel_7.add(textField_19);
		
		JLabel lblDevolvido_1 = new JLabel("DEVOLVIDO");
		lblDevolvido_1.setBounds(10, 62, 110, 20);
		panel_7.add(lblDevolvido_1);
		
		textField_24 = new JTextField("0,00");
		textField_24.setHorizontalAlignment(SwingConstants.CENTER);
		textField_24.setForeground(Color.BLACK);
		textField_24.setEnabled(false);
		textField_24.setDisabledTextColor(Color.BLACK);
		textField_24.setColumns(10);
		textField_24.setBackground(Color.WHITE);
		textField_24.setBounds(120, 60, 122, 20);
		panel_7.add(textField_24);
		
		JPanel panel_8 = new JPanel();
		panel_8.setLayout(null);
		panel_8.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_8.setBounds(10, 140, 320, 179);
		panel_5.add(panel_8);
		
		textField_20 = new JTextField("0,00");
		textField_20.setHorizontalAlignment(SwingConstants.CENTER);
		textField_20.setForeground(Color.BLACK);
		textField_20.setEnabled(false);
		textField_20.setDisabledTextColor(Color.BLACK);
		textField_20.setColumns(10);
		textField_20.setBackground(Color.WHITE);
		textField_20.setBounds(120, 35, 122, 20);
		panel_8.add(textField_20);
		
		JLabel lblCNota = new JLabel("DESP. C/ NOTA");
		lblCNota.setBounds(10, 35, 110, 20);
		panel_8.add(lblCNota);
		
		textField_21 = new JTextField("0,00");
		textField_21.setHorizontalAlignment(SwingConstants.CENTER);
		textField_21.setForeground(Color.BLACK);
		textField_21.setEnabled(false);
		textField_21.setDisabledTextColor(Color.BLACK);
		textField_21.setColumns(10);
		textField_21.setBackground(Color.WHITE);
		textField_21.setBounds(120, 60, 122, 20);
		panel_8.add(textField_21);
		
		JLabel lblDespSNota = new JLabel("DESP. S/ NOTA");
		lblDespSNota.setBounds(10, 60, 110, 20);
		panel_8.add(lblDespSNota);
		
		textField_22 = new JTextField("0,00");
		textField_22.setHorizontalAlignment(SwingConstants.CENTER);
		textField_22.setForeground(Color.BLACK);
		textField_22.setEnabled(false);
		textField_22.setDisabledTextColor(Color.BLACK);
		textField_22.setColumns(10);
		textField_22.setBackground(Color.WHITE);
		textField_22.setBounds(120, 85, 122, 20);
		panel_8.add(textField_22);
		
		JLabel lblManuteno = new JLabel("MANUTEN\u00C7\u00C3O");
		lblManuteno.setBounds(10, 85, 110, 20);
		panel_8.add(lblManuteno);
		
		JLabel lblGasolina = new JLabel("GASOLINA");
		lblGasolina.setBounds(10, 10, 110, 20);
		panel_8.add(lblGasolina);
		
		textField_26 = new JTextField("0,00");
		textField_26.setHorizontalAlignment(SwingConstants.CENTER);
		textField_26.setForeground(Color.BLACK);
		textField_26.setEnabled(false);
		textField_26.setDisabledTextColor(Color.BLACK);
		textField_26.setColumns(10);
		textField_26.setBackground(Color.WHITE);
		textField_26.setBounds(120, 10, 122, 20);
		panel_8.add(textField_26);
		
		JLabel label_14 = new JLabel("PERDIDO");
		label_14.setHorizontalAlignment(SwingConstants.RIGHT);
		label_14.setBounds(10, 135, 110, 20);
		panel_8.add(label_14);
		
		JLabel lblDiarias = new JLabel("DIARIAS");
		lblDiarias.setBounds(10, 110, 110, 20);
		panel_8.add(lblDiarias);
		
		textField_28 = new JTextField("0,00");
		textField_28.setHorizontalAlignment(SwingConstants.CENTER);
		textField_28.setForeground(Color.BLACK);
		textField_28.setEnabled(false);
		textField_28.setDisabledTextColor(Color.BLACK);
		textField_28.setColumns(10);
		textField_28.setBackground(Color.WHITE);
		textField_28.setBounds(120, 110, 122, 20);
		panel_8.add(textField_28);
		
		textField_29 = new JTextField("0,00");
		textField_29.setHorizontalAlignment(SwingConstants.CENTER);
		textField_29.setForeground(new Color(255, 250, 205));
		textField_29.setEnabled(false);
		textField_29.setDisabledTextColor(Color.BLACK);
		textField_29.setColumns(10);
		textField_29.setBackground(new Color(255, 250, 205));
		textField_29.setBounds(120, 135, 122, 20);
		panel_8.add(textField_29);
		
		textField_23 = new JTextField("0,00");
		textField_23.setHorizontalAlignment(SwingConstants.CENTER);
		textField_23.setForeground(new Color(255, 250, 205));
		textField_23.setEnabled(false);
		textField_23.setDisabledTextColor(Color.BLACK);
		textField_23.setColumns(10);
		textField_23.setBackground(new Color(255, 250, 205));
		textField_23.setBounds(250, 135, 59, 20);
		panel_8.add(textField_23);
		
		JPanel panel_9 = new JPanel();
		panel_9.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_9.setBounds(10, 448, 320, 54);
		panel_5.add(panel_9);
		
		JPanel panel_10 = new JPanel();
		panel_10.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_10.setBounds(360, 40, 358, 319);
		add(panel_10);
		panel_10.setLayout(null);
		
		JLabel lblGrafico = new JLabel("GRAFICO");
		lblGrafico.setFont(new Font("Tahoma", Font.PLAIN, 47));
		lblGrafico.setBounds(83, 129, 241, 62);
		panel_10.add(lblGrafico);

	}
}
