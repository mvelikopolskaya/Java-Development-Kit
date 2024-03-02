public class Fork {
    private int num;
    private boolean isTaken = false;

    public Fork(int num) {
        this.num = num;
    }

    public int getNum() {
        return num;
    }

    public boolean isTaken() {
        return isTaken;
    }

    public void take(){
        isTaken = true;
    }

    public void free() {
        isTaken = false;
    }
}
