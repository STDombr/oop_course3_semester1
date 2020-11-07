import java.util.Random;
import java.util.concurrent.BrokenBarrierException;

public class Lobby {
    private static Runnable startingGame = new Runnable() {
        @Override
        public void run() {
            synchronized (this) {
                try {
                    this.wait(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
                System.out.println("Game started!");
        }
    };

    private static final CyclicBarrierCustom barrier = new CyclicBarrierCustom(5, startingGame);

    public static void addPlayer(int playerId){
        new Thread() {
            @Override
            public void run(){
                try {
                    synchronized (this) {
                        Random random = new Random();
                        this.wait(random.nextInt(4000) + 1000);
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
