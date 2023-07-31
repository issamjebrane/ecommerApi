package com.example.ecommerceApi.produit;

import jakarta.persistence.*;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProduitService {

    Produit addProduit(Produit produit);
    Produit findProduitById(Integer id);
    List<Produit> getProduit();
    Produit findProduitByType(String type);

    Page<Produit> getProduitsByPage(int pageNum, int pageSize);

    List<Produit> filterByType(String[] type);
}
