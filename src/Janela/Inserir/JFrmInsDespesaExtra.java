package Janela.Inserir;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import com.toedter.calendar.JDateChooser;

import Bin.DespExtra;
import Bin.Equipe.Equipe;
import Persistence.Dao;

import java.util.Date;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JFrmInsDespesaExtra extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtDescricao;
	private JTextField txtValor;
	private Equipe equpe;
	private DespExtra despExtra=null;
	private JDateChooser data;
	private Dao banco= new Dao();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			JFrmInsDespesaExtra dialog = new JFrmInsDespesaExtra(null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public JFrmInsDespesaExtra(Equipe equipe) {
		this.equpe = equipe;
		setTitle("Lan\u00E7amento de Despesa Extra");
		setBounds(100, 100, 450, 184);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		setAlwaysOnTop(true);
		setLocationRelativeTo(null);

		txtDescricao = new JTextField();
		txtDescricao.setText("0");
		txtDescricao.setDisabledTextColor(Color.BLACK);
		txtDescricao.setColumns(10);
		txtDescricao.setBounds(10, 29, 414, 20);
		contentPanel.add(txtDescricao);

		JLabel lblDescrio = new JLabel("Descri\u00E7\u00E3o");
		lblDescrio.setBounds(10, 11, 90, 14);
		contentPanel.add(lblDescrio);

		txtValor = new JTextField();
		txtValor.setText("0");
		txtValor.setDisabledTextColor(Color.BLACK);
		txtValor.setColumns(10);
		txtValor.setBounds(10, 78, 90, 20);
		contentPanel.add(txtValor);

		JLabel lblvalor = new JLabel("Valor");
		lblvalor.setBounds(10, 60, 90, 14);
		contentPanel.add(lblvalor);

		JLabel Data = new JLabel("Data");
		Data.setBounds(110, 60, 90, 14);
		contentPanel.add(Data);

		data = new JDateChooser(new Date());
		data.setBounds(110, 78, 116, 20);
		contentPanel.add(data);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						salvar();
						dispose();
					}

				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

	private void salvar() {
		try {
			
		
		
		float valor= Float.parseFloat(txtValor.getText().replace(",", "."));
		String descricao=txtDescricao.getText().toUpperCase();
		DespExtra de = new DespExtra(descricao, valor, data.getDate(), equpe);
		
		if (despExtra!=null) {
			de.setId(despExtra.getId());
		}
		boolean a =banco.salvarOuAtualizarObjeto(de);
		if (a) {
			JOptionPane.showMessageDialog(contentPanel, "Salvo com sucesso");
		}} catch (Exception e) {
			JOptionPane.showMessageDialog(contentPanel, e.getMessage());
		}
		
	}

	public boolean inserir(DespExtra desp) {
		try {
			this.despExtra = desp;
			txtDescricao.setText(String.valueOf(desp.getDescricao()));
			txtValor.setText(String.valueOf(desp.getValor()));
			data.setDate(desp.getData());

			return true;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(contentPanel, e.getMessage());
			return false;
		}
	}
}
