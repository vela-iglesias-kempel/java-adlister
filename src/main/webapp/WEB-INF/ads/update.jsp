<%--
  Created by IntelliJ IDEA.
  User: jasonkempel
  Date: 10/30/19
  Time: 8:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Update Your Ad" />
    </jsp:include>
</head>
<body>
<%--<% request.setAttribute("adId", request.getParameter("adId"));%>--%>
<jsp:include page="/WEB-INF/partials/navbar.jsp"/>

<div class="container">
    <h1>Update Your Ad, ${sessionScope.user.username}</h1>

    <form action="/ads/update" method="post">
        <div class="form-group">
            <label  for="update-title">Title</label>
            <input id="update-title" name="title" class="form-control" value="${ad.title}" type="text">
        </div>
        <input type="hidden" name="id" value="${ad.id}">
        <div class="form-group">
            <label for="update-description">Description</label>
            <textarea id="update-description" name="description" class="form-control"  type="text">${ad.description}</textarea>
        </div>
        <a href="/profile"><input type="submit" class="btn btn-block btn-primary"></a>
    </form>


</div>
</body>
</html>