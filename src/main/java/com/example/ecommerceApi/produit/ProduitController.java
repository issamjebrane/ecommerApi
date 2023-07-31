package com.example.ecommerceApi.produit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/produits")
public class ProduitController {

    @Autowired
    ProduitService produitService;


    @GetMapping("/getproduits")
    public List<Produit> getProduits(){
        return produitService.getProduit();
    }

    @GetMapping("/{id}")
    public Produit getProduit(@PathVariable Integer id){
        return produitService.findProduitById(id);
    }
    @GetMapping("/type/{type}")
    public Produit getProduit(@PathVariable String type){
        return produitService.findProduitByType(type);
    }

    @GetMapping("/filter")
    public List<Produit> filter(@RequestParam("type") String type){
         return produitService.filterByType(type.split(","));
    }
    @PostMapping("/save")
    public Produit addProduit(@RequestBody Produit produit){
        return produitService.addProduit(produit);
    }

    @GetMapping("/page/{pageNum}")
    public ResponseEntity<Page<Produit>> getProduitsByPage(@PathVariable int pageNum){
        int pageSize = 6;
        Page<Produit> produitsByPage= produitService.getProduitsByPage(pageNum,pageSize);
        return ResponseEntity.ok(produitsByPage);
    }
}
