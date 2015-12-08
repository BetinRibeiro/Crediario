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

import org.jboss.jandex.Main;

import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JScrollPane;
import javax.swing.JProgressBar;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DecimalFormat;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class JPnlMercadoriaCarrada extends JPanel implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtValorTotal;
	private Equipe equipeLocal;
	private ModelTabelaCarrada model = new ModelTabelaCarrada();
	private JTable table;
	private Dao banco = new Dao();
	private JButton btnAdicionar;
	DecimalFormat df = new DecimalFormat("0.00");
	private JTextField txtCustoTotal;
	private JTextField txtValorFretes;
	private JProgressBar progressBar;

	/**
	 * Create the 
	 */
	public JPnlMercadoriaCarrada(Equipe equipe) {
		equipeLocal=equipe;
		setBounds(10, 40, 1055, 250);
		setLayout(null);
		JLabel foto2 = new JLabel();
		foto2.setBounds(885, 0, 40, 40);
		ImageIcon img2 = new ImageIcon(Main.class.getResource("/Imagens/002.png"));
		Image img02 = img2.getImage().getScaledInstance(foto2.getWidth(), foto2.getHeight(), Image.SCALE_DEFAULT);
		foto2.setIcon(new ImageIcon(img02));
		add(foto2);
		
	
		JLabel lblValorDasCarradas = new JLabel("VALOR DAS CARRADAS");
		lblValorDasCarradas.setHorizontalAlignment(SwingConstants.RIGHT);
		lblValorDasCarradas.setBounds(10, 210, 148, 20);
		add(lblValorDasCarradas);
		
		txtValorTotal = new JTextField();
		txtValorTotal.setEnabled(false);
		txtValorTotal.setDisabledTextColor(Color.BLACK);
		txtValorTotal.setColumns(10);
		txtValorTotal.setBounds(170, 210, 93, 20);
		add(txtValorTotal);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 40, 1035, 160);
		add(scrollPane);
		
		
		
		table = new JTable(model);
		table.getTableHeader().setReorderingAllowed(false);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.getColumn("CIDADE").setPreferredWidth(200);
		table.getColumn("MOTORISTA").setPreferredWidth(200);
		scrollPane.setViewportView(table);
		JPopupMenu popupMenu = new JPopupMenu();
		addPopup(table, popupMenu);
		
		JMenuItem mntmVisualizar = new JMenuItem("Deletar");
		mntmVisualizar.addActionListener(this);
		popupMenu.add(mntmVisualizar);
		
		JMenuItem mntmAlterar = new JMenuItem("Alterar");
		mntmAlterar.addActionListener(this);
		popupMenu.add(mntmAlterar);
		
		
		 progressBar = new JProgressBar();
		
		progressBar.setForeground(new Color(173, 216, 230));
		progressBar.setBounds(240, 10, 479, 25);
		add(progressBar);
		
		JLabel label_1 = new JLabel("CARRADAS ENVIADAS");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_1.setBounds(10, 11, 216, 25);
		add(label_1);
		
		btnAdicionar = new JButton("Adicionar");
		btnAdicionar.addActionListener(this);
		btnAdicionar.setBounds(925, 10, 120, 25);
		add(btnAdicionar);
		
		JLabel lblCustoDasCarradas = new JLabel("CUSTO DAS CARRADAS");
		lblCustoDasCarradas.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCustoDasCarradas.setBounds(273, 210, 148, 20);
		add(lblCustoDasCarradas);
		
		txtCustoTotal = new JTextField();
		txtCustoTotal.setText("0,00");
		txtCustoTotal.setEnabled(false);
		txtCustoTotal.setDisabledTextColor(Color.BLACK);
		txtCustoTotal.setColumns(10);
		txtCustoTotal.setBounds(433, 210, 93, 20);
		add(txtCustoTotal);
		
		txtValorFretes = new JTextField();
		txtValorFretes.setText("0,00");
		txtValorFretes.setEnabled(false);
		txtValorFretes.setDisabledTextColor(Color.BLACK);
		txtValorFretes.setColumns(10);
		txtValorFretes.setBounds(719, 210, 93, 20);
		add(txtValorFretes);
		
		JLabel lblValorDosFrets = new JLabel("VALOR DOS FRETES");
		lblValorDosFrets.setHorizontalAlignment(SwingConstants.RIGHT);
		lblValorDosFrets.setBounds(559, 210, 148, 20);
		add(lblValorDosFrets);
		atualizar();

	}

	private void atualizar() {
		try {
		
		model.removeTudo();
		
		equipeLocal = (Equipe) banco.buscarPorId(Equipe.class, equipeLocal.getId());
		
		Set<Carrada> listaCarrada = equipeLocal.getCarrada();
		System.out.println(listaCarrada.size());
		float valorTotal = 0;
		float custo = 0;
		float fretes = 0;
		List<Carrada> listCarr = new ArrayList<Carrada>(listaCarrada);
		Collections.sort(listCarr);
		for (Carrada carrada : listCarr) {
			valorTotal=valorTotal+carrada.getValorTotal();
			custo=custo+carrada.getCusto();
			fretes=fretes+carrada.getValorFrete();
			model.addRow(carrada);
		}
		txtValorTotal.setText(String.valueOf(df.format(valorTotal)));
		txtCustoTotal.setText(String.valueOf(df.format(custo)));
		txtValorFretes.setText(String.valueOf(df.format(fretes)));
		
		equipeLocal.getVenda().setTotalCarradas(valorTotal);
		equipeLocal.getVenda().setCustoCarrada(custo);
		equipeLocal.setCustoCarradas(custo);
		equipeLocal.setPrecoCarradas(valorTotal);
		equipeLocal.setValorFretes(fretes);
		
		System.out.println(equipeLocal.getPrecoCarradas()/equipeLocal.getMetaVenda()+" valor impresso");
		System.out.println((int) (equipeLocal.getMetaVenda()/equipeLocal.getPrecoCarradas()*100)+" aqui");
		progressBar.setValue((int) (equipeLocal.getPrecoCarradas()/equipeLocal.getMetaVenda()*100));
		boolean a= banco.salvarOuAtualizarObjeto(equipeLocal);
		 a= banco.salvarOuAtualizarObjeto(equipeLocal.getVenda());
		System.out.println(a);	
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, e.getMessage());
		}
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
		case "Deletar":
			Carrada carrad = (Carrada) model.getObj(table.getSelectedRow());
			banco.deletarObjeto(carrad);
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
