package com.sda.catsrest.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CatDto {

    private Long id;

    private String name;

    private Integer age;
}
