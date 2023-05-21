import java.util.ArrayList;
import java.util.List;

public class Solution {
    private final List<Integer> max_int_numbers = List.of(2, 1, 4, 7, 4, 8, 3, 6, 4, 7);
    private final List<Integer> min_int_numbers = List.of(2, 1, 4, 7, 4, 8, 3, 6, 4, 8);
    public int reverse(int x) {
        var reversedArrayOfX = this.numberToArrayOfReversedNumbers(x);
        var isNegative = x < 0;

        var arrayOfMAX_VALUE = isNegative ? min_int_numbers : max_int_numbers;

        if(isFirstBigger(reversedArrayOfX, arrayOfMAX_VALUE)) {
            return 0;
        }

        return arrayOfNumbersToInt(reversedArrayOfX) * (isNegative ? -1 : 1);
    }

    private List<Integer> numberToArrayOfReversedNumbers(int x){
        var numbers = new ArrayList<Integer>();
        var x1 = x;
        while (x1 != 0) {
            var remain = Math.abs(x1 % 10);
            numbers.add(remain);
            x1 = x1 / 10;
        }
        return numbers;
    }

    private boolean isFirstBigger(List<Integer> a, List<Integer> b) {
        if(a.size() > b.size()) {
            return true;
        }
        if (a.size() < b.size()){
            return false;
        }

        for(int i = 0; i < a.size(); ++i){
            if(a.get(i) > b.get(i)) {
                return true;
            } else if (a.get(i) < b.get(i)) {
                return false;
            }
        }

        return false;
    }

    private int arrayOfNumbersToInt(List<Integer> arr) {
        int i = 0;
        for(var number : arr){
            i *= 10;
            i += number;
        }
        return i;
    }
}
