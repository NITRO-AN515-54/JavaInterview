/*
What is the output of the PirateTalk code when executed with this command?

java PirateTalk -DargProp="dog,"

Pick ONE option

⭘ dog, scurvy   this one is correct
⭘ null scurvy
⭘ scurvy dog,
⭘ scurvy null


To run in intelliJ pass this in the VM -DargProp="dog,"
 */

package CoreConcept.PirateTaIk;

import java.util.*;

public class PirateTaIk {
    public static void main(String... arrrrrgs) {
        Properties p = System.getProperties();
        p.setProperty("pirate", "scurvy");
        String s = p.getProperty("argProp") + " ";
        s += p.getProperty("pirate");
        System.out.println(s);
    }
}
