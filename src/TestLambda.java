import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class TestLambda {
    public static void main(String[] args) {

        Integer[] ints = {3,4,2,1};
        Arrays.stream(ints).forEach(e -> System.out.print(e) );
        System.out.println();
        Arrays.sort(ints, (x,y) -> x - y);
        Arrays.stream(ints).forEach(e -> System.out.print(e) );
        System.out.println();
        Consumer consumer = x -> System.out.println(x);

    }

}
