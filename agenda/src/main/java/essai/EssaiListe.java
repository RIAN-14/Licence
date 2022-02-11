package essai;

import utils.ArrayList;
import utils.LinkedList;
import utils.List;

public class EssaiListe {
	private static void affiche(List<String> l) {
		for (int i = 0; i < l.size(); i++) {
			System.out.print(l.get(i));
			System.out.print("  ");
		}
		System.out.println();
	}
	public static void main(String args[]) {
		List<String> list;
		list = new LinkedList<String>();
		list.add("un");
		affiche(list);
		list.add("deux");
		affiche(list);
		list.add("trois");
		affiche(list);
		list.add("quatre");
		affiche(list);
		list.remove(0);
		affiche(list);
		
		System.out.println("/-/-/-/-///-/-/-/-//-/-/-/-/-/-/-/--");
		
		list = new ArrayList<String>();
		list.add("un");
		affiche(list);
		list.add("deux");
		affiche(list);
		list.add("trois");
		affiche(list);
		list.add("quatre");
		affiche(list);
		list.remove(0);
		affiche(list);
	}
}
