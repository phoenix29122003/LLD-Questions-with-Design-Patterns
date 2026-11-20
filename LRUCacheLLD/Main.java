package LRUCacheLLD;

public class Main {
    public static void main(String args[]){
        LRUCache cache=new LRUCache(3);
        cache.printCache();
        cache.putKey(1, 1);
        cache.putKey(2, 2);
        cache.putKey(3, 3);
        cache.printCache();
        cache.putKey(4, 4);
        cache.printCache();
        cache.putKey(5, 5);
        cache.printCache();
        cache.putKey(3, 6);
        cache.printCache();
        cache.getKey(4);
        cache.printCache();
    }
}
