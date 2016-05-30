package ColorPoints;

public class Color {
	private int r;
	private int g;
	private int b;

	public Color(){
		this(0, 0, 0);
	}

	public Color(int red, int green, int blue){
		r = red;
		g = green;
		b = blue;
	}

	public int getR(){
		return r;
	}

	public int getG(){
		return g;
	}

	public int getB(){
		return b;
	}

	public void printColor(){
		System.out.print("R: " + r + "G: " + g + "B: " + b + "\n");
	}

}