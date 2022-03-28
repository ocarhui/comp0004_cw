<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
  <meta charset="UTF-8">
  <title>All Notes</title>
  <link rel="stylesheet" href="allNotes.css">
</head>
<body>

<div class = topBar>
  <span id = "title">All Notes</span>
</div>

<div class= main>
  <ul>
    <%
      ArrayList<String> notes = (ArrayList<String>) request.getAttribute("fileNames");

      for (String note : notes)
      {
        String href = "/data/"+note +".html";
    %>
    <li><a href="<%=href%>"><%=note%></a>
    </li>
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

</div>
</html>
