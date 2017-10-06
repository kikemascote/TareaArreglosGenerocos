package app;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

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
		Bolsa<T> newbag = new Bolsa<>(type, data.length);
		T[] copia = Arrays.copyOf(data, data.length);
		long startTime = System.currentTimeMillis();
		boolean flag = true;
		for (int i = 1; i < copia.length && flag; i++) {
			flag = false;
			for (int j = copia.length - 1; j >= i; j--) {
				if (copia[j - 1].compareTo(copia[j]) == 1) {
					T tmp = copia[j - 1];
					copia[j - 1] = copia[j];
					copia[j] = tmp;
					flag = true;
				} // end if
			} // end for
		}
		for (T com : copia) {
			newbag.add(com);
		}
		long stopTime = System.currentTimeMillis();
		long elapsedTime = stopTime - startTime;
		System.out.println("el timpo de bubble " + elapsedTime);
		return newbag;
	}

	/* INICIO DE METODOS DE ORDENAMIENTO */
	public <T extends Comparable<T>> T[] insertionSort() {
		T[] list = (T[]) Arrays.copyOf(data, data.length);
		int size = data.length;
		int outCounter, inCounter;
		T temp;
		// Sort list[] into increasing order.
		long startTime = System.currentTimeMillis();

		for (outCounter = 1; outCounter < size; outCounter++) {
			temp = list[outCounter];
			for (inCounter = outCounter; inCounter > 0 && list[inCounter - 1].compareTo(temp) > 0; inCounter--) {
				list[inCounter] = list[inCounter - 1];
			}
			list[inCounter] = temp;
		}

		long stopTime = System.currentTimeMillis();
		long elapsedTime = stopTime - startTime;
		System.out.println("el timpo de insertion " + elapsedTime);
		return list;
	}

	public <T extends Comparable<T>> T[] gnomeSort() {
		T[] array = (T[]) Arrays.copyOf(data, data.length);

		long startTime = System.currentTimeMillis();

		for (int index = 1; index < array.length;) {
			if (array[index - 1].compareTo(array[index]) <= 0) {
				++index;
			} else {
				T tempVal = (T) array[index];
				array[index] = array[index - 1];
				array[index - 1] = tempVal;
				--index;
				if (index == 0) {
					index = 1;
				}
			}
		}
		long stopTime = System.currentTimeMillis();
		long elapsedTime = stopTime - startTime;
		System.out.println("el timpo de gnome " + elapsedTime);
		return array;
	}

	public <T extends Comparable<T>> T[] seleccion() {
		T[] A = (T[]) Arrays.copyOf(data, data.length);
		int i, j, pos;
		T menor, tmp;
		long startTime = System.currentTimeMillis();

		for (i = 0; i < A.length - 1; i++) {
			menor = A[i];
			pos = i;
			for (j = i + 1; j < A.length; j++) {
				if (A[j].compareTo(menor) < 0) {
					menor = A[j];
					pos = j;
				}
			}
			if (pos != i) {
				tmp = A[i];
				A[i] = A[pos];
				A[pos] = tmp;
			}
		}

		long stopTime = System.currentTimeMillis();
		long elapsedTime = stopTime - startTime;
		System.out.println("el timpo de selecction " + elapsedTime);
		return A;
	}

	public T[] Qsort() {

		T[] a = (T[]) Arrays.copyOf(data, data.length);
		long startTime = System.currentTimeMillis();
		quicksort(a, 0, a.length - 1);
		long stopTime = System.currentTimeMillis();
		long elapsedTime = stopTime - startTime;
		System.out.println("el timpo de quick " + elapsedTime);
		return a;
	}

	public static <T extends Comparable<T>> T[] quicksort(T[] b, int low, int high) {
		int i = low, j = high;

		T pivot = b[low + (high - low) / 2];

		while (i <= j) {
			while (b[i].compareTo(pivot) == -1) {
				i++;
			}
			while (b[j].compareTo(pivot) == 1) {
				j--;
			}

			if (i <= j) {
				// exchange
				T temp = (T) b[i];
				b[i] = b[j];
				b[j] = temp;

				i++;
				j--;
			}
		}
		// Recursion
		if (low < j)
			quicksort(b, low, j);
		if (i < high)
			quicksort(b, i, high);

		return b;

	}

	////// HeapSort ///////////////////////////

	public <T extends Comparable<T>> T[] heapSort() {
		T[] array = (T[]) Arrays.copyOf(data, data.length);
		int length = array.length;

		long startTime = System.currentTimeMillis();

		buildMaxHeap(array, length);
		for (int i = length - 1; i > 0; i--) {
			T temp = array[0];
			array[0] = array[i];
			array[i] = temp;
			maxHeapify(array, 1, i);
		}

		long stopTime = System.currentTimeMillis();
		long elapsedTime = stopTime - startTime;
		System.out.println("el timpo de heap " + elapsedTime);
		return array;
	}

	private static <T extends Comparable> void buildMaxHeap(T[] array, int heapSize) {
		if (array == null) {
			throw new NullPointerException("null");
		}
		if (array.length <= 0 || heapSize <= 0) {
			throw new IllegalArgumentException("illegal");
		}
		if (heapSize > array.length) {
			heapSize = array.length;
		}

		for (int i = heapSize / 2; i > 0; i--) {
			maxHeapify(array, i, heapSize);
		}
	}

	private static <T extends Comparable<T>> void maxHeapify(T[] array, int index, int heapSize) {
		int l = index * 2;
		int r = l + 1;
		int largest;

		if (l <= heapSize && array[l - 1].compareTo(array[index - 1]) == 1) {
			largest = l;
		} else {
			largest = index;
		}

		if (r <= heapSize && array[r - 1].compareTo(array[largest - 1]) == 1) {
			largest = r;
		}
		if (largest != index) {
			T temp = array[index - 1];
			array[index - 1] = array[largest - 1];
			array[largest - 1] = temp;
			maxHeapify(array, largest, heapSize);
		}
	}

	////////////// Fin HeapSort/////////////////////////

	public <T extends Comparable<T>> T[] CocktailSort() {
		T[] arreglocopia = (T[]) Arrays.copyOf(data, data.length);
		boolean bandera = true;
		int i = 0;
		int j = arreglocopia.length - 1;
		long startTime = System.currentTimeMillis();

		while (i < j && bandera) {

			for (int k = 0; k < j; k++) {

				if (arreglocopia[k + 1].compareTo(arreglocopia[k]) <= 0) {
					T aux = arreglocopia[k];
					arreglocopia[k] = arreglocopia[k + 1];
					arreglocopia[k + 1] = aux;
					bandera = true;
				}
			}
			j--;
			if (bandera) {
				bandera = false;
				for (int k = j; k > i; k--) {
					if (arreglocopia[k - 1].compareTo(arreglocopia[k]) >= 0) {
						T aux = arreglocopia[k];
						arreglocopia[k] = arreglocopia[k - 1];
						arreglocopia[k - 1] = aux;
						bandera = true;
					}
				}
			}
			i++;
		}

		long stopTime = System.currentTimeMillis();
		long elapsedTime = stopTime - startTime;
		System.out.println("el timpo de cocktali " + elapsedTime);
		return arreglocopia;
	}

	public <T extends Comparable<T>> T[] shell() {
		T[] values = (T[]) Arrays.copyOf(data, data.length);
		long startTime = System.currentTimeMillis();

		for (int gap = values.length / 2; gap > 0; gap = gap == 2 ? 1 : (int) (gap / 2.2)) {
			for (int i = gap; i < values.length; i++) {

				T tmp = (T) values[i];
				int j;

				for (j = i; j >= gap && values[j - gap].compareTo(tmp) == 1; j -= gap) {
					values[j] = values[j - gap];
				}
				values[j] = tmp;
			}
		} // Primer FOR

		long stopTime = System.currentTimeMillis();
		long elapsedTime = stopTime - startTime;
		System.out.println("el timpo de shell " + elapsedTime);
		return values;
	}

	public <T extends Comparable<T>> T[] CountingSort() {
		T[] A = (T[]) Arrays.copyOf(data, data.length);
		Map<T, Integer> counts = new TreeMap<>();
		long startTime = System.currentTimeMillis();

		for (T t : A) {
			counts.merge(t, 1, Integer::sum);
		}

		int i = 0;
		for (Map.Entry<T, Integer> entry : counts.entrySet()) {
			for (int j = 0; j < entry.getValue(); j++)
				A[i++] = entry.getKey();
		}

		long stopTime = System.currentTimeMillis();
		long elapsedTime = stopTime - startTime;
		System.out.println("el timpo de counting " + elapsedTime);
		return A;
	}

	public void MergeSort(){
		long in=System.currentTimeMillis();
		T[] arrNew = data;
		mergesort(arrNew, 0, arrNew.length-1);
		long en=System.currentTimeMillis();
		long cu=en-in;
		System.out.println("El tiempo de Merge " + cu);
	}
	public void mergesort(T[] a, int i, int j) {
		if (j - i < 1)
			return;
		int mid = (i + j) / 2;

		mergesort(a, i, mid);
		mergesort(a, mid + 1, j);
		merge(a, i, mid, j);
	}

	@SuppressWarnings("unchecked")
	private void merge(T[] a, int p, int mid, int q) {
		T[] tmp = (T[]) Array.newInstance(type, q - p + 1);
		int i = p;
		int j = mid + 1;
		int k = 0;

		while (i <= mid && j <= q) {
			if (a[i].compareTo(a[j]) <= 0)
				tmp[k] = a[i++];
			else
				tmp[k] = a[j++];
			k++;
		}
		if (i <= mid && j > q) {
			while (i <= mid)
				tmp[k++] = a[i++];
		} else {
			while (j <= q)
				tmp[k++] = a[j++];
		}
		for (k = 0; k < tmp.length; k++) {
			a[k + p] = (T) (tmp[k]);
		}
	}

	public void printMerge(T[] a) {
		for (int i = 0; i < a.length; i++)
			System.out.println(a[i].toString());
	}

	/* FIN DE METODOS DE ORDENAMIENTO */

	@Override
	public Iterator<T> iterator() {

		return new Iterator<T>() {
			int i = 0;

			@Override
			public boolean hasNext() {

				return (i < counter);
			}

			@Override
			public T next() {

				return data[i++];
			}
		};
	}

}
