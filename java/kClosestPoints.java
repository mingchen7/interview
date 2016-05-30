import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class kClosestPoints{
	private double xcord;
	private double ycord;
	public kClosestPoints(double x, double y){
		this.xcord = x;
		this.ycord = y;
	} 

	public double getX(){
		return this.xcord;
	}

	public double getY(){
		return this.ycord;
	}

	public String toString(){
		return getX() + ", " + getY();
	}

	public static void main(String args[]){
		Comparator<kClosestPoints> cmp = new Comparator<kClosestPoints>(){
			public int compare(kClosestPoints p1, kClosestPoints p2){
				double x1 = p1.getX();
				double y1 = p1.getY();
				double x2 = p2.getX();
				double y2 = p2.getY();
				if(Math.pow(x1,2) + Math.pow(y1,2) > Math.pow(x2,2) + Math.pow(y2,2))
					return 1;
				else if(Math.pow(x1,2) + Math.pow(y1,2) < Math.pow(x2,2) + Math.pow(y2,2))
					return -1;
				else
					return 0;
			}
		};

		Queue<kClosestPoints> pq = new PriorityQueue<kClosestPoints>(10,cmp);
		pq.add(new kClosestPoints(1.2,2.3));
		pq.add(new kClosestPoints(1.3,2.4));
		pq.add(new kClosestPoints(1.5,2.6));
		pq.add(new kClosestPoints(2.3,2.1));
		pq.add(new kClosestPoints(3.2,4.3));
		pq.add(new kClosestPoints(4.2,5.3));
		pq.add(new kClosestPoints(3.2,8.3));
		pq.add(new kClosestPoints(6.2,4.3));
		int K = 5;
		for(int i = 0; i < K; i++){
			System.out.println(pq.poll().toString());	
		}	
	}	
}