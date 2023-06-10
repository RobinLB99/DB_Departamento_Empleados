package com.mycompany.db_empresa_empleados.prompt;

public class Pantalla {
    public void limpiar() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
