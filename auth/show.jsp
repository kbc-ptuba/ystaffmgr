<%@ page language="java" contentType="text/html; UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="itiran.css">

<title>詳細画面</title>
</head>
<body>
<TABLE border="1"  cellpadding="10" align="center">
<tr><td>ID</td><td><%= request.getAttribute("id") %></td></tr>
<tr><td>名前</td>
<td><%= request.getAttribute("name") %></td></tr>

<tr><td>所属部署</td>
<td><%= request.getAttribute("dept1") %></td></tr>
<tr><td>所属課</td>
<td><%= request.getAttribute("dept2") %></td></tr>
<tr><td>役職</td>
<td><%= request.getAttribute("exec") %></td></tr>
<tr><td>入社日</td>
<td><%= request.getAttribute("ent") %></td></tr>
<tr><td>住所</td>
<td><%= request.getAttribute("addr") %></td></tr>
<tr><td>生年月日</td>
<td><%= request.getAttribute("birth") %></td></tr>
<tr><td>性別</td>
<td><%= request.getAttribute("gender") %></td></tr>
<tr><td>メールPC</td>
<td> <%= request.getAttribute("mail_pc") %></td></tr>
<tr><td>メール携帯 </td>
<td><%= request.getAttribute("mail_tel") %></td></tr>
<tr><td>電話番号</td>
<td><%= request.getAttribute("tel") %></td></tr>
<tr><td>最終更新日時 </td>
<td> <%= request.getAttribute("renew") %></td></tr>
<tr><td>作成日 </td>
<td> <%= request.getAttribute("making") %></td></tr>
</TABLE>
</body>
</html>