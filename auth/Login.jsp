<%@ page contentType="text/html; charset=euc-jp" %>
<!DOCTYPE html PUBLIC "-//W3C/DTD HTML4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html lang="ja">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=Shift_JIS">
<meta http-equiv="Content-Style-Type" content="text/css">
<link rel="stylesheet" type="text/css" href="css.css">
<style type="text/css">
<!--

-->
</style>
<title>ログイン　商品管理システム</title>
</head>
<body>
	<div class="title">
		商品管理システム
	</div>

	<div class="title2">
		ログイン
		<span>
			<!--一覧or組織図ヘのリンクを貼る-->
		</span>
	</div>

	<br><br><br>

	<div align="center">
		<form action="GoodsList.jsp" method="post">
			<div>
				ID:
				<input type="text" name="user_id" value="" size="18" maxlength="8">
				<br>
				パスワード:
				<input type="password" name="pass" value="" size="16" maxlength="12">
			</div>
			<input type="submit" value="ログイン">
		</form>
	</div>
</body>
</html>