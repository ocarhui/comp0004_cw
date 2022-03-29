/**
 * RunCommandServlet is for deleting the note selected by the user.
 * The url http://localhost:8080/runCommand.html is mapped to calling doPost on the servlet object.
 *
 *
 */


package uk.ac.ucl.servlets;

import uk.ac.ucl.model.Model;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/runCommand.html")
public class RunCommandServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        Model model = new Model();

        String command = request.getParameter("cmdLine");
        boolean result = model.deleteNote(command);

        request.setAttribute("deleteResult", result);

        ServletContext context = getServletContext();
        RequestDispatcher dispatch = context.getRequestDispatcher("/deleted.jsp");
        dispatch.forward(request, response);
    }
}

