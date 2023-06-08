package com.mycompany.db_empresa_empleados.logica;

import com.mycompany.db_empresa_empleados.persistencia.PersistenceController;
import java.util.ArrayList;
import java.util.List;

public class LogicController {
    
    PersistenceController perControl = new PersistenceController();
    
    // Empleado
    public void crearEmpleado(Empleado empleado) {
        perControl.createEmploy(empleado);
    }
    
    public void eliminarEmpleado(int id) {
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
    
}
