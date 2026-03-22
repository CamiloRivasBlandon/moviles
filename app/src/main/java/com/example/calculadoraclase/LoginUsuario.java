
package com.example.calculadoraclase;

import java.io.Serializable;

public class LoginUsuario implements Serializable {

    private String nombreUsuario;
    private String contraseñaUsuario;
    public String getNombreUsuario() {return nombreUsuario;}
    public void setNombreUsuario(String nombreUsuario) {this.nombreUsuario = nombreUsuario;}
    public String getContraseñaUsuario() {return contraseñaUsuario;}
    public void setContraseñaUsuario(String contraseñaUsuario) {this.contraseñaUsuario = contraseñaUsuario;}
}
