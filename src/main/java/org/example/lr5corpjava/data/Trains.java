package org.example.lr5corpjava.data;

import jakarta.persistence.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "trains")
public class Trains {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    public Trains() {}

    public int getId() {return id;}
    public void setId(int id) {this.id = id;}

}

