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
        
        String title;
        String content;
        
        String firstLine = null;
        String secondLine = null;
        
        String path = getServletContext().getRealPath("/WEB-INF/note.txt");
        BufferedReader br = new BufferedReader(new FileReader(new File(path)));
        
        firstLine = br.readLine();
        request.setAttribute("first", firstLine);
        request.setAttribute("title", firstLine);
        if(firstLine != null) {
            secondLine = br.readLine();
            request.setAttribute("second", secondLine);
            request.setAttribute("content", secondLine);
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
        String path = getServletContext().getRealPath("/WEB-INF/note.txt");
        
        request.setAttribute("title", title);
        request.setAttribute("content", content);
        
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(path, false)));
        pw.printf("%s%n" , title);
        pw.printf("%s" , content);
        
        pw.close();
        
        getServletContext().getRequestDispatcher("/WEB-INF/viewnote.jsp").forward(request, response);
    }
}
