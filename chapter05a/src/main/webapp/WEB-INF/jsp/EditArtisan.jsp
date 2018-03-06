<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%
String path = request.getContextPath();
//获得本项目的地址(例如: http://localhost:8080/domain/)赋值给basePath变量 
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
// 将 "项目路径basePath" 放入pageContext中，待以后用EL表达式读出。 
pageContext.setAttribute("basePath",basePath); 
%>
<!DOCTYPE HTML>
<html>
<head>
<title>Edit Artisan Form</title>
<style type="text/css">@import url("<c:url value="/css/main.css"/>");</style>
</head>
<body>

<div id="global">
<form:form commandName="artisan" action="${pageScope.basePath}/artisan/artisan_update" method="post">
    <fieldset>
        <legend>Edit Artisan</legend>
        
      
        
        <p>
        	<label for="orgs">orgName: </label>
       		<form:select id="org" path="org.orgId" 
       			items="${orgList}"  
       			itemValue="orgId" 
       			itemLabel="orgName"/>
        </p>
        
        
        <p>
            <label for="name">name: </label>
            <form:input id="name" path="name"/>
        </p>
        <p>
            <label for="code">code: </label>
            <form:input id="code" path="code"/>
        </p>
        <p>
            <label for="sex">sex: </label>
            <form:input id="sex" path="sex"/>
        </p>
        
        <p id="buttons">
            <input id="reset" type="reset" tabindex="4">
            <input id="submit" type="submit" tabindex="5" 
                value="Update Artisan">
        </p>
    </fieldset>
</form:form>
</div>
</body>
</html>
