package com.example.mytricount.Models;

import java.io.Serializable;
import java.util.Date;

public class Tricount implements Serializable {
    private String titre;
    private String description;


public Tricount(String titre, String description){
    this.titre = titre;
    this.description = description;

}

    @Override
    public String toString() {
        return "Tricount{" +
                "titre='" + titre + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    public String getTitre() {
        return titre;
    }

    public String getDescription() {
        return description;
    }


}
