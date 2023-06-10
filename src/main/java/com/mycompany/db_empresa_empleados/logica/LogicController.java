package com.mycompany.db_empresa_empleados.logica;

import com.mycompany.db_empresa_empleados.persistencia.PersistenceController;
import com.mycompany.db_empresa_empleados.persistencia.exceptions.NonexistentEntityException;

import java.util.ArrayList;
import java.util.List;

public class LogicController {
    
    PersistenceController perControl = new PersistenceController();
    
    // Empleado
    public void crearEmpleado(Empleado empleado) {
        perControl.createEmploy(empleado);
    }
    
    public void eliminarEmpleado(int id) /**/throws NonexistentEntityException {
        perControl.deleteEmploy(id);
    }
    
    public void editarEmpleado(Empleado empleado) {
        perControl.editEmploy(empleado);
    }
    
    public Empleado buscarEmpleado(int id) {
        return perControl.findEmploy(id);
    }
    
    public ArrayList listaEmpleados() {
        List<Empleado> lista = perControl.employsList();
        ArrayList<Empleado> empleados = new ArrayList(lista);
        return empleados;
    }
    
    // Direccion
    public void crearDireccion(Direccion direccion) {
        perControl.createAddress(direccion);
    }

    public void eliminarDireccion(int id) {
        perControl.deleteAddress(id);
    }

    public void editarDireccion(Direccion direccion) {
        perControl.editAddress(direccion);
    }

    public Direccion buscarDireccion(int id) {
        return perControl.findAddress(id);
    }

    public ArrayList listaDirecciones() {
        List<Direccion> lista = perControl.addressList();
        ArrayList<Direccion> direcciones = new ArrayList(lista);
        return direcciones;
    }
    
    // Departamento
    public void crearDepartamento(Departamento depart) {
        perControl.createDepartment(depart);
    }
    
    public void eliminarDepartamento(int id) {
        perControl.deleteDepartment(id);
    }
    
    public void editarDepartamento(Departamento depart) {
        perControl.editDepartment(depart);
    }
    
    public Departamento buscarDepartamento(int id) {
        return perControl.findDepartment(id);
    }
    
    public ArrayList listaDepartamentos() {
        List<Departamento> lista = perControl.departmentList();
        ArrayList departamentos = new ArrayList(lista);
        return departamentos;
    }
    
}
