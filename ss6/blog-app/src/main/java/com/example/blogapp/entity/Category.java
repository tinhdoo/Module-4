package com.example.blogapp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Entity(name = "category")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cag")
    private Integer id_cag;

    @Column(name = "name_cag")
    private String name_cag;


    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private List<Blog> blogs;

}
