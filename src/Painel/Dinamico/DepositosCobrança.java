package Painel.Dinamico;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;
import java.util.Date;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;

public class DepositosCobrança extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTable table;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;

	/**
	 * Create the panel.
	 */
	public DepositosCobrança() {
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBounds(0, 0, 1075, 570);
		setLayout(null);
		
		JLabel lblCodigoEquipe = new JLabel("Codigo Equipe");
		lblCodigoEquipe.setBounds(10, 11, 93, 14);
		add(lblCodigoEquipe);
		
		textField = new JTextField();
		textField.setBounds(10, 33, 93, 20);
		add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(10, 80, 93, 20);
		add(textField_1);
		
		JLabel lblTotal = new JLabel("Total");
		lblTotal.setBounds(10, 60, 93, 14);
		add(lblTotal);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(115, 80, 93, 20);
		add(textField_2);
		
		JLabel lblQuantFichas = new JLabel("Quant Fichas");
		lblQuantFichas.setBounds(115, 60, 93, 14);
		add(lblQuantFichas);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(220, 80, 93, 20);
		add(textField_3);
		
		JLabel label_2 = new JLabel("Codigo Equipe");
		label_2.setBounds(220, 60, 93, 14);
		add(label_2);
		
		JLabel lblDataInicio = new JLabel("Data Inicio");
		lblDataInicio.setBounds(10, 110, 93, 14);
		add(lblDataInicio);
		
		JLabel lblUltimaData = new JLabel("Ultima Data");
		lblUltimaData.setBounds(140, 110, 93, 14);
		add(lblUltimaData);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Deposito", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(10, 160, 328, 135);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblCodigoDeposito = new JLabel("Codigo Deposito");
		lblCodigoDeposito.setBounds(10, 20, 104, 14);
		panel.add(lblCodigoDeposito);
		
		textField_4 = new JTextField();
		textField_4.setBounds(10, 40, 86, 20);
		panel.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblValor = new JLabel("Valor");
		lblValor.setBounds(10, 70, 46, 14);
		panel.add(lblValor);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(10, 90, 86, 20);
		panel.add(textField_5);
		
		JDateChooser dateChooser_2 = new JDateChooser((Date) null);
		dateChooser_2.setBounds(125, 40, 120, 20);
		panel.add(dateChooser_2);
		
		JLabel label = new JLabel("Data Inicio");
		label.setBounds(125, 20, 93, 14);
		panel.add(label);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(125, 90, 86, 20);
		panel.add(textField_6);
		
		JLabel lblBanco = new JLabel("Banco");
		lblBanco.setBounds(125, 70, 46, 14);
		panel.add(lblBanco);
		
		JButton btnInserir = new JButton("Inserir");
		btnInserir.setBounds(225, 90, 89, 23);
		panel.add(btnInserir);
		
		JDateChooser dateChooser = new JDateChooser((Date) null);
		dateChooser.setBounds(10, 130, 120, 20);
		add(dateChooser);
		
		JDateChooser dateChooser_1 = new JDateChooser((Date) null);
		dateChooser_1.setBounds(140, 130, 120, 20);
		add(dateChooser_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 355, 328, 204);
		add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		textField_7 = new JTextField();
		textField_7.setBackground(new Color(255, 248, 220));
		textField_7.setDisabledTextColor(new Color(0, 0, 0));
		textField_7.setEnabled(false);
		textField_7.setColumns(10);
		textField_7.setBounds(10, 325, 93, 20);
		add(textField_7);
		
		JLabel lblPontoEquilibrio = new JLabel("Ponto Equilibrio");
		lblPontoEquilibrio.setBounds(10, 305, 93, 14);
		add(lblPontoEquilibrio);
		
		textField_8 = new JTextField();
		textField_8.setBackground(new Color(255, 248, 220));
		textField_8.setDisabledTextColor(new Color(0, 0, 0));
		textField_8.setEnabled(false);
		textField_8.setColumns(10);
		textField_8.setBounds(115, 325, 93, 20);
		add(textField_8);
		
		JLabel lblTotalDepositos = new JLabel("Total Depositos");
		lblTotalDepositos.setBounds(115, 305, 93, 14);
		add(lblTotalDepositos);
		
		textField_9 = new JTextField();
		textField_9.setBackground(new Color(255, 248, 220));
		textField_9.setDisabledTextColor(new Color(0, 0, 0));
		textField_9.setEnabled(false);
		textField_9.setColumns(10);
		textField_9.setBounds(220, 325, 93, 20);
		add(textField_9);
		
		JLabel lblLucro = new JLabel("Saldo");
		lblLucro.setBounds(220, 305, 93, 14);
		add(lblLucro);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(348, 11, 717, 548);
		add(panel_1);
		
		textField_10 = new JTextField();
		textField_10.setBackground(new Color(255, 248, 220));
		textField_10.setColumns(10);
		textField_10.setBounds(270, 129, 68, 20);
		add(textField_10);
		
		JLabel lblFaltam = new JLabel("Faltam");
		lblFaltam.setBounds(270, 110, 68, 14);
		add(lblFaltam);

	}
}
