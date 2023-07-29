package com.example.ecommerceApi.produit;

import jakarta.persistence.*;

@Entity
@Table(name = "product")
public class Produit {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    public Integer id;
    public String ref;
    public String type;
    public String description;
    public Long prix;
    public String image ;

    public Produit() {
    }

    public Produit(String ref, String type, String description, Long prix, String image) {
        this.ref = ref;
        this.type = type;
        this.description = description;
        this.prix = prix;
        this.image = image;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getPrix() {
        return prix;
    }

    public void setPrix(Long prix) {
        this.prix = prix;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
