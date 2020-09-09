package com.cacecres.crud1.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@Table(name = "USUARIO")
public class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String lastname;
    @ManyToOne
    private Distrito distrito;
    private boolean State;

    @PrePersist
    void prepersit (){
        State = true;
    }
}
