import java.util.*;

public class FractionalKnapsack {
    private static double getOptimalValue(int capacity, int[] values, int[] weights) {
        double value = 0;

        //write your code here

        return value;
    }

    private static double getOptimalValue(int capacity, List<Item> items) {
        double value = 0;
        double amount = 0;

        for (Item item : items) {
            if (capacity == 0) {
                return value;
            }

            amount = Math.min(item.getWeight(), capacity);
            value += amount * item.getValuePerWeightUnit();
            capacity -= amount;
        }

        return value;
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int capacity = scanner.nextInt();
        List<Item> items = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            items.add(new Item(scanner.nextDouble(), scanner.nextDouble()));
        }

        // Sort list based on valuePerWeightUnit, descending order
        Collections.sort(items, new Comparator<Item>() {
            @Override
            public int compare(Item o1, Item o2) {
                if (o1.getValuePerWeightUnit() < o2.getValuePerWeightUnit()) { return 1; }
                if (o1.getValuePerWeightUnit() > o2.getValuePerWeightUnit()) { return -1; }
                return 0;
            }
        });

        System.out.format("%.4f", getOptimalValue(capacity, items));
    }
} 

class Item {
    private double value;
    private double weight;
    private double valuePerWeightUnit;

    public Item(double v, double w) {
        value = v;
        weight = w;
        valuePerWeightUnit = value / weight;
    }

    public double getWeight() {
        return weight;
    }

    public double getValuePerWeightUnit() {
        return valuePerWeightUnit;
    }
}
