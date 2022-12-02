package org.example.model;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// Lombok annotations to simplify getters/setters/constructors
@Data
@NoArgsConstructor
@AllArgsConstructor
// make this class a table in our db:
@Entity
@Table(name = "zoid")
public class Zoid {
    // make the id field an id with auto-generated values:
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String animal_type;
    private String code_name;
    private String color;
    private double height;
    private int strength;

    // Constructor with no id:
    public Zoid(String animal_type, String code_name, String color, double height, int strength) {
        this.animal_type = animal_type;
        this.code_name = code_name;
        this.color = color;
        this.height = height;
        this.strength = strength;
    }
}
