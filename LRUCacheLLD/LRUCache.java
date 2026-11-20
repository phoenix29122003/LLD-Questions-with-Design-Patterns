package LRUCacheLLD;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    public Map<Integer,Node>map;
    public Node head;
    public Node tail;
    public Integer capacity;
    public Integer currCapacity;

    public LRUCache(Integer capacity){
        if(capacity<0){
            throw new IllegalArgumentException("Non zero capacity not allowed.");
        }
        this.capacity=capacity;
        this.map=new HashMap<>();
        this.head=new Node(-1, -1);
        this.tail=new Node(-1,-1);
        this.currCapacity=0;
        head.next=tail;
        tail.prev=head;
    }

    public void putKey(Integer key, Integer value){
        if(map.containsKey(key)){
            Node currNode=map.get(key);
            removeNode(currNode);
            currNode.value=value;
            addAfterHead(currNode);
            System.out.println(key + " updated with value: "+value);
        }
        else{
            Node newNode=new Node(key, value);
            map.put(key, newNode);
            if(currCapacity==capacity){
                Node nodeBeforeTail=tail.prev;
                map.remove(nodeBeforeTail.key);
                removeBeforeTail();
                addAfterHead(newNode);
            }
            else if(currCapacity<capacity){
                addAfterHead(newNode);
                this.currCapacity++;
            }
            System.out.println("New key: "+key + " added with value:"+value);
        }
    }

    public Integer getKey(Integer key){
        if(map.containsKey(key)){
            Node currNode=map.get(key);
            removeNode(currNode);
            addAfterHead(currNode);
            System.out.println(key +" value is: "+currNode.value);
            return currNode.value;
        }
        else{
            System.out.println("Key not found in cache");
            return -1;
        }
    }

    public void removeNode(Node currNode){
        currNode.prev.next=currNode.next;
        currNode.next.prev=currNode.prev;
    }

    public void addAfterHead(Node newNode){
        newNode.next=head.next;
        newNode.prev=head;
        head.next=newNode;
        newNode.next.prev=newNode;
    }

    public void removeBeforeTail(){
        Node nodeBeforeTail=tail.prev;
        nodeBeforeTail.prev.next=tail;
        tail.prev=nodeBeforeTail.prev;
    }

    public void printCache(){
        Node currNode=head.next;
        while(currNode!=tail){
            System.out.println("Key: "+currNode.key+" Value: "+currNode.value);
            currNode=currNode.next;
        }
    }
}
