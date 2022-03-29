/**
 * EditNoteServlet class is for fetching the note that the user wanted to edit
 * The url http://localhost:8080/editNote.html is mapped to calling doPost on the servlet object.
 *
 *
 */


package uk.ac.ucl.servlets;

import uk.ac.ucl.model.Model;
import uk.ac.ucl.model.ModelFactory;
import uk.ac.ucl.model.ReadNote;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/editNote.html")
public class EditNoteServlet extends HttpServlet{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        Model model = ModelFactory.getModel();

        String command = request.getParameter("editLine");
        ReadNote note = model.editNote(command);

        request.setAttribute("readNote", note);

        ServletContext context = getServletContext();
        RequestDispatcher dispatch = context.getRequestDispatcher("/edit.jsp");
        dispatch.forward(request, response);
    }
}
