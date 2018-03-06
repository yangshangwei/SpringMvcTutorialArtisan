<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML>
<html>
<head>
<title>Artisan List</title>
<style type="text/css">@import url("<c:url value="/css/main.css"/>");</style>
</head>
<body>

<div id="global">
<h1>Artisan List</h1>

<p>
	<a href='<c:url value="/artisan/artisan_input"/>'>Add Artisan</a>
</p>


<table border="1" cellspacing="0">
<tr>
    <th align="center">OrgName</th>
    <th align="center">ArtisanName</th>
    <th align="center">Code</th>
    <th align="center">Sex</th>
    <th align="center" colspan="2">Operation</th>
</tr>

<!-- var要循环集合的别名 -->
<c:forEach items="${artisanList}" var="artisan" varStatus="status">
    <tr <c:if test="${status.count%2==0}">bgcolor="#7CCD7C"</c:if> align="center">
        <td>${artisan.org.orgName}</td>
        <td>${artisan.name}</td>
        <td>${artisan.code}</td>
        <td>${artisan.sex}</td>
        <td><a href="artisan_edit/${artisan.id}">Edit</a></td>
    </tr>
</c:forEach>
</table>
</div>
</body>
</html>
