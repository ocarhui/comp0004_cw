<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Patient Data App</title>
</head>
<body>
<div class="main">
    <h1>Add Note Result</h1>
    <%
        boolean deleteResult = (boolean) request.getAttribute("deleteResult");
        if (deleteResult == true)
        {
    %>
    <ul>
        <p>Note Deleted.</p>
        <% } else
        {%>
        <p>Failed to delete Note.</p>
        <%}%>
    </ul>
</div>
</body>
<footer>
    <div class="navbar">
        <a href="allNotes.html" class = "active">Notes</a>
        <a href="search.html">Search</a>
        <a href="add.html">Add Notes</a>
    </div>
</footer>
<link rel="stylesheet" href="searchResult.css">
</html>

