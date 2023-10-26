package principal;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Utiles {
	static Scanner sc = new Scanner(System.in);

	// Escanea sin restricciones
	public static String scanLibre() {
		return sc.nextLine();
	}

	static public String confirmarAccion() {
		System.out.println("Seguro que quiere realizar la accion?\nSi o No");
		String respuesta = scanPalabras().trim();
		System.out.println(respuesta);
		if (respuesta.equalsIgnoreCase("si")) {
			respuesta = null;
			System.out.println("Confirmacion aceptada , la accion se realizara");
		} else {
			System.out.println("Confirmacion denegada , la accion no se realizara");
		}
		System.out.println(respuesta);
		return respuesta;
	}

	// Escanea frases sin numeros
	static public String scanPalabras() {
		// Declaracion de la string que se va a escanear
		String nombre;
		// Declaracion del boolean que refleja si la cadena tiene el formato adecuado
		boolean check = true;
		// Declaracion del contador de errores
		int errorCont = 0;
		// Bucle que permitira introducir una cadena hasta 5 veces
		do {
			// Reset del boolean en cada ciclo del bucle
			check = true;
			// comprobacion del numero de ciclos del bucle
			if (errorCont < 5) {
				// Input del usuario
				nombre = sc.nextLine();
				// Se comprueba si la cadena esta vacia
				if (!nombre.isBlank()) {
					// Split de la cadena en cada espacio para despues reducir el numero de espacios
					// entre palabras a 1
					String palabras[] = nombre.split(" ");
					String aux = "";
					for (int i = 0; i < palabras.length; i++) {
						if (i == palabras.length-1) {
							aux += palabras[i].trim();
						} else {
							aux += palabras[i].trim() + " ";
						}
					}
					nombre = aux;
					// Se comprueba que la frase no tenga numeros
					check = !esDigito(nombre);
				} else {
					// Se cambia a falso por cadena vacia
					check = false;
				}
				// Print de confirmacion de error en la introduccion de datos
				if (!check) {
					System.out.println("Valor incorrecto, introduzca letras o espacios");
				}
				// Suma de contador de errores al final del bucle
				errorCont++;

				// Tras 5 errores se manda mensaje de fin de intentos
			} else {
				nombre = null;
				System.out.println("Excedido numero de intentos (" + errorCont + ")");
			}
		} while (!check);
		// Return de frase
		return nombre;
	}

	// Escanea numeros sin espacios
	static public String scanNumero() {
		// Declaracion de la string que se va a escanear
		String nombre;
		// Declaracion del boolean que refleja si la cadena tiene el formato adecuado
		boolean check = true;
		// Declaracion del contador de errores
		int errorCont = 0;
		// Bucle que permitira introducir una cadena hasta 5 veces
		do {
			// Reset del boolean en cada ciclo del bucle
			check = true;
			// comprobacion del numero de ciclos del bucle
			if (errorCont < 5) {
				// Input del usuario
				nombre = sc.nextLine().trim();
				// Se comprueba si la cadena esta vacia
				if (!nombre.isBlank()) {
					// Se comprueba si hay solo una palabra
					String palabras[] = nombre.split(" ");
					if (palabras.length != 1) {
						check = false;
					} else {
						// Se comprueba si son todo numeros
						check = esDigito(nombre);
					}
				} else {
					// cambio por cadena vacia
					check = false;
				}
				// Print de confirmacion de error en la introduccion de datos
				if (!check) {
					System.out.println("Valor incorrecto, introduzca solo numeros");
				}
				// Suma de contador de errores al final del bucle
				errorCont++;
				// Tras 5 errores se manda mensaje de fin de intentos
			} else {
				nombre = null;
				System.out.println("Excedido numero de intentos (" + errorCont + ")");
			}
		} while (!check);
		// Return de frase
		return nombre;
	}

	// Escanea numeros de telefono
	static public String scanTelefono() {
		// Declaracion de la string que se va a escanear
		String nombre;
		// Declaracion del boolean que refleja si la cadena tiene el formato adecuado
		boolean check = true;
		// Declaracion del contador de errores
		int errorCont = 0;
		// Bucle que permitira introducir una cadena hasta 5 veces
		do {
			// Reset del boolean en cada ciclo del bucle
			check = true;
			// comprobacion del numero de ciclos del bucle
			if (errorCont < 5) {
				// Input del usuario
				nombre = sc.nextLine().trim();
				// Se comprueba si la cadena esta vacia y si la longitud de esta es 9
				if (!nombre.isBlank() && nombre.length() == 9) {
					// Se comprueba si son todo numeros
					check = esDigito(nombre);
				} else {
					check = false;
				}
				// Print de confirmacion de error en la introduccion de datos
				if (!check) {
					System.out.println("Valor incorrecto, introduzca un numero de telefono");
				}
				// Suma de contador de errores al final del bucle
				errorCont++;
				// Tras 5 errores se manda mensaje de fin de intentos
			} else {
				nombre = null;
				System.out.println("Excedido numero de intentos (" + errorCont + ")");
			}
		} while (!check);
		// Return de frase
		return nombre;
	}

	// Escaneo de frase sin distincion
	static public String scanTodoTrim() {
		// Declaracion de la string que se va a escanear
		String nombre;
		// Declaracion del boolean que refleja si la cadena tiene el formato adecuado
		boolean check = true;
		// Declaracion del contador de errores
		int errorCont = 0;
		// Bucle que permitira introducir una cadena hasta 5 veces
		do {
			// Reset del boolean en cada ciclo del bucle
			check = true;
			// comprobacion del numero de ciclos del bucle
			if (errorCont < 5) {
				// Imput del usuario
				nombre = sc.nextLine().trim();
				// Se comprueba si la cadena esta vacia
				if (!nombre.isBlank()) {
					// Split de la cadena en cada espacio para despues reducir el numero de espacios
					// entre palabras a 1
					String palabras[] = nombre.split(" ");
					String aux = "";
					for (int i = 0; i < palabras.length; i++) {
						if (i == palabras.length-1) {
							aux += palabras[i].trim();
						} else {
							aux += palabras[i].trim() + " ";
						}
					}
					nombre = aux;
				} else {
					// cambio por cadena vacia
					check = false;
				}
				// Print de confirmacion de error en la introduccion de datos
				if (!check) {
					System.out.println("Valor incorrecto");
				}
				// Suma de contador de errores al final del bucle
				errorCont++;
				// Tras 5 errores se manda mensaje de fin de intentos
			} else {
				nombre = null;
				System.out.println("Excedido numero de intentos (" + errorCont + ")");
			}
		} while (!check);
		// Return de frase
		return nombre;
	}

	// Escaneo de fecha
	static public String scanFecha() {
		// Declaracion de la variable que contendra el dia
		String dia = null;
		// Declaracion de la variable que contendra el mes
		String mes = null;
		// Declaracion de la variable que contendra el anyo
		String year = null;
		// Declaracion de la string que se va a escanear
		String nombre = null;
		// Declaracion del boolean que refleja si la cadena tiene el formato adecuado
		boolean check = true;
		// Declaracion del contador de errores
		int errorCont = 0;
		// Bucle que permitira introducir una cadena hasta 5 veces
		do {
			// Reset del boolean en cada ciclo del bucle
			check = true;
			// comprobacion del numero de ciclos del bucle
			if (errorCont < 5) {
				// Input de dia del usuario
				System.out.println("Introduzca el dia");
				dia = scanNumero();
				// Si el valor de dia es solo un numero se le pone un cero delante
				if (dia.length() == 1) {
					dia = "0" + dia;
				}
				// Input de mes del usuario
				System.out.println("Introduzca el mes (numero)");
				mes = scanNumero();
				// Si el valor de dia es solo un numero se le pone un cero delante
				if (mes.length() == 1) {
					mes = "0" + mes;
				}
				// Input de anyo del usuario
				System.out.println("Introduzca el anyo");
				year = scanNumero();
				// Se comprueba si la fecha existe creando un objeto LocalDate. Si da error la
				// fecha no es valida
				try {
					DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy");
					LocalDate fecha = LocalDate.parse(dia + "-" + mes + "-" + year, format);
					if (fecha.isAfter(LocalDate.now())) {
						check = false;
						System.out.println("Esa fecha es el futuro por lo que no puede ser una fecha de nacimiento. Intentelo con otra fecha mas antigua.");
					}
				} catch (Exception e) {
					// Print de confirmacion de error en la introduccion de datos
					System.out.println("La fecha introducida no existe, intentelo otra vez");
					check = false;
				}
				// Suma de contador de errores al final del bucle
				errorCont++;
				// Tras 5 errores se manda mensaje de fin de intentos
			} else {
				System.out.println("Excedido numero de intentos (" + errorCont + ")");
			}
		} while (!check);
		// Si el contador de errores es menor a 5 se guarda el la fecha en la string
		if (errorCont < 5) {
			nombre = dia + "-" + mes + "-" + year;
		}
		return nombre;
	}

	// Escaneo de dni (8 numeros y letra)
	static public String scanDni() {
		String nombre;
		boolean check = true;
		int errorCont = 0;
		do {
			check = true;
			if (errorCont < 5) {
				System.out.println("Introduzca el dni (8 numeros y una letra)");
				nombre = sc.nextLine().trim().toUpperCase();
				if (!nombre.isBlank() && nombre.length() == 9) {
					for (int i = 0; i < nombre.length(); i++) {
						if (i <= 7 && !Character.isDigit(nombre.charAt(i))) {
							check = false;
						} else if (i == 8 && !Character.isAlphabetic(nombre.charAt(i))) {
							check = false;
						}
					}
				} else {
					check = false;
				}
				// Print de confirmacion de error en la introduccion de datos
				if (!check) {
					System.out.println("Valor incorrecto, introduzca un dni");
				}
				// Suma de contador de errores al final del bucle
				errorCont++;
				// Tras 5 errores se manda mensaje de fin de intentos
			} else {
				nombre = null;
				System.out.println("Excedido numero de intentos (" + errorCont + ")");
			}
		} while (!check);
		// Return de frase
		return nombre;
	}

	public static boolean esDigito(String nombre) {
		boolean check = true;
		// Se recorre la string y si encuentra algo que no sea digito devuelve false
		for (int i = 0; i < nombre.length(); i++) {
			if (!Character.isDigit(nombre.charAt(i))) {
				check = false;
			}
		}
		return check;
	}

	public static boolean esLetra(String nombre) {
		boolean check = true;
		// Se recorre la string y si encuentra algo que no sea digito devuelve true
		for (int i = 0; i < nombre.length(); i++) {
			if (Character.isDigit(nombre.charAt(i))) {
				check = false;
			}
		}
		return check;
	}

}
