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
import Bin.Funcionario.Cobrador;
import Bin.Funcionario.Funcionario;
import Janela.Pesquisa.JFrmPesFuncionario;
import Persistence.Dao;

import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class JFrmInsCobrador extends JDialog implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtIdFuncionario;
	private JTextField txtNomeFuncionario;
	private JTextField txtPromissoria;
	private JTextField txtPercComissao;
	private JTextField txtTotalVend;
	private JTextField txtTotalRecbido;
	private JTextField txtComissao;
	private Equipe equipe;
	private Dao banco = new Dao();
	private Cobrador cobradorEquipe = null;

	public Cobrador getCobradorEquipe() {
		return cobradorEquipe;
	}

	public void setCobradorEquipe(Cobrador cobradorEquipe) {
		this.cobradorEquipe = cobradorEquipe;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			JFrmInsCobrador dialog = new JFrmInsCobrador(null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public JFrmInsCobrador(Equipe equipe) {
		this.equipe = equipe;
		setTitle("Cadastro e Altera\u00E7\u00E3o do cobrador de equipe");
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
			JLabel lblComisso = new JLabel("% Comiss\u00E3o");
			lblComisso.setBounds(105, 62, 79, 14);
			contentPanel.add(lblComisso);
		}
		{
			txtPercComissao = new JTextField();
			txtPercComissao.setText("3");
			txtPercComissao.setDisabledTextColor(Color.BLACK);
			txtPercComissao.setColumns(10);
			txtPercComissao.setBounds(105, 80, 60, 20);
			contentPanel.add(txtPercComissao);
		}
		{
			JLabel lblVendido = new JLabel("Venda");
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
			txtComissao = new JTextField();
			txtComissao.setText("0,00");
			txtComissao.setEnabled(false);
			txtComissao.setDisabledTextColor(Color.BLACK);
			txtComissao.setColumns(10);
			txtComissao.setBounds(10, 168, 90, 20);
			contentPanel.add(txtComissao);
		}
		{
			JButton btnBuscar = new JButton("Buscar");
			btnBuscar.addActionListener(this);
			btnBuscar.setBounds(240, 80, 89, 20);
			contentPanel.add(btnBuscar);
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

			Funcionario cobrador = (Funcionario) banco.buscarPorId(Funcionario.class,
					Integer.parseInt(txtIdFuncionario.getText()));

			float percComissao = Float.parseFloat(txtPercComissao.getText().replace(",", "."));
			float valeCobrador = Float.parseFloat(txtPromissoria.getText().replace(",", "."));
			Cobrador cobradorEq = new Cobrador(cobrador, percComissao, valeCobrador, 0);
			if (cobradorEquipe != null) {
				cobradorEq.setId(cobradorEquipe.getId());
			}
			banco.salvarOuAtualizarObjeto(cobradorEq);
			JOptionPane.showMessageDialog(contentPanel, "Salvo com sucesso");
			this.cobradorEquipe = cobradorEq;
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

	public boolean inserir(Cobrador cobrador) {
		try {

			this.cobradorEquipe = cobrador;
			txtIdFuncionario.setText(String.valueOf(cobrador.getCobrador().getId()));
			txtNomeFuncionario.setText(String.valueOf(cobrador.getCobrador().getNome()));
			txtPromissoria.setText(String.valueOf(cobrador.getValeCobrador()));
			float perVen = cobrador.getPercComissao();
			txtPercComissao.setText(String.valueOf(perVen));

			float venda = equipe.getVenda().getVendaPraso();
			txtTotalVend.setText(String.valueOf(venda));
			float cobrado = equipe.getCobranca().getRecebidoTotal();
			txtTotalRecbido.setText(String.valueOf(cobrado));

			float comVend = perVen * venda / 100;
			txtComissao.setText(String.valueOf(comVend));

			return true;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(contentPanel, e.getMessage());
			return false;
		}

	}

}
