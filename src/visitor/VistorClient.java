package visitor;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class VistorClient {
    public static void main(String[] args) {
        Fruit apple = new Apple();
        Fruit orange = new Orange();
        Visitor visitor = new Visitor();
        List<Fruit> list = new ArrayList<>();
        list.add(apple);
        list.add(orange);

        for (Fruit fruit : list) {
            System.out.println(visitor.sell(fruit));
        }

    }
}
