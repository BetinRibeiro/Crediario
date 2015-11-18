package Janela.Cadastro;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;

import Bin.Equipe.Equipe;
import Bin.Mercadoria.Carrada;
import Bin.Mercadoria.ItemCarrada;
import Bin.Produto.Produto;
import Janela.Pesquisa.JFrmPesProduto;
import Model.Tabela.ModelTabelaItemCarrada;
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
import java.util.List;
import java.util.Set;

import javax.swing.JMenuItem;
import javax.swing.SwingConstants;

public class JFrmCadCarrada extends JDialog implements ActionListener {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtId;
	private JTextField txtItemCarradaID;
	private JTextField txtItemCarradaDescricao;
	private JTextField txtQuantidade;
	private JTextField txtPreco;
	private JTextField txtCusto;
	private JTextField txtIdEquipe;
	private JTable table;
	private JTextField txtTxtfret;
	private JTextField txtCustoTotal;
	private ModelTabelaItemCarrada model = new ModelTabelaItemCarrada();
	private JButton btnCancelar;
	private JButton btnFinalizar;
	private Dao banco = new Dao();
	private JButton btnBuscar;
	private JButton btnInserir;
	private JMenuItem mntmAlterar;
	private JTextField textField;
	private JTextField txtMotorista;
	private JDateChooser dtCarrada;
	private JTextField txtCidade;
	private JLabel lblCidade;
	
	private Equipe equipe;
	private Carrada carrada;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			JFrmCadCarrada dialog = new JFrmCadCarrada();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public JFrmCadCarrada() {

		setTitle("Cadastro de Carrada");
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
			txtItemCarradaID = new JTextField();
			txtItemCarradaID.setBackground(new Color(255, 250, 205));
			txtItemCarradaID.setEnabled(false);
			txtItemCarradaID.setColumns(10);
			txtItemCarradaID.setBounds(10, 80, 87, 20);
			contentPanel.add(txtItemCarradaID);
		}
		{
			JLabel lblDescrio = new JLabel("Descri\u00E7\u00E3o");
			lblDescrio.setBounds(112, 60, 234, 14);
			contentPanel.add(lblDescrio);
		}
		{
			txtItemCarradaDescricao = new JTextField();
			txtItemCarradaDescricao.setBackground(new Color(255, 250, 205));
			txtItemCarradaDescricao.setEnabled(false);
			txtItemCarradaDescricao.setColumns(10);
			txtItemCarradaDescricao.setBounds(112, 80, 234, 20);
			contentPanel.add(txtItemCarradaDescricao);
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
				}
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
		{
			JLabel lblValorDoFrete = new JLabel("Valor do Frete");
			lblValorDoFrete.setBounds(10, 347, 105, 14);
			contentPanel.add(lblValorDoFrete);
		}
		{
			txtTxtfret = new JTextField();
			txtTxtfret.setBounds(113, 344, 86, 20);
			contentPanel.add(txtTxtfret);
			txtTxtfret.setColumns(10);
		}

		JLabel lblData = new JLabel("Data");
		lblData.setBounds(10, 375, 68, 14);
		contentPanel.add(lblData);

		dtCarrada = new JDateChooser(new java.util.Date());
		dtCarrada.setBounds(83, 372, 116, 20);
		contentPanel.add(dtCarrada);

		JLabel lblMotorista = new JLabel("Motorista");
		lblMotorista.setHorizontalTextPosition(SwingConstants.RIGHT);
		lblMotorista.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMotorista.setBounds(242, 347, 127, 14);
		contentPanel.add(lblMotorista);

