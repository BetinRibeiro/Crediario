package Painel.Dinamico;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import Bin.Equipe.Equipe;
import Bin.Mercadoria.Carrada;
import Janela.Cadastro.JFrmCadCarrada;
import Model.Tabela.ModelTabelaCarrada;
import Persistence.Dao;

import java.awt.Color;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
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

public class JPnlEquipeMercadoria extends JPanel {
	private JTable tableCarradas;
	private ModelTabelaCarrada modelCarrada = new ModelTabelaCarrada();
	private ModelTabelaCarrada modelRetorno = new ModelTabelaCarrada();
	
	private Dao banco = new Dao();

	public Equipe getEquipe() {
		return equipe;
	}

	public void setEquipe(Equipe equipe) {

		this.equipe = equipe;
		atualiza();
	}

	private Equipe equipe;

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
		scrollPane.setBounds(10, 61, 528, 141);
		add(scrollPane);

		tableCarradas = new JTable(modelCarrada);
		scrollPane.setViewportView(tableCarradas);

		JPopupMenu popupMenu = new JPopupMenu();
		addPopup(tableCarradas, popupMenu);
		
		JMenuItem mntmCancelar = new JMenuItem("Cancelar");
		popupMenu.add(mntmCancelar);
		
		JMenuItem mntmAlterar = new JMenuItem("Alterar");
		mntmAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Carrada carrada = (Carrada) banco.buscarPorId(Carrada.class, (Integer) tableCarradas.getValueAt(
						tableCarradas.getSelectedRow(), 0));
				JFrmCadCarrada cadcarr = new JFrmCadCarrada();
				cadcarr.inserirCarrada(carrada);
				cadcarr.setVisible(true);
			}
		});
		popupMenu.add(mntmAlterar);

		JButton btnAdicionarCarrada = new JButton("Adicionar");
		btnAdicionarCarrada.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				JFrmCadCarrada carr = new JFrmCadCarrada();
				carr.setEquipe(equipe);
				carr.setModal(true);
				carr.setVisible(true);
				atualiza();
			}

		});
		btnAdicionarCarrada.setBounds(418, 32, 120, 23);
		add(btnAdicionarCarrada);

		JProgressBar progressBar = new JProgressBar();
		progressBar.setBounds(10, 236, 528, 14);
		add(progressBar);

		JLabel lblCapacidadeDeVenda = new JLabel("Meta de Venda");
		lblCapacidadeDeVenda.setBounds(10, 211, 131, 14);
		add(lblCapacidadeDeVenda);

	}

	private void atualiza() {
		modelCarrada.removeTudo();
		Set<Carrada> lista = equipe.getCarradas();
		for (Carrada carrada : lista) {
			modelCarrada.addRow(carrada);
		}

	}

	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}

			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}

			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
