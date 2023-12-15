package gestores;

import java.io.BufferedWriter;
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
import java.util.NoSuchElementException;
import java.util.Scanner;

import clases.Alumno;
import clases.Curso;
import clases.Profesor;
import principal.Utiles;

public class GestorDatos {
	static File archivoAlum = new File("alumnos.ser");
	static File archivoProf = new File("profesores.ser");
	static File archivoCurso = new File("cursos.txt");

	// Metodos de alumno -------------------------------------------------

	/**
	 * Metodo que comprueba si existe el archivo de alumnos y si no existe lo crea
	 */
	public static void alumFileCheck() {
		if (!archivoAlum.exists()) {
			try {
				archivoAlum.createNewFile();
			} catch (IOException e) {
				System.out.println("Error al crear el archivo");
			}
		}
	}

	/**
	 * Metodo para escribir un alumno
	 * 
	 * @param alumno Alumno a escribir
	 */
	public static void escribirAlum(Alumno alumno) {
		// Se trae la lista y se le agrega el alumno nuevo para enviarlo a escribir la
		// lista entera
		HashMap<String, Alumno> listaAlum = getListaAlum();
		listaAlum.put(alumno.getNombre() + "_" + alumno.getApellidos(), alumno);
		escribirTodosAlum(listaAlum);
	}

	/**
	 * Metodo para escribir todos los alumnos
	 * 
	 * @param listaAlum HashMap con todos los alumnos
	 */
	public static void escribirTodosAlum(HashMap<String, Alumno> listaAlum) {
		// En un try se crea el file output y el object output
		try {
			FileOutputStream fileOut = new FileOutputStream(archivoAlum);
			ObjectOutputStream salida = new ObjectOutputStream(fileOut);

			// Se escribe el contador de alumnos
			salida.writeInt(Alumno.getCont());
			// Se recorre la lista de alumnos y se escriben todos
			for (Map.Entry<String, Alumno> i : listaAlum.entrySet()) {
				salida.writeObject(i.getValue());
			}
			// Se cierran el fileOutput y el object output
			salida.close();
			fileOut.close();

		} catch (IOException e) {
			System.out.println("Error al escribir el archivo");
		}
	}

	/**
	 * Metodo que busca un alumno
	 * 
	 * @param nombre    String del nombre del alumno
	 * @param apellidos String de los apellidos del alumno
	 * @return Alumno deseado o null si no lo encuentra
	 */
	public static Alumno buscarAlum(String nombre, String apellidos) {
		// Se define un alumno en el que guardaremos el alumno deseado
		Alumno alumno = null;
		// Se comprueba si el archivo existe
		alumFileCheck();
		// Se crea el object input stream y se abre un try para trabajar con el
		ObjectInputStream entrada = null;
		try {
			// Se define el object input stream
			entrada = new ObjectInputStream(new FileInputStream(archivoAlum));

			// Se salta la linea del contador de alumnos del archivo
			entrada.readInt();
			// Se busca en el archivo el alumno hasta que lo encuentre o hasta que no queden
			// mas
			while (true) {
				Alumno alumnoAux = (Alumno) entrada.readObject();
				// Se comprueba si el alumno coincide y si coincide se guarda en la variable
				// creada anteriormente
				if (nombre.equalsIgnoreCase(alumnoAux.getNombre())
						&& apellidos.equalsIgnoreCase(alumnoAux.getApellidos())) {
					alumno = alumnoAux;
				}

			}
		} catch (IOException e) {
		} catch (ClassNotFoundException e) {
			System.out.println("Error al leer el archivo: Objeto inesperado encontrado en lectura");
		} finally {
			try {
				if (entrada != null) {
					entrada.close();
				}
			} catch (IOException e) {
				System.out.println("Esta en null el ObjectInputStream");
			}
		}
		// Si no se encuentra al alumno se devuelve un null
		return alumno;
	}

