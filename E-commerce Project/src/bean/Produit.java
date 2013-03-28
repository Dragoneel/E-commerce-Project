package bean;

import java.io.Serializable;

public class Produit implements Serializable {
private Long id;
private String designation;
private float prix;
private String  categorie;
private String image;

public Produit() {
	super();
}

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getDesignation() {
	return designation;
}

public void setDesignation(String designation) {
	this.designation = designation;
}

public float getPrix() {
	return prix;
}

public void setPrix(float prix) {
	this.prix = prix;
}

public String getCategorie() {
	return categorie;
}

public void setCategorie(String categorie) {
	this.categorie = categorie;
}

public String getImage() {
	return image;
}

public void setImage(String image) {
	this.image = image;
}


}
