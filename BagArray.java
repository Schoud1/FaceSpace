package FaceSpace;



import java.util.Iterator;

public class BagArray<Item> implements Bag<Item>, Iterable<Item>
{
   
   private Item[] items;        
   private int size;
   
   public BagArray()
   {
       items = (Item[]) (new Object[1]);  
       size = 0; 
   }
   
   public boolean isEmpty()
   {
       return (size == 0);
   }
   
   public int size()
   {
       return size;
   }
   
   public void resize(int capacity)
   {
       Item[] newArray = (Item[]) (new Object[capacity]);  
       for (int i = 0; i < size; i++) {
           newArray[i] = items[i];
       }
       items = newArray;
   }
   
   public void add(Item item)
   {   
       if (size == items.length) {
           resize( 2 * items.length );
       }
       items[size++] = item;
   }
   
   private class BagIterator implements Iterator<Item>
   {

       private int i = 0;

       public boolean hasNext() {
           return i < size;
       }

       public Item next() {
           return items[i++];
       }
   }
   
   public Iterator<Item> iterator()
   {
       return new BagIterator();
   }
   
   
}
