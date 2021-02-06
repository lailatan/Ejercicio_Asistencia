package ada.java;
/*
Asistencia a clases
        Crear un sistema que permita registrar la asistencia a clases de las alumnas de ADA.
        Existen distintos cursos en el instituto. Cada curso tiene un listado de alumnas y un profesor titular.
        Cada alumna tiene un registro de asistencias.
        Cuando marca la asistencia a clases, se registra la fecha y hora. La asistencia puede ser en
            vivo o diferida (ver la grabación de la clase).
        Permitir generar listados de:
        a) Asistentes a una clase determinada.
        b) Alumnas que vieron una clase en vivo.
        c) Cantidad de asistencias de cada alumna.
        d) Alumnas que alcanzan el 75% de asistencia.
        e) Alumnas que no alcanzan el 75% de asistencia.
        * Si cumple años no cuenta la inasistencia 😊

ADA     -->     Cursos
Curso   -->     Alumnas
                Profesor
                Clases
Clase   -->     Fecha / Hora
Alumna  -->     Asistencias
Asistencia -->  Fecha/Hora (vivo/diferido)
                Clase
*/

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class ADA {

    public static void main(String[] args) {
        List<Curso> cursos;

        List<Alumna> alumnas = new ArrayList<>();
        Alumna alumna1=new Alumna("Ana", LocalDate.of(2000,6,3));
        alumna1.agregarAsistencia(new Asistencia(1,LocalDate.of(2020,11,17), LocalTime.of(19,00,00)));
        alumna1.agregarAsistencia(new Asistencia(2,LocalDate.of(2020,11,19), LocalTime.of(19,00,00)));
        alumna1.agregarAsistencia(new Asistencia(3,LocalDate.of(2020,11,21), LocalTime.of(9,00,00)));
        alumnas.add( alumna1);

        Alumna alumna2=new Alumna("Maria", LocalDate.of(2000,11,17));
        alumna2.agregarAsistencia(new Asistencia(1,LocalDate.of(2020,11,17), LocalTime.of(19,00,00)));
        alumna2.agregarAsistencia(new Asistencia(2,LocalDate.of(2020,11,20), LocalTime.of(8,30,00)));
        alumnas.add( alumna2);

        Alumna alumna3=new Alumna("Juana", LocalDate.of(2000,11,19));
        alumna3.agregarAsistencia(new Asistencia(1,LocalDate.of(2020,11,17), LocalTime.of(19,00,00)));
        alumnas.add( alumna3);

        Alumna alumna4=new Alumna("Teresa", LocalDate.of(2000,3,21));
        alumna4.agregarAsistencia(new Asistencia(3,LocalDate.of(2020,11,18), LocalTime.of(10,25,00)));
        alumnas.add( alumna4);

        Persona profesor1=new Persona("Pablo", LocalDate.of(2000,1,9));

        List<Clase> clases = new ArrayList<>();
        clases.add(new Clase(1,LocalDate.of(2020,11,17), LocalTime.of(19,00,00),"Bienvenida"));
        clases.add(new Clase(2,LocalDate.of(2020,11,19), LocalTime.of(19,00,00),"Tipod de Datos"));
        clases.add(new Clase(3,LocalDate.of(2020,11,21), LocalTime.of(9,00,00),"PSEInt"));

        Curso curso1 = new Curso("5ta BackEnd Online",alumnas,profesor1,clases);

        /* P:Presente   A:Ausente   D:Diferido  E:Exceptuada (Cumpleaños)
                    Clase 1:    Clase2:     Clase3:
        Alumna1:    P           P           P
        Alumna2:    P           D           A
        Alumna3:    P           E           A
        Alumna4:    A           A           D
        */

        System.out.println("*********************************************************************************************************");
        System.out.println("            LISTADO DE ASISTENCIA A CLASES");
        System.out.println("*********************************************************************************************************");
        for (Clase c:curso1.getClases()){
            curso1.listarAsistenciaUnaClase(c,false);
        }

        System.out.println("*********************************************************************************************************");
        System.out.println("            LISTADO DE ASISTENCIA EN VIVO A CLASES");
        System.out.println("*********************************************************************************************************");
        for (Clase c:curso1.getClases()){
            curso1.listarAsistenciaUnaClase(c,true);
        }

        System.out.println("*********************************************************************************************************");
        System.out.println("            LISTADO DE ASISTENCIA POR ALUMNA");
        System.out.println("*********************************************************************************************************");
        for (Alumna a:curso1.getAlumnas()){
            curso1.listarCantidadAsistenciaPorAlumna(a);
        }

        System.out.println("*********************************************************************************************************");
        System.out.println("            LISTADO DE ALUMNAS ALCANZAN 75% ASISTENCIA");
        System.out.println("*********************************************************************************************************");
        curso1.listarAlumnasCumplenAsistencia(true);

        System.out.println("*********************************************************************************************************");
        System.out.println("            LISTADO DE ALUMNAS NO ALCANZAN 75% ASISTENCIA");
        System.out.println("*********************************************************************************************************");
        curso1.listarAlumnasCumplenAsistencia(false);

    }
}
