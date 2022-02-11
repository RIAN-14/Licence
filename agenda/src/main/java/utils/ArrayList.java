package utils;

import java.util.Iterator;

@SuppressWarnings("unchecked")
public class ArrayList<Type> implements List<Type>,Iterable<Type> {
	private Type content[];
	private int numberOfElements;
	
	public class Parcours implements Iterator<Type> {

		private int currentIndex;
		
		public Parcours() {
			currentIndex=0;
		}
		
		public boolean hasNext() {
			return currentIndex < numberOfElements;
		}

		public Type next() {
			Type current = content[currentIndex++];
			return current;
		}
		
		public void remove() {
			shiftLeft(--currentIndex);			
		}
		
	}

	public class ParcoursEnvers implements Iterator<Type> {

		private int currentIndex;
		
		public ParcoursEnvers() {
			currentIndex=numberOfElements-1;
		}
		
		public boolean hasNext() {
			return currentIndex >= 0;
		}

		public Type next() {
			Type current = content[currentIndex--];
			return current;
		}
		
		public void remove() {
			shiftLeft(currentIndex+1);	
			numberOfElements--;
		}
		
	}
	
	
	public ArrayList() {
		content = (Type[])(new Object[1]);
		numberOfElements = 0;
	}


	private void shiftLeft(int currentIndex) {
		for(int i = currentIndex; i+1 < numberOfElements;i++) {
			content[i] = content[i+1];
		}
		content[numberOfElements-1] = null;
	}
	
	public void add(Type element) {
		int size = content.length;
		if (numberOfElements == size) {
			Type bigger[] = (Type[])(new Object[size * 2]);
			for (int i = 0; i < numberOfElements; i++) {
				bigger[i] = content[i];
			}
			content = (Type[])bigger;
		}
		content[numberOfElements] = element;
		numberOfElements++;
	}
	
	public void remove(Type element) {
		remove(indexOf(element));
	}
	
	public void remove(int index) {
		numberOfElements--;
		for (int i = index; i < numberOfElements; i++) {
			content[i] = content[i+1];
		}
		content[numberOfElements] = null;
	}
	
	public Type get(int index) {
		return content[index];
	}
	
	public int size() {
		return numberOfElements;
	}
	
	public boolean contains(Type element) {
		for(int i = 0; i < numberOfElements; i++) {
			if (content[i] == element) {
				return true;
			}
		}
		return false;
	}
	
	public int indexOf(Type element) {
		for(int i = 0; i < numberOfElements; i++) {
			if (content[i] == element) {
				return i;
			}
		}
		return -1;
	}
	
	public void clear() {
		for (int i = 0; i < numberOfElements; i++) {
			content[i] = null;
		}
		numberOfElements = 0;
	}
	
	public boolean isEmpty() {
		return numberOfElements == 0;
	}
	
	@Override
	public Iterator<Type> iterator() {
		return new Parcours();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
