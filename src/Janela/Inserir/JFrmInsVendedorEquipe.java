package Janela.Inserir;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.border.LineBorder;

import Bin.Equipe.Equipe;
import Bin.Equipe.VendedorEquipe;
import Bin.Funcionario.Funcionario;
import Janela.Pesquisa.JFrmPesFuncionario;
import Persistence.Dao;

public class JFrmInsVendedorEquipe extends JDialog implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtNome;
	private JTextField txtId;
	private JTextField txtPromissoaria;
	private JTextField txtVale;
	private JTextField txtVenda;
	private JTextField txtPercentualVenda;
	private JTextField txtEntrada;
	private JTextField txtFichas;
	private JTextField txtPercCobranca;
	private JTextField txtQuitado;
	private JTextField txtDevolvido;
	private JTextField txtPerdido;
	private JTextField txtRecebidoParc;
	private JTextField txtPerdidoParc;
	private JTextField txtTotalCobranca;
	private JTextField txtSaldoVenda;
	private JTextField txtSaldoQuitacao;
	private JTextField txtPercCobrado;
	private Equipe equipe;
	private Dao banco = new Dao();
	private VendedorEquipe vendedorEquipe = null;
	private JButton btnBuscar;
	private JTextField txtVenda2;
	private JTextField txtComissaoVenda;
	private JTextField txtCobranca2;
	private JTextField txtcomissaoCob;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			JFrmInsVendedorEquipe dialog = new JFrmInsVendedorEquipe(null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public JFrmInsVendedorEquipe(Equipe equipe) {
		this.equipe = equipe;
		setTitle("Inserir Vendedor na Equipe");
		setBounds(100, 100, 450, 474);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		setAlwaysOnTop(true);
		setLocationRelativeTo(null);

		JLabel label = new JLabel("C\u00F3digo");
		label.setBounds(10, 11, 46, 14);
		contentPanel.add(label);

		JLabel lblNomeDoVendedor = new JLabel("Nome do vendedor");
		lblNomeDoVendedor.setBounds(80, 11, 246, 14);
		contentPanel.add(lblNomeDoVendedor);

		txtNome = new JTextField();
		txtNome.setEnabled(false);
		txtNome.setColumns(10);
		txtNome.setBackground(new Color(255, 250, 205));
		txtNome.setBounds(80, 30, 246, 20);
		contentPanel.add(txtNome);

		txtId = new JTextField();
		txtId.setEnabled(false);
		txtId.setColumns(10);
		txtId.setBackground(new Color(255, 250, 205));
		txtId.setBounds(10, 30, 65, 20);
		contentPanel.add(txtId);

		JLabel label_2 = new JLabel("Promissoria");
		label_2.setBounds(10, 63, 90, 14);
		contentPanel.add(label_2);

		txtPromissoaria = new JTextField();
		txtPromissoaria.setText("0,00");
		txtPromissoaria.setDisabledTextColor(Color.BLACK);
		txtPromissoaria.setEnabled(false);
		txtPromissoaria.setColumns(10);
		txtPromissoaria.setBounds(10, 81, 90, 20);
		contentPanel.add(txtPromissoaria);

		txtVale = new JTextField();
		txtVale.setText("0,00");
		txtVale.setDisabledTextColor(Color.BLACK);
		txtVale.setEnabled(false);
		txtVale.setColumns(10);
		txtVale.setBounds(105, 81, 90, 20);
		contentPanel.add(txtVale);

		JLabel label_3 = new JLabel("Vale");
		label_3.setBounds(105, 63, 90, 14);
		contentPanel.add(label_3);

		txtVenda = new JTextField();
		txtVenda.setText("0,00");
		txtVenda.setEnabled(false);
		txtVenda.setDisabledTextColor(Color.BLACK);
		txtVenda.setColumns(10);
		txtVenda.setBounds(10, 125, 90, 20);
		contentPanel.add(txtVenda);

		JLabel label_4 = new JLabel("Venda");
		label_4.setBounds(10, 107, 90, 14);
		contentPanel.add(label_4);

		txtPercentualVenda = new JTextField();
		txtPercentualVenda.setText("7");
		txtPercentualVenda.setDisabledTextColor(Color.BLACK);
		txtPercentualVenda.setEnabled(false);
		txtPercentualVenda.setColumns(10);
		txtPercentualVenda.setBounds(200, 81, 60, 20);
		contentPanel.add(txtPercentualVenda);

		JLabel lblVenda = new JLabel("% Venda");
		lblVenda.setBounds(200, 63, 63, 14);
		contentPanel.add(lblVenda);

		btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(this);
		btnBuscar.setBounds(333, 30, 89, 23);
		contentPanel.add(btnBuscar);

		txtEntrada = new JTextField();
		txtEntrada.setText("0,00");
		txtEntrada.setEnabled(false);
		txtEntrada.setDisabledTextColor(Color.BLACK);
		txtEntrada.setColumns(10);
		txtEntrada.setBounds(105, 125, 90, 20);
		contentPanel.add(txtEntrada);

		JLabel label_6 = new JLabel("Entradas");
		label_6.setBounds(105, 107, 90, 14);
		contentPanel.add(label_6);

		txtFichas = new JTextField();
		txtFichas.setText("0");
		txtFichas.setEnabled(false);
		txtFichas.setDisabledTextColor(Color.BLACK);
		txtFichas.setColumns(10);
		txtFichas.setBounds(200, 125, 90, 20);
		contentPanel.add(txtFichas);

		JLabel lblQuantFichas = new JLabel("Quant Fichas");
		lblQuantFichas.setBounds(200, 107, 90, 14);
		contentPanel.add(lblQuantFichas);

		JLabel lblCobranca = new JLabel("% Cobranca");
		lblCobranca.setBounds(265, 62, 90, 14);
		contentPanel.add(lblCobranca);

		txtPercCobranca = new JTextField();
		txtPercCobranca.setText("10");
		txtPercCobranca.setDisabledTextColor(Color.BLACK);
		txtPercCobranca.setEnabled(false);
		txtPercCobranca.setColumns(10);
		txtPercCobranca.setBounds(265, 81, 60, 20);
		contentPanel.add(txtPercCobranca);

		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(10, 155, 412, 121);
		contentPanel.add(panel);
		panel.setLayout(null);

		txtQuitado = new JTextField();
		txtQuitado.setText("0,00");
		txtQuitado.setDisabledTextColor(Color.BLACK);
		txtQuitado.setEnabled(false);
		txtQuitado.setColumns(10);
		txtQuitado.setBounds(10, 29, 90, 20);
		panel.add(txtQuitado);

		JLabel lblQuitado = new JLabel("Quitado");
		lblQuitado.setBounds(10, 11, 90, 14);
		panel.add(lblQuitado);

		JLabel lblDevolvido = new JLabel("Devolvido");
		lblDevolvido.setBounds(105, 11, 90, 14);
		panel.add(lblDevolvido);

		txtDevolvido = new JTextField();
		txtDevolvido.setText("0,00");
		txtDevolvido.setDisabledTextColor(Color.BLACK);
		txtDevolvido.setEnabled(false);
		txtDevolvido.setColumns(10);
		txtDevolvido.setBounds(105, 29, 90, 20);
		panel.add(txtDevolvido);

		txtPerdido = new JTextField();
		txtPerdido.setText("0,00");
		txtPerdido.setDisabledTextColor(Color.BLACK);
		txtPerdido.setEnabled(false);
		txtPerdido.setColumns(10);
		txtPerdido.setBounds(200, 29, 90, 20);
		panel.add(txtPerdido);

		JLabel lblPerdido = new JLabel("Perdido");
		lblPerdido.setBounds(200, 11, 90, 14);
		panel.add(lblPerdido);

		JLabel lblRecebidoParc = new JLabel("Recebido Parc.");
		lblRecebidoParc.setBounds(10, 60, 90, 14);
		panel.add(lblRecebidoParc);

		txtRecebidoParc = new JTextField();
		txtRecebidoParc.setText("0,00");
		txtRecebidoParc.setEnabled(false);
		txtRecebidoParc.setDisabledTextColor(Color.BLACK);
		txtRecebidoParc.setColumns(10);
		txtRecebidoParc.setBounds(10, 78, 90, 20);
		panel.add(txtRecebidoParc);

		JLabel lblPerdidoparc = new JLabel("Perdido Parc.");
		lblPerdidoparc.setBounds(105, 60, 90, 14);
		panel.add(lblPerdidoparc);

		txtPerdidoParc = new JTextField();
		txtPerdidoParc.setText("0,00");
		txtPerdidoParc.setEnabled(false);
		txtPerdidoParc.setDisabledTextColor(Color.BLACK);
		txtPerdidoParc.setColumns(10);
		txtPerdidoParc.setBounds(105, 78, 90, 20);
		panel.add(txtPerdidoParc);

		txtTotalCobranca = new JTextField();
		txtTotalCobranca.setText("0,00");
		txtTotalCobranca.setEnabled(false);
		txtTotalCobranca.setDisabledTextColor(Color.BLACK);
		txtTotalCobranca.setColumns(10);
		txtTotalCobranca.setBounds(200, 78, 90, 20);
		panel.add(txtTotalCobranca);

		JLabel lblTotal = new JLabel("Total ");
		lblTotal.setBounds(200, 60, 90, 14);
		panel.add(lblTotal);

		txtPercCobrado = new JTextField();
		txtPercCobrado.setText("0");
		txtPercCobrado.setDisabledTextColor(Color.BLACK);
		txtPercCobrado.setEnabled(false);
		txtPercCobrado.setColumns(10);
		txtPercCobrado.setBounds(295, 29, 60, 20);
		panel.add(txtPercCobrado);

		JLabel lblCobrado = new JLabel("% Cobrado");
		lblCobrado.setBounds(295, 10, 90, 14);
		panel.add(lblCobrado);

		txtSaldoVenda = new JTextField();
		txtSaldoVenda.setText("0,00");
		txtSaldoVenda.setEnabled(false);
		txtSaldoVenda.setDisabledTextColor(Color.BLACK);
		txtSaldoVenda.setColumns(10);
		txtSaldoVenda.setBounds(295, 125, 90, 20);
		contentPanel.add(txtSaldoVenda);

		JLabel lblSaldoVenda = new JLabel("Saldo Venda");
		lblSaldoVenda.setBounds(295, 107, 90, 14);
		contentPanel.add(lblSaldoVenda);
		
		txtVenda2 = new JTextField();
		txtVenda2.setText("0,00");
		txtVenda2.setEnabled(false);
		txtVenda2.setDisabledTextColor(Color.BLACK);
		txtVenda2.setColumns(10);
		txtVenda2.setBounds(10, 305, 90, 20);
		contentPanel.add(txtVenda2);
		
		JLabel lblVenda_1 = new JLabel("Venda");
		lblVenda_1.setBounds(10, 287, 90, 14);
		contentPanel.add(lblVenda_1);
		
		JLabel lblComissoVend = new JLabel("Comiss\u00E3o");
		lblComissoVend.setBounds(105, 287, 90, 14);
		contentPanel.add(lblComissoVend);
		
		txtComissaoVenda = new JTextField();
		txtComissaoVenda.setText("0,00");
		txtComissaoVenda.setEnabled(false);
		txtComissaoVenda.setDisabledTextColor(Color.BLACK);
		txtComissaoVenda.setColumns(10);
		txtComissaoVenda.setBounds(105, 305, 90, 20);
		contentPanel.add(txtComissaoVenda);
		
		txtCobranca2 = new JTextField();
		txtCobranca2.setText("0,00");
		txtCobranca2.setEnabled(false);
		txtCobranca2.setDisabledTextColor(Color.BLACK);
		txtCobranca2.setColumns(10);
		txtCobranca2.setBounds(10, 354, 90, 20);
		contentPanel.add(txtCobranca2);
		
		JLabel txtCobranca = new JLabel("Cobran\u00E7a");
		txtCobranca.setBounds(10, 336, 90, 14);
		contentPanel.add(txtCobranca);
		
		JLabel txtComissaoCobr = new JLabel("Comiss\u00E3o");
		txtComissaoCobr.setBounds(105, 336, 90, 14);
		contentPanel.add(txtComissaoCobr);
		
		txtcomissaoCob = new JTextField();
		txtcomissaoCob.setText("0,00");
		txtcomissaoCob.setEnabled(false);
		txtcomissaoCob.setDisabledTextColor(Color.BLACK);
		txtcomissaoCob.setColumns(10);
		txtcomissaoCob.setBounds(105, 354, 90, 20);
		contentPanel.add(txtcomissaoCob);
		
				JLabel lblSaldoQuitao = new JLabel("Saldo Quita\u00E7\u00E3o");
				lblSaldoQuitao.setBounds(214, 336, 90, 14);
				contentPanel.add(lblSaldoQuitao);
				
						txtSaldoQuitacao = new JTextField();
						txtSaldoQuitacao.setBounds(214, 354, 90, 20);
						contentPanel.add(txtSaldoQuitacao);
						txtSaldoQuitacao.setText("0,00");
						txtSaldoQuitacao.setEnabled(false);
						txtSaldoQuitacao.setDisabledTextColor(Color.BLACK);
						txtSaldoQuitacao.setColumns(10);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnOk = new JButton("OK");
				btnOk.setActionCommand("OK");
				btnOk.addActionListener(this);
				buttonPane.add(btnOk);
				getRootPane().setDefaultButton(btnOk);
			}
			{
				JButton btnCancelar = new JButton("Cancelar");
				btnCancelar.addActionListener(this);
				btnCancelar.setActionCommand("Cancelar");
				buttonPane.add(btnCancelar);
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String acao = e.getActionCommand();

		switch (acao) {
		case "OK":
			salvar();
			break;
		case "Cancelar":
			dispose();
			break;
		case "Buscar":
			buscar();
			break;
		default:
			break;
		}

	}

	private void salvar() {
		try {

			Funcionario vendedor = (Funcionario) banco.buscarPorId(Funcionario.class,
					Integer.parseInt(txtId.getText()));
			float venda = Float.parseFloat(txtVenda.getText().replace(",", "."));
			float percComissaoVenda = Float.parseFloat(txtPercentualVenda.getText().replace(",", "."));
			float valeLocal = Float.parseFloat(txtPromissoaria.getText().replace(",", "."));
			float valeViagem = Float.parseFloat(txtVale.getText().replace(",", "."));
			float quitado = Float.parseFloat(txtQuitado.getText().replace(",", "."));
			float devolvido = Float.parseFloat(txtDevolvido.getText().replace(",", "."));
			float perca = Float.parseFloat(txtPerdido.getText().replace(",", "."));
			float quitadoParcial = Float.parseFloat(txtRecebidoParc.getText().replace(",", "."));
			float percaParcial = Float.parseFloat(txtPerdidoParc.getText().replace(",", "."));
			float percComissaoCobrancao = Float.parseFloat(txtPercCobranca.getText().replace(",", "."));
			float dinheiroEntrada = Float.parseFloat(txtEntrada.getText().replace(",", "."));
			Integer quantFicha = Integer.parseInt(txtFichas.getText());
			VendedorEquipe vendedorIns = new VendedorEquipe(equipe, vendedor, venda, percComissaoVenda, valeLocal,
					valeViagem, quitado, devolvido, perca, quitadoParcial, percaParcial, percComissaoCobrancao,
					dinheiroEntrada, quantFicha);

			if (vendedorEquipe != null) {
				System.out.println("vendedorequipe não nulo setou id como "+vendedorEquipe.getId());
				vendedorIns.setId(vendedorEquipe.getId());
			}
			banco.salvarOuAtualizarObjeto(vendedorIns);
			JOptionPane.showMessageDialog(contentPanel, "Salvo com sucesso");
			dispose();
		} catch (java.lang.NullPointerException e) {
			JOptionPane.showMessageDialog(contentPanel, "Escolha numeros válidos");
		}catch (Exception e) {
			System.out.println(e);
			JOptionPane.showMessageDialog(contentPanel, e.getMessage());
		}

	}

	private void buscar() {
		try {

			JFrmPesFuncionario func = new JFrmPesFuncionario();
			func.moduloEscolher();
			func.setModal(true);
			func.setVisible(true);
			Funcionario p = (Funcionario) func.getObj();
			txtId.setText(String.valueOf(p.getId()));
			txtNome.setText(String.valueOf(p.getNome() + " " + String.valueOf(p.getSobrenome())));
			func.dispose();
		} catch (java.lang.NullPointerException e) {
			JOptionPane.showMessageDialog(contentPanel, "Escolha um funcionario para inserir");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(contentPanel, e.getMessage());
			dispose();
		}

	}

	public boolean inserir(VendedorEquipe vendedor) {
		try {
			
			this.vendedorEquipe = vendedor;
			txtId.setText(String.valueOf(vendedor.getVendedor().getId()));
			txtVenda.setText(String.valueOf(vendedor.getvenda()));
			txtNome.setText(String.valueOf(vendedor.getVendedor().getNome()));
			txtDevolvido.setText(String.valueOf(vendedor.getdevolvido()));
			txtEntrada.setText(String.valueOf(vendedor.getDinheiroEntrada()));
			txtFichas.setText(String.valueOf(vendedor.getQuantFicha()));
			txtPercCobrado.setText(String.valueOf(vendedor.getPercCobrado()));
			txtPercCobranca.setText(String.valueOf(vendedor.getPercComissaoCobrancao()));
			txtPercentualVenda.setText(String.valueOf(vendedor.getPercComissaoVenda()));
			txtPerdido.setText(String.valueOf(vendedor.getPerca()));
			txtQuitado.setText(String.valueOf(vendedor.getquitado()));
			txtPromissoaria.setText(String.valueOf(vendedor.getValeLocal()));
			txtVale.setText(String.valueOf(vendedor.getValeViagem()));
			txtRecebidoParc.setText(String.valueOf(vendedor.getquitadoParcial()));
			txtPerdidoParc.setText(String.valueOf(vendedor.getPercaParcial()));
			
			
			txtSaldoVenda.setText(String.valueOf(vendedor.getSaldoVenda()));
			txtPercCobrado.setText(String.valueOf(vendedor.getPercCobrado()));
			txtTotalCobranca.setText(String.valueOf(vendedor.getVenda()));
			txtSaldoQuitacao.setText(String.valueOf(vendedor.getVlrSaldoQuitacao()));
			
			txtVenda2.setText(txtVenda.getText());
			txtCobranca2.setText(String.valueOf(vendedor.getRecebidoTotal()));
			txtComissaoVenda.setText(String.valueOf(vendedor.getVlrComissaoVenda()));
			txtcomissaoCob.setText(String.valueOf(vendedor.getVlrComissaoCobranca()));
			
			return true;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(contentPanel, e.getMessage());
			return false;
		}

	}

	public boolean moduloVenda() {
		try {
			
	
		btnBuscar.setEnabled(true);
		txtPromissoaria.setEnabled(true);
		txtVale.setEnabled(true);
		txtPercentualVenda.setEnabled(true);
		txtPercCobranca.setEnabled(true);
		txtVenda.setEnabled(true);
		txtEntrada.setEnabled(true);
		txtFichas.setEnabled(true);

		return true;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(contentPanel, e.getMessage());
			return false;
		}

	}

	public boolean moduloCobranca() {
		try {
			
		
		btnBuscar.setEnabled(false);
		txtDevolvido.setEnabled(true);
		txtPerdido.setEnabled(true);
		txtQuitado.setEnabled(true);
		txtRecebidoParc.setEnabled(true);
		txtPerdidoParc.setEnabled(true);
		txtSaldoQuitacao.setEnabled(false);
		txtPercCobrado.setEnabled(false);
		return true;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(contentPanel, e.getMessage());
			return false;
		}

	}
}
