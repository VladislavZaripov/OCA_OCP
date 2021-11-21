package OCP.Chapter3;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.TreeMap;

public class MapInterface {
    public static void main(String[] args) {
        Map <String,String> map1 = new HashMap   <> ();
        //      HashMap - don't allow Key duplicate, use hashCode() method
        //      lost order of elements
        //      Read, add or remove - O(1)

        Map <String,String> map3 = new TreeMap   <> ();
        //      TreeMap - don't allow Key duplicate
        //      always sort elements by KEY in tree structure
        //      Read, add or remove - O(log n)

        Map <String,String> map2 = new Hashtable <> ();
        //      Hashtable - old version HashMap like Vector in List

        /* Map interface methods */

        // void clear()             Removes all keys and values from the map.
        // boolean isEmpty()        Returns whether the map is empty.
        // int size()               Returns the number of entries (key/value pairs) in the map.
        // V get(Object key)        Returns the value mapped by key or null if none is mapped.
        // V put(K key, V value)    Adds or replaces key/value pair. Returns previous value or null.
        // V remove(Object key)     Removes and returns value mapped to key. Returns null if none.
        // boolean containsKey(Object key)      Returns whether key is in map.
        // boolean containsValue(Object)        Returns value is in map.
        // Set <K> keySet()                     Returns set of all keys.
        // Collection <V> values()              Returns Collection of all values.
    }}
