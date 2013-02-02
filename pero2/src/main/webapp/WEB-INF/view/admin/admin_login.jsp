<!DOCTYPE html>
<html lang="ja">
<head>
<title>ログインページ</title>
<meta charset="UTF-8" />
<link rel="stylesheet" type="text/css" media="screen"
	href="${f:url('/css/admincss.css')}" charset="utf-8" />


</head>
<body>
	<h1>ログインページ</h1>
	<s:form method="POST" action="loginUsr">
		<ul>
			<li>ユーザーID:<html:text property="userName" />
			</li>
			<li>パスワード:<html:password property="password" />
			</li>
			<li><s:submit property="loginUsr" value="ログイン" /></li>
		</ul>
	</s:form >
	</body>
</html>
