package Painel.Dinamico;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JProgressBar;
import java.awt.ComponentOrientation;

public class JPnlEquipeDepositos extends JPanel {
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public JPnlEquipeDepositos() {
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBounds(0, 0, 1075, 570);
		setLayout(null);
		
		JLabel lblDepositosDaCobran = new JLabel("DEPOSITOS DA COBRAN\u00C7A");
		lblDepositosDaCobran.setHorizontalAlignment(SwingConstants.CENTER);
		lblDepositosDaCobran.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDepositosDaCobran.setBounds(10, 11, 1055, 25);
		add(lblDepositosDaCobran);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(10, 46, 1055, 254);
		add(panel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 41, 1035, 193);
		panel.add(scrollPane);
		
		JButton button = new JButton("Inserir");
		button.setBounds(925, 11, 120, 25);
		panel.add(button);
		
		JLabel lblListaDeDepositos = new JLabel("LISTA DE DEPOSITOS DA COBRAN\u00C7A");
		lblListaDeDepositos.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblListaDeDepositos.setBounds(10, 11, 364, 25);
		panel.add(lblListaDeDepositos);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(10, 374, 1055, 185);
		add(panel_1);
		
		JLabel label = new JLabel("Grafico");
		label.setFont(new Font("Tahoma", Font.PLAIN, 26));
		label.setBounds(58, 54, 311, 57);
		panel_1.add(label);
		
		JProgressBar progressBar = new JProgressBar();
		progressBar.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		progressBar.setBounds(10, 311, 460, 20);
		progressBar.setValue(50);
		
		add(progressBar);
		
		JProgressBar progressBar_1 = new JProgressBar();
		progressBar_1.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		progressBar_1.setBounds(580, 311, 485, 20);
		progressBar_1.setValue(50);
		add(progressBar_1);
		
		textField = new JTextField();
		textField.setBounds(480, 311, 90, 20);
		add(textField);
		textField.setColumns(10);
		
		JProgressBar progressBar_2 = new JProgressBar();
		progressBar_2.setBackground(new Color(205, 133, 63));
		progressBar_2.setForeground(new Color(205, 133, 63));
		progressBar_2.setBounds(10, 342, 1055, 20);
		progressBar_2.setValue(25);
		add(progressBar_2);
	}
}
