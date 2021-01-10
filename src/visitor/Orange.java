package visitor;

public class Orange extends Fruit{
    @Override
    public Integer accept(Visitor visitor) {
        System.out.println("橘子15");
        return Integer.valueOf(15);
    }
}
