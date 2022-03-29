<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Result</title>
</head>
<body>
<div class = topBar>
    <span id = "title">Add Note Results</span>
    <button id = "btnBack" onclick = "window.location='add.html'">Back</button>
</div>
<div class="main">
    <%
        boolean addResult = (boolean) request.getAttribute("addNoteResult");
        if (addResult == true)
        {
    %>
    <ul>
        <p id="success">Note Added.</p>
        <% } else
        {%>
        <p id="error">Failed to add Note.</p>
        <%}%>
    </ul>
</div>
</body>
<footer>
    <div class="navbar">
        <a href="allNotes.html">Notes</a>
        <a href="search.html">Search</a>
        <a href="add.html" class = "active">Add Notes</a>
    </div>
</footer>
<link rel="stylesheet" href="addNoteResult.css">
</html>
