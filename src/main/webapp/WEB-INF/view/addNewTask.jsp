<%-- 
    Document   : addNewTask
    Created on : Jun 8, 2018, 3:09:30 PM
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
        <title>User Todo || Dashboard</title>
        <link href="static/css/addNewTask.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div>

            <jsp:include page="include/menu.jsp"/>

        </div>
        <div class="todo_form">

            <div class="heading"><p><h3>Enter New Working Schedule</h3></P></div>
                    <s:url var="url_add_task" value="/saveAddedTask"/>
                    <f:form action="${url_add_task}" modelAttribute="command">

                <table cellspacing="5" cellpadding="3" class="table">

                    <tr>
                        <th>MONTH</th>
                        <th>DAY</th>
                        <th>YEAR</th>
                    </tr>

                    <tr>
                        <td>
                            <f:input path="month" placeholder="month" id="tdtd"/>
                        </td>
                        <td >
                            <f:input path="day" placeholder="day" id="tdtd" />
                        </td>
                        <td>
                            <f:input path="year" placeholder="year" id="tdtd"/>
                        </td>
                    </tr> 

                </table>

                <div class="title">
                    <p><h3>Give a Title For Your Task</h3></p>
                    <f:input path="title" placeholder="give a title" id="title"/>
                </div>
                </br>
                </br>

                <div class="textarea">
                    <p><h3>Give a Description For Your Task</h3></p>
                    <f:textarea path="description" placeholder="Add Description For the task" id="textarea"/>
                </div>
                </br>
                </br>
                <div class="priority">
                    <p><h3>Select The Priority of Your Task</h3></p>
                </div>
                <div class="radio">
                    <f:radiobutton path="priority" value="High" id="high"/>
                    <label for="high">High</label>
                </div>
                <div class="radio">
                    <f:radiobutton path="priority" value="Medium" id="medium"/>
                    <label for="medium">Medium</label>
                </div>
                <div class="radio">
                    <f:radiobutton path="priority" value="Low" id="low"/>
                    <label for="low">Low</label>
                </div>
                <div class="button">
                    <f:button id="button">SAVE</f:button>
                    </div>

            </f:form>



        </div>
        <div id="footer">
            <footer>
                <jsp:include page="include/footer.jsp"/>
            </footer>
        </div>

    </body>
</html>
