import java.util.ArrayList;
import java.util.List;

public class EquationSystem {
    private TriDiagonalMatrix Matrix;
    private List<Double> x,d;

    public EquationSystem(TriDiagonalMatrix matrix, List<Double> d) throws Exception {
        if (d.size() != matrix.getSize())
            throw new Exception("Wrong input!");

        Matrix = matrix;
        this.d = d;
        this.x = new ArrayList<>(matrix.getSize());
    }

    public TriDiagonalMatrix getMatrix() {
        return Matrix;
    }

    public List<Double> getX() {
        return x;
    }

    public void setX(List<Double> x) {
        this.x = x;
    }

    public List<Double> getD() {
        return d;
    }

    public void print(){
        int size = this.Matrix.getSize();
        Double temp;

        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++)
            {
                temp = this.Matrix.getByIndex(i,j);

                if (!temp.equals(0d))
                {
                    if (temp > 0 && j != 0 && j >= i)
                        System.out.print("+");

                    if (temp == 1)
                        System.out.print("x_" + (j + 1));
                    else
                        System.out.print(temp + "x_" + (j + 1));
                }
            }
            System.out.print("=" + this.d.get(i) + '\n');
        }

    }

    public void printX(){
        for (int i = 0; i < x.size(); i++)
        {
            System.out.print("x_" + (i + 1) + "=");
            System.out.printf("%.2f", x.get(i));
            System.out.print('\n');
        }
    }
}
