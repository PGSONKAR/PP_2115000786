import java.util.*;

public class VotingSystem {
    private Map<String, Integer> voteCount;
    private Map<String, Integer> voteOrder;
    
    public VotingSystem() {
        this.voteCount = new HashMap<>();
        this.voteOrder = new LinkedHashMap<>();
    }

    public void castVote(String candidate) {
        voteCount.put(candidate, voteCount.getOrDefault(candidate, 0) + 1);
        voteOrder.put(candidate, voteOrder.getOrDefault(candidate, 0) + 1);
    }

    public void displayResultsSorted() {
        TreeMap<String, Integer> sortedResults = new TreeMap<>(voteCount);
        System.out.println("Results (Sorted by Candidate Name): " + sortedResults);
    }

    public void displayResultsInVoteOrder() {
        System.out.println("Results (In Vote Order): " + voteOrder);
    }

    public static void main(String[] args) {
        VotingSystem votingSystem = new VotingSystem();
        votingSystem.castVote("Alice");
        votingSystem.castVote("Bob");
        votingSystem.castVote("Alice");
        votingSystem.castVote("Charlie");
        votingSystem.castVote("Bob");

        votingSystem.displayResultsSorted();
        votingSystem.displayResultsInVoteOrder();
    }
}