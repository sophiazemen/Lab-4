import java.io.Serializable;

public class VectorClock implements Serializable {
    private int[] clock;

    public VectorClock() {
        this.clock = new int[10]; // Adjust size as needed
    }

    public void increment(int processId) {
        clock[processId]++;
    }

    public int[] getClock() {
        return clock;
    }
}
