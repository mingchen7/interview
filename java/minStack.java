import java.util.*;

public class MinStack {
	private Stack<Integer> mainStack;
	private Stack<Integer> minStack;

	public MinStack(){
		mainStack = new Stack<Integer>();
		minStack = new Stack<Integer>();
	}

	public void push(int number){
		mainStack.push(number);
		if(!minStack.empty()){
			int top = minStack.peek();
			if(number < top){
				minStack.push(number);
			}
			else{
				minStack.push(top);
			}
		}
		else{
			minStack.push(number);
		}
	}

	public int pop(){
		minStack.pop();
		int tmp = mainStack.pop();
		return tmp;
	}

	public int getMin(){
		return minStack.peek();
	}

	public Stack<Integer> getMainStack(){
		return mainStack;
	}

	public Stack<Integer> getMinStack(){
		return minStack;
	}

	public static void main(String args[]){
		int[] numbers = {4,3,9,5,2,7,6,1,8,10};
		MinStack stack = new MinStack();
		for(int num:numbers){
			stack.push(num);
			System.out.print("New: " + num + "\n");
			System.out.print("Min: " + stack.getMin() + "\n");
		}	
		System.out.print("\n");
		
		int i = 9;		
		while(i > 0){			
			System.out.print("Out: " + stack.pop() + "\n");
			System.out.print("Min: " + stack.getMin() + "\n");			
			i--;
		}
	}

}