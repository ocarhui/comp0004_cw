<%@ page import="uk.ac.ucl.model.ReadNote" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <meta charset="UTF-8">
    <title>Edit Note</title>
    <link rel="stylesheet" href="edit.css">
</head>
<body>

<div class = topBar>
    <span id = "title">Edit Note</span>
</div>

<div class="main">
    <%
        ReadNote note = (ReadNote) request.getAttribute("readNote");

        String noteName = note.getNoteName();
        String imgPath = note.getImgPath();
        String urlPath = note.getUrlPath();
        String noteDetail = note.getNoteDetail();
    %>
    <form id="noteForm" method="POST" action="/saveEditNote.html">
        <input type="text" name="originalName" style= "display: none;" id = 'originalBox' value=<%=noteName%>/></br>
        <label for="nameBox" id="lblName">Title</label>
        <input type="text" name="editNamePath" id = 'nameBox' value=<%=noteName%>></br>
        <label for="imgBox" id="lblImg">Image</label>
        <input type="text" name="editImgPath" id = 'imgBox' value=<%=imgPath%>></br>
        <label for="urlBox" id="lblURL">URL links</label>
        <input type="url" name="editUrlPath" id = 'urlBox' value=<%=urlPath%>></br>
        <textarea rows="5" cols="100" id="noteTxt" name="editNotePath" form="noteForm"><%=noteDetail%></textarea></br>
        <input type="submit" value="Submit" id = "submitBtn"/>
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

</div>
</html>
