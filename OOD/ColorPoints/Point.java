package ColorPoints;

public class Point {
	// x and y coordinates for the point
	private double xcord;
	private double ycord;
	private double size;

	// construction function
	public Point(){
		this(0.0, 0.0, 1);		
	}

	public Point(double x, double y, double psize){
		xcord = x;
		ycord = y;
		size = psize;
	}

	public double getX(){
		return xcord;
	}

	public double getY(){
		return ycord;
	}

	public double getSize(){
		return size;
	}

	public void printPoint(){
		System.out.print("(" + xcord + "," + ycord + ")" + "\n");
	}

}