package Janela.Cadastro;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Bin.DespExtra;
import Bin.Despesa;
import Bin.ReceitaExtra;
import Bin.Devolucao.Devolucao;
import Bin.Equipe.Cobranca;
import Bin.Equipe.Deposito;
import Bin.Equipe.Equipe;
import Bin.Equipe.Venda;
import Bin.Equipe.VendedorEquipe;
import Bin.Funcionario.ChefeEquipe;
import Bin.Funcionario.Cobrador;
import Bin.Mercadoria.Carrada;
import Bin.Retorno.Retorno;
import Bin.Transporte.TransporteViagem;
import Janela.Inserir.JFrmInsChefe;
import Janela.Inserir.JFrmInsCobrador;
import Persistence.Dao;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.Set;
import java.awt.event.ActionEvent;

public class JFrmCadEquipe extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtId;
	private JTextField txtTitulo;
	private JTextField txtIdChefe;
	private JTextField txtNomeChefe;
	private JButton btnBuscar;
	private Dao banco = new Dao();
	private Equipe equipe = null;
	private JTextField txtIdCobrador;
	private JTextField txtNomeCobrador;
	private Cobrador cobrador;
	private ChefeEquipe chefe;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			JFrmCadEquipe dialog = new JFrmCadEquipe();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public JFrmCadEquipe() {
		setTitle("Cadastro de Equipe de Venda");
		setBounds(100, 100, 476, 307);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		setAlwaysOnTop(true);
		setLocationRelativeTo(null);

		JLabel lblCdigo = new JLabel("C\u00F3digo");
		lblCdigo.setBounds(10, 10, 46, 14);
		contentPanel.add(lblCdigo);

		txtId = new JTextField();
		txtId.setEnabled(false);
		txtId.setBackground(new Color(255, 250, 205));
		txtId.setBounds(10, 30, 86, 20);
		contentPanel.add(txtId);
		txtId.setColumns(10);

		txtTitulo = new JTextField();
		txtTitulo.setColumns(10);
		txtTitulo.setBounds(10, 75, 343, 20);
		contentPanel.add(txtTitulo);

		JLabel lblDescrio = new JLabel("Titulo da Forma\u00E7\u00E3o da Equipe");
		lblDescrio.setBounds(10, 55, 343, 14);
		contentPanel.add(lblDescrio);

		txtIdChefe = new JTextField();
		txtIdChefe.setEnabled(false);
		txtIdChefe.setDisabledTextColor(new Color(0, 0, 0));
		txtIdChefe.setBackground(new Color(224, 255, 255));
		txtIdChefe.setBounds(10, 121, 86, 20);
		contentPanel.add(txtIdChefe);
		txtIdChefe.setColumns(10);

		txtNomeChefe = new JTextField();
		txtNomeChefe.setEnabled(false);
		txtNomeChefe.setDisabledTextColor(new Color(0, 0, 0));
		txtNomeChefe.setBackground(new Color(224, 255, 255));
		txtNomeChefe.setColumns(10);
		txtNomeChefe.setBounds(106, 121, 247, 20);
		contentPanel.add(txtNomeChefe);

		btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buscar();
			}

		});
		btnBuscar.setBounds(363, 120, 89, 23);
		contentPanel.add(btnBuscar);

		JLabel lblCodigo = new JLabel("Codigo");
		lblCodigo.setBounds(10, 100, 86, 14);
		contentPanel.add(lblCodigo);

		JLabel lblResponsavelPelaEquipe = new JLabel("Responsavel pela Equipe");
		lblResponsavelPelaEquipe.setBounds(106, 100, 247, 14);
		contentPanel.add(lblResponsavelPelaEquipe);

		txtIdCobrador = new JTextField();
		txtIdCobrador.setEnabled(false);
		txtIdCobrador.setDisabledTextColor(Color.BLACK);
		txtIdCobrador.setColumns(10);
		txtIdCobrador.setBackground(new Color(224, 255, 255));
		txtIdCobrador.setBounds(10, 173, 86, 20);
		contentPanel.add(txtIdCobrador);

		JLabel label = new JLabel("Codigo");
		label.setBounds(10, 152, 86, 14);
		contentPanel.add(label);

		JLabel lblResponsavelPelaCobranca = new JLabel("Responsavel pela Cobranca");
		lblResponsavelPelaCobranca.setBounds(106, 152, 247, 14);
		contentPanel.add(lblResponsavelPelaCobranca);

		txtNomeCobrador = new JTextField();
		txtNomeCobrador.setEnabled(false);
		txtNomeCobrador.setDisabledTextColor(Color.BLACK);
		txtNomeCobrador.setColumns(10);
		txtNomeCobrador.setBackground(new Color(224, 255, 255));
		txtNomeCobrador.setBounds(106, 173, 247, 20);
		contentPanel.add(txtNomeCobrador);

		JButton btnBuscarCob = new JButton("Buscar");
		btnBuscarCob.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buscarCobrador();
			}

		});
		btnBuscarCob.setBounds(363, 172, 89, 23);
		contentPanel.add(btnBuscarCob);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						salvar();
					}

				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

	private void buscarCobrador() {
		try {
			JFrmInsCobrador iqui = new JFrmInsCobrador(equipe);
			iqui.setModal(true);
			if (!txtIdCobrador.getText().equals("")) {
				iqui.inserir(cobrador);
			}
			iqui.setVisible(true);
			setCobrador(iqui.getCobradorEquipe());
			txtIdCobrador.setText(String.valueOf(iqui.getCobradorEquipe().getId()));
			txtNomeCobrador.setText(String.valueOf(iqui.getCobradorEquipe().getCobrador().getNome()));
		} catch (java.lang.NullPointerException e) {
			JOptionPane.showMessageDialog(contentPanel, "Escolha um funcionario para inserir");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(contentPanel, "ERRO! Refaça o cadastro novamente ");
			dispose();
		}

	}

	private void salvar() {
		try {

			// criamos aqui a estrutura que compom a equipe

			// primeiro o chefe de equipe
			// Funcionario chefe = (Funcionario)
			// banco.buscarPorId(Funcionario.class,
			// Integer.parseInt(txtIdChefe.getText()));
			// float percentualVenda =
			// Float.parseFloat(txtPercentualComissaoChefe.getText());
			// float valeChefe = Float.parseFloat(txtValeChefe.getText());
			// salvamos o chefe no banco para criar um id válido
			boolean salv = banco.salvarObjeto(this.chefe);
			salv = banco.salvarObjeto(this.cobrador);
			System.out.println("salvou chefe : " + salv);

			String titulo = txtTitulo.getText().toUpperCase();

			if (equipe == null) {

				// segundo uma despesa para compor a venda, todos os valores
				// nulos
				// ou
				// vazios
				Despesa despesa = new Despesa(0, 0, 0, 0, 0, 0);
				// Venda venda = new Venda(null, null, 0, 0, 0, 0, 0, 0, null,
				// null,
				// "", "", despesa, 0, 0);
				Venda venda = new Venda(null, null, 0, 0, 0, 0, 0, 0, null, null, "", "", despesa, 0, 0, 0, 0);
				// salvamos no banco para gerar um id
				salv = banco.salvarObjeto(venda);
				System.out.println("salvou venda : " + salv);

				// Funcionario funcionarioCobr = (Funcionario)
				// banco.buscarPorId(Funcionario.class,
				// Integer.parseInt(txtIdCobrador.getText()));

				//

				despesa = new Despesa(0, 0, 0, 0, 0, 0);
				Cobranca cobranca = new Cobranca(null, null, 0, this.cobrador, 0, 0, 0, 0, 0, 0, despesa, 0, 0);
				salv = banco.salvarObjeto(cobranca);
				System.out.println("salvou cobranca : " + salv);

				Set<TransporteViagem> traspViagem = new HashSet<>();
				Set<Deposito> deposito = new HashSet<>();
				Set<Carrada> carrada = new HashSet<>();
				Set<VendedorEquipe> vendedor = new HashSet<>();
				Set<Retorno> retorno = new HashSet<>();
				Set<Devolucao> devolucao = new HashSet<>();
				Set<DespExtra> despExtra = new HashSet<>();
				float totalDepositos = 0;
				float totalDespExtra = 0;
				float valorManutencao = 0;
				float precoCarradas = 0;
				float custoCarradas = 0;
				float valorFretes = 0;
				float valesVendedores = 0;
				float comissaoVendedores = 0;
				float totalFichas = 0;
				float precoRetornos = 0;
				float custoRetornos = 0;
				float precoDevolucao = 0;
				float totalreceitaExtra = 0;
				Set<ReceitaExtra> receitaExtra = new HashSet<>();
				float custoDevolucao = 0;
				float dividaVendedores = 0;
				float metaVenda = 0;
				float lucroBruto=0;
				float lucroLiquido=0;
				float totalDespLocal=0;
				float saldoNegVend=0;
				equipe = new Equipe(titulo, chefe, venda, cobranca, traspViagem, valorManutencao, deposito,
						totalDepositos, metaVenda, carrada, precoCarradas, custoCarradas, valorFretes, vendedor,
						dividaVendedores, valesVendedores, comissaoVendedores, totalFichas, retorno, precoRetornos,
						custoRetornos, devolucao, precoDevolucao, custoDevolucao, despExtra, totalDespExtra,
						receitaExtra, totalreceitaExtra, lucroBruto, lucroLiquido,totalDespLocal,saldoNegVend);

			}
			equipe.setChefe(this.chefe);
			equipe.getCobranca().setCobrador(this.cobrador);
			equipe.setTitulo(titulo);

			boolean liberado = false;
			if (txtId.getText().length() > 0) {
				equipe.setId(Integer.parseInt(txtId.getText()));
				liberado = banco.salvarOuAtualizarObjeto(equipe);
				liberado = banco.salvarOuAtualizarObjeto(equipe.getCobranca());

			}
			if (txtId.getText().length() <= 0) {
				liberado = banco.salvarObjeto(equipe);

			}

			if (liberado) {
				JOptionPane.showMessageDialog(contentPanel, "Equipe salva com sucesso!!");
				dispose();
			}
			if (!liberado) {
				JOptionPane.showMessageDialog(contentPanel, "Erro ao salvar a equipe no banco.");
				dispose();
			}

		} catch (Exception e) {
			JOptionPane.showMessageDialog(contentPanel, e.getMessage());
		}
	}

	private void buscar() {
		try {
			JFrmInsChefe iqui = new JFrmInsChefe(equipe);
			iqui.setModal(true);
			if (!txtIdChefe.getText().equals("")) {
				iqui.setChefeEquipe(chefe);
			}
			iqui.setVisible(true);
			setChefe(iqui.getChefeEquipe());
			txtIdChefe.setText(String.valueOf(iqui.getChefeEquipe().getId()));
			txtNomeChefe.setText(String.valueOf(iqui.getChefeEquipe().getChefe().getNome()));
		} catch (java.lang.NullPointerException e) {
			JOptionPane.showMessageDialog(contentPanel, "Escolha um funcionario para inserir");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(contentPanel,e.getMessage());
			dispose();
		}

	}

	public boolean inserirEquipe(Equipe equipe) {
		try {
			this.setEquipe(equipe);
			setTitle("Alteração de dados Equipe");
			txtId.setText(String.valueOf(equipe.getId()));
			txtTitulo.setText(equipe.getTitulo());
			txtIdChefe.setText(String.valueOf(equipe.getChefe().getId()));
			txtNomeChefe.setText(
					equipe.getChefe().getChefe().getNome() + " " + equipe.getChefe().getChefe().getSobrenome());

			txtIdCobrador.setText(String.valueOf(equipe.getCobranca().getCobrador().getId()));
			txtNomeCobrador.setText(String.valueOf(equipe.getCobranca().getCobrador().getCobrador().getNome()));

			cobrador = equipe.getCobranca().getCobrador();
			chefe = equipe.getChefe();

			return true;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(contentPanel, e.getMessage());
			dispose();
			return false;
		}

	}

	public Equipe getEquipe() {
		return equipe;
	}

	public void setEquipe(Equipe equipe) {
		this.equipe = equipe;
	}

	public Cobrador getCobrador() {
		return cobrador;
	}

	public void setCobrador(Cobrador cobrador) {
		this.cobrador = cobrador;
	}

	public ChefeEquipe getChefe() {
		return chefe;
	}

	public void setChefe(ChefeEquipe chefe) {
		this.chefe = chefe;
	}
}
