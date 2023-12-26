import java.util.ArrayList;

public class KeywordList {
	private ArrayList<Keyword> lst;
	
	public KeywordList(){
		this.lst = new ArrayList<Keyword>();
    }
	
	public void add(Keyword keyword){
		lst.add(keyword);
    }
	
	//Quick sort
	public void sort(){
		if(lst.size() == 0)
		{
			System.out.println("InvalidOperation");
		}
		else 
		{
			quickSort(0, lst.size()-1);
		}
	}
	
	private void quickSort(int leftbound, int rightbound){
		//1. Implement QuickSort algorithm
		if (leftbound >= rightbound) {
			return;
		}
		int pivot = rightbound;
		int i = rightbound - 1;
		int j = leftbound;
		while(j < i) {
			while(lst.get(j).count < lst.get(pivot).count) {
				j++;
			}
			while(lst.get(i).count >= lst.get(pivot).count) {
				i--;
			}
			if(j < i) {
				swap(j, i);
			}
		}
		swap(pivot, j);
		quickSort(leftbound, j - 1);
		quickSort(j + 1, rightbound);
	}
	
	private void swap(int aIndex, int bIndex){
		Keyword temp = lst.get(aIndex);
		lst.set(aIndex, lst.get(bIndex));
		lst.set(bIndex, temp);
	}
	
	public void output(){
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < lst.size(); i++){
			Keyword k = lst.get(i);
			if(i > 0)sb.append(" ");
			sb.append(k.toString());
		}
		
		System.out.println(sb.toString());	
	}
}