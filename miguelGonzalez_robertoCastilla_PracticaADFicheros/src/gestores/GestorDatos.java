package gestores;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import clases.Alumno;
import clases.Curso;
import clases.Profesor;
import principal.Utiles;

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
			salida.write(Alumno.getCont());
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
			bw.write(Curso.getCont());
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

	// No se que hace el cuarto catch pero me da cosa quitarlo sin probarlo
	public static Alumno buscarAlum(String nombre, String apellidos) {
		Alumno alumno = null;
		alumFileCheck();
		ObjectInputStream entrada = null;
		try {
			entrada = new ObjectInputStream(new FileInputStream("alumnos.ser"));
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
		} finally {
			try {
				entrada.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return alumno;
	}

	public static Profesor buscarProf(String dni) {
		Profesor profesor = null;
		profFileCheck();
		ObjectInputStream entrada = null;
		try {
			entrada = new ObjectInputStream(new FileInputStream("alumnos.ser"));
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
		} finally {
			try {
				entrada.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return profesor;
	}

	public static Curso buscarCurso(String nombre) {
		Curso curso = null;
		FileReader fr;
		try {
			fr = new FileReader("cursos.txt");
			Scanner sc = new Scanner("cursos.txt");
			while (sc.hasNextLine()) {
				String cursoTexto = sc.nextLine();
				String cursoAlum = sc.nextLine();
				String cursoProf = sc.nextLine();
				if (cursoTexto.split("¬")[1].equals(nombre)) {
					curso = new Curso(cursoTexto.split("¬")[1], cursoTexto.split("¬")[2]);
					curso.setCodigo(cursoTexto.split("¬")[0]);
					curso.setProfesor(new Profesor(cursoProf.split("¬")[0], cursoProf.split("¬")[1],
							cursoProf.split("¬")[2], cursoProf.split("¬")[3]));
					HashMap<String, Alumno> listaAlum = new HashMap<String, Alumno>();
					for (int i = 0; i < cursoAlum.split("¬").length; i++) {
						listaAlum.put(cursoAlum.split("¬")[i] + "_" + cursoAlum.split("¬")[i + 1],
								new Alumno(cursoAlum.split("¬")[i], cursoAlum.split("¬")[i + 1],
										cursoAlum.split("¬")[i + 2], cursoAlum.split("¬")[i + 3],
										cursoAlum.split("¬")[+4]));
						i += 5;
					}
					curso.setAlumnos(listaAlum);
					return curso;
				}
			}
			sc.close();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return curso;

	}

	// metodos para enviar lista
	public static HashMap<String, Alumno> getListaAlum() {
		HashMap<String, Alumno> listaAlum = new HashMap<String, Alumno>();
		alumFileCheck();
		ObjectInputStream entrada = null;
		try {
			entrada = new ObjectInputStream(new FileInputStream("alumnos.ser"));
			try {
				Alumno.setCont(entrada.readInt());
				while (true) {
					Alumno alumno = (Alumno) entrada.readObject();
					listaAlum.put(alumno.getNombre() + "_" + alumno.getApellidos(), alumno);
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
		} finally {
			try {
				entrada.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return listaAlum;
	}

	public static HashMap<String, Profesor> getListaProf() {
		HashMap<String, Profesor> listaProf = new HashMap<String, Profesor>();
		profFileCheck();
		ObjectInputStream entrada = null;
		try {
			entrada = new ObjectInputStream(new FileInputStream("alumnos.ser"));
			try {
				while (true) {
					Profesor profesor = (Profesor) entrada.readObject();
					listaProf.put(profesor.getDni(), profesor);
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
		} finally {
			try {
				entrada.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return listaProf;
	}

	public static HashMap<String, Curso> getListaCursos() {
		HashMap<String, Curso> listaCurso = new HashMap<String,Curso>();
		FileReader fr;
		try {
			fr = new FileReader("cursos.txt");
			Scanner sc = new Scanner("cursos.txt");
			if (sc.hasNextLine()) {
				String contador = sc.nextLine();
				if (Utiles.esDigito(contador)) {
					Curso.setCont(Integer.parseInt(contador));
				}else {
					Curso.setCont(0);
				}
			}
			while (sc.hasNextLine()) {
				String cursoTexto = sc.nextLine();
				String cursoAlum = sc.nextLine();
				String cursoProf = sc.nextLine();
				Curso curso = new Curso(cursoTexto.split("¬")[1], cursoTexto.split("¬")[2]);
				curso.setCodigo(cursoTexto.split("¬")[0]);
				curso.setProfesor(new Profesor(cursoProf.split("¬")[0], cursoProf.split("¬")[1],
						cursoProf.split("¬")[2], cursoProf.split("¬")[3]));
				HashMap<String, Alumno> listaAlum = new HashMap<String, Alumno>();
				for (int i = 0; i < cursoAlum.split("¬").length; i++) {
					listaAlum.put(cursoAlum.split("¬")[i] + "_" + cursoAlum.split("¬")[i + 1],
							new Alumno(cursoAlum.split("¬")[i], cursoAlum.split("¬")[i + 1],
									cursoAlum.split("¬")[i + 2], cursoAlum.split("¬")[i + 3],
									cursoAlum.split("¬")[+4]));
					i += 5;
				}
				curso.setAlumnos(listaAlum);
				listaCurso.put(curso.getNombre(), curso);
			}
			sc.close();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return listaCurso;
	}

}
