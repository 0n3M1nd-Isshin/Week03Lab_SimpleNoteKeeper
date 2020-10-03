package servlets;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NoteServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    
        String editNote = request.getParameter("edit");
        
        String firstLine = null;
        String secondLine = null;
        
        String path = getServletContext().getRealPath("/WEB-INF/note.txt");
        BufferedReader br = new BufferedReader(new FileReader(new File(path)));
        
        firstLine = br.readLine();
        request.setAttribute("first", firstLine);
        if(firstLine != null) {
            secondLine = br.readLine();
            request.setAttribute("second", secondLine);
        }
        br.close();
        
        if(editNote != null) {
            getServletContext().getRequestDispatcher("/WEB-INF/editnote.jsp").forward(request, response);
        }
        
        getServletContext().getRequestDispatcher("/WEB-INF/viewnote.jsp").forward(request, response);     
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException { 
        
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        
        request.setAttribute("title", title);
        request.setAttribute("content", content);
        
        getServletContext().getRequestDispatcher("/WEB-INF/viewnote.jsp").forward(request, response);
    }
}
