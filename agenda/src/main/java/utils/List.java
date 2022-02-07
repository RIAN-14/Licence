package utils;

public interface List<Type> {

	void add(Type element);
	void remove(Type element);
	void remove(int index);
	Type get(int index);
	int length();
	boolean contains(Type element);
	int indexOf(Type element);
}
