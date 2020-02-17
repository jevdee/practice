import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class Dish {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("Hello", "World");

        List<String[]> result = words.stream().map(w -> w.split("")).distinct().collect(toList());
        List<String> result2 = words.stream().map(w -> w.split("")).flatMap(Arrays::stream).distinct().collect(toList());

        List<Integer> numbers = Arrays.asList(1,2,3,4,5);
        List<Integer> result3 = numbers.stream().map(i -> i*i).collect(toList());

        List<Integer> num1 = Arrays.asList(1,2,3);
        List<Integer> num2 = Arrays.asList(3,4);
        List<int[]> result4 = num1.stream().flatMap(i -> num2.stream().map(j -> new int[]{i,j})).collect(toList());
        List<int[]> result5 = num1.stream().flatMap(i -> num2.stream().map(j -> new int[]{i,j})).filter(ints -> (ints[0]+ints[1]) % 3 == 0).collect(toList());
    }

    private final String name;
    private final boolean vegetarian;
    private final int calories;
    private final Type type;

    public Dish(String name, boolean vegetarian, int calories, Type type) {
        this.name = name;
        this.vegetarian = vegetarian;
        this.calories = calories;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public boolean isVegetarian() {
        return vegetarian;
    }

    public int getCalories() {
        return calories;
    }

    public Type getType() {
        return type;
    }

    public enum Type {
        MEAT,
        FISH,
        OTHER
    }

    @Override
    public String toString() {
        return name;
    }

    public static final List<Dish> menu = Arrays.asList(
            new Dish("pork", false, 800, Dish.Type.MEAT),
            new Dish("beef", false, 700, Dish.Type.MEAT),
            new Dish("chicken", false, 400, Dish.Type.MEAT),
            new Dish("french fries", true, 530, Dish.Type.OTHER),
            new Dish("rice", true, 350, Dish.Type.OTHER),
            new Dish("season fruit", true, 120, Dish.Type.OTHER),
            new Dish("pizza", true, 550, Dish.Type.OTHER),
            new Dish("prawns", false, 400, Dish.Type.FISH),
            new Dish("salmon", false, 450, Dish.Type.FISH)
    );

}
