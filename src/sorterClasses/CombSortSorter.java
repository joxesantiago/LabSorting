package sorterClasses;

public class CombSortSorter<E> extends AbstractSorter<E> {
	
	public CombSortSorter() { 
		super("     Comb Sort"); 
	}
	
	@Override
	protected void auxSort() {
		
		double factor = 1.3;
		if(arr.length > 0){
			double gap = (arr.length-1)/ factor;
			
			while(gap>1){
				int i = 0;
				int j = (int) (i+ Math.floor(gap));
				while(j != arr.length){
					if(cmp.compare(arr[i],arr[j])>0){
						swapArrayElements(i,j); 					
					}
					i++;
					j++;
				}
				gap =gap/ factor;
			}
		}
	}
}
