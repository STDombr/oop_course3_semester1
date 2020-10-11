import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        List<Double> a = new ArrayList<>(Arrays.asList(1d, 1d, 1d));
        List<Double> b = new ArrayList<>(Arrays.asList(3d, 3d, 3d, 3d));
        List<Double> c = new ArrayList<>(Arrays.asList(1d, 1d, 1d));

        TriDiagonalMatrix matrix = new TriDiagonalMatrix(a,b,c);
        //matrix.print();

        List<Double> d = new ArrayList<>(Arrays.asList(1d, 1d, 1d, 1d));

        EquationSystem system = new EquationSystem(matrix, d);
        system.print();

        ThomasAlgorithm thomasAlgorithm = new ThomasAlgorithm(system);
        //thomasAlgorithm.calculate();
        thomasAlgorithm.calculateMultiThread();

        system.printX();
    }
}
