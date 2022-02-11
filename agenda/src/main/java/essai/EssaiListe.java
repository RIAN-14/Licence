package essai;

import java.util.Iterator;

import utils.ArrayList;
import utils.LinkedList;
import utils.List;

public class EssaiListe {
	private static void affiche(List<String> l) {
		/*for (int i = 0; i < l.size(); i++) {
			System.out.print(l.get(i));
			System.out.print("  ");
		}
		System.out.println();*/
		for (String s: l) {
			System.out.print(s);
			System.out.print("  ");
		}
		System.out.println();
	}
	public static void main(String args[]) {
		List<String> list;
		
		System.out.println("/---------------LinkedList----------------/");
		list = new LinkedList<String>();
		list.add("un");
		affiche(list);
		list.add("deux");
		affiche(list);
		list.add("onze");
		affiche(list);
		list.add("trois");
		affiche(list);
		list.add("quatre");
		affiche(list);
		list.remove(0);
		affiche(list);
		
		System.out.println("/----------------ArrayList-----------------/");
		list = new ArrayList<String>();
		list.add("un");
		affiche(list);
		list.add("deux");
		affiche(list);
		list.add("onze");
		affiche(list);
		list.add("trois");
		affiche(list);
		list.add("quatre");
		affiche(list);
		//list.remove(0);
		//affiche(list);
		
		/*Iterator<String> it = list.iterator();
		while(it.hasNext()) {
			String s= it.next();
			char c = s.charAt(0);
			if(    c == 'a' 
				|| c == 'e' 
				|| c == 'i' 
				|| c == 'o' 
				|| c == 'u' 
				|| c == 'y') 
			{
				it.remove();
			}
		}
		affiche(list);*/
	}
}
