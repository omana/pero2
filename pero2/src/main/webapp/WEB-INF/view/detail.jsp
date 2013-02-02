<!DOCTYPE html>
<html lang="ja">
<head>
	<title>テンプレート{ページごとにテキストが変わります}</title>
	<meta charset="UTF-8" />
	<meta name="description" content="できるまとめサイトです。">
	<meta name="keywords" content="閲覧">
	<link rel="stylesheet" type="text/css" media="screen" href="${f:url('/css/peroperoBase.css')}" charset="utf-8" />
	<link rel="stylesheet" type="text/css" media="screen" href="${f:url('/css/detailStyle.css')}" charset="utf-8" />
	<!--[if lt IE 9]>
		<script src="http://html5shiv.googlecode.com/svn/trunk/html5.js" type="text/javascript"></script>
	<![endif]-->

	<!--[if lte IE 7]>
		<link href="ie.css" rel="stylesheet" type="text/css" />
	<![endif]-->
	<%
	/*
	<script type="text/javascript" src="${f:url('/js/jquery.js')}"></script>
	<script type="text/javascript" src="${f:url('/js/toTop.js')}"></script>
	<script type="text/javascript" src="${f:url('/js/linkStyle.js')}"></script>
	<script type="text/javascript" src="${f:url('/js/missing.js')}"></script>
	 */
	 %>
	</head>
<body>
	<div id="wrapper">
		<header>
			<div id="inner_header">
				<h1 id ="tagline">ヘアスタイルのまとめサイト|{テキストを変更します。}｜{テキストを変更します。}</h1>

				<div id="logo">
					<p>ロゴ画像</p>
				</div>
			</div>
		</header>
		<nav>
			<div id="inner_nav">
				<div id="naviDiv">
					<ul>
						<li><s:link href="search/0/1">トップページ</s:link>|</li>
						<li><s:link href="./">このサイトについて</s:link>|</li>
						<li><s:link href="./">リンク</s:link>|</li>
						<li><s:link href="./">サイトリンク</s:link></li>
					</ul>
				</div>
				<div id="searchDiv">
						<form name="" id="searchMovie">
							<p>
								<input type="text" class="search_text"  name="searchForm" />
								<input type="submit" class="search_btr" name="toSearch" value="検索">
							</p>
						</form>
				</div>
			</div>
		</nav>
		<hr />
		<article>
			<div id="inner_content">
				<div id="path_list">
					<p><s:link href="">トップページ</s:link>><s:link href="">お気に入り</s:link>>${f:h(movieName)}</p>
				</div>
				<div id="detailMain">
					<div id="detailMainBar">
						<h2>${f:h(movieName)}</h2>
					</div>
					<br>
					<c:forEach var="m" items="${movieSeriesList}" varStatus="mStatus">
					<div class="detailmovieContents">
						<iframe src="http://flashservice.xvideos.com/embedframe/${f:h(m.mid)}" frameborder=0 width="960" height="640" scrolling=no></iframe>
					</div>
					</c:forEach>
				</div>

				<div id="similarStyle">
					<h2><img src="${f:url('/img/similarStyle.png')}" width="958" height="29" alt="似ているヘアスタイルを探す"></h2>
						<div id="similarPhoto">
						<p>
							<ul>
								<li><img src="${f:url('/img/sampleImage.jpg')}"" alt="ここにヘアスタイル名が入ります。" width="120" height="160"></li>
								<li><img src="${f:url('/img/sampleImage2.jpg')}"" alt="ここにヘアスタイル名が入ります。" width="120" height="160"></li>
								<li><img src="${f:url('/img/sampleImage3.jpg')}"" alt="ここにヘアスタイル名が入ります。" width="120" height="160"></li>
								<li><img src="${f:url('/img/sampleImage.jpg')}"" alt="ここにヘアスタイル名が入ります。" width="120" height="160"></li>
								<li><img src="${f:url('/img/sampleImage2.jpg')}"" alt="ここにヘアスタイル名が入ります。" width="120" height="160"></li>
								<li><img src="${f:url('/img/sampleImage3.jpg')}"" alt="ここにヘアスタイル名が入ります。" width="120" height="160"></li>
								<li><img src="${f:url('/img/sampleImage.jpg')}"" alt="ここにヘアスタイル名が入ります。" width="120" height="160"></li>
							</ul>
						</p>
						</div>
				</div>

			</div>
		</article>
		<footer>
			<div id="inner_footer">
				<div id="footerLeftList">
					<h3><span class="footerDeco">コンテンツ</span></h3>
					<ul>
					<p>
						<li>・<s:link href="./">サイトトップに戻る</s:link></li>
						<li>・<s:link href="./">お気に入りを見る</s:link></li>
						<li>・<s:link href="./">人気ランキング</s:link></li>
					</p>
					</ul>
				</div>
				<div class="footerList">
					<h3><span class="footerDeco">○○について</span></h3>
					<ul>
					<p>
						<li>・<s:link href="./">本サイトについて</s:link></li>
						<li>・<s:link href="./">サイトポリシー</s:link></li>
						<li>・<s:link href="./">お問い合わせ</s:link></li>
						<li>・<s:link href="./">広告掲載について</s:link></li>
					</p>
					</ul>
				</div>
				<div class="footerList">
					<h3><span class="footerDeco">おススメサイト</span></h3>
					<ul>
					<p>
						<li>・<s:link href="./">相互サイトリンク</s:link></li>
						<li>・<s:link href="./">アクセスランキング</s:link></li>
						<li>・<s:link href="./">広告へのリンク１</s:link></li>
						<li>・<s:link href="./">広告へのリンク２</s:link></li>
					</p>
					</ul>
				</div>
			</div>
				<div id="bottom">
					<p>このサイトはヘアスタルのカタログまとめサイトです。</p>
					<address> Copyright(C)2012 ******  All Rights Reserved</address>
				</div>
		</footer>
	</div>
</body>
</html>
