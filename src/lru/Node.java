package lru;

/**
 * @author songxianglong
 * @date 2020/4/26 上午 10:59
 */
public class Node {

    public Node prev, next;

    public Integer key, val;

    public Node() {
    }

    public Node(Integer key, Integer val) {
        this.key = key;
        this.val = val;
    }

}
