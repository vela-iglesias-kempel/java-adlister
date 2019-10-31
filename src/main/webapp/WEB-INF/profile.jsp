<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                    <button><a href="ads/update?ads=${ad.id}">Modify Ads</a></button>
                    <button><a href="ads/delete?ads=${ad.id}">Delete Ads</a></button>
                </div>
            </c:forEach>
        </div>
    </div>
</body>
</html>