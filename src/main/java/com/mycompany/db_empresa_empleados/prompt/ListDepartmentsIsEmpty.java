package com.mycompany.db_empresa_empleados.prompt;

import com.mycompany.db_empresa_empleados.logica.LogicController;
import java.util.ArrayList;

public class ListDepartmentsIsEmpty {
    
    LogicController control = new LogicController();
    IngresarDepartamentos inDepart = new IngresarDepartamentos();
    
    public void crearDepartamento() {
        
        ArrayList listaDepartamentos = control.listaDepartamentos();
        
        if (listaDepartamentos.isEmpty()) {
            // Ingresar por primera vez lista de Departamentos
            inDepart.InputDepartments(); 
        }
          
    }
  
}
