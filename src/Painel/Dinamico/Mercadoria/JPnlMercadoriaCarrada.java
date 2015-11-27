package Painel.Dinamico.Mercadoria;

import javax.swing.JPanel;

import Bin.Equipe.Equipe;
import Bin.Mercadoria.Carrada;
import Janela.Equipe.Cadastro.JFrmCadCarrada;
import Model.Tabela.ModelTabelaCarrada;
import Persistence.Dao;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JProgressBar;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JMenuItem;

public class JPnlMercadoriaCarrada extends JPanel implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtValorTotal;
	private Equipe equipeLocal;
	private ModelTabelaCarrada model = new ModelTabelaCarrada();
	private JTable table;
	private float valorTotal;
	private Dao banco = new Dao();

	/**
	 * Create the 
	 */
	public JPnlMercadoriaCarrada(Equipe equipe) {
		equipeLocal=equipe;
		setLayout(null);
		setBounds(0, 0, 1055, 250);
		
	
		JLabel label = new JLabel("Valor das Carradas");
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setBounds(10, 210, 148, 20);
		add(label);
		
		txtValorTotal = new JTextField();
		txtValorTotal.setEnabled(false);
		txtValorTotal.setDisabledTextColor(Color.BLACK);
		txtValorTotal.setColumns(10);
		txtValorTotal.setBounds(170, 210, 93, 20);
		add(txtValorTotal);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 41, 1035, 160);
		add(scrollPane);
		
		
		
		table = new JTable(model);
		scrollPane.setViewportView(table);
		JPopupMenu popupMenu = new JPopupMenu();
		addPopup(table, popupMenu);
		
		JMenuItem mntmVisualizar = new JMenuItem("Visualizar");
		popupMenu.add(mntmVisualizar);
		
		JMenuItem mntmAlterar = new JMenuItem("Alterar");
		mntmAlterar.addActionListener(this);
		popupMenu.add(mntmAlterar);
		
		JProgressBar progressBar = new JProgressBar();
		progressBar.setValue(50);
		progressBar.setForeground(new Color(173, 216, 230));
		progressBar.setBounds(240, 10, 479, 25);
		add(progressBar);
		
		JLabel label_1 = new JLabel("CARRADAS ENVIADAS");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_1.setBounds(10, 11, 216, 25);
		add(label_1);
		
		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.addActionListener(this);
		btnAdicionar.setBounds(925, 10, 120, 25);
		add(btnAdicionar);
		atualizar();

	}

	private void atualizar() {
		model.removeTudo();
		
		equipeLocal = (Equipe) banco.buscarPorId(Equipe.class, equipeLocal.getId());
		
		Set<Carrada> listaCarrada = equipeLocal.getCarrada();
		System.out.println(listaCarrada.size());
		valorTotal = 0;
		for (Carrada carrada : listaCarrada) {
			valorTotal=valorTotal+carrada.getValorTotal();
			model.addRow(carrada);
		}
		txtValorTotal.setText(String.valueOf(valorTotal));
		
		equipeLocal.getVenda().setTotalCarradas(valorTotal);
		banco.salvarOuAtualizarObjeto(equipeLocal);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String acao = e.getActionCommand();
		
		switch (acao) {
		case "Adicionar":
			JFrmCadCarrada cadCar = new JFrmCadCarrada();
			cadCar.setEquipe(equipeLocal);
			cadCar.setModal(true);
			cadCar.setVisible(true);
			atualizar();
			break;
			
		case "Alterar":
			Carrada carrada = (Carrada) model.getObj(table.getSelectedRow());
			JFrmCadCarrada altCar = new JFrmCadCarrada();
			altCar.inserirCarrada(carrada);
			altCar.setModal(true);
			altCar.setVisible(true);
			atualizar();
			break;
		case "Visualizar":
			Carrada carrad = (Carrada) model.getObj(table.getSelectedRow());
			JFrmCadCarrada visCar = new JFrmCadCarrada();
			visCar.inserirCarrada(carrad);
			visCar.setModal(true);
			visCar.setVisible(true);
			visCar.setVisualizar();
			atualizar();
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
