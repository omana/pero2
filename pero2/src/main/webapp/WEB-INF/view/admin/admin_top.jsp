<!DOCTYPE html>
<html lang="ja">
<head>
	<title>管理者画面トップ</title>
	<meta charset="UTF-8" />
	<link rel="stylesheet" type="text/css" media="screen" href="${f:url('/css/base.css')}" charset="utf-8" />
	<!--[if lt IE 9]>
		<script src="http://html5shiv.googlecode.com/svn/trunk/html5.js" type="text/javascript"></script>
	<![endif]-->

	<!--[if lte IE 7]>
		<link href="ie.css" rel="stylesheet" type="text/css" />
	<![endif]-->
</head>
<body>
	<div id="wrapper">
		<header>
			<div id="inner_header">
				<h1 id ="tagline"></h1>

				<div id="logo">
					<p>管理者トップページ</p>
				</div>
			</div>

		</header>
		<nav>
			<div id="inner_nav">
				<div id="naviDiv">
					<s:form method="POST" action="movieList/${f:h(catId)}/1" >
						<html:select  property="roles" value="${f:h(role)}">
							<html:option value="0" >松浦 </html:option>
							<html:option value="1">小野木</html:option>
							<html:option value="2">仲井</html:option>
						</html:select>
						<s:submit property="movieList/${f:h(catId)}/${f:h(page)}" value="ソート" />
						<s:link href ="logout">ログアウト</s:link>
					</s:form>

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
					<p><s:link href="movieList/${f:h(catId)}/${f:h(page)}">トップページ</s:link>お気に入り</p>
				</div>
				<div id="contentLeft">
					<div id="searchBox">
						<div id="search_bar">
							<h2>検索ジャンル</h2>
						</div>
						<div id="womenHairGenre">
							<ul>
								<c:forEach var ="msrCt" items="${masterCatList}" varStatus="status">
									<c:if test="${catId == status.index }">
										<li ><s:link href="movieList/${f:h(msrCt.catId)}/1" > <Strong>${f:h(msrCt.catName) }</Strong> </s:link></li>
									</c:if>
	 								<c:if test="${catId != status.index }">
										<li><s:link href="movieList/${f:h(msrCt.catId)}/1" > ${f:h(msrCt.catName) } </s:link></li>
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
								<div class="hairContents">
									<div class="hairImages">
										<s:link href="edit_movie/${f:h(movie.sid)}"><img src="${f:h(movie.spic)}" alt="" height="130" width="170"></s:link>
									</div>
									<div class="Names">
										<p>${f:h(movie.stitle)}</p>
									</div>
									<div class="hairInfo">
										<div class="hairGenre">
											<c:if test="${catId != 0}">
												<p>${f:h(catName)} }</p>
											</c:if>
										</div>
										<div class="hairColor">
											<p>更新日:${f:h(movie.sdate)}</p>
										</div>
									</div>
								</div>
							</c:forEach>


						<div class="pageController">
							<c:if test="${hasPrev}">
								<s:link href="movieList/${f:h(catId)}/${f:h(page + s.index -1)}">
								前のページへ |</s:link>
							</c:if>
							<c:forEach var = "pages" items="${pagingList}" varStatus="s" >
								<c:if test="${f:h(pages) == page }">
									<Strong>
										<s:link href="movieList/${f:h(catId)}/${f:h(pages)}">
										    ${f:h(pages)}
										</s:link>
									</Strong>
								</c:if>
								<c:if test="${f:h(pages) != page }">
									<s:link href="movieList/${f:h(catId)}/${f:h(pages)}">
								    	${f:h(pages)}
									</s:link>
								</c:if>
							</c:forEach>

<%-- 							<c:if test="${((page+5) != maxPage)|| page>maxPage})"></c:if>
							・・・
							<s:link href="movieList/${f:h(catId)}/${f:h(maxPage)}">
							${f:h(maxPage)}</s:link>--%>
							<c:if test="${hasNext}">
								<s:link href="movieList/${f:h(catId)}/${f:h(page + s.index +1)}">
								|次のページへ</s:link>
							</c:if>
						</div>
						<div id="topDiv">
							<p><s:link href="delete">すべて削除</s:link></p>
						</div>

				</div>
			</div>
		</article>
		</footer>
	</div>
</body>
</html>
