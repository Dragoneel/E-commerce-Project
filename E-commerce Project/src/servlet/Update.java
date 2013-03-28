package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAOFactory;
import dao.UtilisateurDao;

/**
 * Servlet implementation class Update
 */
public class Update extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String CONF_DAO_FACTORY2 = "daofactory";
	
	public UtilisateurDao     clientDao;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Update() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		response.setContentType("text/html");
	    PrintWriter out = response.getWriter();
	    out.print("<HEAD><TITLE>DAO PATTERN</TITLE></HEAD>");
	    out.print("Suppression<br/>");
	    //out.print(this.find("Dchar"));
	    
	    String nom= "adm";
	    
			DAOFactory fact = DAOFactory.getInstance();
			this.clientDao = fact.getUtilisateurDao();
			System.out.println("appel de la méthode remove(String nom)");	
			
			try {
				
				this.clientDao.update(nom);

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request,response);
	}

}
