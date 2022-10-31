package V7.ThreadPools.Streams;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        Item[] items = Item.createSampleItems(1000);
//        List<Item> itemList = Arrays.asList(items);
//        System.out.println(itemList);
//        List<Item> redItems = filterItemsByColorAndCost(itemList, item -> item.getColor() == Item.Color.RED);
//        System.out.println(redItems);
//        List<Item> redCheepItems = filterItemsByColorAndCost(redItems, item -> item.getCost() < 70);
//        System.out.println(redCheepItems);
        Arrays.stream(items).parallel().filter(item -> {
                    System.out.println("Filteringbycolor" + Thread.currentThread());
                    return item.getColor() != Item.Color.RED;
                }).
                filter(item -> {
                    System.out.println("Filteringbyweight" + Thread.currentThread());
                    return item.getCost() < 70;
                }).mapToInt(item -> {
                    System.out.println("Mappingtoint" + Thread.currentThread());
                    return item.getWeight();
                }).average().getAsDouble();
//        Arrays.stream(items)
//                .filter(item -> {
//                    System.out.println("F by color " + Thread.currentThread());
//                    return item.getColor() != Item.Color.RED;
//                })
//                .filter(item -> {
//                    System.out.println("F by weight " + Thread.currentThread());
//                    return item.getCost() < 70;
//                })
//                .mapToInt(item -> {
//                    System.out.println("Mapping to int " + Thread.currentThread());
//                    return item.getWeight();
//                })
//                .average().getAsDouble();
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
