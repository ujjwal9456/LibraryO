package com.LibraryO.LibraryManagement.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Table(name = "Library")
@NoArgsConstructor
public class Library {

    @Id
    @Column(name = "\"Id\"")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "libraryname")
    private String libraryname;

    @Column(name = "description")
    private String description;


}
