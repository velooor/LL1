<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<fmt:setLocale value="${locale}" scope="session"/>
<fmt:setBundle basename="properties.pagecontent"/>
<c:set var="context" value="${pageContext.request.contextPath}" />
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <title>Error</title>

    <!-- Bootstrap -->
    <link href="/css/bootstrap/bootstrap.min.css" rel="stylesheet">
    <link href="/css/style.css" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Bungee" rel="stylesheet">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>

<main class="container">
    <div class="jumbotron">
        <h2 class="text-center">Error...</h2>
        <%--<h1 class="text-center">${pageContext.errorData.statusCode}</h1>--%>
        <div class="text-center"><a href="/index.jsp"><h2>To main...</h2></a></div>
    </div>
</main>

<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="${context}/js/jquery-3.2.0.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="${context}/js/jquery.form.min.js"></script>
<script src="${context}/js/bootstrap.min.js"></script>
</body>
</html>
