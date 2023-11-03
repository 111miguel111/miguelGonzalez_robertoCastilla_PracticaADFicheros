package gestores;

import java.util.HashMap;
import clases.*;
import principal.*;

public class GestorCursos {

	public static void vincularProfesor() {
		HashMap<String, Profesor> profesores = GestorDatos.getListaProf();
		if(!profesores.isEmpty()) {
			HashMap<String, Curso> cursos = GestorDatos.getListaCursos();
			if(!cursos.isEmpty()) {
				
			
		Profesor profesor = buscarProfesor();
		if (profesor != null) {
			System.out.println(profesor.toString());
			Curso curso = buscarCurso();
			if (curso != null) {
				System.out.println(curso.toString());
				if (profesor != null && curso != null) {
					profesores = GestorDatos.getListaProf();
					cursos = GestorDatos.getListaCursos();
					HashMap<String, Curso> cursosProfesor = profesor.getCursos();
					if (!(cursosProfesor.containsValue(curso) && curso.getProfesor() == profesor)) {
						cursos.get(curso.getNombre()).setProfesor(profesor);
						cursosProfesor.put(curso.getNombre(), curso);
						profesores.get(profesor.getDni()).setCursos(cursosProfesor);
						GestorDatos.escribirTodosProf(profesores);
						GestorDatos.escribirTodosCursos(cursos);
					} else {
						System.out.println("Lo sentimos pero: " + profesor.getNombre() + " ya esta vinculado en: "
								+ curso.getNombre());
					}
				}
			}
		}
			}else {
				System.out.println("No hay cursos, porfavor crea alguno");
			}
		}else {
			System.out.println("No hay profesores, porfavor crea alguno");
		}
	}

	public static void desvincularProfesor() {
		HashMap<String, Profesor> profesores = GestorDatos.getListaProf();
		if(!profesores.isEmpty()) {
			HashMap<String, Curso> cursos = GestorDatos.getListaCursos();
			if(!cursos.isEmpty()) {
		Profesor profesor = buscarProfesor();
		if (profesor != null) {
			System.out.println(profesor.toString());
			Curso curso = buscarCurso();
			if (curso != null) {
				System.out.println(curso.toString());
				if (profesor != null && curso != null) {
					profesores = GestorDatos.getListaProf();
					cursos = GestorDatos.getListaCursos();
					HashMap<String, Curso> cursosProfesor = profesor.getCursos();
					if (cursosProfesor.containsValue(curso) && curso.getProfesor().equals(profesor)) {
						cursos.get(curso.getNombre()).setProfesor(null);
						cursosProfesor.remove(curso.getNombre(), curso);
						profesores.get(profesor.getDni()).setCursos(cursosProfesor);
						GestorDatos.escribirTodosProf(profesores);
						GestorDatos.escribirTodosCursos(cursos);
					} else {
						System.out.println("Lo sentimos pero: " + profesor.getNombre() + " no esta vinculado en: "
								+ curso.getNombre());
					}
				}
			}
		}
			}else {
				System.out.println("No hay cursos, por lo que no hay nada que desvincular");
			}
		}else {
			System.out.println("No hay profesores, por lo que no hay nadie vinculado");
		}
	}

	public static void matricularAlumno() {
		// buscar alumno , buscar curso , if ambos not null pido lista alumnos ,lista
		// cursos ,elimino el alumno de la lista de alumnos de los cursos, mopdifico
		// ambas listas y las mando a sus metodos de datos pa
		// serializar
		HashMap<String, Alumno> alumnos = GestorDatos.getListaAlum();
		if(!alumnos.isEmpty()) {
			HashMap<String, Curso> cursos = GestorDatos.getListaCursos();
			if(!cursos.isEmpty()) {
				
			
		Alumno alumno = buscarAlumno();
		if (alumno != null) {
			System.out.println(alumno.toString());
			Curso curso = buscarCurso();
			if (curso != null) {

				System.out.println(curso.toString());
				if (alumno != null && curso != null) {
					alumnos = GestorDatos.getListaAlum();
					cursos = GestorDatos.getListaCursos();
					HashMap<String, Curso> cursosAlum = alumnos.get(alumno.getNombre() + "_" + alumno.getApellidos())
							.getCursos();
					HashMap<String, Alumno> alumnosCurso = cursos.get(curso.getNombre()).getAlumnos();
					if (!(cursosAlum.containsValue(curso) && alumnosCurso.containsValue(alumno))) {
						cursosAlum.put(curso.getNombre(), curso);
						alumnos.get(alumno.getNombre() + "_" + alumno.getApellidos()).setCursos(cursosAlum);
						GestorDatos.escribirTodosAlum(alumnos);

						alumnosCurso.put(alumno.getNombre() + "_" + alumno.getApellidos(), alumno);
						cursos.get(curso.getNombre()).setAlumnos(alumnosCurso);
						GestorDatos.escribirTodosCursos(cursos);
					} else {
						System.out.println("Lo sentimos pero: " + alumno.getNombre() + " ya esta matriculado en: "
								+ curso.getNombre());
					}
				}
			}
		}
			}else {
				System.out.println("No hay cursos, crea algun curso antes");
			}
		}else {
			System.out.println("No hay alumnos, crea algun alumno antes");
		}
	}

