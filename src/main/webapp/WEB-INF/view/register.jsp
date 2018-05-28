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
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User Registration</title>
        <link href="static/css/style.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        
        <div class="simple_form">
            
            <form id="reg">
                <h1  style="color:red;">Registration</h1>
                <input type="text" name="name" placeholder="Enter your name" id="box">
                </br>
                </br>
                </br>

                <input type="text" name="phone" placeholder="Enter your phone number" id="box">
                </br>
                </br
                </br>
                <input type="text" name="loginName" placeholder="Enter your user name" id="box">
                </br>
                </br>
                </br>
                <input type="password" name="password" placeholder="Enter your password" id="box">
                </br>
                </br>
                </br>
                <input type="submit" value="Register" id="butt">
            </form>
        </div>
    </body>
</html>
