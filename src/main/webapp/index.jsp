<%@ page import="java.util.List" %>
<%@ page import="redis.clients.jedis.Jedis" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Tasks from Redis</title>
</head>
<body>
<h1>Tasks from Redis</h1>

<form action="add" method="post">
    Enter Task : <input type="text" name="task-name">
    <input type="submit">
</form>

<%
    // Connect to Redis server (your existing code)
    Jedis jedis = new Jedis("127.0.0.1", 6379);
    List<String> tasks = jedis.lrange("tasks", 0, -1);
    jedis.close();  // Close connection (consider connection pool)

    // Check if tasks exist (your existing code)
%>

<% if (tasks != null && !tasks.isEmpty()) { %>
<form id="taskDeleteForm" method="post" action="del">  <ul id="taskList">
    <% for (String task : tasks) { %>
    <li>
        <%= task %>
        <button type="submit" name="delTask" value="<%= task %>">Delete</button>
    </li>
    <% } %>
</ul>
</form>
<% } else { %>
<p>No tasks found in Redis.</p>
<% } %>

</body>
</html>
