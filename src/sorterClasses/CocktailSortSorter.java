package sorterClasses;

public class CocktailSortSorter<E> extends AbstractSorter<E> {
	
	public CocktailSortSorter() { 
		super(" Cocktail Sort"); 
	}
	
	@Override
	protected void auxSort() {
		
		boolean changed = true;
	      int i = 0;
	      int j = arr.length - 1;
	      while(i < j && changed) 
	      {
	         changed = false;
	         for(int k = i; k < j; k++) 
	         {
	            if(cmp.compare(arr[k], arr[k+1]) > 0) 
	            {
	            	swapArrayElements(k, k+1);
	            	changed = true;
	            }
	         }
	         j--;
	         if(changed) 
	         {
	            changed = false;
	            for(int k = j; k > i; k--) 
	            {
	               if(cmp.compare(arr[k], arr[k-1])<0) 
	               {
	            	   swapArrayElements(k, k-1);
	            	   changed = true;
	               }
	            }
	         }
	         i++;
	      }   
	}
}
