package clases;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Objects;

public class Profesor implements Serializable{
	private String nombre;
	private String dni;
	private String direccion;
	private String telefono;
	private HashMap<String,Curso> cursos;
	
	public Profesor(String nombre, String dni, String direccion, String telefono){
		this.nombre=nombre;
		this.direccion=direccion;
		this.dni=dni;
		this.telefono=telefono;
		this.cursos=new HashMap<String,Curso>();
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(dni);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Profesor other = (Profesor) obj;
		return Objects.equals(dni, other.dni);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
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

	public HashMap<String,Curso> getCursos() {
		return cursos;
	}
	public String getCursosString() {
		String cursosString="\n Cursos";
		for(HashMap.Entry<String, Curso> entry : this.cursos.entrySet()) {
		    String key = entry.getKey();
		    cursosString=cursosString+"{ nombre= "+ entry.getValue().getNombre() +", descripcion= "+ entry.getValue().getDescripcion() +", codigo= "+ entry.getValue().getCodigo()+" }\n";
		}
		cursosString=cursosString;
		return cursosString;
	}

	public void setCursos(HashMap<String,Curso> cursos) {
		this.cursos = cursos;
	}

	@Override
	public String toString() {
		if(this.cursos.isEmpty()) {
			return "Profesor [ nombre= " + nombre + "\n dni= " + dni + "\n direccion= " + direccion + "\n telefono= " + telefono
					+  "\n]";
		}else {
			return "Profesor [ nombre=" + nombre + "\n dni=" + dni + "\n direccion=" + direccion + "\n telefono=" + telefono
					+ getCursosString() + "]";
		}
	}
	
	
}
