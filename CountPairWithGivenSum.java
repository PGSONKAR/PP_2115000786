import java.util.HashMap;
public class CountPairWithGivenSum {
    public static void checkPairWithSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int currentNumber = nums[i];
            int requiredNumber = target - currentNumber;
            if (map.containsKey(requiredNumber)) {
                System.out.println("Pair Found: (" + requiredNumber + ", " + currentNumber + ")");
                return;
            }
            map.put(currentNumber, i);
        }
        System.out.println("No Pair Found with Sum " + target);
    }
    public static void main(String[] args) {
        int[] nums = {10, 2, 8, 5, 7, 3};
        int target = 15;
        checkPairWithSum(nums, target);
    }
}