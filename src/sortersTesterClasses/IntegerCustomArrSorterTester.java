package sortersTesterClasses;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

import sorterClasses.BubbleSortSorter;
import sorterClasses.CocktailSortSorter;
import sorterClasses.CombSortSorter;
import sorterClasses.InsertionSortSorter;
import sorterClasses.SelectionSortSorter;
import interfaces.Sorter;

public class IntegerCustomArrSorterTester {

	private static ArrayList<Sorter<Integer>> sortersList = new ArrayList<>(); 
	
	public static void main(String[] args) { 
		sortersList.add(new BubbleSortSorter<Integer>()); 
		sortersList.add(new SelectionSortSorter<Integer>()); 
		sortersList.add(new InsertionSortSorter<Integer>()); 
		sortersList.add(new CombSortSorter<Integer>());
		sortersList.add(new CocktailSortSorter<Integer>());
		
		test("Sorting Using Default Comparator<Integer>", null); 
		test("Sorting Using IntegerComparator1", new IntegerComparator1()); 
		test("Sorting Using IntegerComparator2", new IntegerComparator2()); 
	}
	
	private static void test(String msg, Comparator<Integer> cmp) { 
		
		Scanner sc = new Scanner(System.in);
		System.out.println("How many numbers you want to sort?: ");
		int n = sc.nextInt();
		
		Integer[] original = new Integer[n];
		
		System.out.println("Enter integers: ");
		
		for (int i = 0; i < original.length; i++) {
			original[i] = sc.nextInt();
		}

		System.out.println("\n\n*******************************************************");
		System.out.println("*** " + msg + "  ***");
		System.out.println("*******************************************************");
		
		Integer[] arr; 
		// generate random arrays is size i and test...
		for (int i=1; i<=20; i += 5) { 
			showArray("\n ---Original array of size " + i + " to sort:", original); 
			
			for (int s=0; s<sortersList.size(); s++) {
				Sorter<Integer> sorter = sortersList.get(s); 
			    arr = original.clone(); 
			    sorter.sort(arr, cmp);
			    showArray(sorter.getName() + ": ", arr); 
			}
		}
	}

	private static void showArray(String msg, Integer[] a) {
		System.out.print(msg); 
		for (int i=0; i<a.length; i++) 
			System.out.print("\t" + a[i]); 
		System.out.println();
	}

}

