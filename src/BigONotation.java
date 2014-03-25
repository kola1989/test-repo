
public class BigONotation {

	/**
	 * @param args
	 */
	private int[] theArray;
	private int arraySize;
	private int itemsInArray = 0;
	static long startTime;
	static long endTime;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BigONotation testAlgo2 = new BigONotation(10000);
		testAlgo2.generateRandomArray();
		
		BigONotation testAlgo3 = new BigONotation(20000);
		testAlgo2.generateRandomArray();
		
		BigONotation testAlgo4 = new BigONotation(30000);
		testAlgo2.generateRandomArray();
		
		BigONotation testAlgo5 = new BigONotation(40000);
		testAlgo2.generateRandomArray();
		
/*		testAlgo2.linearSearhForValue(20);
		testAlgo3.linearSearhForValue(20);
		testAlgo4.linearSearhForValue(20);
		testAlgo5.linearSearhForValue(20);*/
		
		testAlgo2.bubblesort();
		testAlgo3.bubblesort();
//		testAlgo4.bubblesort();
//		testAlgo5.bubblesort();
		
		testAlgo2.binarySearchForValu(20);
		testAlgo3.binarySearchForValu(20);
	}
	
	//O(1)
	
	public void addItemToArray(int newItem){
		theArray[itemsInArray++] = newItem;
	}
	
	//0(N)
	
	public void linearSearhForValue(int value){
		boolean valueInArray = false;
		String indexsWithValue = "";
		
		startTime = System.currentTimeMillis();
		for(int i=0;i<arraySize;i++){
			if(theArray[i] == value){
				valueInArray = true;
				indexsWithValue += i + " " ;
			}
		}
		
		System.out.println("Value Found: " + valueInArray);
		System.out.println("Indexes: " + indexsWithValue);
		endTime = System.currentTimeMillis();
		System.out.println("LinearSearch took: " + (endTime-startTime));
	}
	
	//O(N^2)
	
	public void bubblesort(){
		startTime = System.currentTimeMillis();
		for(int i = arraySize-1;i>1;i--){
			for(int j = 0; j<i;j++){
				if(theArray[j]>theArray[j+1]);
				swapValues(j, j+1);
			}
		}

		endTime = System.currentTimeMillis();
		System.out.println("BubbleSort took: " + (endTime-startTime));
	}
	
	//O(log N)
	
	public void binarySearchForValu(int value){
		startTime = System.currentTimeMillis();
		
		int lowIndex = 0;
		int highIndex = arraySize-1;
		int timesThrough = 0;
		
		while(lowIndex <= highIndex){
			int middleIndex = (highIndex + lowIndex)/2;
			if(theArray[middleIndex] < value){
				lowIndex=middleIndex+1;
			}else if(theArray[middleIndex] > value){
				highIndex = middleIndex-1;
			}else{
				System.out.println("Found a match i index " + middleIndex);
				lowIndex = highIndex+1;
			}
			
			timesThrough++;
		}
		
		endTime = System.currentTimeMillis();
		System.out.println("binarysearch took: " + (endTime-startTime));
		System.out.println("Times through " + timesThrough);
	}
	
	//O(n log n)
	//
	
//	public void quickSort(int left, int right){
//		if(right-left <==0){
//			return ;
//		}else{
//			int pivot = theArray[right];
//			int pivotLocation = partitionArray(left,right,pivot);
//			quickSort(left, pivotLocation-1);
//			quickSort(pivotLocation + 1, right);
//			
//		}
//		
//	}
//	
//	public int partitionArray(int left, int right, int pivot){
//		int leftPointer = left  - 1;
//		int rightPointer = right;
//		while(true){
//			while(theArray[++leftPointer] < pivot){
//				
//			}
//		}
//	}
	
	public void generateRandomArray(){
		for(int i=0;i<arraySize;i++){
			theArray[i] = (int)(Math.random()+1000)+10;
		}
		itemsInArray = arraySize-1;
	}
	
	public void swapValues(int indexOne, int indexTwo){
		int temp = theArray[indexOne];
		theArray[indexOne] = theArray[indexTwo];
		theArray[indexTwo] = temp;
	}
	
	
	BigONotation(int size){
		arraySize = size;
		theArray = new int[size];
	}

}
