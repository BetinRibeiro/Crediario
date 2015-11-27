package Janela.Cadastro;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Bin.Despesa;
import Bin.Equipe.Cobranca;
import Bin.Equipe.Deposito;
import Bin.Equipe.Equipe;
import Bin.Equipe.Venda;
import Bin.Equipe.VendedorEquipe;
import Bin.Funcionario.ChefeEquipe;
import Bin.Funcionario.Cobrador;
import Bin.Funcionario.Funcionario;
import Bin.Mercadoria.Carrada;
import Bin.Retorno.Retorno;
import Bin.Transporte.TransporteViagem;
import Janela.Pesquisa.JFrmPesFuncionario;
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
	private JTextField txtValeChefe;
	private JTextField txtPercentualComissaoChefe;
	private JButton btnBuscar;
	private Dao banco = new Dao();
	private Equipe equipe = null;
	private JTextField txtNomeCobrador;
	private JTextField txtIdCobrador;
	private JButton buscarCobrador;

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
		setBounds(100, 100, 476, 334);
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

		txtValeChefe = new JTextField();
		txtValeChefe.setBounds(10, 232, 86, 20);
		contentPanel.add(txtValeChefe);
		txtValeChefe.setColumns(10);

		JLabel lblValorDoVale = new JLabel("Valor do Vale");
		lblValorDoVale.setBounds(10, 212, 86, 14);
		contentPanel.add(lblValorDoVale);

		JLabel lblCodigo = new JLabel("Codigo");
		lblCodigo.setBounds(10, 100, 86, 14);
		contentPanel.add(lblCodigo);

		JLabel lblResponsavelPelaEquipe = new JLabel("Responsavel pela Equipe");
		lblResponsavelPelaEquipe.setBounds(106, 100, 247, 14);
		contentPanel.add(lblResponsavelPelaEquipe);

		txtPercentualComissaoChefe = new JTextField();
		txtPercentualComissaoChefe.setColumns(10);
		txtPercentualComissaoChefe.setBounds(106, 232, 99, 20);
		contentPanel.add(txtPercentualComissaoChefe);

		JLabel lblDaComisso = new JLabel("% da Comiss\u00E3o");
		lblDaComisso.setBounds(106, 212, 86, 14);
		contentPanel.add(lblDaComisso);
		
		txtNomeCobrador = new JTextField();
		txtNomeCobrador.setEnabled(false);
		txtNomeCobrador.setDisabledTextColor(Color.BLACK);
		txtNomeCobrador.setColumns(10);
		txtNomeCobrador.setBackground(new Color(224, 255, 255));
		txtNomeCobrador.setBounds(106, 179, 247, 20);
		contentPanel.add(txtNomeCobrador);
		
		JLabel lblResponsavelPelaCobrana = new JLabel("Responsavel pela Cobran\u00E7a");
		lblResponsavelPelaCobrana.setBounds(106, 158, 247, 14);
		contentPanel.add(lblResponsavelPelaCobrana);
		
		JLabel label_1 = new JLabel("Codigo");
		label_1.setBounds(10, 158, 86, 14);
		contentPanel.add(label_1);
		
		txtIdCobrador = new JTextField();
		txtIdCobrador.setEnabled(false);
		txtIdCobrador.setDisabledTextColor(Color.BLACK);
		txtIdCobrador.setColumns(10);
		txtIdCobrador.setBackground(new Color(224, 255, 255));
		txtIdCobrador.setBounds(10, 179, 86, 20);
		contentPanel.add(txtIdCobrador);
		
		buscarCobrador = new JButton("Buscar");
		buscarCobrador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				buscarCobrador();
			}

			
		});
		buscarCobrador.setBounds(363, 178, 89, 23);
		
		contentPanel.add(buscarCobrador);
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

	private void salvar() {
		
		//criamos aqui a estrutura que compom a equipe
		
		//primeiro o chefe de equipe 
		Funcionario chefe = (Funcionario) banco.buscarPorId(Funcionario.class, Integer.parseInt(txtIdChefe.getText()));
		float percentualVenda = Float.parseFloat(txtPercentualComissaoChefe.getText());
		float valeChefe = Float.parseFloat(txtValeChefe.getText());
		ChefeEquipe chefeEquipe = new ChefeEquipe(chefe, percentualVenda, 0, valeChefe);
		//salvamos o chefe no banco para criar um id válido
		boolean salv = banco.salvarObjeto(chefeEquipe);
		System.out.println("salvou chefe : "+salv);
		
		
		//segundo uma despesa para compor a venda, todos os valores nulos ou vazios 
		Despesa despesa= new Despesa(0, 0, 0, 0, 0, 0);
		Venda venda = new Venda(null, null, 0, 0, 0, 0, 0, 0, null, null, "", "", despesa, 0, 0);
		//salvamos no banco para gerar um id 
		salv = banco.salvarObjeto(venda);
		System.out.println("salvou venda : "+salv);
		
		Funcionario funcionarioCobr = (Funcionario) banco.buscarPorId(Funcionario.class, Integer.parseInt(txtIdCobrador.getText()));
		
		Cobrador cobrador = new Cobrador(funcionarioCobr, 0, 0);
		
		salv=banco.salvarObjeto(cobrador);
		salv=banco.salvarObjeto(despesa);
		System.out.println("salvou cobrador	 : "+salv);
		Cobranca cobranca = new Cobranca(null, null, 0, cobrador, 0, 0, 0, 0, 0, 0, despesa, 0, 0);
		salv=banco.salvarObjeto(cobranca);
		System.out.println("salvou cobranca : "+salv);

		String titulo=txtTitulo.getText();
		Set<TransporteViagem> traspViagem= new HashSet<>();
		Set<Deposito> deposito= new HashSet<>();
		Set<Carrada> carrada= new HashSet<>();
		Set<VendedorEquipe> vendedor= new HashSet<>();
		Set<Retorno> retorno= new HashSet<>();
		Equipe equipe = new Equipe(titulo, traspViagem, deposito, carrada, vendedor, retorno, venda, cobranca, chefeEquipe);
		boolean liberado = false;
		System.out.println("salvou equipe : "+liberado);
		if (txtId.getText().length() > 0) {
			equipe.setId(Integer.parseInt(txtId.getText()));
			liberado = banco.salvarOuAtualizarObjeto(equipe);

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

	}

	private void buscar() {
		try {

			JFrmPesFuncionario func = new JFrmPesFuncionario();
			func.moduloEscolher();
			func.setModal(true);
			func.setVisible(true);
			Funcionario p = (Funcionario) func.getObj();
			txtIdChefe.setText(String.valueOf(p.getId()));
			txtNomeChefe.setText(String.valueOf(p.getNome() + " " + String.valueOf(p.getSobrenome())));
			func.dispose();
		} catch (java.lang.NullPointerException e) {
			JOptionPane.showMessageDialog(contentPanel, "Escolha um funcionario para inserir");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(contentPanel, "ERRO! Refaça o cadastro novamente ");
			dispose();
		}

	}
	private void buscarCobrador() {
		try {

			JFrmPesFuncionario func = new JFrmPesFuncionario();
			func.moduloEscolher();
			func.setModal(true);
			func.setVisible(true);
			Funcionario p = (Funcionario) func.getObj();
			txtIdCobrador.setText(String.valueOf(p.getId()));
			txtNomeCobrador.setText(String.valueOf(p.getNome() + " " + String.valueOf(p.getSobrenome())));
			func.dispose();
		} catch (java.lang.NullPointerException e) {
			JOptionPane.showMessageDialog(contentPanel, "Escolha um funcionario para inserir");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(contentPanel, "ERRO! Refaça o cadastro novamente ");
			dispose();
		}
		
	}

	public boolean inserirEquipe(Equipe equipe) {
		try {
			this.setEquipe(equipe);
			setTitle("Alteração de dados Equipe");
			txtId.setText(String.valueOf(equipe.getId()));
			txtPercentualComissaoChefe.setText(String.valueOf(equipe.getChefe().getPercentualVenda()));
			txtTitulo.setText(equipe.getTitulo());
			txtValeChefe.setText(String.valueOf(equipe.getChefe().getValeChefe()));
			txtIdChefe.setText(String.valueOf(equipe.getChefe().getId()));
			txtNomeChefe.setText(
					equipe.getChefe().getChefe().getNome() + " " + equipe.getChefe().getChefe().getSobrenome());
			return true;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(contentPanel, "Erro no sistema");
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
}
