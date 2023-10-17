package gestores;

import java.util.HashMap;

import clases.*;

public class gestorAlumno {
	private HashMap<String,Alumno> listaAlumnos;
	private HashMap<String,Curso> listaCursos;
	
	public gestorAlumno(HashMap<String, Alumno> listaAlumnos, HashMap<String, Curso> listaCursos) {
		this.listaAlumnos = listaAlumnos;
		this.listaCursos = listaCursos;
	}

	
	
	public void matricularAlumno() {
		System.out.println("Introduzca el nombre del alumno");
		String nombreAlum="ESCANER";
		System.out.println("Introduzca los apellidos del alumno");
		String apellidosAlum="ESCANER";
		if( listaAlumnos.containsKey(nombreAlum+"_"+apellidosAlum)) {
			System.out.println("El alumno= "+nombreAlum+" ha sido encontrado");
			System.out.println("Introduzca el nombre del curso");
			String nombreCurso="ESCANER";
			if(listaCursos.containsKey(nombreCurso)) {
				System.out.println("El curso= "+nombreCurso+" ha sido encontrado");
				if(listaCursos.get(nombreCurso).getAlumnos().containsKey(nombreAlum+"_"+apellidosAlum)) {
					System.out.println("Lo sentimos pero el alumno= "+nombreAlum+" ya esta mtriculado en el curso= "+nombreCurso);
				}else {
					listaCursos.get(nombreCurso).AlumnoNuevo(listaAlumnos.get(nombreAlum+"_"+apellidosAlum));
					//que se hga tambien en la lista de alumnos
					System.out.println("El alumno= "+nombreAlum+" ha sido matriculado en el curso= "+nombreCurso);
				}
			}else {
				System.out.println("No se ha podido encontrar el curso");
			}
		}else{
			System.out.println("No se ha podido encontrar el alumno");
		}
	}
	public void desmatricularAlumno() {
		System.out.println("Introduzca el nombre del alumno");
		String nombreAlum="ESCANER";
		System.out.println("Introduzca los apellidos del alumno");
		String apellidosAlum="ESCANER";
		if( listaAlumnos.containsKey(nombreAlum+"_"+apellidosAlum)) {
			System.out.println("El alumno= "+nombreAlum+" ha sido encontrado");
			System.out.println("Introduzca el nombre del curso");
			String nombreCurso="ESCANER";
			if(listaCursos.containsKey(nombreCurso)) {
				System.out.println("El curso= "+nombreCurso+" ha sido encontrado");
				if(listaCursos.get(nombreCurso).getAlumnos().containsKey(nombreAlum+"_"+apellidosAlum)) {
					listaCursos.get(nombreCurso).AlumnoPop(listaAlumnos.get(nombreAlum+"_"+apellidosAlum));
					//que se haga tambien en la lista de alumnos
					System.out.println("El alumno= "+nombreAlum+" ha sido desmatriculado en el curso= "+nombreCurso);
				}else {
					
					System.out.println("El alumno= "+nombreAlum+" no esta matriculado en el curso= "+nombreCurso);
				}
			}else {
				System.out.println("No se ha podido encontrar el curso");
			}
		}else{
			System.out.println("No se ha podido encontrar el alumno");
		}
	}
	public void crearAlumno() {
		System.out.println("Introduzca el nombre del alumno");
		String nombreAlum="ESCANER";
		System.out.println("Introduzca los apellidos del alumno");
		String apellidosAlum="ESCANER";
		if(listaAlumnos.containsKey(nombreAlum+"_"+apellidosAlum)) {
			System.out.println("Ya existe un alumno con ese nombre y apellido\nTiene que proporcionar un nombre o apellido diferente");
		}else{
			System.out.println("Introduzca la direccion del alumno");
			String direccionAlum="ESCANER";
			System.out.println("Introduzca el telefono del alumno");
			String telefonoAlum="ESCANER";
			System.out.println("Introduzca la fecha de nacimiento del alumno");
			String fechaNacimientoAlum="ESCANER";
			this.listaAlumnos.put(nombreAlum+"_"+apellidosAlum, new Alumno(nombreAlum,apellidosAlum,direccionAlum,telefonoAlum,fechaNacimientoAlum));
			System.out.println("El alumno= "+nombreAlum+" ha sido creado");
		}
	}
	public void borrarAlumno() {
		
	}
	public void modificarAlumno() {
		
	}
	public Alumno buscarAlumno() {
		return null;
	}
	public void mostrarAlumno() {
		Alumno alumno=buscarAlumno();
		System.out.println(listaAlumnos.get(alumno.getNombre()+"_"+alumno.getApellidos()).toString());
	}
	public void mostrarAlumnos() {
		for(HashMap.Entry<String, Alumno> entry : this.listaAlumnos.entrySet()) {
			System.out.println(entry.getValue().toString());
		}
	}
	
}
