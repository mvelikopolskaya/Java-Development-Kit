import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class Table {
    private List<Philosopher> philosophers;
    private List<Fork> forks;
    private int philosohpersCount;
    private int dinnerCount;

    public Table(int philosohpersCount, int dinnerCount) {
        this.philosophers = new ArrayList<>();
        this.forks = new ArrayList<>();
        this.philosohpersCount = philosohpersCount;
        this.dinnerCount = dinnerCount;
    }

    public int getPhilosohpersCount() {
        return philosohpersCount;
    }

    public int getDinnerCount() {
        return dinnerCount;
    }

    public void addPhilosopher(){
        int philosohpersCount = getPhilosohpersCount();
        for (int i = 0; i < philosohpersCount; i++) {
            CountDownLatch dinnerCount = new CountDownLatch(getDinnerCount());
            Philosopher philosopher = new Philosopher("Philosopher " + (i + 1), dinnerCount);
            philosophers.add(philosopher);
        }
    }

    public void dine(){
        addPhilosopher();
        addForksInList();
        assignForks();
        for (Philosopher philosopher : philosophers){
            Thread thread = new Thread(philosopher);
            thread.start();
        }
        countFulledPhilosophers();
        System.out.println("The dinner is over");
    }

    public void countFulledPhilosophers(){
        int count;
        do {
            count = 0;
            for (Philosopher philosopher : philosophers){
                if(philosopher.isFull()) count++;
            }
        } while (count != getPhilosohpersCount());
    }

    public void addForksInList(){
        for (Philosopher philosopher : philosophers){
            Fork fork = new Fork(philosophers.indexOf(philosopher) + 1);
            forks.add(fork);
        }
    }

    public void assignForks(){
        for (int i = 0; i < philosophers.size(); i++) {
            Philosopher philosopher = philosophers.get(i);
            if(i < philosophers.size() - 1){
                philosopher.setLeftFork(forks.get(i));
                philosopher.setRightFork(forks.get(i + 1));
            } else {
                philosopher.setLeftFork(forks.get(0));
                philosopher.setRightFork(forks.get(i));
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Philosopher philosopher : philosophers){
            sb.append(philosopher);
        }
        return sb.toString();
    }
}
