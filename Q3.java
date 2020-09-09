import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
* 剑指 Offer 03. 数组中重复的数字
* 找出数组中重复的数字。在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
* 示例 1：
* 输入：
* [2, 3, 1, 0, 2, 5, 3]
* 输出：2 或 3 
*/

public class Q3 {
//  Best Solution
    public int findRepeatNumber(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while (i != nums[i]) {
                if (nums[i] == nums[nums[i]]) {
                    return nums[i];
                }
                //sort and exchange
                int temp = nums[nums[i]];
                nums[nums[i]] = nums[i];
                nums[i] = temp;
            }
        }
        return -1;
    }

//  Use HashSet
    public int findRepeatNumberHash(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                return nums[i];
            }
            set.add(nums[i]);
        }
        return -1;
    }

    public static void main(String[] args) {
        Q3 q3= new Q3();
        int[] nums = {2, 3, 1, 5, 4, 5, 6};
        System.out.println(Arrays.toString(nums));
        System.out.println("findRepeatNumber\t" + q3.findRepeatNumber(nums));
        System.out.println("findRepeatNumberHash\t" + q3.findRepeatNumberHash(nums));
    }

}

