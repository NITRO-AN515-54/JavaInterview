/*
Pick ONE option

⭘ a followed by ConcurrentModificationException this one is correct
⭘ a b c
⭘ a
⭘ a c

 */

package CoreConcept.Itrator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Question {
    public static void main(String args[]){
        List<String> arrayList = new ArrayList<>();
        arrayList.add("a");
        arrayList.add("b");
        Iterator<String> itr = arrayList.iterator();
        while(itr.hasNext()){
            System.out.println(itr.next());
            arrayList.add("c");
        }
    }
}
