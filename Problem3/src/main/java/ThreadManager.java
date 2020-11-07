public class ThreadManager {

    private boolean threadFlag = true;

    public void setThreadFlag(boolean threadFlag) {
        this.threadFlag = threadFlag;
    }

    public void printThreadGroupHierarchy(ThreadGroup threadGroup) {
        if (threadGroup == null)
            return;

        Runnable printThreadInfo;
        printThreadInfo = () -> {
            synchronized (this) {
                while (threadFlag) {
                    int sizeThreadArray = threadGroup.activeCount();
                    ThreadGroup[] allThreadGroups = new ThreadGroup[sizeThreadArray];
                    threadGroup.enumerate(allThreadGroups, false);

                    for (int i = 0; i < sizeThreadArray; i++) {
                        if (allThreadGroups[i] != null)
                            allThreadGroups[i].list();
                    }

                    try {
                        wait(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println("\n");
                }
            }
        };

        Thread printingThread = new Thread(printThreadInfo);
        printingThread.start();

    }
}
