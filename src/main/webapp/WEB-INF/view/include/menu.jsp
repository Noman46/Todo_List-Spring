
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f" %>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@taglib uri="http://www.springframework.org/tags" prefix="s" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            body{
                margin: 0px;
                border: 0px;
                
            }
            #navbar{
                width:100%;
                height: 65px;
                position: fixed ;
                top: 0;
                background-color: black;
                position: fixed;
                display: block;
                text-align: center;
                opacity: 0.8;
            }

            #link{
                color: white;
                text-decoration: none;
                padding: 15px;
                vertical-align: central;
                padding-right: 80px;

            }
            #link:hover{
               
                color: coral;
            }
        </style>
    </head>
    <body>
    <center>
        <c:if test="${param.act != 'taskpage'}">
            <div id="navbar">
                <s:url var="url_home" value="/index"/>
                <a href="${url_home}" id="link">HOME</a>
                <s:url var="url_reg_form" value="/reg_form"/>
                <a href="${url_reg_form}" id="link">REGISTRATION</a>

                <s:url var="url_login_form" value="/loginform"/>
                <a href="${url_login_form}" id="link">LOGIN</a>
                <s:url var="url_about_me" value="/aboutme"/>
                <a href="${url_about_me}" id="link">ABOUT ME</a>
            </div>
        </c:if>
        <c:if test="${param.act eq 'taskpage'}">
            <div id="navbar">
                <s:url var="url_addnemTask" value="#"/>
                <a href="${url_addnewTask}" id="link">ADD NEW TASK</a>
                <s:url var="url_search" value="#"/>
                <a href="${url_search}" id="link">MY TASKS</a>

                <s:url var="url_logout" value="#"/>
                <a href="${url_logout}" id="link">LOGOUT</a>
                <s:url var="url_about_me" value="#"/>
                <a href="${url_about_me}" id="link">ABOUT ME</a>
            </div>
        </c:if>
    </center>

</body>
</html>

