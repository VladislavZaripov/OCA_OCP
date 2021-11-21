package OCP.Chapter7;
import java.util.*;
import java.util.concurrent.*;
public class ConcurrentCollections {
    public static void main(String[] args) {

/*Concurrent*/      // use this class instead 'Synchronized'
        ConcurrentMap CHM = new ConcurrentHashMap();
        Deque D = new ConcurrentLinkedDeque();
        Queue Q = new ConcurrentLinkedQueue();

/*SkipList*/        // Sorted!
        SortedMap    SM1 = new ConcurrentSkipListMap();
        NavigableMap SM2 = new ConcurrentSkipListMap();
        SortedSet    SS1 = new ConcurrentSkipListSet();
        NavigableSet SS2 = new ConcurrentSkipListSet();

/*CopyOnWrite*/     // CopyOnWriteArrayList create copy when you modify element!

        // If you modify element in LinkedList when iterating, it will cause Exception
        // List <Integer> linkedList = new LinkedList<> (Arrays.asList(1,2));
        // for (Integer num : linkedList){
        //     System.out.print(num + " ");    // ConcurrentModificationException
        //     linkedList.add(10);       }

        List <Integer> list = new CopyOnWriteArrayList<> (Arrays.asList(1,2));
        Set set   = new ConcurrentSkipListSet();

        for (Integer num : list){
            list.add(10);
            System.out.print(num + " ");    // 1 2
            list.add(20);        }
        for (Integer num : list){
            System.out.print(num + " ");}   // 1 2 10 20 10 20

/*Blocking Queues*/
        BlockingQueue BQ1 = new LinkedBlockingQueue();
        try {
            BQ1.offer(10);                           // throw InterruptedException
            BQ1.offer(20,2,TimeUnit.SECONDS);        // throw InterruptedException
            System.out.println(BQ1.poll());                         // 10
            System.out.println(BQ1.poll(2,TimeUnit.SECONDS));       // 20
        }
        catch (InterruptedException e) {}

        BlockingQueue BQ2 = new LinkedBlockingDeque();

        BlockingDeque BD  = new LinkedBlockingDeque();
        try {
            BD.offerFirst(10,2,TimeUnit.SECONDS);     // throw InterruptedException
            BD.offerLast(20,2,TimeUnit.SECONDS);      // throw InterruptedException
            BD.offer(30,2,TimeUnit.SECONDS);
            System.out.println(BD.poll(2,TimeUnit.SECONDS));        // 10
            System.out.println(BD.pollLast(2,TimeUnit.SECONDS));    // 30
            System.out.println(BD.pollFirst(2,TimeUnit.SECONDS));   // 20
        }
        catch (InterruptedException e) {}

/*SynchronizedCollections*/ // Synchronize methods such as get() and set()
                            // DON'T synchronize any iterators

        Map<String, Object> map = new HashMap <String, Object>();
        map.put("one", 1); map.put("two", 2);
        Map<String,Object> SM = Collections.synchronizedMap(map);
        try{
            synchronized (SM)       {
        for(String key: SM.keySet())    // throw ConcurrentModificationException
            SM.remove(key);         }
        }
        catch (ConcurrentModificationException e) {}
    }}
