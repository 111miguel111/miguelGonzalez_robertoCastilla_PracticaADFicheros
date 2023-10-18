package gestores;

import java.util.HashMap;

import clases.Alumno;
import clases.Curso;
import clases.Profesor;

public class GestorDatos {
	// baja, modificar, relacionar fuera
	// alta, buscar, mostrar todos
	// cursos en txt

	// metodos para comprobar si el archivo existe y si no crearlos
	public static void AlumFileCheck() {

	}

	public static void ProfFileCheck() {

	}

	public static void CursoFileCheck() {

	}

	// metodos para serializar todos los datos

	public static void EscribirTodosAlum(HashMap<String, Alumno> listaAlum) {

	}

	public static void EscribirTodosProf(HashMap<String, Profesor> listaProf) {

	}

	public static void EscribirTodosCursos(HashMap<String, Curso> listaCursos) {

	}

	// metodos para serializar un dato
	public static void EscribirAlum(Alumno alumno) {

	}

	public static void EscribirProf(Profesor profesor) {

	}

	public static void EscribirCurso(Curso curso) {

	}

	// metodos para buscar un dato

	public static Alumno BuscarAlum(String nombre, String apellidos) {
		Alumno alumno = null;
		return alumno;
	}

	public static Profesor BuscarProf(String dni) {
		Profesor profesor = null;
		return profesor;
	}

	public static Curso BuscarCurso(String nombre) {
		Curso curso = null;
		return curso;
	}

	// metodos para enviar lista
	public static HashMap<String, Alumno> BuscarAlum() {
		HashMap<String, Alumno> listaAlum = null;
		return listaAlum;
	}

	public static HashMap<String, Profesor> BuscarProf() {
		HashMap<String, Profesor> listaProf = null;
		return listaProf;
	}

	public static HashMap<String, Curso> BuscarCurso() {
		HashMap<String, Curso> listaCurso = null;
		return listaCurso;
	}

}
