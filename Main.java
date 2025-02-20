import java.time.LocalDate;
import java.util.*;

class Policy {
    private String policyNumber;
    private String policyholderName;
    private LocalDate expiryDate;
    private String coverageType;
    private double premiumAmount;

    public Policy(String policyNumber, String policyholderName, LocalDate expiryDate, String coverageType, double premiumAmount) {
        this.policyNumber = policyNumber;
        this.policyholderName = policyholderName;
        this.expiryDate = expiryDate;
        this.coverageType = coverageType;
        this.premiumAmount = premiumAmount;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public String getPolicyholderName() {
        return policyholderName;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public String getCoverageType() {
        return coverageType;
    }

    public double getPremiumAmount() {
        return premiumAmount;
    }

    @Override
    public String toString() {
        return "Policy{" +
                "policyNumber='" + policyNumber + '\'' +
                ", policyholderName='" + policyholderName + '\'' +
                ", expiryDate=" + expiryDate +
                ", coverageType='" + coverageType + '\'' +
                ", premiumAmount=" + premiumAmount +
                '}';
    }
}

class PolicyManager {
    private List<Policy> policies;

    public PolicyManager() {
        policies = new ArrayList<>();
    }

    public void addPolicy(Policy policy) {
        policies.add(policy);
    }

    public List<Policy> getAllPolicies() {
        return policies;
    }

    public List<Policy> getPoliciesExpiringSoon() {
        LocalDate today = LocalDate.now();
        LocalDate thirtyDaysLater = today.plusDays(30);
        List<Policy> expiringSoon = new ArrayList<>();
        for (Policy policy : policies) {
            if (policy.getExpiryDate().isAfter(today) && policy.getExpiryDate().isBefore(thirtyDaysLater)) {
                expiringSoon.add(policy);
            }
        }
        return expiringSoon;
    }

    public List<Policy> getPoliciesByCoverageType(String coverageType) {
        List<Policy> filteredPolicies = new ArrayList<>();
        for (Policy policy : policies) {
            if (policy.getCoverageType().equalsIgnoreCase(coverageType)) {
                filteredPolicies.add(policy);
            }
        }
        return filteredPolicies;
    }

    public List<Policy> getDuplicatePolicies() {
        Map<String, Policy> policyMap = new HashMap<>();
        List<Policy> duplicates = new ArrayList<>();
        for (Policy policy : policies) {
            if (policyMap.containsKey(policy.getPolicyNumber())) {
                duplicates.add(policy);
            } else {
                policyMap.put(policy.getPolicyNumber(), policy);
            }
        }
        return duplicates;
    }
}

public class Main {
    public static void main(String[] args) {
        PolicyManager manager = new PolicyManager();
        manager.addPolicy(new Policy("P1", "John Doe", LocalDate.of(2023, 12, 31), "Health", 500.0));
        manager.addPolicy(new Policy("P2", "Jane Doe", LocalDate.of(2023, 11, 15), "Auto", 300.0));
        manager.addPolicy(new Policy("P3", "John Smith", LocalDate.of(2024, 1, 1), "Home", 200.0));
        manager.addPolicy(new Policy("P1", "John Doe", LocalDate.of(2023, 12, 31), "Health", 500.0));

        System.out.println("All Policies:");
        manager.getAllPolicies().forEach(System.out::println);

        System.out.println("\nPolicies Expiring Soon:");
        manager.getPoliciesExpiringSoon().forEach(System.out::println);

        System.out.println("\nHealth Policies:");
        manager.getPoliciesByCoverageType("Health").forEach(System.out::println);

        System.out.println("\nDuplicate Policies:");
        manager.getDuplicatePolicies().forEach(System.out::println);
    }
}
