package test.record;

public class MainRecord {

	public static void main(String[] args) {
		PersonRecord r = new PersonRecord("jorge", "sandoval", 32);
		System.out.println("Nombre: "+r.nombre()+"\tApellido: "+r.apellido());
	}

}
