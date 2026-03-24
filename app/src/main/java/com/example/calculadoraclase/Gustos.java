package com.example.calculadoraclase;

import java.io.Serializable;

public class Gustos implements Serializable {

    private String comidaFavorita;
    private String peliculaFavorita;
    private String generoMusical;
    private String colorFavorito;
    private String deporteFavorito;
    private String libroFavorito;
    private String pasatiempo;
    private String bebidaFavorita;
    private String animalFavorito;
    private String lugarDeViaje;

    public Gustos() {
    }
    public String getComidaFavorita() { return comidaFavorita; }
    public void setComidaFavorita(String comidaFavorita) { this.comidaFavorita = comidaFavorita; }

    public String getPeliculaFavorita() { return peliculaFavorita; }
    public void setPeliculaFavorita(String peliculaFavorita) { this.peliculaFavorita = peliculaFavorita; }

    public String getGeneroMusical() { return generoMusical; }
    public void setGeneroMusical(String generoMusical) { this.generoMusical = generoMusical; }

    public String getColorFavorito() { return colorFavorito; }
    public void setColorFavorito(String colorFavorito) { this.colorFavorito = colorFavorito; }

    public String getDeporteFavorito() { return deporteFavorito; }
    public void setDeporteFavorito(String deporteFavorito) { this.deporteFavorito = deporteFavorito; }

    public String getLibroFavorito() { return libroFavorito; }
    public void setLibroFavorito(String libroFavorito) { this.libroFavorito = libroFavorito; }

    public String getPasatiempo() { return pasatiempo; }
    public void setPasatiempo(String pasatiempo) { this.pasatiempo = pasatiempo; }

    public String getBebidaFavorita() { return bebidaFavorita; }
    public void setBebidaFavorita(String bebidaFavorita) { this.bebidaFavorita = bebidaFavorita; }

    public String getAnimalFavorito() { return animalFavorito; }
    public void setAnimalFavorito(String animalFavorito) { this.animalFavorito = animalFavorito; }

    public String getLugarDeViaje() { return lugarDeViaje; }
    public void setLugarDeViaje(String lugarDeViaje) { this.lugarDeViaje = lugarDeViaje; }
}