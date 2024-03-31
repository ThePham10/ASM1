import java.util.HashSet;
import java.util.Set;

public class ClaimSet implements ClaimProcessManager{
    private Set<Claim> claimList;


    public ClaimSet() {
        // An empty set at the beginning
        claimList = new HashSet<Claim>();
    }

    @Override
    public boolean add(Claim claim) {
        return claimList.add(claim);
    }

    @Override
    public boolean update(String claimID) {
        return false;
    }

    @Override
    public void delete(String claimID) {
        Claim claim = getOne(claimID);
        if (claim != null) {
            claimList.remove(claim);
        }
    }

    @Override
    public Claim getOne(String claimID) {
        for (Claim claim:claimList) {
            if (claim.getClaimID().equals(claimID)) {
                return claim;
            }
        }
        return null;
    }

    @Override
    public Set<Claim> getAll() {
        return claimList;
    }
}