		txtMotorista = new JTextField();
		txtMotorista.setColumns(10);
		txtMotorista.setBounds(379, 344, 283, 20);
		contentPanel.add(txtMotorista);
		{
			txtCidade = new JTextField();
			txtCidade.setColumns(10);
			txtCidade.setBounds(379, 375, 283, 20);
			contentPanel.add(txtCidade);
		}
		{
			lblCidade = new JLabel("Cidade");
			lblCidade.setHorizontalTextPosition(SwingConstants.RIGHT);
			lblCidade.setHorizontalAlignment(SwingConstants.RIGHT);
			lblCidade.setBounds(242, 378, 127, 14);
			contentPanel.add(lblCidade);
		}
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
			valorTotal();
			break;
		default:
			break;
		}
	}

	private void valorTotal() {
		try {

			float valor = 0;
			System.out.println(valor);
			for (int i = 0; i < model.getRowCount(); i++) {
				String a = String.valueOf(table.getValueAt(i, 5));
				System.out.println((table.getValueAt(i, 5)).getClass());
				valor = valor + ((Float.parseFloat(a.replace(",", "."))));
			}
			txtCustoTotal.setText(String.valueOf(valor));
		} catch (Exception e) {
			JOptionPane.showMessageDialog(contentPanel, "ERRO! Refaça a compra novamente");
			dispose();
		}
	}

	private void remover() {
		try {
			model.removeRow(table.getSelectedRow());
			if (model.getRowCount() <= 0) {
				btnFinalizar.setEnabled(false);
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(contentPanel, "ERRO! Refaça a carrada novamente");
			dispose();
		}
	}

	private void inserir() {
		try {
			Produto prod = (Produto) banco.buscarPorId(Produto.class, Integer.parseInt(txtItemCarradaID.getText()));
			System.out.println(txtItemCarradaID.getText());
			System.out.println(prod.getDescricao());
			ItemCarrada itemCarrada = new ItemCarrada();
			itemCarrada.setProduto(prod);
			itemCarrada.setCusto(Float.parseFloat(txtCusto.getText().replace(",", ".")));
			itemCarrada.setQuantidade(Float.parseFloat(txtQuantidade.getText().replace(",", ".")));
			itemCarrada.setPreco(Float.parseFloat(txtPreco.getText().replace(",", ".")));
			boolean salvo = true;
			for (int i = 0; i < model.getRowCount(); i++) {
				if (itemCarrada.getProduto().getId().equals(model.getValueAt(i, 0))) {
					JOptionPane.showMessageDialog(contentPanel, "Produto Igual, remova o ItemCarrada inserido.");
					salvo = false;
				}
			}
			if (salvo) {
				model.addRow(itemCarrada);
				btnFinalizar.setEnabled(true);
			}
			limpatxt();
		} catch (java.lang.NumberFormatException e) {
			JOptionPane.showMessageDialog(contentPanel, "Insira numeros validos nos campos de quantidade e valor.");

		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e);
			JOptionPane.showMessageDialog(contentPanel, "ERRO! Refaça a Carrada");
			// compra novamente ");
			// dispose();
		}
	}

	private void limpatxt() {
		try {
			txtCusto.setText("");
			txtPreco.setText("");
			txtQuantidade.setText("");
			txtItemCarradaDescricao.setText("");
			txtItemCarradaID.setText("");
			btnInserir.setEnabled(false);
			txtCusto.setEnabled(false);
			txtQuantidade.setEnabled(false);
			txtPreco.setEnabled(false);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(contentPanel, "ERRO! Refaça a carrada novamente ");
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
			txtItemCarradaID.setText(String.valueOf(p.getId()));
			txtItemCarradaDescricao.setText(String.valueOf(p.getDescricao()));
			prod.dispose();
			btnInserir.setEnabled(true);
			txtQuantidade.setEnabled(true);
			txtPreco.setEnabled(true);
			txtCusto.setEnabled(true);
			System.out.println("aqui");
		} catch (java.lang.NullPointerException e) {
			JOptionPane.showMessageDialog(contentPanel, "Escolha um ItemCarrada para inserir");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(contentPanel, "ERRO! Refaça a compra novamente ");
			dispose();
		}

	}

	private void salvar() {
		try {

			Equipe equipe = (Equipe) banco.buscarPorId(Equipe.class, Integer.parseInt(txtIdEquipe.getText()));
			String cidade = txtCidade.getText();
			float valorFrete = Float.parseFloat(txtTxtfret.getText());
			float valorTotal = Float.parseFloat(txtCustoTotal.getText());
			String motorista = txtMotorista.getText();
			Date data = dtCarrada.getDate();
			Carrada carrada = new Carrada(data, motorista, valorTotal, valorFrete, cidade, equipe);
			
			Set<ItemCarrada> itemcarrada = new HashSet<ItemCarrada>();

			ArrayList<ItemCarrada> array = (ArrayList<ItemCarrada>) model.getDados();
			for (ItemCarrada itemCarrada2 : array) {
				itemcarrada.add(itemCarrada2);
				
			}
			
			
			carrada.setCarrada(itemcarrada);

			boolean salvo = false;

			if (txtId.getText().length() <= 0) {
				
				salvo = banco.salvarObjeto(carrada);

			}
			if (txtId.getText().length() > 0) {
				carrada.setId(Integer.parseInt(txtId.getText()));
				salvo = banco.salvarOuAtualizarObjeto(carrada);

			}
			for (ItemCarrada insta : array) {
				insta.setCarrada(carrada);
				banco.salvarObjeto(insta);
			}

			if (salvo) {
				JOptionPane.showMessageDialog(contentPanel, "Carrada salva no banco com sucesso!");
				dispose();
			}
			if (!salvo) {
				JOptionPane.showMessageDialog(contentPanel, "Erro Carrada não foi salva no banco.");
				dispose();

			}

		 } catch (
		
		 Exception e)
		
		 {
		 // JOptionPane.showMessageDialog(contentPanel, "ERRO! Tente
		 // novamente");
		 System.out.println(e);
		 System.out.println(e.getMessage());
		 }

	}

	public void inserirCarrada(Carrada carrada) {
		try {

			txtId.setText(String.valueOf(carrada.getId()));
			txtCidade.setText(carrada.getCidade());
			
			txtIdEquipe.setText(String.valueOf(carrada.getEquipe().getId()));
			txtMotorista.setText(carrada.getMotorista());
			txtTxtfret.setText(String.valueOf(carrada.getValorFrete()));
			
			float total=0;
			Set<ItemCarrada> lista = carrada.getCarrada();
			for (ItemCarrada inst : lista) {
				model.addRow(inst);
				total=total+inst.getTotalCusto();
			}
			
			txtCustoTotal.setText(String.valueOf(total));
			btnFinalizar.setEnabled(true);
		} catch (

		Exception e)

		{
			JOptionPane.showMessageDialog(contentPanel,
					"Erro ao resgatar os ItemCarrada na pesquisa, tente novamente ");
			System.out.println(e);
			System.out.println(e.getMessage());
			dispose();
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
		txtIdEquipe.setText(String.valueOf(this.equipe.getId()));
	}

	public Carrada getCarrada() {
		return carrada;
	}

	public void setCarrada(Carrada carrada) {
		this.carrada = carrada;
	}
	
	
}
