import edu.rit.numeric.LinearSolve;
import java.util.Random;

public class ParallelJavaTest {
	public static void main(String[] args) {
		int size = Integer.parseInt(args[0]);
		double[][] doubleMatrix = new double[size][size];
		double[][] doubleInverse = new double[size][size];
		
		System.out.println("\nMatrix building");
		double startBuild = System.nanoTime();
		doubleMatrix = build(doubleMatrix);
		double endBuild = System.nanoTime();
		System.out.println("Time taken to build: " + ((endBuild - startBuild) / 1000000000) + "s");
		// doubleMatrix = easyTest(doubleMatrix);
		// prettyPrint(doubleMatrix);
		
		System.out.println("\nSolving inverse");
		double startSolve = System.nanoTime();
		LinearSolve solver = new LinearSolve(doubleMatrix);
		solver.invert(doubleInverse);
		double endSolve = System.nanoTime();
		System.out.println("Time taken to solve: " + ((endSolve - startSolve) / 1000000000) + "s");

		// System.out.println("\nInverse matrix");
		// prettyPrint(doubleInverse);
	}

	public static double[][] easyTest(double[][] doubleMatrix) {
		doubleMatrix[0][0] = 4;
		doubleMatrix[0][1] = 7;
		doubleMatrix[1][0] = 2;
		doubleMatrix[1][1] = 6;
		
		return doubleMatrix;
	}

	public static double[][] build(double[][] doubleMatrix) {
        Random r = new Random();
		for (int i = 0; i < doubleMatrix.length; i++) {
			for (int j = i; j < doubleMatrix.length; j++) {
				doubleMatrix[i][j] = r.nextDouble();
				doubleMatrix[j][i] = doubleMatrix[i][j];
			}
		}
		return doubleMatrix;
	}

	public static void prettyPrint(double[][] input) {
		for (int i = 0; i < input.length; i++) {
			System.out.print(input[i][0]);
			for (int j = 1; j < input.length; j++) {
				System.out.print(", " + input[i][j]);
			}
			System.out.println();
		}
	}
}
