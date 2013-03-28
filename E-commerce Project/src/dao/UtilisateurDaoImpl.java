package dao;
import static dao.DAOUtilitaire.*;
import dao.UtilisateurDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import java.sql.Statement;



import bean.utilisateur;

public class UtilisateurDaoImpl implements UtilisateurDao {
	
	private DAOFactory daoFactory;
	
	UtilisateurDaoImpl( DAOFactory daoFactory ) {
        this.daoFactory = daoFactory;
    }
	
	
	private static final String SQL_INSERT = "INSERT INTO Utilisateur ( nom,email, mdp,dateins) VALUES (?, ?, ?, NOW())";
	 
	/* Impl�mentation de la m�thode d�finie dans l'interface UtilisateurDao */
	@Override
	public void creer( utilisateur utilisateur ) throws DAOException {
	    Connection connexion = null;
	    PreparedStatement preparedStatement = null;
	    ResultSet valeursAutoGenerees = null;
	    
	    try {
	        /* R�cup�ration d'une connexion depuis la Factory */
	        connexion = daoFactory.getConnection();
	        preparedStatement = initialisationRequetePreparee( connexion, SQL_INSERT, true, utilisateur.getNom(), utilisateur.getEmail(), utilisateur.getMotDePasse() );
	        int statut = preparedStatement.executeUpdate();
	        /* Analyse du statut retourn� par la requ�te d'insertion */
	        if ( statut == 0 ) {
	            throw new DAOException( "�chec de la cr�ation de l'utilisateur, aucune ligne ajout�e dans la table." );
	        }
	        /* R�cup�ration de l'id auto-g�n�r� par la requ�te d'insertion */
	        valeursAutoGenerees = preparedStatement.getGeneratedKeys();
	        if ( valeursAutoGenerees.next() ) {
	            /* Puis initialisation de la propri�t� id du bean Utilisateur avec sa valeur */
	            utilisateur.setId( valeursAutoGenerees.getLong( 1 ) );
	        } else {
	            throw new DAOException( "�chec de la cr�ation de l'utilisateur en base, aucun ID auto-g�n�r� retourn�." );
	        }
	    } catch ( SQLException e ) {
	        throw new DAOException( e );
	    } finally {
	        fermeturesSilencieuses( valeursAutoGenerees, preparedStatement, connexion );
	    }
	}
	
	private static final String SQL_SELECT_PAR_EMAIL = "SELECT id_user, nom, email, mdp, dateins FROM Utilisateur WHERE nom = ?";
	 
	/* Impl�mentation de la m�thode d�finie dans l'interface UtilisateurDao */
	@Override
	public utilisateur findby(String nom){
	    Connection connexion = null;
	    PreparedStatement preparedStatement = null;
	    ResultSet resultSet = null;
	    utilisateur utilisateur = null;
	 
	    try {
	        /* R�cup�ration d'une connexion depuis la Factory */
	        connexion = daoFactory.getConnection();
	        preparedStatement = initialisationRequetePreparee( connexion, SQL_SELECT_PAR_EMAIL, false, nom );
	        resultSet = preparedStatement.executeQuery();
	        /* Parcours de la ligne de donn�es de l'�ventuel ResulSet retourn� */
	        if ( resultSet.next() ) {
	        	//utilisateur.setId(resultSet.getLong("id_user"));
//	        	utilisateur.setNom(resultSet.getString("nom"));
//	        	utilisateur.setEmail(resultSet.getString("email"));
//	        	utilisateur.setMotDePasse(resultSet.getString("mdp"));
//	        	utilisateur.setDateInscription(resultSet.getTimestamp("dateins"));
	            utilisateur = map( resultSet );
	        }
	       return utilisateur;
	    } catch ( SQLException e ) {
	        throw new DAOException( e );
	    } finally {
	        fermeturesSilencieuses( resultSet, preparedStatement, connexion );
	    }
	    
	}
	
	
	private static final String SQL_SELECT_ALL = "SELECT * FROM Utilisateur";
	@Override
	public List<utilisateur> findAll() throws Exception {
		// TODO Auto-generated method stub

	    Connection connexion = null;
	    PreparedStatement preparedStatement = null;
	    ResultSet resultSet = null;
	    List<utilisateur> utilisateur = null;
	 
	    try {
	        /* R�cup�ration d'une connexion depuis la Factory */
	        connexion = daoFactory.getConnection();
	        preparedStatement = initialisationRequetePreparee( connexion, SQL_SELECT_ALL, false);
	        resultSet = preparedStatement.executeQuery();
	        /* Parcours de la ligne de donn�es de l'�ventuel ResulSet retourn� */
	        if ( resultSet.next() ) {
	            utilisateur.add(map( resultSet ));
	        }
	       return utilisateur;
	    } catch ( SQLException e ) {
	        throw new DAOException( e );
	    } finally {
	        fermeturesSilencieuses( resultSet, preparedStatement, connexion );
	    }
	}
	
	
	
	private static final String SQL_DELETE = " DELETE FROM utilisateur WHERE nom= 'adm' ";
	@Override
	public Boolean supprimer(String nom) throws Exception {
		// TODO Auto-generated method stub
		
		Connection connexion = null;
	    Statement statement = null;
	 

	        /* R�cup�ration d'une connexion depuis la Factory */
	        connexion = daoFactory.getConnection();
	        statement = (Statement) connexion.createStatement();
	        statement.execute(SQL_DELETE);
	        return true;

	}
	
	



	@Override
	public void update(String nom) throws Exception {
		// TODO Auto-generated method stub
		
		String SQL_UPDATE = "Update from utilisateur set prenom=\"toto\" where nom= \" "+nom+" \" ";
		Connection connexion = null;
	    PreparedStatement preparedStatement = null;
	    ResultSet resultSet = null;
	 
	    try {
	        /* R�cup�ration d'une connexion depuis la Factory */
	        connexion = daoFactory.getConnection();
	        Statement st = connexion.createStatement();
	        st.executeUpdate(SQL_UPDATE);

	    } catch ( SQLException e ) {
	        throw new DAOException( e );
	    } finally {
	        fermeturesSilencieuses( resultSet, preparedStatement, connexion );
	    }
		
	}

	
	
	
	/*
	 * Simple m�thode utilitaire permettant de faire la correspondance (le
	 * mapping) entre une ligne issue de la table des utilisateurs (un
	 * ResultSet) et un bean Utilisateur.
	 */
	private static utilisateur map( ResultSet resultSet ) throws SQLException {
	    utilisateur utilisateur = new utilisateur();
	    utilisateur.setId( resultSet.getLong( "id_user" ) );
	    utilisateur.setEmail( resultSet.getString( "email" ) );
	    utilisateur.setMotDePasse( resultSet.getString( "mdp" ) );
	    utilisateur.setNom( resultSet.getString( "nom" ) );
	    utilisateur.setDateInscription( resultSet.getTimestamp( "dateins" ) );
	    return utilisateur;
	}





    
}