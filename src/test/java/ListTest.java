import java.util.ArrayList;
import java.util.List;

public class ListTest {

    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        if (list.contains("123")) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }

    }


}
