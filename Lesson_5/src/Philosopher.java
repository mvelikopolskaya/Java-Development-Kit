import java.util.Random;
import java.util.concurrent.CountDownLatch;


public class Philosopher implements Runnable{
    private String name;
    CountDownLatch cdl;
    private Fork rightFork;
    private Fork leftFork;
    private boolean isFull = false;
    private boolean isThinking = false;

    public Philosopher(String name, CountDownLatch cdl) {
        this.name = name;
        this.cdl = cdl;
    }

    public boolean isFull() {
        return isFull;
    }

    @Override
    public void run() {
       while (cdl.getCount() > 0) {
           try {
               eating();
               thinking();
           }
           catch(InterruptedException e){
               e.getMessage();
           }
       }
       isFull = true;
       System.out.println(name + " finished dinner");
    }

    public void setRightFork(Fork rightFork) {
        this.rightFork = rightFork;
    }

    public void setLeftFork(Fork leftFork) {
        this.leftFork = leftFork;
    }

    public void thinking() throws InterruptedException {
        if(!isThinking && cdl.getCount() < 3) {
            System.out.println(name + " is thinking");
            Thread.sleep(new Random().nextInt(100, 1000));
            isThinking = true;
        }
    }

    public void eating() throws InterruptedException {
        if(!rightFork.isTaken() && !leftFork.isTaken()) {
            rightFork.take();
            leftFork.take();
            System.out.printf("%s is eating with forks %s and %s\n", name, leftFork.getNum(), rightFork.getNum());
            Thread.sleep(new Random().nextInt(200, 2000));
            cdl.countDown();
            rightFork.free();
            leftFork.free();
            System.out.printf("%s put forks %s and %s on the table\n", name, leftFork.getNum(), rightFork.getNum());
        }
    }
}
