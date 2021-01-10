package visitor;

public class Visitor {
    public Integer sell(Fruit fruit){
        return fruit.accept(this);
    }
}
