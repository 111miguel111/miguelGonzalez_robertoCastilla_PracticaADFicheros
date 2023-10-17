package principal;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Utiles {
	static Scanner sc = new Scanner(System.in);

	static public String scanPalabras() {
		String nombre;
		boolean check = true;
		do {
			check = true;
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
		} while (!check);
		return nombre;
	}

	static public String scanNumero() {
		String nombre;
		boolean check = true;
		do {
			check = true;
			nombre = sc.nextLine().trim();
			if (!nombre.isBlank()) {
				String palabras[] = nombre.split(" ");
				if (palabras.length != 1) {
					check = false;
				} else {
					for (int i = 0; i < nombre.length(); i++) {
						if (!Character.isDigit(nombre.charAt(i))) {
							check = false;
						}
					}
				}
			} else {
				check = false;
			}
			if (!check) {
				System.out.println("Valor incorrecto, introduzca letras o espacios");
			}
		} while (!check);
		return nombre;
	}

	static public String scanTodoTrim() {
		String nombre;
		boolean check = true;
		do {
			check = true;
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
		} while (!check);
		return nombre;
	}

	static public String scanFecha() {
		String nombre;
		boolean check;
		String dia;
		String mes;
		String year;
		do {
			check = true;
			System.out.println("Introduzca el dia");
			dia = scanNumero();
					if (dia.length()==1) {
						dia="0"+dia;
					}
			System.out.println("Introduzca el mes (numero)");
			mes = scanNumero();
				if (mes.length()==1) {
					mes="0"+mes;
				}
			System.out.println("Introduzca el anyo");
			year = scanNumero();
			try {
				DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy");
				LocalDate fecha = LocalDate.parse(dia+"-"+mes+"-"+year,format);
			}catch(Exception e) {
				System.out.println("La fecha introducida no existe, intentelo otra vez");
				check = false;
			}
		} while (!check);
		nombre = dia+"-"+mes+"-"+year;
		return nombre;
	}
}
