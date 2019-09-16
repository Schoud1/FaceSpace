package FaceSpace;



import java.util.Iterator;



public class LinkedListH<Item> implements Iterable<Item> {

    private class Node {
        Item item;
        Node next;
    }
    
    private Node first = null;
    private int size = 0;
    
    public boolean isEmpty() {
        return (first == null);
    }

    public int size() {
        return size;
    }
    
    public void addFirst(Item item) {
        Node node = new Node();
        node.item = item;
        node.next = first;
        first = node;
        size++;
    }
    
    public Item removeFirst() {
        if (this.isEmpty()) { 
            return null;
        }
        else { 
            Item item = first.item;
            first = first.next;
            size--;
            return item;
        }
    }
    
    public void addLast(Item item) { 
       
        
        Node node = new Node();
        node.item = item;
        
        if (this.isEmpty()) { 
            first = node;
        }
        else { 
            Node n = first;
            while (n.next != null) 
                n = n.next;
            n.next = node;
        }
        size++;
    }
    
    public Item removeLast() {  
      
                
        if (this.isEmpty())  
            return null; 
        else if (first.next == null) { 
            Item item = first.item;
            first = null;
            size--;
            return item;
        }
        else { 
            Node n = first;
            while (n.next.next != null) {
                n = n.next;
            }
           
            Item item = n.next.item;
            n.next = null;
            size--;
            return item;
        }
    }
    
    public boolean contains(Item item) {
     
        for (Node n = first; n != null; n = n.next) {
            if (n.item.equals(item)) return true;
        }
        return false;
    }
    
    public Iterator<Item> iterator() {
        return new Iterator<Item>() {
            Node node = first;
            
            public boolean hasNext() {
                return (node != null);
            }
            
            public Item next() {
                Item item = node.item;
                node = node.next;
                return item;
            }
        };
    }
    
    public String toString() {
        String outputStr = "";
        outputStr += "first: " + ((first != null) ? first.item : "-") + "   ";
        outputStr += "size: " + this.size + "   ";
        outputStr += " list: ";
        for (Item i : this) {
            outputStr += i + " ";
        }
        return outputStr;
    }

   
}
