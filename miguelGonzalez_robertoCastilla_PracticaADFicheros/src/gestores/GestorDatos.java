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
	public static void alumFileCheck() {

	}

	public static void profFileCheck() {

	}

	public static void cursoFileCheck() {

	}

	// metodos para serializar todos los datos

	public static void escribirTodosAlum(HashMap<String, Alumno> listaAlum) {

	}

	public static void escribirTodosProf(HashMap<String, Profesor> listaProf) {

	}

	public static void escribirTodosCursos(HashMap<String, Curso> listaCursos) {

	}

	// metodos para serializar un dato
	public static void escribirAlum(Alumno alumno) {

	}

	public static void escribirProf(Profesor profesor) {

	}

	public static void escribirCurso(Curso curso) {

	}

	// metodos para buscar un dato

	public static Alumno buscarAlum(String nombre, String apellidos) {
		Alumno alumno = null;
		return alumno;
	}

	public static Profesor buscarProf(String dni) {
		Profesor profesor = null;
		return profesor;
	}

	public static Curso buscarCurso(String nombre) {
		Curso curso = null;
		return curso;
	}

	// metodos para enviar lista
	public static HashMap<String, Alumno> getListaAlum() {
		HashMap<String, Alumno> listaAlum = null;
		return listaAlum;
	}

	public static HashMap<String, Profesor> getListaProf() {
		HashMap<String, Profesor> listaProf = null;
		return listaProf;
	}

	public static HashMap<String, Curso> getListaCursos() {
		HashMap<String, Curso> listaCurso = null;
		return listaCurso;
	}

}
