package list;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: 定义双向链表的操作
 * <p>
 * 对于双向链表的操作，删除、新增
 */
public class LRUCache {

    //  定义当前缓存需要的链表，头节点
    public DoubleLinkedNode head;

    //  维护一个尾节点，方便新增
    public DoubleLinkedNode tail;

    public int capacity;

    public Map<Integer, DoubleLinkedNode> map = new HashMap<>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
//      关键是虚拟的头结点和尾节点
        head = new DoubleLinkedNode(-1, -1);
        tail = new DoubleLinkedNode(-1, -1);

        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        if (map.get(key) == null) {
            return -1;
        }
//      每次get操作，是要将当前的值提前的；
        putFirstPosition(key);
        return map.get(key).value;
    }

    public void put(int key, int value) {
        DoubleLinkedNode node = new DoubleLinkedNode(key, value);
        DoubleLinkedNode hasone = map.get(key);
        if (hasone != null) {
//          如果当前已近有这个节点了，那么先把map下的节点更新
            node.next = hasone.next;
            node.pre = hasone.pre;
            map.put(key, node);
//          再将当前的更新到首位
            putFirstPosition(key);
        } else {
            //  如果当前的节点数已经是等于了capacity
            if (map.size() == capacity) {
//       那么删除尾节点
                // 记录当前尾节点
                int removeKey = tail.pre.key;
                deleteTailNode();
//          map 删除尾节点
                map.remove(removeKey);
            }
            // 添加新节点；
            head.next.pre = node;
            node.next = head.next;
            node.pre = head;
            head.next = node;
            map.put(key, node);
        }
    }

    //  双向链表节点类，临时写为静态类
    static class DoubleLinkedNode {
        public Integer key;
        public Integer value;
        //      前序节点
        public DoubleLinkedNode pre;
        //      后续节点
        public DoubleLinkedNode next;

        public DoubleLinkedNode(Integer key, Integer value) {
            this.value = value;
            this.key = key;
        }
    }

    //  删除链表尾节点
    public void deleteTailNode() {
        tail.pre.pre.next = tail;
        tail.pre = tail.pre.pre;
    }

    public void deleteNode(int key) {
        DoubleLinkedNode delete = map.get(key);
        if (delete != null) {
            delete.pre.next = delete.next;
            delete.next.pre = delete.pre;
        }
    }

    public void putFirstPosition(int key) {
        DoubleLinkedNode node = map.get(key);
        // 将当前节点删除
        deleteNode(key);
//      在头结点添加当前节点

        head.next.pre = node;
        node.next = head.next;

        node.pre = head;
        head.next = node;
    }

    public static void main(String[] args) {

//      初始化
        LRUCache cache = new LRUCache(2);

        System.out.println(cache.get(2));
        cache.put(2, 6);
        System.out.println(cache.get(1));
        cache.put(1, 5);
        cache.put(1, 2);
        System.out.println(cache.get(1));
        System.out.println(cache.get(2));


    }

}
