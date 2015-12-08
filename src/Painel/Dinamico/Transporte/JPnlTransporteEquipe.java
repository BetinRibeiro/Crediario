package Painel.Dinamico.Transporte;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import Bin.Equipe.Equipe;
import Bin.Transporte.TransporteViagem;
import Janela.Inserir.JFrmTransporteEquipe;
import Model.Tabela.ModelTabelaEquipeTransporteVenda;
import Persistence.Dao;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

import org.jboss.jandex.Main;

import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import java.awt.Color;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JMenuItem;

public class JPnlTransporteEquipe extends JPanel implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable table;
	private ModelTabelaEquipeTransporteVenda model = new ModelTabelaEquipeTransporteVenda();
	private Equipe equipeLocal;
	private Dao banco = new Dao();
	private float valorTotal;
	private JTextField txtValorManutencao;

	/**
	 * Create the panel.
	 * 
	 * @param equipe
	 */
	public JPnlTransporteEquipe(Equipe equipe) {
		equipeLocal = equipe;
		setBounds(0, 0, 1055, 207);
		setLayout(null);
		JLabel foto2 = new JLabel();
		foto2.setBounds(880, 0, 40, 40);
		ImageIcon img2 = new ImageIcon(Main.class.getResource("/Imagens/031.png"));
		Image img02 = img2.getImage().getScaledInstance(foto2.getWidth(), foto2.getHeight(), Image.SCALE_DEFAULT);
		foto2.setIcon(new ImageIcon(img02));
		add(foto2);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 40, 1035, 130);
		add(scrollPane);

		table = new JTable(model);
		table.getTableHeader().setReorderingAllowed(false);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.getColumn("TRANSPORTE").setPreferredWidth(200);
		scrollPane.setViewportView(table);

		JPopupMenu popupMenu = new JPopupMenu();
		addPopup(table, popupMenu);

		JMenuItem mntmDeletar = new JMenuItem("Deletar");
		mntmDeletar.addActionListener(this);
		popupMenu.add(mntmDeletar);

		JMenuItem mntmAlterar = new JMenuItem("Alterar");
		mntmAlterar.addActionListener(this);
		popupMenu.add(mntmAlterar);

		JLabel lblTransportesDaEquipe = new JLabel("TRANSPORTES DA EQUIPE");
		lblTransportesDaEquipe.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTransportesDaEquipe.setBounds(10, 10, 216, 25);
		add(lblTransportesDaEquipe);

		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.addActionListener(this);

		btnAdicionar.setBounds(925, 10, 120, 25);
		add(btnAdicionar);

		JLabel lblValorDaManuteno = new JLabel("Valor da Manuten\u00E7\u00E3o");
		lblValorDaManuteno.setHorizontalAlignment(SwingConstants.RIGHT);
		lblValorDaManuteno.setBounds(10, 176, 148, 20);
		add(lblValorDaManuteno);

		txtValorManutencao = new JTextField();
		txtValorManutencao.setText("0.0");
		txtValorManutencao.setEnabled(false);
		txtValorManutencao.setDisabledTextColor(Color.BLACK);
		txtValorManutencao.setColumns(10);
		txtValorManutencao.setBounds(170, 176, 93, 20);
		add(txtValorManutencao);
		atualizar();

	}

	private void atualizar() {
		model.removeTudo();

		equipeLocal = (Equipe) banco.buscarPorId(Equipe.class, equipeLocal.getId());

		Set<TransporteViagem> listaTrans = equipeLocal.getTraspViagem();
		System.out.println(listaTrans.size());
		valorTotal = 0;
		List<TransporteViagem> listaTr = new ArrayList<TransporteViagem>(listaTrans);
		Collections.sort(listaTr);
		for (TransporteViagem transporte : listaTr) {
			valorTotal = valorTotal + transporte.getManutencao();
			model.addRow(transporte);
		}
		txtValorManutencao.setText(String.valueOf(valorTotal));

		equipeLocal.setValorManutencao(valorTotal);
		banco.salvarOuAtualizarObjeto(equipeLocal);
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

	@Override
	public void actionPerformed(ActionEvent e) {
		String acao = e.getActionCommand();

		System.out.println(acao);

		switch (acao) {
		case "Adicionar":
			JFrmTransporteEquipe cadCar = new JFrmTransporteEquipe(equipeLocal);
			cadCar.setModal(true);
			cadCar.setVisible(true);
			atualizar();
			break;
		case "Alterar":
			TransporteViagem transporte = (TransporteViagem) model.getObj(table.getSelectedRow());
			JFrmTransporteEquipe altCar = new JFrmTransporteEquipe(equipeLocal);
			altCar.inserir(transporte);
			altCar.setModal(true);
			altCar.setVisible(true);
			atualizar();
			break;
		case "Deletar":
			TransporteViagem transportee = (TransporteViagem) model.getObj(table.getSelectedRow());
			banco.deletarObjeto(transportee);
			atualizar();
			break;

		default:
			break;
		}

	}
}
