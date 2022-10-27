package V7.ThreadPools.Streams;

import java.util.Random;

public class Item {
    public enum Color {
        RED, GREEN, BLUE, YELLOW, BLACK, WHITE
    }
    private Color color;
    private int weight;
    private int cost;
    private static final Random random = new Random();
    private static Color[] colorValues = Color.values();

    public Item(Color color, int weight, int cost) {
        this.color = color;
        this.weight = weight;
        this.cost = cost;
    }
    public int getWeight() {
        return weight;
    }
    public void setWeight(int weight) {
        this.weight = weight;
    }
    public int getCost() {
        return cost;
    }
    public void setCost(int cost) {
        this.cost = cost;
    }

    public Color getColor() {
        return color;
    }
    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Item color: " + color +
                " weight: " + weight +
                " cost: " + cost;
    }

    public static Item[] createSampleItems(int numberOfItems){
        Item[] items = new Item[numberOfItems];
        for (int i = 0; i < numberOfItems; i++){
            items[i] = new Item(colorValues[random.nextInt(colorValues.length)],
                    random.nextInt(1000),
                    random.nextInt(100));
        }
        return items;
    }
}
