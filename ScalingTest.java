import org.jblas.*;
import java.util.*;

public class ScalingTest {
	public static void main(String[] args) {
		int size = Integer.parseInt(args[0]);
        DoubleMatrix initial = new DoubleMatrix(new double[size][size]);
	
		initial = build(initial);

		// System.out.println("Starting Matrix");
		// prettyPrint(initial);
		
		double start = System.nanoTime();
		
		Decompose.LUDecomposition<DoubleMatrix> de = decompose(initial);
		DoubleMatrix id = new DoubleMatrix(new double[size][size]);
		// omp parallel for threadNum(20)
		for (int i = 0; i < id.rows; i++) {
			for (int j = 0; j < id.columns; j++) {
				id.put(i, j, 1);
			}
		}
		
		// omp parallel for threadNum(20)
		for (int i = 0; i < size; i++) {
			DoubleMatrix forwardSub = solver(de.l, id.getColumn(i));
			DoubleMatrix column = solver(de.u, forwardSub);
			initial.putColumn(i, column);
		}

		// solver(initial, initial2);
		// matrixMultiply(initial, initial2);
		// initial = computeInverse(initial);

		double end = System.nanoTime();
		System.out.println("Compute Time: " + ((end - start) / 1000000000) + "s");
		// System.out.println("Inverse Matrix");
		// prettyPrint(initial);
	}

	public static Decompose.LUDecomposition<DoubleMatrix> decompose(DoubleMatrix input) {
		return Decompose.lu(input);
	}

	public static DoubleMatrix solver(DoubleMatrix input1, DoubleMatrix input2) {
		return Solve.solve(input1, input2);
	}

	public static DoubleMatrix build(DoubleMatrix input) {
        Random r = new Random();
		System.out.println(input.rows);
		// omp parallel for threadNum(20)
		for (int i = 0; i < input.rows; i++) { 
			for (int j = i; j < input.rows; j++) { 
				input.put(i, j, r.nextDouble());
				input.put(j, i, input.get(i, j));
			} 
		}
		// input.print();
		return input;
	}

	public static void prettyPrint(DoubleMatrix input) {
		for (int i = 0; i < input.rows; i++) {
			System.out.print("[" + input.get(i, 0));
				for (int j = 1; j < input.columns; j++) {
					System.out.print(", " + input.get(i, j)); 
				}
			System.out.println("]");
		}
	}
}
