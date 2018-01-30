<%@ page import="java.util.List" %>
<%@ page import="hall.Task" %>
<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 10.09.2017
  Time: 12:34
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Test</title>
</head>
<body>
<jsp:useBean id="userbase" scope = "session"
             class="hall.BeanTask" />
<form method="get" action="totals">

<%
        List<Task> tasks = userbase.getBeanTask();
        int questionNumber = 0;

        for (Task task : tasks) {
%>
    <table>
<tr>
    <p><%=questionNumber+1%>.<b> <%=task.getQuestion()%></b></p>
    <%String variant = "variant" + questionNumber;%>

    <p>
        <input type="radio" name=<%=variant%> value="variant1" ><%=task.getVariant1()%><Br>
        <input type="radio" name=<%=variant%> value="variant2" ><%=task.getVariant2()%><Br>
        <input type="radio" name=<%=variant%> value="variant3" ><%=task.getVariant3()%><Br>

    </p>

<%
      if(tasks.size()-1 == questionNumber ){%>
    <input type="submit" value="Submit">
    <%      }
        questionNumber++;%>
    </tr>
    </table>
<%
            }
%>

</form>
</body>
</html>
