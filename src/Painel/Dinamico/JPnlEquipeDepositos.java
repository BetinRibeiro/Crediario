package Painel.Dinamico;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import Bin.Equipe.Equipe;
import Painel.Dinamico.Depositos.JPnlDepositos;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

public class JPnlEquipeDepositos extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public JPnlEquipeDepositos(Equipe equipe) {
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBounds(0, 0, 1075, 570);
		setLayout(null);
		
		JLabel lblDepositosDaCobran = new JLabel("DEPOSITOS DA COBRAN\u00C7A");
		lblDepositosDaCobran.setHorizontalAlignment(SwingConstants.CENTER);
		lblDepositosDaCobran.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDepositosDaCobran.setBounds(10, 10, 1055, 25);
		add(lblDepositosDaCobran);
		
		JPanel panel = new JPnlDepositos(equipe);
		panel.setLayout(null);
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(10, 40, 1055, 500);
		add(panel);
		
		
	}
}
