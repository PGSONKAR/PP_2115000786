import java.util.*;

class Policy implements Comparable<Policy> {
    private String policyNumber;
    private String policyholderName;
    private String expiryDate;
    private String coverageType;
    private double premiumAmount;

    public Policy(String policyNumber, String policyholderName, String expiryDate, 
                  String coverageType, double premiumAmount) {
        this.policyNumber = policyNumber;
        this.policyholderName = policyholderName;
        this.expiryDate = expiryDate;
        this.coverageType = coverageType;
        this.premiumAmount = premiumAmount;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Policy policy = (Policy) obj;
        return policyNumber.equals(policy.policyNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(policyNumber);
    }

    @Override
    public int compareTo(Policy other) {
        return this.policyNumber.compareTo(other.policyNumber);
    }
}

public class PolicySetComparison {
    public static void main(String[] args) {
        Set<Policy> hashSet = new HashSet<>();
        Set<Policy> linkedHashSet = new LinkedHashSet<>();
        Set<Policy> treeSet = new TreeSet<>();

        Policy p1 = new Policy("P1001", "Alice", "2026-12-31", "Health", 5000.0);
        Policy p2 = new Policy("P1002", "Bob", "2025-06-30", "Auto", 3200.0);
        Policy p3 = new Policy("P1003", "Charlie", "2027-08-15", "Home", 7500.0);

        measurePerformance(hashSet, "HashSet", p1, p2, p3);
        measurePerformance(linkedHashSet, "LinkedHashSet", p1, p2, p3);
        measurePerformance(treeSet, "TreeSet", p1, p2, p3);
    }

    private static void measurePerformance(Set<Policy> set, String setName, Policy... policies) {
        long startTime, endTime;

        startTime = System.nanoTime();
        for (Policy policy : policies) set.add(policy);
        endTime = System.nanoTime();
        System.out.println(setName + " Add Time: " + (endTime - startTime) + " ns");

        startTime = System.nanoTime();
        boolean contains = set.contains(policies[1]);
        endTime = System.nanoTime();
        System.out.println(setName + " Search Time: " + (endTime - startTime) + " ns, Found: " + contains);

        startTime = System.nanoTime();
        set.remove(policies[1]);
        endTime = System.nanoTime();
        System.out.println(setName + " Remove Time: " + (endTime - startTime) + " ns");
    }
}