import java.util.*;
public class SubsetCheck {
    public static boolean isSubset(Set<Integer> subset, Set<Integer> superset) {
        return superset.containsAll(subset);
    }
    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>(Set.of(2, 3));
        Set<Integer> set2 = new HashSet<>(Set.of(1, 2, 3, 4));
        System.out.println("Is Subset: " + isSubset(set1, set2));
    }
}