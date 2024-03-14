package test.record;

public record PersonRecord(String nombre,String apellido,int edad) {

	public PersonRecord(String nombre, String apellido) {
		this(nombre, apellido, 2000);
	}
}
