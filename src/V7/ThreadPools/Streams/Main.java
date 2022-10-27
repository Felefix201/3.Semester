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
        Arrays.stream(items)
                .filter(item -> item.getColor() == Item.Color.RED)
                .filter(item -> item.getCost() < 70)
                .mapToInt(item -> item.getWeight())
                //.average().getAsDouble();
                .forEach(System.out::println);
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
