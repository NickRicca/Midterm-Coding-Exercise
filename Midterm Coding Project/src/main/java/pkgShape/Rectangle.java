package pkgShape;

import java.util.Comparator;

public class Rectangle extends Shape implements Comparable {
	private int iWidth;
	private int iLength;

	public Rectangle(int wid, int len) throws Exception {
		super();

		if (wid < 0 || len < 0)
			throw new IllegalArgumentException("Width and/or Length cannot be negative!");
		else {
			iWidth = wid;
			iLength = len;
		}
	}

	public int getiWidth() {
		return iWidth;
	}

	public void setiWidth(int wid) {
		iWidth = wid;
	}

	public int getiLength() {
		return iLength;
	}

	public void setiLength(int len) {
		iLength = len;
	}

	@Override
	public double area() {
		return (double) iWidth * iLength;
	}

	@Override
	public double perimeter() throws Exception {
		return (double) 2 * (this.iLength + this.iWidth);
	}

	public int compareTo(Object x) {
		Rectangle rec = (Rectangle) x;
		return (int) (this.area() - rec.area());
	}

}
