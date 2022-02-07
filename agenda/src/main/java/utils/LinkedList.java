package utils;
	
@SuppressWarnings("unused")
public class LinkedList<Type> implements List<Type> {

	private class ListElement {
		public Type value;
		public ListElement next;
		public ListElement previous;
		
		public ListElement(Type value) {
			this.value = value;
		}
	}
	
	private int length;
	public ListElement first;
	public ListElement last;
	
	public LinkedList() {
		
	}

	@Override
	public void add(Type element) {
		ListElement newElement = new ListElement(element);
		if(first == null) {
			first = newElement;
		} else {
			last.next = newElement;
			newElement.previous = last;
		}
		last = newElement;
		length++;
	}

	@Override
	public void remove(Type element) {
		ListElement current = first;
		while( current != null) {
			if (current.value == element) {
				if(current == first) { // début de liste
					first = current.next;
					if(first.previous != null) {
						first.previous = null;				
					} else {
						last = null;
					}
				} else if(current == last) { // fin de liste
					last = current.previous;
					last.next =null;
				} else { // milieu de liste
					current.previous.next = current.next;
					current.next.previous = current.previous;
				} 
				//instruction globale
				current = null;
				length--;
				break;
			}
			current = current.next;
		}
	}

	@Override
	public void remove(int index) {
		ListElement current = first;
		int currentIndex = 0;
		while( current != null) {
			if (currentIndex == index) {
				if(current == first) { // début de liste
					first = current.next;
					if(first.previous != null) {
						first.previous = null;				
					} else {
						last = null;
					}
				} else if(current == last) { // fin de liste
					last = current.previous;
					last.next =null;
				} else { // milieu de liste
					current.previous.next = current.next;
					current.next.previous = current.previous;
				} 
				//instruction globale
				current = null;
				length--;
				break;
			}
			currentIndex++;
		}		
	}

	@Override
	public Type get(int index) {
		if(index > length) {
			return null;
		}
		ListElement current = first;
		int currentIndex = 0;
		while( current != null) {
			if (currentIndex == index) {
				return current.value;
			}
			index++;
			current = current.next;
		}
		return null;
	}

	@Override
	public int length() {
		return length;
	}

	@Override
	public boolean contains(Type element) {
		ListElement current = first;
		while( current != null) {
			if (current.value == element) {
				return true;
			}
		}
		return false;
	}

	@Override
	public int indexOf(Type element) {
		ListElement current = first;
		int index = 0;
		while( current != null) {
			if (current.value == element) {
				return index;
			}
			index++;
			current = current.next;
		}
		return -1;
	}

}
