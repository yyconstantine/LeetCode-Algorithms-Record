package lru;

/**
 * @author songxianglong
 * @date 2020/4/26 上午 10:59
 */
public class LruList {

    private Node head, tail;

    private int size;

    public LruList() {
        head = new Node(0, 0);
        tail = new Node(0 ,0);
        head.next = tail;
        tail.prev = head;
        size = 0;
    }

    public void addFirst(Node node) {
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
        size++;
    }

    public void remove(Node node) {
        if (head.next == tail || tail.prev == head || size == 0) {
            return;
        }
        node.prev.next = node.next;
        node.next.prev = node.prev;
        size--;
    }

    public Node removeLast() {
        if (head.next == tail || tail.prev == head || size == 0) {
            return null;
        }
        Node last = tail.prev;
        remove(last);
        return last;
    }

    public Integer size() {
        return size;
    }

}
