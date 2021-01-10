package visitor;

public class Apple extends Fruit{
    @Override
    public Integer accept(Visitor visitor) {
        System.out.println("苹果10");
        return Integer.valueOf(10);
    }
}
