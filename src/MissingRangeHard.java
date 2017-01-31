import java.util.*;

/**
 * Created by Nikhil on 1/31/17.
 */

/**
 * Extension of Missing ranges with negatives and duplicates and unsorted
 */
public class MissingRangeHard {
    public static void main(String[] args) {
        int[] input = {5};
        List<String> list = giveMissingRange(input);
        for (String s : list) {
            System.out.println(s);
        }
    }

    public static List<String> giveMissingRange(int[] input) {
        List<String> list = new LinkedList<>();
        if (input == null) return list;
        int start = 0;
        Arrays.sort(input);
        // 1,2 ,3 6
        if (input.length == 0) {
            list.add(0 + "-" + 100);
            return list;
        }
        for (int i = 0; i < input.length; i++) {

            if (input[i] >= 0 & input[i] <= 100) {
                int number1 = input[i];

                if (number1-start != 0) {
                    int rangeEnd = number1 - 1;
                    if (start == rangeEnd ) {
                        list.add(start + "");
                    } else {
                        list.add(start + "-" + rangeEnd );
                    }
                }
                start = number1+1;
                while(i < input.length-1 && input[i]==input[i+1]){
                    i++;
                }


            }
        }
        if(start==100){
            list.add(100+"");

        }else if(start<100){
            String s = start+"-"+100;
            list.add(s);
        }

        return list;
    }
}
