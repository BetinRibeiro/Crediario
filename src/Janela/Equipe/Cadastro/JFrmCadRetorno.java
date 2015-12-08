package Janela.Equipe.Cadastro;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;

import Bin.Equipe.Equipe;
import Bin.Produto.Produto;
import Bin.Retorno.ItemRetorno;
import Bin.Retorno.Retorno;
import Janela.Pesquisa.JFrmPesProduto;
import Model.Tabela.ModelTabelaItemRetorno;
import Persistence.Dao;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.swing.JMenuItem;
import javax.swing.SwingConstants;

public class JFrmCadRetorno extends JDialog implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtId;
	private JTextField txtItemRetornoID;
	private JTextField txtItemRetornoDescricao;
	private JTextField txtQuantidade;
	private JTextField txtPreco;
	private JTextField txtCusto;
	private JTextField txtIdEquipe;
	private JTable table;
	private JTextField txtCustoTotal;
	private ModelTabelaItemRetorno model = new ModelTabelaItemRetorno();
	private JButton btnCancelar;
	private JButton btnFinalizar;
	private Dao banco = new Dao();
	private JButton btnBuscar;
	private JButton btnInserir;
	private JMenuItem mntmAlterar;
	private JDateChooser dtRetorno;

	private Equipe equipe;
	private Retorno retorno;
	private ItemRetorno itemAlterando;
	private JTextField txtTotalGeral;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			JFrmCadRetorno dialog = new JFrmCadRetorno();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public JFrmCadRetorno() {

		setTitle("Cadastro de Retorno");
		setBounds(100, 100, 692, 486);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		setAlwaysOnTop(true);
		setLocationRelativeTo(null);
		{
			JLabel lblCodigo = new JLabel("C\u00F3digo");
			lblCodigo.setBounds(10, 10, 87, 14);
			contentPanel.add(lblCodigo);
		}
		{
			txtId = new JTextField();
			txtId.setBackground(new Color(255, 250, 205));
			txtId.setEnabled(false);
			txtId.setBounds(10, 30, 87, 20);
			contentPanel.add(txtId);
			txtId.setColumns(10);
		}
		{
			JLabel label = new JLabel("C\u00F3digo");
			label.setBounds(10, 60, 87, 14);
			contentPanel.add(label);
		}
		{
			txtItemRetornoID = new JTextField();
			txtItemRetornoID.setBackground(new Color(255, 250, 205));
			txtItemRetornoID.setEnabled(false);
			txtItemRetornoID.setColumns(10);
			txtItemRetornoID.setBounds(10, 80, 87, 20);
			contentPanel.add(txtItemRetornoID);
		}
		{
			JLabel lblDescrio = new JLabel("Descri\u00E7\u00E3o");
			lblDescrio.setBounds(112, 60, 234, 14);
			contentPanel.add(lblDescrio);
		}
		{
			txtItemRetornoDescricao = new JTextField();
			txtItemRetornoDescricao.setBackground(new Color(255, 250, 205));
			txtItemRetornoDescricao.setEnabled(false);
			txtItemRetornoDescricao.setColumns(10);
			txtItemRetornoDescricao.setBounds(112, 80, 234, 20);
			contentPanel.add(txtItemRetornoDescricao);
		}
		{
			txtQuantidade = new JTextField();
			txtQuantidade.setEnabled(false);
			txtQuantidade.setColumns(10);
			txtQuantidade.setBounds(10, 135, 87, 20);
			contentPanel.add(txtQuantidade);
		}
		{
			JLabel lblQuantidade = new JLabel("Quantidade");
			lblQuantidade.setBounds(10, 115, 87, 14);
			contentPanel.add(lblQuantidade);
		}
		{
			txtPreco = new JTextField();
			txtPreco.setEnabled(false);
			txtPreco.setColumns(10);
			txtPreco.setBounds(112, 135, 87, 20);
			contentPanel.add(txtPreco);
		}
		{
			JLabel lblPreo = new JLabel("Pre\u00E7o");
			lblPreo.setBounds(112, 115, 87, 14);
			contentPanel.add(lblPreo);
		}
		{
			txtCusto = new JTextField();
			txtCusto.setEnabled(false);
			txtCusto.setColumns(10);
			txtCusto.setBounds(210, 135, 87, 20);
			contentPanel.add(txtCusto);
		}
		{
			JLabel lblCusto = new JLabel("Custo");
			lblCusto.setBounds(212, 115, 85, 14);
			contentPanel.add(lblCusto);
		}
		{
			btnBuscar = new JButton("Buscar");
			btnBuscar.setBounds(369, 79, 89, 23);
			btnBuscar.addActionListener(this);
			contentPanel.add(btnBuscar);
		}
		{
			btnInserir = new JButton("Inserir");
			btnInserir.setEnabled(false);
			btnInserir.setBounds(307, 134, 89, 23);
			btnInserir.addActionListener(this);
			contentPanel.add(btnInserir);
		}
		{
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 179, 652, 154);
			contentPanel.add(scrollPane);

			{
				table = new JTable(model);
				scrollPane.setViewportView(table);
			}
			{
				JPopupMenu popupMenu = new JPopupMenu();
				addPopup(table, popupMenu);

				JMenuItem mntmRemover = new JMenuItem("Remover");
				popupMenu.add(mntmRemover);
				{
					mntmAlterar = new JMenuItem("Alterar");
					popupMenu.add(mntmAlterar);
					mntmAlterar.addActionListener(this);
				}
				mntmRemover.addActionListener(this);
			}
		}
		{
			txtIdEquipe = new JTextField();
			txtIdEquipe.setBackground(new Color(255, 250, 205));
			txtIdEquipe.setEnabled(false);
			txtIdEquipe.setColumns(10);
			txtIdEquipe.setBounds(572, 30, 94, 20);
			contentPanel.add(txtIdEquipe);

		}
		{
			JLabel lblCdigoDaVenda = new JLabel("C\u00F3digo da Equipe");
			lblCdigoDaVenda.setHorizontalAlignment(SwingConstants.RIGHT);
			lblCdigoDaVenda.setBounds(547, 10, 119, 14);
			contentPanel.add(lblCdigoDaVenda);
		}
		{
			txtCustoTotal = new JTextField();
			txtCustoTotal.setBounds(572, 78, 94, 22);
			contentPanel.add(txtCustoTotal);
			txtCustoTotal.setBackground(new Color(255, 250, 205));
			txtCustoTotal.setFont(new Font("Tahoma", Font.BOLD, 13));
			txtCustoTotal.setEnabled(false);
			txtCustoTotal.setColumns(10);
		}
		{
			JLabel lblCustoTotal = new JLabel("Custo Total");
			lblCustoTotal.setBounds(572, 60, 94, 14);
			contentPanel.add(lblCustoTotal);
		}

		JLabel lblData = new JLabel("Data");
		lblData.setBounds(10, 375, 68, 14);
		contentPanel.add(lblData);

		dtRetorno = new JDateChooser(new java.util.Date());
		dtRetorno.setBounds(83, 372, 116, 20);
		contentPanel.add(dtRetorno);

		JLabel lblVendaTotal = new JLabel("Custo Total");
		lblVendaTotal.setBounds(572, 115, 94, 14);
		contentPanel.add(lblVendaTotal);

		txtTotalGeral = new JTextField();
		txtTotalGeral.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtTotalGeral.setEnabled(false);
		txtTotalGeral.setColumns(10);
		txtTotalGeral.setBackground(new Color(255, 250, 205));
		txtTotalGeral.setBounds(572, 133, 94, 22);
		contentPanel.add(txtTotalGeral);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btnFinalizar = new JButton("Finalizar");
				btnFinalizar.setEnabled(false);
				btnFinalizar.setActionCommand("Finalizar");
				buttonPane.add(btnFinalizar);
				getRootPane().setDefaultButton(btnFinalizar);
				btnFinalizar.addActionListener(this);
			}
			{
				btnCancelar = new JButton("Cancelar");
				btnCancelar.setActionCommand("Cancelar");
				buttonPane.add(btnCancelar);
				btnCancelar.addActionListener(this);
			}

		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String acao = e.getActionCommand();

		switch (acao) {
		case "Buscar":
			buscar();
			System.out.println("fim do buscar");
			break;
		case "Cancelar":
			dispose();
			break;

		case "Finalizar":
			salvar();
			break;
		case "Inserir":
			inserir();
			valorTotal();
			break;

		case "Remover":
			remover();
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

			itemAlterando = remover();

			if (itemAlterando != null) {

				txtItemRetornoDescricao.setText(itemAlterando.getProduto().getDescricao());
				txtItemRetornoID.setText(String.valueOf(itemAlterando.getProduto().getId()));
				txtQuantidade.setText(String.valueOf(itemAlterando.getQuantidade()));
				txtPreco.setText(String.valueOf(itemAlterando.getValor()));
				txtCusto.setText(String.valueOf(itemAlterando.getCusto()));

				txtQuantidade.setEnabled(true);
				txtPreco.setEnabled(true);
				txtCusto.setEnabled(true);

				btnInserir.setEnabled(true);
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(contentPanel, e.getMessage());
		}

	}

	private void valorTotal() {
		try {
			float valorPreco = 0;
			float valor = 0;
			System.out.println(valor);
			for (int i = 0; i < model.getRowCount(); i++) {
				String a = String.valueOf(table.getValueAt(i, 5));
				String d = String.valueOf(table.getValueAt(i, 6));
				System.out.println((table.getValueAt(i, 5)).getClass());
				valor = valor + ((Float.parseFloat(a.replace(",", "."))));
				valorPreco = valorPreco + ((Float.parseFloat(d.replace(",", "."))));
			}
			txtCustoTotal.setText(String.valueOf(valor));
			txtTotalGeral.setText(String.valueOf(valorPreco));
		} catch (Exception e) {
			JOptionPane.showMessageDialog(contentPanel, e.getMessage());
			dispose();
		}
	}

	private ItemRetorno remover() {
		 try {
		ItemRetorno itemSelecionado = (ItemRetorno) model.getObj(table.getSelectedRow());
		System.out.println(itemSelecionado.getProduto().getDescricao());

		// retorno.getRetorno().remove(itemSelecionado.getId());
		boolean a = banco.deletarObjeto(itemSelecionado);
		System.out.println("item removido com sucesso" + a);
		// retorno.getItemRetorno().remove(itemremovido);
		// a = banco.salvarObjeto(retorno);
		if (a) {
			System.out.println("retorno salva com sucesso" + a);
			model.removeRow(table.getSelectedRow());
			if (model.getRowCount() <= 0) {
				btnFinalizar.setEnabled(false);
				return itemSelecionado;
			}

		}
		return null;

		 } catch (Exception e) {
		 JOptionPane.showMessageDialog(contentPanel, e.getMessage());
		 return null;
		 }
	}

	private void inserir() {
		try {
			Produto prod = (Produto) banco.buscarPorId(Produto.class, Integer.parseInt(txtItemRetornoID.getText()));
			System.out.println(txtItemRetornoID.getText());
			System.out.println(prod.getDescricao());
			ItemRetorno itemRetorno = new ItemRetorno();
			itemRetorno.setProduto(prod);
			itemRetorno.setCusto(Float.parseFloat(txtCusto.getText().replace(",", ".")));
			itemRetorno.setQuantidade(Float.parseFloat(txtQuantidade.getText().replace(",", ".")));
			itemRetorno.setValor(Float.parseFloat(txtPreco.getText().replace(",", ".")));
			boolean salvo = true;
			for (int i = 0; i < model.getRowCount(); i++) {
				if (itemRetorno.getProduto().getId().equals(model.getValueAt(i, 0))) {
					JOptionPane.showMessageDialog(contentPanel, "Produto Igual, remova o ItemRetorno inserido.");
					salvo = false;
				}
			}
			if (salvo) {
				model.addRow(itemRetorno);
				btnFinalizar.setEnabled(true);
			}
			limpatxt();
		} catch (java.lang.NumberFormatException e) {
			JOptionPane.showMessageDialog(contentPanel, "Insira numeros validos nos campos de quantidade e valor.");

		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e);
			JOptionPane.showMessageDialog(contentPanel, e.getMessage());
		}
	}

	private void limpatxt() {
		try {
			txtCusto.setText("");
			txtPreco.setText("");
			txtQuantidade.setText("");
			txtItemRetornoDescricao.setText("");
			txtItemRetornoID.setText("");
			btnInserir.setEnabled(false);
			txtCusto.setEnabled(false);
			txtQuantidade.setEnabled(false);
			txtPreco.setEnabled(false);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(contentPanel, e.getMessage());
			dispose();
		}
	}

	private void buscar() {
		try {

			JFrmPesProduto prod = new JFrmPesProduto();
			prod.moduloEscolher();
			prod.setModal(true);
			prod.setVisible(true);
			Produto p = (Produto) prod.getObj();
			txtItemRetornoID.setText(String.valueOf(p.getId()));
			txtItemRetornoDescricao.setText(String.valueOf(p.getDescricao()));
			prod.dispose();
			btnInserir.setEnabled(true);
			txtQuantidade.setEnabled(true);
			txtPreco.setEnabled(true);
			txtCusto.setEnabled(true);
			System.out.println("aqui");
		} catch (java.lang.NullPointerException e) {
			JOptionPane.showMessageDialog(contentPanel, "Escolha um ItemRetorno para inserir");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(contentPanel, e.getMessage());
			dispose();
		}

	}

	private void salvar() {
		 try {
			
		

		Equipe equipe = (Equipe) banco.buscarPorId(Equipe.class, Integer.parseInt(txtIdEquipe.getText()));
		System.out.println("id da equipe " + equipe.getId());
		float valorTotal = Float.parseFloat(txtTotalGeral.getText());
		Date data = dtRetorno.getDate();
		float custo = Float.parseFloat(txtCustoTotal.getText());
		System.out.println(equipe.getTitulo() + " " + equipe.getId());
		Retorno retorno = new Retorno(data, custo, valorTotal, equipe);

		Set<ItemRetorno> itemretorno = new HashSet<ItemRetorno>();

		ArrayList<ItemRetorno> array = (ArrayList<ItemRetorno>) model.getDados();
		for (ItemRetorno itemRetorno2 : array) {
			itemretorno.add(itemRetorno2);
			System.out.println(itemRetorno2.getId());

		}

		retorno.setItemRetorno(itemretorno);

		boolean salvo = false;

		if (txtId.getText().length() <= 0) {

			salvo = banco.salvarObjeto(retorno);

		}
		if (txtId.getText().length() > 0) {
			retorno.setId(Integer.parseInt(txtId.getText()));
			salvo = banco.salvarOuAtualizarObjeto(retorno);

		}
		for (ItemRetorno insta : array) {
			insta.setRetorno(retorno);
			banco.salvarOuAtualizarObjeto(insta);
		}

		if (salvo) {
			JOptionPane.showMessageDialog(contentPanel, "Retorno salva no banco com sucesso!");
			dispose();
		}
		if (!salvo) {
			JOptionPane.showMessageDialog(contentPanel, "Erro Retorno não foi salva no banco.");
			dispose();

		}} catch (Exception e) {
			JOptionPane.showMessageDialog(contentPanel, e.getMessage());
		}

	}

	public void inserirRetorno(Retorno retorno) {
		try {

			txtId.setText(String.valueOf(retorno.getId()));
			txtTotalGeral.setText(String.valueOf(retorno.getValor()));
			txtCustoTotal.setText(String.valueOf(retorno.getCusto()));
			txtIdEquipe.setText(String.valueOf(retorno.getEquipe().getId()));
			model.removeTudo();
			for (ItemRetorno item : retorno.getInstaRetorno()) {
				model.addRow(item);
			}
			btnFinalizar.setEnabled(true);

		} catch (

		Exception e)

		{
			JOptionPane.showMessageDialog(contentPanel,e.getMessage());
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

	public Equipe getEquipe() {
		return equipe;
	}

	public void setEquipe(Equipe equipe) {
		this.equipe = equipe;
		System.out.println(equipe.getId());
		txtIdEquipe.setText(String.valueOf(this.equipe.getId()));
	}

	public Retorno getRetorno() {
		return retorno;
	}

	public void setRetorno(Retorno retorno) {
		this.retorno = retorno;
	}

	public void setVisualizar() {
		contentPanel.setEnabled(false);

	}
}
