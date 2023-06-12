package seminar4;

public class Node <K, V>{
    public K key;
    public V value;
    public Node<K, V> nextnode;

    public Node(K key, V value) {
        this.key = key;
        this.value = value;
    }
}