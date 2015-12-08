package Painel.Dinamico.ReceitasDespesasExtra;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JTable;

import Bin.DespExtra;
import Bin.Equipe.Equipe;
import Janela.Inserir.JFrmInsDespesaExtra;
import Model.Tabela.ModelTabelaDespedaExtra;
import Persistence.Dao;

import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import java.awt.Color;
import javax.swing.SwingConstants;

import org.jboss.jandex.Main;

import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JMenuItem;

public class JPnlDespesasExtra extends JPanel implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable table;
	private ModelTabelaDespedaExtra model = new ModelTabelaDespedaExtra();
	private Equipe equipe;
	private Dao banco = new Dao();
	private JTextField txtValor;
	DecimalFormat df = new DecimalFormat("0.00");

	/**
	 * Create the panel.
	 */
	public JPnlDespesasExtra(Equipe equipe) {
		this.equipe = equipe;
		setBounds(0, 0, 727, 495);
		setLayout(null);

		JLabel foto2 = new JLabel();
		foto2.setBounds(600, 10, 20, 20);
		ImageIcon img2 = new ImageIcon(Main.class.getResource("/Imagens/x.png"));
		Image img02 = img2.getImage().getScaledInstance(foto2.getWidth(), foto2.getHeight(), Image.SCALE_DEFAULT);
		foto2.setIcon(new ImageIcon(img02));
		add(foto2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 43, 707, 360);
		add(scrollPane);

		table = new JTable(model);
		table.getTableHeader().setReorderingAllowed(false);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.getColumn("DESCRIÇÃO").setPreferredWidth(200);
		scrollPane.setViewportView(table);
		JPopupMenu popupMenu = new JPopupMenu();
		addPopup(table, popupMenu);

		JMenuItem mntmDeletar = new JMenuItem("Deletar");
		mntmDeletar.addActionListener(this);
		popupMenu.add(mntmDeletar);

		JMenuItem mntmAlterar = new JMenuItem("Alterar");
		mntmAlterar.addActionListener(this);
		popupMenu.add(mntmAlterar);

		JButton btnInserir = new JButton("Adicionar");
		btnInserir.addActionListener(this);
		btnInserir.setBounds(628, 9, 89, 23);
		add(btnInserir);

		JLabel lblDespesasLanadasDe = new JLabel("DESPESAS LAN\u00C7ADAS DE FORMA EXTRAORDINARIA");
		lblDespesasLanadasDe.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDespesasLanadasDe.setBounds(10, 7, 572, 25);
		add(lblDespesasLanadasDe);

		txtValor = new JTextField();
		txtValor.setText("0,00");
		txtValor.setEnabled(false);
		txtValor.setDisabledTextColor(Color.BLACK);
		txtValor.setColumns(10);
		txtValor.setBounds(624, 410, 93, 20);
		add(txtValor);

		JLabel lblTotal = new JLabel("Total");
		lblTotal.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTotal.setBounds(464, 410, 148, 20);
		add(lblTotal);
		atualizar();

	}

	private void atualizar() {
		model.removeTudo();

		equipe = (Equipe) banco.buscarPorId(Equipe.class, equipe.getId());

		Set<DespExtra> listaDesp = (equipe.getDespExtra());
		System.out.println(listaDesp.size());
		float valorTotal = 0;
		List<DespExtra> listaDes = new ArrayList<DespExtra>(listaDesp);
		Collections.sort(listaDes);
		for (DespExtra desp : listaDes) {
			valorTotal = valorTotal + desp.getValor();
			model.addRow(desp);
		}
		txtValor.setText(String.valueOf(df.format(valorTotal)));
		equipe.setTotalDespExtra(valorTotal);

		boolean a = banco.salvarOuAtualizarObjeto(equipe);
		System.out.println(a);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String acao = e.getActionCommand();
		System.out.println(acao);

		switch (acao) {
		case "Adicionar":
			JFrmInsDespesaExtra d = new JFrmInsDespesaExtra(this.equipe);
			d.setModal(true);
			d.setVisible(true);
			atualizar();
			break;

		case "Alterar":
			DespExtra desp = (DespExtra) model.getObj(table.getSelectedRow());
			JFrmInsDespesaExtra dr = new JFrmInsDespesaExtra(this.equipe);
			dr.inserir(desp);
			dr.setModal(true);
			dr.setVisible(true);
			atualizar();
			break;
		case "Deletar":
			DespExtra carrad = (DespExtra) model.getObj(table.getSelectedRow());
			banco.deletarObjeto(carrad);
			atualizar();
			break;

		default:
			break;
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
