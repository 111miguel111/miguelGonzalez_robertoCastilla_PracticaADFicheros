package principal;

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
			System.out.println("Seleccione con que opcion de alumnos desea trabajar:\n1.Crear Alumno\n2.Borrar Alumno\n3.Modificar Alumno\n4.Matricular Alumno"
					+ "\n5.Desmatricular Alumno\n6.Mostrar Alumno\n7.Mostrar Alumnos\n0.Salir");
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
				System.out.println("Valor no valido.");
			}
		} while (check);
	}
	
	private static void menuCurso() {
		boolean check = true;
		do {
			System.out.println("Seleccione con que opcion de cursos desea trabajar:\n1.Crear Curso\n2.Borrar Curso\n3.Modificar Curso\n4.Matricular Alumno"
					+ "\n5.Desmatricular Alumno\n6.Vincular Profesor\n7.Desvincular Profesor\n8.Mostrar Curso\n9.Mostrar Cursos\n0.Salir");
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
				System.out.println("Valor no valido.");
			}
		} while (check);
	}
	private static void menuProfesor() {
		boolean check = true;
		do {
			System.out.println("Seleccione con que opcion de profesores desea trabajar:\n1.Crear Profesor\n2.Borrar Profesor\n3.Modificar Profesor\n4.Vincular Curso"
					+ "\n5.Desvincular Curso\n6.Mostrar Profesor\n7.Mostrar Profesores\n0.Salir");
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
				System.out.println("Valor no valido.");
			}
		} while (check);
	}

}
