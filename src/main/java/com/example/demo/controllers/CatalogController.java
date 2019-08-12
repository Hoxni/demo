package com.example.demo.controllers;

import com.example.demo.catalog.Catalog;
import com.example.demo.catalog.CatalogUpdateModel;
import com.example.demo.services.CatalogService;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("api/products/catalogs")
public class CatalogController {

    private final CatalogService catalogService;

    public CatalogController(CatalogService catalogService) {
        this.catalogService = catalogService;
    }

    @GetMapping("/active")
    public Catalog getActiveCatalog(){
        return catalogService.getActiveCatalog();
    }

    @PutMapping("/{id}")
    public void saveCatalog(@PathVariable Long id, @RequestBody CatalogUpdateModel catalogUpdateModel){
        catalogService.update(id, catalogUpdateModel);
    }
}
