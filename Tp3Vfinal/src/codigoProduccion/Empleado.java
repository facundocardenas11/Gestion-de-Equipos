package codigoProduccion;

public class Empleado {
	private String rol;
	private String dni;
	private String nombre;
	private String apellido;
	
	Empleado(){	
	}
	public Empleado(String rol,String dni,String nombre,String apellido){
		this.rol=rol;
		this.dni=dni;
		this.nombre=nombre;
		this.apellido=apellido;
	}
	public String getRol() {
		return rol;
	}
	public String getDni() {
		return dni;
	}
	public String getNombre() {
		return nombre;
	}
	public String getApellido() {
		return apellido;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Empleado other = (Empleado) obj;
		if (dni != other.dni)
			return false;
		if (rol == null) {
			if (other.rol != null)
				return false;
		} else if (!rol.equals(other.rol))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return dni +" "+nombre +" "+apellido;
	}
	public boolean compararDNI(String a) {
		if(this.dni.equals(a)) {
			return true;
		}
		return false;
	}	
}