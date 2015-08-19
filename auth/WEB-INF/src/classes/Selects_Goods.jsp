<%@ page import="java.sql.*, classes.DBAccess"
    contentType="text/html; charset=euc-jp" %>
<%
// 内容: データベースにアクセスする
 
// DBAccess のインスタンスを生成する
DBAccess db = new DBAccess();
 
// データベースへのアクセス
db.open();
 
// メンバーを取得
ResultSet rs = db.getResultSet("select * from member");
 
// メンバー一覧表示用のテーブル
String tableHTML = "<table border=1>";
tableHTML += "<tr bgcolor=\"000080\"><td><font color=\"white\">メンバーID</font></td>"
    + "<td><font color=\"white\">名前</font></td>"
    + "<td><font color=\"white\">カナ</font></td>";
 
// 取得された各結果に対しての処理
while(rs.next()) {
 
    int id = rs.getInt("member_id"); // メンバーIDを取得
    String name = rs.getString("name"); // メンバー名を取得
    String kana = rs.getString("kana"); // メンバー名(カナ)を取得
 
    // 文字コードを EUC_JP からUnicode へ変換
    name = new String(name.getBytes("8859_1"), "EUC_JP");
    kana = new String(kana.getBytes("8859_1"), "EUC_JP");
 
    // テーブル用HTMLを作成
    tableHTML += "<tr><td align=\"right\">" + id + "</td>"
              + "<td>" + name + "</td><td>" + kana + "</td></tr>";
}
 
tableHTML += "</table>";
 
// データベースへのコネクションを閉じる
db.close();
 
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head><title>データベースへのアクセス</title></head>
<body>
<p>-- データベースへのアクセス --</p>
<p>
<b>メンバーの一覧</b><br>
<%= tableHTML %>
</p>
</body>
</html>