package main;

import java.util.Arrays;
import java.util.stream.Collectors;

public class ArreglosYFlujosString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] cadenas = {"Rojo", "naranja", "Amarillo", "verde", "Azul", "indigo", "Violeta"};
		
		System.out.printf("Cadenas originales: %s%n", Arrays.asList(cadenas));
		
		//
		System.out.println();
		System.out.printf("Cadenas en MAYUSCULAS: %S%n",
				Arrays.stream(cadenas)
					.map(String::toUpperCase)
					.collect(Collectors.toList())
				);
		
		//
		System.out.println();
		System.out.printf("Cadenas mayores que m en orden ascendente %s%n",
				Arrays.stream(cadenas)
					.filter(s -> s.compareToIgnoreCase("m") > 0 )
					.sorted(String.CASE_INSENSITIVE_ORDER)
					.map(String::toUpperCase)
					.collect(Collectors.toList())
				);
		
		//
		System.out.println();
		System.out.printf("Cadenas mayores que m en orden descendente %s%n",
				Arrays.stream(cadenas)
					.filter(s -> s.compareToIgnoreCase("m") > 0 )
					.sorted(String.CASE_INSENSITIVE_ORDER.reversed())
					.map(String::toUpperCase)
					.collect(Collectors.toList())
				);
	}

}
