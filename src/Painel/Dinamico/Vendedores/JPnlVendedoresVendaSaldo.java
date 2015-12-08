package Painel.Dinamico.Vendedores;

import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.LineBorder;

import org.jboss.jandex.Main;

import Bin.Equipe.Equipe;
import Bin.Equipe.VendedorEquipe;
import Janela.Inserir.JFrmInsVendedorEquipe;
import Model.Tabela.ModelTabelaVendedorEquipe;
import Persistence.Dao;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;

import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import javax.swing.JMenuItem;

public class JPnlVendedoresVendaSaldo extends JPanel implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable table;
	private ModelTabelaVendedorEquipe model = new ModelTabelaVendedorEquipe();
	private JTextField txtChefeNome;
	private JTextField txtTotalVenda;
	private JTextField txtTotalComissao;
	private JTextField txtPromissoria;
	private JTextField txtDiferêncaViagem;
	private JTextField txtSaldoChefe;
	private JButton btnInserir;
	private Equipe equipe;
	private Dao banco = new Dao();
	private float valorTotal;
	private JTextField txtCaderno;
	private JTextField txtEntrada;
	private JTextField txtFichas;

	/**
	 * Create the
	 */
	public JPnlVendedoresVendaSaldo(Equipe equipe) {
		this.equipe = equipe;

		JPanel panel = new JPanel();
		setBounds(10, 45, 1055, 296);
		setBorder(new LineBorder(new Color(0, 0, 0)));
		add(panel);
		setLayout(null);

		JLabel foto2 = new JLabel();
		foto2.setBounds(300, 0, 40, 40);
		ImageIcon img2 = new ImageIcon(Main.class.getResource("/Imagens/013.png"));
		Image img02 = img2.getImage().getScaledInstance(foto2.getWidth(), foto2.getHeight(), Image.SCALE_DEFAULT);
		foto2.setIcon(new ImageIcon(img02));
		add(foto2);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 41, 1035, 193);
		add(scrollPane);

		table = new JTable(model);
		table.getTableHeader().setReorderingAllowed(false);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.getColumn("NOME").setPreferredWidth(200);
		scrollPane.setViewportView(table);
		JPopupMenu popupMenu = new JPopupMenu();
		addPopup(table, popupMenu);

		JMenuItem mntmDeletar = new JMenuItem("Deletar");
		mntmDeletar.addActionListener(this);
		popupMenu.add(mntmDeletar);

		JMenuItem mntmAlterar = new JMenuItem("Alterar");
		mntmAlterar.addActionListener(this);
		popupMenu.add(mntmAlterar);

		btnInserir = new JButton("Inserir");
		btnInserir.addActionListener(this);
		btnInserir.setBounds(925, 11, 120, 25);
		add(btnInserir);

		txtChefeNome = new JTextField();
		txtChefeNome.setDisabledTextColor(Color.BLACK);
		txtChefeNome.setEnabled(false);
		txtChefeNome.setBounds(10, 265, 270, 20);
		add(txtChefeNome);
		txtChefeNome.setColumns(10);

		txtTotalVenda = new JTextField();
		txtTotalVenda.setDisabledTextColor(Color.BLACK);
		txtTotalVenda.setEnabled(false);
		txtTotalVenda.setColumns(10);
		txtTotalVenda.setBounds(290, 265, 120, 20);
		add(txtTotalVenda);

		txtTotalComissao = new JTextField();
		txtTotalComissao.setDisabledTextColor(Color.BLACK);
		txtTotalComissao.setEnabled(false);
		txtTotalComissao.setColumns(10);
		txtTotalComissao.setBounds(420, 265, 120, 20);
		add(txtTotalComissao);

		txtPromissoria = new JTextField();
		txtPromissoria.setDisabledTextColor(Color.BLACK);
		txtPromissoria.setEnabled(false);
		txtPromissoria.setColumns(10);
		txtPromissoria.setBounds(550, 265, 120, 20);
		add(txtPromissoria);

		txtDiferêncaViagem = new JTextField();
		txtDiferêncaViagem.setDisabledTextColor(Color.BLACK);
		txtDiferêncaViagem.setEnabled(false);
		txtDiferêncaViagem.setColumns(10);
		txtDiferêncaViagem.setBounds(680, 265, 120, 20);
		add(txtDiferêncaViagem);

		txtSaldoChefe = new JTextField();
		txtSaldoChefe.setDisabledTextColor(Color.BLACK);
		txtSaldoChefe.setEnabled(false);
		txtSaldoChefe.setColumns(10);
		txtSaldoChefe.setBounds(810, 265, 120, 20);
		add(txtSaldoChefe);

		JLabel lblChefeDaEquipe = new JLabel("CHEFE DA EQUIPE");
		lblChefeDaEquipe.setBounds(10, 245, 270, 14);
		add(lblChefeDaEquipe);

		JLabel lblTotalVenda = new JLabel("TOTAL VENDA");
		lblTotalVenda.setBounds(290, 245, 120, 14);
		add(lblTotalVenda);

		JLabel lblComisso = new JLabel("COMISS\u00C3O");
		lblComisso.setBounds(420, 245, 120, 14);
		add(lblComisso);

		JLabel lblPromissoria = new JLabel("PROMISSORIA");
		lblPromissoria.setBounds(550, 245, 120, 14);
		add(lblPromissoria);

		JLabel lblDiferna = new JLabel("DIFER\u00CAN\u00C7A");
		lblDiferna.setBounds(680, 245, 120, 14);
		add(lblDiferna);

		JLabel lblSaldo = new JLabel("SALDO");
		lblSaldo.setBounds(810, 245, 120, 14);
		add(lblSaldo);

		JLabel lblSaldoDeVenda = new JLabel("SALDO DE VENDA DOS VENDEDORES");
		lblSaldoDeVenda.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSaldoDeVenda.setBounds(10, 11, 364, 25);
		add(lblSaldoDeVenda);

		txtCaderno = new JTextField();
		txtCaderno.setText("0.0");
		txtCaderno.setEnabled(false);
		txtCaderno.setDisabledTextColor(Color.BLACK);
		txtCaderno.setColumns(10);
		txtCaderno.setBounds(776, 10, 120, 20);
		add(txtCaderno);

		txtEntrada = new JTextField();
		txtEntrada.setText("0.0");
		txtEntrada.setEnabled(false);
		txtEntrada.setDisabledTextColor(Color.BLACK);
		txtEntrada.setColumns(10);
		txtEntrada.setBounds(516, 10, 120, 20);
		add(txtEntrada);

		JLabel lblEntradas = new JLabel("ENTRADAS");
		lblEntradas.setBounds(384, 10, 120, 20);
		add(lblEntradas);

		JLabel lblTotal = new JLabel("TOTAL CADERNO");
		lblTotal.setBounds(646, 10, 120, 20);
		add(lblTotal);

		txtFichas = new JTextField();
		txtFichas.setText("0");
		txtFichas.setEnabled(false);
		txtFichas.setDisabledTextColor(Color.BLACK);
		txtFichas.setColumns(10);
		txtFichas.setBounds(940, 265, 105, 20);
		add(txtFichas);

		JLabel lblQuantFichas = new JLabel("QUANT. FICHAS");
		lblQuantFichas.setBounds(940, 245, 105, 14);
		add(lblQuantFichas);

		inserirVendedores(equipe);

	}

	private void atualizar() {
		model.removeTudo();
		equipe = (Equipe) banco.buscarPorId(Equipe.class, equipe.getId());
		Set<VendedorEquipe> listaVendedor = equipe.getVendedor();
		valorTotal = 0;
		float valescaderno = 0;
		float entradas = 0;
		int fichas = 0;
		float comissao = 0;
		float metaVenda = 0;
		float percaVales=0;
		List<VendedorEquipe> listaVend = new ArrayList<VendedorEquipe>(listaVendedor);
		Collections.sort(listaVend);
		for (VendedorEquipe vendedor : listaVend) {
			valorTotal = valorTotal + vendedor.getvenda();
			valescaderno = valescaderno + vendedor.getValeViagem();
			entradas = entradas + vendedor.getDinheiroEntrada();
			fichas = fichas + vendedor.getQuantFicha();
			comissao = comissao + vendedor.getVlrComissaoVenda();
			if (vendedor.getSaldoVenda()<0) {
				percaVales=percaVales+(vendedor.getSaldoVenda()*-1);
			}
			
			System.out.println("venda vale local " + vendedor.getVendedor().getNome() + " =" + vendedor.getValeLocal());
			System.out.println("% de comissão é do vendedor " + vendedor.getVendedor().getNome() + " ="
					+ vendedor.getPercComissaoVenda() + " e ficou " + vendedor.getPercComissaoVenda() / 100);
			
			metaVenda = metaVenda + (vendedor.getValeLocal() / (vendedor.getPercComissaoVenda() / 100));
			System.out.println("a meta de venda do vendedor " + vendedor.getVendedor().getNome() + " ="
					+ vendedor.getValeLocal() / (vendedor.getPercComissaoVenda() / 100));
			System.out.println("_______________________________________________________________________________");

			model.addRow(vendedor);
		}
		txtTotalVenda.setText(String.valueOf(valorTotal));

		txtChefeNome.setText(equipe.getChefe().getChefe().getNome());

		txtPromissoria.setText(String.valueOf(equipe.getChefe().getValeChefe()));

		txtDiferêncaViagem.setText(String.valueOf(equipe.getVenda().getDiferenca()));

		txtTotalComissao.setText(String.valueOf(equipe.getChefe().getComissaoVenda(valorTotal)));

		txtSaldoChefe.setText(String.valueOf((valorTotal * equipe.getChefe().getPercentualVenda() / 100)
				- equipe.getChefe().getValeChefe() - equipe.getVenda().getDiferenca()));

		txtEntrada.setText(String.valueOf(entradas));
		txtCaderno.setText(String.valueOf(valescaderno));
		txtFichas.setText(String.valueOf(fichas));
		
		equipe.setDividaVendedores(percaVales);

		equipe.setMetaVenda(metaVenda);
		equipe.setComissaoVendedores(comissao);
		equipe.getVenda().setVendaPraso(valorTotal);
		equipe.getVenda().setEntradas(entradas);
		equipe.getVenda().setValeCaderno(valescaderno);
		boolean a = banco.salvarOuAtualizarObjeto(equipe.getVenda());
		a = banco.salvarOuAtualizarObjeto(equipe);
		System.out.println("salvo os dados " + a);
		System.out.println(equipe.getVenda().getEntradas());
		validate();

	}

	private void inserirVendedores(Equipe equipes) {
		model.removeTudo();
		float venda = 0;

		for (VendedorEquipe vendedor : equipes.getVendedor()) {
			model.addRow(vendedor);
			venda = venda + vendedor.getvenda();

		}
		txtTotalVenda.setText(String.valueOf(venda));
		txtChefeNome
				.setText(equipes.getChefe().getChefe().getNome() + " " + equipes.getChefe().getChefe().getSobrenome());
		float comissao = equipes.getChefe().getPercentualVenda() * venda;
		txtTotalComissao.setText(String.valueOf(comissao));
		float promissoria = equipes.getChefe().getValeChefe();
		txtPromissoria.setText(String.valueOf(promissoria));
		float diferenca = equipes.getVenda().getDiferenca();
		txtDiferêncaViagem.setText(String.valueOf(diferenca));
		txtSaldoChefe.setText(String.valueOf(comissao - promissoria - diferenca));

		atualizar();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String acao = e.getActionCommand();

		switch (acao) {
		case "Inserir":
			JFrmInsVendedorEquipe iqui = new JFrmInsVendedorEquipe(equipe);
			iqui.setModal(true);
			iqui.moduloVenda();
			iqui.setVisible(true);
			atualizar();

			break;
		case "Alterar":
			VendedorEquipe vendEqui = (VendedorEquipe) model.getObj(table.getSelectedRow());
			JFrmInsVendedorEquipe a = new JFrmInsVendedorEquipe(equipe);
			a.inserir(vendEqui);
			a.setModal(true);
			a.moduloVenda();
			a.setVisible(true);
			atualizar();

			break;
		case "Deletar":
			VendedorEquipe v = (VendedorEquipe) model.getObj(table.getSelectedRow());
			banco.deletarObjeto(v);
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
