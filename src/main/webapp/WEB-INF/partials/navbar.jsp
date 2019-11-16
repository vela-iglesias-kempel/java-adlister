<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<nav class="navbar navbar-default">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <a class="navbar-brand" href="/ads">Adlister</a>
        </div>
        <ul class="nav navbar-nav navbar-right">
            <li>
                <form action="/searchAds" method="post">
                    <label for="description"> Search ad description<input type="text" id="description"
                                                                          name="description">
                         <button type="submit">search</button>

                </form>
            </li>
            <c:set var="user" scope="session" value="${user}"/>
            <c:choose>

                <c:when test="${(user != null)}">
                    <li><a href="/ads/create">Create Ad</a></li>
                    <li><a href="/updateSettings">Update Settings</a></li>
                    <li><a href="/logout">Logout</a></li>
                </c:when>

                <c:otherwise>
                    <li><a href="/register">Register</a></li>
                    <li><a href="/login">Login</a></li>
                </c:otherwise>

            </c:choose>

            <li><a href="/ads">List Ads</a></li>
        </ul>
    </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>