	public static void desmatricularAlumno() {
		// buscar alumno, buscar curso if not null pedir lista y desmatricular de las
		// listas y mandar a
		// escribir Alumnosssss y cursosssss
		HashMap<String, Alumno> alumnos = GestorDatos.getListaAlum();
		if(!alumnos.isEmpty()) {
			HashMap<String, Curso> cursos = GestorDatos.getListaCursos();
			if(!cursos.isEmpty()) {
				
			
		Alumno alumno = buscarAlumno();
		if (alumno != null) {
			System.out.println(alumno.toString());
			Curso curso = buscarCurso();
			if (curso != null) {

				System.out.println(curso.toString());
				if (alumno != null && curso != null) {
					alumnos = GestorDatos.getListaAlum();
					cursos = GestorDatos.getListaCursos();
					HashMap<String, Curso> cursosAlum = alumnos.get(alumno.getNombre() + "_" + alumno.getApellidos())
							.getCursos();
					HashMap<String, Alumno> alumnosCurso = cursos.get(curso.getNombre()).getAlumnos();
					if (cursosAlum.containsValue(curso) && alumnosCurso.containsValue(alumno)) {
						cursosAlum.remove(curso.getNombre(), curso);

						alumnos.get(alumno.getNombre() + "_" + alumno.getApellidos()).setCursos(cursosAlum);
						GestorDatos.escribirTodosAlum(alumnos);

						alumnosCurso.remove(alumno.getNombre() + "_" + alumno.getApellidos(), alumno);
						cursos.get(curso.getNombre()).setAlumnos(alumnosCurso);
						GestorDatos.escribirTodosCursos(cursos);
					} else {
						System.out.println("Lo sentimos pero: " + alumno.getNombre() + " no esta matriculado en: "
								+ curso.getNombre());
					}
				}
			}
		}
			}else {
				System.out.println("No hay cursos, por lo que nadie esta matriculado");
			}
		}else {
			System.out.println("No hay alumnos, por lo que no hay nada que desmatricular");
		}
	}

	public static void crearCurso() {
		Curso curso = null;
		System.out.println("Introduzca el nombre del curso");
		String nombreCurso = Utiles.scanPalabras();
		if (nombreCurso != null) {
			curso = confirmarInexistenciaCurso(nombreCurso);
			if (curso == null) {
				System.out.println("Introduzca la descripcion del curso");
				String descripcionCurso = Utiles.scanTodoTrim();
				if (descripcionCurso != null) {
					curso = new Curso(nombreCurso, descripcionCurso);
					GestorDatos.escribirCurso(curso);// falta confirmacion

					System.out.println("El curso ha sido creado exitosamente");

				}
			}
		}
	}

	public static void borrarCurso() {
		// busco curso if not null pido las tres listas , recorro alumnos y pido de cada
		// alumno la lista de cursos
		// si tiene el curso, lo quito ,se recorren ambos cosos recorro profesores y si
		// alguno tiene el curso, lo elimino
		// despues de eso elimino el curso
		Curso curso = buscarCurso();
		if (curso != null) {
			System.out.println(curso.toString());
			HashMap<String, Curso> cursos = GestorDatos.getListaCursos();

			HashMap<String, Alumno> alumnos = GestorDatos.getListaAlum();
			for (HashMap.Entry<String, Alumno> entry : alumnos.entrySet()) {
				HashMap<String, Curso> cursosAlum = entry.getValue().getCursos();
				Curso cursoAux = cursosAlum.get(curso.getNombre());
				if (cursoAux != null) {
					cursosAlum.remove(curso.getNombre(), curso);
				}
					alumnos.get(entry.getKey()).setCursos(cursosAlum);
				
			}

			HashMap<String, Profesor> profesores = GestorDatos.getListaProf();
			for (HashMap.Entry<String, Profesor> entry : profesores.entrySet()) {
				HashMap<String, Curso> cursosProfesor = entry.getValue().getCursos();
				Curso cursoAux = cursosProfesor.get(curso.getNombre());
				if (cursoAux != null) {
					cursosProfesor.remove(curso.getNombre(), curso);
				}
				profesores.get(entry.getKey()).setCursos(cursosProfesor);
			}
			if (Utiles.confirmarAccion() == null) {
				cursos.remove(curso.getNombre());
				GestorDatos.escribirTodosProf(profesores);
				GestorDatos.escribirTodosAlum(alumnos);
				GestorDatos.escribirTodosCursos(cursos);
			}
		}
	}

