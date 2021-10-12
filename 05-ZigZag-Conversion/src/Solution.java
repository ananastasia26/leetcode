public class Solution {
    public String convert(String s, int numRows) {
        StringBuilder sb = new StringBuilder();
        var shift = numRows == 1 ? 1 : 2;
        for (int i = 0; i < numRows; ++i) {
            var j = i;
            var go_down = (numRows == 1) || i != (numRows - 1);
            while (j < s.length()) {
                sb.append(s.charAt(j));

                if(go_down) {
                    j += 2 * numRows - shift * (1 + i);
                } else {
                    j += 2 * i;
                }

                if(i != 0 && i != (numRows - 1)) {
                    go_down = !go_down;
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        var s = new Solution();

        var r1 = s.convert("PAYPALISHIRING", 3);
        var r2 = s.convert("PAYPALISHIRING", 4);
        if(!r1.equals("PAHNAPLSIIGYIR")) {
            System.out.println("1) Your string: " + r1);
        }

        if (!r2.equals("PINALSIGYAHRPI")) {
            System.out.println("2) Your string: " + r2);
        }

        var r3 = s.convert("A", 1);
        if (!r3.equals("A")) {
            System.out.println("3) Your string: " + r3);
        }

    }
}
