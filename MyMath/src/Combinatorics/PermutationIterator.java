package Combinatorics;



import MyMath.MyMath;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;


//iterator for all permutations of a list (order matters)
//generates permutaions as needed, not all at once. each iteration includes all objects in list
public class PermutationIterator<T> implements Iterator<LinkedList<T>>{//wrapper class to convert all to linked list?
    //number of items to include in permutation?*** use a wrapper class to extract wanted elements from the list?
    private long numLeft;
    private LinkedList<T> objectsLeft;
    private T currentObject;
    private PermutationIterator iterator;
    
    public PermutationIterator(T[] iterable){
        objectsLeft = new LinkedList<>();
        objectsLeft.addAll(Arrays.asList(iterable));
        initiate();
    }
    
    public PermutationIterator(Iterable<T> iterable){
        objectsLeft = getListCopy(iterable);
        initiate();
    }
    
    private void initiate(){
        numLeft = (long) MyMath.fact(objectsLeft.size());
        
        currentObject = objectsLeft.pop();
        
        if (!objectsLeft.isEmpty()){
            iterator = new PermutationIterator(getListCopy(objectsLeft));
        }
    }

    @Override
    public boolean hasNext() {
        return numLeft != 0;
    }
    
    @Override
    public LinkedList<T> next() {
        if (iterator == null){
            LinkedList<T> singleList = new LinkedList<>();
            singleList.add(currentObject);
            numLeft --;
            return singleList;
        }
        
        if (iterator.hasNext()){
            LinkedList<T> list = iterator.next();
            list.add(0,currentObject);
            numLeft --;
            return list;
        }
        else{//swap out currentObject and return next
            T temp = objectsLeft.pop();
            objectsLeft.add(currentObject);
            currentObject = temp;
            
            iterator = new PermutationIterator(objectsLeft);
            
            LinkedList<T> list = iterator.next();
            list.add(0,currentObject);
            numLeft --;
            return list;
        }
    }
    
    //returns shallow copy of list
    private LinkedList<T> getListCopy(Iterable<T> iterable){
        LinkedList<T> newList = new LinkedList<>();
        for (T i : iterable){
            newList.add(i);
        }
        return newList;
    }
        
    
        
}
