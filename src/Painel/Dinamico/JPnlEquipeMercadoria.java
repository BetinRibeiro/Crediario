package Painel.Dinamico;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import Model.Tabela.ModelTabelaCarrada;

import java.awt.Color;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JPnlEquipeMercadoria extends JPanel {
	private JTable tableCarradas;
	private JTable tableRetornos;
	private ModelTabelaCarrada modelCarrada = new ModelTabelaCarrada();
	private ModelTabelaCarrada modelRetorno = new ModelTabelaCarrada();

	/**
	 * Create the panel.
	 */
	public JPnlEquipeMercadoria() {
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBounds(0, 0, 1075, 570);
		setLayout(null);
		
		JLabel lblCarradas = new JLabel("Carradas");
		lblCarradas.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCarradas.setBounds(10, 36, 216, 14);
		add(lblCarradas);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 61, 528, 208);
		add(scrollPane);
		
		tableCarradas = new JTable(modelCarrada);
		scrollPane.setViewportView(tableCarradas);
		
		JLabel lblRetorno = new JLabel("Retorno");
		lblRetorno.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblRetorno.setBounds(10, 304, 216, 14);
		add(lblRetorno);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 329, 528, 208);
		add(scrollPane_1);
		
		tableRetornos = new JTable(modelRetorno);
		scrollPane_1.setViewportView(tableRetornos);
		
		JButton btnAdicionarCarrada = new JButton("Adicionar");
		btnAdicionarCarrada.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		btnAdicionarCarrada.setBounds(418, 32, 120, 23);
		add(btnAdicionarCarrada);
		
		JButton btnAdicionarRetorno = new JButton("Adicionar");
		btnAdicionarRetorno.setBounds(418, 300, 120, 23);
		add(btnAdicionarRetorno);

	}
}
