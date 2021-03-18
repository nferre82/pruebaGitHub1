package nelsonferreira;

public class Punto {
	private int x;
	private int y;
	
	Punto(){
		x=-25+(int)(Math.random()*26);
		y=-25+(int)(Math.random()*26);
		while(y==x) {
			y=-25+(int)(Math.random()*26);
		}
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
}
