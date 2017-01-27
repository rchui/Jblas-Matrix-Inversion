import jeigen.DenseMatrix;

public class EigenTest {
	public static void main(String[] args) {
		int size = Integer.parseInt(args[0]);
		DenseMatrix dm1, dm2;
		dm1 = DenseMatrix.rand(size, size);
		dm2 = DenseMatrix.rand(size, size);
		for (int i = 0; i < size; i++) {
			for (int j = i; j < size; j++) {
				dm1.set(j, i, dm1.get(i, j));
			}
		}

		System.out.println(dm1.toString());

		dm2 = dm1.inv();

		System.out.println(dm2.toString());
	}
}
