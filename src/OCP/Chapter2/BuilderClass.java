package OCP.Chapter2;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Builder {
    private final String name;
    private final int age;
    private final List<String> list;

    public Builder(String name, int age, List<String> list) {
        this.name = name;
        this.age = age;
        this.list = new ArrayList<>(list);    }

    public String getName() {return name;}
    public int getAge() {return age;}
    public List<String> getList() {return list;}

    @Override
    public String toString() {return this.name + " " + this.age + " " + this.list;}
}
public class BuilderClass {
    private String name;
    private int age;
    private List<String> list;

    public BuilderClass setName(String name) {this.name = name;return this;}
    public BuilderClass setAge(int age) {this.age = age;return this;}
    public BuilderClass setList(List<String> list) {this.list = list;return this;}
    public Builder build (){return new Builder(name,age,list);}

    public static void main(String[] args) {
        BuilderClass builderClass1 = new BuilderClass();
        builderClass1.setName("Vlad").setAge(34).setList(Arrays.asList("Bla","Bla"));
        Builder builder1 = builderClass1.build();
        System.out.println(builder1);                        // Vlad 34 [Java, OCP]

        BuilderClass builderClass2 = new BuilderClass();
        builderClass2.setName("Tanya").setList(Arrays.asList("Bla","Bla"));
        Builder builder2 = builderClass2.build();
        System.out.println(builder2);                        // Tanya 0 [Bla, Bla]

        BuilderClass builderClass3 = new BuilderClass();
        builderClass3.setName("Null").setAge(34);            // list is NULL
    //  Builder builder3 = builderClass3.build();            // NullPointerException
    }}
