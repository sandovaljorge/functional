package main.function;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class ProcesarEmpleados {

	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Inicializar array de objetos empleado.
		Empleado[] empleados = {
			new Empleado("jorge", "sandoval", 8000.00, "sistemas"),
			new Empleado("pedro", "castillo", 10000.00, "contabilidad"),
			new Empleado("luis", "orantes", 9000.00, "seguridad"),
			new Empleado("maria", "gonzales", 8000.00, "recepcion"),
			new Empleado("antonio", "pereira", 7000.00, "marketing"),
			new Empleado("saul", "sandoval", 7000.00, "marketing"),
			new Empleado("fernanda", "lopez", 7000.00, "sistemas"),
		}; 
		
		//Obtener una vista List de los objetos Empleado.
		List<Empleado> lista = Arrays.asList(empleados);
		
		//muestra de todos los empleados
		System.out.println("Lista de empleados.");
		//lista.stream().forEach(e ->System.out.println(e));
		lista.stream().forEach(System.out::println);
		
		//Predicate que devuelve true para salarios en el rango Q4000 - Q6000
		Predicate<Empleado> rangoSalarial = empleado -> (empleado.getSalario() >= 4000 && empleado.getSalario() <= 9000);
		
		//muestra de empleados con salarios en el rango seleccionado.
		//en orden ascendente por salario
		System.out.println();
		System.out.println("Lista de empleados en el rango salarial.");
		lista.stream()
			.filter(rangoSalarial)
			.sorted(Comparator.comparing(Empleado::getSalario))
			.forEach(System.out::println);;
			
		/**
		 * PARTE NO. 2
		 */
		//Primer empledo en el rango salarial seleccionado.
		System.out.println();
		System.out.println("Primer empledo en el rango salarial seleccionado.");
		System.out.println(
				lista.stream()
					.filter(rangoSalarial)
					.sorted(Comparator.comparing(Empleado::getSalario))
					.findFirst()
					.get()
		);
		
		//ORDENACION DE EMPLEADOS POR APELLIDO Y NOMBRE
		//Function para obtener primer nombre y apellido de un empleados.
		Function<Empleado, String> getNombre = Empleado::getNombre;
		Function<Empleado, String> getApellido = Empleado::getApellido;
		
		//Comparator para comparar empleados por nombre y luego por apellido.
		Comparator<Empleado> apellidoNombre = Comparator.comparing(getApellido).thenComparing(getNombre);
		
		System.out.println();
		System.out.println("Empleados en orden ascendente por apellido luego nombre");
		lista.stream()
			.sorted(apellidoNombre)
			.forEach(System.out::println);
		
		System.out.println();
		System.out.println("Empleados en orden descendente por apellido luego nombre");
		lista.stream()
			.sorted(apellidoNombre.reversed())
			.forEach(System.out::println);
		
		/**
		 * PARTE NO. 3
		 */
		//Muestra apellidos de empleados unicos ordenados
		System.out.println();
		System.out.println("Muestra apellidos de empleados unicos ordenados");
		lista.stream()
			.map(Empleado::getApellido)
			.distinct()
			.sorted()
			.forEach(System.out::println);
		
		//Muestra nombre y apellido de empleados unicos ordenados
		System.out.println();
		System.out.println("Muestra nombre y apellido de empleados unicos ordenados");
		lista.stream()
			.sorted(apellidoNombre)
			.map(Empleado::getNombreCompleto)
			.forEach(System.out::println);
		
		/**
		 * PARTE NO. 4
		 */
		//Agrupacion por departamento de los empleados.
		System.out.println();
		System.out.println("Agrupacion por departamento de los empleados.");
		Map<String, List<Empleado>> agrupadosPorDepartamento = 
				lista.stream()
					.collect(Collectors.groupingBy(Empleado::getDepartamento));
		
		//Impresion
		agrupadosPorDepartamento.forEach(
			(departamento, empleadosDepartamento) -> {
				System.out.println(departamento);
				empleadosDepartamento.forEach(
					empleado -> System.out.printf("      %s%n",empleado)
				);
			}
		);
		
		//
		System.out.println();
		System.out.println("Contar cada uno de los elementos en cada departamento.");
		Map<String, Long> empleadosPorDepartamento = 
				lista.stream()
					.collect(Collectors.groupingBy(
								Empleado::getDepartamento,		//Parametro de conteo.
								TreeMap::new,					//Permite imprimir en orden por departamento
								Collectors.counting()			//Conteo
							))
					
				;
		
		//Impresion
		empleadosPorDepartamento.forEach(
				(departamento, conteo) -> System.out.printf("%s tiene %d empleado(s)%n", departamento, conteo)
		);
		
		/**
		 * PARTE NO. 5
		 */
		//Suma de salarios de empleados con el metodo sum de DoubleStream.
		System.out.println();
		System.out.println("Suma de salarios de los empleados: ");
		System.out.println(lista.stream()
					.mapToDouble(Empleado::getSalario)
					.sum()
		);
		
		//Calcular la suma de los salarios de los empleados con el metodo reduce.
		System.out.println();
		System.out.println("Calcular la suma de los salarios de los empleados con el metodo reduce.");
		System.out.println(
				lista.stream()
					.mapToDouble(Empleado::getSalario)
					.reduce(0, (valor1, valor2) -> valor1 + valor2)
		);
		
		//Promedio de salarios de los empleados con el metodo average().
		System.out.println();
		System.out.println("Promedio de salarios de empleados con metodo average().");
		System.out.println(
				lista.stream()
					.mapToDouble(Empleado::getSalario)
					.average()
					.getAsDouble()
		);
		
	}

}
