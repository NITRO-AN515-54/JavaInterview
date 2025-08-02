/*
Pick ONE option
⭕ Line 2 generates warning
⭕ Line 3 generates warning
⭕ Code does not compile
✅ Code compiles and runs properly
 */

package CoreConcept.Generic2;

public class Main {

    static class MyAdd<T> {
        void add(T t) {
            System.out.println("Added: " + t + " of type " + t.getClass().getSimpleName());
        }
    }

    public static void main(String[] args) {
        MyAdd<Number> myadd = new MyAdd<>();
        myadd.add(new Integer(1));  // Line 2
        myadd.add(new Double(1.0)); // Line 3
    }
}
