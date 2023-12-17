package gestores;

import java.util.HashMap;
import clases.*;
import principal.*;
import gestores.*;

public class GestorAlumnos {
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
								if(Utiles.confirmarAccion()==null) {
									
								
									cursosAlum.put(curso.getNombre(), curso);
									alumnos.get(alumno.getNombre() + "_" + alumno.getApellidos()).setCursos(cursosAlum);
									GestorDatos.escribirTodosAlum(alumnos);
									System.out.println("El alumno: " + alumno.getNombre()
											+ " ha sido matriculado en el curso: " + curso.getNombre());
									alumnosCurso.put(alumno.getNombre() + "_" + alumno.getApellidos(), alumno);
									cursos.get(curso.getNombre()).setAlumnos(alumnosCurso);
									GestorDatos.escribirTodosCursos(cursos);
								}
							} else {
								System.out.println("Lo sentimos pero: " + alumno.getNombre()
										+ " ya esta matriculado en: " + curso.getNombre());
							}
						}
					}
				}
			} else {
				System.out.println("No hay cursos, crea algun curso antes");
			}
		} else {
			System.out.println("No hay alumnos, crea algun alumno antes");
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
								if(Utiles.confirmarAccion()==null) {
									
									cursosAlum.remove(curso.getNombre(),curso);
									alumnos.get(alumno.getNombre() + "_" + alumno.getApellidos()).setCursos(cursosAlum);
									GestorDatos.escribirTodosAlum(alumnos);
									System.out.println("El alumno: " + alumno.getNombre()
											+ " ha sido desmatriculado del curso: " + curso.getNombre());
	
									alumnosCurso.remove(alumno.getNombre() + "_" + alumno.getApellidos(), alumno);
									cursos.get(curso.getNombre()).setAlumnos(alumnosCurso);
									GestorDatos.escribirTodosCursos(cursos);
								}
							} else {
								System.out.println("Lo sentimos pero: " + alumno.getNombre()
										+ " no esta matriculado en: " + curso.getNombre());
							}
						}
					}
				}
			} else {
				System.out.println("No hay cursos, por lo que nadie esta matriculado");
			}
		} else {
			System.out.println("No hay alumnos, por lo que no hay nada que desmatricular");
		}
	}
	/**
	 * Este metodo se encarga de crear y confirmar que no existe un alumno
	 */
	public static void crearAlumno() {
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
						String telefonoAlum = Utiles.scanTelefono();
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
	/**
	 * Este metodo se encarga de borrar un alumno y todas sus relaciones
	 */
	public static void borrarAlumno() {
		HashMap<String, Alumno> alumnos = GestorDatos.getListaAlum();
		if(!alumnos.isEmpty()) {
		
		Alumno alumno = buscarAlumno();
		if (alumno != null) {
			System.out.println(alumno.toString());
			alumnos = GestorDatos.getListaAlum();
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
		}else {
			System.out.println("No hay alumnos, crea algun alumno antes");
		}

	}
	/**
	 * Este metodo se encarga de buscar un alumno y te permite modificar todos los datos que quieras hasta que desees salir
	 */
	public static void modificarAlumno() {
		HashMap<String, Alumno> alumnos = GestorDatos.getListaAlum();
		if(!alumnos.isEmpty()) {
		
		String nombreAlum = null;
		String apellidosAlum = null;
		String direccionAlum = null;
		String telefonoAlum = null;
		String fechaNacimientoAlum = null;
		Alumno alumno = buscarAlumno();
		if (alumno != null) {
			Alumno alumno2 = null;
			Alumno alumno3 = new Alumno(alumno.getNombre(), alumno.getApellidos(), alumno.getDireccion(),
					alumno.getTelefono(), alumno.getFechaNacimiento());
			
				alumnos = GestorDatos.getListaAlum();
				boolean check = true;
				System.out.println("Se ha encontrado el alumno: " + alumno.toString());
				do {
					System.out.println(
							"Que desea modificar?\n1.Nombre \n2.Apellidos \n3.Direccion \n4.Telefono \n5.Fecha de nacimiento \n6.Todo \n0.Salir ");
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
						telefonoAlum = Utiles.scanTelefono();
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
										telefonoAlum = Utiles.scanTelefono();
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

				if (Utiles.confirmarAccion() == null) {
					if(alumno.getCursos()!=null) {
						HashMap<String, Curso> cursos=GestorDatos.getListaCursos();
						HashMap<String, Curso> cursosAlumn=alumno.getCursos();
						
						for(HashMap.Entry<String, Curso> entryCursosAlumn : cursosAlumn.entrySet()) {
							
							HashMap<String, Alumno> alumnCurso =entryCursosAlumn.getValue().getAlumnos();
							for(HashMap.Entry<String, Alumno> entryAlumnCurso : alumnCurso.entrySet()) {
								if(entryAlumnCurso.getValue().getNombre().equalsIgnoreCase(alumno.getNombre())&&entryAlumnCurso.getValue().getApellidos().equalsIgnoreCase(alumno.getApellidos())) {
									cursos.get(entryCursosAlumn.getValue().getNombre()).getAlumnos().remove(alumno.getNombre());
									cursos.get(entryCursosAlumn.getValue().getNombre()).getAlumnos().put(alumno3.getNombre()+"_"+alumno3.getApellidos(), alumno3);
								}
							}
							
						}
						GestorDatos.escribirTodosCursos(cursos);
					}
					alumnos.get(alumno.getNombre() + "_" + alumno.getApellidos()).setNombre(alumno3.getNombre());
					alumnos.get(alumno.getNombre() + "_" + alumno.getApellidos()).setApellidos(alumno3.getApellidos());
					alumnos.get(alumno.getNombre() + "_" + alumno.getApellidos()).setDireccion(alumno3.getDireccion());
					alumnos.get(alumno.getNombre() + "_" + alumno.getApellidos()).setTelefono(alumno3.getTelefono());
					alumnos.get(alumno.getNombre() + "_" + alumno.getApellidos())
							.setFechaNacimiento(alumno3.getFechaNacimiento());
					GestorDatos.escribirTodosAlum(alumnos);
				}
			
		}
		}else {
			System.out.println("No hay alumnos, crea algun alumno antes");
		}
	}
	/**
	 * Este metodo se encarga de confirmar que un alumno no existe, para poder crearlo
	 * @param nombreAlum Es la clave que va a comprobar si esta en la lista de alumnos
	 *@param apellidosAlum Es la otra parte de la clave que va a comprobar si esta en la lista de alumnos
	 * @return En el caso de encontrar un alumno con la misma clave lo devuelve y si no existe devuelve null
	 */
	public static Alumno confirmarInexistenciaAlumno(String nombreAlum, String apellidosAlum) {
		Alumno alumno = GestorDatos.buscarAlum(nombreAlum, apellidosAlum);
		if (alumno == null) {
			
		} else {
			System.out.println("Se ha encontrado un alumno con el mismo nombre y apellidos");
			System.out.println("");
		}

		return alumno;
	}
	/**
	 * Este metodo se encarga de buscar un alumno y si este existe lo devuelve si no devuelve null
	 * @return Devuelve un alumno si lo encuentra y si no null
	 */
	public static Alumno buscarAlumno() {
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
							System.out.println("");
							check = false;
						} else {
							System.out.println("Se ha encontrado el alumno");
						}
					}
				}
				errorCont++;
			} else {
				System.out.println("Excedido numero de intentos (" + errorCont + ")");
				System.out.println("");
			}
		} while (!check);

		return alumno;
	}
	/**
	 * Este metodo se encarga de buscar un curso y si este existe lo devuelve si no devuelve null
	 * @return Devuelve un curso si lo encuentra y si no null
	 */
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
						System.out.println("");
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
	/**
	 * Muestra los datos de un alumno que es buscado
	 */
	public static void mostrarAlumno() {
		HashMap<String, Alumno> alumnos = GestorDatos.getListaAlum();
		if(!alumnos.isEmpty()) {
		
		Alumno alumno = buscarAlumno();
		if (alumno != null) {
			System.out.println(alumno.toString());
		}
		}else {
			System.out.println("No hay alumnos, crea algun alumno antes");
			System.out.println("");
		}
	}
	/**
	 * Muestra los datos de todos los alumnos
	 */
	public static void mostrarAlumnos() {
		HashMap<String, Alumno> alumnos = GestorDatos.getListaAlum();
		for (HashMap.Entry<String, Alumno> entry : alumnos.entrySet()) {
			System.out.println(entry.getValue().toString());
		}
	}

}
