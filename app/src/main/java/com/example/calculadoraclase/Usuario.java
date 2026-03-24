
package com.example.calculadoraclase;

import java.io.Serializable;

public class Usuario implements Serializable {
    private String cedula;
    private String nombre;
    private String apellido;
    private String correo;
    private String telefono;
    private String direccion;
    private String ciudad;
    private String departamento;
    private String codigoPostal;
    private String ocupacion;
    private String fechaNacimiento;
    private String genero;
    private Gustos misGustos;
    private Preferencias misPreferencias;

    public String getCedula() {return cedula;}
    public void setCedula(String cedula) {this.cedula = cedula;}
    public String getNombre() {return nombre;}
    public void setNombre(String nombre) {this.nombre = nombre;}
    public String getApellido() {return apellido;}
    public void setApellido(String apellido) {this.apellido = apellido;}
    public String getCorreo() {return correo;}
    public void setCorreo(String correo) {this.correo = correo;}
    public String getTelefono() {return telefono;}
    public void setTelefono(String telefono) {this.telefono = telefono;}
    public String getDireccion() {return direccion;}
    public void setDireccion(String direccion) {this.direccion = direccion;}
    public String getCiudad() {return ciudad;}
    public void setCiudad(String ciudad) {this.ciudad = ciudad;}
    public String getDepartamento() {return departamento;}
    public void setDepartamento(String departamento) {this.departamento = departamento;}
    public String getCodigoPostal() {return codigoPostal;}
    public void setCodigoPostal(String codigoPostal) {this.codigoPostal = codigoPostal;}
    public String getOcupacion() {return ocupacion;}
    public void setOcupacion(String ocupacion) {this.ocupacion = ocupacion;}
    public String getFechaNacimiento() {return fechaNacimiento;}
    public void setFechaNacimiento(String fechaNacimiento) {this.fechaNacimiento = fechaNacimiento;}
    public String getGenero() {return genero;}
    public void setGenero(String genero) {this.genero = genero;}
    public Gustos getMisGustos() { return misGustos; }
    public void setMisGustos(Gustos misGustos) { this.misGustos = misGustos; }
    public Preferencias getMisPreferencias() { return misPreferencias; }
    public void setMisPreferencias(Preferencias misPreferencias) { this.misPreferencias = misPreferencias; }
}
