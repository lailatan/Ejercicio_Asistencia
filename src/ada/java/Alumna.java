package ada.java;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Alumna extends Persona{
    private List<Asistencia> asistencias;

    public Alumna(String nombre, LocalDate fechaNacimiento) {
        super(nombre, fechaNacimiento);
        asistencias = new ArrayList<>();
    }

    public List<Asistencia> getAsistencias() {
        return asistencias;
    }

    public void agregarAsistencia(Asistencia asistencia) {
        this.asistencias.add(asistencia);
    }

    public Integer totalClasesVistas(){
        return asistencias.size();
    }

    public String asistioAClase(Clase clase){
        String asistencia=null;
        for (Asistencia a: asistencias){
            if (a.getNumeroClase()==clase.getNumero()) {
                if (a.getFecha().equals(clase.getFecha()) && a.getHora().equals(clase.getHora())) asistencia="Vivo";
                else asistencia = "Diferido";
            }
        }
        Integer anioClase = clase.getFecha().getYear();
        //Veo si esta exceptuada por Cumpleaños
        if (asistencia==null && clase.getFecha().equals(LocalDate.of(anioClase,fechaNacimiento.getMonth(),fechaNacimiento.getDayOfMonth())))
                asistencia="Exceptuada";
        return asistencia;
    }

}
