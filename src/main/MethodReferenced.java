package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiPredicate;

public class MethodReferenced {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MethodReferenced m = new MethodReferenced();
		
		System.out.println("Mediante clases anonimas.");
		for(Integer integer : m.numerosEncontrados) {
			System.out.print(integer + " ");
		}
		
		
		System.out.println();
		System.out.println("Mediante expresiones lambdas.");
		for(Integer integer : m.numerosEncontrados2) {
			System.out.print(integer + " ");
		}
		
		System.out.println();
		System.out.println("Mediante metodos referenciados estaticos.");
		for(Integer integer : m.numerosEncontrados3) {
			System.out.print(integer + " ");
		}
	}
	public static boolean mayorQueCincuenta(int n1, int n2) {
		return (n1 + n2) > 50;
	}
	
	public static List<Integer> encontrarNumeros(List<Integer> l, BiPredicate<Integer, Integer> b){
		List<Integer> nuevaLista = new ArrayList<>();
		
		for(Integer i : l) {
			if(b.test(i, i + 10)) {
				nuevaLista.add(i);
			}
		}
		return nuevaLista;
	}
	
	List<Integer> list = Arrays.asList(12, 5, 45, 18, 33, 24 ,40);
	
	//Mediante una clase anonima.
	List<Integer> numerosEncontrados = encontrarNumeros(list, new BiPredicate<Integer, Integer>() {
		@Override
		public boolean test(Integer n1, Integer n2) {
			return mayorQueCincuenta(n1, n2);
		}
	});
	
	//Mediante una expresion lambda.
	List<Integer> numerosEncontrados2 = encontrarNumeros(list, (n1, n2) -> mayorQueCincuenta(n1, n2));
	
	
	
	//Metodo referenciado a un metodo estatico.
	List<Integer> numerosEncontrados3 = encontrarNumeros(list, MethodReferenced::mayorQueCincuenta);
}
