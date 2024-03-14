package main.function;

public class Empleado {

	private String nombre;
	private String apellido;
	private double salario;
	private String departamento;
	
	public Empleado(String nombre, String apellido, double salario, String departamento) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.salario = salario;
		this.departamento = departamento;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}
	
	public String getNombreCompleto() {
		return this.nombre + " " + this.apellido;
	}

	@Override
	public String toString() {
		/*return "Empleado [nombre=" + nombre + ", apellido=" + apellido + ", salario=" + salario + ", departamento="
				+ departamento + "]";*/
		return String.format("%-10s %-10s %10.2f    %s", 
				this.nombre, this.apellido, this.salario, this.departamento);
	}
	
	
}
