//-----------------------------------------------------
// Title: Queue Array Implementation class
// Author: Arda Baran
// Description: This class implements queue data structure with array data structure
//-----------------------------------------------------
public class QueueArrayImplementation {
int front,rear,capacity;
int [] bag;
public QueueArrayImplementation(int capacity) {
//constructor.front and rear indices are initialized 0 and queue bag is created by capacity.	
	this.capacity=capacity;
	this.front=0;
    this.rear=0;
    this.bag=new int[capacity];
 }
public boolean isEmpty() {
	return (front==rear);
}
public boolean isFull() {
	return (rear==capacity);	
}
public void addIslandToQueue(int island) {
//adds island to rear	
	if(isFull()) {
		return;
		
	}else {
		bag[rear]=island;
	rear++;
	}
		return;
}
public void deleteIslandFromQueue() {
//deletes island from rear
	if(isEmpty()) {
		return;
	}else {
		for(int i=0;i<rear;i++) {
			bag[i]=bag[i+1];
		}
		if(rear<capacity)
		bag[rear]=0;
		rear--;
	}
return;
}
public int getFrontElementOfQueue() {
//returns front island

	if(isEmpty()) {
		return Integer.MIN_VALUE;
	}
return bag[front];
}
}
