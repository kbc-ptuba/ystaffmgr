<%@ page import="java.sql.*, classes.DBAccess"
    contentType="text/html; charset=UTF-8" %>
<%
//MyDBAccess のインスタンスを生成する
classes.DBAccess db = new classes.DBAccess();

//データベースへのアクセス
db.open();

//メンバーを取得
ResultSet rs = db.getResultSet("select goods_id,goods,field_id,price,stock from goods_master where ? = like'?%'");

%>


<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>商品一覧画面</title>
</head>
<body>


<form method="post" action="./pro2">	<!-- name属性消しました -->
<table><tr>
<td><select name='select'>								<!-- 1列目 -->
	<option value='商品ID'>商品ID</option>
	<option value='商品名'>商品名</option>
	<option value='商品分野'>商品分野</option>
	<option value='販売単価'>販売単価</option>
	<option value='在庫数'>在庫数</option>
	<option value='最終売上日'>最終売上日</option>
	<option value='月別売上'>月別売上</option>
	<option value='累積売上'>累積売上</option>
	<option value='仕入先'>仕入先</option>
	<option value='仕入数'>仕入数</option>
	</select></td>
<td><input type="text" name="select" value=""/></td>	<!-- ２列目 -->
<td>
<input type="submit" name="select" value="検索"/>		<!-- ３列目 -->
</td></tr>
</table>
</form>
<br>


<!-- データベースから表示するテーブルはfor文ぐらいで繰り返し処理で取らないとまずいですよ！ -->
  <form name=f method=POST action="./pro">
    <table border="1" width="10%" cellspacing="0">
        <tr>
            <td>ユーザID</td>
        </tr>
        <tr>
            <td><a href="javascript:document.f.submit()">1194012016</a>
            <input type=hidden name=userId value="1194012016"/></td>		<!-- 元々tableタグの外にあったのをid列だけ -->
        </tr>
    </table>



</form>
</body>
</html>

<!-- おそらく、Proc2.javaからのデータのdoPostが必要 -->
