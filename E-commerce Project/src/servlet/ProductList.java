package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAOFactory;
import dao.ProduitDao;

import bean.Produit;

/**
 * Servlet implementation class ProductList
 */
public class ProductList extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public ProduitDao     produitDao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductList() {
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
		
		System.out.println("appel de la méthode findAll() With limit");
		
		int page = 1;
        int recordsPerPage = 3;
        if(request.getParameter("page") != null)
            page = Integer.parseInt(request.getParameter("page"));

        List<Produit> list;
		try {
			list = this.produitDao.findAll((page-1)*recordsPerPage, recordsPerPage);
			int noOfRecords = this.produitDao.getNoOfRecords();
	        int noOfPages = (int) Math.ceil(noOfRecords * 1.0 / recordsPerPage);
	        request.setAttribute("ProductList", list);
	        request.setAttribute("noOfPages", noOfPages);
	        request.setAttribute("currentPage", page);
	        RequestDispatcher view = request.getRequestDispatcher("product.jsp");
	        view.forward(request, response);
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
