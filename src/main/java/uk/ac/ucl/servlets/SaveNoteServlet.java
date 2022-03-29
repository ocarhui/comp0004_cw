/**
 * SaveNoteServlet class is for saving the note that was selected and passed from EditNoteServlet.
 * The url http://localhost:8080/saveEditNote.html is mapped to calling doPost on the servlet object.
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

@WebServlet("/saveEditNote.html")
public class SaveNoteServlet extends HttpServlet
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

        Model model = ModelFactory.getModel();


        String originalName = request.getParameter("originalName");
        String noteNameIn = request.getParameter("editNamePath");
        String imgPathIn = request.getParameter("editImgPath");

        // check if the imgPath is null.
        //if(imgPathIn.equals("") || imgPathIn.equals("null"))
         //   imgPathIn = null;

        // check if the editUrlPath is null.
        String urlPathIn = request.getParameter("editUrlPath");
        //if(urlPathIn.equals("") || urlPathIn.equals("null"))
         //   urlPathIn = null;
        String noteDetailIn = request.getParameter("editNotePath");

        boolean editResult = false;

        /*if(originalName.equals(noteNameIn)) {
            editResult = model.addNotes(noteNameIn, imgPathIn, urlPathIn, noteDetailIn);
        } else {
            model.deleteNote(originalName);
            editResult = model.addNotes(noteNameIn, imgPathIn, urlPathIn, noteDetailIn);
        }*/

        editResult=model.saveEditNote(originalName,noteNameIn,imgPathIn,urlPathIn,noteDetailIn);

        request.setAttribute("editResult", editResult);


        ServletContext context = getServletContext();
        RequestDispatcher dispatch = context.getRequestDispatcher("/finalEditResult.jsp");
        dispatch.forward(request, response);
    }
}

