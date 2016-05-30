package ColorPoints;

public class ColorPoint extends Point{
	private Color color;

	public ColorPoint(double x, double y, double size, Color pcolor){
		super(x, y, size);
		color = pcolor;
	}

	public void printColorPoint(){
		super.printPoint();
		color.printColor();
	}

	public static void main(String args[]){
		Color color = new Color(255,255,255);
		ColorPoint cp = new ColorPoint(1.1, 2.2, 1.0, color);
		cp.printColorPoint();
	}
}