package gestores;

import java.util.HashMap;
import clases.*;
import principal.*;

public class GestorCursos {
	/**
	 * Este metodo se encarga de vincular un profesor a un curso y viceversa
	 */
	public static void vincularProfesor() {
		HashMap<String, Profesor> profesores = GestorDatos.getListaProf();
		if (!profesores.isEmpty()) {
			HashMap<String, Curso> cursos = GestorDatos.getListaCursos();
			if (!cursos.isEmpty()) {

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
							if (!(cursosProfesor.containsValue(curso) && curso.getProfesor().equals(profesor))) {
								if (curso.getProfesor() != null) {
									System.out.println("\nEl profesor: " + curso.getProfesor().getNombre()
											+ " ya esta vinculado al curso: " + curso.getNombre());
								}
								if (Utiles.confirmarAccion() == true) {
									cursos.get(curso.getNombre()).setProfesor(profesor);
									cursosProfesor.put(curso.getNombre(), curso);
									profesores.get(profesor.getDni()).setCursos(cursosProfesor);
									if (curso.getProfesor() != null) {
										cursosProfesor.remove(curso.getNombre(), curso);
										profesores.get(curso.getProfesor().getDni()).setCursos(cursosProfesor);
									}
									System.out.println("\nEl profesor: " + profesor.getDni()
											+ " ha sido vinculado al curso: " + curso.getNombre());
									GestorDatos.escribirTodosProf(profesores);
									GestorDatos.escribirTodosCursos(cursos);
								}
							} else {
								System.out.println("\nLo sentimos pero: " + profesor.getNombre()
										+ " ya esta vinculado en: " + curso.getNombre());
							}
						}
					}
				}
			} else {
				System.out.println("\nNo hay cursos, porfavor crea alguno");
			}
		} else {
			System.out.println("\nNo hay profesores, porfavor crea alguno");
		}
	}

	/**
	 * Este metodo se encarga de desvincular un profesor de un curso y viceversa
	 */
	public static void desvincularProfesor() {
		HashMap<String, Profesor> profesores = GestorDatos.getListaProf();
		if (!profesores.isEmpty()) {
			HashMap<String, Curso> cursos = GestorDatos.getListaCursos();
			if (!cursos.isEmpty()) {
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
								if(Utiles.confirmarAccion()==true) {
									cursos.get(curso.getNombre()).setProfesor(null);
									cursosProfesor.remove(curso.getNombre(), curso);
									profesores.get(profesor.getDni()).setCursos(cursosProfesor);
									System.out.println("\nEl profesor: " + profesor.getDni()
											+ " ha sido desvinculado al curso: " + curso.getNombre());
									GestorDatos.escribirTodosProf(profesores);
									GestorDatos.escribirTodosCursos(cursos);
								}
							} else {
								System.out.println("\nLo sentimos pero: " + profesor.getNombre()
										+ " no esta vinculado en: " + curso.getNombre());
							}
						}
					}
				}
			} else {
				System.out.println("\nNo hay cursos, por lo que no hay nada que desvincular");
			}
		} else {
			System.out.println("\nNo hay profesores, por lo que no hay nadie vinculado");
		}
	}

	/**
	 * Este metodo se encarga de matricular un alumno a un curso y viceversa
	 */
	public static void matricularAlumno() {
		HashMap<String, Alumno> alumnos = GestorDatos.getListaAlum();
		if (!alumnos.isEmpty()) {
			HashMap<String, Curso> cursos = GestorDatos.getListaCursos();
			if (!cursos.isEmpty()) {

				Alumno alumno = buscarAlumno();
				if (alumno != null) {
					System.out.println(alumno.toString());
					Curso curso = buscarCurso();
					if (curso != null) {

						System.out.println(curso.toString());
						if (alumno != null && curso != null) {
							alumnos = GestorDatos.getListaAlum();
							cursos = GestorDatos.getListaCursos();
							HashMap<String, Curso> cursosAlum = alumnos
									.get(alumno.getNombre() + "_" + alumno.getApellidos()).getCursos();
							HashMap<String, Alumno> alumnosCurso = cursos.get(curso.getNombre()).getAlumnos();
							if (!(cursosAlum.containsValue(curso) && alumnosCurso.containsValue(alumno))) {
								if(Utiles.confirmarAccion()==true) {
									
								
									cursosAlum.put(curso.getNombre(), curso);
									alumnos.get(alumno.getNombre() + "_" + alumno.getApellidos()).setCursos(cursosAlum);
									GestorDatos.escribirTodosAlum(alumnos);
									System.out.println("\nEl alumno: " + alumno.getNombre()
											+ " ha sido matriculado en el curso: " + curso.getNombre());
									alumnosCurso.put(alumno.getNombre() + "_" + alumno.getApellidos(), alumno);
									cursos.get(curso.getNombre()).setAlumnos(alumnosCurso);
									GestorDatos.escribirTodosCursos(cursos);
								}
							} else {
								System.out.println("\nLo sentimos pero: " + alumno.getNombre()
										+ " ya esta matriculado en: " + curso.getNombre());
							}
						}
					}
				}
			} else {
				System.out.println("\nNo hay cursos, crea algun curso antes");
			}
		} else {
			System.out.println("\nNo hay alumnos, crea algun alumno antes");
		}
	}

	/**
	 * Este metodo se encarga de desmatricular un alumno a un curso y viceversa
	 */
	public static void desmatricularAlumno() {
		HashMap<String, Alumno> alumnos = GestorDatos.getListaAlum();
		if (!alumnos.isEmpty()) {
			HashMap<String, Curso> cursos = GestorDatos.getListaCursos();
			if (!cursos.isEmpty()) {

				Alumno alumno = buscarAlumno();
				if (alumno != null) {
					System.out.println(alumno.toString());
					Curso curso = buscarCurso();
					if (curso != null) {
						System.out.println(curso.toString());

						if (alumno != null && curso != null) {
							alumnos = GestorDatos.getListaAlum();
							cursos = GestorDatos.getListaCursos();
							HashMap<String, Curso> cursosAlum = alumnos.get(alumno.getNombre() + "_" + alumno.getApellidos()).getCursos();
							HashMap<String, Alumno> alumnosCurso = cursos.get(curso.getNombre()).getAlumnos();
							if (cursosAlum.containsValue(curso) && alumnosCurso.containsValue(alumno)) {
								if(Utiles.confirmarAccion()==true) {
									
									cursosAlum.remove(curso.getNombre(),curso);
									alumnos.get(alumno.getNombre() + "_" + alumno.getApellidos()).setCursos(cursosAlum);
									GestorDatos.escribirTodosAlum(alumnos);
									System.out.println("\nEl alumno: " + alumno.getNombre()
											+ " ha sido desmatriculado del curso: " + curso.getNombre());
	
									alumnosCurso.remove(alumno.getNombre() + "_" + alumno.getApellidos(), alumno);
									cursos.get(curso.getNombre()).setAlumnos(alumnosCurso);
									GestorDatos.escribirTodosCursos(cursos);
								}
							} else {
								System.out.println("\nLo sentimos pero: " + alumno.getNombre()
										+ " no esta matriculado en: " + curso.getNombre());
							}
						}
					}
				}
			} else {
				System.out.println("\nNo hay cursos, por lo que nadie esta matriculado");
			}
		} else {
			System.out.println("\nNo hay alumnos, por lo que no hay nada que desmatricular");
		}
	}

	/**
	 * Este metodo se encarga de crear y confirmar que no existe un curso
	 */
	public static void crearCurso() {
		Curso curso = null;
		System.out.println("\nIntroduzca el nombre del curso");
		String nombreCurso = Utiles.scanPalabras();
		if (nombreCurso != null) {
			curso = confirmarInexistenciaCurso(nombreCurso);
			if (curso == null) {
				System.out.println("\nIntroduzca la descripcion del curso");
				String descripcionCurso = Utiles.scanTodoTrim();
				if (descripcionCurso != null) {
					curso = new Curso(nombreCurso, descripcionCurso);
					GestorDatos.escribirCurso(curso);// falta confirmacion

					System.out.println("\nEl curso ha sido creado exitosamente");

				}
			}
		}
	}

	/**
	 * Este metodo se encarga de borrar un curso y todas sus relaciones
	 */
	public static void borrarCurso() {
		HashMap<String, Curso> cursos = GestorDatos.getListaCursos();
		if (!cursos.isEmpty()) {
			Curso curso = buscarCurso();
			if (curso != null) {
				System.out.println(curso.toString());
				cursos = GestorDatos.getListaCursos();

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
				if (Utiles.confirmarAccion() == true) {
					cursos.remove(curso.getNombre());
					GestorDatos.escribirTodosProf(profesores);
					GestorDatos.escribirTodosAlum(alumnos);
					GestorDatos.escribirTodosCursos(cursos);
				}
			}
		} else {
			System.out.println("\nNo hay cursos, porfavor crea alguno");
		}
	}

	/**
	 * Este metodo se encarga de buscar un curso y te permite modificar todos los
	 * datos que quieras hasta que desees salir
	 */
	// LOS PRINTS ESTABAN MUY MAL, AHORA TENDRIAN QUE ESTAR BIEN Y LA COMPARACION
	// FINAL FUNCIONA EN PREINCIPIO
	public static void modificarCurso() {
		HashMap<String, Curso> cursos = GestorDatos.getListaCursos();
		if (!cursos.isEmpty()) {

			String nombreCurso = null;
			String descripcionCurso = null;
			Curso curso = buscarCurso();
			if (curso != null) {
				Curso curso2 = null;
				Curso curso3 = new Curso(curso.getNombre(), curso.getDescripcion());
				Curso.restarCont();//Tras crear un curso que no es nuevo se resta 1 al contador

				cursos = GestorDatos.getListaCursos();
				for (HashMap.Entry<String, Curso> entry : cursos.entrySet()) {
					if (entry.getValue().equals(curso)) {
						boolean check = true;
						System.out.println("\nSe ha encontrado el curso: " + curso.toString());
						do {
							System.out.println("\n¿Que desea modificar?\n1.Nombre\n2.Descripcion\n3.Todo\n0.Salir");
							String opcion = Utiles.scanNumero();
							switch (opcion) {
							case "1":
								System.out.println("\nIntroduzca el nombre del curso");
								nombreCurso = Utiles.scanPalabras();
								if (nombreCurso != null) {
									curso2 = confirmarInexistenciaCurso(nombreCurso);
									if (curso2 == null) {
										curso3.setNombre(nombreCurso);
									}
								}
								break;
							case "2":
								System.out.println("\nIntroduzca la descripcion del curso");
								descripcionCurso = Utiles.scanTodoTrim();
								if (descripcionCurso != null) {
									curso3.setDescripcion(descripcionCurso);
								}
								break;
							case "3":
								System.out.println("\nIntroduzca el nombre del curso");
								nombreCurso = Utiles.scanPalabras();
								if (nombreCurso != null) {
									curso2 = confirmarInexistenciaCurso(nombreCurso);
									if (curso2 == null) {
										System.out.println("\nIntroduzca la descripcion del curso");
										descripcionCurso = Utiles.scanTodoTrim();
										if (descripcionCurso != null) {
											curso3.setNombre(nombreCurso);
											curso3.setDescripcion(descripcionCurso);
										}
									}
								}
								break;
							case "0":
								check = false;
								break;
							default:
								System.out.println("\nValor no valido.\n");
							}
						} while (check);
						// AHORA SI TENDRIA QUE MODIFICAR EN CONDICIONES EL CURSO
						if (Utiles.confirmarAccion() == true) {
							if (curso.getProfesor() != null) {
								HashMap<String, Profesor> profesores = GestorDatos.getListaProf();
								for (HashMap.Entry<String, Profesor> entryAux : profesores.entrySet()) {
									Profesor profesorAux = entryAux.getValue();
									if (profesorAux.getDni().equalsIgnoreCase(curso.getProfesor().getDni())) {
										HashMap<String, Curso> cursosProfesor = profesorAux.getCursos();
										for (HashMap.Entry<String, Curso> entryAuxCursoProfesor : cursosProfesor
												.entrySet()) {
											if (entryAuxCursoProfesor.getValue().getNombre().equalsIgnoreCase(curso.getNombre())) {
												profesores.get(entryAux.getKey()).getCursos().remove(entryAuxCursoProfesor.getKey(), entryAuxCursoProfesor.getValue());
												profesores.get(entryAux.getKey()).getCursos().put(curso3.getNombre(), curso3);
											}
										}
									}
								}
								GestorDatos.escribirTodosProf(profesores);
							}

							if (curso.getAlumnos() != null) {
								HashMap<String, Alumno> alumnos = GestorDatos.getListaAlum();
								for (HashMap.Entry<String, Alumno> entryAux : alumnos.entrySet()) {
									Alumno alumnoAux = entryAux.getValue();
									HashMap<String, Curso> cursosAlumno = alumnoAux.getCursos();
									for (HashMap.Entry<String, Curso> entryAuxCursoAlumno : cursosAlumno.entrySet()) {
										if (entryAuxCursoAlumno.getValue().getNombre().equalsIgnoreCase(curso.getNombre())) {
											
											alumnos.get(entryAux.getKey()).getCursos().remove(entryAuxCursoAlumno.getKey(),entryAuxCursoAlumno.getValue());
											alumnos.get(entryAux.getKey()).getCursos().put(curso3.getNombre(), curso3);
											
										}
									}
								}
								GestorDatos.escribirTodosAlum(alumnos);
							}
							cursos.get(curso.getNombre()).setNombre(curso3.getNombre());
							cursos.get(curso.getNombre()).setDescripcion(curso3.getDescripcion());
							GestorDatos.escribirTodosCursos(cursos);
						}
					}
				}
			}

		} else {
			System.out.println("\nNo hay cursos, porfavor crea alguno");
		}
	}

	/**
	 * Este metodo se encarga de confirmar que un curso no existe, para poder
	 * crearlo
	 * 
	 * @param nombreCurso Es la clave que va a comprobar si esta en la lista de
	 *                    cursos
	 * @return En el caso de encontrar un curso con la misma clave lo devuelve y si
	 *         no existe devuelve null
	 */
	public static Curso confirmarInexistenciaCurso(String nombreCurso) {
		Curso curso = GestorDatos.buscarCurso(nombreCurso);
		if (curso == null) {
		} else {
			System.out.println("\nSe ha encontrado un curso con el mismo nombre");
		}

		return curso;
	}

	/**
	 * Este metodo se encarga de buscar un curso y si este existe lo devuelve si no
	 * devuelve null
	 * 
	 * @return Devuelve un curso si lo encuentra y si no null
	 */
	public static Curso buscarCurso() {
		Curso curso = null;
		boolean check = true;
		int errorCont = 0;
		do {
			check = true;
			if (errorCont < 5) {
				System.out.println("\nIntroduzca el nombre del curso");
				String nombreCurso = Utiles.scanPalabras();
				if (nombreCurso != null) {
					curso = GestorDatos.buscarCurso(nombreCurso);
					if (curso == null) {
						System.out.println("\nNo se ha encontrado el curso vuelva a introducir los datos\n");
						check = false;
					} else {
						System.out.println("\nSe ha encontrado el curso");
					}
				}
				errorCont++;
			} else {
				System.out.println("\nExcedido numero de intentos (" + errorCont + ")");
			}
		} while (!check);
		return curso;
	}

	/**
	 * Este metodo se encarga de confirmar que un profesor no existe, para poder
	 * crearlo
	 * 
	 * @param dniProfesor Es la clave que va a comprobar si esta en la lista de
	 *                    profesores
	 * @return En el caso de encontrar un profesor con el mismo dni lo devuelve y si
	 *         no existe devuelve null
	 */
	public static Profesor confirmarInexistenciaProfesor(String dniProfesor) {
		Profesor profesor = GestorDatos.buscarProf(dniProfesor);
		if (profesor == null) {
		} else {
			System.out.println("\nSe ha encontrado un profesor con el mismo dni\n");
		}
		return profesor;
	}

	/**
	 * Este metodo se encarga de buscar un profesor y si este existe lo devuelve si
	 * no devuelve null
	 * 
	 * @return Devuelve un profesor si lo encuentra y si no null
	 */
	public static Profesor buscarProfesor() {
		Profesor profesor = null;
		boolean check = true;
		int errorCont = 0;
		do {
			check = true;
			if (errorCont < 5) {
				System.out.println("\nIntroduzca el DNI del profesor");
				String dniProfesro = Utiles.scanDni();
				if (dniProfesro != null) {
					profesor = GestorDatos.buscarProf(dniProfesro);
					if (profesor == null) {
						System.out.println("\nNo se ha encontrado el profesor vuelva a introducir los datos\n");
						check = false;
					} else {
						System.out.println("\nSe ha encontrado el profesor");
					}
				}
				errorCont++;
			} else {
				System.out.println("\nExcedido numero de intentos (" + errorCont + ")");
			}
		} while (!check);
		return profesor;
	}

	/**
	 * Este metodo se encarga de confirmar que un alumno no existe, para poder
	 * crearlo
	 * 
	 * @param nombreAlum    Es la clave que va a comprobar si esta en la lista de
	 *                      alumnos
	 * @param apellidosAlum Es la otra parte de la clave que va a comprobar si esta
	 *                      en la lista de alumnos
	 * @return En el caso de encontrar un alumno con la misma clave lo devuelve y si
	 *         no existe devuelve null
	 */
	public static Alumno confirmarInexistenciaAlumno(String nombreAlum, String apellidosAlum) {
		Alumno alumno = GestorDatos.buscarAlum(nombreAlum, apellidosAlum);
		if (alumno == null) {
			
		} else {
			System.out.println("\nSe ha encontrado un alumno con el mismo nombre y apellidos\n");
		}

		return alumno;
	}

	/**
	 * Este metodo se encarga de buscar un alumno y si este existe lo devuelve si no
	 * devuelve null
	 * 
	 * @return Devuelve un alumno si lo encuentra y si no null
	 */
	public static Alumno buscarAlumno() {
		Alumno alumno = null;
		boolean check = true;
		int errorCont = 0;
		do {
			check = true;
			if (errorCont < 5) {
				System.out.println("\nIntroduzca el nombre del alumno");
				String nombreAlum = Utiles.scanPalabras();
				if (nombreAlum != null) {
					System.out.println("\nIntroduzca los apellidos del alumno");
					String apellidosAlum = Utiles.scanPalabras();
					if (apellidosAlum != null) {
						alumno = GestorDatos.buscarAlum(nombreAlum, apellidosAlum);
						if (alumno == null) {
							System.out.println("\nNo se ha encontrado el alumno vuelva a introducir los datos\n");
							check = false;
						} else {
							System.out.println("\nSe ha encontrado el alumno");
						}
					}
				}
				errorCont++;
			} else {
				System.out.println("\nExcedido numero de intentos (" + errorCont + ")\n");
			}
		} while (!check);

		return alumno;
	}

	/**
	 * Muestra los datos de un curso que es buscado
	 */
	public static void mostrarCurso() {
		HashMap<String, Curso> cursos = GestorDatos.getListaCursos();
		if (!cursos.isEmpty()) {
			Curso curso = buscarCurso();
			if (curso != null) {
				System.out.println(curso.toString());
			}
		} else {
			System.out.println("\nNo hay cursos, porfavor crea alguno\n");
		}
	}

	/**
	 * Muestra los datos de todos los cursos
	 */
	public static void mostrarCursos() {
		HashMap<String, Curso> cursos = GestorDatos.getListaCursos();
		for (HashMap.Entry<String, Curso> entry : cursos.entrySet()) {
			System.out.println("\n"+entry.getValue().toString());
		}
	}

}