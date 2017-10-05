public class Mezcla<T> {
	public static int[] MezclaDirecta(int[] arreglo) {
		int i, j, k;
		if (arreglo.length > 1) {
			int nEleIzq = arreglo.length / 2;
			int nEleDer = arreglo.length - nEleIzq;
			int arregloIzq[] = new int[nEleIzq];
			int arregloDer[] = new int[nEleDer];
			for (i = 0; i < nEleIzq; i++) {
				arregloIzq[i] = arreglo[i];
			}
			for (i = nEleIzq; i < nEleIzq + nEleDer; i++) {
				arregloDer[i - nEleIzq] = arreglo[i];
			}
			arregloIzq = MezclaDirecta(arregloIzq);
			arregloDer = MezclaDirecta(arregloDer);
			i = 0;
			j = 0;
			k = 0;
			while (arregloIzq.length != j && arregloDer.length != k) {
				if (arregloIzq[j] < arregloDer[k]) {
					arreglo[i] = arregloIzq[j];
					i++;
					j++;
				} else {
					arreglo[i] = arregloDer[k];
					i++;
					k++;
				}
			}
			while (arregloIzq.length != j) {
				arreglo[i] = arregloIzq[j];
				i++;
				j++;

			}
			while (arregloDer.length != k) {
				arreglo[i] = arregloDer[k];
				i++;
				k++;

			}
		}
		return arreglo;
	}

	public void MezclaNatural(int arreglo[]) {
		int izquierda = 0, izq = 0, derecha = arreglo.length - 1, der = derecha;
		boolean ordenado = false;
		do {
			ordenado = true;
			izquierda = 0;
			while (izquierda < derecha) {
				izq = izquierda;
				while (izq < derecha && arreglo[izq] <= arreglo[izq + 1]) {
					izq++;
				}
				der = izq + 1;
				while (der == derecha - 1 || der < derecha && arreglo[der] <= arreglo[der + 1]) {
					der++;
				}
				if (der <= derecha) {
					MezclaDirecta(arreglo);
					ordenado = false;
				}
				izquierda = izq;
			}

		} while (!ordenado);
	}
	
	public void mostrar(int [] arreglo) {
		for(int i = 0; i < arreglo.length; i++){
			System.out.print("["+ arreglo[i] + "]");
		}
		System.out.println();
	}
}
