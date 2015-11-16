package Janela.Compra;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;

import Bin.Compra.Compra;
import Bin.Compra.InstanciaCompra;
import Bin.Produto.Produto;
import Janela.Pesquisa.JFrmPesProduto;
import Model.Tabela.ModelTabelaProduto;
import Persistence.Dao;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class JFrmComProduto extends JDialog implements ActionListener {

	private final JPanel contentPanel = new JPanel();
	private JTable tableProduto;
	private JTextField txtId;
	private JTextField txtValorTotal;
	private JDateChooser dtCompra;
	private JTextField txtProdutoId;
	private JTextField txtProdutoDescricao;
	private JTextField txtQuantidade;
	private JTextField txtValorProduto;
	private JButton btnBuscar;
	private ModelTabelaProduto model = new ModelTabelaProduto();
	private JButton btnInserir;
	private Dao banco = new Dao();
	private JButton btnFinalizar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			JFrmComProduto dialog = new JFrmComProduto();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public JFrmComProduto() {
		setTitle("Comprar Produtos");
		setBounds(100, 100, 514, 427);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		setAlwaysOnTop(true);
		setLocationRelativeTo(null);
		{
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 161, 472, 184);
			contentPanel.add(scrollPane);

			tableProduto = new JTable(model);
			scrollPane.setViewportView(tableProduto);

			JPopupMenu popupMenu = new JPopupMenu();
			addPopup(tableProduto, popupMenu);

			JMenuItem mntmRemover = new JMenuItem("Remover");
			mntmRemover.addActionListener(this);
			popupMenu.add(mntmRemover);

		}

		JLabel lblCdigo = new JLabel("C\u00F3digo");
		lblCdigo.setBounds(10, 10, 46, 14);
		contentPanel.add(lblCdigo);

		txtId = new JTextField();
		txtId.setEnabled(false);
		txtId.setBounds(10, 30, 86, 20);
		contentPanel.add(txtId);
		txtId.setColumns(10);

		txtValorTotal = new JTextField();
		txtValorTotal.setEnabled(false);
		txtValorTotal.setColumns(10);
		txtValorTotal.setBounds(396, 30, 86, 20);
		contentPanel.add(txtValorTotal);

		JLabel lblValor = new JLabel("Valor Total");
		lblValor.setBounds(396, 10, 86, 14);
		contentPanel.add(lblValor);

		JLabel lblData = new JLabel("Data");
		lblData.setBounds(240, 10, 46, 14);
		contentPanel.add(lblData);

		dtCompra = new JDateChooser(new java.util.Date());
		dtCompra.setBounds(240, 30, 122, 20);
		contentPanel.add(dtCompra);

		txtProdutoId = new JTextField();
		txtProdutoId.setEnabled(false);
		txtProdutoId.setBounds(10, 80, 86, 20);
		contentPanel.add(txtProdutoId);
		txtProdutoId.setColumns(10);

		txtProdutoDescricao = new JTextField();
		txtProdutoDescricao.setEnabled(false);
		txtProdutoDescricao.setBounds(106, 80, 280, 20);
		contentPanel.add(txtProdutoDescricao);
		txtProdutoDescricao.setColumns(10);

		btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(396, 79, 89, 20);
		contentPanel.add(btnBuscar);
		btnBuscar.setActionCommand("Buscar");
		btnBuscar.addActionListener(this);

		JLabel lblCdigo_1 = new JLabel("C\u00F3digo");
		lblCdigo_1.setBounds(10, 60, 86, 14);
		contentPanel.add(lblCdigo_1);

		JLabel lblDescrioDoProduto = new JLabel("Descri\u00E7\u00E3o do Produto");
		lblDescrioDoProduto.setBounds(106, 60, 280, 14);
		contentPanel.add(lblDescrioDoProduto);

		JLabel lblQuantidade = new JLabel("Quantidade");
		lblQuantidade.setBounds(10, 110, 86, 14);
		contentPanel.add(lblQuantidade);

		txtQuantidade = new JTextField();
		txtQuantidade.setBounds(10, 130, 86, 20);
		contentPanel.add(txtQuantidade);
		txtQuantidade.setColumns(10);

		txtValorProduto = new JTextField();
		txtValorProduto.setColumns(10);
		txtValorProduto.setBounds(106, 130, 89, 20);
		contentPanel.add(txtValorProduto);

		JLabel lblValorUnitario = new JLabel("Valor Unitario");
		lblValorUnitario.setBounds(106, 110, 280, 14);
		contentPanel.add(lblValorUnitario);

		btnInserir = new JButton("Inserir");
		btnInserir.setActionCommand("Inserir");
		btnInserir.setBounds(205, 130, 89, 20);
		btnInserir.addActionListener(this);
		contentPanel.add(btnInserir);

		btnInserir.setEnabled(false);
		txtQuantidade.setEnabled(false);
		txtValorProduto.setEnabled(false);

		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btnFinalizar = new JButton("Finalizar");
				btnFinalizar.setActionCommand("Finalizar");
				buttonPane.add(btnFinalizar);
				getRootPane().setDefaultButton(btnFinalizar);
				btnFinalizar.addActionListener(this);
				btnFinalizar.setEnabled(false);
			}
			{
				JButton btnCancelar = new JButton("Cancelar");
				btnCancelar.setActionCommand("Cancelar");
				buttonPane.add(btnCancelar);
				btnCancelar.addActionListener(this);
			}
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
				String a = (String) (model.getValueAt(i, 4));
				valor = valor + ((Float.parseFloat(a.replace(",", "."))));
			}
			txtValorTotal.setText(String.valueOf(valor));
		} catch (Exception e) {
			JOptionPane.showMessageDialog(contentPanel, "ERRO! Refaça a compra novamente");
			dispose();
		}
	}

	private void remover() {
		try {
			model.removeRow(tableProduto.getSelectedRow());
			if (model.getRowCount() <= 0) {
				btnFinalizar.setEnabled(false);
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(contentPanel, "ERRO! Refaça a compra novamente");
			dispose();
		}
	}

	private void inserir() {
		try {
			Produto produto = (Produto) banco.buscarPorId(Produto.class, Integer.parseInt(txtProdutoId.getText()));
			produto.setCusto(Float.parseFloat(txtValorProduto.getText().replace(",", ".")));
			produto.setQuantidade(Float.parseFloat(txtQuantidade.getText().replace(",", ".")));
			boolean liberado = true;
			for (int i = 0; i < model.getRowCount(); i++) {
				if (produto.getId().equals(model.getValueAt(i, 0))) {
					JOptionPane.showMessageDialog(contentPanel, "Produto Igual, remova o produto inserido.");
					liberado = false;
				}
			}
			if (liberado) {
				model.addRow(produto);
				btnFinalizar.setEnabled(true);
			}
			limpatxt();
		} catch (java.lang.NumberFormatException e) {
			JOptionPane.showMessageDialog(contentPanel, "Insira numeros validos nos campos de quantidade e valor.");

		} catch (Exception e) {
//			System.out.println(e.getMessage());
//			System.out.println(e);
			JOptionPane.showMessageDialog(contentPanel, "ERRO! Refaça a Compra");
			// compra novamente ");
			dispose();
		}
	}

	private void limpatxt() {
		try {
			txtProdutoId.setText("");
			txtProdutoDescricao.setText("");
			txtQuantidade.setText("");
			txtValorProduto.setText("");
			btnInserir.setEnabled(false);
			txtQuantidade.setEnabled(false);
			txtValorProduto.setEnabled(false);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(contentPanel, "ERRO! Refaça a compra novamente ");
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
			txtProdutoId.setText(String.valueOf(p.getId()));
			txtProdutoDescricao.setText(String.valueOf(p.getDescricao()));
			prod.dispose();
			btnInserir.setEnabled(true);
			txtQuantidade.setEnabled(true);
			txtValorProduto.setEnabled(true);
		} catch (java.lang.NullPointerException e) {
			JOptionPane.showMessageDialog(contentPanel, "Escolha um produto para inserir");
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
			// produto
			List<InstanciaCompra> listaCompra = new ArrayList<>();
			List<Produto> listaProdutos = new ArrayList<>();

			for (int i = 0; i < model.getRowCount(); i++) {
				Integer idProd = (Integer) tableProduto.getValueAt(i, 0);
				Produto produto = (Produto) banco.buscarPorId(Produto.class, idProd);
				String custostr =(String.valueOf(tableProduto.getValueAt(i, 2)));
				float custo = Float.parseFloat(custostr.replace(",", "."));
				String quantstr =(String.valueOf(tableProduto.getValueAt(i, 3)));
				float quantidade = Float.parseFloat(quantstr.replace(",", "."));
				InstanciaCompra inst = new InstanciaCompra(produto, custo, quantidade);
				listaCompra.add(inst);

				// reajusta custo e quantidade do produto mantido no estoque

				float quantidadeVelha = produto.getQuantidade();
				float custoUnitarioVelho = produto.getCusto();
				float quantidadeEntrada = quantidade;
				float custoUnitarioEntrada = custo;

				float custoTotalVelho = quantidadeVelha * custoUnitarioVelho;
				float custoTotalEntrada = quantidadeEntrada * custoUnitarioEntrada;

				float quantidadeAtual = quantidadeEntrada + quantidadeVelha;
				float custoTotalAtual = custoTotalEntrada + custoTotalVelho;

				float custoUnitarioAtual = custoTotalAtual / quantidadeAtual;

				produto.setCusto(custoUnitarioAtual);
				produto.setQuantidade(quantidadeAtual);
				listaProdutos.add(produto);

				System.out.println(produto.getCusto());

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
				// aqui simplesmente salva todos os produtos atualizados
				for (int i = 0; i < listaProdutos.size(); i++) {
					prossegue = banco.salvarOuAtualizarObjeto(listaProdutos.get(i));
					// caso não atualize algum dos produtos para tudo e deleta a
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
		txtId.setText(String.valueOf(compra.getId()));
		dtCompra.setDate(compra.getData());
		txtValorProduto.setText(String.valueOf(compra.getValor()));
		
		
		List<?> lista = banco.BuscaNome(InstanciaCompra.class, txtId.getText(), "compra_id");
		for (int i = 0; i < lista.size(); i++) {
			InstanciaCompra inst = (InstanciaCompra) lista.get(i);
			Produto prod = new Produto();
			prod.setId(inst.getProduto().getId());
			prod.setCusto(inst.getCusto());
			prod.setQuantidade(inst.getQuantidade());
			model.addRow(prod);
		}

	}
}
