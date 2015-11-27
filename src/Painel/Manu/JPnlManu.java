package Painel.Manu;

import javax.swing.JPanel;

import Janela.Cadastro.JFrmCadEquipe;
import Janela.Cadastro.JFrmCadFuncionario;
import Janela.Cadastro.JFrmCadProduto;
import Janela.Cadastro.JFrmCadTransporte;
import Janela.Compra.JFrmComProduto;
import Janela.Pesquisa.JFrmPesCompra;
import Janela.Pesquisa.JFrmPesEquipe;
import Janela.Pesquisa.JFrmPesFuncionario;
import Janela.Pesquisa.JFrmPesProduto;
import Janela.Pesquisa.JFrmPesTransporte;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JToolBar;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class JPnlManu extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lblTituloDaEquipe;

	public JLabel getLblTituloDaEquipe() {
		return lblTituloDaEquipe;
	}

	public void setLblTituloDaEquipe(JLabel lblTituloDaEquipe) {
		this.lblTituloDaEquipe = lblTituloDaEquipe;
	}

	/**
	 * Create the panel.
	 */
	public JPnlManu() {
		setBounds(0, 0, 1350, 90);
		setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(1, 1, 1348, 21);
		add(menuBar);
		
		JMenu mnCadastro = new JMenu("Cadastro");
		menuBar.add(mnCadastro);
		
		JMenuItem mntmCadastroProduto = new JMenuItem("Cadastro Produto");
		mntmCadastroProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFrmCadProduto cp = new JFrmCadProduto();
				cp.setVisible(true);
				cp.setAlwaysOnTop(true);
				cp.setLocationRelativeTo(null);
			}
		});
		mnCadastro.add(mntmCadastroProduto);
		
		JMenuItem mntmCadastroTransporte = new JMenuItem("Cadastro Transporte");
		mntmCadastroTransporte.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrmCadTransporte ct = new JFrmCadTransporte();
				ct.setVisible(true);
				ct.setAlwaysOnTop(true);
				ct.setLocationRelativeTo(null);
			}
		});
		mnCadastro.add(mntmCadastroTransporte);
		
		JMenuItem mntmCadastroFuncionario = new JMenuItem("Cadastro Funcionario");
		mntmCadastroFuncionario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrmCadFuncionario cf = new JFrmCadFuncionario();
				cf.setVisible(true);
				cf.setAlwaysOnTop(true);
				cf.setLocationRelativeTo(null);
			}
		});
		mnCadastro.add(mntmCadastroFuncionario);
		
		JMenuItem mntmCadastroEquipe = new JMenuItem("Cadastro Equipe");
		mntmCadastroEquipe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrmCadEquipe ceq= new JFrmCadEquipe();
				ceq.setVisible(true);
			}
		});
		mnCadastro.add(mntmCadastroEquipe);
		
		JMenu mnPesquisa = new JMenu("Pesquisa");
		menuBar.add(mnPesquisa);
		
		JMenuItem mntmPesquisaProduto = new JMenuItem("Pesquisa Produto");
		mntmPesquisaProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrmPesProduto pp = new JFrmPesProduto();
				pp.setVisible(true);
				pp.setAlwaysOnTop(true);
				pp.setLocationRelativeTo(null);
			}
		});
		mnPesquisa.add(mntmPesquisaProduto);
		
		JMenuItem mntmPesquisaTransporte = new JMenuItem("Pesquisa Transporte");
		mntmPesquisaTransporte.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrmPesTransporte pt = new JFrmPesTransporte();
				pt.setVisible(true);
				pt.setAlwaysOnTop(true);
				pt.setLocationRelativeTo(null);
			}
		});
		mnPesquisa.add(mntmPesquisaTransporte);
		
		JMenuItem mntmPesquisaFuncionario = new JMenuItem("Pesquisa Funcionario");
		mntmPesquisaFuncionario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrmPesFuncionario pf = new JFrmPesFuncionario();
				pf.setVisible(true);
				pf.setAlwaysOnTop(true);
				pf.setLocationRelativeTo(null);
			}
		});
		mnPesquisa.add(mntmPesquisaFuncionario);
		
		JMenuItem mntmPesquisaCompra = new JMenuItem("Pesquisa Compra");
		mntmPesquisaCompra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFrmPesCompra crp = new JFrmPesCompra();
				crp.setVisible(true);
			}
		});
		mnPesquisa.add(mntmPesquisaCompra);
		
		JMenuItem mntmPesquisaEquipe = new JMenuItem("Pesquisa Equipe");
		mntmPesquisaEquipe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrmPesEquipe eui = new JFrmPesEquipe();
				eui.setVisible(true);
			}
		});
		mnPesquisa.add(mntmPesquisaEquipe);
		
		JMenu mnMovimentao = new JMenu("Movimenta\u00E7\u00E3o");
		menuBar.add(mnMovimentao);
		
		JMenuItem mntmComprarProduto = new JMenuItem("Comprar Produto");
		mntmComprarProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrmComProduto cp = new JFrmComProduto();
				cp.setVisible(true);
				cp.setAlwaysOnTop(true);
				cp.setLocationRelativeTo(null);
			}
		});
		mnMovimentao.add(mntmComprarProduto);
		
		JToolBar toolBar = new JToolBar();
		toolBar.setEnabled(false);
		toolBar.setBounds(1, 20, 1348, 68);
		add(toolBar);
		
		JButton button_2 = new JButton("");
		button_2.setIcon(new ImageIcon(JPnlManu.class.getResource("/Imagens/Maersk.png")));
		toolBar.add(button_2);
		
		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.setIcon(new ImageIcon(JPnlManu.class.getResource("/Imagens/photo-retouche.png")));
		toolBar.add(btnNewButton_2);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon(JPnlManu.class.getResource("/Imagens/Hapag3.png")));
		toolBar.add(btnNewButton);
		
		JButton button_3 = new JButton("");
		button_3.setIcon(new ImageIcon(JPnlManu.class.getResource("/Imagens/Hard-Drive.png")));
		toolBar.add(button_3);
		
		JButton button_4 = new JButton("");
		button_4.setIcon(new ImageIcon(JPnlManu.class.getResource("/Imagens/poubelle-pleine.png")));
		toolBar.add(button_4);
		
		JButton button_5 = new JButton("");
		button_5.setIcon(new ImageIcon(JPnlManu.class.getResource("/Imagens/Alpha Dista (Grey) Icon 40.png")));
		toolBar.add(button_5);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setIcon(new ImageIcon(JPnlManu.class.getResource("/Imagens/Desktop.png")));
		toolBar.add(btnNewButton_1);
		
		JButton btnNewButton_3 = new JButton("");
		btnNewButton_3.setIcon(new ImageIcon(JPnlManu.class.getResource("/Imagens/box1.png")));
		toolBar.add(btnNewButton_3);
		
		JButton button_7 = new JButton("");
		button_7.setIcon(new ImageIcon(JPnlManu.class.getResource("/Imagens/box2.png")));
		toolBar.add(button_7);
		
		JButton button_6 = new JButton("");
		button_6.setIcon(new ImageIcon(JPnlManu.class.getResource("/Imagens/firewall.png")));
		toolBar.add(button_6);
		
		lblTituloDaEquipe = new JLabel("Titulo da Equipe");
		lblTituloDaEquipe.setHorizontalTextPosition(SwingConstants.LEFT);
		lblTituloDaEquipe.setVerticalAlignment(SwingConstants.BOTTOM);
		toolBar.add(lblTituloDaEquipe);
		lblTituloDaEquipe.setFont(new Font("Verdana", Font.BOLD, 22));
		lblTituloDaEquipe.setVisible(false);
		
		
		

	}
}
