package principal;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Utiles {
	static Scanner sc = new Scanner(System.in);

	// Escanea frases sin numeros
	static public String scanPalabras() {
		String nombre;
		boolean check = true;
		int errorCont = 0;
		do {
			check = true;
			if (errorCont < 5) {
				nombre = sc.nextLine().trim();
				if (!nombre.isBlank()) {
					String palabras[] = nombre.split(" ");
					String aux = "";
					for (int i = 0; i < palabras.length; i++) {
						if (i == palabras.length) {
							aux += palabras[i].trim();
						} else {
							aux += palabras[i].trim() + " ";
						}
					}
					nombre = aux;
					for (int i = 0; i < nombre.length(); i++) {
						if (Character.isDigit(nombre.charAt(i))) {
							check = false;
						}
					}
				} else {
					check = false;
				}
				if (!check) {
					System.out.println("Valor incorrecto, introduzca letras o espacios");
				}
				errorCont++;
			} else {
				nombre = null;
				System.out.println("Excedido numero de intentos (" + errorCont + ")");
			}
		} while (!check);
		return nombre;
	}

	// Escanea numeros sin espacios
	static public String scanNumero() {
		String nombre;
		boolean check = true;
		int errorCont = 0;
		do {
			check = true;
			if (errorCont < 5) {
				nombre = sc.nextLine().trim();
				if (!nombre.isBlank()) {
					String palabras[] = nombre.split(" ");
					if (palabras.length != 1) {
						check = false;
					} else {
						check=esDigito(nombre);
					}
				} else {
					check = false;
				}
				if (!check) {
					System.out.println("Valor incorrecto, introduzca letras o espacios");
				}
				errorCont++;
			} else {
				nombre = null;
				System.out.println("Excedido numero de intentos (" + errorCont + ")");
			}
		} while (!check);
		return nombre;
	}
	
	// Escanea numeros de telefono
		static public String scanTelefono() {
			String nombre;
			boolean check = true;
			int errorCont = 0;
			do {
				check = true;
				if (errorCont < 5) {
					nombre = sc.nextLine().trim();
					if (!nombre.isBlank()&&nombre.length()==9) {
							check=esDigito(nombre);
					} else {
						check = false;
					}
					if (!check) {
						System.out.println("Valor incorrecto, introduzca letras o espacios");
					}
					errorCont++;
				} else {
					nombre = null;
					System.out.println("Excedido numero de intentos (" + errorCont + ")");
				}
			} while (!check);
			return nombre;
		}

	// Escaneo de frase sin distincion
	static public String scanTodoTrim() {
		String nombre;
		boolean check = true;
		int errorCont = 0;
		do {
			check = true;
			if (errorCont < 5) {
				nombre = sc.nextLine().trim();
				if (!nombre.isBlank()) {
					String palabras[] = nombre.split(" ");
					String aux = "";
					for (int i = 0; i < palabras.length; i++) {
						if (i == palabras.length) {
							aux += palabras[i].trim();
						} else {
							aux += palabras[i].trim() + " ";
						}
					}
					nombre = aux;
				} else {
					check = false;
				}
				if (!check) {
					System.out.println("Valor incorrecto, introduzca letras o espacios");
				}
				errorCont++;
			} else {
				nombre = null;
				System.out.println("Excedido numero de intentos (" + errorCont + ")");
			}
		} while (!check);
		return nombre;
	}

	// Escaneo de fecha
	static public String scanFecha() {
		String nombre=null;
		boolean check;
		String dia = null;
		String mes = null;
		String year = null;
		int errorCont = 0;
		do {
			check = true;
			if (errorCont < 5) {
				System.out.println("Introduzca el dia");
				dia = scanNumero();
				if (dia.length() == 1) {
					dia = "0" + dia;
				}
				System.out.println("Introduzca el mes (numero)");
				mes = scanNumero();
				if (mes.length() == 1) {
					mes = "0" + mes;
				}
				System.out.println("Introduzca el anyo");
				year = scanNumero();
				try {
					DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy");
					LocalDate fecha = LocalDate.parse(dia + "-" + mes + "-" + year, format);
				} catch (Exception e) {
					System.out.println("La fecha introducida no existe, intentelo otra vez");
					check = false;
				}
				errorCont++;
			} else {
				nombre = null;
				System.out.println("Excedido numero de intentos (" + errorCont + ")");
			}
		} while (!check);
		if (errorCont < 5) {
			nombre = dia + "-" + mes + "-" + year;
		}
		return nombre;
	}

	// Escaneo de dni (9 numeros y letra)
	static public String scanDni() {
		String nombre;
		boolean check = true;
		int errorCont = 0;
		do {
			check = true;
			if (errorCont < 5) {
				System.out.println("Introduzca el dni (9 numeros y una letra)");
				nombre = sc.nextLine().trim().toUpperCase();
				if (!nombre.isBlank() && nombre.length() == 10) {
					for (int i = 0; i < nombre.length(); i++) {
						if (i <= 8 && !Character.isDigit(nombre.charAt(i))) {
							check = false;
						} else if (i == 9 && !Character.isAlphabetic(nombre.charAt(i))) {
							check = false;
						}
					}
				} else {
					check = false;
				}
				if (!check) {
					System.out.println("Valor incorrecto, introduzca letras o espacios");
				}
				errorCont++;
			} else {
				nombre = null;
				System.out.println("Excedido numero de intentos (" + errorCont + ")");
			}
		} while (!check);
		return nombre;
	}
	public static boolean esDigito(String nombre) {
		boolean check = true;
		for (int i = 0; i < nombre.length(); i++) {
			if (!Character.isDigit(nombre.charAt(i))) {
				check = false;
			}
		}
		return check;
	}
	
}
