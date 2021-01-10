package Josefu;

public class Boy {
    private int no;
    private Boy next;

    public Boy(int no, Boy next) {
        this.no = no;
        this.next = next;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "Boy{" +
                "no=" + no +
                ", next=" + next.getNo() +
                '}';
    }
}
