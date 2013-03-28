package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import bean.utilisateur;
import dao.DAOException;
import dao.DAOFactory;
import dao.UtilisateurDao;
import Forms.FormValidationException;
import Forms.InscriptionForm;
import Forms.InscriptionForm.*;

/**
 * Servlet implementation class Inscription
 */
@WebServlet("/Inscription")
public class Inscription extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 public static final String CONF_DAO_FACTORY = "daofactory";
	    public static final String ATT_USER         = "client";
	    public static final String ATT_FORM         = "form";
	    public static final String VUE              = "/inscription.jsp";
	    
	    private UtilisateurDao     clientDao;
	 
	    public void init() throws ServletException {
	        /* Récupération d'une instance de notre DAO Utilisateur */
	        this.clientDao = ( (DAOFactory) getServletContext().getAttribute( CONF_DAO_FACTORY ) ).getUtilisateurDao();
	    }
  
    public Inscription() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 /* Affichage de la page d'inscription */
        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/* Préparation de l'objet formulaire */
        InscriptionForm form = new InscriptionForm( clientDao );
 
        /* Traitement de la requête et récupération du bean en résultant */
        utilisateur client = form.inscrireClient( request );
 
        /* Stockage du formulaire et du bean dans l'objet request */
        request.setAttribute( ATT_FORM, form );
        request.setAttribute( ATT_USER, client );
 
        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
	}

	

}
