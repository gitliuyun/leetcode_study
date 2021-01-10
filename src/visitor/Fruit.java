package visitor;

public class Fruit {

    public Integer accept(Visitor visitor) {
        return visitor.sell(this);
    }
}
