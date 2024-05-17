//-----------------------------------------------------
//Title: Stack Array Implementation class
//Author: Arda Baran
//Description: this class implements stack data structure by using Array data structure 
//-----------------------------------------------------
public class StackArrayImplementation {
	int capacity,top;
	int bag[];
	public StackArrayImplementation(int capacity) {
		this.capacity=capacity;
	    this.bag=new int [this.capacity];
	    this.top=-1;
	}
	public boolean isEmpty() {
		return (top==-1);
	}
	public boolean isFull() {
		return (top==this.capacity-1);
	}
	public void addCityToStack(int city) {
		if(isFull()) {
			
		return ;
		}
		top++;
		bag[top]=city;	

	}
	public void deleteCityFromStack() {
		if(isEmpty()) {
		
		return ;
		}

		top--;

	}
	public int getTop() {
		if(!isEmpty()) {
			return bag[top];
		}
		return -1;
	}
}

