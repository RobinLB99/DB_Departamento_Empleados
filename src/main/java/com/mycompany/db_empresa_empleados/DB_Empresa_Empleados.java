package com.mycompany.db_empresa_empleados;

import com.mycompany.db_empresa_empleados.logica.Direccion;
import com.mycompany.db_empresa_empleados.logica.Empleado;
import com.mycompany.db_empresa_empleados.logica.LogicController;
import java.util.Date;

public class DB_Empresa_Empleados {

    public static void main(String[] args) {
        
        LogicController control = new LogicController();
        
        Direccion dir = new Direccion();
        control.crearDireccion(dir);
        
        Empleado employ1 = new Empleado(
                1, "Robin Joel", "Lugo Boero", new Date(),dir);
        control.crearEmpleado(employ1);
        
        dir.setId(1);
        dir.setEstado("Guayas");
        dir.setCiudad("Guayaquil");
        dir.setCalle("Av. Las Americas");
        dir.setCodigoPostal("0955412");
        
        control.editarDireccion(dir);
        
        
    }
}
