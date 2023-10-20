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
		Curso curso = buscarCurso();
		if (alumno != null && curso != null) {
			HashMap<String, Alumno> alumnos = GestorDatos.getListaAlum();
			HashMap<String, Curso> cursos = GestorDatos.getListaCursos();
		}
	}

	public void desmatricularAlumno() {
		// buscar alumno, buscar curso if not null pedir lista y desmatricular de la
		// lista y mandar a
		// escribir Alumnosssss
		Alumno alumno = buscarAlumno();
		Curso curso = buscarCurso();
		if (alumno != null && curso != null) {
			HashMap<String, Alumno> alumnos = GestorDatos.getListaAlum();
			HashMap<String, Curso> cursos = GestorDatos.getListaCursos();
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
								if (5 == 5) {
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
		// buscar alumno if not null pedir lista pedir lista cursos , borrar de cursos y
		// borrar de la lista y mandar a
		// escribir Alumnosssss y cursossss
		Alumno alumno = buscarAlumno();
		if (alumno != null) {
			HashMap<String, Alumno> alumnos = GestorDatos.getListaAlum();
		}

	}

	public void modificarAlumno() {
		// buscar alumno if not null pedir lista y modificar alumno de la lista y mandar
		// a escribir Alumnosssss
		String nombreAlum=null;
		String apellidosAlum=null;
		String direccionAlum=null;
		String telefonoAlum=null;
		String fechaNacimientoAlum=null;
		
		
		
		
		
		
		Alumno alumno = buscarAlumno();
		Alumno alumno2 =null;
		Alumno alumno3= alumno;
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
								if(apellidosAlum!=null) {
									alumno2 = confirmarInexistenciaAlumno(nombreAlum, apellidosAlum);
								}else {
									alumno2 = confirmarInexistenciaAlumno(nombreAlum, alumno3.getApellidos());
								}
								if (alumno2 == null) {
									alumno3.setNombre(nombreAlum);
								}else{
									System.out.println("El nombre y apellido del alumno coinciden con los de otro alumno, porfavor cambie el apellido o el nombre");
								}
							}
							break;
						case "2":
							System.out.println("Introduzca los apellidos del alumno");
							apellidosAlum = Utiles.scanPalabras();
							if (apellidosAlum != null) {
									if(nombreAlum!=null) {
										alumno2 = confirmarInexistenciaAlumno(nombreAlum, apellidosAlum);
									}else {
										alumno2 = confirmarInexistenciaAlumno(alumno3.getNombre(), apellidosAlum);
									}
									if (alumno2 == null) {
										alumno3.setApellidos(apellidosAlum);
									}else{
										System.out.println("El nombre y apellido del alumno coinciden con los de otro alumno, porfavor cambie el apellido o el nombre");
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
									}else {
										System.out.println("El nombre y apellido del alumno coinciden con los de otro alumno, porfavor cambie el apellido o el nombre");
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
					
				}
			}
		}

	}

	public Alumno confirmarInexistenciaAlumno(String nombreAlum, String apellidosAlum) {

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
		HashMap<String, Alumno> alumnos = GestorDatos.getListaAlum();
		for (HashMap.Entry<String, Alumno> entry : alumnos.entrySet()) {
			System.out.println(entry.getValue().toString());
		}
	}

}
