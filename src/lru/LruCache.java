package lru;

import java.util.HashMap;

/**
 * @author songxianglong
 * @date 2020/4/26 上午 10:59
 */
public class LruCache {

    private HashMap<Integer, Integer> map;

    private LruList cache;

    /**
     * lru容量
     */
    private Integer capacity;

    public Integer get(Integer key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        // 先获取结果
        Integer result = map.get(key);
        // 再将对应key提前(执行一次put)
        put(key, result);
        return result;
    }

    public void put(Integer key, Integer val) {
        Node node = new Node(key, val);
        if (map.containsKey(key)) {
            cache.remove(node);
            cache.addFirst(node);
            map.put(key, val);
        } else {
            if (capacity.equals(cache.size())) {
                Node last = cache.removeLast();
                map.remove(last.key);
            }
            cache.addFirst(node);
            map.put(key, val);
        }
    }

}
