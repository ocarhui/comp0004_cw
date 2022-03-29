package uk.ac.ucl.servlets;

import uk.ac.ucl.model.Model;
import uk.ac.ucl.model.ReadNote;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/saveEditNote.html")
public class SaveNoteServlet extends HttpServlet
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        // Use the model to do the search and put the results into the request object sent to the
        // Java Server Page used to display the results.
        Model model = new Model();
        //String noteNameIn, String imgPathIn, String urlPathIn, String noteDetailIn;
        String originalName = request.getParameter("originalName");
        String noteNameIn = request.getParameter("editNamePath");
        String imgPathIn = request.getParameter("editImgPath");
        if(imgPathIn.equals("") || imgPathIn.equals("null"))
            imgPathIn = null;
        String urlPathIn = request.getParameter("editUrlPath");
        if(urlPathIn.equals("") || urlPathIn.equals("null"))
            urlPathIn = null;
        String noteDetailIn = request.getParameter("editNotePath");
        boolean editResult = false;
        if(originalName.equals(noteNameIn)) {
            editResult = model.addNotes(noteNameIn, imgPathIn, urlPathIn, noteDetailIn);
        } else {
            model.deleteNote(originalName);
            editResult = model.addNotes(noteNameIn, imgPathIn, urlPathIn, noteDetailIn);
        }


        request.setAttribute("editResult", editResult);

        // Invoke the JSP page.
        ServletContext context = getServletContext();
        RequestDispatcher dispatch = context.getRequestDispatcher("/finalEditResult.jsp");
        dispatch.forward(request, response);
    }
}

