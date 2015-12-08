package Painel.Dinamico.Mercadoria;

import javax.swing.JPanel;

import Bin.Equipe.Equipe;
import Bin.Retorno.Retorno;
import Janela.Equipe.Cadastro.JFrmCadRetorno;
import Model.Tabela.ModelTabelaRetorno;
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
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class JPnlMercadoriaRetorno extends JPanel implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtTotalRetorno;
	private JTable table;
	private JButton btnAdicionar;
	private Equipe equipeLocal;
	private ModelTabelaRetorno model = new ModelTabelaRetorno();
	private Dao banco = new Dao();
	private float valorTotal;
	DecimalFormat df = new DecimalFormat("0.00");
	private JTextField txtCusto;

	/**
	 * Create the
	 */
	public JPnlMercadoriaRetorno(Equipe equipe) {
		this.equipeLocal = equipe;
		setLayout(null);
		setBounds(0, 0, 1055, 250);
		JLabel foto2 = new JLabel();
		foto2.setBounds(880, 0, 40, 40);
		ImageIcon img2 = new ImageIcon(Main.class.getResource("/Imagens/001.png"));
		Image img02 = img2.getImage().getScaledInstance(foto2.getWidth(), foto2.getHeight(), Image.SCALE_DEFAULT);
		foto2.setIcon(new ImageIcon(img02));
		add(foto2);

		JLabel label = new JLabel("Valor dos Retornos");
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setBounds(10, 210, 148, 20);
		add(label);

		txtTotalRetorno = new JTextField();
		txtTotalRetorno.setEnabled(false);
		txtTotalRetorno.setDisabledTextColor(Color.BLACK);
		txtTotalRetorno.setColumns(10);
		txtTotalRetorno.setBounds(170, 210, 93, 20);
		add(txtTotalRetorno);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 41, 1035, 160);
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

		JLabel label_1 = new JLabel("RETORNOS RECEBIDOS");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_1.setBounds(10, 11, 216, 25);
		add(label_1);

		btnAdicionar = new JButton("Adicionar");
		btnAdicionar.setBounds(925, 10, 120, 25);
		btnAdicionar.addActionListener(this);
		add(btnAdicionar);

		JLabel lblCustoTotalRetorno = new JLabel("Custo Total Retorno");
		lblCustoTotalRetorno.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCustoTotalRetorno.setBounds(284, 210, 148, 20);
		add(lblCustoTotalRetorno);

		txtCusto = new JTextField();
		txtCusto.setText("0,00");
		txtCusto.setEnabled(false);
		txtCusto.setDisabledTextColor(Color.BLACK);
		txtCusto.setColumns(10);
		txtCusto.setBounds(444, 210, 93, 20);
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
		try {

			Retorno retorno = (Retorno) model.getObj(table.getSelectedRow());
			JFrmCadRetorno altCar = new JFrmCadRetorno();
			altCar.inserirRetorno(retorno);
			altCar.setModal(true);
			altCar.setVisible(true);
			atualizar();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, e.getMessage());
		}
	}

	private void deletar() {
		try {

			Retorno carrad = (Retorno) model.getObj(table.getSelectedRow());
			banco.deletarObjeto(carrad);
			atualizar();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, e.getMessage());
		}
	}

	private void adicionar() {
		try {
			
	
		JFrmCadRetorno cadCar = new JFrmCadRetorno();
		cadCar.setEquipe(equipeLocal);
		cadCar.setModal(true);
		cadCar.setVisible(true);
		atualizar();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, e.getMessage());
		}
	}

	private void atualizar() {
		try {
			
		
		model.removeTudo();

		equipeLocal = (Equipe) banco.buscarPorId(Equipe.class, equipeLocal.getId());

		Set<Retorno> listaRetorno = equipeLocal.getRetorno();
		System.out.println(listaRetorno.size());
		valorTotal = 0;
		float custo = 0;
		List<Retorno> listRet = new ArrayList<Retorno>(listaRetorno);
		Collections.sort(listRet);

		for (Retorno retorno : listRet) {
			valorTotal = valorTotal + retorno.getValor();
			custo = custo + retorno.getCusto();
			model.addRow(retorno);
		}
		txtTotalRetorno.setText(String.valueOf(df.format(valorTotal)));

		txtCusto.setText(String.valueOf(df.format(custo)));
		equipeLocal.getVenda().setCustoRetorno(custo);
		equipeLocal.getVenda().setRetorno(valorTotal);
		equipeLocal.setCustoRetornos(custo);
		equipeLocal.setPrecoRetornos(valorTotal);
		boolean a = banco.salvarOuAtualizarObjeto(equipeLocal.getVenda());
		a = banco.salvarOuAtualizarObjeto(equipeLocal);
		System.out.println("Salvou retorno " + a);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, e.getMessage());
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
