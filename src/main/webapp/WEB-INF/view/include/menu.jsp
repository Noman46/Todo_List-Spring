
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
            #link1{
                color: white;
                text-decoration: none;
                padding: 15px;
                vertical-align: central;
                padding-right: 80px;

            }
            #link1:hover{

                color: green;
            }





            .navbar2{
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
            .navbar2 ul{
                margin:0px;
                padding:0px;
                list-style: none;
            }
            .navbar2 ul li{
                float:left;
                width:180px;
                height:40px;


            }
            .navbar2 ul li a{

                text-decoration: none;
                display:block;
                color:white;


            }
            .navbar2 ul li a:hover{
                color:green;
            }
            .navbar2 ul li ul li{
                display:none;
            }
            .navbar2 ul li:hover ul li{
                display:block;
                background-color:#4b0d2b;
                color:black;
            }

            #link{
                margin-left:710px;
            }


        </style>
    </head>
    <body>
    <center>
        <c:if test="${sessionScope.userId ==null}">
            <div id="navbar">
                <s:url var="url_home" value="/index"/>
                <a href="${url_home}" id="link1">HOME</a>
                <s:url var="url_reg_form" value="/reg_form"/>
                <a href="${url_reg_form}" id="link1">REGISTRATION</a>

                <s:url var="url_login_form" value="/loginform"/>
                <a href="${url_login_form}" id="link1">LOGIN</a>
                <s:url var="url_about_me" value="/aboutme"/>
                <a href="${url_about_me}" id="link1">ABOUT ME</a>
            </div>
        </c:if>
        <c:if test="${sessionScope.userId !=null}">
            <div class="navbar2">
                <ul>
                    <s:url var="url_addnemTask" value="#"/>
                    <li> <a href="${url_addnewTask}">ADD NEW TASK</a></li>
                        <s:url var="url_search" value="/todolist"/>
                    <li><a href="${url_search}">MY TASKS</a>
                        <ul>
                            <li>
                                <s:url var="url_priority" value="/priority"/>
                                <a href="${url_priority}">ORDER BY PRIORITY</a>
                            </li>
                            <li>
                                <s:url var="url_by_time" value="/time"/>
                                <a href="${url_by_time}">ORDER BY TIME</a>
                            </li>
                            <li>
                                <s:url var="url_only_for_High" value="/High"/>
                                <a href="${url_only_for_High}">ONLY FOR HIGH</a>
                            </li>
                            <li>
                                <s:url var="url_only_for_Medium" value="/Medium"/>
                                <a href="${url_only_for_Medium}">ONLY FOR MEDIUM</a>
                            </li>
                            <li>
                                <s:url var="url_only_for_Low" value="/Low"/>
                                <a href="${url_only_for_Low}">ONLY FOR LOW</a>
                            </li>

                        </ul>

                    </li>

                    <s:url var="url_logout" value="/logout"/>
                    <li><a href="${url_logout}" id="link">LOGOUT</a></li>
                        <s:url var="url_about_me" value="#"/>
                    <li><a href="${url_about_me}" id="link">ABOUTME</a></li>
                </ul>
            </div>
        </c:if>
    </center>

</body>
</html>

