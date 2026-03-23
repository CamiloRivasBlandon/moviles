package com.example.calculadoraclase;

import java.io.Serializable;

public class Preferencias implements Serializable {
    private String notificaciones, tema, idioma, privacidad, frecuenciaCorreos;
    private String tamañoLetra, sonidos, autoguardado, formatoHora, pantallaInicio;

    public Preferencias() {}

    public String getNotificaciones() { return notificaciones; }
    public void setNotificaciones(String notificaciones) { this.notificaciones = notificaciones; }

    public String getTema() { return tema; }
    public void setTema(String tema) { this.tema = tema; }

    public String getIdioma() { return idioma; }
    public void setIdioma(String idioma) { this.idioma = idioma; }

    public String getPrivacidad() { return privacidad; }
    public void setPrivacidad(String privacidad) { this.privacidad = privacidad; }

    public String getFrecuenciaCorreos() { return frecuenciaCorreos; }
    public void setFrecuenciaCorreos(String frecuenciaCorreos) { this.frecuenciaCorreos = frecuenciaCorreos; }

    public String getTamañoLetra() { return tamañoLetra; }
    public void setTamañoLetra(String tamañoLetra) { this.tamañoLetra = tamañoLetra; }

    public String getSonidos() { return sonidos; }
    public void setSonidos(String sonidos) { this.sonidos = sonidos; }

    public String getAutoguardado() { return autoguardado; }
    public void setAutoguardado(String autoguardado) { this.autoguardado = autoguardado; }

    public String getFormatoHora() { return formatoHora; }
    public void setFormatoHora(String formatoHora) { this.formatoHora = formatoHora; }

    public String getPantallaInicio() { return pantallaInicio; }
    public void setPantallaInicio(String pantallaInicio) { this.pantallaInicio = pantallaInicio; }
}