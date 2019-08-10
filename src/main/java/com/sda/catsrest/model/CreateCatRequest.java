package com.sda.catsrest.model;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class CreateCatRequest {

    @NotNull
    private String name;

    @NotNull
    private Integer age;
}
