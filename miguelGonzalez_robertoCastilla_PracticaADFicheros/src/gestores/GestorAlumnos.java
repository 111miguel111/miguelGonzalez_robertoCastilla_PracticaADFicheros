package gestores;

import java.util.HashMap;
import clases.*;
import principal.*;
import gestores.*;

public class GestorAlumnos {
	
	
	// esto tiene que desaparecer
	private HashMap<String, Alumno> listaAlumnos;
	private HashMap<String, Curso> listaCursos;

	public GestorAlumnos(HashMap<String, Alumno> listaAlumnos, HashMap<String, Curso> listaCursos) {
		this.listaAlumnos = listaAlumnos;
		this.listaCursos = listaCursos;
	}
	// esto tiene que desaparecer

	public void matricularAlumno() {
		// buscar alumno , buscar curso , if ambos not null pido lista alumnos ,lista
		// cursos , mopdifico ambas listas y las mando a sus metodos de datos pa
		// serializar
		Alumno alumno =buscarAlumno();
		if (alumno!=null) {
		
		}
	}

	public void desmatricularAlumno() {
		// buscar alumno, buscar curso if not null pedir lista y desmatricular de la lista y mandar a
		// escribir Alumnosssss
		
	}

	public void crearAlumno() {
		// busco alumno if null mando alumno a datos
		
	}

	public void borrarAlumno() {
		// buscar alumno if not null pedir lista y borrar de la lista y mandar a
		// escribir Alumnosssss
		Alumno alumno = buscarAlumno();
		
	}

	public void modificarAlumno() {
		// buscar alumno if not null pedir lista y modificar alumno de la lista y mandar
		// a escribir Alumnosssss
		Alumno alumno = buscarAlumno();
		
	}

	public Alumno buscarAlumno() {
		// mandar nombre y apellido a datos , si me devuelve null me devuelvo null pa
		// saber que no existe si no me tendria que devolver un alumno que me devuelvo a
		// mi mismo
		//si no encuentra el alumno en 5 intentos te saca
		
		Alumno alumno =null;
		System.out.println("Introduzca el nombre del alumno");
		String nombreAlum = Utiles.scanPalabras();
		if(nombreAlum!=null) {
			System.out.println("Introduzca los apellidos del alumno");
			String apellidosAlum = Utiles.scanPalabras();
			if(apellidosAlum!=null) {
				alumno = GestorDatos.buscarAlum(nombreAlum, apellidosAlum);
				if(alumno==null) {
					System.out.println("No se ha encontrado el alumno");
				}else {
					System.out.println("Se ha encontrado el alumno");
				}
			}
		}
		
		

		return alumno;
	}
	public Curso buscarCurso() {
		// mandar nombre y apellido a datos , si me devuelve null me devuelvo null pa
		// saber que no existe si no me tendria que devolver un alumno que me devuelvo a
		// mi mismo
		//si no encuentra el curso en 5 intentos te saca
		Curso curso =null;
		System.out.println("Introduzca el nombre del curso");
		String nombreCurso = Utiles.scanPalabras();
		if(nombreCurso!=null) {
			curso = GestorDatos.buscarCurso(nombreCurso);
			if(curso==null) {
				System.out.println("No se ha encontrado el curso");
			}else {
				System.out.println("Se ha encontrado el curso");
			}
		}
			return curso;
		
	}

	public void mostrarAlumno() {
		// buscar alumno y si no es null printear
		Alumno alumno = buscarAlumno();
		if (alumno != null) {
			System.out.println(alumno.toString());
		}

	}

	public void mostrarAlumnos() {
		// llamar a mostrartodos en datos
		
		for (HashMap.Entry<String, Alumno> entry : this.listaAlumnos.entrySet()) {
			System.out.println(entry.getValue().toString());
		}
	}

}
