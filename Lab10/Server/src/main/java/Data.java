import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import java.io.File;
import java.io.IOException;

class Data {

    public Data(AccountsList accountsList) throws IOException {
        CategoryDataset dataset = createDataset(accountsList);
        JFreeChart chart = createChart(dataset);
        ChartUtils.saveChartAsPNG(new File("data.png"), chart, 800, 600);
    }

    private CategoryDataset createDataset(AccountsList accountsList) {
        var dataset = new DefaultCategoryDataset();

        for(Account account : accountsList.getAccounts()) {
            dataset.setValue(account.getFriends().size(), "Numar prieteni", account.getName());
        }

        return dataset;
    }

    private JFreeChart createChart(CategoryDataset dataset) {
        JFreeChart barChart = ChartFactory.createBarChart(
                "Statistica numar prieteni",
                "",
                "Numar prieteni",
                dataset,
                PlotOrientation.VERTICAL,
                false,
                true,
                false);
        return barChart;
    }


//    private void initUI() throws IOException {
//        CategoryDataset dataset = createDataset();
//        JFreeChart chart = createChart(dataset);
//        ChartPanel chartPanel = new ChartPanel(chart);
//        chartPanel.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));
//        chartPanel.setBackground(Color.white);
//        add(chartPanel);
//
//        pack();
//        setTitle("Bar chart");
//        setLocationRelativeTo(null);
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
//        ChartUtils.saveChartAsPNG(new File("histogram.png"), chart, 800, 600);
//    }
}