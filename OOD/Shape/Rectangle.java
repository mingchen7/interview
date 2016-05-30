public class Rectangle extends Shape {
	private double length;
	private double width;

	public Rectangle(){
		this(0.0, 0.0);
	}

	public Rectangle(double l, double w){
		length = l;
		width = w;
		area = length * width;
		circumference = 2 * (length + width);
	}


}