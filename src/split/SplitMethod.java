package split;

import java.util.ArrayList;
import java.util.List;

public class SplitMethod {

	public static void main(String[] args) {
		List<String> names = new ArrayList<>();
        names.add("jorge_armando_sandoval_latin");
        names.add("mayra_aracely_sandoval_latin");
        names.add("ada_paty_sandoval_latin");
        names.add("saul_enrique_sandoval_latin");
        names.add("maria_elena_sandoval_latin");
        
        List<Persona> personas = new ArrayList<>();
        String vector[];
        
        //Separation by regular expression.
        for(String s : names) {
        	vector = s.split("_");
        	personas.add(new Persona(vector[0], vector[1], vector[2], vector[3]));
        }
        
        //Printed result.
        personas.stream()
        	.forEach(p -> System.out.println(p.getPrimerNombre()
        			+"\t" + p.getSegundoNombre()
        			+"\t" + p.getPrimerApellido()
        			+"\t" + p.getSegundoApellido())
        	);
	}
	
}
