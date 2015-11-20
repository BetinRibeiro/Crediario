package Painel.Dinamico;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import Bin.Equipe.Equipe;
import Bin.Mercadoria.Carrada;
import Bin.Mercadoria.ItemCarrada;
import Janela.Equipe.Cadastro.JFrmCadCarrada;
import Model.Tabela.ModelTabelaCarrada;
import Persistence.Dao;

import java.awt.Color;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.List;
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

public class JPnlEquipeMercadoria extends JPanel {
	private JTable tableCarradas;
	private ModelTabelaCarrada modelCarrada = new ModelTabelaCarrada();
	private ModelTabelaCarrada modelRetorno = new ModelTabelaCarrada();
	private Equipe equipe= null;

	private Dao banco = new Dao();
	private JTextField txtTotalCarrada;

	public Equipe getEquipe() {
		return equipe;
	}

	public void setEquipe(Equipe equipe) {

		this.equipe = equipe;
		atualiza();
	}


	/**
	 * Create the panel.
	 */
	public JPnlEquipeMercadoria() {
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBounds(0, 0, 1075, 570);
		setLayout(null);

		JLabel lblCarradas = new JLabel("Carradas");
		lblCarradas.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCarradas.setBounds(10, 10, 216, 25);
		add(lblCarradas);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 40, 1055, 160);
		add(scrollPane);

		tableCarradas = new JTable(modelCarrada);
		tableCarradas.getTableHeader().setReorderingAllowed(false);
		tableCarradas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(tableCarradas);

		JPopupMenu popupMenu = new JPopupMenu();
		addPopup(tableCarradas, popupMenu);

		JMenuItem mntmCancelar = new JMenuItem("Deletar");
		mntmCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Integer id= (Integer) tableCarradas.getValueAt(tableCarradas.getSelectedRow(), 0);
				Carrada carrr = ((Carrada)banco.buscarPorId(Carrada.class, id));
				System.out.println(carrr.getId()+" - carrada");
//				@SuppressWarnings("unchecked")
//				Set<ItemCarrada> lista = carrr.getCarrada();
//				for (ItemCarrada inst : lista){
//					System.out.println("Id inst"+inst.getId());
//					System.out.println("nome - " +inst.getProduto().getDescricao());
//					System.out.println("Deletou - "+banco.deletarObjeto(inst));
//					
//				}
				boolean v =banco.deletarObjeto(carrr);
				System.out.println("deletou"+v);
				atualiza();
			}
		});
		popupMenu.add(mntmCancelar);

		JMenuItem mntmAlterar = new JMenuItem("Alterar");
		mntmAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Carrada carrada = (Carrada) banco.buscarPorId(Carrada.class,
						(Integer) tableCarradas.getValueAt(tableCarradas.getSelectedRow(), 0));
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

				carr.dispose();
				validate();
			}

		});
		btnAdicionarCarrada.setBounds(945, 10, 120, 25);
		add(btnAdicionarCarrada);

		JProgressBar progressBar = new JProgressBar();
		progressBar.setForeground(new Color(173, 216, 230));
		progressBar.setValue(50);
		progressBar.setBounds(361, 10, 570, 25);
		add(progressBar);

		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel.setBounds(10, 241, 1055, 318);
		add(panel);
		
		JLabel lblValorTotalDas = new JLabel("Valor Total das Carradas");
		lblValorTotalDas.setHorizontalAlignment(SwingConstants.RIGHT);
		lblValorTotalDas.setBounds(10, 210, 148, 20);
		add(lblValorTotalDas);
		
		txtTotalCarrada = new JTextField();
		txtTotalCarrada.setDisabledTextColor(new Color(0, 0, 0));
		txtTotalCarrada.setEnabled(false);
		txtTotalCarrada.setBounds(170, 210, 93, 20);
		add(txtTotalCarrada);
		txtTotalCarrada.setColumns(10);


	}

	public boolean atualiza() {
//		try {
		equipe = (Equipe)banco.buscarPorId(Equipe.class, equipe.getId());
			modelCarrada.removeTudo();
			 Set<Carrada> lista = equipe.getCarradas();
			for (Carrada carrada : lista) {
				modelCarrada.addRow(carrada);
			}
			float valor = 0;
			for (Carrada carrada : lista) {
				valor= valor+carrada.getValorTotal();
			}
			txtTotalCarrada.setText(String.valueOf(valor));
//		} catch (java.lang.NullPointerException e) {
////			JOptionPane.showMessageDialog(this, "Equipe Não possui carradas relacionadas a ela.");
//			System.out.println(e.getMessage());
//			System.out.println(e);
//		}
			return true;

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
