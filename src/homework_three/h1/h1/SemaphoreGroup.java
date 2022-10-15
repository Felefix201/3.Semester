package homework_three.h1.h1;

public class SemaphoreGroup {
    private int[] values;

    public SemaphoreGroup(int numberOfMembers) {
        if (numberOfMembers < 1) {
            throw new IllegalArgumentException("Value must be == 1");
        }
        values = new int[numberOfMembers];
    }

    public synchronized void changeValues(int[] x) throws InterruptedException {
        if (x.length != values.length) {
            throw new IllegalArgumentException("Array length must be " + values.length);
        } else {
            while (!canChange(x)) {
                wait();
            }
            doChange(x);
            notifyAll();
        }
    }


    private boolean canChange(int[] x) {
        for (int i = 0; i < values.length; i++) {
            if (values[i] + x[i] < 0) {
                return false;
            }
        }
        return true;
    }

    private void doChange(int[] x) {
        for (int i = 0; i < values.length; i++) {
            values[i] = values[i] + x[i];
        }
    }
}