package com.mycompany.db_empresa_empleados.persistencia;

import com.mycompany.db_empresa_empleados.logica.Direccion;
import com.mycompany.db_empresa_empleados.logica.Empleado;
import com.mycompany.db_empresa_empleados.persistencia.exceptions.NonexistentEntityException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PersistenceController {

    EmpleadoJpaController empControl = new EmpleadoJpaController();
    DireccionJpaController dirControl = new DireccionJpaController();

    // Empleados
    public void createEmploy(Empleado empleado) {
        empControl.create(empleado);
    }

    public void deleteEmploy(int id) {
        try {
            empControl.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(PersistenceController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void editEmploy(Empleado empleado) {
        try {
            empControl.edit(empleado);
        } catch (Exception ex) {
            Logger.getLogger(PersistenceController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Empleado findEmploy(int id) {
        return empControl.findEmpleado(id);
    }

    public List<Empleado> employsList() {
        return empControl.findEmpleadoEntities();
    }
    
    
    // Direccion

    public void createAddress(Direccion direccion) {
        dirControl.create(direccion);
    }

    public void deleteAddress(int id) {
        try {
            dirControl.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(PersistenceController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void editAddress(Direccion direccion) {
        try {
            dirControl.edit(direccion);
        } catch (Exception ex) {
            Logger.getLogger(PersistenceController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Direccion findAddress(int id) {
        return dirControl.findDireccion(id);
    }

    public List<Direccion> addressList() {
        return dirControl.findDireccionEntities();
    }
    
    
}
