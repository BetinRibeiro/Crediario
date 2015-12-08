package Painel.Dinamico;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import Bin.Equipe.Equipe;
import Painel.Dinamico.Mercadoria.JPnlMercadoriaCarrada;
import Painel.Dinamico.Mercadoria.JPnlMercadoriaRetorno;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

public class JPnlEquipeMercadoriaRetorno extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	/**
	 * Create the panel.
	 */
	public JPnlEquipeMercadoriaRetorno(Equipe equipe) {
		//INSTANCIA DOIS PAINEIS DENTRO DESSA PARA DEIXAR BEM SEPARADO
		//UM PAINEL REPONSAVEL PELAS CARRADAS OUTRO PELOS RETORNOS
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBounds(0, 0, 1075, 570);
		setLayout(null);

		JLabel lblRelaoDeMercadorias = new JLabel("RELA\u00C7\u00C3O DE MERCADORIAS ENVIADAS E RETORNADAS DA VENDA");
		lblRelaoDeMercadorias.setHorizontalAlignment(SwingConstants.CENTER);
		lblRelaoDeMercadorias.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblRelaoDeMercadorias.setBounds(10, 10, 1055, 25);
		add(lblRelaoDeMercadorias);
		
		JPanel panel = new JPnlMercadoriaCarrada(equipe);
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(10, 40, 1055, 250);
		add(panel);
		
		JPanel panel_1 = new JPnlMercadoriaRetorno(equipe);
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(10, 300, 1055, 258);
		add(panel_1);

	}


}
