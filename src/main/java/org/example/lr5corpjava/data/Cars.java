package org.example.lr5corpjava.data;

import jakarta.persistence.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "cars")
public class Cars {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    public Cars() {}

    public int getId() {return id;}
    public void setId(int id) {this.id = id;}

}

