package gestores;

import java.util.HashMap;

import java.util.HashMap;
import clases.*;
import principal.*;
import gestores.*;

public class GestorProfesores {
	/**
	 * Este metodo se encarga de vincular un profesor a un curso y viceversa
	 */
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
						System.out.println("El profesor: "+profesor.getDni()+" ha sido vinculado al curso: "+curso.getNombre());
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
	/**
	 * Este metodo se encarga de desvincular un profesor de un curso y viceversa
	 */
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
						System.out.println("El profesor: "+profesor.getDni()+" ha sido desvinculado al curso: "+curso.getNombre());
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
	/**
	 * Este metodo se encarga de crear y confirmar que no existe un profesor
	 */
	public static void crearProfesor() {
		Profesor profesor = null;
		System.out.println("Introduzca el DNI del profesor");
		String dniProfesor = Utiles.scanDni();
		if (dniProfesor != null) {
			profesor = confirmarInexistenciaProfesor(dniProfesor);
			if (profesor == null) {
				System.out.println("Introduzca el nombre del profesor");
				String nombreProfesor = Utiles.scanPalabras();
				if (nombreProfesor != null) {
					System.out.println("Introduzca la direccion del profesor");
					String direccionProfesor = Utiles.scanTodoTrim();
					if (direccionProfesor != null) {
						System.out.println("Introduzca el telefono del profesor");
						String telefonoProfesor = Utiles.scanTelefono();
						if (telefonoProfesor != null) {
							profesor = new Profesor(nombreProfesor, dniProfesor, direccionProfesor, telefonoProfesor);
							GestorDatos.escribirProf(profesor);// falta confirmacion
							System.out.println("El profesor ha sido creado exitosamente");
						}
					}
				}
			}
		}
	}
	/**
	 * Este metodo se encarga de borrar un profesor y todas sus relaciones
	 */
	//SE HA TOCADO EL COMPARAR EL PROFESOR BORRADO CON EL PROFESOR DEL CURSO AHORA DEBERIA FUNCIONAR 
	public static void borrarProfesor() {
		HashMap<String, Profesor> profesores = GestorDatos.getListaProf();
		if(!profesores.isEmpty()) {
		Profesor profesor = buscarProfesor();
		if (profesor != null) {
			System.out.println(profesor.toString());
			profesores = GestorDatos.getListaProf();
			if (Utiles.confirmarAccion() == null) {
				HashMap<String, Curso> cursos = GestorDatos.getListaCursos();
				for (HashMap.Entry<String, Curso> entry : cursos.entrySet()) {
					Profesor profesorAux = entry.getValue().getProfesor();
					if (profesorAux != null && profesorAux.equals(profesor)) {
						entry.getValue().setProfesor(null);
					}
				}
				profesores.remove(profesor.getDni(),profesor);
				GestorDatos.escribirTodosProf(profesores);
				GestorDatos.escribirTodosCursos(cursos);
			}
		}
		}else {
			System.out.println("No hay profesores, porfavor crea alguno");
		}
	}
	/**
	 * Este metodo se encarga de buscar un profesor y te permite modificar todos los datos que quieras hasta que desees salir
	 */
	public static void modificarProfesor() {
		HashMap<String, Profesor> profesores = GestorDatos.getListaProf();
		if(!profesores.isEmpty()) {
		String nombreProfesor = null;
		String dniProfesor = null;
		String direccionProfesor = null;
		String telefonoProfesor = null;
		Profesor profesor = buscarProfesor();
		if (profesor != null) {
		Profesor profesor2 = null;
		Profesor profesor3 = new Profesor(profesor.getNombre(),profesor.getDni(),profesor.getDireccion(),profesor.getTelefono());
		
			profesores = GestorDatos.getListaProf();
			
					boolean check = true;
					System.out.println("Se ha encontrado el profesor: " + profesor.toString());
					do {
						System.out.println(
								"Que desea modificar?\n1.Nombre \n2.DNI \n3.Direccion \n4.Telefono \n5.Todo \n0.Salir ");
						String opcion = Utiles.scanNumero();
						switch (opcion) {
						case "1":
							System.out.println("Introduzca el nombre del profesor");
							nombreProfesor = Utiles.scanPalabras();
							if (nombreProfesor != null) {
								profesor3.setNombre(nombreProfesor);
							}
							break;
						case "2":
							System.out.println("Introduzca el DNI del profesor");
							dniProfesor = Utiles.scanDni();
							if (dniProfesor != null) {
								profesor2 = confirmarInexistenciaProfesor(dniProfesor);
								if (profesor2 == null) {
									profesor3.setDni(dniProfesor);
								} else {
									System.out.println(
											"El DNI del profesor coincide con el de otro profesor, porfavor cambie el DNI");
								}
							}
							break;
						case "3":
							System.out.println("Introduzca la direccion del profesor");
							direccionProfesor = Utiles.scanTodoTrim();
							if (direccionProfesor != null) {
								profesor3.setDireccion(direccionProfesor);
							}
							break;
						case "4":
							System.out.println("Introduzca el telefono del profesor");
							telefonoProfesor = Utiles.scanTelefono();
							if (telefonoProfesor != null) {
								profesor3.setTelefono(telefonoProfesor);
							}
							break;
						case "5":
							System.out.println("Introduzca el nombre del profesor");
							nombreProfesor = Utiles.scanPalabras();
							if (nombreProfesor != null) {
								System.out.println("Introduzca el DNI del profesor");
								dniProfesor = Utiles.scanPalabras();
								if (dniProfesor != null) {
									profesor2 = confirmarInexistenciaProfesor(dniProfesor);
									if (profesor2 == null) {
										System.out.println("Introduzca la direccion del profesor");
										direccionProfesor = Utiles.scanTodoTrim();
										if (direccionProfesor != null) {
											System.out.println("Introduzca el telefono del profesor");
											telefonoProfesor = Utiles.scanTelefono();
											if (telefonoProfesor != null) {
												profesor3.setNombre(nombreProfesor);
												profesor3.setDni(dniProfesor);
												profesor3.setDireccion(direccionProfesor);
												profesor3.setTelefono(telefonoProfesor);
											}
										}
									} else {
										System.out.println(
												"El DNI coincide con el de otro profesor, porfavor cambie el DNI");
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
							profesores.get(profesor.getDni()).setNombre(profesor3.getNombre());
							profesores.get(profesor.getDni()).setDni(profesor3.getDni());
							profesores.get(profesor.getDni()).setDireccion(profesor3.getDireccion());
							profesores.get(profesor.getDni()).setTelefono(profesor3.getTelefono());
							GestorDatos.escribirTodosProf(profesores);
						}
		}
		}else {
			System.out.println("No hay profesores, porfavor crea alguno");
		}
	}
	/**
	 * Este metodo se encarga de confirmar que un profesor no existe, para poder crearlo
	 * @param dniProfesor Es la clave que va a comprobar si esta en la lista de profesores
	 * @return En el caso de encontrar un profesor con el mismo dni lo devuelve y si no existe devuelve null
	 */
	public static Profesor confirmarInexistenciaProfesor(String dniProfesor) {
		Profesor profesor = GestorDatos.buscarProf(dniProfesor);
		if (profesor == null) {
			System.out.println("El profesor no existe, siga introcuciendo datos");
		} else {
			System.out.println("Se ha encontrado un profesor con el mismo dni");
		}
		return profesor;
	}
	/**
	 * Este metodo se encarga de buscar un profesor y si este existe lo devuelve si no devuelve null
	 * @return Devuelve un profesor si lo encuentra y si no null
	 */
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
						System.out.println("No se ha encontrado el profesor, vuelva a introducir los datos");
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
						System.out.println("No se ha encontrado el curso, vuelva a introducir los datos");
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
	 * Muestra los datos de un profesor que es buscado
	 */
	public static void mostrarProfesor() {
		HashMap<String, Profesor> profesores = GestorDatos.getListaProf();
		if(!profesores.isEmpty()) {
	
		Profesor profesor = buscarProfesor();
		if (profesor != null) {
			System.out.println(profesor.toString());
		}
		}else {
			System.out.println("No hay profesores, porfavor crea alguno");
		}
	}
	/**
	 * Muestra los datos de todos los profesores
	 */
	public static void mostrarProfesores() {
		HashMap<String, Profesor> profesores = GestorDatos.getListaProf();
		for (HashMap.Entry<String, Profesor> entry : profesores.entrySet()) {
			System.out.println(entry.getValue().toString());
		}
	}

}
