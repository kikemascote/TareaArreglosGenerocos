public class app {
	public static void main(String[] args) {
	Mezcla MezNat = new Mezcla();
	
	int arreglo1 []  = {-24,48,-100,7,45,98,12};
	
	System.out.println("Arreglo Original");
	MezNat.mostrar(arreglo1);
	System.out.println("Arreglo Ordenado");
	MezNat.MezclaNatural(arreglo1);
	MezNat.mostrar(arreglo1);
	

	}

}
