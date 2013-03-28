package dao;
import static dao.DAOUtilitaire.*;
import dao.ProduitDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Statement;

import bean.Produit;
import bean.utilisateur;

public class ProduitDaoImp implements ProduitDao {
    private DAOFactory daoFactory;
    private int noOfRecords;
	
	public  ProduitDaoImp(DAOFactory daoFactory ) {
        this.daoFactory = daoFactory;
    }
	
	
	private static final String SQL_INSERT = "INSERT INTO  ( desi, prix, categorie,image) VALUES (?, ?, ?, ?)";

	@Override
	public void creer(Produit produit) throws Exception {
		 Connection connexion = null;
		    PreparedStatement preparedStatement = null;
		    ResultSet valeursAutoGenerees = null;
		    
		    try {
		        /* Récupération d'une connexion depuis la Factory */
		        connexion = daoFactory.getConnection();
		        preparedStatement = initialisationRequetePreparee( connexion, SQL_INSERT, true, produit.getDesignation(), produit.getPrix(), produit.getCategorie(),produit.getImage() );
		        int statut = preparedStatement.executeUpdate();
		        /* Analyse du statut retourné par la requête d'insertion */
		        if ( statut == 0 ) {
		            throw new DAOException( "Échec de la création du Produit, aucune ligne ajoutée dans la table." );
		        }
		        /* Récupération de l'id auto-généré par la requête d'insertion */
		        valeursAutoGenerees = preparedStatement.getGeneratedKeys();
		        if ( valeursAutoGenerees.next() ) {
		            /* Puis initialisation de la propriété id du bean Produit avec sa valeur */
		            produit.setId( valeursAutoGenerees.getLong( 1 ) );
		        } else {
		            throw new DAOException( "Échec de la création de l'Produit en base, aucun ID auto-généré retourné." );
		        }
		    } catch ( SQLException e ) {
		        throw new DAOException( e );
		    } finally {
		        fermeturesSilencieuses( valeursAutoGenerees, preparedStatement, connexion );
		    }	

		
	}

	@Override
	public Produit findby(String nom) throws Exception {
		String SQL_SELECT_PAR_NOM = "SELECT id_pro, desi, prix, categorie, image FROM produit WHERE image = ? ";

		Connection connexion = null;
		Statement st=null;
	    PreparedStatement preparedStatement = null;
	    ResultSet resultSet = null;
	    Produit prod = null;
	 
	    try {
	        /* Récupération d'une connexion depuis la Factory */
	        connexion = daoFactory.getConnection();
	        preparedStatement = initialisationRequetePreparee( connexion, SQL_SELECT_PAR_NOM, false, nom );
	        resultSet = preparedStatement.executeQuery();
	        /* Parcours de la ligne de données de l'éventuel ResulSet retourné */
	        if ( resultSet.next() ) {
	        	//utilisateur.setId(resultSet.getLong("id_user"));
//	        	utilisateur.setNom(resultSet.getString("nom"));
//	        	utilisateur.setEmail(resultSet.getString("email"));
//	        	utilisateur.setMotDePasse(resultSet.getString("mdp"));
//	        	utilisateur.setDateInscription(resultSet.getTimestamp("dateins"));
	        	prod = map( resultSet );
	        }
	       return prod;
	    } catch ( SQLException e ) {
	        throw new DAOException( e );
	    } finally {
	        fermeturesSilencieuses( resultSet, preparedStatement, connexion );
	    }
	    
	}

	@Override
	public List<Produit> findAll() throws Exception {
		
		String SQL_SELECT_ALL = "SELECT id_pro, desi, prix, categorie, image FROM produit";

		Connection connexion = null;

	    PreparedStatement preparedStatement = null;
	    ResultSet resultSet = null;
	    List<Produit> prod = new ArrayList<Produit>();
	 
	    try {
	        /* Récupération d'une connexion depuis la Factory */
	        connexion = daoFactory.getConnection();
	        preparedStatement = initialisationRequetePreparee( connexion, SQL_SELECT_ALL, false);
	        resultSet = preparedStatement.executeQuery();
	        /* Parcours de la ligne de données de l'éventuel ResulSet retourné */
	        while ( resultSet.next() ) {
	        	prod.add(map( resultSet ));
	        }
	       return prod;
	    } catch ( SQLException e ) {
	        throw new DAOException( e );
	    } finally {
	        fermeturesSilencieuses( resultSet, preparedStatement, connexion );
	    }
	    
	}
	
	
	@Override
	public List<Produit> findAll(int offset, int noOfRecords) throws Exception {
		// TODO Auto-generated method stub
		
		String SQL_SELECT_ALL = "SELECT SQL_CALC_FOUND_ROWS * FROM produit limit "
                 + offset + ", " + noOfRecords;

		Connection connexion = null;

	    PreparedStatement preparedStatement = null;
	    ResultSet resultSet = null;
	    List<Produit> prod = new ArrayList<Produit>();
	 
	    try {
	        /* Récupération d'une connexion depuis la Factory */
	        connexion = daoFactory.getConnection();
	        preparedStatement = initialisationRequetePreparee( connexion, SQL_SELECT_ALL, false);
	        resultSet = preparedStatement.executeQuery();
	        /* Parcours de la ligne de données de l'éventuel ResulSet retourné */
	        while ( resultSet.next() ) {
	        	prod.add(map( resultSet ));
	        }
	        resultSet = preparedStatement.executeQuery("SELECT FOUND_ROWS()");
	        if(resultSet.next())
                this.noOfRecords = resultSet.getInt(1);
	       return prod;
	    } catch ( SQLException e ) {
	        throw new DAOException( e );
	    } finally {
	        fermeturesSilencieuses( resultSet, preparedStatement, connexion );
	    }
	    
	}
	
	public int getNoOfRecords() {
        return noOfRecords;
    }

	@Override
	public void update(String nom) throws Exception {
		
		
	}

	@Override
	public Boolean supprimer(String nom) throws Exception {
		
		return null;
	}
	
	/*
	 * Simple méthode utilitaire permettant de faire la correspondance (le
	 * mapping) entre une ligne issue de la table des utilisateurs (un
	 * ResultSet) et un bean Utilisateur.
	 */
	private static Produit map( ResultSet resultSet ) throws SQLException {
		Produit prod = new Produit();
		prod.setId( resultSet.getLong( "id_pro" ) );
	    prod.setDesignation( resultSet.getString( "desi" ) );
	    prod.setPrix( resultSet.getLong( "prix" ) );
	    prod.setCategorie( resultSet.getString( "categorie" ) );
	    prod.setImage( resultSet.getString( "image" ) );
	    return prod;
	}


	

}
