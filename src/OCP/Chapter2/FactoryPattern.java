package OCP.Chapter2;

public abstract class FactoryPattern {
    private int num;
    public FactoryPattern (int num) {this.num = num;}
    public int getNum() {return num;}
    public abstract void getSomeNum ();
}
class Tool1 extends FactoryPattern {
    public Tool1(int num){super(num);}
    public void getSomeNum(){System.out.println("Tool1 " + getNum());}}
class Tool2 extends FactoryPattern {
    public Tool2(int num){super(num);}
    public void getSomeNum(){System.out.println("Tool2 " + getNum());}}
class Tool3 extends FactoryPattern {
    public Tool3(int num){super(num);}
    public void getSomeNum(){System.out.println("Tool3 " + getNum());}}

class Factory {
    public static FactoryPattern getTool (String tool){
        switch (tool){
            case "tool1": return new Tool1(100);
            case "tool2": return new Tool2(200);
            case "tool3": return new Tool3(300);
            default: return null;}}
    }
class Worker {
    public static void main(String[] args) {
        final FactoryPattern factoryPattern = Factory.getTool("tool1");
        factoryPattern.getSomeNum();            // Tool1 100
    }}
