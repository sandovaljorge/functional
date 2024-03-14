package main;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Predicates {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<Persona> personas = new ArrayList<>();
		Persona p1 = new Persona("Jorge", "Sandoval", 32);
		Persona p2 = new Persona("Armando", "Sandoval", 30);
		Persona p3 = new Persona("Jorge", "Perez", 37);
		
		personas.add(p1);
		personas.add(p2);
		personas.add(p3);
		
		//Imprision
		personas.stream().forEach(p -> System.out.println(p.getNombre()));
		System.out.println();
		
		//Create predicate que permite filtrar la lista
		//la condicion de predicate se puede reutilizar.
		Predicate<Persona> perdicate = p -> p.getNombre().equals("Jorge");
		personas.stream()
			.filter(perdicate)
			.forEach(p -> System.out.println(p.getApellido()));
		System.out.println();
		
		//Usando predicate de manera abreviada con filter.
		personas.stream()
			.filter(p -> p.getNombre().equals("Armando"))
			.forEach(p -> System.out.println(p.getApellido()));
		System.out.println();
		
		
		//
		//int lenght = personas.stream().map(Comparator.comparing(Persona::getId)).get().getId();
	}

}
