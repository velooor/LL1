<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<fmt:setLocale value="${locale}" scope="session"/>
<fmt:setBundle basename="properties.pagecontent"/>
<c:set var="context" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
    <title><fmt:message key="main.page.title"/></title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap -->
    <link href="/css/bootstrap/bootstrap.min.css" rel="stylesheet">
    <link href="/css/style.css" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Chewy" rel="stylesheet">
    <link type="text/css" rel="stylesheet" href="/css/common.css"/>
    <link type="text/css" rel="stylesheet" href="/css/rooms.css"/>
    <link rel="shortcut icon" href="/css/mainFavicon.png" type="image/png">

    <link rel="stylesheet" media="all" href="/css/animate.css">
    <script src="/js/wow.min.js"></script>
    <script>new WOW().init();</script>
</head>
<body>





<main class="container">
    <br><br><br><br><br>
    <div id="mainSearchPanel" class="panel panel-default">

        <div class="panel-body">
            <form id="mainCMD" name="mainForm" action="/main" method="post">
                <div class="row">
                    <div class="col-sm-2">
                       <h4>http://localhost:8087/</h4>
                    </div>
                    <div class="col-sm-9">
                        <input type="text" name="searchQuery" class="form-control" value="main/rooms" placeholder="enter your query here or in browser command line" required>
                    </div>
                    <div class="col-sm-1">
                        <input type="submit" class="btn btn-primary" value="<fmt:message key="button.search"/>">
                    </div>
                </div>
                <input type="hidden" name="command" value="query">
            </form>
        </div>
       <%-- <div class="panel-body">
            <button onclick="showAll()" class="btn btn-primary text-center"><fmt:message key="button.search"/></button>
            <a href="/main?command=mainSearch">Simple search</a>
        </div>--%>

    </div>


</main>


<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="/js/jquery-3.2.0.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="/js/jquery.form.min.js"></script>
<%--<script src="${context}/js/sign_manage.js"></script>--%>
<script src="/js/bootstrap.min.js"></script>
<script src="/js/searchUtil.js"></script>
</body>
</html>
