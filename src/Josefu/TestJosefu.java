package Josefu;

import java.util.LinkedList;
import java.util.stream.Stream;

public class TestJosefu {
    public static void main(String[] args) {
        /*LinkedList<Boy> linkedList = new LinkedList<>();
        for (int i = 1; i <= 5; i++) {
            Boy boy = new Boy(i,null);
            linkedList.add(boy);
        }

        for (int i = 0; i < 5; i++) {
            linkedList.get(i).setNext(linkedList.get((i + 1) % 5));
        }

        for (int i = 0; i < 5; i++) {
            System.out.println(linkedList.get(i) + " " + linkedList.get(i).getNext());
        }

        int count = 1;
        Boy head = linkedList.get(0);
        Boy tail = linkedList.get(4);
        Boy temp = null;
        while (linkedList.size() > 1) {
            head = head.getNext();
            tail = tail.getNext();
            temp = head;
            count ++;
            if (count % 3 == 0) {
                head = head.getNext();
                System.out.println("ÒÆ³ýµÄÔªËØ" + temp);
                linkedList.remove(temp);
                count = 1;
                tail.setNext(head);
            }


        }

        System.out.println(linkedList.get(0));*/

        Boy head = new Boy(1,null);
        Boy cur = head;
        for (int i = 2; i <= 5; i++) {
            cur.setNext(new Boy(i, null));
            cur = cur.getNext();
            if (i == 5) {
                cur.setNext(head);
            }
        }

        Boy tail = cur;
        cur = head;
        /*do {
            System.out.println(temp);
            temp = temp.getNext();
        } while (temp != head);
        */
        int count = 0;
        while (cur.getNext() != cur ) {
            count ++;
            cur = cur.getNext();
            if (count % 3 == 0) {
                tail.setNext(cur);
            } else {
                tail = tail.getNext();
            }
        }

        System.out.println(cur);
    }
}
