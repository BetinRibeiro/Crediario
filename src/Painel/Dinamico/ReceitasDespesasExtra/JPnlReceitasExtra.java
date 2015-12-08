package Painel.Dinamico.ReceitasDespesasExtra;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JTable;

import Bin.ReceitaExtra;
import Bin.Equipe.Equipe;
import Janela.Inserir.JFrmInsReceitaExtra;
import Model.Tabela.ModelTabelaReceitaExtra;
import Persistence.Dao;

import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import java.awt.Color;
import javax.swing.SwingConstants;

import org.jboss.jandex.Main;

import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JMenuItem;

public class JPnlReceitasExtra extends JPanel implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable table;
	private ModelTabelaReceitaExtra model = new ModelTabelaReceitaExtra();
	private Equipe equipe;
	private Dao banco= new Dao();
	private JTextField txtValor;
	DecimalFormat df = new DecimalFormat("0.00");

	/**
	 * Create the panel.
	 */
	public JPnlReceitasExtra(Equipe equipe) {
		this.equipe = equipe;
		setBounds(0, 0, 727, 495);
		setLayout(null);
		
		JLabel foto2 = new JLabel();
		foto2.setBounds(600, 10, 20, 20);
		ImageIcon img2 = new ImageIcon(Main.class.getResource("/Imagens/v.png"));
		Image img02 = img2.getImage().getScaledInstance(foto2.getWidth(), foto2.getHeight(), Image.SCALE_DEFAULT);
		foto2.setIcon(new ImageIcon(img02));
		add(foto2);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 43, 707, 360);
		add(scrollPane);
		
		

		table = new JTable(model);
		scrollPane.setViewportView(table);
		JPopupMenu popupMenu = new JPopupMenu();
		table.getTableHeader().setReorderingAllowed(false);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.getColumn("DESCRIÇÃO").setPreferredWidth(200); 
//		table.getColumn("TELEFONE").setPreferredWidth(100); 
		addPopup(table, popupMenu);
		
		JMenuItem mntmDeletar = new JMenuItem("Deletar");
		mntmDeletar.addActionListener(this);
		popupMenu.add(mntmDeletar);
		
		JMenuItem mntmAlterar = new JMenuItem("Alterar");
		mntmAlterar.addActionListener(this);
		popupMenu.add(mntmAlterar);

		JButton btnInserir = new JButton("Adicionar");
		btnInserir.addActionListener(this);
		btnInserir.setBounds(628, 9, 89, 23);
		add(btnInserir);

		JLabel lblReceitasLanadasDe = new JLabel("RECEITAS LAN\u00C7ADAS DE FORMA EXTRAORDINARIA");
		lblReceitasLanadasDe.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblReceitasLanadasDe.setBounds(10, 7, 586, 25);
		add(lblReceitasLanadasDe);
		
		txtValor = new JTextField();
		txtValor.setText("0,00");
		txtValor.setEnabled(false);
		txtValor.setDisabledTextColor(Color.BLACK);
		txtValor.setColumns(10);
		txtValor.setBounds(624, 410, 93, 20);
		add(txtValor);
		
		JLabel lblTotal = new JLabel("Total");
		lblTotal.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTotal.setBounds(466, 410, 148, 20);
		add(lblTotal);
		atualizar();

	}
	private void atualizar() {
		model.removeTudo();
		
		equipe = (Equipe) banco.buscarPorId(Equipe.class, equipe.getId());
		
		Set<ReceitaExtra> listReceita = equipe.getReceitaExtra();
		System.out.println(listReceita.size());
		float valorTotal = 0;
		List<ReceitaExtra> listaRec = new ArrayList<ReceitaExtra>(listReceita);
		Collections.sort(listaRec);
		for (ReceitaExtra desp : listaRec) {
			valorTotal=valorTotal+desp.getValor();
			model.addRow(desp);
		}
		txtValor.setText(String.valueOf(df.format(valorTotal)));
		equipe.setTotalreceitaExtra(valorTotal);
		
		boolean a= banco.salvarOuAtualizarObjeto(equipe);
		System.out.println(a);
		repaint();
		validate();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String acao = e.getActionCommand();
		System.out.println(acao);
		
		switch (acao) {
		case "Adicionar":
			JFrmInsReceitaExtra d = new JFrmInsReceitaExtra(this.equipe);
			d.setModal(true);
			d.setVisible(true);
			atualizar();
			validate();
			break;
			
		case "Alterar":
			ReceitaExtra desp = (ReceitaExtra) model.getObj(table.getSelectedRow());
			JFrmInsReceitaExtra dr = new JFrmInsReceitaExtra(this.equipe);
			dr.inserir(desp);
			dr.setModal(true);
			dr.setVisible(true);
			atualizar();
			validate();
			break;
		case "Deletar":
			ReceitaExtra carrad = (ReceitaExtra) model.getObj(table.getSelectedRow());
			banco.deletarObjeto(carrad);
			atualizar();
			validate();
			break;

		default:
			break;
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
}
