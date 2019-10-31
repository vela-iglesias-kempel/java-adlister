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

    <c:forEach var="ad" items="${ads}">
            <form action="/ads/update" method="post">
<%--                <h2 style="color: red;"><c:out value="${updateAdFailure}"></c:out></h2>--%>
                <div class="form-group">
                    <input id="userId" name="userId" class="form-control" type="hidden" value="<c:out value="${ad.userId}"/>">
                </div>
                <div class="form-group">
                    <input id="adId" name="adId" class="form-control" type="hidden" value="<c:out value="${ad.id}"/>">
                </div>
                <div class="form-group">
                    <label for="title">Title</label>
                    <input id="title" name="title" class="form-control" type="text" value="<c:out value="${ad.title}"/>">
                </div>
                <div class="form-group">
                    <label for="description">Description</label>
                    <input id="description" name="description" class="form-control" type="text" value="<c:out value="${ad.description}"/>">
                </div>
                <div class="form-group">
                    <label for="category">Category</label>
                    <input id="category" name="category" class="form-control" type="text" value="<c:out value="${ad.category}"/>">
                </div>
                <input type="submit" class="btn btn-block btn-primary">
            </form>
    </c:forEach>

</div>
</body>
</html>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Your Profile" />
    </jsp:include>
</head>
<body>
    <jsp:include page="/WEB-INF/partials/navbar.jsp" />

    <div class="container">
        <div>
            <h1>Welcome, <c:out value="${sessionScope.user.username}"/>!</h1
            <h2>Recently Posted Ads</h2>
            <hr>
            <br>
            <c:forEach var="ad" items="${ads}">
                <div class="col-md-6 ">
                    <p class="card-title"><strong>Title</strong>: ${ad.title}</p>
                    <p><strong>Description</strong>: ${ad.description}</p>
                    <p><strong>Category</strong>: ${ad.category}</p>
                    <button><a href="ads/update">Modify Ads</a></button>
                    <button><a href="ads/delete">Delete Ads</a></button>
                </div>
            </c:forEach>
        </div>
    </div>
</body>
</html>--%>