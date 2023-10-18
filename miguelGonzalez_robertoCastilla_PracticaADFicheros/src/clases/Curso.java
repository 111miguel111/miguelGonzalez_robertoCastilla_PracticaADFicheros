package clases;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Objects;

public class Curso implements Serializable{

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
		String alumnosString="\n alumnos{";
		for(HashMap.Entry<String, Alumno> entry : this.alumnos.entrySet()) {
		    String key = entry.getKey();
		    alumnosString=alumnosString+ "[ nombre= "+entry.getValue().getNombre() +", apellidos= "+entry.getValue().getApellidos()+", direccion= "+entry.getValue().getDireccion()+", telefono= "+entry.getValue().getTelefono()+", fechaNacimiento= "+entry.getValue().getFechaNacimiento()+" ]\n";
		}
		alumnosString=alumnosString+"}\n";
		return alumnosString;
	}
	public void setAlumnos(HashMap alumnos) {
		this.alumnos = alumnos;
	}
	public void AlumnoNuevo(Alumno alumno) {
		this.alumnos.put(alumno.getNombre()+"_"+alumno.getApellidos(), alumno);
	}
	public void AlumnoPop(Alumno alumno) {
		this.alumnos.remove(alumno.getNombre()+"_"+alumno.getApellidos(), alumno);
	}
	public Profesor getProfesor() {
		return profesor;
	}
	public String getProfesorString() {
		return "\nprofesor {nombre= " + this.profesor.getNombre() + " dni= " + this.profesor.getDni() + ", direccion= " + this.profesor.getDireccion() + ", telefono= " + this.profesor.getTelefono() +"}\n";
	}
	public void setProfesor(Profesor profesores) {
		this.profesor = profesores;
	}
	@Override
	public String toString() {
		if(!(this.alumnos.isEmpty()&&this.profesor==null)) {
			return "Curso [ codigo= "+codigo+"\n nombre= " + nombre + "\n descripcion= " + descripcion + getAlumnosString() + getProfesorString() + " ]";
		}else if(this.alumnos.isEmpty()&&this.profesor!=null) {
			return "Curso [ codigo= "+codigo+"\n nombre= " + nombre + "\n descripcion= " + descripcion + getProfesorString() + " ]";
		}else if(!this.alumnos.isEmpty()&&this.profesor==null) {
			return "Curso [ codigo= "+codigo+"\n nombre= " + nombre + "\n descripcion= " + descripcion + getAlumnosString() + " ]";
		}else{
			return "Curso [ codigo= "+codigo+"\n nombre= " + nombre + "\n descripcion= " + descripcion + " ]";
		}
	}
	
	

}
