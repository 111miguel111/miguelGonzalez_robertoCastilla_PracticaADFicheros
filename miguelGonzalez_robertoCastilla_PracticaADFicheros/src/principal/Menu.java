package principal;

import clases.Curso;
import gestores.*;

public class Menu {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Inicio del programa.");
		GestorDatos.setContadores();
		boolean check = true;
		do {
			System.out.println("Seleccione con que desea trabajar:\n1.Alumnos\n2.Profesores\n3.Cursos\n0.Salir");
			String opcion = Utiles.scanLibre();
			switch (opcion) {
			case "1":
				menuAlumno();
				break;
			case "2":
				menuProfesor();
				break;
			case "3":
				menuCurso();
				break;
			case "0":
				check = false;
				break;
			default:
				System.out.println("Valor no valido.");
			}
		} while (check);
		System.out.println("Fin del programa");
	}

	private static void menuAlumno() {
		boolean check = true;
		do {
			System.out.println("\nSeleccione con que opcion de alumnos desea trabajar:\n1.Crear Alumno\t\t4.Matricular Alumno\t7.Mostrar Todos Alumnos"
					+ "\n2.Borrar Alumno\t\t5.Desmatricular Alumno\n3.Modificar Alumno\t6.Buscar Alumno\n0.Salir");
			String opcion = Utiles.scanLibre();
			switch (opcion) {
			case "1":
				GestorAlumnos.crearAlumno();
				break;
			case "2":
				GestorAlumnos.borrarAlumno();
				break;
			case "3":
				GestorAlumnos.modificarAlumno();
				break;
			case "4":
				GestorAlumnos.matricularAlumno();
				break;
			case "5":
				GestorAlumnos.desmatricularAlumno();
				break;
			case "6":
				GestorAlumnos.mostrarAlumno();
				break;
			case "7":
				GestorAlumnos.mostrarAlumnos();
				break;
			case "0":
				check = false;
				break;
			default:
				System.out.println("\nValor no valido.");
			}
		} while (check);
		System.out.println();
	}
	
	private static void menuCurso() {
		boolean check = true;
		do {
			System.out.println("\nSeleccione con que opcion de cursos desea trabajar:\n1.Crear Curso\t\t4.Matricular Alumno"
					+ "\t7.Desvincular Profesor\n2.Borrar Curso\t\t5.Desmatricular Alumno\t8.Buscar Curso\n3.Modificar Curso"
					+ "\t6.Vincular Profesor\t9.Mostrar Todos Cursos\n0.Salir");
			String opcion = Utiles.scanLibre();
			switch (opcion) {
			case "1":
				GestorCursos.crearCurso();
				break;
			case "2":
				GestorCursos.borrarCurso();
				break;
			case "3":
				GestorCursos.modificarCurso();
				break;
			case "4":
				GestorCursos.matricularAlumno();
				break;
			case "5":
				GestorCursos.desmatricularAlumno();
				break;
			case "6":
				GestorCursos.vincularProfesor();
				break;
			case "7":
				GestorCursos.desvincularProfesor();
				break;
			case "8":
				GestorCursos.mostrarCurso();
				break;
			case "9":
				GestorCursos.mostrarCursos();
				break;
			case "0":
				check = false;
				break;
			default:
				System.out.println("\nValor no valido.");
			}
		} while (check);
		System.out.println();
	}
	private static void menuProfesor() {
		boolean check = true;
		do {
			System.out.println("\nSeleccione con que opcion de profesores desea trabajar:\n1.Crear Profesor\t4.Vincular Curso\t7.Mostrar Todos Profesores"
					+ "\n2.Borrar Profesor\t5.Desvincular Curso\n3.Modificar Profesor\t6.Buscar Profesor\n0.Salir");
			String opcion = Utiles.scanLibre();
			switch (opcion) {
			case "1":
				GestorProfesores.crearProfesor();
				break;
			case "2":
				GestorProfesores.borrarProfesor();
				break;
			case "3":
				GestorProfesores.modificarProfesor();
				break;
			case "4":
				GestorProfesores.vincularProfesor();
				break;
			case "5":
				GestorProfesores.desvincularProfesor();
				break;
			case "6":
				GestorProfesores.mostrarProfesor();
				break;
			case "7":
				GestorProfesores.mostrarProfesores();
				break;
			case "0":
				check = false;
				break;
			default:
				System.out.println("\nValor no valido.");
			}
		} while (check);
		System.out.println();
	}

}
