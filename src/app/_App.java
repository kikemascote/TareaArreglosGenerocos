package app;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Bolsa<Integer> enteros = new Bolsa<>(Integer.class);
		
		
		Integer i, vec[] = new Integer[1000];
		System.out.println("1000 NUMEROS AL AZAR CON RANGO DEL 1 AL 1000");
		for (i = 0; i < vec.length; i++) {
			vec[i] = (int) (Math.random() * 1000 + 1);
		}
        /*
		for (i = 0; i < vec.length; i++) {
			if (i + 1 != vec.length)
				System.out.print(vec[i] + ", ");
			else
				System.out.println(vec[i] + ".");
		}
        */
		Bolsa.insertionSort (vec, vec.length);
		Bolsa.quicksort(vec,0, vec.length);
		Bolsa.gnomeSort(vec);
		Bolsa.seleccion(vec);
		Bolsa.heapSort(vec);
		Bolsa.CocktailSort(vec);
		Bolsa.shell(vec);
		
		/*FIN DE LOS LLAMADOS DE LA CLASE BOLSA*/
		
		 System.out.println("Sorted Array: ");
		    for(Integer i1 : vec)
		    {
		      System.out.println(i1);
		    }
		
	}

	

}