package second;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class prob1 {
	public static void main(String[] args) throws IOException {
		 BufferedReader reader = new BufferedReader(new FileReader("d:\\\\harry_full.txt"));
	     String line;
	     StringBuilder content = new StringBuilder();
	     while ((line = reader.readLine()) != null) {
	    	 content.append(line).append(" ");
	     }
	     reader.close();
	     String[] words = content.toString().split("\\s+");
	     
	     
	     String[] bubbleSorted = Arrays.copyOf(words, words.length);
	     long beforeTime = System.currentTimeMillis(); 
	     bubbleSort(bubbleSorted);	           
	     long afterTime = System.currentTimeMillis(); 
	     long secDiffTime = (afterTime - beforeTime)/1000; 
	     System.out.println("시간차이(m) : "+secDiffTime);
	     
	     String[] insertionSorted = Arrays.copyOf(words, words.length);
	     beforeTime = System.currentTimeMillis(); 
	     insertionSort(insertionSorted);	           
	     afterTime = System.currentTimeMillis();
	     secDiffTime = (afterTime - beforeTime)/1000;
	     System.out.println("시간차이(m) : "+secDiffTime);
	   	     	    	     
	     String[] mergeSorted = Arrays.copyOf(words, words.length);
	     beforeTime = System.currentTimeMillis();  
	     mergeSort(mergeSorted,0, mergeSorted.length - 1);	           
	     afterTime = System.currentTimeMillis(); 
	     secDiffTime = (afterTime - beforeTime)/1000; 
	     System.out.println("시간차이(m) : "+secDiffTime);
	     
	     String[] quickSorted = Arrays.copyOf(words, words.length);
	     beforeTime = System.currentTimeMillis();   
	     quickSort(quickSorted,0, quickSorted.length - 1);	           
	     afterTime = System.currentTimeMillis(); 
	     secDiffTime = (afterTime - beforeTime)/1000; 
	     System.out.println("시간차이(m) : "+secDiffTime);
	          
	     String[] heapSorted = Arrays.copyOf(words, words.length);
	     beforeTime = System.currentTimeMillis();        
	     heapSort(heapSorted);	           
	     afterTime = System.currentTimeMillis(); 
	     secDiffTime = (afterTime - beforeTime)/1000; 
	     System.out.println("시간차이(m) : "+secDiffTime);
	          
	     String[] Sorted = Arrays.copyOf(words, words.length);
	     beforeTime = System.currentTimeMillis();        
	     Arrays.sort(Sorted);  
	     afterTime = System.currentTimeMillis(); 
	     secDiffTime = (afterTime - beforeTime)/1000; 
	     System.out.println("시간차이(m) : "+secDiffTime);
	     
	     
	}
	
	static void bubbleSort(String words[]) {
		int n = words.length;
        for(int i = 0; i < n-1; i++) {
            for(int j = 0; j < n-i-1; j++) {
                if(words[j].compareTo(words[j+1]) > 0) {
                    String temp = words[j];
                    words[j] = words[j+1];
                    words[j+1] = temp;
                }
            }
        }
	}
	
	static void insertionSort(String words[]) {
		int n = words.length;
        for(int i = 1; i < n; ++i) {
            String key = words[i];
            int j = i - 1;
            while(j >= 0 && words[j].compareTo(key) > 0) {
            	words[j + 1] = words[j];
                j = j - 1;
            }
            words[j + 1] = key;
        }
	}
	
	static void mergeSort(String[] words, int left, int right) {
		if(left < right) {
			
	        int mid = (left + right) / 2;

	        mergeSort(words, left, mid);
	        
	        mergeSort(words, mid + 1, right);

	        merge(words, left, mid, right);
		}
    }
	static void merge(String[] words, int left, int mid, int right) {
        int n1 = mid - left + 1; 
        int n2 = right - mid; 

        String[] leftTemp = new String[n1];
        String[] rightTemp = new String[n2];
  
        for(int i = 0; i < n1; i++) {
            leftTemp[i] = words[left + i];
        }
        
        for(int i = 0; i < n2; i++) {
            rightTemp[i] = words[mid + 1 + i];
        }

        int i = 0, j = 0;
        
        int k = left;
        
        while(i < n1 && j < n2) {
            if(leftTemp[i].compareTo(rightTemp[j]) <= 0) {
            	words[k] = leftTemp[i];
                i++;
            }else {
            	words[k] = rightTemp[j];
                j++;
            }
            k++;
        }

        while(i < n1) {
        	words[k] = leftTemp[i];
            i++;
            k++;
        }

        while(j < n2) {
        	words[k] = rightTemp[j];
            j++;
            k++;
        }
    }
	static void quickSort(String words[], int low, int high) {
		if(low < high) {
            int pi = partition(words, low, high);
            quickSort(words, low, pi - 1);
            quickSort(words, pi + 1, high);
        }
	}
	
	static int partition(String words[], int low, int high) {
		String pivot = words[high];
		int i = low - 1;
		for(int j = low; j < high; j++) {
	        if(words[j].compareTo(pivot) < 0) { 
	            i++; 

	            String temp = words[i];
	            words[i] = words[j];
	            words[j] = temp;
	        }
	    }
		String temp = words[i + 1];
		words[i + 1] = words[high];
		words[high] = temp;
	    return i + 1;
	}
	static void heapSort(String word[]) {
		int n = word.length;
		for(int i = n/2 -1; i >=0; i--) {
			 heapify(word, n, i);
		}
		for(int i = n - 1; i > 0; i--) {
            String temp = word[0];
            word[0] = word[i];
            word[i] = temp;
            heapify(word, i, 0);
        }

		
	}
	static void heapify(String[] word, int n, int i) {
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;
        if(l < n && word[l].compareTo(word[largest]) > 0)
            largest = l;
        if(r < n && word[r].compareTo(word[largest]) > 0)
            largest = r;
        if(largest != i) {
            String swap = word[i];
            word[i] = word[largest];
            word[largest] = swap;
            heapify(word, n, largest);
        }
    }
}
