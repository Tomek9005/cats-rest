package com.sda.catsrest.service;

import com.sda.catsrest.model.Cat;
import com.sda.catsrest.model.CatDto;
import com.sda.catsrest.model.CreateCatRequest;
import lombok.experimental.UtilityClass;

@UtilityClass
//tworzy prywatny konstruktor -> nie mozna utworzyc instancji klasy
//wszystkie metody sa statyczne
public class CatMapper {

    CatDto map(Cat entity){
        return CatDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .age(entity.getAge())
                .build();
    }

    Cat map(CreateCatRequest request) {
        return Cat.builder()
                .name(request.getName())
                .age(request.getAge())
                .build();
    }



}
