package Painel.Dinamico;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import Bin.Equipe.Equipe;
import Painel.Dinamico.Mercadoria.JPnlMercadoriaDevolucao;
import Painel.Dinamico.Vendedores.JPnlVendedoresCobrancaQuitacao;

import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.SwingConstants;

public class JPnlEquipeCobrancaComissao extends JPanel {
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Create the panel.
	 */
	public JPnlEquipeCobrancaComissao(Equipe equipe) {
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBounds(0, 0, 1075, 570);
		setLayout(null);
		
		JPanel panel = new JPnlVendedoresCobrancaQuitacao(equipe);
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(10, 40, 1055, 280);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblRelaoDeCobrana = new JLabel("RELA\u00C7\u00C3O DE COBRAN\u00C7A E SALDO");
		lblRelaoDeCobrana.setHorizontalAlignment(SwingConstants.CENTER);
		lblRelaoDeCobrana.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblRelaoDeCobrana.setBounds(10, 11, 1055, 25);
		add(lblRelaoDeCobrana);
		
		JPanel panel_1 = new JPnlMercadoriaDevolucao(equipe);
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(10, 330, 1055, 218);
		add(panel_1);

	}
	
}
