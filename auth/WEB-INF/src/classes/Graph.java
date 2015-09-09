package classes;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.servlet.ServletUtilities;
import org.jfree.data.category.DefaultCategoryDataset;

/**
* 棒グラフのサンプル
*/
public class Graph {
    String x;
    public static void main(String[] args) {
        new Graph();
    }
    public Graph(){
        // 表示するデータの作成
        String series1 = "第一";
        String series2 = "第二";
        String series3 = "第三";
        // カテゴリーの設定
        String category1 = "カテゴリー 1";
        String category2 = "カテゴリー 2";
        String category3 = "カテゴリー 3";
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(1.0, series1, category1);
        dataset.addValue(4.0, series1, category2);
        dataset.addValue(5.0, series1, category3);

        dataset.addValue(5.0, series2, category1);
        dataset.addValue(7.0, series2, category2);
        dataset.addValue(7.0, series2, category3);

        dataset.addValue(6.0, series3, category1);
        dataset.addValue(8.0, series3, category2);
        dataset.addValue(8.0, series3, category3);

        // JFreeChartオブジェクトの生成（タイトル、項目名など）
        JFreeChart chart = ChartFactory.createBarChart("棒グラフのサンプル",
        null, "値", dataset, PlotOrientation.VERTICAL, true,    true, false);

        try {
            x = ServletUtilities.saveChartAsPNG(chart, 500, 500,null);
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
    public String getName(){
        return x;
    }
}