package pkgShape;

import java.util.Comparator;

public class Cuboid extends Rectangle {

	private int iDepth;

	public Cuboid(int wid, int len, int dep) throws Exception {
		super(wid, len);

		if (dep < 0)
			throw new IllegalArgumentException("Depth cannot be negative!");
		else
			iDepth = dep;
	}

	public int getiDepth() {
		return iDepth;
	}

	public void setiDepth(int dep) {
		iDepth = dep;
	}

	public double volume() {
		return (double) getiLength() * getiWidth() * getiLength();
	}

	@Override
	public double area() {
		return (this.getiLength() * this.getiWidth() + this.getiLength() * getiDepth() + this.iDepth * this.getiWidth())
				* 2;
	}

	@Override
	public double perimeter() throws Exception {
		throw new UnsupportedOperationException("There is no perimeter for a cuboid, silly!");
	}

	@Override
	public int compareTo(Object x) {
		Cuboid cub = (Cuboid) x;
		return (int) (this.area() - cub.area());
	}
}

class SortByArea implements Comparator<Cuboid> {
	SortByArea() {
		super();
	}

	public int compare(Cuboid cub1, Cuboid cub2) {
		return (int) (cub1.area() - cub2.area());
	}

}

class SortByVolume implements Comparator<Cuboid> {
	SortByVolume() {
		super();
	}

	public int compare(Cuboid cub1, Cuboid cub2) {
		return (int) (cub1.volume() - cub2.volume());
	}

}