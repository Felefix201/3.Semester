package hw5.Stream;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Main2 {
    public static void main(String[] args) {
        Item[] items = Item.createSampleItems(1000);
        System.out.println(Arrays.stream(items)
                .filter(item -> item.getColor() == Item.Color.RED)
                .filter(item -> item.getCost() < 70)
                .mapToInt(item -> item.getWeight())
                .average().getAsDouble());

        //Average cost
        Arrays.stream(items)
                .mapToInt(item -> item.getCost())
                .average().getAsDouble();

        Arrays.stream(items).filter(item -> {
                    System.out.println("Filtering by color " + Thread.currentThread());
                    return item.getColor() != Item.Color.RED;
                }).filter(item -> {
                    System.out.println("Filtering by weight " + Thread.currentThread());
                    return item.getCost() < 70;
                }).mapToInt(item -> {
                    System.out.println("Mapping to int " + Thread.currentThread());
                    return item.getWeight();
                });
        Arrays.stream(items).parallel().filter(item -> {
            System.out.println("Filtering by color " + Thread.currentThread());
            return item.getColor() != Item.Color.RED;
        }).filter(item -> {
            System.out.println("Filtering by weight " + Thread.currentThread());
            return item.getCost() < 70;
        }).mapToInt(item -> {
            System.out.println("Mapping to int " + Thread.currentThread());
            return item.getWeight();
        });
    }

    public static List<Item> filterItemsByColorAndCost(List<Item> items, Predicate<Item> filterPredicate) {
        ArrayList<Item> outputList = new ArrayList<>();
        for (Item item : items) {
            if (filterPredicate.test(item)) {
                outputList.add(item);
            }
        }
        return outputList;
    }
}
