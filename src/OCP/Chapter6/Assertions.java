package OCP.Chapter6;
// assert boolean_expression;
// assert boolean_expression: error_message;

// Assertions throws AssertionsError if it is false.

// You must Enable assertions. By default assertions ignored by the JVM.
// For enable assertions you must use:
// java -enableassertions classname   OR   java -ea classname
// using without classname enables assertions in all class except System classes
// java -ea:com.OCP.Chapter6... my.programs.Main - three dots mean all classes
// java -ea:com.OCP.Chapter6.Assertions my.programs.Main - for specific class

// You can disable assertions using the -disablessertions OR -da

public class Assertions {
    public static void main(String[] args) {
        int numberGuests = -5;
        assert numberGuests > 0;
        System.out.println(numberGuests);
}}

class Assertions1 {
    public enum Seasons {one,two,three}

    public void testEnum (Seasons num) {
        switch (num){
            case one:
            case two:
            case three:
            default: assert false: "Invalid number";  }
}}

// class Assertions2 { ...
// assert booleanMethod(): "You can use method instead boolean_expression"
