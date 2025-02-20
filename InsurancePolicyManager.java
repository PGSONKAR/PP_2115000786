import java.util.*;
class InsurancePolicy implements Comparable<InsurancePolicy> {
    private String policyNumber;
    private String policyholderName;
    private Date expiryDate;
    private String coverageType;
    private double premiumAmount;

    public InsurancePolicy(String policyNumber, String policyholderName, Date expiryDate, String coverageType, double premiumAmount) {
        this.policyNumber = policyNumber;
        this.policyholderName = policyholderName;
        this.expiryDate = expiryDate;
        this.coverageType = coverageType;
        this.premiumAmount = premiumAmount;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        InsurancePolicy that = (InsurancePolicy) obj;
        return policyNumber.equals(that.policyNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(policyNumber);
    }

    @Override
    public int compareTo(InsurancePolicy other) {
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
public class InsurancePolicyManager {
    private Set<InsurancePolicy> hashSetPolicies = new HashSet<>();
    private Set<InsurancePolicy> linkedHashSetPolicies = new LinkedHashSet<>();
    private Set<InsurancePolicy> treeSetPolicies = new TreeSet<>();

    public void addPolicy(InsurancePolicy policy) {
        hashSetPolicies.add(policy);
        linkedHashSetPolicies.add(policy);
        treeSetPolicies.add(policy);
    }

    public void displayPolicies(Set<InsurancePolicy> policies) {
        for (InsurancePolicy policy : policies) {
            System.out.println(policy);
        }
    }

    public static void main(String[] args) {
        InsurancePolicyManager manager = new InsurancePolicyManager();

        manager.addPolicy(new InsurancePolicy("P001", "John Doe", new Date(2025 - 1900, 5, 15), "Health", 1200.50));
        manager.addPolicy(new InsurancePolicy("P002", "Jane Smith", new Date(2025 - 1900, 3, 10), "Auto", 900.75));
        manager.addPolicy(new InsurancePolicy("P003", "Alice Brown", new Date(2025 - 1900, 1, 25), "Home", 1500.00));

        System.out.println("HashSet Policies (Unordered):");
        manager.displayPolicies(manager.hashSetPolicies);

        System.out.println("\nLinkedHashSet Policies (Insertion Order):");
        manager.displayPolicies(manager.linkedHashSetPolicies);

        System.out.println("\nTreeSet Policies (Sorted by Expiry Date):");
        manager.displayPolicies(manager.treeSetPolicies);
    }
}