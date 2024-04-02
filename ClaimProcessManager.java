import java.util.List;

public interface ClaimProcessManager {
    public boolean addClaim(Claim claim);
    public boolean updateClaim(String claimID);
    public void deleteClaim(String claimID);
    public Claim getOneClaim(String claimID);
    public List<Claim> getAllClaims();
}
