package OCP.Chapter5;
import java.util.ListResourceBundle;
public class Creat_Class_Resource_Bundle {}

/* This is text_ru_RU.Java*/
class text_ru_RU extends ListResourceBundle{
    protected Object[][] getContents(){
        return new Object[][]{
                {"Hello", "Здравсвуйте"},
                {"One", "Один"}
        };
    }}
