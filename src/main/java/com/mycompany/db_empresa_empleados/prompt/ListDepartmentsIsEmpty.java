package com.mycompany.db_empresa_empleados.prompt;

import com.mycompany.db_empresa_empleados.logica.LogicController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class ListDepartmentsIsEmpty {

    InputStreamReader in = new InputStreamReader(System.in);
    BufferedReader buffer = new BufferedReader(in);
    LogicController control = new LogicController();
    IngresarDepartamentos inDepart = new IngresarDepartamentos();
    
    public boolean crearDepartamento() {
        
        ArrayList listaDepartamentos = control.listaDepartamentos();
        boolean ok = true;
        
        if (listaDepartamentos.isEmpty()) {
            System.out.println("No hay departamentos en la base de datos!\n");

            // Ingresar por primera vez lista de Departamentos
            int opc;
            boolean repetir = false;

            do {
                repetir = false;

                System.out.flush();
                System.out.println("Desea ingresar departamentos a la lista?\nSi(1)  No(2)");

                try {
                    opc = Integer.parseInt(buffer.readLine());

                    if (opc == 1 ){
                        inDepart.InputDepartments();
                    } else if (opc == 2) {
                        ok = false;
                    } else {
                        repetir = true;
                        System.out.println("No se ingreso una opcion valida!");
                    }

                } catch (Exception e) {
                    repetir = true;
                    System.out.println("Ups! Hubo un error al ingresar la opcion. Intentalo de nuevo.");
                }

            }while(repetir);

        }

        return ok;
          
    }
  
}
