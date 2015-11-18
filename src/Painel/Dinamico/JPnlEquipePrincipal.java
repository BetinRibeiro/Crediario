package Painel.Dinamico;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JMenuBar;
import javax.swing.JMenu;

public class JPnlEquipePrincipal extends JPanel {

	/**
	 * Create the panel.
	 */
	public JPnlEquipePrincipal() {
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBounds(0, 0, 1075, 570);
		setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 1075, 21);
		add(menuBar);
		
		JMenu mnMercadoria = new JMenu("Mercadoria");
		menuBar.add(mnMercadoria);
		
		JMenu mnTransporte = new JMenu("Transporte");
		menuBar.add(mnTransporte);
		
		JMenu mnEquipe = new JMenu("Equipe");
		menuBar.add(mnEquipe);

	}
}
