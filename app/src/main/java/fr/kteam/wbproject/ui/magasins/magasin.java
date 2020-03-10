package fr.kteam.wbproject.ui.magasins;

import java.util.ArrayList;

import fr.kteam.wbproject.ui.promotions.promotion;

public class magasin {
    private String nom, adresse, description, coord;
    private int idMagasin;
    private ArrayList<promotion> promo;

    public magasin(String nom, String adresse, String description, String coord, int idMagasin) {
        this.nom = nom;
        this.adresse = adresse;
        this.description = description;
        this.coord = coord;
        this.idMagasin = idMagasin;
    }

    public magasin(String nom, String adresse, String description, String coord, int idMagasin, ArrayList<promotion> promo) {
        this.nom = nom;
        this.adresse = adresse;
        this.description = description;
        this.coord = coord;
        this.idMagasin = idMagasin;
        this.promo = promo;
    }
}
