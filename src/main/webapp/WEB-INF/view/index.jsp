<%-- 
    Document   : register
    Created on : May 27, 2018, 1:46:54 AM
    Author     : Noman Ibrahim
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f" %>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@taglib uri="http://www.springframework.org/tags" prefix="s" %>
<!DOCTYPE html>
<html>
    
    <div>
        <jsp:include page="include/menu.jsp"/>
    </div>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User Registration</title>
        <link href="static/css/style_index.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>

        <div id="main">
            <p>Life become busy.You have your career , You family, Your love, friends. You have many duties and responsibilities
             Sometime life become messy. To make the life properly oriented, this todo list web app can help you. You just make  note of your tast
             according to the date by simply <a href="#">register </a>register your self here.</p>
            
        </div>
        <div id="footer">
            <footer>
                <jsp:include page="include/footer.jsp"/>
            </footer>
        </div>
    </body>
</html>
