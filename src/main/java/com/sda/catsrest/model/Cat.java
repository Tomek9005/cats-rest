package com.sda.catsrest.model;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import java.time.LocalDate;

@Entity(name = "cats")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Cat {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private Integer age;

    private LocalDate createdAt;


    @PrePersist
    void beforeSave(){
        createdAt = LocalDate.now();
    }

}
