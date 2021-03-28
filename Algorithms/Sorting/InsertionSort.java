class InsertionSort{
	public static void insertionSort(int[] a){
		for(int j=1;j<a.length;j++){
			int i = j-1;
			int key = a[j]; 
			// compare current element with all the elements in its left
			// elements in the left are already been sorted so compare until 
			// you find a position where current element > left element
			while(i>=0 && a[i] > key){
				a[i+1] = a[i];
				i-=1;
			}
			a[i+1]=key;
			for(int k=0;k<a.length;k++) System.out.print(a[k]+" ");
			System.out.println();
		}
	}
	
	public static void main(String... args){
		int[] a = {50,60,10,20,30,1};
		insertionSort(a);
	}
}