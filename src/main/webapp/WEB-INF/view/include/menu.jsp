
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
                height: 70px;
                background-color: #660066;
                position: fixed;
                top: 0;
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
                font-size: 20px;
                color: coral;
            }
        </style>
    </head>
    <body>
    <center>
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
    </center>

</body>
</html>

