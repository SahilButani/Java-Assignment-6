
/*
 * The SList class has two methods toString which prints the SList and SListIterator which 
 * returns the head node.
 */
class SList<E> 
{
    private Link<E> headLink = new Link<E>(null);
    SListIterator<E> iterator() 
    { 
        return new SListIterator<E>(headLink); 
    }
    public String toString() 
    {
        if(headLink.next == null) return "SList: []";
        System.out.println("SList: [");
        SListIterator<E> it = this.iterator();
        StringBuilder s = new StringBuilder();
        while(it.hasNext()) 
        {
            s.append(it.next() + (it.hasNext() ? ", " : ""));
        }
        return s + "]";
    }
}

/*
 * The SListIterator class has functions which will insert remove the nodes
 * This class also has methods such as next() and hasNext() which will get 
 * get the next node, checks if the current node has next node respectively.
 */
class SListIterator<E> 
{
    Link<E> current;
    SListIterator(Link<E> link) 
    {
        current = link;
    }
    public boolean hasNext() 
    {
        return current.next != null;
    }
    public Link<E> next() 
    {
        current = current.next;
        return current;
    }
    public void insert(E e) 
    {
        current.next = new Link<E>(e, current.next);
        current = current.next;
    }
    public void remove() 
    {
        if(current.next != null) 
        {
            current.next = current.next.next;
        }
    }
}

/* 
 *This Link class acts as a node which has constructor that takes value of the node and also the 
 *link to next node.
 */
class Link<E> 
{
    E e;
    Link<E> next;
    Link(E e, Link<E> next) 
    {
        this.e = e;
        this.next = next;
    }
    Link(E e) 
    {
        this(e, null);
    }
    public String toString() 
    {
        if(e == null) return "null";
        return e.toString();
    }
}

public class List_Iterator 
{
    /*
     *Main method creates a sList and inserts elements and then removes them.
     */
    public static void main(String[] args) 
    {
        
        SList<String> sl = new SList<String>();
        
        System.out.println(sl);
        
        SListIterator<String> slIter = sl.iterator();
        
        System.out.println("inserting \"hello\"");
        slIter.insert("hello");
        System.out.println(sl);
        System.out.println("inserting \"there\"");
        slIter.insert("there");
        System.out.println(sl);
        System.out.println("inserting \"Sahil\"");
        slIter.insert("Sahil");
        System.out.println(sl);
        System.out.println("inserting \"Butani\"");
        slIter.insert("Butani");
        System.out.println(sl);

        SListIterator<String> slIter2 = sl.iterator();
        
        System.out.println("removing \"hello\"");
        slIter2.remove();
        System.out.println(sl);
        System.out.println("inserting \"hi\"");
        slIter2.insert("hi");
        System.out.println(sl);
        System.out.println("removing \"there\"");
        slIter2.remove();
        System.out.println(sl);
        System.out.println("removing \"Sahil\"");
        slIter2.remove();
        System.out.println(sl);
        System.out.println("removing \"Butani\"");
        slIter2.remove();
        System.out.println(sl);
        System.out.println("removing \"hi\"");
        SListIterator slIter3 = sl.iterator();
        slIter3.remove();
        System.out.println(sl);
    }
}

/*
OUTPUT:
SList: []
inserting "hello"
SList: [
hello]
inserting "there"
SList: [
hello, there]
inserting "Sahil"
SList: [
hello, there, Sahil]
inserting "Butani"
SList: [

hello, there, Sahil, Butani]
removing "hello"
SList: [
there, Sahil, Butani]
inserting "hi"
SList: [
hi, there, Sahil, Butani]
removing "there"
SList: [
hi, Sahil, Butani]
removing "Sahil"
SList: [
hi, Butani]
removing "Butani"
SList: [
hi]
removing "hi"
SList: []
*/
