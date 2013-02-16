<!DOCTYPE html>
<html lang="ja">
<head>
	<title>テンプレート{ページごとにテキストが変わります}</title>
	<meta charset="UTF-8" />
	<meta name="description" content="できるまとめサイトです。">
	<meta name="keywords" content="閲覧">
	<link rel="stylesheet" type="text/css" media="screen" href="${f:url('/css/peroperoBase.css')}" charset="utf-8" />
	<!--[if lt IE 9]>
		<script src="http://html5shiv.googlecode.com/svn/trunk/html5.js" type="text/javascript"></script>
	<![endif]-->

	<!--[if lte IE 7]>
		<link href="ie.css" rel="stylesheet" type="text/css" />
	<![endif]-->
	<% /*
	<script type="text/javascript" src="${f:url('/js/jquery.js')}"></script>
	<script type="text/javascript" src="${f:url('/js/toTop.js')}"></script>
	<script type="text/javascript" src="${f:url('/js/linkStyle.js')}"></script>
	<script type="text/javascript" src="${f:url('/js/missing.js')}"></script>
	<script type="text/javascript" src="${f:url('/js/switchOnOff.js')}"></script>
	<script language="JavaScript" type="text/javascript" src="${f:url('/js/jquery.syg_imageradio.1.1.js')}"></script>
	 */
	 %>
</head>
<body>
	<div id="wrapper">
		<header>
			<div id="inner_header">
				<h1 id ="tagline">エロアニメのまとめサイト|{テキストを変更します。}｜{テキストを変更します。}【ぺろぺろ】</h1>

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
						<li><s:link href="">このサイトについて</s:link>|</li>
						<li><s:link href="">リンク</s:link>|</li>
						<li><s:link href="">サイトリンク</s:link></li>
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
					</li>

			</div>
		</nav>
		<hr />

		<article>
			<div id="inner_content">
				<div id="path_list">
					<p><s:link href="search/${f:h(catId)}/1">トップページ</s:link>お気に入り</p>
				</div>
				<div id="contentLeft">
					<div id="searchBox">
						<div id="search_bar">
							<h2><img src="${f:url('/img/searchBar.png')}" alt="ジャンルから探す"/></h2>
						</div>
						<div id="womenmovieGenre">
							<ul>
								<c:forEach var ="msrCt" items="${masterCatList}" varStatus="status">
									<c:if test="${catId == status.index }">
										<li ><s:link href="search/${f:h(msrCt.catId)}/1" > <Strong>${f:h(msrCt.catName) }</Strong> </s:link></li>
									</c:if>
	 								<c:if test="${catId != status.index}">
										<li><s:link href="search/${f:h(msrCt.catId)}/1" > ${f:h(msrCt.catName) } </s:link></li>
									</c:if>
								</c:forEach>
							</ul>
						</div>
					</div>

				</div>

				<div id="main">
						<div id="main_bar">
							<h2>動画一覧</h2>
						</div>
							<c:if test="${empty movieSeriesList}">
                            	<p>検索結果はありません。</p>
                            </c:if>
                            <c:forEach var="movie" items="${movieSeriesList}" varStatus="mStatus">
								<div class="movieContents">
									<div class="movieImages">
										<s:link href="detail/${f:h(movie.sid)}"><img src="${f:h(movie.spic)}" alt="" height="100" width="130"></s:link>
									</div>
									<div class="Names">
										<p>${f:h(movie.stitle)}</p>
									</div>
									<div class="movieInfo">
										<c:if test="${catId != 0}">
											<div class="movieGenre">
												<p>${f:h(catName)} }</p>
											</div>
										</c:if>

										<div class="movieColor">
											<p>更新日:${f:h(movie.sdate)}</p>
										</div>
									</div>
									<div class="movieMarkUp">
										<div class="amountOfAccess">
											<p>お気に入り: 2500人</p>
										</div>
									</div>
								</div>
						</c:forEach>

						<div class="pageController">
							<c:if test="${hasPrev}">
								<s:link href="search/${f:h(catId)}/${f:h(page + s.index -1)}">
								前のページへ |</s:link>
							</c:if>
							<c:forEach var = "pages" items="${pagingList}" varStatus="s" >
								<c:if test="${f:h(pages) == page }">
									<Strong>
										<s:link href="search/${f:h(catId)}/${f:h(pages)}">
										    ${f:h(pages)}
										</s:link>
									</Strong>
								</c:if>
								<c:if test="${f:h(pages) != page }">
									<s:link href="search/${f:h(catId)}/${f:h(pages)}">
								    	${f:h(pages)}
									</s:link>
								</c:if>
							</c:forEach>

<%-- 							<c:if test="${((page+5) != maxPage)|| page>maxPage})"></c:if>
							・・・
							<s:link href="search/${f:h(catId)}/${f:h(maxPage)}">
							${f:h(maxPage)}</s:link>--%>
							<c:if test="${hasNext}">
								<s:link href="search/${f:h(catId)}/${f:h(page + s.index +1)}">
								|次のページへ</s:link>
							</c:if>
						</div>
						<div id="topDiv">
							<p id="toTop"><s:link href="#wrapper">このページのトップへ</s:link></p>
						</div>

				</div>

				<div id="secondArea">

					<div id="favorite">
						<div id="favoriteBar">
							<h2><img src="${f:url('/img/favoriteBar.png')}" alt="お気に入りを見る"></h2>
						</div>
						<c:forEach var="his" items="${hisList}" varStatus="status">
						<div id="favoriteContents">
								<p>
									<ul>
										<li><s:link href="detail/${f:h(his.sid)}">${f:h(his.stitle)}</s:link></li>
									</ul>
								</p>

						</div>
						</c:forEach>
						<div id="favoriteFooter">
								<p>
									<ul>

										<li><s:link href="">もっと見る</s:link></li>
									</ul>
								</p>
						</div>
					</div>
					<div class="ad">
						<img src="${f:url('/img/300_2503.jpg')}" width="240px" height="200px" />
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
						<li><s:link href="./">本サイトについて</s:link></li>
						<li><s:link href="./">サイトポリシー</s:link></li>
						<li><s:link href="./">お問い合わせ</s:link></li>
						<li><s:link href="./">広告掲載について</s:link></li>
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
					</p>
					</ul>
				</div>
			</div>
				<div id="bottom">
					<p>このサイトはエロアニメまとめサイトです。18歳未満の閲覧は禁止されています。</p>
					<address> Copyright(C)2012 ******  All Rights Reserved</address>
				</div>
		</footer>
	</div>
</body>
</html>
