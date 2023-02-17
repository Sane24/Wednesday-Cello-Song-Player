package gh2;

import deque.ArrayDeque;
import deque.Deque;

public class Cello {
    private static final int SR = 48100;      // Sampling Rate
    private static final double DECAY = 0.998; // energy decay factor

    /* Buffer for storing sound data. */
    private Deque<Double> buffer;
    private int capacity;

    /* Create a guitar string of the given frequency.  */
    public Cello (double frequency) {

        buffer = new ArrayDeque<>();

        capacity = SR / (int) Math.round(frequency);
        for (int i = 0; i < capacity; i++) {
            buffer.addLast(0.0);
        }

    }


    /* Pluck the guitar string by replacing the buffer with white noise. */
    public void pluck() {

        for (int i = 0; i < capacity; i++) {
            buffer.removeFirst();
            buffer.addLast(Math.random() - 0.5);
        }


    }

    /* Advance the simulation one time step by performing one iteration of
     * the Karplus-Strong algorithm.
     */
    public void tic() {
        double a = buffer.removeFirst();
        double mean = (a + buffer.get(0)) / 2;
        double newDouble = mean * DECAY;
        buffer.addLast(newDouble);
    }

    /* Return the double at the front of the buffer. */
    public double sample() {

        return buffer.get(0);
    }
}
