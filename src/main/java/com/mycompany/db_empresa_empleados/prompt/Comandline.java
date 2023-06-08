package com.mycompany.db_empresa_empleados.prompt;

public class Comandline {
    
    public void iniciar() {
        
        // Verifica si existe una lista de departamentos. Si no existe, los crea.
        ListDepartmentsIsEmpty inDepartment = new ListDepartmentsIsEmpty();
        inDepartment.crearDepartamento();
        
        // Verifica si existe una lista de empleados. Si no existe, los crea.
        ListEmployesIsEmpty inEmployes = new ListEmployesIsEmpty();
        inEmployes.crearEmpleados();
        
        
    }
    
}
