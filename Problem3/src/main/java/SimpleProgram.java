public class SimpleProgram {

    private Runnable positiveOne;
    private Runnable positiveTwo;
    private Runnable positiveThree;
    private Runnable negativeOne;
    private Runnable negativeTwo;

    private final ThreadGroup mainThreadGroup;

    private boolean threadFlag;

    SimpleProgram() {
        positiveOne = positiveTwo = positiveThree = negativeOne = negativeTwo = null;
        mainThreadGroup = new ThreadGroup("Main thread group");
        threadFlag = true;
    }

    public ThreadGroup getMainThreadGroup() {
        return mainThreadGroup;
    }

    public void setThreadFlag(boolean threadFlag) {
        this.threadFlag = threadFlag;
    }

    private void prepareThreads() {

        this.positiveOne = () -> {
            synchronized (this) {
                try {
                    wait(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        this.positiveTwo = () -> {
            synchronized (this) {
                try {
                    wait(1500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        this.positiveThree = () -> {
            synchronized (this) {
                try {
                    wait(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        this.negativeOne = () -> {
            synchronized (this) {
                try {
                    wait(2500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        this.negativeTwo = () -> {
            synchronized (this) {
                try {
                    wait(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
    }

    public void simulateWork() throws InterruptedException {
        synchronized (this) {
            ThreadGroup threadGroupPos = new ThreadGroup(mainThreadGroup, "Positive numbers");
            ThreadGroup threadGroupNeg = new ThreadGroup(mainThreadGroup, "Negative numbers");

            prepareThreads();

            while (threadFlag) {
                new Thread(threadGroupPos, this.positiveOne, "positiveOne thread").start();
                new Thread(threadGroupPos, this.positiveTwo, "positiveTwo thread").start();
                new Thread(threadGroupPos, this.positiveThree, "positiveThree thread").start();
                new Thread(threadGroupNeg, this.negativeOne, "negativeOne thread").start();
                new Thread(threadGroupNeg, this.negativeTwo, "negativeTwo thread").start();

                wait(2000);
            }
        }
    }
}
