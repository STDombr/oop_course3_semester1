import java.util.Random;
import java.util.concurrent.BrokenBarrierException;

public class Lobby {
    private static Runnable startingGame = new Runnable() {
        @Override
        public void run() {
            System.out.println("Game started!");
        }
    };

    private static final CyclicBarrierCustom barrier = new CyclicBarrierCustom(5, startingGame);

    public static void addPlayer(int playerId) {
        new Thread() {
            @Override
            public void run() {
                try {
                    Random random = new Random();
                    synchronized (this) {
                        this.wait(random.nextInt(4000) + 1000);
                    }
                    System.out.println("Player " + playerId + " entered the lobby");
                    barrier.await();

                    synchronized (this) {
                        this.wait(random.nextInt(4000) + 3000);
                    }

                    System.out.println("Player " + playerId + " entered the lobby");
                    barrier.await();

                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }
}
