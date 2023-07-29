package com.example.ecommerceApi.produit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProduitServiceImpl implements ProduitService{

    @Autowired
    ProduitRepository produitRepository;
    public Produit addProduit(Produit produit) {
        return produit;
    }

    public Produit findProduitById(Integer id) {
        return produitRepository.findById(id).orElse(null);
    }

    public List<Produit> getProduit() {
        return produitRepository.findAll();
    }

    public Produit findProduitByType(String type) {
        return null;
    }



    public Page<Produit> getProduitsByPage(int pageNum, int pageSize){
        Pageable pageable = PageRequest.of(pageNum,pageSize);
        return produitRepository.findAll(pageable);
    }
}
