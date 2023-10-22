package gestores;

import java.util.HashMap;
import clases.*;
import principal.*;
import gestores.*;

public class GestorAlumnos {

	public static void matricularAlumno() {
		// buscar alumno , buscar curso , if ambos not null pido lista alumnos ,lista
		// cursos ,elimino el alumno de la lista de alumnos de los cursos, mopdifico
		// ambas listas y las mando a sus metodos de datos pa
		// serializar
		Alumno alumno = buscarAlumno();
		if (alumno != null) {
			System.out.println(alumno.toString());
			Curso curso = buscarCurso();
			if (curso != null) {

				System.out.println(curso.toString());
				if (alumno != null && curso != null) {
					HashMap<String, Alumno> alumnos = GestorDatos.getListaAlum();
					HashMap<String, Curso> cursos = GestorDatos.getListaCursos();
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
	}

	public static void desmatricularAlumno() {
		// buscar alumno, buscar curso if not null pedir lista y desmatricular de las
		// listas y mandar a
		// escribir Alumnosssss y cursosssss
		Alumno alumno = buscarAlumno();
		if (alumno != null) {
			System.out.println(alumno.toString());
			Curso curso = buscarCurso();
			if (curso != null) {

				System.out.println(curso.toString());
				if (alumno != null && curso != null) {
					HashMap<String, Alumno> alumnos = GestorDatos.getListaAlum();
					HashMap<String, Curso> cursos = GestorDatos.getListaCursos();
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
	}

	public static void crearAlumno() {
		// busco alumno if null pido el resto de datos y mando alumno a datos para que
		// se añada
		Alumno alumno = null;
		System.out.println("Introduzca el nombre del alumno");
		String nombreAlum = Utiles.scanPalabras();
		if (nombreAlum != null) {
			System.out.println("Introduzca los apellidos del alumno");
			String apellidosAlum = Utiles.scanPalabras();
			if (apellidosAlum != null) {
				alumno = confirmarInexistenciaAlumno(nombreAlum, apellidosAlum);
				if (alumno == null) {
					System.out.println("Introduzca la direccion del alumno");
					String direccionAlum = Utiles.scanTodoTrim();
					if (direccionAlum != null) {
						System.out.println("Introduzca el telefono del alumno");
						String telefonoAlum = Utiles.scanNumero();
						if (telefonoAlum != null) {
							System.out.println("Introduzca la fecha de nacimiento del alumno");
							String fechaNacimientoAlum = Utiles.scanFecha();
							if (fechaNacimientoAlum != null) {
								alumno = new Alumno(nombreAlum, apellidosAlum, direccionAlum, telefonoAlum,
										fechaNacimientoAlum);
								GestorDatos.escribirAlum(alumno);// falta confirmacion
								System.out.println("El alumno ha sido creado exitosamente");

							}
						}
					}
				}
			}
		}
	}

	public static void borrarAlumno() {
		// buscar alumno if not null pedir lista pedir lista cursos , borrar de cursos y
		// borrar de la lista y mandar a
		// escribir Alumnosssss y cursossss
		Alumno alumno = buscarAlumno();
		if (alumno != null) {
			System.out.println(alumno.toString());
			HashMap<String, Alumno> alumnos = GestorDatos.getListaAlum();
			HashMap<String, Curso> cursos = GestorDatos.getListaCursos();
			for (HashMap.Entry<String, Curso> entry : cursos.entrySet()) {
				HashMap<String, Alumno> alumnosCurso = cursos.get(entry.getKey()).getAlumnos();
				Alumno alumnoAux = alumnosCurso.get(alumno.getNombre() + "_" + alumno.getApellidos());
				if (alumnoAux != null) {
					alumnosCurso.remove(alumno.getNombre() + "_" + alumno.getApellidos(), alumno);
				}
				cursos.get(entry.getKey()).setAlumnos(alumnosCurso);
			}
			if (Utiles.confirmarAccion() == null) {

				alumnos.remove(alumno.getNombre() + "_" + alumno.getApellidos(), alumno);
				GestorDatos.escribirTodosAlum(alumnos);
				GestorDatos.escribirTodosCursos(cursos);
			}
		}

	}

	public static void modificarAlumno() {
		// buscar alumno if not null pedir lista y modificar alumno de la lista y mandar
		// a escribir Alumnosssss
		String nombreAlum = null;
		String apellidosAlum = null;
		String direccionAlum = null;
		String telefonoAlum = null;
		String fechaNacimientoAlum = null;
		Alumno alumno = buscarAlumno();
		Alumno alumno2 = null;
		Alumno alumno3 = alumno;
		if (alumno != null) {
			HashMap<String, Alumno> alumnos = GestorDatos.getListaAlum();
			for (HashMap.Entry<String, Alumno> entry : alumnos.entrySet()) {
				if (entry.equals(alumno)) {
					boolean check = true;
					System.out.println("Se ha encontrado el alumno: " + alumno.toString());
					do {
						System.out.println(
								"Que desea modificar?\nNombre 1\nApellidos 2\nDireccion 3\nTelefono 4\nFecha de nacimiento 5\n Todo 6\n Salir 0");
						String opcion = Utiles.scanNumero();
						switch (opcion) {
						case "1":
							System.out.println("Introduzca el nombre del alumno");
							nombreAlum = Utiles.scanPalabras();
							if (nombreAlum != null) {
								if (apellidosAlum != null) {
									alumno2 = confirmarInexistenciaAlumno(nombreAlum, apellidosAlum);
								} else {
									alumno2 = confirmarInexistenciaAlumno(nombreAlum, alumno3.getApellidos());
								}
								if (alumno2 == null) {
									alumno3.setNombre(nombreAlum);
								} else {
									System.out.println(
											"El nombre y apellido del alumno coinciden con los de otro alumno, porfavor cambie el apellido o el nombre");
								}
							}
							break;
						case "2":
							System.out.println("Introduzca los apellidos del alumno");
							apellidosAlum = Utiles.scanPalabras();
							if (apellidosAlum != null) {
								if (nombreAlum != null) {
									alumno2 = confirmarInexistenciaAlumno(nombreAlum, apellidosAlum);
								} else {
									alumno2 = confirmarInexistenciaAlumno(alumno3.getNombre(), apellidosAlum);
								}
								if (alumno2 == null) {
									alumno3.setApellidos(apellidosAlum);
								} else {
									System.out.println(
											"El nombre y apellido del alumno coinciden con los de otro alumno, porfavor cambie el apellido o el nombre");
								}
							}
							break;
						case "3":
							System.out.println("Introduzca la direccion del alumno");
							direccionAlum = Utiles.scanTodoTrim();
							if (direccionAlum != null) {
								alumno3.setDireccion(direccionAlum);
							}
							break;
						case "4":
							System.out.println("Introduzca el telefono del alumno");
							telefonoAlum = Utiles.scanNumero();
							if (telefonoAlum != null) {
								alumno3.setTelefono(telefonoAlum);
							}
							break;
						case "5":
							System.out.println("Introduzca la fecha de nacimiento del alumno");
							fechaNacimientoAlum = Utiles.scanFecha();
							if (fechaNacimientoAlum != null) {
								alumno3.setFechaNacimiento(fechaNacimientoAlum);
							}
							break;
						case "6":
							System.out.println("Introduzca el nombre del alumno");
							nombreAlum = Utiles.scanPalabras();
							if (nombreAlum != null) {
								System.out.println("Introduzca los apellidos del alumno");
								apellidosAlum = Utiles.scanPalabras();
								if (apellidosAlum != null) {
									alumno2 = confirmarInexistenciaAlumno(nombreAlum, apellidosAlum);
									if (alumno2 == null) {
										System.out.println("Introduzca la direccion del alumno");
										direccionAlum = Utiles.scanTodoTrim();
										if (direccionAlum != null) {
											System.out.println("Introduzca el telefono del alumno");
											telefonoAlum = Utiles.scanNumero();
											if (telefonoAlum != null) {
												System.out.println("Introduzca la fecha de nacimiento del alumno");
												fechaNacimientoAlum = Utiles.scanFecha();
												if (fechaNacimientoAlum != null) {
													alumno3.setNombre(nombreAlum);
													alumno3.setApellidos(apellidosAlum);
													alumno3.setDireccion(direccionAlum);
													alumno3.setTelefono(telefonoAlum);
													alumno3.setFechaNacimiento(fechaNacimientoAlum);

												}
											}
										}
									} else {
										System.out.println(
												"El nombre y apellido del alumno coinciden con los de otro alumno, porfavor cambie el apellido o el nombre");
									}
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
					if (!(alumno.getNombre().equals(alumno3.getNombre())
							&& alumno.getApellidos().equals(alumno3.getApellidos()))) {
						alumnos.get(alumno.getNombre() + "_" + alumno.getApellidos()).setNombre(alumno3.getNombre());
						alumnos.get(alumno.getNombre() + "_" + alumno.getApellidos())
								.setApellidos(alumno3.getApellidos());
						alumnos.get(alumno.getNombre() + "_" + alumno.getApellidos())
								.setDireccion(alumno3.getDireccion());
						alumnos.get(alumno.getNombre() + "_" + alumno.getApellidos())
								.setTelefono(alumno3.getTelefono());
						alumnos.get(alumno.getNombre() + "_" + alumno.getFechaNacimiento())
								.setNombre(alumno3.getFechaNacimiento());
						if (Utiles.confirmarAccion() == null) {
							GestorDatos.escribirTodosAlum(alumnos);
						}
					} else {
						System.out.println(
								"El nombre y apellido del alumno coinciden con los de otro alumno, porfavor cambie el apellido o el nombre");
					}
				}
			}
		}

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

	public static Curso buscarCurso() {
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

	public static void mostrarAlumno() {
		// buscar alumno y si no es null printear
		Alumno alumno = buscarAlumno();
		if (alumno != null) {
			System.out.println(alumno.toString());
		}
	}

	public static void mostrarAlumnos() {
		// pedir lista alumnos printear lista alumnos
		HashMap<String, Alumno> alumnos = GestorDatos.getListaAlum();
		for (HashMap.Entry<String, Alumno> entry : alumnos.entrySet()) {
			System.out.println(entry.getValue().toString());
		}
	}

}
