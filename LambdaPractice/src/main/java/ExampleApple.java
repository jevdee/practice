import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class ExampleApple {

    public static void main(String[] args) {
        List<Apple> inventory = Arrays.asList(
                new Apple(80, Color.GREEN),
                new Apple(155, Color.GREEN),
                new Apple(120, Color.RED));

        List<Integer> numbers = Arrays.asList(
                80, 155, 120
               );
        // [Apple{color=GREEN, weight=80}, Apple{color=GREEN, weight=155}]
//        List<Apple> greenApples = filterApplesByColor(inventory, Color.GREEN);
//        System.out.println(greenApples);

//        // [Apple{color=GREEN, weight=80}, Apple{color=GREEN, weight=155}]
//        List<Apple> greenApples2 = filterApples(inventory, new AppleColorPredicate());
//        System.out.println(greenApples2);
//
//        // [Apple{color=GREEN, weight=155}]
//        List<Apple> heavyApples = filterApples(inventory, new AppleWeightPredicate());
//        System.out.println(heavyApples);
//
//        // []
//        List<Apple> redAndHeavyApples = filterApples(inventory, new AppleRedAndHeavyPredicate());
//        System.out.println(redAndHeavyApples);

//        prettyPrintApple(inventory, new AppleColorAndWeightFormatter());
//        prettyPrintApple(inventory, new AppleWeightFormatter());
//
//        List<Apple> redApples = filterApples(inventory, new ApplePredicate() {
//            @Override
//            public boolean test(Apple apple) {
//                return "RED".equals(apple.getColor());
//            }
//        });
//        List<Apple> redApples2 = filterApples(inventory, (Apple apple) -> "RED".equals(apple.getColor()));
        List<Apple> redApples3 = filter(inventory, (Apple apple) -> "RED".equals(apple.getColor()));
        List<Integer> evenNumbers = filter(numbers, (Integer i) -> i % 2 == 0);
        System.out.println(evenNumbers);
    }

    public static <T> List<T> filter(List<T> list, Predicate<T> p) {
        List<T> result = new ArrayList<>();
        for(T e: list) {
            if(p.test(e)) {
                result.add(e);
            }
        }

        return result;
    }

    public interface ApplePredicate {
        boolean test(Apple apple);
    }

    static class AppleWeightPredicate implements ApplePredicate {
        @Override
        public boolean test(Apple apple) {
            return apple.getWeight() > 150;
        }
    }
    static class AppleColorPredicate implements ApplePredicate {
        @Override
        public boolean test(Apple apple) {
            return apple.getColor() == Color.GREEN;
        }
    }
    static class AppleRedAndHeavyPredicate implements ApplePredicate {
        @Override
        public boolean test(Apple apple) {
            return apple.getColor() == Color.RED && apple.getWeight() > 150;
        }
    }

    public interface AppleFormatter {
        String accept(Apple apple);
    }

    static class AppleColorAndWeightFormatter implements AppleFormatter {
        @Override
        public String accept(Apple apple) {
            String weight = (apple.getWeight() > 150) ? "heavy" : "light";
            return "A " + weight + " " + apple.getColor() + " apple";
        }
    }

    static class AppleWeightFormatter implements AppleFormatter {
        @Override
        public String accept(Apple apple) {
            return "An apple of " + apple.getWeight() + "g";
        }
    }

    public static List<Apple> filterApples(List<Apple> inventory, ApplePredicate p) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (p.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }

    public static void prettyPrintApple(List<Apple> inventory, AppleFormatter f) {
        for(Apple apple : inventory) {
            String output = f.accept(apple);
            System.out.println(output);
        }
    }

//    public static List<Apple> filterApplesByColor(List<Apple> inventory, Color color) {
//        List<Apple> result = new ArrayList<>();
//        for (Apple apple : inventory) {
//            if (apple.getColor().equals(color)) {
//                result.add(apple);
//            }
//        }
//        return result;
//    }
//
//    public static List<Apple> filterApplesByWeight(List<Apple> inventory, int weight) {
//        List<Apple> result = new ArrayList<>();
//        for (Apple apple : inventory) {
//            if (apple.getWeight() > weight) {
//                result.add(apple);
//            }
//        }
//        return result;
//    }


    enum Color {
        RED,
        GREEN
    }

    public static class Apple {

        private int weight = 0;
        private Color color;

        public Apple(int weight, Color color) {
            this.weight = weight;
            this.color = color;
        }

        public int getWeight() {
            return weight;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }

        public Color getColor() {
            return color;
        }

        public void setColor(Color color) {
            this.color = color;
        }

        @SuppressWarnings("boxing")
        @Override
        public String toString() {
            return String.format("Apple{color=%s, weight=%d}", color, weight);
        }

    }
}
