<!DOCTYPE html>
<html lang="ja">
<head>
	<title>ãã³ãã¬ã¼ã{ãã¼ã¸ãã¨ã«ãã­ã¹ããå¤ããã¾ã}</title>
	<meta charset="UTF-8" />
	<meta name="description" content="無料のエロアニメまとめサイト【ぺろぺろ】">
	<meta name="keywords" content="無料">
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
				<h1 id ="tagline">ã¨ã­ã¢ãã¡ã®ã¾ã¨ããµã¤ã|{ãã­ã¹ããå¤æ´ãã¾ãã}ï½{ãã­ã¹ããå¤æ´ãã¾ãã}ããºããºãã</h1>

				<div id="logo">
					<p>ã­ã´ç»å</p>
				</div>
			</div>
		</header>
		<nav>
			<div id="inner_nav">
				<div id="naviDiv">
					<ul>
						<li><s:link href="search/0/1">ããããã¼ã¸</s:link>|</li>
						<li><s:link href="">ãã®ãµã¤ãã«ã¤ãã¦</s:link>|</li>
						<li><s:link href="">ãªã³ã¯</s:link>|</li>
						<li><s:link href="">ãµã¤ããªã³ã¯</s:link></li>
					</ul>
				</div>
				<div id="searchDiv">
						<form name="" id="searchMovie">
							<p>
								<input type="text" class="search_text"  name="searchForm" />
								<input type="submit" class="search_btr" name="toSearch" value="æ¤ç´¢">
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
					<p><s:link href="search/${f:h(catId)}/1">ããããã¼ã¸</s:link>ãæ°ã«å¥ã</p>
				</div>
				<div id="contentLeft">
					<div id="searchBox">
						<div id="search_bar">
							<h2><img src="${f:url('/img/searchBar.png')}" alt="ã¸ã£ã³ã«ããæ¢ã"/></h2>
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
							<h2>åç»ä¸è¦§</h2>
						</div>
							<c:if test="${empty movieSeriesList}">
                            	<p>æ¤ç´¢çµæã¯ããã¾ããã</p>
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
											<p>æ´æ°æ¥:${f:h(movie.sdate)}</p>
										</div>
									</div>
									<div class="movieMarkUp">
										<div class="amountOfAccess">
											<p>ãæ°ã«å¥ã: 2500äºº</p>
										</div>
									</div>
								</div>
						</c:forEach>

						<div class="pageController">
							<c:if test="${hasPrev}">
								<s:link href="search/${f:h(catId)}/${f:h(page + s.index -1)}">
								åã®ãã¼ã¸ã¸ |</s:link>
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
							ã»ã»ã»
							<s:link href="search/${f:h(catId)}/${f:h(maxPage)}">
							${f:h(maxPage)}</s:link>--%>
							<c:if test="${hasNext}">
								<s:link href="search/${f:h(catId)}/${f:h(page + s.index +1)}">
								|æ¬¡ã®ãã¼ã¸ã¸</s:link>
							</c:if>
						</div>
						<div id="topDiv">
							<p id="toTop"><s:link href="#wrapper">ãã®ãã¼ã¸ã®ãããã¸</s:link></p>
						</div>

				</div>

				<div id="secondArea">

					<div id="favorite">
						<div id="favoriteBar">
							<h2><img src="${f:url('/img/favoriteBar.png')}" alt="ãæ°ã«å¥ããè¦ã"></h2>
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

										<li><s:link href="">ãã£ã¨è¦ã</s:link></li>
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
					<h3><span class="footerDeco">ã³ã³ãã³ã</span></h3>
					<ul>
					<p>
						<li>ã»<s:link href="./">ãµã¤ããããã«æ»ã</s:link></li>
						<li>ã»<s:link href="./">ãæ°ã«å¥ããè¦ã</s:link></li>
						<li>ã»<s:link href="./">äººæ°ã©ã³ã­ã³ã°</s:link></li>
					</p>
					</ul>
				</div>
				<div class="footerList">
					<h3><span class="footerDeco">ââã«ã¤ãã¦</span></h3>
					<ul>
					<p>
						<li>ã»<s:link href="./">æ¬ãµã¤ãã«ã¤ãã¦</s:link></li>
						<li>ã»<s:link href="./">ãµã¤ãããªã·ã¼</s:link></li>
						<li>ã»<s:link href="./">ãåãåãã</s:link></li>
						<li>ã»<s:link href="./">åºåæ²è¼ã«ã¤ãã¦</s:link></li>
					</p>
					</ul>
				</div>
				<div class="footerList">
					<h3><span class="footerDeco">ãã¹ã¹ã¡ãµã¤ã</span></h3>
					<ul>
					<p>
						<li>ã»<s:link href="./">ç¸äºãµã¤ããªã³ã¯</s:link></li>
						<li>ã»<s:link href="./">ã¢ã¯ã»ã¹ã©ã³ã­ã³ã°</s:link></li>
						<li>ã»<s:link href="./">åºåã¸ã®ãªã³ã¯ï¼</s:link></li>
					</p>
					</ul>
				</div>
			</div>
				<div id="bottom">
					<p>ãã®ãµã¤ãã¯ã¨ã­ã¢ãã¡ã¾ã¨ããµã¤ãã§ãã18æ­³æªæºã®é²è¦§ã¯ç¦æ­¢ããã¦ãã¾ãã</p>
					<address> Copyright(C)2012 ******  All Rights Reserved</address>
				</div>
		</footer>
	</div>
</body>
</html>
