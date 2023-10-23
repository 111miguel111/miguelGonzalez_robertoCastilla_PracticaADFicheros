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
	static File archivoAlum = new File("alumnos.ser");
	static File archivoProf = new File("profesores.ser");
	static File archivoCurso = new File("cursos.txt");

	//Metodos de alumno
	
	//Comprueba si existe el archivo de alumnos y si no existe lo crea
		public static void alumFileCheck() {
			if (!archivoAlum.exists()) {
				try {
					archivoAlum.createNewFile();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					System.out.println("Error al crear el archivo");
				}
			}
		}
		
	// metodos para comprobar si el archivo existe y si no crearlos
	
	

	//Comprueba si existe el archivo de profesores y si no existe lo crea
	public static void profFileCheck() {
		if (!archivoProf.exists()) {
			try {
				archivoProf.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("Error al crear el archivo");
			}
		}
	}

	//Comprueba si existe el archivo de cursos y si no existe lo crea
	public static void cursoFileCheck() {
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

	//Metodo para escribir todos los alumnos
	public static void escribirTodosAlum(HashMap<String, Alumno> listaAlum) {
		//En un try se crea el file output y el object output
		try {
			FileOutputStream fileOut = new FileOutputStream(archivoAlum);
			ObjectOutputStream salida = new ObjectOutputStream(fileOut);
			//Se escribe el contador de alumnos
			salida.writeInt(Alumno.getCont());
			//Se recorre la lista de alumnos y se escriben todos
			for (Map.Entry<String, Alumno> i : listaAlum.entrySet()) {
				salida.writeObject(i.getValue());
			}
			//Se cierran el fileOutput y el object output
			salida.close();
			fileOut.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Error al escribir el archivo");
		}
	}

	//Metodo para escribir todos los profesores
	public static void escribirTodosProf(HashMap<String, Profesor> listaProf) {
		//En un try se crea el file output y el object output
		try {
			FileOutputStream fileOut = new FileOutputStream(archivoProf);
			ObjectOutputStream salida = new ObjectOutputStream(fileOut);
			//Se recorre la lista de alumnos y se escriben todos
			for (Map.Entry<String, Profesor> i : listaProf.entrySet()) {
				salida.writeObject(i.getValue());
			}
			//Se cierran el fileOutput y el object output
			salida.close();
			fileOut.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Error al escribir el archivo");
		}
	}

	//Metodo para escribir todos los cursos 
	public static void escribirTodosCursos(HashMap<String, Curso> listaCursos) {
		//En un try se crean el printwriter y el bufferedwriter
		try {
			PrintWriter myWriter = new PrintWriter(archivoCurso);
			BufferedWriter bw = new BufferedWriter(myWriter);
			
			//Se escribe el contador estatico de cursos
			//bw.write(Curso.getCont());
			
			//Se recorre la lista de cursos escribiendo cada valor de forma individual
			for (Map.Entry<String, Curso> i : listaCursos.entrySet()) {
				bw.write(i.getValue().toStringDatos());
			}
			//Se cierran el printWriter y el bufferedWriter
			bw.close();
			myWriter.close();
			System.out.println("Se ha escrito en el archivo");
		} catch (IOException e) {
			System.out.println("Error al escribir el archivo");
			//e.printStackTrace();
		}
	}

	// metodos para serializar un dato
	
	//Metodo para escribir un alumno
	public static void escribirAlum(Alumno alumno) {
		//Se trae la lista y se le agrega el alumno nuevo para enviarlo a escribir la lista entera
		HashMap<String, Alumno> listaAlum = getListaAlum();
		listaAlum.put(alumno.getNombre() + "_" + alumno.getApellidos(), alumno);
		escribirTodosAlum(listaAlum);
	}

	//Metodo para escribir un profesor
	public static void escribirProf(Profesor profesor) {
		//Se trae la lista y se le agrega el profesor nuevo para enviarlo a escribir la lista entera
		HashMap<String, Profesor> listaProf = getListaProf();
		listaProf.put(profesor.getDni(), profesor);
		escribirTodosProf(listaProf);
	}

	//Metodo para escribir un curso
	public static void escribirCurso(Curso curso) {
		//Se trae la lista y se le agrega el cursos nuevo para enviarlo a escribir la lista entera
		HashMap<String, Curso> listaCursos = getListaCursos();
		listaCursos.put(curso.getNombre(), curso);
		escribirTodosCursos(listaCursos);
	}

	// metodos para buscar un dato

	// Metodo que busca un alumno
	// ------------------------No se que hace el cuarto catch pero me da cosa quitarlo sin probarlo
	public static Alumno buscarAlum(String nombre, String apellidos) {
		//Se define un alumno en el que guardaremos el alumno deseado
		Alumno alumno = null;
		//Se comprueba si el archivo existe
		alumFileCheck();
		//Se crea el object input stream y se abre un try para trabajar con el
		ObjectInputStream entrada = null;
		try {
			//Se define el object input stream
			entrada = new ObjectInputStream(new FileInputStream(archivoAlum));
			try {
				
				Alumno.setCont((int)entrada.readInt());
				
				//Se busca en el archivo el alumno hasta que lo encuentre o hasta que no queden mas
				while (true) {
					Alumno alumnoAux = (Alumno) entrada.readObject();
					//Se comprueba si el alumno coincide y si coincide se guarda en la variable creada anteriormente
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
			System.out.println("Fichero vacio");
		} finally {
			try {
				if (entrada!=null) {
					entrada.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("Esta en null el Object imput stream");
			}
		}
		//Si no se encuentra al alumno se devuelve un null
		return alumno;
	}

	// Metodo que busca un profesor
	public static Profesor buscarProf(String dni) {
		//Se crea una variable para guardar el profesor
		Profesor profesor = null;
		//Se comprueba que el archivo existe
		profFileCheck();
		//Se crea el object input stream y se abre un try para trabajar con el
		ObjectInputStream entrada = null;
		try {
			//Se define el object input stream
			entrada = new ObjectInputStream(new FileInputStream(archivoProf));
			try {
				//Se busca en el archivo el profesor hasta que lo encuentre o hasta que no queden mas
				while (true) {
					Profesor profesorAux = (Profesor) entrada.readObject();
					//Se comprueba si el profesor coincide y si coincide se guarda en la variable creada anteriormente
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
		//Si no se encuentra al profesor se devuelve un null
		return profesor;
	}

	//Metodo que busca un curso
	public static Curso buscarCurso(String nombre) {
		Curso curso = null;
		FileReader fr;
		try {
			fr = new FileReader(archivoCurso);
			Scanner sc = new Scanner(archivoCurso);
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
				Alumno.setCont((int)entrada.readInt());
				while (true) {
					Alumno alumno = (Alumno) entrada.readObject();
					listaAlum.put(alumno.getNombre() + "_" + alumno.getApellidos(), alumno);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("Fin de lectura");
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				System.out.println("Error al leer el archivo: Objeto inesperado encontrado en lectura");
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("No se ha encontrado el archivo");
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			System.out.println("Fichero vacio");
		} finally {
			try {
				if (entrada!=null) {
					entrada.close();
				}
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
			entrada = new ObjectInputStream(new FileInputStream(archivoAlum));
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
			fr = new FileReader(archivoCurso);
			Scanner sc = new Scanner(archivoCurso);
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
