package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import bean.utilisateur;

import dao.DAOFactory;
import dao.UtilisateurDao;

/**
 * Servlet implementation class Find
 */
public class Find extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String CONF_DAO_FACTORY2 = "daofactory";
	
	public UtilisateurDao     clientDao;
	
	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		 /* Récupération d'une instance de notre DAO Utilisateur */
       //this.clientDao = ( (DAOFactory) getServletContext().getAttribute("daofactory") ).getUtilisateurDao();
	}
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Find() {
        super();
        // TODO Auto-generated constructor stub
    }



	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//clientDao = ( (DAOFactory) getServletContext().getAttribute("daofactory") ).getUtilisateurDao();
		//this.clientDao = null;
		//this.clientDao = ((DAOFactory)(getServletContext().getAttribute(CONF_DAO_FACTORY2))).getUtilisateurDao();
//		response.setContentType("text/html");
//	    PrintWriter out = response.getWriter();
//	    out.print("<HEAD><TITLE>DAO PATTERN</TITLE></HEAD>");
//	    out.print("DaoTest<br/>");
//	    //out.print(this.find("Dchar"));
//
//	    String nom="adm";
//	    utilisateur user;
//
//			DAOFactory fact = DAOFactory.getInstance();
//			this.clientDao = fact.getUtilisateurDao();
//			System.out.println("appel de la méthode findby()");	
//			
//			try {
//				
//				user = this.clientDao.findby(nom);
//				if(user != null){
//					out.print(user.toString());
//				}
//				else{
//					System.out.println("user is NULL");
//				}
//				
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
		
		DAOFactory fact = DAOFactory.getInstance();
		this.clientDao = fact.getUtilisateurDao();
		System.out.println("appel de la méthode findby()");	
		
		utilisateur user;
		try {
			user = this.clientDao.findby("adm");
			request.setAttribute("user", user);
			RequestDispatcher rd= request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
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