	/**
	 * Metodo que devuelve una lista de alumnos
	 * 
	 * @return Hashmap con todos los alumnos
	 */
	public static HashMap<String, Alumno> getListaAlum() {
		HashMap<String, Alumno> listaAlum = new HashMap<String, Alumno>();
		// Se comprueba si el archivo existe
		alumFileCheck();
		// Se crea el object input stream y se abre un try para trabajar con el
		ObjectInputStream entrada = null;
		try {
			// Se define el object input stream
			entrada = new ObjectInputStream(new FileInputStream("alumnos.ser"));
			// Se salta la linea del contador de alumnos del archivo
			entrada.readInt();
			// Se leen todos los alumnos y se meten en un hashmap
			while (true) {
				Alumno alumno = (Alumno) entrada.readObject();
				listaAlum.put(alumno.getNombre() + "_" + alumno.getApellidos(), alumno);
			}
		} catch (FileNotFoundException e) {
			System.out.println("No se ha encontrado el archivo");
		} catch (IOException e2) {
			//System.out.println("Fichero vacio");
		} catch (ClassNotFoundException e) {
			System.out.println("Error al leer el archivo: Objeto inesperado encontrado en lectura");
		} finally {
			try {
				if (entrada != null) {
					entrada.close();
				}
			} catch (IOException e) {
				// e.printStackTrace();
			}
		}
		return listaAlum;
	}

	// Metodos profesores ------------------------------------------------

	/**
	 * Metodo que comprueba si existe el archivo de profesores y si no existe lo
	 * crea
	 */
	public static void profFileCheck() {
		if (!archivoProf.exists()) {
			try {
				archivoProf.createNewFile();
			} catch (IOException e) {
				System.out.println("Error al crear el archivo");
			}
		}
	}

	/**
	 * Metodo para escribir todos los profesores
	 * 
	 * @param listaProf HashMap con todos los profesores
	 */
	public static void escribirTodosProf(HashMap<String, Profesor> listaProf) {
		// En un try se crea el file output y el object output
		try {
			FileOutputStream fileOut = new FileOutputStream(archivoProf);
			ObjectOutputStream salida = new ObjectOutputStream(fileOut);
			// Se recorre la lista de alumnos y se escriben todos
			for (Map.Entry<String, Profesor> i : listaProf.entrySet()) {
				salida.writeObject(i.getValue());
			}
			// Se cierran el fileOutput y el object output
			salida.close();
			fileOut.close();
		} catch (IOException e) {
			System.out.println("Error al escribir el archivo");
		}
	}

	/**
	 * Metodo para escribir un profesor
	 * 
	 * @param profesor Profesor a escribir
	 */
	public static void escribirProf(Profesor profesor) {
		// Se trae la lista y se le agrega el profesor nuevo para enviarlo a escribir la
		// lista entera
		HashMap<String, Profesor> listaProf = getListaProf();
		listaProf.put(profesor.getDni(), profesor);
		escribirTodosProf(listaProf);
	}

