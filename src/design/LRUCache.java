package design;

import java.util.HashMap;
import java.util.Map;

/**
 * ʹ������洢���ʹ�õĽڵ㣬ʹ��map�洢���ͽڵ�
 * map   key    value
 *        1     node1
 *        2     node2
 *
 * linklist   head                      tail
 *          dummyHead->node1->node2->dummyTail
 */
public class LRUCache {

    public static void main(String[] args) {
        String[] operations = {"LRUCache","get","put","get","put","put","get","get"};
        Integer[][] nums = {{2},{2},{2,6},{1},{1,5},{1,2},{1},{2}};
        LRUCache lRUCache = new LRUCache(nums[0][0]);
        for (int i = 0; i < operations.length; i++) {
            System.out.print("ѭ����" + i + "��" + "����:" + operations[i] + "��ֵ��" + nums[i][0] + " ");
            if (operations[i] == "put") {
                lRUCache.put(nums[i][0], nums[i][1]);
            }

            Node head = lRUCache.dummyHead;
            while (head != null) {
                System.out.print(head.hashCode() + "->");
                head = head.next;
            }
            System.out.print("=====map====");
            lRUCache.map.forEach((k,v) -> System.out.print(k + "��" + v.value + " "));
            System.out.println();
            if (operations[i] == "get") {
                System.out.println("ѭ����" + i + "��" + "get����� " + lRUCache.get(nums[i][0]));
            }
        }

    }

    public static class Node {
        int key,value;
        Node pre,next;
        public Node(int key, int value){
            this.key = key;
            this.value = value;
        }
        public Node(){
        }
    }

    private int size,capacity;
    private Map<Integer, Node> map;
    private Node dummyHead = new Node();
    private Node dummyTail = new Node();

    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        map = new HashMap();
        dummyHead.next = dummyTail;
        dummyTail.pre = dummyHead;
    }

    public int get(int key) {
        if (map.get(key) == null) {
            return -1;
        }
        Node node = map.get(key);
        //���Լ��Ƴ���ӵ�����
        removeSelf(node);
        insertIntoHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        Node node;
        if (map.get(key) == null) {
            size ++;
            node = new Node(key, value);
            if (size > capacity) {
                removeTail(node);
                size --;
            }
        } else {
            node = map.get(key);
            node.value = value;
            removeSelf(node);
        }
        //������λ�øı��Ҫͬ������map�нڵ����Ϣ��ǰ���ͺ�̣�
        insertIntoHead(node);
    }

    private void insertIntoHead(Node node) {
        Node tmp = dummyHead.next;
        tmp.pre = node;
        node.next = tmp;
        dummyHead.next = node;
        node.pre = dummyHead;
        map.put(node.key, node);
    }

    private void removeTail(Node node) {
        Node tailPre = dummyTail.pre;
        Node tmp = tailPre.pre;
        tmp.next = dummyTail;
        dummyTail.pre = tmp;
        //�������Ƴ���Ҫͬ���Ƴ�map�е�Ԫ��
        map.remove(tailPre.key);
    }

    private void removeSelf(Node node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
        node.next = null;
        node.pre = null;
        map.remove(node.key);
    }
}
