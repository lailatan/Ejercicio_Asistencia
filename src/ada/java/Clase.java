package ada.java;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Clase {
    private Integer numero;
    private LocalDate fecha;
    private LocalTime hora;
    private String tema;

    public Clase(Integer numero, LocalDate fecha, LocalTime hora, String tema) {
        this.numero = numero;
        this.fecha = fecha;
        this.hora = hora;
        this.tema = tema;
    }

    public Integer getNumero() {
        return numero;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public LocalTime getHora() {
        return hora;
    }

    public String getTema() {
        return tema;
    }

    public void mostrarDatos(){
        System.out.print("Clase N°: "+  numero);
        System.out.print(" - Fecha: " + fecha.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        System.out.print(" - Hora: " + hora.format(DateTimeFormatter.ofPattern("HH:mm")));
        System.out.println(" - Tema: " + tema);
    }
}