package Painel.Dinamico.Vendedores;

import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.LineBorder;

import org.jboss.jandex.Main;

import Bin.Equipe.Equipe;
import Bin.Equipe.VendedorEquipe;
import Janela.Inserir.JFrmInsVendedorEquipe;
import Model.Tabela.ModelTabelaVendedorEquipeCobranca;
import Persistence.Dao;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;

import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DecimalFormat;
import java.util.Set;

import javax.swing.JMenuItem;

public class JPnlVendedoresCobrancaQuitacao extends JPanel implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Equipe equipe;
	private Dao banco = new Dao();
	private JTextField txtChefe;
	private JTextField txtVenda;
	private JTextField txtComissaoVenda;
	private JTextField txtCobranca;
	private JTextField txtComissaoCobranca;
	private JTextField txtSaldo;
	private JTable table;
	private ModelTabelaVendedorEquipeCobranca model = new ModelTabelaVendedorEquipeCobranca();

	DecimalFormat df = new DecimalFormat("0.00");

	/**
	 * Create the
	 */
	public JPnlVendedoresCobrancaQuitacao(Equipe equipe) {
		this.equipe = equipe;

		JPanel panel = new JPanel();
		setBounds(10, 45, 1055, 296);
		setBorder(new LineBorder(new Color(0, 0, 0)));
		add(panel);
		setLayout(null);
		JLabel foto2 = new JLabel();
		foto2.setBounds(300, 0, 40, 40);
		ImageIcon img2 = new ImageIcon(Main.class.getResource("/Imagens/015.png"));
		Image img02 = img2.getImage().getScaledInstance(foto2.getWidth(), foto2.getHeight(), Image.SCALE_DEFAULT);
		foto2.setIcon(new ImageIcon(img02));
		add(foto2);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 43, 1035, 166);
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

		JLabel label = new JLabel("SALDO DA COBRAN\u00C7A");
		label.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label.setBounds(10, 11, 364, 25);
		add(label);

		txtChefe = new JTextField();
		txtChefe.setEnabled(false);
		txtChefe.setColumns(10);
		txtChefe.setBounds(10, 239, 270, 20);
		add(txtChefe);

		txtVenda = new JTextField();
		txtVenda.setEnabled(false);
		txtVenda.setColumns(10);
		txtVenda.setBounds(290, 239, 120, 20);
		add(txtVenda);

		txtComissaoVenda = new JTextField();
		txtComissaoVenda.setEnabled(false);
		txtComissaoVenda.setColumns(10);
		txtComissaoVenda.setBounds(420, 239, 120, 20);
		add(txtComissaoVenda);

		txtCobranca = new JTextField();
		txtCobranca.setEnabled(false);
		txtCobranca.setColumns(10);
		txtCobranca.setBounds(550, 239, 120, 20);
		add(txtCobranca);

		txtComissaoCobranca = new JTextField();
		txtComissaoCobranca.setEnabled(false);
		txtComissaoCobranca.setColumns(10);
		txtComissaoCobranca.setBounds(680, 239, 120, 20);
		add(txtComissaoCobranca);

		txtSaldo = new JTextField();
		txtSaldo.setEnabled(false);
		txtSaldo.setColumns(10);
		txtSaldo.setBounds(810, 239, 120, 20);
		add(txtSaldo);

		JLabel label_1 = new JLabel("CHEFE DA EQUIPE");
		label_1.setBounds(10, 219, 270, 14);
		add(label_1);

		JLabel label_2 = new JLabel("TOTAL VENDA");
		label_2.setBounds(290, 219, 120, 14);
		add(label_2);

		JLabel label_3 = new JLabel("COMISS\u00C3O");
		label_3.setBounds(420, 219, 120, 14);
		add(label_3);

		JLabel label_4 = new JLabel("COBRAN\u00C7A");
		label_4.setBounds(550, 219, 120, 14);
		add(label_4);

		JLabel label_5 = new JLabel("COMISS\u00C3O");
		label_5.setBounds(680, 219, 120, 14);
		add(label_5);

		JLabel label_6 = new JLabel("SALDO");
		label_6.setBounds(810, 219, 120, 14);
		add(label_6);

		inserirVendedores(equipe);

	}

	private void atualizar() {
		model.removeTudo();
		equipe = (Equipe) banco.buscarPorId(Equipe.class, equipe.getId());
		Set<VendedorEquipe> listaVendedor = equipe.getVendedor();
		System.out.println(listaVendedor.size());
		float quitado = 0;
		float divida = 0;
		float recebidoParcial = 0;
		float devolvido = 0;
		float perdidoParcial = 0;
		float perdido = 0;
		float vales = 0;
		float comissao = 0;
		float totalFichas = 0;
		for (VendedorEquipe vendedor : listaVendedor) {
			if (vendedor.getSaldoVenda() < 0) {
				divida = divida + vendedor.getSaldoVenda();
			}
			comissao = comissao + vendedor.getVlrComissaoVenda();
			quitado = quitado + vendedor.getquitado();
			perdido = perdido + vendedor.getPerca();
			devolvido = devolvido + vendedor.getdevolvido();
			recebidoParcial = recebidoParcial + vendedor.getquitadoParcial();
			perdidoParcial = perdidoParcial + vendedor.getPercaParcial();
			vales = vales + vendedor.getValeLocal();
			totalFichas=totalFichas+vendedor.getQuantFicha();
			model.addRow(vendedor);
		}
		equipe.setTotalFichas(totalFichas);
		equipe.setComissaoVendedores(comissao);
		equipe.setDividaVendedores(-divida);
		equipe.setValesVendedores(vales);
		equipe.getCobranca().setQuitado(quitado);
		equipe.getCobranca().setDevolvido(devolvido);
		equipe.getCobranca().setPerdido(perdido);
		equipe.getCobranca().setPerdidoParcial(perdidoParcial);
		equipe.getCobranca().setRecebidoParcial(recebidoParcial);

		boolean a = banco.salvarOuAtualizarObjeto(equipe.getCobranca());
		System.out.println("salvo os dados " + a);
		System.out.println(equipe.getVenda().getEntradas());
		txtChefe.setText(equipe.getChefe().getChefe().getNome());
		txtVenda.setText(String.valueOf(df.format(equipe.getVenda().getVendaPraso())));
		float saldoVenda = equipe.getChefe().getComissaoVenda(equipe.getVenda().getVendaPraso());
		txtComissaoVenda.setText(String.valueOf(df.format(saldoVenda)));
		txtCobranca.setText(String.valueOf(df.format(equipe.getCobranca().getRecebidoTotal())));
		equipe.getChefe().setPercentualCobranca(5);
		System.out.println(equipe.getCobranca().getRecebidoTotal() + " - Recebido Total");
		float saldoCobraca = equipe.getChefe().getComissaoCobranca(equipe.getCobranca().getRecebidoTotal());
		txtComissaoCobranca.setText(String.valueOf(df.format(saldoCobraca)));
		txtSaldo.setText(String.valueOf(df.format(saldoCobraca - saldoVenda)));
		validate();

	}

	private void inserirVendedores(Equipe equipes) {
		model.removeTudo();
		float venda = 0;

		for (VendedorEquipe vendedor : equipes.getVendedor()) {
			model.addRow(vendedor);
			venda = venda + vendedor.getvenda();

		}

		atualizar();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String acao = e.getActionCommand();

		switch (acao) {

		case "Alterar":
			VendedorEquipe vendEqui = (VendedorEquipe) model.getObj(table.getSelectedRow());
			JFrmInsVendedorEquipe a = new JFrmInsVendedorEquipe(equipe);
			a.inserir(vendEqui);
			a.setModal(true);
			a.moduloCobranca();
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
