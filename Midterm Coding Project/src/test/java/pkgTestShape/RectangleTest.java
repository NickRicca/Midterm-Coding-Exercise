package pkgTestShape;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.ThreadLocalRandom;

import org.junit.Test;

import pkgShape.Rectangle;

public class RectangleTest {

	@Test
	public void Rectangle_Test1() throws Exception {
		new Rectangle(2, 4);
	}

	@Test(expected = IllegalArgumentException.class)
	public void Rectangle_Test2() throws Exception {
		new Rectangle(-5, 15);
	}

	@Test(expected = IllegalArgumentException.class)
	public void Rectangle_Test3() throws Exception {
		new Rectangle(5, -4);
	}

	@Test(expected = IllegalArgumentException.class)
	public void Rectangle_Test4() throws Exception {
		new Rectangle(-7, -3);
	}

	@Test
	public void setter_Test1() throws Exception {
		Rectangle rec = new Rectangle(2, 4);

		rec.setiLength(3);
		rec.setiWidth(18);

		assertEquals(rec.getiWidth(), 18);
		assertEquals(rec.getiLength(), 3);

	}

	@Test
	public void area_Test1() throws Exception {
		Rectangle rec = new Rectangle(4, 3);

		assertEquals(rec.area(), 12, 0.0001);
	}

	@Test
	public void perimeter_Test1() throws Exception {
		Rectangle rec = new Rectangle(5, 2);

		assertEquals(rec.perimeter(), 14, 0.0001);
	}

	@Test
	public void compareTo_Test1() throws Exception {
		ArrayList<Rectangle> recs = new ArrayList<Rectangle>();

		for (int i = 0; i < 10; i++) {
			int iWidth = ThreadLocalRandom.current().nextInt(1, 10 + 1);
			int iLength = ThreadLocalRandom.current().nextInt(1, 10 + 1);

			recs.add(new Rectangle(iWidth, iLength));
		}

		Collections.sort(recs);

		for (int i = 0; i < 9; i++) {
			assertTrue(recs.get(i).area() <= recs.get(i + 1).area());
		}
	}
}
