package com.sda.catsrest.controller;

import com.sda.catsrest.model.CatDto;
import com.sda.catsrest.model.CreateCatRequest;
import com.sda.catsrest.model.UpdateCatRequest;
import com.sda.catsrest.service.CatManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/cats")
public class CatController {

    private final CatManager catManager;

    @Autowired
    public CatController(CatManager catManager) {
        this.catManager = catManager;
    }

    @GetMapping
    List<CatDto> getAllCats() {
        return catManager.getAllCats();
    }

    @GetMapping("/{id}")
    ResponseEntity<CatDto> getCat(@PathVariable("id") Long id){
        return new ResponseEntity<>(catManager.getCat(id),HttpStatus.OK);
    }

    @PostMapping
    ResponseEntity<CatDto> saveCat(@RequestBody @Valid CreateCatRequest createCatRequest) {
        CatDto savedCat = catManager.saveCat(createCatRequest);
        return new ResponseEntity<>(savedCat, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    void deleteCat(@PathVariable("id") Long id){
        catManager.deleteCat(id);
    }

    @PutMapping("/{id}")
    ResponseEntity<CatDto> editCat(@PathVariable("id") Long id, @RequestBody UpdateCatRequest catRequest)
    {
        CatDto updatedCat = catManager.editCat(id, catRequest);
        return new ResponseEntity<>(updatedCat, HttpStatus.OK);
    }
    @PatchMapping("/{id}")
    ResponseEntity<CatDto> patchCat(@PathVariable("id") Long id, @RequestBody UpdateCatRequest catRequest)
    {
        CatDto updatedCat = catManager.patchCat(id, catRequest);
        return new ResponseEntity<>(updatedCat, HttpStatus.OK);
    }
}
