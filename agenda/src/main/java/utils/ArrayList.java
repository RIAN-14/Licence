package utils;

@SuppressWarnings("unchecked")
public class ArrayList<Type> implements List<Type> {

	private Type content[];
	private int numberOfElements;
	
	public ArrayList() {
		content = (Type[]) new Object[10];
		numberOfElements=0;
	}
	
	@Override
	public void add(Type element) {
		int size = content.length;
		if(numberOfElements == size) {
			Type biggerArray[] = (Type[]) new Object[size*2];
			for (int i = 0; i < content.length; i++) {
				biggerArray[i] = content[i];
			}
			content = (Type[]) biggerArray;
		} else {
			content[numberOfElements] = element;
			numberOfElements++;
		}
	}

	
	@Override
	public void remove(Type element) {
		remove(indexOf(element));
	}

	@Override
	public void remove(int index) {
		numberOfElements--;
		for (int i = index; i < content.length; i++) {
			content[i] = content[i+1];
		}
		content[numberOfElements] = null;;
	}

	@Override
	public Type get(int index) {
		return content[index];
	}

	@Override
	public int length() {
		return numberOfElements;
	}

	@Override
	public boolean contains(Type element) {
		for (int i = 0; i < content.length; i++) {
			if(content[i] == element) return true;
		}
		return false;
	}

	@Override
	public int indexOf(Type element) {
		for (int i = 0; i < content.length; i++) {
			if(content[i] == element) return i;
		}
		return -1;
	}

}
