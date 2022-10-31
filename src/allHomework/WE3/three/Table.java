package allHomework.WE3.three;

public class Table {
    private final int[] table;
    private final int size;

    public Table(int size) {
        this.size = size;
        table = new int[size];
    }

    public int getSize() {
        return size;
    }

    public int get(int index) {
        return table[index];
    }

    public void set(int index, int value) {
        table[index] = value;
    }
}
