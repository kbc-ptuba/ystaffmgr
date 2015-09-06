<%@ page language="java" contentType="text/html; UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>詳細画面</title>
</head>
<body>
<p>ID = <%= request.getAttribute("id") %></p>
<p>名前 = <%= request.getAttribute("name") %></p>
<p>所属部署 = <%= request.getAttribute("dept1") %></p>
<p>所属課 = <%= request.getAttribute("dept2") %></p>
<p>役職 = <%= request.getAttribute("exec") %></p>
<p>入社日 = <%= request.getAttribute("ent") %></p>
<p>住所 = <%= request.getAttribute("addr") %></p>
<p>生年月日 = <%= request.getAttribute("birth") %></p>
<p>性別 = <%= request.getAttribute("gender") %></p>
<p>メールPC = <%= request.getAttribute("mail_pc") %></p>
<p>メール携帯 = <%= request.getAttribute("mail_tel") %></p>
<p>電話番号= <%= request.getAttribute("tel") %></p>
<p>最終更新日時 = <%= request.getAttribute("renew") %></p>
<p>作成日 = <%= request.getAttribute("making") %></p>
</body>
</html>