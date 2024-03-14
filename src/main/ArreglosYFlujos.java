package main;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ArreglosYFlujos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Integer [] valores = {2, 9, 5, 0, 3, 7, 1, 4, 8, 6};
		
		System.out.printf("Valores originales: %s%n", Arrays.asList(valores));
		System.out.println();
		
		//ordena los valores en forma ascendente con flujos
		System.out.printf("Valores ordenados: %s%n",
				Arrays.stream(valores)			//Devuelve un stream del tipo apropiado
					.sorted()					//Devuelve un Stream<Integer> con los valores en orden ascendente.
					.collect(Collectors.toList())	//Se crea una nueva coleccion con los resultados.
				);
		System.out.println();
		
		//
		List<Integer> mayorQue4 = Arrays.stream(valores)
				.filter(value -> value > 4)
				.collect(Collectors.toList());
		System.out.printf("Valores mayores que 4: %s%n", mayorQue4);
		System.out.println();
		
		//
		List<Integer> mayorQue4Asc = Arrays.stream(valores)
				.filter(value -> value > 4)
				.sorted()
				.collect(Collectors.toList());
		System.out.printf("Valores mayores que 4 Ascendentes: %s%n", mayorQue4Asc);
		System.out.println();
		
		//
		System.out.printf("Valores mayores que 4 (ascendente con flujos) %S%n",
				mayorQue4.stream()
					.sorted()
					.collect(Collectors.toList()));
	}

}
