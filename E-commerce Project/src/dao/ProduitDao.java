package dao;

import java.util.List;
import bean.Produit;


public interface ProduitDao {
	
    void creer( Produit produit ) throws Exception;
    
    Produit findby(String nom) throws Exception;
    
    List<Produit> findAll() throws Exception;
    
    List<Produit> findAll(int offset, int noOfRecords) throws Exception;
    
    int getNoOfRecords()  throws Exception;
    
    void update(String nom) throws Exception;
    
    Boolean supprimer(String nom) throws Exception;

}
