public class Node{
    int val;
    int key;
    Node prev;
    Node next;
    public Node(int key, int val){
        this.key = key;
        this.val = val;
        this.prev = null;
        this.next = null;
    }
}

class LRUCache {

    int cap;
    HashMap<Integer,Node> cache;
    Node right;
    Node left;

    public LRUCache(int capacity) {

    this.cap = capacity;
    this.right = new Node(0,0);
    this.left = new Node(0,0);
    this.cache = new HashMap<Integer,Node>();
    this.right.prev = this.left;
    this.left.next = this.right;
    }

    public void insert(Node node){
        Node prev = this.right.prev;
        prev.next = node;
        node.prev = prev;
        node.next = this.right;
        this.right.prev = node;
    }

    public void remove(Node node){
        Node next = node.next;
        Node prev = node.prev;
        next.prev = prev;
        prev.next = next;
    }
    
    public int get(int key) {
        if(cache.containsKey(key)){
            Node node = cache.get(key);
            remove(node);
            insert(node);
            return node.val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(cache.containsKey(key)){
            remove(cache.get(key));
        }
        Node newNode = new Node(key, value);
        cache.put(key, newNode);
        insert(newNode);

        if(cache.size() > cap){
            Node lru = this.left.next;
            remove(lru);
            cache.remove(lru.key);
        }
    }
}
