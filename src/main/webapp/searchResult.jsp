<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
  <title>Search</title>
</head>
<body>
<div class = topBar>
  <span id = "title">Search Results</span>
  <button id = "btnBack" onclick = "window.location='search.html'">Back</button>
</div>

<div class="main">
  <%
    ArrayList<String> notes = (ArrayList<String>) request.getAttribute("result");
    if (notes.size() !=0)
    {
    %>
    <ul id = 'results'>
      <%
        for (String note : notes) {
          String href = "/data/"+note +".html";
      %>
      <li><a href="<%=href%>"><%=note%></a></li>
      <% }
      } else
      {%>
      <p id="error">nothing found...</p>
      <%}%>
    </ul>
</div>

</body>

<footer>
  <div class="navbar">
    <a href="allNotes.html">Notes</a>
    <a href="search.html" class = "active">Search</a>
    <a href="add.html">Add Notes</a>
  </div>
</footer>
<link rel="stylesheet" href="searchResult.css">
</html>