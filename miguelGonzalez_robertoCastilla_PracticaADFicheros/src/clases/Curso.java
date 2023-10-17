package clases;

import java.util.HashMap;

public class Curso {

	private static int codigo = 0;
	private String nombre;
	private String descripcion;
	private HashMap alumnos;
	private HashMap profesor;
	
	public Curso(String nombre, String descripcion) {
		codigo++;
		this.nombre = nombre;
		this.descripcion = descripcion;
		alumnos=new HashMap();
		profesor=new HashMap();
	}
	public static int getCodigo() {
		return codigo;
	}
	public static void setCodigo(int codigo) {
		Curso.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public HashMap getAlumnos() {//implementar que este metodo solo devuelva el n_expediente, nombre, apellido, direccion, telefono, f_nacimiento de alumnos para evitar bucles
		return alumnos;
	}
	public void setAlumnos(HashMap alumnos) {
		this.alumnos = alumnos;
	}
	public HashMap getProfesores() {//implementar que este metodo solo devuelva el nombre,dni,direccion,telefono de profesor para evitar bucles
		return profesor;
	}
	public void setProfesores(HashMap profesores) {
		this.profesor = profesores;
	}
	@Override
	public String toString() {//creo que hay que cambiar el null por .isEmpty()
		if(alumnos!=null&&profesor!=null) {
			return "Curso [nombre=" + nombre + ", descripcion=" + descripcion + ", alumnos=" + alumnos + ", profesores="
					+ profesor + "]";
		}else if(alumnos==null&&profesor!=null) {
			return "Curso [nombre=" + nombre + ", descripcion=" + descripcion + ", profesores="
					+ profesor + "]";
		}else if(alumnos!=null&&profesor==null) {
			return "Curso [nombre=" + nombre + ", descripcion=" + descripcion + ", alumnos=" + alumnos + "]";
		}else{
			return "Curso [nombre=" + nombre + ", descripcion=" + descripcion + "]";
		}
	}
	
	

}
