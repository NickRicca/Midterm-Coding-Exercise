package pkgTestShape;

import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.ThreadLocalRandom;
import org.junit.Test;
import pkgShape.Cuboid;

public class CuboidTest {
	
	@Test
	public void Cuboid_Test1() throws Exception {
		new Cuboid(5, 6, 7);
	}

	@Test(expected = IllegalArgumentException.class)
	public void Cuboid_Test2() throws Exception {
		new Cuboid(-5, 6, 7);
	}

	@Test(expected = IllegalArgumentException.class)
	public void Cuboid_Test3() throws Exception {
		new Cuboid(5, -6, 7);
	}

	@Test(expected = IllegalArgumentException.class)
	public void Cuboid_Test4() throws Exception {
		new Cuboid(5, 6, -7);
	}

	@Test(expected = IllegalArgumentException.class)
	public void Cuboid_Test5() throws Exception {
		new Cuboid(-5, -6, -7);
	}

	@Test
	public void getter_Test1() throws Exception {
		Cuboid cub = new Cuboid(8, 4, 3);

		assertEquals(cub.getiWidth(), 8);
		assertEquals(cub.getiLength(), 4);
		assertEquals(cub.getiDepth(), 3);

	}

	@Test
	public void setter_Test1() throws Exception {
		Cuboid cub = new Cuboid(42, 5, 2);

		cub.setiLength(42);
		cub.setiWidth(5);
		cub.setiDepth(2);

		assertEquals(cub.getiLength(), 42);
		assertEquals(cub.getiWidth(), 5);
		assertEquals(cub.getiDepth(), 2);
	}

	@Test
	public void area_Test1() throws Exception {
		Cuboid cub = new Cuboid(10, 3, 14);

		assertEquals(cub.area(), 424, 0.0001);
	}

	@Test
	public void volume_Test1() throws Exception {
		Cuboid cub = new Cuboid(10, 3, 14);

		assertEquals(cub.volume(), 420, 0.0001);
	}

	@Test(expected = UnsupportedOperationException.class)
	public void perimeter_Test1() throws Exception {
		Cuboid cub = new Cuboid(420, 420, 420);

		cub.perimeter();
	}

	@Test
	public void compareTo_Test1() throws Exception {
		ArrayList<Cuboid> cubs = new ArrayList<Cuboid>();

		for (int i = 0; i < 10; i++) {
			int iLength = ThreadLocalRandom.current().nextInt(1, 10 + 1);
			int iWidth = ThreadLocalRandom.current().nextInt(1, 10 + 1);
			int iDepth = ThreadLocalRandom.current().nextInt(1, 10 + 1);

			cubs.add(new Cuboid(iWidth, iLength, iDepth));
		}

		Collections.sort(cubs);

		for (int i = 0; i < 9; i++) {
			assertTrue(cubs.get(i).area() <= cubs.get(i + 1).area());
		}

	}

	@Test
	public void SortByArea_Test1() throws Exception {
		ArrayList<Cuboid> cubs = new ArrayList<Cuboid>();

		for (int i = 0; i < 10; i++) {
			int iWidth = ThreadLocalRandom.current().nextInt(1, 10 + 1);
			int iLength = ThreadLocalRandom.current().nextInt(1, 10 + 1);
			int iDepth = ThreadLocalRandom.current().nextInt(1, 10 + 1);

			cubs.add(new Cuboid(iWidth, iLength, iDepth));
		}

		Collections.sort(cubs, SortByArea());

		for (int i = 0; i < 9; i++) {
			assertTrue(cubs.get(i).area() <= cubs.get(i + 1).area());
		}
	}
	
	@Test
	public void SortByVolume_Test1() throws Exception {
		ArrayList<Cuboid> cubs = new ArrayList<Cuboid>();

		for (int i = 0; i < 10; i++) {
			int iLength = ThreadLocalRandom.current().nextInt(1, 10 + 1);
			int iWidth = ThreadLocalRandom.current().nextInt(1, 10 + 1);
			int iDepth = ThreadLocalRandom.current().nextInt(1, 10 + 1);

			cubs.add(new Cuboid(iWidth, iLength, iDepth));
		}

		Collections.sort(cubs, SortByVolume());

		for (int i = 0; i < 9; i++) {
			assertTrue(cubs.get(i).volume() <= cubs.get(i).volume());
		}
	}
}
