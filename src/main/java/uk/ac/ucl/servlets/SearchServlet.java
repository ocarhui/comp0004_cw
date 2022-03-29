/**
 * SearchServlet class is for searching through the notes.
 * The url http://localhost:8080/searchServlet.html is mapped to calling doPost on the servlet object.
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
import java.util.List;

@WebServlet("/runsearch.html")
public class SearchServlet extends HttpServlet
{
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
  {
    Model model = new Model();
    List<String> searchResult = model.searchNotes(request.getParameter("searchstring"));
    request.setAttribute("result", searchResult);


    ServletContext context = getServletContext();
    RequestDispatcher dispatch = context.getRequestDispatcher("/searchResult.jsp");
    dispatch.forward(request, response);
  }
}
