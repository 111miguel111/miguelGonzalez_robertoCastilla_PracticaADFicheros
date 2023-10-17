package clases;

import java.time.LocalDate;
import java.util.HashMap;

public class Alumno {
	private static int numExpediente = 0;
	private String nombre;
	private String apellidos;
	private String direccion;
	private String telefono;
	private LocalDate fechaNacimiento;
	private HashMap cursos;
	
	Alumno(String nombre, String apellidos, String direccion, String telefono, LocalDate fechaNacimiento){
		numExpediente++;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.direccion = direccion;
		this.telefono = telefono;
		this.fechaNacimiento=fechaNacimiento;
		cursos = new HashMap();
	}

	
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public HashMap getCursos() {
		return cursos;
	}

	public void setCursos(HashMap cursos) {
		this.cursos = cursos;
	}



	@Override
	public String toString() {
		return "Alumno [nombre=" + nombre + ", apellidos=" + apellidos + ", direccion=" + direccion + ", telefono="
				+ telefono + ", fechaNacimiento=" + fechaNacimiento + ", cursos=" + cursos + "]";
	}
	
	
}
