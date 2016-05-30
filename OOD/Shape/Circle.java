public class Circle extends Shape{
	private double radius;
	private double Pi = 3.141596;

	public Circle(double r){
		radius = r;
		area = Pi * Math.pow(r, 2);
		circumference = 2 * Pi * r;
	}

	public Circle(){
		this(0.0);
	}

}