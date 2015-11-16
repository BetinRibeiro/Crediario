package Janela;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import Painel.Manu.JPnlManu;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

@SuppressWarnings("serial")
public class JFrmPrincipal extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JPanel panelSetorial;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {// com.jtattoo.plaf.luna.LunaLookAndFeel azulado simples
						// com.jtattoo.plaf.smart.SmartLookAndFeel o padrão que
						// eu
						// usava muito
						// com.jtattoo.plaf.hifi.HiFiLookAndFeel preto bem
						// massa!!
						// com.jtattoo.plaf.graphite.GraphiteLookAndFeel preto
						// com
						// detalhes marrons
						// com.jtattoo.plaf.fast.FastLookAndFeel cinza basico
						// com.jtattoo.plaf.aluminium.AluminiumLookAndFeel -
						// com.jtattoo.plaf.acryl.AcrylLookAndFeel - um pouco
						// transparente detalhes em preto, bonito
						// com.jtattoo.plaf.bernstein.BernsteinLookAndFeel
						// bonito
						// detalhes em amarelo laranja
						// com.jtattoo.plaf.mcwin.McWinLookAndFeel interface do
						// MacOs
						// com.jtattoo.plaf.mint.MintLookAndFeel basico cores
						// cinsas
						// padrao
						// com.jtattoo.plaf.noire.NoireLookAndFeel preto com
						// detalhe
						// em laranja
						// com.jtattoo.plaf.smart.SmartLookAndFeel tons em azul
						// com.jtattoo.plaf.texture.TextureLookAndFeel banco
						// gelo
						// com detalhes em preto fosco muito massa
						// Properties props = new Properties();
					// props.put("logoString", "");
					// SmartLookAndFeel.setCurrentTheme(props);

					UIManager
							.setLookAndFeel("com.jtattoo.plaf.acryl.AcrylLookAndFeel");
					JFrmPrincipal frame = new JFrmPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					System.out.println("betin");
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public JFrmPrincipal() {
		setTitle("Vendas e Crediario");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panelMenu = new JPnlManu();
		panelMenu.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelMenu.setBounds(5, 5, 1350, 90);
		contentPane.add(panelMenu);

		JPanel panelComandas = new JPanel();
		panelComandas.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelComandas.setBounds(5, 100, 270, 570);
		contentPane.add(panelComandas);
		panelComandas.setLayout(null);

		JButton btnPreparacaoVenda = new JButton("Prepara\u00E7\u00E3o da Venda");
		btnPreparacaoVenda.setBounds(10, 10, 250, 23);
		panelComandas.add(btnPreparacaoVenda);

		JButton btnVendas = new JButton("Venda em andamento");
		btnVendas.setBounds(10, 45, 250, 23);
		panelComandas.add(btnVendas);

		JButton btnCobrancaAndamento = new JButton("Cobran\u00E7as em Andamento");
		btnCobrancaAndamento.setBounds(10, 80, 250, 23);
		panelComandas.add(btnCobrancaAndamento);

		JButton btnVendasFinalizadas = new JButton("Vendas Finalizadas");
		btnVendasFinalizadas.setBounds(10, 115, 250, 23);
		panelComandas.add(btnVendasFinalizadas);

		JPanel panelRodape = new JPanel();
		panelRodape.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelRodape.setBounds(5, 675, 1350, 43);
		contentPane.add(panelRodape);

		panelSetorial = new JPanel();
		panelSetorial.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelSetorial.setBounds(280, 100, 1075, 570);
		contentPane.add(panelSetorial);
		
		
		panelSetorial.setLayout(null);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setBounds(0, 0, screenSize.width, screenSize.height);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);

		btnPreparacaoVenda.addActionListener(this);
		btnPreparacaoVenda.setActionCommand("AGENDAMENTO");
		btnVendas.addActionListener(this);
		btnVendas.setActionCommand("CONTRATOS");
		btnVendasFinalizadas.addActionListener(this);
		btnVendasFinalizadas.setActionCommand("IMOVEIS");
		btnCobrancaAndamento.addActionListener(this);
		btnCobrancaAndamento.setActionCommand("LOCATARIOS");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String acao = e.getActionCommand();

		switch (acao) {
		case "AGENDAMENTO":
			//contentPane.remove(panelSetorial);
			panelSetorial.removeAll();
			//panelSetorial.add(new JPnlAgenda());
			panelSetorial.repaint();
			panelSetorial.validate();

			break;
		case "CONTRATOS":
			panelSetorial.removeAll();
			panelSetorial.repaint();
			//panelSetorial.add(new JPnlContrato());
			panelSetorial.validate();

			break;
		case "IMOVEIS":
		panelSetorial.removeAll();
		panelSetorial.repaint();
		//panelSetorial.add(new JPnlImoveis());
		panelSetorial.validate();

			break;
		case "LOCATARIOS":
			panelSetorial.removeAll();
			panelSetorial.repaint();
			//panelSetorial.add(new JPnlLocatarios());
			panelSetorial.validate();

			break;
		case "CONTRATOJS":
			panelSetorial.removeAll();
			panelSetorial.repaint();
			//panelSetorial.add(new JPnlContratos());
			panelSetorial.validate();

			break;

		default:
			break;
		}

	}

}