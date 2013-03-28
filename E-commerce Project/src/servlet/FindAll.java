package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.utilisateur;
import dao.DAOFactory;
import dao.UtilisateurDao;

/**
 * Servlet implementation class FindAll
 */
public class FindAll extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String CONF_DAO_FACTORY2 = "daofactory";
	
	public UtilisateurDao     clientDao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindAll() {
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
	    out.print("DaoTest<br/>");
	    
	    String nom="adm";
	    List<utilisateur> user;

			DAOFactory fact = DAOFactory.getInstance();
			this.clientDao = fact.getUtilisateurDao();
			System.out.println("appel de la méthode findby()");	
			
			try {
				
				user = this.clientDao.findAll();
				if(user != null){
					out.print(user);
				}
				else{
					System.out.println("user is NULL");
				}
				
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
