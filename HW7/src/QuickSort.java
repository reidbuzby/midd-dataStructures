import java.util.LinkedList;

public class QuickSort {
	
	LinkedList<Word> list = new LinkedList<Word>();//global list
	
	public QuickSort(LinkedList<Word> list) {//constructor
		this.list=list;
	}
	
	public LinkedList<Word> getList() {//get the list created
		return list;
	}
	
	public void swap(int i, int j) {//method to swap two elements
		Word temp = new Word(null);
		temp.setName(list.get(i).toString());
		temp.setLineList(list.get(i).getLineList());
		list.get(i).setName(list.get(j).toString());
		list.get(i).setLineList(list.get(j).getLineList());
		list.get(j).setName(temp.toString());
		list.get(j).setLineList(temp.getLineList());
	}
	
	public void quickSort(int first, int last) {//quick sort algorithm applied on the global list
		int i = first;
		int j = last;
		Word pivot = list.get(first+(last-first)/2);
		while(i<=j) {
			while(list.get(i).compareTo(pivot)==-1){
				i++;
			}
			while(list.get(j).compareTo(pivot)==1) {
				j--;
			}
			if(i<=j) {
				swap(i,j);
				i++;
				j--;
			}
		}
		if(first<j) {
			quickSort(first,j);
		}
		if(i<last) {
			quickSort(i,last);
		}
	}
}
