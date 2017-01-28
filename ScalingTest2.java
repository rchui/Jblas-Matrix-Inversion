import org.jblas.*;
import java.util.*;

public class ScalingTest2 {
	public static void main(String[] args) {
		int size = Integer.parseInt(args[0]);
        size = Math.abs(size);
		DoubleMatrix initial = DoubleMatrix.zeros(size, size);
		
		// double startBuild = System.nanoTime();
		// System.out.println("\n----------Starting Matrix Build----------");
		
		// initial = build(initial, size);
		
		// double endBuild = System.nanoTime();	
		// System.out.println("Build took: " + ((endBuild - startBuild) / 1000000000) + "s");
		// System.out.println("\n----------Finishing Matrix Build----------");
		
		// System.out.println("\n----------Starting Matrix----------");
		// prettyPrint(initial);
		
		// double startIdentity = System.nanoTime();
		// System.out.println("\n----------Building Identiy Matrix----------");
		
		// DoubleMatrix id = new DoubleMatrix(new double[size][size]);
		// omp parallel for
		// for (int i = 0; i < size; i++) {
			// for (int j = 0; j < size; j++) {
				// id.put(i, j, 1);
			// }
		// }
		
	    // double endIdentity = System.nanoTime();
		// System.out.println("Build took: " + ((endIdentity - startIdentity) / 1000000000) + "s");	  
		// System.out.println("\n----------Finishing Identiy Matrix Build----------");

		// double startCompute = System.nanoTime();
		// System.out.println("\n----------Starting Computation----------");

		// initial = solver(initial, id);
		
		// double endCompute = System.nanoTime();                                                                                        
		// System.out.println("Compute Time: " + ((endCompute - startCompute) / 1000000000) + "s");
		// System.out.println("\n----------Finishing Computation----------");
		
		// System.out.println("\n----------Inverse Matrix----------");
		// prettyPrint(initial);
		// System.out.println();
	}

	public static DoubleMatrix solver(DoubleMatrix input1, DoubleMatrix input2) {
		return Solve.solve(input1, input2);
	}

	public static DoubleMatrix build(DoubleMatrix input, int size) {
        Random r = new Random();
		// omp parallel for
		for (int i = 0; i < size; i++) { 
			for (int j = i; j < size; j++) { 
				input.put(i, j, r.nextDouble());
				input.put(j, i, input.get(i, j));
			} 
		}
		// input.print();
		return input;
	}

	public static void prettyPrint(DoubleMatrix input, int size) {
		for (int i = 0; i < size; i++) {
			System.out.print("[" + input.get(i, 0));
				for (int j = 1; j < size; j++) {
					System.out.print(", " + input.get(i, j)); 
				}
			System.out.println("]");
		}
	}
}
