package ada.java;

import java.time.LocalDate;
import java.time.LocalTime;

public class Asistencia {
    private Integer numeroClase;
    private LocalDate fecha;
    private LocalTime hora;

    public Asistencia(Integer numeroClase, LocalDate fecha, LocalTime hora) {
        this.numeroClase = numeroClase;
        this.fecha = fecha;
        this.hora = hora;
    }

    public Integer getNumeroClase() {
        return numeroClase;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public LocalTime getHora() {
        return hora;
    }
}
