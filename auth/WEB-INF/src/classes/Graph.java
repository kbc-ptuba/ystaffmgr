//package classes;
//
//import java.io.BufferedOutputStream;
//import java.io.OutputStream;
//
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.jfree.chart.ChartFactory;
//import org.jfree.chart.ChartUtilities;
//import org.jfree.chart.JFreeChart;
//import org.jfree.chart.plot.PlotOrientation;
//import org.jfree.data.category.CategoryDataset;
//import org.jfree.data.general.DatasetUtilities;
//
//public class Graph extends HttpServlet {
//
//    protected void doGet(HttpServletRequest req, HttpServletResponse res) {
//	int width = 640;
//	int height = 640;
//
//	try {
//	    // 縦横サイズの指定
//	    width = Integer.parseInt(req.getParameterValues ("width")[0]);
//	    height = Integer.parseInt(req.getParameterValues ("height")[0]);
//	} catch (Exception e) {
//	    e.printStackTrace();
//	}
//
//	// 棒グラフのJFreeChartを作成
//	JFreeChart chart = createChart();
//	// コンテンツタイプをpngにする.
//	res.setContentType("image/png");
//	OutputStream outputStream;
//	System.err.println("write png width = " + width + " / height = " + height);
//	try {
//	    outputStream = new BufferedOutputStream(res.getOutputStream());
//	    // JFreeChartをPNGとして出力
//	    ChartUtilities.writeChartAsPNG(outputStream, chart, width, height);
//	    outputStream.close();
//	} catch (Exception e) {
//	    e.printStackTrace();
//	}
//    }
//
//    /**
//     * 棒グラフのJFreeChartを作成する.
//     */
//    private JFreeChart createChart () {
//	// 棒グラフのデータ
//        double[][] data = new double[][]
//	{{1.0, 2.0, 3.0, 4.0},
//	 {5.0, 6.0, 7.0, 8.0},
//	 {9.0, 10.0, 11.0, 12.0},
//	 {13.0, 14.0, 15.0, 16.0}};
//        // CategoryDatasetオブジェクトの作成
//	CategoryDataset cData = DatasetUtilities.createCategoryDataset("RowKey ", "ColKey ", data);
//	// CategoryDatasetをデータにしてJFreeChartを作成
//	JFreeChart barChart = ChartFactory.createBarChart ("SampleBarChart",
//							   "categoryAxisLabel",
//							   "valueAxisLabel",
//							   cData, PlotOrientation.VERTICAL,
//							   false, false, false);
//	return barChart;
//    }
//
//}