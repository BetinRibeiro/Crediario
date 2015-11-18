package Janela.Cadastro;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

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
import java.util.List;

public class JFrmCadCarrada extends JDialog implements ActionListener{

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
	private ModelTabelaItemCarrada model=new ModelTabelaItemCarrada();
	private JButton cancelButton;
	private JButton okButton;
	private Dao banco=new Dao();
	private JButton btnBuscar;
	private JButton btnInserir;

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
		setBounds(100, 100, 487, 415);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
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
			contentPanel.add(btnBuscar);
		}
		{
			 btnInserir = new JButton("Inserir");
			btnInserir.setEnabled(false);
			btnInserir.setBounds(307, 134, 89, 23);
			contentPanel.add(btnInserir);
		}
		{
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 179, 448, 154);
			contentPanel.add(scrollPane);
			{
				JPopupMenu popupMenu = new JPopupMenu();
				addPopup(table, popupMenu);
			}
			{
				table = new JTable(model);
				scrollPane.setViewportView(table);
			}
		}
		{
			txtIdEquipe = new JTextField();
			txtIdEquipe.setBackground(new Color(255, 250, 205));
			txtIdEquipe.setEnabled(false);
			txtIdEquipe.setColumns(10);
			txtIdEquipe.setBounds(371, 30, 87, 20);
			contentPanel.add(txtIdEquipe);
		}
		{
			JLabel lblCdigoDaVenda = new JLabel("C\u00F3digo da Equipe");
			lblCdigoDaVenda.setBounds(371, 10, 87, 14);
			contentPanel.add(lblCdigoDaVenda);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JLabel lblCustoTotal = new JLabel("Custo Total");
				buttonPane.add(lblCustoTotal);
			}
			{
				txtCustoTotal = new JTextField();
				txtCustoTotal.setBackground(new Color(255, 250, 205));
				txtCustoTotal.setFont(new Font("Tahoma", Font.BOLD, 13));
				txtCustoTotal.setEnabled(false);
				buttonPane.add(txtCustoTotal);
				txtCustoTotal.setColumns(10);
			}
			{
				JLabel lblValorDoFrete = new JLabel("Valor do Frete");
				buttonPane.add(lblValorDoFrete);
			}
			{
				txtTxtfret = new JTextField();
				buttonPane.add(txtTxtfret);
				txtTxtfret.setColumns(10);
			}
			{
				 okButton = new JButton("OK");
				okButton.setEnabled(false);
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				 cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String acao = e.getActionCommand();

		switch (acao) {
		case "Buscar":
			buscar();
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
				String a = (String) (model.getValueAt(i, 5));
				valor = valor + ((Float.parseFloat(a.replace(",", "."))));
			}
			txtCusto.setText(String.valueOf(valor));
		} catch (Exception e) {
			JOptionPane.showMessageDialog(contentPanel, "ERRO! Refaça a compra novamente");
			dispose();
		}
	}

	private void remover() {
		try {
			model.removeRow(table.getSelectedRow());
			if (model.getRowCount() <= 0) {
				okButton.setEnabled(false);
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(contentPanel, "ERRO! Refaça a carrada novamente");
			dispose();
		}
	}

	private void inserir() {
		try {
			ItemCarrada itemCarrada = (ItemCarrada) banco.buscarPorId(ItemCarrada.class, Integer.parseInt(txtItemCarradaID.getText()));
			itemCarrada.setCusto(Float.parseFloat(txtCusto.getText().replace(",", ".")));
			itemCarrada.setQuantidade(Float.parseFloat(txtQuantidade.getText().replace(",", ".")));
			itemCarrada.setPreco(Float.parseFloat(txtPreco.getText().replace(",", ".")));
			boolean liberado = true;
			for (int i = 0; i < model.getRowCount(); i++) {
				if (itemCarrada.getId().equals(model.getValueAt(i, 0))) {
					JOptionPane.showMessageDialog(contentPanel, "ItemCarrada Igual, remova o ItemCarrada inserido.");
					liberado = false;
				}
			}
			if (liberado) {
				model.addRow(itemCarrada);
				okButton.setEnabled(true);
			}
			limpatxt();
		} catch (java.lang.NumberFormatException e) {
			JOptionPane.showMessageDialog(contentPanel, "Insira numeros validos nos campos de quantidade e valor.");

		} catch (Exception e) {
			// System.out.println(e.getMessage());
			// System.out.println(e);
			JOptionPane.showMessageDialog(contentPanel, "ERRO! Refaça a Compra");
			// compra novamente ");
			dispose();
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
		} catch (java.lang.NullPointerException e) {
			JOptionPane.showMessageDialog(contentPanel, "Escolha um ItemCarrada para inserir");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(contentPanel, "ERRO! Refaça a compra novamente ");
			dispose();
		}

	}

	private void salvar() {
		try {

			// para organizar melhor a logistica de 2 setores essa função tem
			// que
			// disparar duas ações a primeira no financeiro que chame-se
			// pendencia
			// de pagamento e a segunda no estoque que chama-se recebimento de
			// ItemCarrada
			List<ItemCarrada> listaCompra = new ArrayList<>();
			List<ItemCarrada> listaItemCarradas = new ArrayList<>();

			for (int i = 0; i < model.getRowCount(); i++) {
				Integer idProd = (Integer) table.getValueAt(i, 0);
				ItemCarrada ItemCarrada = (ItemCarrada) banco.buscarPorId(ItemCarrada.class, idProd);
				String custostr = (String.valueOf(table.getValueAt(i, 2)));
				float custo = Float.parseFloat(custostr.replace(",", "."));
				String quantstr = (String.valueOf(table.getValueAt(i, 3)));
				float quantidade = Float.parseFloat(quantstr.replace(",", "."));

				// reajusta custo e quantidade do ItemCarrada mantido no estoque

				float quantidadeVelha = ItemCarrada.getQuantidade();
				float custoUnitarioVelho = ItemCarrada.getCusto();
				float quantidadeEntrada = quantidade;
				float custoUnitarioEntrada = custo;

				float custoTotalVelho = quantidadeVelha * custoUnitarioVelho;
				float custoTotalEntrada = quantidadeEntrada * custoUnitarioEntrada;

				float quantidadeAtual = quantidadeEntrada + quantidadeVelha;
				float custoTotalAtual = custoTotalEntrada + custoTotalVelho;

				float custoUnitarioAtual = custoTotalAtual / quantidadeAtual;

				ItemCarrada.setCusto(custoUnitarioAtual);
				ItemCarrada.setQuantidade(quantidadeAtual);
				listaItemCarradas.add(ItemCarrada);

				System.out.println(ItemCarrada.getCusto());

			}
			// System.out.println(listaCompra);

			Date data = (Date) dtCompra.getDate();
			System.out.println("Data que inseriiii - " + data);
			float valor = Float.parseFloat(txtValorTotal.getText());
			Compra compra = new Compra(data, valor);

			boolean liberado = false;
			// quando cria a compra no banco retorna verdadeiro para poder
			// atualizar estoque e custo
			liberado = banco.salvarObjeto(compra);
			boolean prossegue = false;
			if (liberado) {
				// aqui simplesmente salva todos os ItemCarradas atualizados
				for (int i = 0; i < listaItemCarradas.size(); i++) {
					prossegue = banco.salvarOuAtualizarObjeto(listaItemCarradas.get(i));
					// caso não atualize algum dos ItemCarradas para tudo e deleta a
					// compra criada no banco para posterior ajuste
					if (!prossegue) {
						JOptionPane.showMessageDialog(contentPanel,
								"Erro ao atualizar estoque, ajuste manualmente o estoque.");
						break;
					}
				}
				if (liberado) {
					for (int i = 0; i < listaCompra.size(); i++) {
						listaCompra.get(i).setCompra(compra);
						banco.salvarObjeto(listaCompra.get(i));
					}

					JOptionPane.showMessageDialog(contentPanel, "Compra salva no banco com sucesso!");
					dispose();
				}
				if (!liberado) {
					JOptionPane.showMessageDialog(contentPanel, "Erro Compra não foi salva no banco.");
				}
			}

		} catch (Exception e) {
			// JOptionPane.showMessageDialog(contentPanel, "ERRO! Tente
			// novamente");
			System.out.println(e);
			System.out.println(e.getMessage());
		}

	}

	public void inserirCompra(Compra compra) {
		setVisible(true);
		try {

			txtId.setText(String.valueOf(compra.getId()));
			dtCompra.setDate(compra.getData());
			txtValorTotal.setText(String.valueOf(compra.getValor()));

			System.out.println(compra.getInstaCompra().size());

			Set<ItemCompra> lista = compra.getInstaCompra();
			System.out.println("Esta é a lista - " + lista);
			for (ItemCompra instanciaCompra : lista) {
				model.addRow(instanciaCompra);
				
			}

			btnBuscar.setEnabled(false);
			btnFinalizar.setEnabled(false);
			btnInserir.setEnabled(false);
			tableItemCarrada.setEnabled(false);
			txtQuantidade.setEnabled(false);
			txtValorItemCarrada.setEnabled(false);
		}catch(

	Exception e)

	{
		JOptionPane.showMessageDialog(contentPanel, "Erro ao resgatar os ItemCarrada na pesquisa, tente novamente ");
		System.out.println(e);
		System.out.println(e.getMessage());
		dispose();
	}


}	private static void addPopup(Component component, final JPopupMenu popup) {
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

