package dao;

import java.util.List;

import bean.utilisateur;

public interface UtilisateurDao {
 
    void creer( utilisateur utilisateur ) throws Exception;
    
    utilisateur findby(String nom) throws Exception;
    
    List<utilisateur> findAll() throws Exception;
    
    void update(String nom) throws Exception;
    
    Boolean supprimer(String nom) throws Exception;
 
}
