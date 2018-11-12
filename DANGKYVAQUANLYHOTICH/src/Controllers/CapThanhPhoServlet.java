package Controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Models.CapThanhPhoService;

/**
 * Servlet implementation class CapThanhPhoServlet
 */
@WebServlet(name = "ThanhPho", urlPatterns ="/CapThanhPhoServlet")
public class CapThanhPhoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public CapThanhPhoServlet() {
        super();
        
    }

    private CapThanhPhoService City = new CapThanhPhoService();
    
    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
    	
    }
	
    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
