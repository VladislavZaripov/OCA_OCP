package OCP.Chapter2;
import java.util.ArrayList;
import java.util.List;

/*
1. Use a constructor to set all properties of the object.
2. Mark all of the instance variables private and final .
3. Don’t define any setter methods.
4. Don’t allow referenced mutable objects to be modified or accessed directly.
5. Prevent methods from being overridden.
 */
public class ImmutableObject {
    private final String name;
    private final List<String> list;

    public ImmutableObject (String name, List <String> list){
        this.name = name;
    if (list == null) throw new RuntimeException("List is null");
        this.list = new ArrayList <String>(list);} // create new List, not refer

    public String getName(){return name;}
    public String getList(int index){return list.get(index);}
}
