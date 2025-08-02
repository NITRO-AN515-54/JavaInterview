package CoreConcept.QuestionOnStatic;

/*
Having below four multiple choice questions

1) Compilation fails due to an error on line 2
2) Compilation fails due to error an on line 9, non-static method referenced from a static context.   this one is correct
3) Compilation fails due to a type mismatch on line 9.
4) 15

 */
public class CoreQuestion1 {
    int add(int i, int j) {
        return i + j;
    }
}