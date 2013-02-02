<html>
<head>
<title><tiles:getAsString name="title" /></title>
<link rel="stylesheet" href="${f:url('/css/main.css')}" type="text/css">
<link rel="stylesheet" href="${f:url('/css/')}<tiles:getAsString name="css" ignore="true"/>" type="text/css">
<link rel="stylesheet" href="${f:url('/css/')}<tiles:getAsString name="css2" ignore="true" />" type="text/css">
<link rel="stylesheet" href="${f:url('/css/')}<tiles:getAsString name="css3" ignore="true" />" type="text/css">
<link rel="stylesheet" href="${f:url('/css/')}<tiles:getAsString name="css4" ignore="true" />" type="text/css">
<link rel="stylesheet" href="${f:url('/css/')}<tiles:getAsString name="css5" ignore="true" />" type="text/css">
<link rel="stylesheet" href="${f:url('/css/')}<tiles:getAsString name="css6" ignore="true" />" type="text/css">
</head>
<body>
<table width="100%">
  <tr><td colspan="2"><tiles:insert page="/common/header.jsp" /></td></tr>
  <tr>
    <td width="20%"><tiles:insert page="/common/menu.jsp" /></td>
    <td><tiles:insert attribute="content" /></td>
  </tr>
  <tr><td colspan="2"><tiles:insert page="/common/footer.jsp" /></td></tr>
</table>
</body>
</html>