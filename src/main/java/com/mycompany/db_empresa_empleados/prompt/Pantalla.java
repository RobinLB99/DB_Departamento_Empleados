package com.mycompany.db_empresa_empleados.prompt;

import java.util.Scanner;

public class Pantalla {
    Scanner scanner = new Scanner(System.in);

    public void limpiar() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
    public void pausa() {
        System.out.println("Precione Enter para continuar...");
        scanner.nextLine();
    }
}
