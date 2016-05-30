public abstract class Shape {
	private double area;
	private double circumference;
	private boolean filled = false;

	public getArea(){
		return area;
	}

	public getCurcumeference(){
		return circumference;
	}

	public fill(){
		filled = true;
	}
}
