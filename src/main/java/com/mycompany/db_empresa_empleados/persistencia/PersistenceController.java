package com.mycompany.db_empresa_empleados.persistencia;

import com.mycompany.db_empresa_empleados.logica.Departamento;
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
    DepartamentoJpaController depControl = new DepartamentoJpaController();

    // Empleados
    public void createEmploy(Empleado empleado) {
        empControl.create(empleado);
    }

    public void deleteEmploy(int id) /**/throws NonexistentEntityException {
        empControl.destroy(id);
        /*try {
            empControl.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(PersistenceController.class.getName()).log(Level.SEVERE, null, ex);
        }*/
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
    
    // Departamento

    public void createDepartment(Departamento depart) {
        depControl.create(depart);
    }

    public void deleteDepartment(int id) {
        try {
            depControl.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(PersistenceController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void editDepartment(Departamento depart) {
        try {
            depControl.edit(depart);
        } catch (Exception ex) {
            Logger.getLogger(PersistenceController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Departamento findDepartment(int id) {
        return depControl.findDepartamento(id);
    }

    public List<Departamento> departmentList() {
        return depControl.findDepartamentoEntities();
    }
    
}