	public static void modificarCurso() {
		String nombreCurso = null;
		String descripcionCurso = null;
		Curso curso = buscarCurso();
		if (curso != null) {
		Curso curso2 = null;
		Curso curso3 = new Curso(curso.getNombre(),curso.getDescripcion());
		
			HashMap<String, Curso> cursos = GestorDatos.getListaCursos();
			for (HashMap.Entry<String, Curso> entry : cursos.entrySet()) {
				if (entry.getValue().equals(curso)) {
					boolean check = true;
					System.out.println("Se ha encontrado el profesor: " + curso.toString());
					do {
						System.out.println("Que desea modificar?\nNombre 1\nDescripcion 2\nTodo 3\n Salir 0");
						String opcion = Utiles.scanNumero();
						switch (opcion) {
						case "1":
							System.out.println("Introduzca el DNI del profesor");
							nombreCurso = Utiles.scanPalabras();
							if (nombreCurso != null) {
								curso2 = confirmarInexistenciaCurso(nombreCurso);
								if (curso2 == null) {
									curso3.setNombre(nombreCurso);
								} else {
									System.out.println(
											"El nombre del curso coincide con el de otro curso, porfavor cambie el nombre");
								}
							}
							break;
						case "2":
							System.out.println("Introduzca el nombre del curso");
							descripcionCurso = Utiles.scanTodoTrim();
							if (descripcionCurso != null) {
								curso3.setDescripcion(descripcionCurso);
							}
							break;
						case "3":
							System.out.println("Introduzca el nombre del curso");
							nombreCurso = Utiles.scanPalabras();
							if (nombreCurso != null) {
								curso2 = confirmarInexistenciaCurso(nombreCurso);
								if (curso2 == null) {
									System.out.println("Introduzca la descripcion del curso");
									descripcionCurso = Utiles.scanTodoTrim();
									if (descripcionCurso != null) {
										curso3.setNombre(nombreCurso);
										curso3.setDescripcion(descripcionCurso);
									}
								} else {
									System.out.println(
											"El nombre del curso coincide con el de otro curso, porfavor cambie el nombre");
								}
							}
							break;
						case "0":
							check = false;
							break;
						default:
							System.out.println("Valor no valido.");
						}
					} while (check);
					if (!(curso.getNombre().equals(curso3.getNombre()))) {
						cursos.get(curso.getNombre()).setNombre(curso3.getNombre());
						cursos.get(curso.getNombre()).setDescripcion(curso3.getDescripcion());
						if (Utiles.confirmarAccion() == null) {
							GestorDatos.escribirTodosCursos(cursos);
						}
					} else {
						System.out.println(
								"El nombre del curso coincide con el de otro curso, porfavor cambie el nombre");
					}
				}
			}
		}
	}

	public static Curso confirmarInexistenciaCurso(String nombreCurso) {
		// busco alumno y si no existe devuelve null
		Curso curso = GestorDatos.buscarCurso(nombreCurso);
		if (curso == null) {
			System.out.println("El curso no existe siga introcuciendo datos");
		} else {
			System.out.println("Se ha encontrado un curso con el mismo nombre");
		}

		return curso;
	}

	public static Curso buscarCurso() {
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

	public static Profesor confirmarInexistenciaProfesor(String dniProfesor) {
		Profesor profesor = GestorDatos.buscarProf(dniProfesor);
		if (profesor == null) {
			System.out.println("El profesor no existe siga introcuciendo datos");
		} else {
			System.out.println("Se ha encontrado un profesor con el mismo dni");
		}
		return profesor;
	}

	public static Profesor buscarProfesor() {
		Profesor profesor = null;
		boolean check = true;
		int errorCont = 0;
		do {
			check = true;
			if (errorCont < 5) {
				System.out.println("Introduzca el DNI del profesor");
				String dniProfesro = Utiles.scanDni();
				if (dniProfesro != null) {
					profesor = GestorDatos.buscarProf(dniProfesro);
					if (profesor == null) {
						System.out.println("No se ha encontrado el profesor vuelva a introducir los datos");
						check = false;
					} else {
						System.out.println("Se ha encontrado el profesor");
					}
				}
				errorCont++;
			} else {
				System.out.println("Excedido numero de intentos (" + errorCont + ")");
			}
		} while (!check);
		return profesor;
	}

	public static Alumno confirmarInexistenciaAlumno(String nombreAlum, String apellidosAlum) {
		// busco alumno y si no existe devuelve null
		Alumno alumno = GestorDatos.buscarAlum(nombreAlum, apellidosAlum);
		if (alumno == null) {
			System.out.println("El alumno no existe siga introcuciendo datos");
		} else {
			System.out.println("Se ha encontrado un alumno con el mismo nombre y apellido");
		}

		return alumno;
	}

	public static Alumno buscarAlumno() {
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

	public static void mostrarCurso() {
		Curso curso = buscarCurso();
		if (curso != null) {
			System.out.println(curso.toString());
		}
	}

	public static void mostrarCursos() {
		HashMap<String, Curso> cursos = GestorDatos.getListaCursos();
		for (HashMap.Entry<String, Curso> entry : cursos.entrySet()) {
			System.out.println(entry.getValue().toString());
		}
	}

}
