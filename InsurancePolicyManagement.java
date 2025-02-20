import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;

class Policy implements Comparable<Policy> {
    String policyNumber;
    String policyholderName;
    LocalDate expiryDate;
    String coverageType;
    double premiumAmount;

    public Policy(String policyNumber, String policyholderName, String expiryDate, 
                  String coverageType, double premiumAmount) {
        this.policyNumber = policyNumber;
        this.policyholderName = policyholderName;
        this.expiryDate = LocalDate.parse(expiryDate, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        this.coverageType = coverageType;
        this.premiumAmount = premiumAmount;
    }

    @Override
    public int compareTo(Policy other) {
        return this.expiryDate.compareTo(other.expiryDate);
    }

    @Override
    public String toString() {
        return "Policy{" +
                "Number='" + policyNumber + '\'' +
                ", Holder='" + policyholderName + '\'' +
                ", Expiry=" + expiryDate +
                ", Type='" + coverageType + '\'' +
                ", Premium=" + premiumAmount +
                '}';
    }
}

public class InsurancePolicyManagement {
    private Map<String, Policy> hashMapPolicies = new HashMap<>();
    private Map<String, Policy> linkedHashMapPolicies = new LinkedHashMap<>();
    private TreeMap<LocalDate, Policy> treeMapPolicies = new TreeMap<>();

    public void addPolicy(Policy policy) {
        hashMapPolicies.put(policy.policyNumber, policy);
        linkedHashMapPolicies.put(policy.policyNumber, policy);
        treeMapPolicies.put(policy.expiryDate, policy);
    }

    public Policy getPolicyByNumber(String policyNumber) {
        return hashMapPolicies.get(policyNumber);
    }

    public List<Policy> getPoliciesExpiringSoon(int days) {
        LocalDate now = LocalDate.now();
        LocalDate limit = now.plusDays(days);
        return new ArrayList<>(treeMapPolicies.subMap(now, limit).values());
    }

    public List<Policy> getPoliciesByHolder(String policyholderName) {
        List<Policy> policies = new ArrayList<>();
        for (Policy policy : hashMapPolicies.values()) {
            if (policy.policyholderName.equalsIgnoreCase(policyholderName)) {
                policies.add(policy);
            }
        }
        return policies;
    }

    public void removeExpiredPolicies() {
        LocalDate now = LocalDate.now();
        treeMapPolicies.headMap(now, true).clear();
        hashMapPolicies.values().removeIf(policy -> policy.expiryDate.isBefore(now));
        linkedHashMapPolicies.values().removeIf(policy -> policy.expiryDate.isBefore(now));
    }

    public static void main(String[] args) {
        InsurancePolicyManagement system = new InsurancePolicyManagement();
        system.addPolicy(new Policy("P1001", "Alice", "2025-03-15", "Health", 5000.0));
        system.addPolicy(new Policy("P1002", "Bob", "2024-03-10", "Auto", 3200.0));
        system.addPolicy(new Policy("P1003", "Alice", "2024-04-01", "Home", 7500.0));

        System.out.println("Policy by Number (P1001): " + system.getPolicyByNumber("P1001"));
        System.out.println("Policies expiring in next 30 days: " + system.getPoliciesExpiringSoon(30));
        System.out.println("Policies for Alice: " + system.getPoliciesByHolder("Alice"));
        system.removeExpiredPolicies();
        System.out.println("After removing expired policies: " + system.hashMapPolicies);
    }
}
