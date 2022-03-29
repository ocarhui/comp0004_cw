/**
 * AllNotesServlet class is for fetching all notes in the application.
 * The url http://localhost:8080/allNote.html is mapped to calling doGet on the servlet object.
 *
 *
 */

package uk.ac.ucl.servlets;

import uk.ac.ucl.model.Model;
import uk.ac.ucl.model.ModelFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/allNotes.html")
public class AllNotesServlet extends HttpServlet
{

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {
        Model model = ModelFactory.getModel();
        ArrayList<String> fileNames = model.getNoteNames();

        request.setAttribute("fileNames", fileNames);

        ServletContext context = getServletContext();
        RequestDispatcher dispatch = context.getRequestDispatcher("/allNotes.jsp");
        dispatch.forward(request, response);
    }


}
