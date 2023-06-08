package com.mycompany.db_empresa_empleados.prompt;

import com.mycompany.db_empresa_empleados.logica.Departamento;
import com.mycompany.db_empresa_empleados.logica.Direccion;
import com.mycompany.db_empresa_empleados.logica.Empleado;
import com.mycompany.db_empresa_empleados.logica.LogicController;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class IngresarEmpleados {
    
    InputStreamReader in = new InputStreamReader(System.in);
    BufferedReader buffer = new BufferedReader(in);

    LogicController control = new LogicController();
    IngresarDireccion inDir = new IngresarDireccion();
    
    public void processIn() {
        
        String nombresE = "";
        String apellidosE = "";
        String fNacimiento;
        Direccion direccion;
        int departamento = 0;
        
        boolean repeat;
        
        do {
            repeat = false;
            boolean repeatI;
            
            // Ingresar Empleados
            System.out.println("\n----- INGRESE LOS EMPLEADOS -----");
            do {  
                //Nombres
                repeatI = false;
                System.out.println("Ingrese los nombres del empleado.");
                try {
                    nombresE = buffer.readLine();
                    
                    if(nombresE.isBlank()){
                        System.out.println("Debe ingresar un nombre!");
                        repeatI = true;
                    }
                    
                } catch (IOException ex) {
                    repeatI = true;
                    Logger.getLogger(IngresarEmpleados.class.getName()).log(Level.SEVERE, null, ex);
                }
            } while (repeatI);
            
            do {  
                //Apellidos
                repeatI = false;
                System.out.println("Ingrese los apellidos del empleado.");
                try {
                    apellidosE = buffer.readLine();
                    
                    if (apellidosE.isBlank()) {
                        System.out.println("Debe ingresar los apellidos!");
                        repeatI = true;
                    }
                    
                } catch (IOException ex) {
                    repeatI = true;
                    Logger.getLogger(IngresarEmpleados.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            } while (repeatI);
            
            do {  
                //Fecha de nacimiento
                repeatI = false;
                System.out.println("Ingrese una fecha de nacimiento.");
                System.out.println("* Formato Año/Dia/Mes - 0000/00/00 *");
                
                try {
                    fNacimiento = buffer.readLine();
                    
                    if (fNacimiento.isBlank() || fNacimiento.isEmpty()) {
                        repeatI = true;
                        System.out.println("Ingrese una fecha!");
                    }
                    
                } catch (IOException ex) {
                    repeatI = true;
                    Logger.getLogger(IngresarEmpleados.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            } while (repeatI);
            
            do {     
                // Direccion
                repeatI = false;
                direccion = inDir.inDireccion();
                
            } while (repeatI);
            
            do {
                //Departamento
                repeatI = false;
                System.out.println("Asigne un departamento por medio de su ID");
                try {
                    departamento = Integer.parseInt(buffer.readLine());
                    
                } catch (IOException ex) {
                    repeatI = true;
                    Logger.getLogger(IngresarEmpleados.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            } while (repeatI);
            
            
            try {
                Departamento depart = control.buscarDepartamento(departamento);
                
                control.crearDireccion(direccion);
                
                Empleado employ = new Empleado(0, nombresE, apellidosE, new Date(), direccion, depart);
                control.crearEmpleado(employ);
                
            } catch (Exception e) {
                System.out.println("Ups! Ocurrio un error. Intentemoslo de nuevo!");
                System.err.println(e);
                repeat = true;
            }
                    
            
            
        } while (repeat);
        
        
        
    }
    
}
