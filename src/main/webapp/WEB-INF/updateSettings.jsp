<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="partials/head.jsp">
        <jsp:param name="title" value="Update Settings" />
    </jsp:include>
</head>
<body>
<jsp:include page="partials/navbar.jsp" />
<div class="container">
    <h1>Update Your Account Info</h1>
<%--    <form action="" method="" >--%>
       <fieldset>
           <legend>Update Email:</legend>
           <td>
               <form action="/updateEmail" method="post">
                   <div class="form-group">
                       <label for="email">Email</label>
                       <input id="email" name="email" class="form-control" type="text">
                   </div>
                   <input class="btn btn-primary btn-sm" type="submit" value="Update Email">
               </form>
           </td>
       </fieldset>
           <fieldset>
           <td>
               <form action="/updatePassword" method="post">
                   <legend>Update Password:</legend>
                   <div class="form-group">
                       <label for="newPassword">Password</label>
                       <input id="newPassword" name="newPassword" class="form-control" type="password">
                   </div>
                   <div class="form-group">
                       <label for="confirm_password">Confirm Password</label>
                       <input id="confirm_password" name="confirm_password" class="form-control" type="password" >
                   </div>
                   <input type="hidden" name="product_id" value="Update Password">
                   <input class="btn btn-primary btn-sm" type="submit" value="Update Password">
               </form>
           </td>

       </fieldset>

<%--    </form>--%>

</div>
</body>
</html>
