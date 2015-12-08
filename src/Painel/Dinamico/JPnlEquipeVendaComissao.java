package Painel.Dinamico;

import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import Bin.Equipe.Equipe;
import Painel.Dinamico.Transporte.JPnlTransporteEquipe;
import Painel.Dinamico.Vendedores.JPnlVendedoresVendaSaldo;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;

public class JPnlEquipeVendaComissao extends JPanel  {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public JPnlEquipeVendaComissao(Equipe equipe) {
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBounds(0, 0, 1075, 570);
		setLayout(null);
		
		JLabel lblRelaoDasVendas = new JLabel("RELA\u00C7\u00C3O DE VANDAS E COMISS\u00D5ES");
		lblRelaoDasVendas.setBounds(10, 10, 1055, 25);
		lblRelaoDasVendas.setHorizontalAlignment(SwingConstants.CENTER);
		lblRelaoDasVendas.setFont(new Font("Tahoma", Font.PLAIN, 16));
		add(lblRelaoDasVendas);
		
		JPanel panel = new JPnlVendedoresVendaSaldo(equipe);
		panel.setBounds(10, 40, 1055, 300);
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		add(panel);
		panel.setLayout(null);
		
		JPanel painelGrafico = new JPnlTransporteEquipe(equipe);
		painelGrafico.setBounds(10, 350, 1055, 207);
		painelGrafico.setBorder(new LineBorder(new Color(0, 0, 0)));
		add(painelGrafico);
		painelGrafico.setLayout(null);
		

	}
	
}
