//package classes;
//
//
//import java.io.IOException;
//
//import javax.servlet.ServletException;
//import javax.servlet.ServletOutputStream;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.jfree.chart.ChartFactory;
//import org.jfree.chart.ChartUtilities;
//import org.jfree.chart.JFreeChart;
//import org.jfree.data.general.DefaultPieDataset;
//
//public class Graph extends HttpServlet {
//  public void doGet(HttpServletRequest request
//                  , HttpServletResponse response)
//    throws ServletException, IOException {
//
//    // グラフ生成用の元データを用意
//    String[][] aryDat={
//      {"書籍紹介","150000"},
//      {"Q＆A掲示板","55500"},
//      {"関連サイト","75000"},
//      {"レンタルサーバ","83100"},
//      {"RSSフィード","22500"}
//    };
//
//    // 円グラフの基となるデータセットを用意
//    DefaultPieDataset objDpd=new DefaultPieDataset();
//
//    // データセットに項目名と値のを順にセット
//    for(int i=0;i<aryDat.length;i++){
//      objDpd.setValue(aryDat[i][0],Integer.parseInt(aryDat[i][1]));
//    }
//
//    // 3次元円グラフを生成（第1引数からグラフタイトル、
//    // データセット、判例を表示するか、ツールチップを
//    // 表示するか、URLを動的に生成するかを指定）
//    JFreeChart objCht=ChartFactory.createPieChart3D(
//      "サイトアクセスログ",objDpd,true,false,false);
//
//    // バイナリ出力ストリームにJPEG形式で画像を出力
//    // 600×400ピクセル）
//    response.setContentType("image/jpeg");
//    ServletOutputStream objSos=response.getOutputStream();
//    ChartUtilities.writeChartAsJPEG(objSos,objCht,600,400);
//  }
//}
