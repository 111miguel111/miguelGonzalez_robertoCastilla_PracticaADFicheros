package gestores;

import java.util.HashMap;

import clases.*;

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
		System.out.println("Introduzca el nombre del alumno");
		String nombreAlum = "ESCANER";
		System.out.println("Introduzca los apellidos del alumno");
		String apellidosAlum = "ESCANER";
		if (listaAlumnos.containsKey(nombreAlum + "_" + apellidosAlum)) {
			System.out.println("El alumno= " + nombreAlum + " ha sido encontrado");
			System.out.println("Introduzca el nombre del curso");
			String nombreCurso = "ESCANER";
			if (listaCursos.containsKey(nombreCurso)) {
				System.out.println("El curso= " + nombreCurso + " ha sido encontrado");
				if (listaCursos.get(nombreCurso).getAlumnos().containsKey(nombreAlum + "_" + apellidosAlum)) {
					System.out.println("Lo sentimos pero el alumno= " + nombreAlum + " ya esta mtriculado en el curso= "
							+ nombreCurso);
				} else {
					listaCursos.get(nombreCurso).AlumnoNuevo(listaAlumnos.get(nombreAlum + "_" + apellidosAlum));
					// que se hga tambien en la lista de alumnos
					System.out.println("El alumno= " + nombreAlum + " ha sido matriculado en el curso= " + nombreCurso);
				}
			} else {
				System.out.println("No se ha podido encontrar el curso");
			}
		} else {
			System.out.println("No se ha podido encontrar el alumno");
		}
	}

	public void desmatricularAlumno() {
		// buscar alumno if not null pedir lista y desmatricular de la lista y mandar a
		// escribir Alumnosssss
		System.out.println("Introduzca el nombre del alumno");
		String nombreAlum = "ESCANER";
		System.out.println("Introduzca los apellidos del alumno");
		String apellidosAlum = "ESCANER";
		if (listaAlumnos.containsKey(nombreAlum + "_" + apellidosAlum)) {
			System.out.println("El alumno= " + nombreAlum + " ha sido encontrado");
			System.out.println("Introduzca el nombre del curso");
			String nombreCurso = "ESCANER";
			if (listaCursos.containsKey(nombreCurso)) {
				System.out.println("El curso= " + nombreCurso + " ha sido encontrado");
				if (listaCursos.get(nombreCurso).getAlumnos().containsKey(nombreAlum + "_" + apellidosAlum)) {
					listaCursos.get(nombreCurso).AlumnoPop(listaAlumnos.get(nombreAlum + "_" + apellidosAlum));
					// que se haga tambien en la lista de alumnos
					System.out.println(
							"El alumno= " + nombreAlum + " ha sido desmatriculado en el curso= " + nombreCurso);
				} else {

					System.out.println("El alumno= " + nombreAlum + " no esta matriculado en el curso= " + nombreCurso);
				}
			} else {
				System.out.println("No se ha podido encontrar el curso");
			}
		} else {
			System.out.println("No se ha podido encontrar el alumno");
		}
	}

	public void crearAlumno() {
		// busco alumno if null mando alumno a datos
		System.out.println("Introduzca el nombre del alumno");
		String nombreAlum = "ESCANER";
		System.out.println("Introduzca los apellidos del alumno");
		String apellidosAlum = "ESCANER";
		if (listaAlumnos.containsKey(nombreAlum + "_" + apellidosAlum)) {
			System.out.println(
					"Ya existe un alumno con ese nombre y apellido\nTiene que proporcionar un nombre o apellido diferente");
		} else {
			System.out.println("Introduzca la direccion del alumno");
			String direccionAlum = "ESCANER";
			System.out.println("Introduzca el telefono del alumno");
			String telefonoAlum = "ESCANER";
			System.out.println("Introduzca la fecha de nacimiento del alumno");
			String fechaNacimientoAlum = "ESCANER";
			this.listaAlumnos.put(nombreAlum + "_" + apellidosAlum,
					new Alumno(nombreAlum, apellidosAlum, direccionAlum, telefonoAlum, fechaNacimientoAlum));
			System.out.println("El alumno= " + nombreAlum + " ha sido creado");
		}
	}

	public void borrarAlumno() {
		// buscar alumno if not null pedir lista y borrar de la lista y mandar a
		// escribir Alumnosssss
		Alumno alumno = buscarAlumno();
		if (alumno == null) {
			listaAlumnos.remove(alumno.getNombre() + "_" + alumno.getApellidos());
			System.out.println("Se ha eliminado el alumno con nombre: " + alumno.getNombre() + " y apellido: "
					+ alumno.getApellidos());
		} else {
			System.out.println("No se ha encontrado ningun alumno con el nombre y apellidos proporcionados");
		}
	}

	public void modificarAlumno() {
		// buscar alumno if not null pedir lista y modificar alumno de la lista y mandar
		// a escribir Alumnosssss
		Alumno alumno = buscarAlumno();
		if (alumno == null) {
			System.out.println(listaAlumnos.get(alumno.getNombre() + "_" + alumno.getApellidos()).toString());
			System.out.println("Modificar \nUn atributo 1 \nTodos los atributos 2 ");
			String opcion = "ESCANER";
			switch (opcion) {
			case "1":

				break;
			case "2":

				break;
			default:
				System.out.println("Opcion no valida");
			}
			System.out.println("Se ha modificado el alumno con nombre: " + alumno.getNombre() + " y apellido: "
					+ alumno.getApellidos());
		} else {
			System.out.println("No se ha encontrado ningun alumno con el nombre y apellidos proporcionados");
		}
	}

	public Alumno buscarAlumno() {
		// mandar nombre y apellido a datos , si me devuelve null me devuelvo null pa
		// saber que no existe si no me tendria que devolver un alumno que me devuelvo a
		// mi mismo
		System.out.println("Introduzca el nombre del alumno");
		String nombreAlum = "ESCANER";
		System.out.println("Introduzca los apellidos del alumno");
		String apellidosAlum = "ESCANER";
		if (listaAlumnos.containsKey(nombreAlum + "_" + apellidosAlum)) {
			System.out.println(
					"Se ha encontrado el alumno: " + listaAlumnos.get(nombreAlum + "_" + apellidosAlum).toString());// linea
																													// temporal
			return listaAlumnos.get(nombreAlum + "_" + apellidosAlum);
		} else {
			System.out.println("No se ha encontrado ningun alumno con el nombre: " + nombreAlum + " y el apellido: "
					+ apellidosAlum);// linea temporal
		}

		return null;
	}

	public void mostrarAlumno() {
		// buscar alumno y si no es null printear
		Alumno alumno = buscarAlumno();
		if (alumno == null) {
			System.out.println(listaAlumnos.get(alumno.getNombre() + "_" + alumno.getApellidos()).toString());
		} else {
			System.out.println("No se ha encontrado ningun alumno con el nombre y apellidos proporcionados");
		}

	}

	public void mostrarAlumnos() {
		// llamar a mostrartodos en datos
		for (HashMap.Entry<String, Alumno> entry : this.listaAlumnos.entrySet()) {
			System.out.println(entry.getValue().toString());
		}
	}

}
