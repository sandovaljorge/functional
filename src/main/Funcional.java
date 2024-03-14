package main;

import java.util.stream.IntStream;

public class Funcional {
	
	public static void main(String[] args) {
		int [] val = {1,2,3,4,5,6,7,12,45,10};
		
		IntStream.of(val)	//Obtiene un stream a partir de un origen de datos
			.forEach(valor -> System.out.printf("%d ", valor));
		System.out.println();
		
		//Operaciones Terminales..
		System.out.println("Cuenta: "+IntStream.of(val).count());
		System.out.println("Minimo: "+IntStream.of(val).min().getAsInt());
		System.out.println("Maximo: "+IntStream.of(val).max().getAsInt());
		System.out.println("Suma: "+IntStream.of(val).sum());
		System.out.println("Promedio: "+IntStream.of(val).average().getAsDouble());
		System.out.println("Sumary statics: "+IntStream.of(val).summaryStatistics());
		
		/**
		 * Operaciones Intermedias con flujos.
		 */
		System.out.println("Valores pares mostrados en orden: ");
		IntStream.of(val)
			.filter(valor -> valor %2 == 0)
			.sorted()
			.forEach(valor -> System.out.printf("%d ", valor));
		System.out.println();
		/**
		 * 
		 */
		System.out.println("Valores impares mostrados en orden: ");
		IntStream.of(val)
			.filter(valor -> valor %2 != 0)
			.sorted()
			.forEach(valor -> System.out.printf("%d ", valor));
		System.out.println();
		/**
		 * 
		 */
		System.out.println("Valores impares multiplicados por 10 en orden: ");
		IntStream.of(val)
			.filter(valor -> valor %2 != 0)
			.map(valor -> valor * 10)
			.sorted()
			.forEach(valor -> System.out.printf("%d ", valor));
		System.out.println();
		
		//Suma de los numeros enteros 1 - 9 exclusivo
		System.out.printf("Suma de números enteros 1 - 9: %d%n", IntStream.range(1, 10).sum());
		System.out.println();
		
		//Suma de los numeros enteros 1 - 9 inclusivo
		System.out.printf("Suma de números enteros 1 - 9: %d%n", IntStream.rangeClosed(1, 10).sum());
		System.out.println();
		
		
	}

}
