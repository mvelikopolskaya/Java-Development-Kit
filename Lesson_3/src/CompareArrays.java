public class CompareArrays {
    public static <T> boolean compareArrays(T[] arr1, T[] arr2) {
        boolean checkArray = true;
        if(arr1.length != arr2.length) checkArray = false;
        else {
            for (int i = 0; i < arr1.length; i++) {
                if (!arr1[i].getClass().equals(arr2[i].getClass())) {
                    checkArray = false;
                    break;
                }
            }
        }
        return checkArray;
    }
}
