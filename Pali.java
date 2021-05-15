package GettingReadyForAmdocs;

import java.util.LinkedList;

public class Pali {
public static void main(String[] args) {
	LinkedList<Integer> list = new LinkedList<>();
	list.add(1);
	list.add(3);
	list.add(1);
	System.out.println("is palindrome? "+isPali(list));
}
public static <T> boolean isPali(LinkedList<T> list)
{
	while (list.size()>1) {
		if (list.removeLast() != list.removeFirst())
			return false;
	}
	return true;
}
}
