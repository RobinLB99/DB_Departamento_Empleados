package com.mycompany.db_empresa_empleados.prompt;

import com.mycompany.db_empresa_empleados.logica.Empleado;
import com.mycompany.db_empresa_empleados.logica.LogicController;
import java.util.ArrayList;
import java.util.List;

public class ListEmployesIsEmpty {
    
    LogicController control = new LogicController();
    IngresarEmpleados inEmploys = new IngresarEmpleados();
    
    public void crearEmpleados() {
        
        List<Empleado> lista = control.listaEmpleados();
        ArrayList employesList = new ArrayList(lista);
        
        if (employesList.isEmpty()) {
            System.out.println("Lista de empleados vacia!");
            inEmploys.processIn();
        }
        
    }
    
}
