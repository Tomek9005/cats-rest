package com.sda.catsrest.service;

import com.sda.catsrest.exception.CatNotFoundException;
import com.sda.catsrest.model.Cat;
import com.sda.catsrest.model.CatDto;
import com.sda.catsrest.model.CreateCatRequest;
import com.sda.catsrest.model.UpdateCatRequest;
import com.sda.catsrest.repository.CatRepository;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

@Service
public class CatManager {

    private final CatRepository catRepository;

    public CatManager(CatRepository catRepository) {
        this.catRepository = catRepository;
    }

    public List<CatDto> getAllCats() {
        return catRepository.findAll().stream()
                //.map(c ->CatMapper.map(c))
                .map(CatMapper::map)
                .collect(toList());
    }

    public CatDto saveCat(CreateCatRequest createCatRequest) {
        Cat entity = CatMapper.map(createCatRequest);
        return CatMapper.map(catRepository.save(entity));
    }

    public CatDto getCat(Long id) {
        return catRepository.findById(id)
                .map(CatMapper::map)
                .orElseThrow(CatNotFoundException::new);
    }
    public CatDto editCat(Long id, UpdateCatRequest catRequest) {
        Cat existingCat = catRepository.findById(id).orElseThrow(CatNotFoundException::new);
        existingCat.setName(catRequest.getName());
        existingCat.setAge(catRequest.getAge());
        catRepository.save(existingCat);
        return CatMapper.map(existingCat);
    }

    public void deleteCat(Long id) {
        Cat cat = catRepository.findById(id).orElseThrow(CatNotFoundException::new);
        catRepository.delete(cat);
//        Optional<Cat> optionalCat = catRepository.findById(id);
//        if(optionalCat.isPresent()){
//            catRepository.delete(optionalCat.get());
//            return;
//        }
//        throw new CatNotFoundException();


//        catRepository.findById(id).map(i -> {
//            catRepository.delete(i);
//            return i;
//        }).orElseThrow(CatNotFoundException::new);

                //.ifPresent(i -> catRepository.delete(i));
        //.ifPresentOrElse(i -> catRepository.delete(i),() -> new CatNotFoundException());
    }

    public CatDto patchCat(Long id, UpdateCatRequest catRequest) {
        Cat existingCat = catRepository.findById(id).orElseThrow(CatNotFoundException::new);
        Optional.ofNullable(catRequest.getName()).ifPresent(existingCat::setName);
        Optional.ofNullable(catRequest.getAge()).ifPresent(existingCat::setAge);
        catRepository.save(existingCat);
        return CatMapper.map(existingCat);
    }
}


