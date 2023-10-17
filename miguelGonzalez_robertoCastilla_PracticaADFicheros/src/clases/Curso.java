package clases;

import java.util.HashMap;
import java.util.Objects;

public class Curso {

	private static int codigo = 0;
	private String nombre;
	private String descripcion;
	private HashMap<String,Alumno> alumnos;
	private Profesor profesor;
	
	public Curso(String nombre, String descripcion) {
		codigo++;
		this.nombre = nombre;
		this.descripcion = descripcion;
		alumnos=new HashMap();
	}
	
	
	
	@Override
	public int hashCode() {
		return Objects.hash(alumnos, descripcion, nombre, profesor);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Curso other = (Curso) obj;
		return Objects.equals(alumnos, other.alumnos) && Objects.equals(descripcion, other.descripcion)
				&& Objects.equals(nombre, other.nombre) && Objects.equals(profesor, other.profesor);
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
	public HashMap getAlumnos() {
		return alumnos;
	}
	public String getAlumnosString() {
		String alumnosString="\n cursos{";
		for(HashMap.Entry<String, Alumno> entry : this.alumnos.entrySet()) {
		    String key = entry.getKey();
		    alumnosString=alumnosString+ entry.getValue().getNombre() +entry.getValue().getApellidos()+entry.getValue().getDireccion()+entry.getValue().getTelefono()+entry.getValue().getFechaNacimiento()+"\n";
		}
		alumnosString=alumnosString+"}\n";
		return alumnosString;
	}
	public void setAlumnos(HashMap alumnos) {
		this.alumnos = alumnos;
	}
	public Profesor getProfesor() {
		return profesor;
	}
	public String getProfesorString() {
		return "\nprofesor {"+this.profesor.getNombre()+this.profesor.getDireccion()+this.profesor.getDni()+this.profesor.getTelefono()+"\n}";
	}
	public void setProfesor(Profesor profesores) {
		this.profesor = profesores;
	}
	@Override
	public String toString() {
		if(!(this.alumnos.isEmpty()&&this.profesor==null)) {
			return "Curso [nombre=" + nombre + "\n descripcion=" + descripcion + getAlumnosString() + getProfesorString() + "]";
		}else if(this.alumnos.isEmpty()&&this.profesor!=null) {
			return "Curso [nombre=" + nombre + "\n descripcion=" + descripcion + getProfesorString() + "]";
		}else if(!this.alumnos.isEmpty()&&this.profesor==null) {
			return "Curso [nombre=" + nombre + "\n descripcion=" + descripcion + getAlumnosString() + "]";
		}else{
			return "Curso [nombre=" + nombre + "\n descripcion=" + descripcion + "]";
		}
	}
	
	

}
