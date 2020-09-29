import java.util.List;

public class TriDiagonalMatrix {
    private List<Double> a,b,c;
    private int size;

    public TriDiagonalMatrix(List<Double> a, List<Double> b, List<Double> c) throws Exception {
        if (a.size() != c.size() || a.size() != (b.size() - 1) ||
            a.size() == 0 || b.size() == 0 || c.size() == 0)
            throw new Exception("Wrong size of vectors!");

        this.a = a;
        this.b = b;
        this.c = c;
        this.c.add(0d);
        this.a.add(0,0d);

        size = b.size();
    }

    public Double getByIndex(int row, int column)
    {
        if (row >= 0 && row < size && column >= 0 && column < size)
        {
            if (row == column)
                return b.get(row);
            if (row == (column + 1))
                return a.get(row);
            if (row == (column - 1))
                return c.get(row);

            return 0d;
        }
        throw new Error("Wrong index!");
    }

    public List<Double> getA() {
        return a;
    }

    public List<Double> getB() {
        return b;
    }

    public List<Double> getC() {
        return c;
    }

    public int getSize() {
        return size;
    }

    public void print(){
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++)
                if (i == j)
                    System.out.print(b.get(j) + " ");
                else if (i == (j + 1))
                    System.out.print(a.get(j) + " ");
                else if (i == (j - 1))
                    System.out.print(c.get(i) + " ");
                else
                    System.out.print("0 ");
            System.out.print('\n');
        }

    }
}
