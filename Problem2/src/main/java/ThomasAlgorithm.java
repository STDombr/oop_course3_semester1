import java.util.ArrayList;
import java.util.List;

public class ThomasAlgorithm {
    private EquationSystem system;
    private List<Double> alpha, beta;

    int index;

    public ThomasAlgorithm(EquationSystem system) {
        this.system = system;

        alpha = new ArrayList<>(system.getMatrix().getSize() - 1);
        beta = new ArrayList<>(system.getMatrix().getSize());
    }

    public void calculate(){
        alpha.add(0, system.getMatrix().getC().get(0) / system.getMatrix().getB().get(0));
        beta.add(0, system.getD().get(0) / system.getMatrix().getB().get(0));

        for (int i = 1; i < system.getMatrix().getSize(); i++)
        {
            alpha.add(system.getMatrix().getC().get(i) /
                    (system.getMatrix().getB().get(i) - system.getMatrix().getA().get(i) * alpha.get(i - 1)));
            beta.add((system.getD().get(i) - system.getMatrix().getA().get(i) * beta.get(i - 1)) /
                    (system.getMatrix().getB().get(i) - system.getMatrix().getA().get(i) * alpha.get(i - 1)));
        }

        calcX();
    }

    public synchronized void calculateMultiThread() throws InterruptedException {
        alpha.add(0, system.getMatrix().getC().get(0) / system.getMatrix().getB().get(0));
        beta.add(0, system.getD().get(0) / system.getMatrix().getB().get(0));
        Runnable calcAlpha = () ->{
           synchronized (this){
               for (int i = 1; i < system.getMatrix().getSize(); i++)
               {
                   alpha.add(system.getMatrix().getC().get(i) /
                           (system.getMatrix().getB().get(i) - system.getMatrix().getA().get(i) * alpha.get(i - 1)));
                   index = i;
                   notify();
               }
           }
        };

        new Thread(calcAlpha).start();

        for (int i = 1; i < system.getMatrix().getSize(); i++)
        {
            while (i - 1 >= index)
                wait();

            beta.add((system.getD().get(i) - system.getMatrix().getA().get(i) * beta.get(i - 1)) /
                    (system.getMatrix().getB().get(i) - system.getMatrix().getA().get(i) * alpha.get(i - 1)));
        }

        calcX();
    }

    private void calcX(){
        List<Double> x = new ArrayList<Double>(system.getMatrix().getSize());
        for (int i = 0; i < system.getMatrix().getSize(); i++)
            x.add(0d);

        x.set(system.getMatrix().getSize() - 1, beta.get(system.getMatrix().getSize() - 1));
        for (int i = system.getMatrix().getSize() - 2; i >= 0; i--)
            x.set(i, beta.get(i) - alpha.get(i) * x.get(i + 1));

        system.setX(x);
    }
}
