package Painel.Dinamico;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import Bin.Equipe.Equipe;
import Bin.Mercadoria.Carrada;
import Janela.Equipe.Cadastro.JFrmCadCarrada;
import Model.Tabela.ModelTabelaCarrada;
import Painel.Dinamico.Mercadoria.JPnlMercadoriaCarrada;
import Painel.Dinamico.Mercadoria.JPnlMercadoriaRetorno;
import Persistence.Dao;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.Set;
import java.awt.event.ActionEvent;
import javax.swing.JProgressBar;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class JPnlEquipeMercadoriaRetorno extends JPanel {
	private ModelTabelaCarrada modelCarrada = new ModelTabelaCarrada();
	private ModelTabelaCarrada modelRetorno = new ModelTabelaCarrada();
	private Equipe equipe;

	private Dao banco = new Dao();


	/**
	 * Create the panel.
	 */
	public JPnlEquipeMercadoriaRetorno(Equipe equipe) {
		this.equipe = equipe;
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
		
		JPanel panel_1 = new JPnlMercadoriaRetorno();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(10, 301, 1055, 258);
		add(panel_1);

	}


}
