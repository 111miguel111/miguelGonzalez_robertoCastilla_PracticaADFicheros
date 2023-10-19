package gestores;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import clases.Alumno;
import clases.Curso;
import clases.Profesor;

public class GestorDatos {
	// baja, modificar, relacionar fuera
	// alta, buscar, mostrar todos
	// cursos en txt
	File archivoAlum = new File("alumnos.ser");
	File archivoProf = new File("profesores.ser");
	File archivoCurso = new File("cursos.txt");

	// metodos para comprobar si el archivo existe y si no crearlos
	public static void alumFileCheck() {
		File archivoAlum = new File("alumnos.ser");
		if (!archivoAlum.exists()) {
			try {
				archivoAlum.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("Error al crear el archivo");
			}
		}
	}

	public static void profFileCheck() {
		File archivoProf = new File("profesor.ser");
		if (!archivoProf.exists()) {
			try {
				archivoProf.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("Error al crear el archivo");
			}
		}
	}

	public static void cursoFileCheck() {
		File archivoCurso = new File("cursos.txt");
		if (!archivoCurso.exists()) {
			try {
				archivoCurso.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("Error al crear el archivo");
			}
		}
	}

	// metodos para serializar todos los datos

	public static void escribirTodosAlum(HashMap<String, Alumno> listaAlum) {
		try {
			FileOutputStream fileOut = new FileOutputStream("alumnos.ser");
			ObjectOutputStream salida = new ObjectOutputStream(fileOut);
			for (Map.Entry<String, Alumno> i : listaAlum.entrySet()) {
				salida.writeObject(i.getValue());
			}
			salida.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Error al escribir el archivo");
		}
	}

	public static void escribirTodosProf(HashMap<String, Profesor> listaProf) {
		try {
			FileOutputStream fileOut = new FileOutputStream("profesores.ser");
			ObjectOutputStream salida = new ObjectOutputStream(fileOut);
			for (Map.Entry<String, Profesor> i : listaProf.entrySet()) {
				salida.writeObject(i.getValue());
			}
			salida.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Error al escribir el archivo");
		}
	}

	// Los alumnos los devuelve como string cuidado
	public static void escribirTodosCursos(HashMap<String, Curso> listaCursos) {
		try {
			PrintWriter myWriter = new PrintWriter("archivo.txt");
			BufferedWriter bw = new BufferedWriter(myWriter);
			for (Map.Entry<String, Curso> i : listaCursos.entrySet()) {
				bw.write(i.getValue().getCodigo());
				bw.write(i.getValue().getNombre());
				bw.write(i.getValue().getDescripcion());
				for (Map.Entry<String, Alumno> j : i.getValue().getAlumnos().entrySet()) {
					bw.write(j.getValue().toString());
				}
				bw.write(i.getValue().getProfesorString());
			}
			bw.close();
			myWriter.close();
			System.out.println("Se ha escrito en el archivo");
		} catch (IOException e) {
			System.out.println("Error");
			e.printStackTrace();
		}
	}

	// metodos para serializar un dato
	public static void escribirAlum(Alumno alumno) {
		HashMap<String, Alumno> listaAlum = getListaAlum();
		listaAlum.put(alumno.getNombre() + "_" + alumno.getApellidos(), alumno);
		escribirTodosAlum(listaAlum);
	}

	public static void escribirProf(Profesor profesor) {
		HashMap<String, Profesor> listaProf = getListaProf();
		listaProf.put(profesor.getDni(), profesor);
		escribirTodosProf(listaProf);
	}

	public static void escribirCurso(Curso curso) {
		HashMap<String, Curso> listaCursos = getListaCursos();
		listaCursos.put(curso.getNombre(), curso);
		escribirTodosCursos(listaCursos);
	}

	// metodos para buscar un dato

	//No se que hace el cuarto catch pero me da cosa quitarlo sin probarlo
	public static Alumno buscarAlum(String nombre, String apellidos) {
		Alumno alumno = null;
		alumFileCheck();
		try {
			ObjectInputStream entrada = new ObjectInputStream(new FileInputStream("alumnos.ser"));
			try {
				while (true) {
					Alumno alumnoAux = (Alumno) entrada.readObject();
					if (nombre.equalsIgnoreCase(alumnoAux.getNombre())
							&& apellidos.equalsIgnoreCase(alumnoAux.getApellidos())) {
						alumno = alumnoAux;
					}
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("Fin de lectura");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				System.out.println("Error al leer el archivo: Objeto inesperado encontrado en lectura");
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("No se ha encontrado el archivo");
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		return alumno;
	}

	public static Profesor buscarProf(String dni) {
		Profesor profesor = null;
		alumFileCheck();
		try {
			ObjectInputStream entrada = new ObjectInputStream(new FileInputStream("alumnos.ser"));
			try {
				while (true) {
					Profesor profesorAux = (Profesor) entrada.readObject();
					if (dni.equalsIgnoreCase(profesorAux.getDni())) {
						profesor = profesorAux;
					}
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("Fin de lectura");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				System.out.println("Error al leer el archivo: Objeto inesperado encontrado en lectura");
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("No se ha encontrado el archivo");
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
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
