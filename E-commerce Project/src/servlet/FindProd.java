package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Produit;
import bean.utilisateur;
import dao.DAOFactory;
import dao.ProduitDao;
import dao.UtilisateurDao;

/**
 * Servlet implementation class FindProd
 */
public class FindProd extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	public ProduitDao     produitDao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindProd() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		DAOFactory fact = DAOFactory.getInstance();
		this.produitDao = fact.getProduitDao();
//		System.out.println("appel de la méthode findby()");	
		
//		Produit prod;
//		try {
//			prod = this.produitDao.findby("chikola.jpg");
//			request.setAttribute("prod", prod);
//			RequestDispatcher rd= request.getRequestDispatcher("index.jsp");
//			rd.forward(request, response);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		System.out.println("appel de la méthode findAll()");
		try {
			List<Produit> lsprod= this.produitDao.findAll();
//			for(int i=0;i<lsprod.size();i++)
//			{
//			System.out.println(lsprod.get(i).getCategorie());
//			}
			request.setAttribute("lsprod", lsprod);
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
