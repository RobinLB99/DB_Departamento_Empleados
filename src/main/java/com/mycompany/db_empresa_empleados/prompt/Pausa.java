package com.mycompany.db_empresa_empleados.prompt;

//import java.io.IOException;
import java.util.Scanner;

public class Pausa {
    Scanner scanner = new Scanner(System.in);
    public void pausa() {
        System.out.println("Precione Enter para continuar...");
        scanner.nextLine();
    }

}
