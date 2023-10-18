package clases;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Objects;

public class Alumno implements Serializable{
	private static int numExpediente = 0;
	private String nombre;
	private String apellidos;
	private String direccion;
	private String telefono;
	private String fechaNacimiento;
	private HashMap<String,Curso> cursos;
	
	public Alumno(String nombre, String apellidos, String direccion, String telefono, String fechaNacimiento){
		numExpediente++;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.direccion = direccion;
		this.telefono = telefono;
		this.fechaNacimiento=fechaNacimiento;
		cursos = new HashMap();
	}

	
	
	@Override
	public int hashCode() {
		return Objects.hash(apellidos, cursos, direccion, fechaNacimiento, nombre, telefono);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Alumno other = (Alumno) obj;
		return Objects.equals(apellidos, other.apellidos) && Objects.equals(cursos, other.cursos)
				&& Objects.equals(direccion, other.direccion) && Objects.equals(fechaNacimiento, other.fechaNacimiento)
				&& Objects.equals(nombre, other.nombre) && Objects.equals(telefono, other.telefono);
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

	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public HashMap getCursos() {
		return cursos;
	}
	public String getCursosString() {
		String cursosString="\n cursos{";
		for(HashMap.Entry<String, Curso> entry : this.cursos.entrySet()) {
		    String key = entry.getKey();
		    cursosString=cursosString+"[ nombre= "+ entry.getValue().getNombre() +", descripcion= "+ entry.getValue().getDescripcion() +", codigo= "+ entry.getValue().getCodigo()+" ]\n";
		}
		cursosString=cursosString+"}\n";
		return cursosString;
	}

	public void setCursos(HashMap cursos) {
		this.cursos = cursos;
	}



	@Override
	public String toString() {
		if(this.cursos.isEmpty()) {
			return "Alumno [ nombre= " + nombre + "\n apellidos= " + apellidos + "\n direccion= " + direccion + "\n telefono= "
					+ telefono + "\n fechaNacimiento= " + fechaNacimiento +  " ]";
		}else {
			return "Alumno [ nombre= " + nombre + "\n apellidos= " + apellidos + "\n direccion= " + direccion + "\n telefono= "
					+ telefono + "\n fechaNacimiento= " + fechaNacimiento + getCursosString() + " ]";
		}
		
	}
	
	
	
}
