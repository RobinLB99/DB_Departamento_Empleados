package com.mycompany.db_empresa_empleados.prompt;

import com.mycompany.db_empresa_empleados.logica.Departamento;
import com.mycompany.db_empresa_empleados.logica.Empleado;
import com.mycompany.db_empresa_empleados.logica.LogicController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Comandline {

    InputStreamReader in = new InputStreamReader(System.in);
    BufferedReader buffer = new BufferedReader(in);
    Pausa pause = new Pausa();
    LogicController control = new LogicController();
    IngresarEmpleados inEmpleado = new IngresarEmpleados();

    boolean repetir;
    
    public void iniciar() {
        
        // Verifica si existe una lista de departamentos. Si no existe, los crea.
        ListDepartmentsIsEmpty inDepartment = new ListDepartmentsIsEmpty();
        boolean ok = inDepartment.crearDepartamento();

        if(ok) {
            // Verifica si existe una lista de empleados. Si no existe, los crea.
            ListEmployesIsEmpty inEmployes = new ListEmployesIsEmpty();
            inEmployes.crearEmpleados();

            // Menu principal
            do {
                repetir = false;

                System.out.println("\n ---------- Menu ---------- ");
                System.out.println("\n¿Que desea hacer?");
                System.out.println("(1) Ver lista de empleados      (2) Buscar empleado      (3) Crear empleado     (4) Eliminar empleado     (5) Ver lista de departamentos      (6) Crear departamento     (7) Eliminar departamento      (8) Salir");

                try {
                    System.out.flush();
                    System.out.println("Opcion: ");
                    int opc = Integer.parseInt(buffer.readLine());

                    switch (opc) {
                        // Ver lista de empleados
                        case 1:
                            repetir = true;
                            System.out.println("------------------------- Lista de Empleados -------------------------");
                            System.out.println("----------------------------------------------------------------------\n");
                            ArrayList<Empleado> lista = control.listaEmpleados();
                            for (Empleado employ : lista) {
                                System.out.println("ID: " + employ.getId() +
                                        " | Nombres: " + employ.getNombres() +
                                        " | Apellidos: " + employ.getApellidos() +
                                        " | Fecha Nacimiento: " + employ.getF_Nacimiento() +
                                        " | Direccion: " + employ.getDireccion().getCalle() +
                                                ", " + employ.getDireccion().getCiudad() +
                                                "/" + employ.getDireccion().getEstado() +
                                                ", " + employ.getDireccion().getCodigoPostal() +
                                        " | Departemento: " + employ.getDepartamento().getNombre());
                                System.out.println("---------------------------------------------");
                            }
                            pause.pausa();
                            System.out.flush();
                            break;

                        // Buscar empleado
                        case 2:
                            boolean repetirId;

                            do {
                                repetirId = false;
                                System.out.flush();
                                System.out.println("\nIngresa el ID del empleado a buscar");
                                try {
                                    int id = Integer.parseInt(buffer.readLine());

                                    try {
                                        Empleado empleado = control.buscarEmpleado(id);
                                        System.out.println("\n-------------------------------------------");
                                        System.out.println("ID: " + empleado.getId() +
                                                " | Nombres: " + empleado.getNombres() +
                                                " | Apellidos: " + empleado.getApellidos() +
                                                " | Fecha Nacimiento: " + empleado.getF_Nacimiento() +
                                                " | Direccion: " + empleado.getDireccion().getCalle() +
                                                        ", " + empleado.getDireccion().getCiudad() +
                                                        "/" + empleado.getDireccion().getEstado() +
                                                        ", " + empleado.getDireccion().getCodigoPostal() +
                                                " | Departemento: " + empleado.getDepartamento().getNombre());
                                        System.out.println("-------------------------------------------");
                                        pause.pausa();
                                        System.out.flush();
                                        repetir = true;

                                    } catch (Exception e) {
                                        repetirId = true;
                                        System.out.println("El empleado no encontrado. Ingrese una ID valida!.");
                                        pause.pausa();
                                        System.out.flush();
                                    }

                                } catch (Exception e) {
                                    repetirId = true;
                                    System.out.println("El carracter a ingresar debe ser numerico!");
                                    pause.pausa();
                                    System.out.flush();
                                }

                            } while (repetirId);
                            break;

                        // Crear empleado
                        case 3:
                            inEmpleado.processIn();
                            repetir = true;
                            break;

                        // Eliminar empleado
                        case 4:
                            boolean repetirDelete;
                            do {
                                repetirDelete = false;

                                System.out.println("\nIngrese el ID del empleado que desea eliminar:");
                                try {
                                    int idEmp = Integer.parseInt(buffer.readLine());
                                    try {
                                        repetir = true;
                                        Empleado employ = control.buscarEmpleado(idEmp);
                                        int idEmploy = employ.getDireccion().getId();
                                        control.eliminarEmpleado(idEmp);
                                        control.eliminarDireccion(idEmploy);
                                        System.out.println("Empleado eliminado de la base de datos exitosamente!\n");
                                        pause.pausa();

                                    } catch (Exception e) {
                                        repetirDelete = true;
                                        System.out.println("El ID que ingreso no se encuentra en el registro! Ingrese un ID de empleado valido.");
                                        pause.pausa();
                                    }
                                } catch (Exception e) {
                                    repetirDelete = true;
                                    System.out.println("Error! No se ingreso un caracter numerico. Intentalo otra vez!");
                                    pause.pausa();
                                }
                            } while (repetirDelete);
                            break;

                        // Lista de departamentos
                        case 5:
                            repetir = true;
                            System.out.println("\n--------------- Lista de Departamentos ---------------\n");
                            ArrayList<Departamento> departamentos = control.listaDepartamentos();
                            for(Departamento depar : departamentos) {
                                System.out.println("ID: " + depar.getId() +
                                                " | Nombre: " + depar.getNombre()+
                                                " | Descripcion: " + depar.getDescripcion());
                                System.out.println("----------------------------------------------------");
                            }
                            pause.pausa();
                            System.out.flush();
                            break;

                        // Cerrar el programa
                        case 8:
                            System.exit(0);
                            break;

                        default:
                            repetir = true;
                            System.out.println("No ingreso una opcion valida!\nIntenta otra vez!");
                            pause.pausa();
                            System.out.flush();

                    }

                } catch (Exception e) {
                    repetir = true;
                    System.out.println("Debe ingresar un caracter numerico!");
                    pause.pausa();
                    System.out.flush();
                }

            } while(repetir);

        }
        
    }
    
}