package DSA.LinkedList;

public class Main {

	public static void main(String[] args) {
		var list = new LinkedList(1);

		list.append(2);
		list.append(3);
		printList(list);

		System.out.println();

		System.out.println(list.insert(3, 4));
		printList(list);

		list.reverse();
		printList(list);
		list.remove(1);
		printList(list);

	}

	public static void printList(LinkedList list) {
		System.out.println();
		System.out.println(list);
		System.out.println(list.length());

	}

}
