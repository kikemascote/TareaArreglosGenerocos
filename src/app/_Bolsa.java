package app;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Iterator;

public class Bolsa<T extends Comparable<T>> implements Iterable<T> {
	private T[] data = null;
	private Class<T> type = null;
	private int counter = 0;

	public Bolsa(Class<T> type) {
		// TODO Auto-generated constructor stub
		data = (T[]) Array.newInstance(type, 10);
		this.type = type;
	}

	public Bolsa(Class<T> type, int size) {
		data = (T[]) Array.newInstance(type, size);
		this.type = type;
	}

	public boolean add(T value) {
		if (counter < data.length) {
			data[counter++] = value;
			return true;
		} else
			return false;
	}

	public void printer() {
		for (int i = 0; i < counter; i++) {
			System.out.println(data[i].toString());
		}
	}

	public Bolsa<T> bubblesort() {

		int index = 0;
		Bolsa<T> newbag = new Bolsa<>(type,data.length);
		T[] copia = Arrays.copyOf(data, data.length);
		boolean flag = true;
		for (int i = 1; i < copia.length && flag; i++) {
			flag = false;
			for (int j = copia.length-1; j >= i; j--) {
				if(copia[j-1].compareTo(copia[j]) == 1 ){
					T tmp = copia[j-1];
					copia[j-1] = copia[j];
					copia[j] = tmp;
					flag = true;
				}//end if
			}//end for
		}
		for(T com:copia){
			newbag.add(com);
		}
		return newbag;
	}

	/*INICIO DE METODOS DE ORDENAMIENTO*/
	public static <T extends Comparable<T>> void insertionSort (T[] list, int size) {
		int outCounter, inCounter;
	    T temp;
	    // Sort list[] into increasing order.
	    for (outCounter = 1; outCounter < size; outCounter++)
	    {
	      temp = list[outCounter];
	      for (inCounter = outCounter; inCounter > 0 && list[inCounter - 1].compareTo(temp) > 0; inCounter--)
	      {
	        list[inCounter] = list[inCounter - 1];
	      }
	      list[inCounter] = temp;
	    }
	  }

	public static <T extends Comparable<T>> T[] gnomeSort(T[] array) {
		for ( int index = 1; index < array.length; ) {
	         if (array[index - 1].compareTo(array[index]) <= 0) {
	            ++index;
	         } else {
	            T tempVal = (T) array[index];
	            array[index] = array[index - 1];
	            array[index - 1] =  tempVal;
	            --index;
	            if ( index == 0 ) {
	               index = 1;
	            }
	         }
	      }
	      System.currentTimeMillis();
	      return array;
 }

	public static <T extends Comparable<T>> T[] seleccion(T[] A) {
        int i, j, pos;
       T menor , tmp;
        for (i = 0; i < A.length - 1; i++) {
              menor = A[i];
              pos = i;
              for (j = i + 1; j < A.length; j++){
                    if (A[j].compareTo(menor) < 0) {
                        menor = A[j];
                        pos = j;
                    }
              }
              if (pos != i){
                  tmp = A[i];
                  A[i] = A[pos];
                  A[pos] = tmp;
              }
        }
		return A;
	}

	public static  <T extends Comparable<T>>  void quicksort(T[] b,int low, int high) {
	         int i = low,  j = high;

	         T pivot =  b[(low + (high-low)/2)];

	         while (i <= j) {
	           while (b[i].compareTo(pivot) == -1) {
	                i++;
	            }
	             while (b[j].compareTo(pivot) == 1) {
	                j--;
	            }

	            if (i <= j) {
	                //exchange
	            	 T temp = (T) b[i];
	            	 b[i]=b[j];
	            	 b[j]=temp;

	                i++;
	                j--;
	            }
	        }
	        // Recursion
	        if (low < j)
	            quicksort(b,low, j);
	        if (i < high)
	            quicksort(b,i, high);
	    }

			////// HeapSort ///////////////////////////

				public static <T> void heapSort(T[] array){
					int length = array.length;
					//Bolsa<T> newbag = new Bolsa<>(type,data.length);

					    buildMaxHeap(array, length);
					for(int i= length -1; i>0; i--){
						T temp = array[0];
						array[0]=array[i];
						array[i]=temp;
						maxHeapify(array,1,i);
					}
					
					//return newbag;
				}

				private static <T> void buildMaxHeap (T[]array , int heapSize){
					if(array == null){
						throw new NullPointerException("null");
					}
					if(array.length<=0 || heapSize <=0){
						throw new IllegalArgumentException("illegal");
					}
					if(heapSize > array.length){
						heapSize= array.length;
					}

					for(int i=heapSize/2; i>0; i--){
						maxHeapify(array, i, heapSize);
					}
				}
				private static <T>void maxHeapify(T[]array, int index, int heapSize){
					int l=index*2;
					int r = l +1;
					int largest;

					if (l<= heapSize && array[l-1].compareTo(array[index -1])==1) {
						largest = l;
					}else{
						largest=index;
					}

					if (r <= heapSize && array[r - 1].compareTo(array[largest - 1])==1) {
						largest=r;
					}
					if (largest != index) {
						T temp=array[index - 1];
						array[index - 1]=array[largest - 1];
						array[largest - 1] = temp;
						maxHeapify(array, largest, heapSize);
					}
				}

				//////////////Fin HeapSort/////////////////////////

				public static <T extends Comparable<T>> void CocktailSort(T[] ar){
						T[] arreglocopia= Arrays.copyOf(ar, ar.length);
						boolean bandera =true;
						int i=0;
						int j=arreglocopia.length-1;
						while(i<j &&bandera) {

							for(int k=0;k<j;k++){

								if(arreglocopia[k+1].compareTo(arreglocopia[k])<=0 ){
								T aux = arreglocopia[k];
								arreglocopia[k] = arreglocopia[k+1];
								arreglocopia[k+1] = aux;
								bandera=true;
								}
								}
								j--;
								if (bandera)
								{
									bandera=false;
									for(int k=j;k>i;k--){
										   if(arreglocopia[k-1].compareTo(arreglocopia[k])>=0){
										   T aux = arreglocopia[k];
										   arreglocopia[k] = arreglocopia[k-1];
										    arreglocopia[k-1] = aux;
										    bandera=true;
										 }
										}
								}
								i++;
						}
					//return arreglocopia;
					}


					public static <T extends Comparable<T>> void shell(T[] values) {
		//Recordar que values es nuestra variable tipo Bolsa.

		//Primer FOR,  dividimos la longitud de nuestro
		//arreglo entre 2, para crear los subgrupos que se
		//van a ir analizando
			for( int gap = values.length / 2; gap > 0; gap = gap == 2 ? 1 : (int) ( gap / 2.2 ) ){
				for( int i = gap; i < values.length ; i++ ){

					T tmp = (T) values[i];
					int j;

					for(j = i; j >= gap && values[ j - gap ].compareTo(tmp) == 1; j -= gap ){
						values[j]= values[ j - gap ];
					}
				values[j]=tmp;
				}
			}//Primer FOR

	}//Fin del método.













	/*FIN DE METODOS DE ORDENAMIENTO*/

	@Override
	public Iterator<T> iterator() {

		return new Iterator<T>() {
			int i=0;
			@Override
			public boolean hasNext() {

				return (i<counter);
			}
			@Override
			public T next() {

				return data[i++];
			}
		};
	}

}
