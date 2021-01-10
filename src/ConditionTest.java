import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionTest {

    public static void main(String[] args) {
        ConditionDemo demo = new ConditionDemo();
        Runnable runnableA = () -> {
            for (int i = 0; i < 5; i++) {
                demo.loopA();
            }
        };
        Runnable runnableB = () -> {
            for (int i = 0; i < 5; i++) {
                demo.loopB();
            }
        };
        Runnable runnableC = () -> {
            for (int i = 0; i < 5; i++) {
                demo.loopC();
            }
        };

        new Thread(runnableA).start();
        new Thread(runnableB).start();
        new Thread(runnableC).start();

    }

    public static class ConditionDemo {
        final Lock lock = new ReentrantLock();
        Condition conditionA = lock.newCondition();
        Condition conditionB = lock.newCondition();
        Condition conditionC = lock.newCondition();
        int num = 1;

        private void loopA(){
            lock.lock();
            try {
                while (num != 1) {
                    conditionA.await();
                }
                System.out.println("A");
                num = 2;
                conditionB.signalAll();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }

        private void loopB(){
            lock.lock();
            try {
                while (num != 2) {
                    conditionB.await();
                }
                num = 3;
                System.out.println("B");
                conditionC.signalAll();
            } catch (InterruptedException e) {
                e.printStackTrace();
                lock.unlock();
            } finally {
                lock.unlock();
            }
        }

        private void loopC(){
            lock.lock();
            try {
                while (num != 3) {
                    conditionC.await();
                }
                System.out.println("C");
                num = 1;
                conditionA.signalAll();
            } catch (InterruptedException e) {
                e.printStackTrace();
                lock.unlock();
            } finally {
                lock.unlock();
            }
        }
    }

}
