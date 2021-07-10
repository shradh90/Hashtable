import java.util.ArrayList;

public class HashTableImpl {
    Node head;
    Node tail;
    private final int numOfBuckets;
    ArrayList<Node<K,V>> myBucketArray;

    public HashTableImpl() {
        this.numOfBuckets = 20;                     //20 is assigned a little more than the numbers of total words
        this.myBucketArray = new ArrayList<>();
        for (int i = 0; i < numOfBuckets; i++)
            this.myBucketArray.add(null);
    }

    public void add(K key, V value) {
        int index = this.getBucketIndex(key);
        Node<K,V> myNode= this.myBucketArray.get(index);
        if(myNode == null) {
            myNode = new Node<>(key , value);
            this.myBucketArray.set(index, myNode);
        }
        myNode = (Node<K, V>) searchNode(key);
        if(myNode == null) {
            myNode = new Node<>(key , value);
            this.append(myNode);
        }
        else {
            myNode.setValue(value);
        }
    }

    //Append the value in the hashtable
    public void append(Node myNode) {
        if(this.head == null)
            this.head = myNode;
        if(this.tail == null)
            this.tail = myNode;
        else {
            this.tail.setNext(myNode);
            this.tail = myNode;
        }
    }

    //Searching for the word in the hashtable
    public Node<K, V> searchNode(K data) {
        Node currentNode = head;
        int position = 0;
        while (currentNode != null) {
            position++;
            if (currentNode.getKey().equals(data)) {
                return currentNode;
            }
            currentNode = currentNode.getNext();
        }
        return currentNode;
    }

    //Searching for the word and get the value from the hashtable
    public V get(K word) {
        int index = this.getBucketIndex(word);
        if(this.myBucketArray.get(index) == null)
            return null;
        Node<K, V> myMapNode = searchNode(word);
        return (myMapNode == null) ? null : myMapNode.getValue();
    }

    //hashcode to find the index
    private int getBucketIndex(K word) {
        int hashCode = Math.abs(word.hashCode());
        int index = hashCode % numOfBuckets;
        //System.out.println("Key: "+word+" hashcode: "+hashCode+" index: "+index);
        return index;
    }

    //Remove "avoidable" from hashtable
    public void remove(K word) {
        Node currentNode = head;
        Node previousNode = null;
        while (currentNode != null && currentNode.getKey().equals(word)) {
            head = currentNode.getNext();
            return;
        }
        while (currentNode != null && !(currentNode.getKey().equals(word))) {
            previousNode = currentNode;
            currentNode = currentNode.getNext();
        }
        if (currentNode != null) {
            previousNode.next = currentNode.next;
        }
        if(currentNode == null)
            System.out.println("Word not found!");
    }

    //Print the hashtable
    @Override
    public String toString() {
        return "MyLinkedListNodes{" + head + "}";
    }
}
