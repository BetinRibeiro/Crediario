package Janela.Inserir;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Bin.Equipe.Equipe;
import Bin.Funcionario.ChefeEquipe;
import Bin.Funcionario.Funcionario;
import Janela.Pesquisa.JFrmPesFuncionario;
import Persistence.Dao;

import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class JFrmInsChefe extends JDialog implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtIdFuncionario;
	private JTextField txtNomeFuncionario;
	private JTextField txtPromissoria;
	private JTextField txtPercVenda;
	private JTextField txtPercCobr;
	private JTextField txtTotalVend;
	private JTextField txtTotalRecbido;
	private JTextField txtComissaoVenda;
	private JTextField txtTotalComissaoCobranca;
	private JTextField txtSandoQuitacao;
	private Equipe equipe;
	private Dao banco = new Dao();
	private ChefeEquipe chefeEquipe = null;

	public ChefeEquipe getChefeEquipe() {
		return chefeEquipe;
	}

	public void setChefeEquipe(ChefeEquipe chefeEquipe) {
		this.chefeEquipe = chefeEquipe;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			JFrmInsChefe dialog = new JFrmInsChefe(null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public JFrmInsChefe(Equipe equipe) {
		this.equipe = equipe;
		setTitle("Cadastro e Altera\u00E7\u00E3o do chefe de equipe");
		setBounds(100, 100, 362, 279);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		setAlwaysOnTop(true);
		setLocationRelativeTo(null);
		{
			txtIdFuncionario = new JTextField();
			txtIdFuncionario.setEnabled(false);
			txtIdFuncionario.setColumns(10);
			txtIdFuncionario.setBackground(new Color(255, 250, 205));
			txtIdFuncionario.setBounds(10, 30, 65, 20);
			contentPanel.add(txtIdFuncionario);
		}
		{
			JLabel label = new JLabel("C\u00F3digo");
			label.setBounds(10, 11, 46, 14);
			contentPanel.add(label);
		}
		{
			JLabel lblNomeDoChefe = new JLabel("Nome do Chefe da Equipe");
			lblNomeDoChefe.setBounds(80, 11, 246, 14);
			contentPanel.add(lblNomeDoChefe);
		}
		{
			txtNomeFuncionario = new JTextField();
			txtNomeFuncionario.setEnabled(false);
			txtNomeFuncionario.setColumns(10);
			txtNomeFuncionario.setBackground(new Color(255, 250, 205));
			txtNomeFuncionario.setBounds(80, 30, 246, 20);
			contentPanel.add(txtNomeFuncionario);
		}
		{
			JLabel label = new JLabel("Promissoria");
			label.setBounds(10, 63, 90, 14);
			contentPanel.add(label);
		}
		{
			txtPromissoria = new JTextField();
			txtPromissoria.setText("0,00");
			txtPromissoria.setDisabledTextColor(Color.BLACK);
			txtPromissoria.setColumns(10);
			txtPromissoria.setBounds(10, 81, 90, 20);
			contentPanel.add(txtPromissoria);
		}
		{
			JLabel label = new JLabel("% Venda");
			label.setBounds(105, 62, 63, 14);
			contentPanel.add(label);
		}
		{
			txtPercVenda = new JTextField();
			txtPercVenda.setText("3");
			txtPercVenda.setDisabledTextColor(Color.BLACK);
			txtPercVenda.setColumns(10);
			txtPercVenda.setBounds(105, 80, 60, 20);
			contentPanel.add(txtPercVenda);
		}
		{
			JLabel label = new JLabel("% Cobranca");
			label.setBounds(170, 61, 90, 14);
			contentPanel.add(label);
		}
		{
			txtPercCobr = new JTextField();
			txtPercCobr.setText("5");
			txtPercCobr.setDisabledTextColor(Color.BLACK);
			txtPercCobr.setColumns(10);
			txtPercCobr.setBounds(170, 80, 60, 20);
			contentPanel.add(txtPercCobr);
		}
		{
			JLabel lblVendido = new JLabel("Vendido");
			lblVendido.setBounds(10, 107, 90, 14);
			contentPanel.add(lblVendido);
		}
		{
			txtTotalVend = new JTextField();
			txtTotalVend.setText("0,00");
			txtTotalVend.setEnabled(false);
			txtTotalVend.setDisabledTextColor(Color.BLACK);
			txtTotalVend.setColumns(10);
			txtTotalVend.setBounds(10, 125, 90, 20);
			contentPanel.add(txtTotalVend);
		}
		{
			JLabel lblRecebido = new JLabel("Recebido");
			lblRecebido.setBounds(105, 107, 90, 14);
			contentPanel.add(lblRecebido);
		}
		{
			txtTotalRecbido = new JTextField();
			txtTotalRecbido.setText("0,00");
			txtTotalRecbido.setEnabled(false);
			txtTotalRecbido.setDisabledTextColor(Color.BLACK);
			txtTotalRecbido.setColumns(10);
			txtTotalRecbido.setBounds(105, 125, 90, 20);
			contentPanel.add(txtTotalRecbido);
		}
		{
			JLabel lblComissao = new JLabel("Comissao");
			lblComissao.setBounds(10, 150, 90, 14);
			contentPanel.add(lblComissao);
		}
		{
			txtComissaoVenda = new JTextField();
			txtComissaoVenda.setText("0,00");
			txtComissaoVenda.setEnabled(false);
			txtComissaoVenda.setDisabledTextColor(Color.BLACK);
			txtComissaoVenda.setColumns(10);
			txtComissaoVenda.setBounds(10, 168, 90, 20);
			contentPanel.add(txtComissaoVenda);
		}
		{
			JLabel lblComissao_1 = new JLabel("Comissao");
			lblComissao_1.setBounds(105, 150, 90, 14);
			contentPanel.add(lblComissao_1);
		}
		{
			txtTotalComissaoCobranca = new JTextField();
			txtTotalComissaoCobranca.setText("0,00");
			txtTotalComissaoCobranca.setEnabled(false);
			txtTotalComissaoCobranca.setDisabledTextColor(Color.BLACK);
			txtTotalComissaoCobranca.setColumns(10);
			txtTotalComissaoCobranca.setBounds(105, 168, 90, 20);
			contentPanel.add(txtTotalComissaoCobranca);
		}
		{
			JButton btnBuscar = new JButton("Buscar");
			btnBuscar.addActionListener(this);
			btnBuscar.setBounds(240, 80, 89, 20);
			contentPanel.add(btnBuscar);
		}
		{
			txtSandoQuitacao = new JTextField();
			txtSandoQuitacao.setText("0,00");
			txtSandoQuitacao.setEnabled(false);
			txtSandoQuitacao.setDisabledTextColor(Color.BLACK);
			txtSandoQuitacao.setColumns(10);
			txtSandoQuitacao.setBounds(208, 168, 90, 20);
			contentPanel.add(txtSandoQuitacao);
		}
		{
			JLabel lblSaldo = new JLabel("Saldo Quita\u00E7\u00E3o");
			lblSaldo.setBounds(208, 150, 90, 14);
			contentPanel.add(lblSaldo);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				okButton.addActionListener(this);
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.setActionCommand("Cancelar");
				cancelButton.addActionListener(this);
				buttonPane.add(cancelButton);
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

			Funcionario funcionarioChefe = (Funcionario) banco.buscarPorId(Funcionario.class,
					Integer.parseInt(txtIdFuncionario.getText()));

			float percentualVenda = Float.parseFloat(txtPercVenda.getText().replace(",", "."));
			float percentualCobranca = Float.parseFloat(txtPercCobr.getText().replace(",", "."));
			float valeChefe = Float.parseFloat(txtPromissoria.getText().replace(",", "."));
			ChefeEquipe chefeEq = new ChefeEquipe(funcionarioChefe, percentualVenda, percentualCobranca, 0, valeChefe);

			if (chefeEquipe != null) {
				chefeEq.setId(chefeEquipe.getId());
			}
			banco.salvarOuAtualizarObjeto(chefeEq);
			JOptionPane.showMessageDialog(contentPanel, "Salvo com sucesso");
			chefeEquipe = chefeEq;
			dispose();
		} catch (Exception e) {
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
			txtIdFuncionario.setText(String.valueOf(p.getId()));
			txtNomeFuncionario.setText(String.valueOf(p.getNome() + " " + String.valueOf(p.getSobrenome())));
			func.dispose();
		} catch (java.lang.NullPointerException e) {
			JOptionPane.showMessageDialog(contentPanel, "Escolha um funcionario para inserir");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(contentPanel, e.getMessage());
			dispose();
		}

	}

	public boolean inserir(ChefeEquipe chefe) {
		try {

			this.chefeEquipe = chefe;
			txtIdFuncionario.setText(String.valueOf(chefe.getChefe().getId()));
			txtNomeFuncionario.setText(String.valueOf(chefe.getChefe().getNome()));
			txtPromissoria.setText(String.valueOf(chefe.getValeChefe()));
			float perVen = chefe.getPercentualVenda();
			txtPercVenda.setText(String.valueOf(perVen));
			float perCob = chefe.getPercentualCobranca();
			txtPercCobr.setText(String.valueOf(perCob));
			float venda = equipe.getVenda().getVendaPraso();
			txtTotalVend.setText(String.valueOf(venda));
			float cobrado = equipe.getCobranca().getRecebidoTotal();
			txtTotalRecbido.setText(String.valueOf(cobrado));
			float comVend = perVen * venda / 100;
			txtComissaoVenda.setText(String.valueOf(comVend));
			float comCob = cobrado * comVend / 100;
			txtTotalComissaoCobranca.setText(String.valueOf(comCob));
			float saldoQuitacao = comCob - comVend;
			txtSandoQuitacao.setText(String.valueOf(saldoQuitacao));

			return true;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(contentPanel, e.getMessage());
			return false;
		}

	}

}
