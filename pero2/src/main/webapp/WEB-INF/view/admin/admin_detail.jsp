<!DOCTYPE html>
<html lang="ja">
<head>
	<title>編集ページ</title>
	<meta charset="UTF-8" />
	<link rel="stylesheet" type="text/css" media="screen" href="${f:url('/css/admindetailcss.css')}" charset="utf-8" />
	<link rel="stylesheet" type="text/css" media="screen" href="${f:url('/css/admincss.css')}" charset="utf-8" />


</head>
<body>
<h1>管理者更新ページ</h1>
<hr />
	<c:forEach var="m" items="${movieSeriesList}" varStatus="mStatus">
		<div class="content">
				<form action="">
					<p>
						s_id:<input type="text" value="${f:h(m.sid)}">
					</p>
					<p>
						m_id:<input type="text" value="${f:h(m.snum)}">
					</p>

					<p>
						ID:<input type="text" value="${f:h(m.mid)}">
						名前:<input type="text" value="${f:h(m.stitle)}">
					</p>
					<p>
					<iframe src="http://flashservice.xvideos.com/embedframe/${f:h(m.mid)}" frameborder="0" width="250" height="200" ></iframe>
					<img src="${f:h(m.spic)}" width="250" height="200" alt="sample">
					<!--ここに動画が入ります。適当にフレーム貼ってください。width=250とheight=200で。-->
					</p>
					<p>
						日付：<input type="text" value="${f:h(m.sdate)}">
					</p>
					<p>
						長さ：<input type="text" value="${f:h(m.stime)}">
					</p>
					<p>
						カテゴリー：
						<c:forEach var ="msrCt" items="${masterCatList}" varStatus="status">
							<input type="checkbox" name="genre" value="${f:h(msrCt.catId)}"/>${f:h(msrCt.catName) }
						</c:forEach>

					</p>
					<p>
					公開可否
						<select name="update">
							<option name="ok">公開する</option>
							<option name="ng">公開しない。</option>
						</select>
					</p>
					<p>
					削除可否
						<select name="delete">
							<option name="ng">削除しない</option>
							<option name="ok">削除</option>
						</select>
					</p>
				<input type="submit">
				</form>
			</div>
		<hr />
	</c:forEach>


</body>
</html>