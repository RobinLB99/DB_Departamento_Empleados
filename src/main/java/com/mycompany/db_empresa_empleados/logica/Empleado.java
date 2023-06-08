package com.mycompany.db_empresa_empleados.logica;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Empleado implements Serializable {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    private String nombres;
    private String apellidos;
    @Temporal(TemporalType.DATE)
    private Date f_Nacimiento;
    @OneToOne
    private Direccion direccion;
    @ManyToOne
    private Departamento departamento;

    public Empleado() {
    }

    public Empleado(int id, String nombres, String apellidos, Date f_Nacimiento, Direccion direccion, Departamento departamento) {
        this.id = id;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.f_Nacimiento = f_Nacimiento;
        this.direccion = direccion;
        this.departamento = departamento;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Date getF_Nacimiento() {
        return f_Nacimiento;
    }

    public void setF_Nacimiento(Date f_Nacimiento) {
        this.f_Nacimiento = f_Nacimiento;
    }
    
    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    
}
