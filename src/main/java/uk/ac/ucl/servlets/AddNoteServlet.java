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
import java.util.List;

// The servlet invoked to perform a search.
// The url http://localhost:8080/runsearch.html is mapped to calling doPost on the servlet object.
// The servlet object is created automatically, you just provide the class.
@WebServlet("/addNote.html")
public class AddNoteServlet extends HttpServlet
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        // Use the model to do the search and put the results into the request object sent to the
        // Java Server Page used to display the results.
        Model model = new Model();
        //String noteNameIn, String imgPathIn, String urlPathIn, String noteDetailIn;
        String noteNameIn = request.getParameter("namePath");
        String imgPathIn = request.getParameter("imgPath");
        String urlPathIn = request.getParameter("urlPath");
        String noteDetailIn = request.getParameter("notePath");
        boolean addResult = model.addNotes(noteNameIn,imgPathIn,urlPathIn,noteDetailIn);


        request.setAttribute("addNoteResult", addResult);

        // Invoke the JSP page.
        ServletContext context = getServletContext();
        RequestDispatcher dispatch = context.getRequestDispatcher("/addNoteResult.jsp");
        dispatch.forward(request, response);
    }
}
