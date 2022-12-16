/*
Ramazan Köpük
02190201030
örnek Dizi: 54,85,23,12,45,61,25,35,40,75
*/
package minheap;

import java.util.Arrays;
import java.util.Scanner;


public class MinHeap {

	public MinHeap(int lenght) {
		heap = new int [lenght];
		size=0;
                
	}
	private int [] heap;
	private int size;
        

	public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Dizi elemanlarını belirleyin: ");
            String elemanlar = sc.next();
            String[] Dizi = elemanlar.split(",");
            int[] dizi = new int[Dizi.length];
            for(int i =0; i<Dizi.length; i++){
                dizi[i] = Integer.parseInt(Dizi[i]);
            }
            //System.out.println("Dizi :" + Arrays.toString(dizi));
		
		MinHeap h = new  MinHeap(dizi.length);

		for (int i : dizi) {
			h.insert(i);
		}
                System.out.println("Dizi: " + Arrays.toString(h.heap));
                h.printHeap();
		
		System.out.println("Min Heap: ");
		for (int i = 0; i < h.heap.length; i++) {
			System.out.print( h.remove() + " ");
		}

	}


	private int leftChild(int position) {
		return position*2 +1;
	}

	private int rightChild(int position) {
		return position*2 +2;
	}


	private int parent(int position) {
		return position/2;
	}


	private boolean isLeaf(int position) {
		if(position >= (size / 2) && position <= size)
			 return true;
		 return false;
	}


	private  void insert(int i) {
		if(size == 0) {
			heap[0] = i;
			size++;
			return;
		}

		heap[size] = i; 
		int current = size;
		while(heap[current]<heap[parent(current)]) {
			swap(current, parent(current));
			current = parent(current);
		}
		size++;
	}
        private void printHeap() {
            for (int i = 0; i < (size / 2); i++) {
                System.out.print("Parent : " + heap[i]);
                if (leftChild(i) < size)
                    System.out.print(" Left : " + heap[leftChild(i)]);
                if (rightChild(i) < size)
                    System.out.print(" Right :" + heap[rightChild(i)]);
                System.out.println();
            return;
            }
        }
        
	private int remove() {
		int val = heap[0];
		heap[0]=heap[--size];
		heapify(0);
		return val;
	}
	private void swap(int i, int j)  
	{ 
		int tmp; 
		tmp = heap[i]; 
		heap[i] = heap[j]; 
		heap[j] = tmp; 
	} 

	private void heapify(int position) {
		if(isLeaf(position)){
			return;
		}

		if(heap[position]>heap[leftChild(position)]) {
			swap(position,leftChild(position));
			heapify(leftChild(position));
		}

		if(heap[position]>heap[rightChild(position)]) {
			swap(position,rightChild(position));
			heapify(rightChild(position));
		}
	}

}