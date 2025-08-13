package CoreConcept.QuestionOnStatic;

class CoreQuestion1 {
    int add(int i, int j) {
        return i + j;
    }
}

public class MainClass extends CoreQuestion1 {
    public static void main(String args[]) {
        short s = 9;
        //System.out.println(add(s, 6));
    }
}