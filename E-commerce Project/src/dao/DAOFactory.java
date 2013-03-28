package dao;

//import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
 
public class DAOFactory {
 
    private static final String FICHIER_PROPERTIES       = "/dao/dao.properties";
    private static final String PROPERTY_URL             = "url";
    private static final String PROPERTY_DRIVER          = "driver";
    private static final String PROPERTY_NOM_UTILISATEUR = "nomutilisateur";
    //private static final String PROPERTY_MOT_DE_PASSE    = "motdepasse";
 
    private String              url;
    private String              username;
    private String              password;
 
    DAOFactory( String url, String username, String password ) {
        this.url = url;
        this.username = username;
        this.password = password;
    }
 
    /*
     * M�thode charg�e de r�cup�rer les informations de connexion � la base de
     * donn�es, charger le driver JDBC et retourner une instance de la Factory
     */
    public static DAOFactory getInstance() throws DAOConfigurationException {
        Properties properties = new Properties();
        String url;
        String driver;
        String nomUtilisateur;
        String motDePasse;
 
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        InputStream fichierProperties = classLoader.getResourceAsStream( FICHIER_PROPERTIES );
 
        if ( fichierProperties == null ) {
            throw new DAOConfigurationException( "Le fichier properties " + FICHIER_PROPERTIES + " est introuvable." );
        }
 
        try {
            properties.load( fichierProperties );
            url = properties.getProperty( PROPERTY_URL );
            driver = properties.getProperty( PROPERTY_DRIVER );
            nomUtilisateur = properties.getProperty( PROPERTY_NOM_UTILISATEUR );
            motDePasse = "";
            //motDePasse = properties.getProperty( PROPERTY_MOT_DE_PASSE );
            System.out.println("le fichier proprieter est charger");
        } catch ( IOException e ) {
            throw new DAOConfigurationException( "Impossible de charger le fichier properties " + FICHIER_PROPERTIES, e );
        }
 
        try {
            Class.forName( driver );
            System.out.println("le driver est charger");
        } catch ( ClassNotFoundException e ) {
            throw new DAOConfigurationException( "Le driver est introuvable dans le classpath.", e );
        }
 
        DAOFactory instance = new DAOFactory( url, nomUtilisateur, motDePasse );
        return instance;
    }
 
    /* M�thode charg�e de fournir une connexion � la base de donn�es */
     /* package */ 
    Connection getConnection() throws SQLException {
    	 Connection con = DriverManager.getConnection( url, username, password );
    	 if(con != null){
    		 System.out.println("connection � la base de donn� �tablie ");
    	 }
    	 else{
    		 System.out.println("No Connection");
    	 }
         
         return con;
      
    }

     /*
     * M�thodes de r�cup�ration de l'impl�mentation des diff�rents DAO (un seul
     * pour le moment)
     */
    public UtilisateurDao getUtilisateurDao() {
        return new UtilisateurDaoImpl( this );
    }
    
    public ProduitDao getProduitDao() {
        return new ProduitDaoImp( this );
    }
    
    
}
