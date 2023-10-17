package principal;

import java.util.Scanner;

public class Menu {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Inicio del programa.");
		boolean check = true;
		do {
			System.out.println("Seleccione con que desea trabajar:\n1.Alumnos\n2.Profesores\n3.Cursos\n0.Salir");
			String opcion = sc.nextLine();
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

	public static void menuAlumno() {
		boolean check = true;
		do {
			System.out.println("Seleccione con que opcion de alumnos desea trabajar:\n1.Crear Alumno\n2.Borrar Alumno\n3.Modificar Alumno\n4.Matricular Alumno"
					+ "\n5.Desmatricular Alumno\n6.Mostrar Alumno\n7.Mostrar Alumnos\n0.Salir");
			String opcion = sc.nextLine();
			switch (opcion) {
			case "1":
				// crear Alumno		
				break;
			case "2":
				// borrar alumno
				break;
			case "3":
				// modificar alumno
				break;
			case "4":
				//matricular alumno
				break;
			case "5":
				//desmatricular alumno
				break;
			case "6":
				//mostrar alumno
				break;
			case "7":
				//mostrar alumnos
				break;
			case "0":
				check = false;
				break;
			default:
				System.out.println("Valor no valido.");
			}
		} while (check);
	}
	
	public static void menuCurso() {
		boolean check = true;
		do {
			System.out.println("Seleccione con que opcion de cursos desea trabajar:\n1.Crear Curso\n2.Borrar Curso\n3.Modificar Curso\n4.Matricular Alumno"
					+ "\n5.Desmatricular Alumno\n6.Vincular Profesor\n7.Desvincular Profesor\n8.Mostrar Curso\n9.Mostrar Cursos\n0.Salir");
			String opcion = sc.nextLine();
			switch (opcion) {
			case "1":
				// crear curso
				break;
			case "2":
				// borrar curso
				break;
			case "3":
				// modificar curso
				break;
			case "4":
				// matricular alumno
				break;
			case "5":
				// desmatricular alumno
				break;
			case "6":
				// vincular profesor
				break;
			case "7":
				// desvincular profesor
				break;
			case "8":
				// mostrar curso
				break;
			case "9":
				// mostrar cursos
				break;
			case "0":
				check = false;
				break;
			default:
				System.out.println("Valor no valido.");
			}
		} while (check);
	}
	public static void menuProfesor() {
		boolean check = true;
		do {
			System.out.println("Seleccione con que opcion de profesores desea trabajar:\n1.Crear Profesor\n2.Borrar Profesor\n3.Modificar Profesor\n4.Vincular Curso"
					+ "\n5.Desvincular Curso\n6.Mostrar Profesor\n7.Mostrar Profesores\n0.Salir");
			String opcion = sc.nextLine();
			switch (opcion) {
			case "1":
				// crear profesor
				break;
			case "2":
				// borrar profesor
				break;
			case "3":
				// modificar profesor
				break;
			case "4":
				// vincular curso
				break;
			case "5":
				// desvincular curso
				break;
			case "6":
				// mostrar profesor
				break;
			case "7":
				// mostrar profesores
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
