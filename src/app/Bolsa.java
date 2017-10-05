package app;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Iterator;

public class Bolsa <T extends Comparable<T>> implements Iterable<T>{

	private T[] data = null;
	private Class<T> type;
	int count = 0;
	
	
	@SuppressWarnings("unchecked")
	public Bolsa(Class <T> type) {
		data = (T[])Array.newInstance(type, 10);
		this.type = type;
	}
	@SuppressWarnings("unchecked")
	public Bolsa(Class <T> type,int n) {
		data = (T[])Array.newInstance(type, n);
		this.type = type;
	}
	
	public T get(int pos){
		return data[pos];
	}
	
	public void set(int ind, T temp){
		data[ind] = temp;
	}
	
	public int getLength(){
		return count;
	}
	
	public boolean add(T value){
		if(count < data.length){
			data[count++] = value;
		}
		
		return false;
	}
	
	public void print(){
		for (int i = 0; i < count; i++) {
			System.out.println(data[i]);
		}
	}
	
	public Bolsa<T> boubleSort (){
	    //int index;
	    boolean band = true;
	    Bolsa <T> newbag = new Bolsa<>(type, data.length);
	    T[] copia = Arrays.copyOf(data, data.length);
	   for (int i = 1; i < count && band; i++) {
		   band=false;
		   for (int j = count-1; j >= i; j--) {
				if(copia[j-1].compareTo(copia[j])==1){
					T tmp = copia[j-1];
					copia[j-1]=copia[j];
				    copia[j-1]= tmp;
				    band = true;
				}
		   }
	   }
	   for (T comp : copia) {
		   newbag.add(comp);
	   }
	   return newbag;
	   
	}
	
	@Override
	public Iterator<T> iterator() {
		return new Iterator<T>(){
			int i = 0;
			@Override
			public boolean hasNext() {
				return i< count;
			}
			@Override
			public T next() {
				return data[i++];	
			}
		};
	}
	
	@SuppressWarnings("unchecked")
	public T[] copyArray(){
		return (T[]) Array.newInstance(type, this.data.length);
	}
	
}
