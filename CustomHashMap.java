import java.util.LinkedList;
public class CustomHashMap<K, V> {
    private static class Node<K, V> {
        K key;
        V value;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
    private static final int INITIAL_CAPACITY = 16;
    private LinkedList<Node<K, V>>[] buckets;
    private int size = 0;
    public CustomHashMap() {
        buckets = new LinkedList[INITIAL_CAPACITY];
    }
    private int getBucketIndex(K key) {
        int hashCode = key == null ? 0 : key.hashCode();
        return Math.abs(hashCode) % buckets.length;
    }
    public void put(K key, V value) {
        int index = getBucketIndex(key);
        if (buckets[index] == null) {
            buckets[index] = new LinkedList<>();
        }
        for (Node<K, V> node : buckets[index]) {
            if (node.key.equals(key)) {
                node.value = value;
                return;
            }
        }
        buckets[index].add(new Node<>(key, value));
        size++;
    }
    public V get(K key) {
        int index = getBucketIndex(key);
        LinkedList<Node<K, V>> bucket = buckets[index];
        if (bucket != null) {
            for (Node<K, V> node : bucket) {
                if (node.key.equals(key)) {
                    return node.value;
                }
            }
        }
        return null;
    }
    public void remove(K key) {
        int index = getBucketIndex(key);
        LinkedList<Node<K, V>> bucket = buckets[index];
        if (bucket != null) {
            for (Node<K, V> node : bucket) {
                if (node.key.equals(key)) {
                    bucket.remove(node);
                    size--;
                    return;
                }
            }
        }
    }
}