package gestores;

import java.util.HashMap;

import java.util.HashMap;
import clases.*;
import principal.*;
import gestores.*;

public class GestorProfesores {
	public static void vincularProfesor() {
		Profesor profesor = buscarProfesor();
		if (profesor != null) {
			System.out.println(profesor.toString());
			Curso curso = buscarCurso();
			if (curso != null) {
				System.out.println(curso.toString());
				if (profesor != null && curso != null) {
					HashMap<String, Profesor> profesores = GestorDatos.getListaProf();
					HashMap<String, Curso> cursos = GestorDatos.getListaCursos();
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
	}

	public static void desvincularProfesor() {
		Profesor profesor = buscarProfesor();
		if (profesor != null) {
			System.out.println(profesor.toString());
			Curso curso = buscarCurso();
			if (curso != null) {
				System.out.println(curso.toString());
				if (profesor != null && curso != null) {
					HashMap<String, Profesor> profesores = GestorDatos.getListaProf();
					HashMap<String, Curso> cursos = GestorDatos.getListaCursos();
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
	}

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

	public static void borrarProfesor() {
		Profesor profesor = buscarProfesor();
		if (profesor != null) {
			System.out.println(profesor.toString());
			HashMap<String, Profesor> profesores = GestorDatos.getListaProf();
			HashMap<String, Curso> cursos = GestorDatos.getListaCursos();
			for (HashMap.Entry<String, Curso> entry : cursos.entrySet()) {
				Profesor profesorAux = entry.getValue().getProfesor();
				if (profesorAux != null) {
					entry.getValue().setProfesor(null);
				}
			}
			if (Utiles.confirmarAccion() == null) {
				profesores.remove(profesor);
				GestorDatos.escribirTodosProf(profesores);
				GestorDatos.escribirTodosCursos(cursos);
			}
		}
	}

	public static void modificarProfesor() {
		String nombreProfesor = null;
		String dniProfesor = null;
		String direccionProfesor = null;
		String telefonoProfesor = null;
		Profesor profesor = buscarProfesor();
		Profesor profesor2 = null;
		Profesor profesor3 = new Profesor(profesor.getNombre(),profesor.getDni(),profesor.getDireccion(),profesor.getTelefono());
		if (profesor != null) {
			HashMap<String, Profesor> profesores = GestorDatos.getListaProf();
			
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
	}

	public static Profesor confirmarInexistenciaProfesor(String dniProfesor) {
		// busco alumno y si no existe devuelve null
		Profesor profesor = GestorDatos.buscarProf(dniProfesor);
		if (profesor == null) {
			System.out.println("El profesor no existe, siga introcuciendo datos");
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
				System.out.println("Introduzca el nombre del curso");
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

	public static void mostrarProfesor() {
		Profesor profesor = buscarProfesor();
		if (profesor != null) {
			System.out.println(profesor.toString());
		}
	}

	public static void mostrarProfesores() {
		HashMap<String, Profesor> profesores = GestorDatos.getListaProf();
		for (HashMap.Entry<String, Profesor> entry : profesores.entrySet()) {
			System.out.println(entry.getValue().toString());
		}
	}

}
