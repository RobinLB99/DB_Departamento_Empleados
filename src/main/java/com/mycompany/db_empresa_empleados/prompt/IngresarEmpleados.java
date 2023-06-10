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
    Pantalla pantalla = new Pantalla();

    LogicController control = new LogicController();
    IngresarDireccion inDir = new IngresarDireccion();

    int opc;
    
    public void processIn() {
        
        String nombresE = "";
        String apellidosE = "";
        String fNacimiento;
        Direccion direccion;
        int departamento = 0;
        
        boolean repeat;

        // Ingresar Empleados
        System.out.println("\n----- INGRESE LOS EMPLEADOS -----");

        do {
            repeat = false;
            boolean repeatI;
            boolean repetirP;

            //Nombres
            do {
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

            //Apellidos
            do {
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

            //Fecha de nacimiento
            do {
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

            // Direccion
            do {
                repeatI = false;
                direccion = inDir.inDireccion();
                
            } while (repeatI);

            //Departamento
            do {
                repeatI = false;
                System.out.println("Asigne un departamento por medio de su ID");
                try {
                    departamento = Integer.parseInt(buffer.readLine());
                    
                } catch (IOException ex) {
                    repeatI = true;
                    Logger.getLogger(IngresarEmpleados.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            } while (repeatI);
            
            // Creacion de empleado
            try {
                Departamento depart = control.buscarDepartamento(departamento);
                
                control.crearDireccion(direccion);
                
                Empleado employ = new Empleado(0, nombresE, apellidosE, new Date(), direccion, depart);
                control.crearEmpleado(employ);
                
            } catch (Exception e) {
                System.out.println("Ups! Ocurrio un error. Intentemoslo de nuevo!");
                pantalla.pausa();
                repeat = true;
            }

            // Pregunta de confirmacion para ingresar otro empleado a la lista.
            do {
                repetirP = false;
                System.out.println("\n¿Desea ingresar otro empleado?\nSi(1)     No(2)");
                try {
                    opc = Integer.parseInt(buffer.readLine());

                    if (opc == 1) {
                        repeat = true;
                    } else if (opc == 2) {
                        repeat = false;
                    } else {
                        repetirP = true;
                        System.out.println("No ingresaste una opcion valida!. Intentalo otra vez.");
                        pantalla.pausa();
                    }

                } catch (Exception e) {
                    repetirP = true;
                    System.out.println("Ups! Solo se permiten caracteres numericos.\nIntentalo otra vez!");
                    pantalla.pausa();
                }

            } while (repetirP);

        } while (repeat);
        
    }
    
}
