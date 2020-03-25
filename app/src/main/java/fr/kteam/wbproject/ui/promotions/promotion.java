package fr.kteam.wbproject.ui.promotions;

public class promotion {

    private String magasin;
    private int idMagasin;
    private String titre;
    private String description;
    private float prixTotal, prixParArticle;
    private int nbArticles, nbArticleParPersonne;
    private boolean validated;
    private String publisher;
    private String lieuxRDV;

    public promotion() {
        this.magasin = "magasin";
        this.idMagasin = 2;
        this.titre = "titre";
        this.description = "description";
        this.prixTotal = (float) 99.99;
        this.prixParArticle = 10;
        this.nbArticles = 100;
        this.nbArticleParPersonne = 2;
        this.publisher = "default";
        this.lieuxRDV = "entree du magasin";
        validated = false;
    }

    public promotion(String magasin, int idMagasin, String titre, String description, float prixTotal, float prixParArticle, int nbArticles, int nbArticleParPersonne, String publisher, String lieuxRDV) {
        this.magasin = magasin;
        this.idMagasin = idMagasin;
        this.titre = titre;
        this.description = description;
        this.prixTotal = prixTotal;
        this.prixParArticle = prixParArticle;
        this.nbArticles = nbArticles;
        this.nbArticleParPersonne = nbArticleParPersonne;
        this.publisher = publisher;
        this.lieuxRDV = lieuxRDV;
        validated = false;
    }

    public String getMagasin() {
        return magasin;
    }

    public void setMagasin(String magasin) {
        this.magasin = magasin;
    }
    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getIdMagasin() {
        return idMagasin;
    }

    public void setIdMagasin(int idMagasin) {
        this.idMagasin = idMagasin;
    }

    public float getPrixTotal() {
        return prixTotal;
    }

    public void setPrixTotal(float prixTotal) {
        this.prixTotal = prixTotal;
    }

    public float getPrixParArticle() {
        return prixParArticle;
    }

    public void setPrixParArticle(float prixParArticle) {
        this.prixParArticle = prixParArticle;
    }

    public int getNbArticles() {
        return nbArticles;
    }

    public void setNbArticles(int nbArticles) {
        this.nbArticles = nbArticles;
    }

    public int getNbArticleParPersonne() {
        return nbArticleParPersonne;
    }

    public void setNbArticleParPersonne(int nbArticleParPersonne) {
        this.nbArticleParPersonne = nbArticleParPersonne;
    }

    public boolean isValidated() {
        return validated;
    }

    public void setValidated(boolean validated) {
        this.validated = validated;
    }
}
