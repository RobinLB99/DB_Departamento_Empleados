package com.mycompany.db_empresa_empleados.prompt;

import com.mycompany.db_empresa_empleados.logica.Departamento;
import com.mycompany.db_empresa_empleados.logica.LogicController;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

public class IngresarDepartamentos {
    
    InputStreamReader in = new InputStreamReader(System.in);
    BufferedReader buffer = new BufferedReader(in);
    
    LogicController control = new LogicController();
    
    public void InputDepartments() {
        
        boolean repeat;
        
        int id = 0;
        String nombreDep = "";
        String descripDep = "";
        
        
        do {
            repeat = false;

            boolean repeatI;
            
            System.out.println("\n ----- Ingresar Departamentos ----- ");
            do {
                repeatI = false;
                System.out.println("Ingrese el nombre del departamento: ");
                System.out.flush();
                try {
                    nombreDep = buffer.readLine();
                    if (nombreDep.isBlank()) {
                        repeatI = true;
                    }
                } catch (IOException ex) {
                    System.out.println("Error al leer el input!");
                    repeatI = true;
                }
            } while (repeatI);

            do {
                repeatI = false;
                System.out.println("Ingrese la descripcion del departamento. *Precione Enter si desea dejar el campo vacio.* ");
                System.out.flush();
                try {
                    descripDep = buffer.readLine();
                } catch (IOException ex) {
                    System.out.println("Error al leer el input!");
                    repeatI = true;
                }
            } while (repeatI);

            Departamento depart = new Departamento(id, nombreDep, descripDep);
            control.crearDepartamento(depart);
            System.out.println("Departamento creado!");

            boolean repeatP;
            
            do {
                repeatP = false;

                System.out.println("\nDesea ingresar otro departamento?\n* Si(Ingrese 1)      No(Ingrese 2)");
                String opc;
                System.out.flush();
                try {
                    opc = buffer.readLine();
                    
                    if (opc.equals("1")) {
                        repeat = true;
                    } else if (opc.equals("2")) {
                        //
                    } else {
                        System.out.println("Opcion Invalida! Ingrese una opcion valida!");
                        repeatP = true;
                    }
                } catch (IOException ex) {
                    Logger.getLogger(IngresarDepartamentos.class.getName()).log(Level.SEVERE, null, ex);
                    repeatP = true;
                }

            } while (repeatP);
        } while (repeat);
        
    }
    
}
