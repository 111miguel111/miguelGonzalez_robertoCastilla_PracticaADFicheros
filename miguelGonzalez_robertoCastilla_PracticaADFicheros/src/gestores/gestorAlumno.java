package gestores;

import java.util.HashMap;

import clases.*;

public class gestorAlumno {
	private HashMap<String,Alumno> listaAlumnos;
	private HashMap<String,Curso> listaCursos;
	
	public gestorAlumno(){
		listaAlumnos = new HashMap<String,Alumno>();
	}
	
	public void matricularAlumno() {
		System.out.println("Introduzca el nombre del alumno");
		String nombreAlum;
		System.out.println("Introduzca los apellidos del alumno");
		String apellidosAlum;
		//Alumno alumno = listaAlumnos.get(nombreAlum+apellidosAlum);
		System.out.println("Introduzca el nombre del curso");
		String nombreCurso;
		//Curso curso = listaCursos.get(nombreCurso);
	}
}
