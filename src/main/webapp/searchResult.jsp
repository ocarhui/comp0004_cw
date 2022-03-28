<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
  <title>Patient Data App</title>
</head>
<body>
<div class="main">
  <h1>Search Result</h1>
  <%
    ArrayList<String> notes = (ArrayList<String>) request.getAttribute("result");
    if (notes.size() !=0)
    {
    %>
    <ul>
      <%
        for (String note : notes) {
          String href = "/data/"+note +".html";
      %>
      <li><a href="<%=href%>"><%=note%></li>
      <% }
      } else
      {%>
      <p>Nothing found</p>
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