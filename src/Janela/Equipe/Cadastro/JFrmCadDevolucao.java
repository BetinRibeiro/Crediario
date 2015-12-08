package Janela.Equipe.Cadastro;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;

import Bin.Endereco;
import Bin.Devolucao.Devolucao;
import Bin.Devolucao.ItemDevolucao;
import Bin.Equipe.Equipe;
import Bin.Produto.Produto;
import Janela.Pesquisa.JFrmPesProduto;
import Model.Tabela.ModelTabelaItemDevolucao;
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
import javax.swing.JComboBox;
import javax.swing.JCheckBox;

public class JFrmCadDevolucao extends JDialog implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtId;
	private JTextField txtItemDevolucaoID;
	private JTextField txtItemDevolucaoDescricao;
	private JTextField txtQuantidade;
	private JTextField txtPreco;
	private JTextField txtCusto;
	private JTextField txtIdEquipe;
	private JTable table;
	private JTextField txtCustoTotal;
	private ModelTabelaItemDevolucao model = new ModelTabelaItemDevolucao();
	private JButton btnCancelar;
	private JButton btnFinalizar;
	private Dao banco = new Dao();
	private JButton btnBuscar;
	private JButton btnInserir;
	private JMenuItem mntmAlterar;
	private JTextField txtResponsavel;
	private JDateChooser dataDeix;

	private Equipe equipe;
	private Devolucao devolucao;
	private ItemDevolucao itemAlterando;
	private JTextField txtTotalGeral;
	private JTextField txtLougradouro;
	private JTextField txtBairro;
	private JTextField txtNumero;
	private JTextField txtCidade;
	private JComboBox<String> boxUf;
	private JCheckBox chqRecolhido;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			JFrmCadDevolucao dialog = new JFrmCadDevolucao();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public JFrmCadDevolucao() {

		setTitle("Cadastro de Devolucao");
		setBounds(100, 100, 692, 580);
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
			txtItemDevolucaoID = new JTextField();
			txtItemDevolucaoID.setBackground(new Color(255, 250, 205));
			txtItemDevolucaoID.setEnabled(false);
			txtItemDevolucaoID.setColumns(10);
			txtItemDevolucaoID.setBounds(10, 80, 87, 20);
			contentPanel.add(txtItemDevolucaoID);
		}
		{
			JLabel lblDescrio = new JLabel("Descri\u00E7\u00E3o");
			lblDescrio.setBounds(112, 60, 234, 14);
			contentPanel.add(lblDescrio);
		}
		{
			txtItemDevolucaoDescricao = new JTextField();
			txtItemDevolucaoDescricao.setBackground(new Color(255, 250, 205));
			txtItemDevolucaoDescricao.setEnabled(false);
			txtItemDevolucaoDescricao.setColumns(10);
			txtItemDevolucaoDescricao.setBounds(112, 80, 234, 20);
			contentPanel.add(txtItemDevolucaoDescricao);
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
		lblData.setBounds(10, 440, 68, 14);
		contentPanel.add(lblData);

		dataDeix = new JDateChooser(new java.util.Date());
		dataDeix.setBounds(10, 460, 116, 23);
		contentPanel.add(dataDeix);

		JLabel lblMotorista = new JLabel("Responsavel");
		lblMotorista.setHorizontalTextPosition(SwingConstants.RIGHT);
		lblMotorista.setBounds(10, 345, 319, 14);
		contentPanel.add(lblMotorista);

		txtResponsavel = new JTextField();
		txtResponsavel.setColumns(10);
		txtResponsavel.setBounds(10, 366, 319, 20);
		contentPanel.add(txtResponsavel);

		JLabel lblVendaTotal = new JLabel("ValorTotal");
		lblVendaTotal.setBounds(572, 115, 94, 14);
		contentPanel.add(lblVendaTotal);

		txtTotalGeral = new JTextField();
		txtTotalGeral.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtTotalGeral.setEnabled(false);
		txtTotalGeral.setColumns(10);
		txtTotalGeral.setBackground(new Color(255, 250, 205));
		txtTotalGeral.setBounds(572, 133, 94, 22);
		contentPanel.add(txtTotalGeral);

		JLabel label = new JLabel("Lougradouro");
		label.setBounds(10, 395, 319, 14);
		contentPanel.add(label);

		txtLougradouro = new JTextField();
		txtLougradouro.setColumns(10);
		txtLougradouro.setBounds(10, 415, 319, 20);
		contentPanel.add(txtLougradouro);

		JLabel label_1 = new JLabel("Bairro");
		label_1.setBounds(340, 345, 214, 14);
		contentPanel.add(label_1);

		txtBairro = new JTextField();
		txtBairro.setColumns(10);
		txtBairro.setBounds(339, 364, 214, 20);
		contentPanel.add(txtBairro);

		JLabel label_2 = new JLabel("Numero");
		label_2.setBounds(560, 345, 68, 14);
		contentPanel.add(label_2);

		txtNumero = new JTextField();
		txtNumero.setColumns(10);
		txtNumero.setBounds(560, 364, 86, 20);
		contentPanel.add(txtNumero);

		JLabel label_3 = new JLabel("Cidade");
		label_3.setBounds(340, 395, 214, 14);
		contentPanel.add(label_3);

		txtCidade = new JTextField();
		txtCidade.setColumns(10);
		txtCidade.setBounds(339, 415, 214, 20);
		contentPanel.add(txtCidade);

		String[] uf = { "AC", "AL", "AM", "AP", "BA", "CE", "DF", "ES", "GO", "MA", "MG", "MS", "MT", "PA", "PB", "PE",
				"PI", "PR", "RJ", "RN", "RO", "RR", "RS", "SC", "SE", "SP", "TO" };
		boxUf = new JComboBox<String>(uf);
		boxUf.setSelectedIndex(5);
		boxUf.setBounds(560, 415, 86, 20);
		contentPanel.add(boxUf);

		JLabel label_4 = new JLabel("UF");
		label_4.setBounds(560, 395, 68, 14);
		contentPanel.add(label_4);

		chqRecolhido = new JCheckBox("Recolhido");
		chqRecolhido.setBounds(140, 460, 188, 23);
		contentPanel.add(chqRecolhido);
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

				txtItemDevolucaoDescricao.setText(itemAlterando.getProduto().getDescricao());
				txtItemDevolucaoID.setText(String.valueOf(itemAlterando.getProduto().getId()));
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
		}
	}

	private ItemDevolucao remover() {
		try {
			ItemDevolucao itemSelecionado = (ItemDevolucao) model.getObj(table.getSelectedRow());
			System.out.println(itemSelecionado.getProduto().getDescricao());

			// devolucao.getDevolucao().remove(itemSelecionado.getId());
			boolean a = banco.deletarObjeto(itemSelecionado);
			System.out.println("item removido com sucesso" + a);
			// devolucao.getItemDevolucao().remove(itemremovido);
			// a = banco.salvarObjeto(devolucao);
			if (a) {
				System.out.println("devolucao salva com sucesso" + a);
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
			Produto prod = (Produto) banco.buscarPorId(Produto.class, Integer.parseInt(txtItemDevolucaoID.getText()));
			System.out.println(txtItemDevolucaoID.getText());
			System.out.println(prod.getDescricao());
			ItemDevolucao itemDevolucao = new ItemDevolucao();
			itemDevolucao.setProduto(prod);
			itemDevolucao.setCusto(Float.parseFloat(txtCusto.getText().replace(",", ".")));
			itemDevolucao.setQuantidade(Float.parseFloat(txtQuantidade.getText().replace(",", ".")));
			itemDevolucao.setValor(Float.parseFloat(txtPreco.getText().replace(",", ".")));
			boolean salvo = true;
			for (int i = 0; i < model.getRowCount(); i++) {
				if (itemDevolucao.getProduto().getId().equals(model.getValueAt(i, 0))) {
					JOptionPane.showMessageDialog(contentPanel, "Produto Igual, remova o ItemDevolucao inserido.");
					salvo = false;
				}
			}
			if (salvo) {
				model.addRow(itemDevolucao);
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
			txtItemDevolucaoDescricao.setText("");
			txtItemDevolucaoID.setText("");
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
			txtItemDevolucaoID.setText(String.valueOf(p.getId()));
			txtItemDevolucaoDescricao.setText(String.valueOf(p.getDescricao()));
			prod.dispose();
			btnInserir.setEnabled(true);
			txtQuantidade.setEnabled(true);
			txtPreco.setEnabled(true);
			txtCusto.setEnabled(true);
			System.out.println("aqui");
		} catch (java.lang.NullPointerException e) {
			JOptionPane.showMessageDialog(contentPanel, "Escolha um ItemDevolucao para inserir");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(contentPanel, e.getMessage());
			dispose();
		}

	}

	private void salvar() {
		try {

			Equipe equipe = (Equipe) banco.buscarPorId(Equipe.class, Integer.parseInt(txtIdEquipe.getText()));
			Date data = dataDeix.getDate();
			float custo = Float.parseFloat(txtCustoTotal.getText());
			float valor = Float.parseFloat(txtTotalGeral.getText());
			Endereco endereco = new Endereco();
			endereco.setBairro(txtBairro.getText());
			endereco.setCep("00000000");
			endereco.setCidade(txtCidade.getText());
			endereco.setLougradouro(txtLougradouro.getText());
			endereco.setNumero(txtNumero.getText());
			endereco.setUfEndereco(String.valueOf(boxUf.getSelectedItem()));
			String responsavel = txtResponsavel.getText();
			boolean recolhido = chqRecolhido.isSelected();
			Devolucao devolucao = new Devolucao(data, custo, valor, endereco, responsavel, recolhido, equipe);

			Set<ItemDevolucao> itemdevolucao = new HashSet<ItemDevolucao>();

			ArrayList<ItemDevolucao> array = (ArrayList<ItemDevolucao>) model.getDados();
			for (ItemDevolucao itemDevolucao2 : array) {
				itemdevolucao.add(itemDevolucao2);
				System.out.println(itemDevolucao2.getId());

			}

			devolucao.setDevolucao(itemdevolucao);

			boolean salvo = false;

			if (txtId.getText().length() <= 0) {

				salvo = banco.salvarObjeto(devolucao);

			}
			if (txtId.getText().length() > 0) {
				devolucao.setId(Integer.parseInt(txtId.getText()));
				salvo = banco.salvarOuAtualizarObjeto(devolucao);

			}
			for (ItemDevolucao insta : array) {
				insta.setDevolucao(devolucao);
				banco.salvarOuAtualizarObjeto(insta);
			}

			if (salvo) {
				JOptionPane.showMessageDialog(contentPanel, "Devolucao salva no banco com sucesso!");
				dispose();
			}
			if (!salvo) {
				JOptionPane.showMessageDialog(contentPanel, "Erro Devolucao não foi salva no banco.");
				dispose();

			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(contentPanel, e.getMessage());
		}

	}

	public void inserirDevolucao(Devolucao devolucao) {
		try {

			txtId.setText(String.valueOf(devolucao.getId()));
			txtCidade.setText(devolucao.getEndereco().getCidade());
			txtTotalGeral.setText(String.valueOf(devolucao.getValor()));
			txtCustoTotal.setText(String.valueOf(devolucao.getCusto()));
			txtIdEquipe.setText(String.valueOf(devolucao.getEquipe().getId()));
			txtResponsavel.setText(devolucao.getResponsavel());
			txtBairro.setText(String.valueOf(devolucao.getEndereco().getBairro()));
			txtLougradouro.setText(devolucao.getEndereco().getLougradouro());
			txtNumero.setText(devolucao.getEndereco().getNumero());
			model.removeTudo();
			for (ItemDevolucao item : devolucao.getDevolucao()) {
				model.addRow(item);
			}
			btnFinalizar.setEnabled(true);

		} catch (

		Exception e)

		{
			JOptionPane.showMessageDialog(contentPanel, e.getMessage());
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

	public Devolucao getDevolucao() {
		return devolucao;
	}

	public void setDevolucao(Devolucao devolucao) {
		this.devolucao = devolucao;
	}

	public void setVisualizar() {
		contentPanel.setEnabled(false);

	}
}
