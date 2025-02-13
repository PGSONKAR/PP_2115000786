import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
public class ZeroSumSubarrays {
    public static List<int[]> findZeroSumSubarrays(int[] nums) {
        List<int[]> result = new ArrayList<>();
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        int sum = 0;
        map.put(0, new ArrayList<>());
        map.get(0).add(-1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum)) {
                List<Integer> indices = map.get(sum);
                for (int start : indices) {
                    result.add(new int[]{start + 1, i});
                }
            }
            map.putIfAbsent(sum, new ArrayList<>());
            map.get(sum).add(i);
        }
        return result;
    }
    public static void main(String[] args) {
        int[] nums = {6, 3, -1, -3, 4, -2, 2, 4, 6, -12, -7};
        List<int[]> result = findZeroSumSubarrays(nums);
        System.out.println("Zero Sum Subarrays:");
        for (int[] subarray : result) {
            System.out.print("Start: " + subarray[0] + ", End: " + subarray[1] + " -> Elements: [");
            for (int i = subarray[0]; i <= subarray[1]; i++) {
                System.out.print(nums[i] + (i < subarray[1] ? ", " : ""));
            }
            System.out.println("]");
        }
    }
}