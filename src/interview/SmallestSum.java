package interview;

import java.util.Arrays;

public class SmallestSum {

    //Receive a string which content is a sun expression, e.g. 135 + 183
    private static int smallestSum(String expression) {
        String [] nums = expression.split("[+]");
        String leftNum = nums[0];
        String rightNum = nums[1];
        int right = nums[1].length();
        int left = 0;
        int smallestRes = Integer.MAX_VALUE;
        int newLeftNum;
        int newRightNum;
        int res;
        while (left < leftNum.length()) {
            int multiplier = 1;
            newLeftNum = Integer.parseInt(leftNum.substring(left, right));
            while (right >= 1) {
                newRightNum = Integer.parseInt(rightNum.substring(0, right));
                res = (newLeftNum + newRightNum) * multiplier;
                smallestRes = Math.min(res, smallestRes);
                right --;
                multiplier = Integer.parseInt(rightNum.substring(right));
            }
            right = rightNum.length();
            left ++;
        }
        left = 0;

        while (right >= 1) {
            int multiplier = 1;
            newRightNum = Integer.parseInt(rightNum.substring(left, right));
            while (left < leftNum.length()) {
                newLeftNum = Integer.parseInt(leftNum.substring(left));
                res = (newLeftNum + newRightNum) * multiplier;
                smallestRes = Math.min(res, smallestRes);
                left ++;
                multiplier = Integer.parseInt(leftNum.substring(0, left));
            }
            left = 0;
            right --;
        }

        return smallestRes;
    }

    public static void main(String[] args) {
        System.out.println(smallestSum("135+183"));
    }
}
