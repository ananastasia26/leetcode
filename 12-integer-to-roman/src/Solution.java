class Solution {
    private static String[][] ROMANS_BY_DIGIT = new String[][] {
            {"I", "V"},
            {"X", "L"},
            {"C", "D"},
            {"M"}};

    public String intToRoman(int num) {
        var digit = 0;
        var res = new StringBuilder();

        while(num > 0) {
            var n = num % 10;

            var nToRoman = new StringBuilder();

            if (n == 5){
                nToRoman.append(ROMANS_BY_DIGIT[digit][1]);
            } else if (n % 5 == 4) {
                if (n < 5) {
                    nToRoman.append(ROMANS_BY_DIGIT[digit][0]).append(ROMANS_BY_DIGIT[digit][1]);
                } else {
                    nToRoman.append(ROMANS_BY_DIGIT[digit][0]).append(ROMANS_BY_DIGIT[digit + 1][0]);
                }
            } else {
                nToRoman.append(String.valueOf(ROMANS_BY_DIGIT[digit][0]).repeat(n % 5));
                if(n > 5) {
                    nToRoman.insert(0, ROMANS_BY_DIGIT[digit][1]);
                }
            }

            res.insert(0, nToRoman);

            digit++;
            num /= 10;
        }
        return res.toString();
    }

    public static void main(String[] args) {
        var s = new Solution();

        System.out.println(s.intToRoman(9));
        System.out.println(s.intToRoman(149));
        System.out.println(s.intToRoman(3));
        System.out.println(s.intToRoman(1998));
    }

}