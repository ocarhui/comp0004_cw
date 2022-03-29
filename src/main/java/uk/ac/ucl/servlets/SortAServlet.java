/**
 * SortAServlet class is for sorting the notes list in ascending order.
 * The url http://localhost:8080/sortA.html is mapped to calling doPost on the servlet object.
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

@WebServlet("/sortA.html")
public class SortAServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        Model model = ModelFactory.getModel();

        ArrayList<String> sortedURL = model.sortByAscendingOrder();

        request.setAttribute("fileNames", sortedURL);


        ServletContext context = getServletContext();
        RequestDispatcher dispatch = context.getRequestDispatcher("/allNotes.jsp");
        dispatch.forward(request, response);
    }
}
