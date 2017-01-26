// import org.jblas.*;
import java.util.*;

public class test {
  public static void main(String[] args) {
    double[][] initial = new double[2][2];
    System.out.println(Arrays.deepToString(initial));
    
    for (int i = 0; i < initial.length; i++) {
      initial[i][i] = 1;
    }
    System.out.println(Arrays.deepToString(initial));  
    

  }
}
