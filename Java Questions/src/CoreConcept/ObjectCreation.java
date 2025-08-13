/*

Which one is correct

A

B extends A

C extends A

a) A a = new A()
b) B b = new A()   This one is not correct as we are trying to store os, This won’t compile because not all A objects are B objects.
c) B b = new B()
d) A a = new B()

 */

package CoreConcept;

class A {
    void show() {
        System.out.println("Inside class A");
    }
}

class B extends A {
    @Override
    void show() {
        System.out.println("Inside class B");
    }
}

class C extends A {
    @Override
    void show() {
        System.out.println("Inside class C");
    }
}

public class ObjectCreation {
    public static void main(String[] args) {
        // 1 ✅ Same type
        A a1 = new A();
        a1.show(); // Output: Inside class A

        // 2 ❌ This will not compile
        // B b1 = new A(); // Uncomment to see compile error

        // 3 ✅ Same type
        B b2 = new B();
        b2.show(); // Output: Inside class B

        // 4 ✅ Upcasting: child object, parent reference
        A a2 = new B();
        a2.show(); // Output: Inside class

    }
}