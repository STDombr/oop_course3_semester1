import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.atomic.AtomicMarkableReference;

public class MySkipListTest {

    MySkipList skipList;

    @Before
    public void setUp(){
        skipList = new MySkipList(16);
    }

    private boolean checkListOrder(){
        AtomicMarkableReference<MySkipList.Node> prev = skipList.getHeader();
        prev = prev.getReference().getNext()[0];
        AtomicMarkableReference<MySkipList.Node> curr = prev;
        curr = curr.getReference().getNext()[0];

        for(int i = 0; i < skipList.size() - 1; i++){
            if(prev.getReference().getValue() >= curr.getReference().getValue()){
                return false;
            }
            prev = curr;
            curr = curr.getReference().getNext()[0];
        }
        return true;
    }

    @Test
    public void concurrentDuplicateAdd_TEST() throws InterruptedException {
        Runnable thread2;
        thread2 = () -> {
            for(int i = 0; i < 100; i++){
                skipList.add(200 + i);
            }
        };

        Thread testThread = new Thread(thread2);
        testThread.start();

        for(int i = 0; i < 100; i++){
            skipList.add(200 + i);
        }

        testThread.join();

        for(int i = 0; i < 100; i++){
            Assert.assertTrue(skipList.contains(200 + i));
        }

        System.out.println(skipList.getSize());

        Assert.assertTrue(checkListOrder());
    }

    @Test
    public void add_TEST(){
        for(int i = 0; i < 100; i++){
            Assert.assertTrue(skipList.add(200 + i));
        }

        for(int i = 0; i < 100; i++){
            Assert.assertFalse(skipList.add(200 + i));
        }

        Assert.assertTrue(checkListOrder());
    }

    @Test
    public void delete_TEST(){
        for(int i = 0; i < 100; i++){
            skipList.add(200 + i);
        }

        for(int i = 0; i < 100; i++){
            Assert.assertTrue(skipList.remove(200 + i));
        }

        for(int i = 0; i < 100; i++){
            Assert.assertFalse(skipList.remove(200 + i));
        }

        Assert.assertTrue(checkListOrder());
    }

    @Test
    public void concurrentAdd_TEST() throws InterruptedException {
        Runnable thread2;
        thread2 = () -> {
            for(int i = 0; i < 50; i++){
                skipList.add(200 + i * 2);
            }
        };

        Thread testThread = new Thread(thread2);
        testThread.start();

        for(int i = 0; i < 50; i++){
            skipList.add(200 + i * 2 + 1);
        }

        testThread.join();

        for(int i = 0; i < 100; i++){
            Assert.assertTrue(skipList.contains(200 + i));
        }

        Assert.assertTrue(checkListOrder());
    }

    @Test
    public void concurrentDeletion_TEST() throws InterruptedException {

        for(int i = 0; i < 100; i++){
            skipList.add(200 + i);
        }

        Runnable thread2;
        thread2 = () -> {
            for(int i = 0; i < 50; i++){
                skipList.remove(200 + i * 2);
            }
        };

        Thread testThread = new Thread(thread2);
        testThread.start();

        for(int i = 0; i < 50; i++){
            skipList.remove(200 + i * 2 + 1);
        }

        testThread.join();

        for(int i = 0; i < 100; i++){
            Assert.assertFalse(skipList.contains(200 + i));
        }

        Assert.assertTrue(checkListOrder());
    }
}
