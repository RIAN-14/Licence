package utils;

@SuppressWarnings("unchecked")
public class ArrayList<Type> implements List<Type> {
	private Type content[];
	private int numberOfElements;
	public ArrayList() {
		content = (Type[])(new Object[1]);
		numberOfElements = 0;
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
	@Override
	public void clear() {
		for (int i = 0; i < numberOfElements; i++) {
			content[i] = null
		}
		numberOfElements = 0;
	}
	@Override
	public boolean isEmpty() {
		return numberOfElements == 0;
	}
}
