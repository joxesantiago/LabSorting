package sortersTesterClasses;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

import sorterClasses.BubbleSortSorter;
import sorterClasses.InsertionSortSorter;
import sorterClasses.SelectionSortSorter;
import interfaces.Sorter;

public class EnteroSorterTester {
	//private static Sorter<Integer> sorter; 
	private static Random rnd; 
	private static ArrayList<Sorter<Entero>> sortersList = new ArrayList<>(); 
	
	public static void main(String[] args) { 
		sortersList.add(new BubbleSortSorter<Entero>()); 
		sortersList.add(new SelectionSortSorter<Entero>()); 
		sortersList.add(new InsertionSortSorter<Entero>()); 
		
		test("Sorting Using Default Comparator<Integer>", null); 
		//test("Sorting Using IntegerComparator1", new IntegerComparator1()); 
		//test("Sorting Using IntegerComparator2", new IntegerComparator2()); 
	}
	
	private static void test(String msg, Comparator<Entero> cmp) { 
		rnd = new Random(101); 

		System.out.println("\n\n*******************************************************");
		System.out.println("*** " + msg + "  ***");
		System.out.println("*******************************************************");
		
		Entero[] original, arr; 
		// generate random arrays is size i and test...
		for (int i=1; i<=20; i += 5) { 
			original = randomValues(i);
			showArray("\n ---Original array of size " + i + " to sort:", original); 
			
			for (int s=0; s<sortersList.size(); s++) {
				Sorter<Entero> sorter = sortersList.get(s); 
			    arr = original.clone(); 
			    sorter.sort(arr, cmp);
			    showArray(sorter.getName() + ": ", arr); 
			}
		}
	}

	private static void showArray(String msg, Entero[] arr) {
		System.out.print(msg); 
		for (int i=0; i<arr.length; i++) 
			System.out.print("\t" + arr[i]); 
		System.out.println();
	}

	private static Entero[] randomValues(int i) {
		Entero[] a = new Entero[i]; 
		for (int j=0; j<i; j++) 
			a[j] = new Entero(rnd.nextInt(100)); 
		return a;
	}

}
