<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML>
<html>
<head>
<title>Save Artisan</title>
<style type="text/css">@import url("<c:url value="/css/main.css"/>");</style>
</head>
<body>
<div id="global">
    <h4>The Artisan details have been saved.</h4>
    <p>
        <h5>Details:</h5>
        First Name: ${artisan.firstName}<br/>
        Last Name: ${artisan.lastName}<br/>
        Date of Birth: ${artisan.birthDate}
    </p>
</div>
</body>
</html>