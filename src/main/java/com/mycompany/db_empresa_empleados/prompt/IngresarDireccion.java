package com.mycompany.db_empresa_empleados.prompt;

import com.mycompany.db_empresa_empleados.logica.Direccion;
import com.mycompany.db_empresa_empleados.logica.LogicController;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

public class IngresarDireccion {
    
    InputStreamReader in = new InputStreamReader(System.in);
    BufferedReader buffer = new BufferedReader(in);

    LogicController control = new LogicController();
    
    private String calle;
    private String ciudad;
    private String estado;
    private String codigoPostal;
    Direccion dir;
    
    public Direccion inDireccion() {

        boolean repetir;
        
        do {   
            repetir = false;
            
            System.out.println("\n----- Ingresa la direccion domiciliar del empleado -----");
            
            boolean repetirIn;
            
            //Calle
            do {              
                repetirIn = false;
                
                System.out.println("Ingrese la calle.");
                try {
                    calle = buffer.readLine();
                    
                    if(calle.isEmpty() || calle.isBlank()) {
                        repetirIn = true;
                        System.out.println("El campo no puede quedar vacio!");
                    }
                    
                } catch (IOException ex) {
                    repetirIn = true;
                    System.err.println(ex);
                    Logger.getLogger(IngresarDireccion.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            } while (repetirIn);
            
            //Ciudad
            do {              
                repetirIn = false;
                
                System.out.println("Ingresa la ciudad");
                
                try {
                    ciudad = buffer.readLine();
                    
                    if (ciudad.isBlank() || ciudad.isEmpty()) {
                        repetirIn = true;
                        System.out.println("No puede dejar el campo vacio!");
                    }
                    
                } catch (IOException ex) {
                    repetirIn = true;
                    System.err.println(ex);
                    Logger.getLogger(IngresarDireccion.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            } while (repetirIn);
            
            // Estado
            do {              
                repetirIn = false;
                
                System.out.println("Ingresa el estado o provincia.");
                
                try {
                    estado = buffer.readLine();
                    
                    if (estado.isBlank() || estado.isEmpty()) {
                        repetirIn = true;
                        System.out.println("No puede dejar este campo vacio.");
                    }
                    
                } catch (IOException ex) {
                    repetirIn = true;
                    System.err.println(ex);
                    Logger.getLogger(IngresarDireccion.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            } while (repetirIn);
            
            // Codigo postal
            do {              
                repetirIn = false;
                
                System.out.println("Ingresa el codigo postal.");
                
                try {
                    codigoPostal = buffer.readLine();
                    
                    if (codigoPostal.isBlank() || codigoPostal.isEmpty()) {
                        repetirIn = true;
                        System.out.println("El campo no puede ir vacio!");
                    }
                    
                } catch (IOException ex) {
                    repetirIn = true;
                    System.err.println(ex);
                    Logger.getLogger(IngresarDireccion.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            } while (repetirIn);
                    
            try {
                dir = new Direccion(0, calle, ciudad, estado, codigoPostal);
                
            } catch (Exception e) {
                System.out.println("Ups! Ocurrio un error. Intentemoslo de nuevo.");
                repetir = true;
            }
            
        } while (repetir);
        
        return dir;
    }
    
}
