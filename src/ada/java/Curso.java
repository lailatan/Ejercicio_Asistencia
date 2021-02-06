package ada.java;

import java.time.format.DateTimeFormatter;
import java.util.List;

public class Curso {
    private String nombre;
    private List<Alumna> alumnas;
    private Persona profesor;
    private List<Clase> clases;
    private static final Integer PORCENTAJE_ASISTENCIA=75;

    public Curso(String nombre, List<Alumna> alumnas, Persona profesor, List<Clase> clases) {
        this.nombre = nombre;
        this.alumnas = alumnas;
        this.profesor = profesor;
        this.clases = clases;
    }

    public String getNombre() {
        return nombre;
    }

    public List<Alumna> getAlumnas() {
        return alumnas;
    }

    public Persona getProfesor() {
        return profesor;
    }

    public List<Clase> getClases() {
        return clases;
    }

    public Integer getCantidadClases() {
        return clases.size();
    }

    public void agregarAlumnas(Alumna alumna) {
        this.alumnas.add(alumna);
    }

    public void setProfesor(Persona profesor) {
        this.profesor = profesor;
    }

    public Integer asistenciaPorAlumna(Alumna alumna){
        Integer total=0;
        for (Clase clase:clases) if (alumna.asistioAClase(clase)!=null) total++;
        return total;
    }

    public void listarAlumnasCumplenAsistencia(Boolean cumplenAsistencia){
        Integer total = 0;
        Integer minimoAsistencia = Math.round(getCantidadClases()*PORCENTAJE_ASISTENCIA/100);
        for (Alumna alumna: alumnas) {
            Integer asistenciaAlumna = asistenciaPorAlumna(alumna);
            if (((asistenciaAlumna>=minimoAsistencia) && cumplenAsistencia) || ((asistenciaAlumna<minimoAsistencia) && !cumplenAsistencia)) {
                alumna.mostrarDatos();
                System.out.println();
                total++;
            }
        }
        System.out.println("Total Alumnas que " + (cumplenAsistencia?"alcanzan":"no alcanzan") + " el  " + PORCENTAJE_ASISTENCIA + "% de Asistencia: " + total);
        System.out.println("---------------------------------------------------------------------------------------------------------");
    }

    public void listarCantidadAsistenciaPorAlumna(Alumna alumna){
        Integer total=0;
        alumna.mostrarDatos();
        System.out.printf( "Asistencias: %-4d" , asistenciaPorAlumna(alumna));
        System.out.println();
    }

    public void listarAsistenciaUnaClase(Clase clase, Boolean enVivo){
        Integer total=0;
        clase.mostrarDatos();
        for (Alumna alumna:alumnas){
            String asiste= alumna.asistioAClase(clase);
            if (asiste!=null){
                if ((!enVivo) || (enVivo && asiste == "Vivo")) {
                    System.out.println(alumna.getNombre());
                    total++;
                }
            }
        }
        System.out.println("Total Asistencia: " + total);
        System.out.println("---------------------------------------------------------------------------------------------------------");
    }
}
