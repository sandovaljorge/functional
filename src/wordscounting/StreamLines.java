package wordscounting;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StreamLines {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		//Expresion regular que coincide con uno o mas caracteres consecutivos
		// de expacio en blanco.
		Pattern pattern = Pattern.compile("\\s+");
		
		//Cuenta las ocurrencias de cada palabra en un Stream<String> ordenado
		//por palabra.
		Map<String, Long> contadorPalabras = 
				Files.lines(Paths.get("Texto.txt"))
					.map(line -> line.replaceAll("\\p{P}", ""))
					.flatMap(line -> pattern.splitAsStream(line))
					.collect(Collectors.groupingBy(String::toLowerCase,
							TreeMap::new,
							Collectors.counting())
				);
		
		//Muestra las palabras agrupadas por letra inicial.
		contadorPalabras.entrySet()
			.stream()
			.collect(Collectors.groupingBy(entry -> entry.getKey().charAt(0),
					TreeMap::new,
					Collectors.toList()))
			.forEach(
					(letra, listaPalabras) -> {
						System.out.printf("%n%C%n", letra);
						listaPalabras.stream()
							.forEach(palabra -> System.out.printf("%13s: %d%n", 
									palabra.getKey(), 
									palabra.getValue())
							);
					}
		);
		
	}

}
