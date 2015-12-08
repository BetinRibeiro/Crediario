package Painel.Dinamico.Mercadoria;

import javax.swing.JPanel;

import Bin.Equipe.Equipe;
import Bin.Devolucao.Devolucao;
import Janela.Equipe.Cadastro.JFrmCadDevolucao;
import Model.Tabela.ModelTabelaDevolucao;
import Persistence.Dao;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import org.jboss.jandex.Main;

import javax.swing.JTextField;
import javax.swing.JScrollPane;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DecimalFormat;
import java.util.Set;

import javax.swing.JMenuItem;

public class JPnlMercadoriaDevolucao extends JPanel implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtTotalDevolucao;
	private JTable table;
	private JButton btnAdicionar;
	private Equipe equipeLocal;
	private ModelTabelaDevolucao model = new ModelTabelaDevolucao();
	private Dao banco = new Dao();
	private float valorTotal;
	DecimalFormat df = new DecimalFormat("0.00");
	private JTextField txtCusto;

	/**
	 * Create the
	 */
	public JPnlMercadoriaDevolucao(Equipe equipe) {
		this.equipeLocal = equipe;
		setLayout(null);
		setBounds(0, 0, 1055, 250);
		JLabel foto2 = new JLabel();
		foto2.setBounds(880, 0, 40, 40);
		ImageIcon img2 = new ImageIcon(Main.class.getResource("/Imagens/003.png"));
		Image img02 = img2.getImage().getScaledInstance(foto2.getWidth(), foto2.getHeight(), Image.SCALE_DEFAULT);
		foto2.setIcon(new ImageIcon(img02));
		add(foto2);

		JLabel label = new JLabel("Valor dos Devolucaos");
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setBounds(10, 189, 148, 20);
		add(label);

		txtTotalDevolucao = new JTextField();
		txtTotalDevolucao.setEnabled(false);
		txtTotalDevolucao.setDisabledTextColor(Color.BLACK);
		txtTotalDevolucao.setColumns(10);
		txtTotalDevolucao.setBounds(170, 189, 93, 20);
		add(txtTotalDevolucao);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 41, 1035, 137);
		add(scrollPane);

		table = new JTable(model);
		scrollPane.setViewportView(table);

		JPopupMenu popupMenu = new JPopupMenu();
		addPopup(table, popupMenu);

		JMenuItem mntmDeletar = new JMenuItem("Deletar");
		mntmDeletar.addActionListener(this);
		popupMenu.add(mntmDeletar);

		JMenuItem mntmAlterar = new JMenuItem("Alterar");
		mntmAlterar.addActionListener(this);
		popupMenu.add(mntmAlterar);

		JLabel lblDevoluesRecebidos = new JLabel("DEVOLU\u00C7\u00D5ES RECEBIDAS");
		lblDevoluesRecebidos.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDevoluesRecebidos.setBounds(10, 11, 216, 25);
		add(lblDevoluesRecebidos);

		btnAdicionar = new JButton("Adicionar");
		btnAdicionar.setBounds(925, 10, 120, 25);
		btnAdicionar.addActionListener(this);
		add(btnAdicionar);

		JLabel lblCustoTotalDevolucao = new JLabel("Custo Total Devolucao");
		lblCustoTotalDevolucao.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCustoTotalDevolucao.setBounds(284, 189, 148, 20);
		add(lblCustoTotalDevolucao);

		txtCusto = new JTextField();
		txtCusto.setText("0,00");
		txtCusto.setEnabled(false);
		txtCusto.setDisabledTextColor(Color.BLACK);
		txtCusto.setColumns(10);
		txtCusto.setBounds(444, 189, 93, 20);
		add(txtCusto);
		atualizar();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String acao = e.getActionCommand();

		switch (acao) {
		case "Adicionar":
			adicionar();
			break;
		case "Deletar":
			deletar();
			break;
		case "Alterar":
			alterar();
			break;

		default:
			break;
		}
	}

	private void alterar() {
		Devolucao devolucao = (Devolucao) model.getObj(table.getSelectedRow());
		JFrmCadDevolucao altCar = new JFrmCadDevolucao();
		altCar.inserirDevolucao(devolucao);
		altCar.setModal(true);
		altCar.setVisible(true);
		atualizar();
	}

	private void deletar() {
		Devolucao carrad = (Devolucao) model.getObj(table.getSelectedRow());
		banco.deletarObjeto(carrad);
		atualizar();
	}

	private void adicionar() {
		JFrmCadDevolucao cadCar = new JFrmCadDevolucao();
		cadCar.setEquipe(equipeLocal);
		cadCar.setModal(true);
		cadCar.setVisible(true);
		atualizar();
	}

	private void atualizar() {
		model.removeTudo();

		equipeLocal = (Equipe) banco.buscarPorId(Equipe.class, equipeLocal.getId());

		Set<Devolucao> listaDevolucao = equipeLocal.getDevolucao();
		System.out.println(listaDevolucao.size());
		valorTotal = 0;
		float custo = 0;
		for (Devolucao devolucao : listaDevolucao) {
			valorTotal = valorTotal + devolucao.getValor();
			custo = custo + devolucao.getCusto();
			model.addRow(devolucao);
		}
		txtTotalDevolucao.setText(String.valueOf(df.format(valorTotal)));

		equipeLocal.setCustoDevolucao(custo);
		equipeLocal.setPrecoDevolucao(valorTotal);
		txtCusto.setText(String.valueOf(df.format(custo)));
		boolean a = banco.salvarOuAtualizarObjeto(equipeLocal.getVenda());
		a = banco.salvarOuAtualizarObjeto(equipeLocal);
		System.out.println("Salvou devolucao " + a);
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
