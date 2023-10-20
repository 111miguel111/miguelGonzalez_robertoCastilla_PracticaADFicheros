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
		Alumno alumno = buscarAlumno();
		Curso curso=buscarCurso();
		if (alumno != null&&curso != null) {
			HashMap<String, Alumno> alumnos= GestorDatos.getListaAlum();
			HashMap<String, Curso> cursos= GestorDatos.getListaCursos();
		}
	}

	public void desmatricularAlumno() {
		// buscar alumno, buscar curso if not null pedir lista y desmatricular de la
		// lista y mandar a
		// escribir Alumnosssss
		Alumno alumno = buscarAlumno();
		Curso curso=buscarCurso();
		if (alumno != null&&curso != null) {
			HashMap<String, Alumno> alumnos= GestorDatos.getListaAlum();
			HashMap<String, Curso> cursos= GestorDatos.getListaCursos();
		}
	}

	public void crearAlumno() {
		// busco alumno if null mando alumno a datos
		Alumno alumno = null;
		System.out.println("Introduzca el nombre del alumno");
		String nombreAlum = Utiles.scanPalabras();
		if (nombreAlum != null) {
			System.out.println("Introduzca los apellidos del alumno");
			String apellidosAlum = Utiles.scanPalabras();
			if (apellidosAlum != null) {
				alumno=confirmarInexistenciaAlumno(nombreAlum,apellidosAlum );
				if(alumno==null) {
					System.out.println("Introduzca la direccion del alumno");
					String direccionAlum = Utiles.scanTodoTrim();
					if (direccionAlum != null) {
						System.out.println("Introduzca el telefono del alumno");
						String telefonoAlum = Utiles.scanNumero();
						if (telefonoAlum != null) {
							System.out.println("Introduzca la fecha de nacimiento del alumno");
							String fechaNacimientoAlum = Utiles.scanFecha();
							if (fechaNacimientoAlum != null) {
								alumno = new Alumno( nombreAlum,  apellidosAlum,  direccionAlum,  telefonoAlum, fechaNacimientoAlum);
								GestorDatos.escribirAlum(alumno);//falta confirmacion
								if(5==5) {
									System.out.println("El alumno ha sido creado exitosamente");
								}
								
							}
						}
					}
				}
			}
		}
	}

	public void borrarAlumno() {
		// buscar alumno if not null pedir lista pedir lista cursos , borrar de cursos y borrar de la lista y mandar a
		// escribir Alumnosssss y cursossss
		Alumno alumno = buscarAlumno();
		if (alumno != null) {
			HashMap<String, Alumno> alumnos= GestorDatos.getListaAlum();
		}

	}

	public void modificarAlumno() {
		// buscar alumno if not null pedir lista y modificar alumno de la lista y mandar
		// a escribir Alumnosssss
		Alumno alumno = buscarAlumno();
		if (alumno != null) {
			HashMap<String, Alumno> alumnos= GestorDatos.getListaAlum();
		}

	}
	public Alumno confirmarInexistenciaAlumno(String nombreAlum,String apellidosAlum ) {
		
		Alumno alumno = null;
				alumno = GestorDatos.buscarAlum(nombreAlum, apellidosAlum);
				if (alumno == null) {
					System.out.println("El alumno no existe siga introcuciendo datos");
				} else {
					System.out.println("Se ha encontrado un alumno con el mismo nombre y apellido");
				}
			
		
		return alumno;
	}
	
	public Alumno buscarAlumno() {
		// mandar nombre y apellido a datos , si me devuelve null me devuelvo null pa
		// saber que no existe si no me tendria que devolver un alumno que me devuelvo a
		// mi mismo
		// si no encuentra el alumno en 5 intentos te saca
		Alumno alumno = null;
		boolean check = true;
		int errorCont = 0;
		do {
			check = true;
			if (errorCont < 5) {
				System.out.println("Introduzca el nombre del alumno");
				String nombreAlum = Utiles.scanPalabras();
				if (nombreAlum != null) {
					System.out.println("Introduzca los apellidos del alumno");
					String apellidosAlum = Utiles.scanPalabras();
					if (apellidosAlum != null) {
						alumno = GestorDatos.buscarAlum(nombreAlum, apellidosAlum);
						if (alumno == null) {
							System.out.println("No se ha encontrado el alumno vuelva a introducir los datos");
							check = false;
						} else {
							System.out.println("Se ha encontrado el alumno");
						}
					}
				}
				errorCont++;
			} else {
				System.out.println("Excedido numero de intentos (" + errorCont + ")");
			}
		} while (!check);

		return alumno;
	}

	public Curso buscarCurso() {
		// mandar nombre y apellido a datos , si me devuelve null me devuelvo null pa
		// saber que no existe si no me tendria que devolver un alumno que me devuelvo a
		// mi mismo
		// si no encuentra el curso en 5 intentos te saca
		Curso curso = null;
		
		boolean check = true;
		int errorCont = 0;
		do {
			check = true;
			if (errorCont < 5) {
				System.out.println("Introduzca el nombre del curso");
				String nombreCurso = Utiles.scanPalabras();
					if (nombreCurso != null) {
						curso = GestorDatos.buscarCurso(nombreCurso);
						if (curso == null) {
							System.out.println("No se ha encontrado el curso vuelva a introducir los datos");
							check = false;
						} else {
							System.out.println("Se ha encontrado el curso");
						}
					}
				errorCont++;
			} else {
				System.out.println("Excedido numero de intentos (" + errorCont + ")");
			}
		} while (!check);
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
		HashMap<String, Alumno> alumnos= GestorDatos.getListaAlum();
		for (HashMap.Entry<String, Alumno> entry : this.listaAlumnos.entrySet()) {
			System.out.println(entry.getValue().toString());
		}
	}

}
