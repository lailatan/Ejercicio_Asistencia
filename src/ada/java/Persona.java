package ada.java;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Persona {
    private String nombre;
    protected LocalDate fechaNacimiento;

    public Persona(String nombre, LocalDate fechaNacimiento) {
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNombre() {
        return nombre;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void mostrarDatos(){
        //System.out.print("Alumna : "+  nombre);
        //System.out.println(" - Fecha Nacimiento: " + fechaNacimiento.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        System.out.printf("Nombre: %-30s  F.N.: %-12s",nombre, fechaNacimiento.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
    }
}
