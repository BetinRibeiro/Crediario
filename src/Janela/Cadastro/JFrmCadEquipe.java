package Janela.Cadastro;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Bin.Equipe.Equipe;
import Bin.Funcionario.Funcionario;
import Janela.Pesquisa.JFrmPesFuncionario;
import Persistence.Dao;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JFrmCadEquipe extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtId;
	private JTextField txtTitulo;
	private JTextField txtIdChefe;
	private JTextField txtNomeChefe;
	private JTextField txtValeChefe;
	private JTextField txtPercentualComissaoChefe;
	private JButton btnBuscar;
	private Dao banco = new Dao();
	private Equipe equipe;

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
		setBounds(100, 100, 476, 287);
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
		txtValeChefe.setBounds(10, 165, 86, 20);
		contentPanel.add(txtValeChefe);
		txtValeChefe.setColumns(10);

		JLabel lblValorDoVale = new JLabel("Valor do Vale");
		lblValorDoVale.setBounds(10, 145, 86, 14);
		contentPanel.add(lblValorDoVale);

		JLabel lblCodigo = new JLabel("Codigo");
		lblCodigo.setBounds(10, 100, 86, 14);
		contentPanel.add(lblCodigo);

		JLabel lblResponsavelPelaEquipe = new JLabel("Responsavel pela Equipe");
		lblResponsavelPelaEquipe.setBounds(106, 100, 247, 14);
		contentPanel.add(lblResponsavelPelaEquipe);

		txtPercentualComissaoChefe = new JTextField();
		txtPercentualComissaoChefe.setColumns(10);
		txtPercentualComissaoChefe.setBounds(106, 165, 99, 20);
		contentPanel.add(txtPercentualComissaoChefe);

		JLabel lblDaComisso = new JLabel("% da Comiss\u00E3o");
		lblDaComisso.setBounds(106, 145, 86, 14);
		contentPanel.add(lblDaComisso);
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
		String titulo = txtTitulo.getText();
		Funcionario chefe = (Funcionario) banco.buscarPorId(Funcionario.class, Integer.parseInt(txtIdChefe.getText()));
		float percentualChefe = Float.parseFloat(txtPercentualComissaoChefe.getText());
		Equipe equipe = new Equipe(titulo, chefe, percentualChefe);
		equipe.setValeChefe(Float.parseFloat(txtValeChefe.getText()));
		boolean liberado = false;
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

	public boolean inserirEquipe(Equipe equipe) {
		try {
			this.equipe = equipe;
			setTitle("Alteração de dados Equipe");
			txtId.setText(String.valueOf(equipe.getId()));
			txtPercentualComissaoChefe.setText(String.valueOf(equipe.getPercentualChefe()));
			txtTitulo.setText(equipe.getTitulo());
			txtValeChefe.setText(String.valueOf(equipe.getValeChefe()));
			txtIdChefe.setText(String.valueOf(equipe.getChefe().getId()));
			txtNomeChefe.setText(equipe.getChefe().getNome() + " " + equipe.getChefe().getSobrenome());
			return true;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(contentPanel, "Erro no sistema");
			dispose();
			return false;
		}

	}

}
