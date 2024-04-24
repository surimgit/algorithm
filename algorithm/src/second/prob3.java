package second;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Random;

public class prob3 {

	public static void main(String[] args) {

		PriorityQueue<Integer> heapQueue = new PriorityQueue<>(Collections.reverseOrder());
		heapQueue = makeHeapQueue();;
		
		int[] arrQueue = new int[100000];
		arrQueue = makeArrQueue();

		Random rand = new Random();

		long beforeTime = System.currentTimeMillis(); 
		for(int i = 0; i < 100000; i++) {
			int n = rand.nextInt(2);
			testArr(n, i, arrQueue);
		}
		long afterTime = System.currentTimeMillis();
	    long secDiffTime = (afterTime - beforeTime)/1000;
	    System.out.println("배열 : "+secDiffTime);
		
	    beforeTime = System.currentTimeMillis(); 
		for(int i = 0; i < 100000; i++) {
			int n = rand.nextInt(2);
			testQueue(n, i, heapQueue);
		}
		afterTime = System.currentTimeMillis();
	    secDiffTime = (afterTime - beforeTime)/1000;
	    System.out.println("힙 : "+secDiffTime);
		
		
	}
	
	public static PriorityQueue<Integer> makeHeapQueue(){
		PriorityQueue<Integer> heapQueue = new PriorityQueue<>(Collections.reverseOrder());
		Random rand = new Random();
		for(int i = 0; i < 100000; i++) {
			int a = rand.nextInt(100000);
			heapQueue.add(a);
		}
		
		return heapQueue;
	}
	
	public static int[] makeArrQueue() {
		int[] arrQueue = new int[100000];
		Random rand = new Random();
		for(int i = 0; i < 100000; i++) {
			int a = rand.nextInt(100000);
			arrQueue[i] = a;
		}

		int n = 100000;
		
		for(int i = 100000/2 -1; i >=0; i--) {
			Max_Heapify(arrQueue, n, i);
		}
		
		return arrQueue;
	}
	
	public static void Max_Heapify(int[] heap, int n, int i) {
		int largest = i;
		int l = 2 * i + 1;
        int r = 2 * i + 2;
        if(l < n &&  heap[l] > heap[largest])
            largest = l;
        if(r < n && heap[r] > heap[largest])
            largest = r;
        if(largest != i) {
            int swap = heap[i];
            heap[i] = heap[largest];
            heap[largest] = swap;
            Max_Heapify(heap, n, largest);
        }
		
	}
	
	public static int[] testArr(int M, int a, int[] arrHeap) {		
		if(M == 1) {
			int n = arrHeap.length + 1;
			int[] newHeap = new int[n];
			System.arraycopy(arrHeap, 0, newHeap, 0, arrHeap.length);
			newHeap[n - 1] = a;
	        for (int i = n / 2 - 1; i >= 0; i--) {
	            Max_Heapify(newHeap, n, i);
	        }

	        return newHeap;

		}
		else {
			if(arrHeap.length < 1)
				return arrHeap;
			int n = arrHeap.length;
			int max = arrHeap[0];
			arrHeap[0] = arrHeap[n - 1];
			n--;
			Max_Heapify(arrHeap, n, 0);
			int[] newHeap = new int[n];
	        System.arraycopy(arrHeap, 0, newHeap, 0, n);
	        return newHeap;
		}
		
	}
	
	public static void testQueue(int M, int a,PriorityQueue<Integer> heapQueue) {
		if(M == 1) {
			heapQueue.add(a);
		}
		else {
			heapQueue.poll();			
		}	
	}
	
}