	/**
	 * Metodo que busca un profesor
	 * 
	 * @param dni DNI del profesor a buscar
	 * @return Profesor deseado o null si no lo encuentra
	 */
	public static Profesor buscarProf(String dni) {
		// Se crea una variable para guardar el profesor
		Profesor profesor = null;
		// Se comprueba que el archivo existe
		profFileCheck();
		// Se crea el object input stream y se abre un try para trabajar con el
		ObjectInputStream entrada = null;
		try {
			// Se define el object input stream
			entrada = new ObjectInputStream(new FileInputStream(archivoProf));
			// Se busca en el archivo el profesor hasta que lo encuentre o hasta que no
			// queden mas
			while (true) {
				Profesor profesorAux = (Profesor) entrada.readObject();
				// Se comprueba si el profesor coincide y si coincide se guarda en la variable
				// creada anteriormente
				if (dni.equalsIgnoreCase(profesorAux.getDni())) {
					profesor = profesorAux;
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println("No se ha encontrado el archivo");
		} catch (IOException e2) {
			//System.out.println("Fichero vacio");
			// e2.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.out.println("Error al leer el archivo: Objeto inesperado encontrado en lectura");
		} finally {
			try {
				if (entrada != null) {
					entrada.close();
				}
			} catch (Exception e) {
				// e.printStackTrace();
				System.out.println("No se pudo cerrar el ObjectInputStream");
			}
		}
		// Si no se encuentra al profesor se devuelve un null
		return profesor;
	}

	/**
	 *  Metodo que busca todos los profesores
	 * @return HashMap con todos los profesores en el archivo
	 */
	public static HashMap<String, Profesor> getListaProf() {
		HashMap<String, Profesor> listaProf = new HashMap<String, Profesor>();
		profFileCheck();
		ObjectInputStream entrada = null;
		try {
			entrada = new ObjectInputStream(new FileInputStream(archivoProf));
			// Se leen profesores y se meten en la lista
			while (true) {
				Profesor profesor = (Profesor) entrada.readObject();
				listaProf.put(profesor.getDni(), profesor);
			}
		} catch (FileNotFoundException e) {
			System.out.println("No se ha encontrado el archivo");
		} catch (IOException e2) {
			//System.out.println("Fichero vacio");
			// e2.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.out.println("Error al leer el archivo: Objeto inesperado encontrado en lectura");
		} finally {
			try {
				if (entrada != null) {
					entrada.close();
				}
			} catch (Exception e) {
				System.out.println("No se pudo cerrar el ObjectInputStream");
			}
		}
		return listaProf;
	}

	// Metodos cursos-----------------------------------------------------

	/**
	 * Metodo que comprueba si existe el archivo de cursos y si no existe lo crea
	 */
	public static void cursoFileCheck() {
		if (!archivoCurso.exists()) {
			try {
				archivoCurso.createNewFile();
			} catch (IOException e) {
				System.out.println("Error al crear el archivo");
			}
		}
	}

	/**
	 * Metodo para escribir todos los cursos
	 * 
	 * @param listaCursos HashMap con todos los cursos
	 */
	public static void escribirTodosCursos(HashMap<String, Curso> listaCursos) {
		// En un try se crean el printwriter y el bufferedwriter
		try {
			PrintWriter myWriter = new PrintWriter(archivoCurso);
			BufferedWriter bw = new BufferedWriter(myWriter);

			// Se escribe el contador estatico de cursos
			bw.write(Curso.getCont() + "\n");

			// Se recorre la lista de cursos escribiendo cada valor de forma individual
			for (Map.Entry<String, Curso> i : listaCursos.entrySet()) {
				bw.write(i.getValue().toStringDatos());
			}
			// Se cierran el printWriter y el bufferedWriter
			bw.close();
			myWriter.close();
			System.out.println("Se ha escrito en el archivo");
		} catch (IOException e) {
			System.out.println("Error al escribir el archivo");
			// e.printStackTrace();
		}
	}

	/**
	 * Metodo para escribir un curso
	 * 
	 * @param curso Curso a escribir
	 */
	public static void escribirCurso(Curso curso) {
		// Se trae la lista y se le agrega el cursos nuevo para enviarlo a escribir la
		// lista entera
		HashMap<String, Curso> listaCursos = getListaCursos();
		listaCursos.put(curso.getNombre(), curso);
		escribirTodosCursos(listaCursos);
	}

	/**
	 * Metodo que busca un curso
	 * 
	 * @param nombre String del nombre del curso
	 * @return Curso deseado o null si no lo encuentra
	 */
	public static Curso buscarCurso(String nombre) {
		Curso curso = null;
		try {
			Scanner sc = new Scanner(archivoCurso);
			// Saltar contador
			if (sc.hasNextLine()) {
				sc.nextLine();
			}
			// Se va leyendo el archivo de 3 en 3, ya que el contenido de cada curso se ha
			// escrito en 3 lineas
			while (sc.hasNextLine()) {
				String cursoTexto = sc.nextLine();
				String cursoAlum = sc.nextLine();
				String cursoProf = sc.nextLine();
				// Se comprueba el nombre del curso es el nombre que se busca
				if (cursoTexto.split("¬")[1].equals(nombre)) {
					curso = new Curso(cursoTexto.split("¬")[1], cursoTexto.split("¬")[2]);
					curso.setCodigo(cursoTexto.split("¬")[0]);
					// Se comprueba que el texto de profesor no sea un campo vacio y se crea
					if (cursoProf != "") {
						curso.setProfesor(new Profesor(cursoProf.split("¬")[0], cursoProf.split("¬")[1],
								cursoProf.split("¬")[2], cursoProf.split("¬")[3]));
					}
					// Se crea el hashmap y se comprueba que haya alumnos, si los hay se introducen
					// 1 a 1
					HashMap<String, Alumno> listaAlum = new HashMap<String, Alumno>();
					if (cursoAlum != "") {
						// En las lineas de texto los alumnos ocupan 5 campos asi que se suman de 5 en 5
						for (int i = 0; i < cursoAlum.split("¬").length; i++) {
							listaAlum.put(cursoAlum.split("¬")[i] + "_" + cursoAlum.split("¬")[i + 1],
									new Alumno(cursoAlum.split("¬")[i], cursoAlum.split("¬")[i + 1],
											cursoAlum.split("¬")[i + 2], cursoAlum.split("¬")[i + 3],
											cursoAlum.split("¬")[+4]));
							i += 5;
						}
					}
					// Se guardan los alumnos en el curso
					curso.setAlumnos(listaAlum);
					sc.close();
					return curso;
				}
			}
			sc.close();
		} catch (FileNotFoundException e1) {
			System.out.println("No se ha encontrado el archivo");
			//e1.printStackTrace();
		}
		return curso;

	}

	/**
	 * Metodo que devuelve un HashMap con todos los cursos
	 * 
	 * @return HashMap con todos los cursos
	 */
	public static HashMap<String, Curso> getListaCursos() {
		HashMap<String, Curso> listaCurso = new HashMap<String, Curso>();
		try {
			Scanner sc = new Scanner(archivoCurso);
			// Saltar contador
			if (sc.hasNextLine()) {
				sc.nextLine();
			}
			// Se va leyendo el archivo de 3 en 3, ya que el contenido de cada curso se ha
			// escrito en 3 lineas
			while (sc.hasNextLine()) {
				String cursoTexto = sc.nextLine();
				String cursoAlum = sc.nextLine();
				String cursoProf = sc.nextLine();
				// Se comprueba si curso esta vacio y si no lo esta se crea el curso
				if (cursoTexto != "") {
					Curso curso = new Curso(cursoTexto.split("¬")[1], cursoTexto.split("¬")[2]);
					curso.setCodigo(cursoTexto.split("¬")[0]);
					// Se comprueba si la linea del profesor esta vacio y si no lo crea y agrega al
					// curso
					if (cursoProf != "") {
						curso.setProfesor(new Profesor(cursoProf.split("¬")[0], cursoProf.split("¬")[1],
								cursoProf.split("¬")[2], cursoProf.split("¬")[3]));
					}
					HashMap<String, Alumno> listaAlum = new HashMap<String, Alumno>();
					// Se comprueba si la linea de alumno esta vacio y si no lo crea y agrega todos
					// los alumnos a un hasmap, que posteriormente se agregaga al curso
					if (cursoAlum != "") {
						// En las lineas de texto los alumnos ocupan 5 campos asi que se suman de 5 en 5
						for (int i = 0; i < cursoAlum.split("¬").length; i++) {
							listaAlum.put(cursoAlum.split("¬")[i] + "_" + cursoAlum.split("¬")[i + 1],
									new Alumno(cursoAlum.split("¬")[i], cursoAlum.split("¬")[i + 1],
											cursoAlum.split("¬")[i + 2], cursoAlum.split("¬")[i + 3],
											cursoAlum.split("¬")[+4]));
							i += 5;
						}
					}
					curso.setAlumnos(listaAlum);
					listaCurso.put(curso.getNombre(), curso);
				}
			}
			sc.close();
		} catch (FileNotFoundException e1) {
			//e1.printStackTrace();
			System.out.println("No se ha encontrado el archivo");
		}
		return listaCurso;
	}

	// Otros-------------------------------------------
	
	/**
	 * Metodo para cargar los contadores de Alumno y Curso para numero de expediente
	 * y codigo respectivamente
	 */
	public static void setContadores() {
		// Se comprueba que existatn los archivos de alumno y curso
		alumFileCheck();
		cursoFileCheck();
		ObjectInputStream entrada = null;
		Scanner sc = null;
		try {
			// Se lee el primer y unico int del fichero de alumno que es el contador y se
			// guarda
			entrada = new ObjectInputStream(new FileInputStream(archivoAlum));
			Alumno.setCont((int) entrada.readInt());
		} catch (IOException e) {
			System.out.println("No se han podido cargar los contadores");
		} finally {
			if (entrada != null) {
				try {
					entrada.close();
				} catch (IOException e) {
					// e.printStackTrace();
					System.out.println("Error al cerrar object input stream");
				}
			}
		}
		try {
			// Se lee la primera linea del archivo que es el contador y se comprueba que sea
			// digito antes de guardarlo
			sc = new Scanner(archivoCurso);
			String contador = sc.nextLine();
			if (Utiles.esDigito(contador)) {
				Curso.setCont(Integer.parseInt(contador));
			}

		} catch (IOException e) {
			System.out.println("No se han podido cargar los contadores");
		} catch (NoSuchElementException e) {
			System.out.println("Contador vacio");
		} finally {
			if (entrada != null) {
				try {
					entrada.close();
				} catch (IOException e) {
					// e.printStackTrace();
					System.out.println("Error al cerrar object input stream");
				}
			}
		}
	}
}
