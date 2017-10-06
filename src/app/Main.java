package app;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Bolsa<Integer> bolsa = new Bolsa<Integer>(Integer.class,1000);
		
		
		Integer i, vec[] = new Integer[1000];
		System.out.println("1000 NUMEROS AL AZAR CON RANGO DEL 1 AL 1000");
		for (i = 0; i < vec.length; i++) {
			bolsa.add((int) (Math.random() * 1000 + 1));
		}
     
		bolsa.bubblesort();
		
		bolsa.insertionSort ();
		
		bolsa.Qsort();
        
        bolsa.gnomeSort();
		
        bolsa.seleccion();
		
        bolsa.heapSort();
		
        bolsa.CocktailSort();
		
        bolsa.shell();
        
        bolsa.CountingSort();
        
		bolsa.MergeSort();

		
	}

}
