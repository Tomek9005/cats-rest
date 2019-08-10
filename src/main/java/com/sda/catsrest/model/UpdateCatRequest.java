package com.sda.catsrest.model;

import lombok.Data;
import javax.validation.constraints.NotNull;
@Data
public class UpdateCatRequest {
    private String name;
    private Integer age;
}