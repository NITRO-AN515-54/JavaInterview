public class reverseTheArray {

    public static void main(String[] arrgs){
        int[] array = {1,2,3};
        int[] array1 = new int[3];

        for(int j = 0, i = array.length ; i > 0 ; j++,i--){
            array1[j] = array[i -1];
        }

        for(int i = 0; i < array1.length ; i++) {
            System.out.println(array1[i]);
        }
    }
}
