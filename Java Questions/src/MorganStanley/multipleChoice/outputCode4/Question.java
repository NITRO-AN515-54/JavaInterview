package MorganStanley.multipleChoice.outputCode4;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Question {

    public static void main(String args[]) {

        List<String> arrayList = new ArrayList<>();

        arrayList.add("a");
        arrayList.add("b");

        Iterator<String> itr = arrayList.iterator();

        while (itr.hasNext()) {
            System.out.println(itr.next());
            arrayList.add("c");
        }
    }
}
