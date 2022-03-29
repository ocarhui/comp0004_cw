/**
 * AddNoteServlet class is for adding note.
 * The url http://localhost:8080/addNote.html is mapped to calling doPost on the servlet object.
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

@WebServlet("/addNote.html")
public class AddNoteServlet extends HttpServlet
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        Model model = new Model();

        String noteNameIn = request.getParameter("namePath");
        String imgPathIn = request.getParameter("imgPath");
        if(imgPathIn.equals("") || imgPathIn.equals("null"))
            imgPathIn = null;
        String urlPathIn = request.getParameter("urlPath");
        if(urlPathIn.equals("") || urlPathIn.equals("null"))
            urlPathIn = null;
        String noteDetailIn = request.getParameter("notePath");
        boolean addResult = model.addNotes(noteNameIn,imgPathIn,urlPathIn,noteDetailIn);


        request.setAttribute("addNoteResult", addResult);

        ServletContext context = getServletContext();
        RequestDispatcher dispatch = context.getRequestDispatcher("/addNoteResult.jsp");
        dispatch.forward(request, response);
    }
}
