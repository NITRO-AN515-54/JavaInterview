public class SwapWithoutTemp {
    public static void main(String[] args) {

        // ----- 1. Using Arithmetic -----
        int a1 = -5;
        int b1 = -10;

        System.out.println("Before Arithmetic Swap: a1 = " + a1 + ", b1 = " + b1);

        a1 = a1 + b1;
        b1 = a1 - b1;
        a1 = a1 - b1;

        System.out.println("After Arithmetic Swap:  a1 = " + a1 + ", b1 = " + b1);


        // ----- 2. Using Bitwise XOR -----
        int a2 = 5;
        int b2 = 10;

        System.out.println("\nBefore XOR Swap: a2 = " + a2 + ", b2 = " + b2);

        a2 = a2 ^ b2;
        b2 = a2 ^ b2;
        a2 = a2 ^ b2;

        System.out.println("After XOR Swap:    a2 = " + a2 + ", b2 = " + b2);
    }
}
