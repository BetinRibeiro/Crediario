package Painel.Dinamico;


import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;


import javax.swing.border.LineBorder;

import java.awt.Color;

@SuppressWarnings("serial")
public class JPanelGrafico extends JPanel {

	float carrada = 350000;
	float compra = (float) (carrada/3.5);
	float retorno = 16500;
	float praso = 285500;
	float vista = (carrada-praso-(praso))/2;

	public JPanelGrafico() {

		setBounds(0, 0, 730, 339);

		DefaultCategoryDataset dataSet = new DefaultCategoryDataset();




		dataSet.setValue(carrada, "Carrada", "Carrada");
		dataSet.setValue(compra, "Compra", "Compra");
		dataSet.setValue(retorno, "Retorno", "Retorno");
		dataSet.setValue(praso, "Venda à praso", "Venda à praso");
		dataSet.setValue(vista, "Venda à vista", "Venda à vista");

		JFreeChart grafico = ChartFactory.createBarChart3D("Contas e Caixa",
				"Parametros", "Valores", dataSet, PlotOrientation.VERTICAL,
				true, true, false);
		setLayout(null);

		ChartPanel chartPanel = new ChartPanel(grafico);
		chartPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		chartPanel.setBounds(1, 1, 729, 338);

		add(chartPanel);

	}



	

}