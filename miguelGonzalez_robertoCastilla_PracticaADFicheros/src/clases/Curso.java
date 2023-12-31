package clases;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Objects;

public class Curso implements Serializable{

	private static int cont = 0;
	private String codigo;
	private String nombre;
	private String descripcion;
	private HashMap<String,Alumno> alumnos;
	private Profesor profesor;
	
	public Curso(String nombre, String descripcion) {
		cont++;
		this.codigo=cont+"";
		this.nombre = nombre;
		this.descripcion = descripcion;
		alumnos=new HashMap<String,Alumno>();
	}
	public Curso(String codigo,String nombre, String descripcion) {
		this.codigo=codigo;
		this.nombre = nombre;
		this.descripcion = descripcion;
		alumnos=new HashMap<String,Alumno>();
	}
	
	/**
	 * Metodo para restar uno al contador cuando se crean Cursos que no son nuevos
	 */
	public static void restarCont() {
		cont-=1;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(nombre);
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
		return Objects.equals(nombre, other.nombre);
	}
	public String getCodigo() {
		return this.codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public static int getCont() {
		return cont;
	}
	public static void setCont(int contador) {
		cont = contador;
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
	public HashMap<String,Alumno> getAlumnos() {
		return alumnos;
	}
	public String getAlumnosString() {
		String alumnosString="\n Alumnos ";
		for(HashMap.Entry<String, Alumno> entry : this.alumnos.entrySet()) {
		    String key = entry.getKey();
		    alumnosString=alumnosString+ "{ nombre= "+entry.getValue().getNombre() +", apellidos= "+entry.getValue().getApellidos()+", direccion= "+entry.getValue().getDireccion()+", telefono= "+entry.getValue().getTelefono()+", fechaNacimiento= "+entry.getValue().getFechaNacimiento()+" }";
		}
		alumnosString=alumnosString;
		return alumnosString;
	}
	public String getAlumnosStringDatos() {
		String alumnosString="";
		for(HashMap.Entry<String, Alumno> entry : this.alumnos.entrySet()) {
		    String key = entry.getKey();
		    alumnosString=alumnosString+ entry.getValue().getNombre() +"¬"+entry.getValue().getApellidos()+"¬"+entry.getValue().getDireccion()+"¬"+entry.getValue().getTelefono()+"¬"+entry.getValue().getFechaNacimiento()+"¬";
		}
		return alumnosString;
	}
	public void setAlumnos(HashMap<String,Alumno> alumnos) {
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
		return "\n Profesor { nombre= " + this.profesor.getNombre() + " dni= " + this.profesor.getDni() + ", direccion= " + this.profesor.getDireccion() + ", telefono= " + this.profesor.getTelefono() +" }\n";
	}
	public String getProfesorStringDatos() {
		return this.profesor.getNombre() + "¬" + this.profesor.getDni() + "¬" + this.profesor.getDireccion() + "¬" + this.profesor.getTelefono();
	}
	public void setProfesor(Profesor profesores) {
		this.profesor = profesores;
	}
	@Override
	public String toString() {
		if(!this.alumnos.isEmpty()&&this.profesor!=null) {
			return "Curso [ codigo= "+codigo+"\n nombre= " + nombre + "\n descripcion= " + descripcion + getAlumnosString() + getProfesorString() + "]";
		}else if(this.alumnos.isEmpty()&&this.profesor!=null) {
			return "Curso [ codigo= "+codigo+"\n nombre= " + nombre + "\n descripcion= " + descripcion + getProfesorString() + "]";
		}else if(!this.alumnos.isEmpty()&&this.profesor==null) {
			return "Curso [ codigo= "+codigo+"\n nombre= " + nombre + "\n descripcion= " + descripcion + getAlumnosString() + "]";
		}else{
			return "Curso [ codigo= "+codigo+"\n nombre= " + nombre + "\n descripcion= " + descripcion + "\n]";
		}
	}
	public String toStringDatos() {
		if(!this.alumnos.isEmpty()&&this.profesor!=null) {
			return codigo+ "¬" + nombre + "¬" + descripcion +"\n"+ getAlumnosStringDatos() +"\n"+ getProfesorStringDatos() + "\n";
		}else if(this.alumnos.isEmpty()&&this.profesor!=null) {
			return codigo+ "¬" + nombre + "¬" + descripcion +"\n"+"\n"+ getProfesorStringDatos() + "\n";
		}else if(!this.alumnos.isEmpty()&&this.profesor==null) {
			return codigo+ "¬" + nombre + "¬" + descripcion +"\n"+ getAlumnosStringDatos() + "\n" + "\n";
		}else{
			return codigo+ "¬" + nombre + "¬" + descripcion +"\n"+"\n"+"\n";
		}
	}
	

}
