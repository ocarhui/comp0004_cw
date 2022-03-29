<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
  <meta charset="UTF-8">
  <title>All Notes</title>
</head>
<body>

<div class = topBar>
  <span id = "title">All Notes</span>
  <form id="sortDesc" method="POST" action="/sortD.html" style="display:inline-flex;">
    <input type="submit" value="Sort By Descending" id = "btnD"/>
  </form>
  <form id="sortAsc" method="POSt" action="/sortA.html" style="display:inline-flex;">
    <input type="submit" value="Sort By Ascending" id = "btnA"/>
  </form>

</div>

<div class= main>
  <ul id = 'results'>
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

<div class = cmdArea>
  <form id="cmdForm" method="POST" action="/runCommand.html">
    <label for="cmdBox" id="lblDelete">Delete Note</label>
    <input type="text" name="cmdLine" id = 'cmdBox' placeholder="Write The Note Name Here."/>
    <input type="submit" value="Delete" id = "delBtn" style="display:inline-flex;"/>
  </form>
  <form id="editForm" method="POST" action="/editNote.html">
    <label for="editBox" id="lblEdit">Edit Note</label>
    <input type="text" name="editLine" id = 'editBox' placeholder="Write The Note Name Here."/>
    <input type="submit" value="Edit" id = "editBtn"/>
  </form>
</div>
</body>

<footer>
  <div class="navbar">
    <a href="allNotes.html" class = "active">Notes</a>
    <a href="search.html">Search</a>
    <a href="add.html">Add Notes</a>
  </div>
</footer>
<link rel="stylesheet" href="allNotes.css">
</div>
</html>
