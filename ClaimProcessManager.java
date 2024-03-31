import java.util.Set;

public interface ClaimProcessManager {
    public boolean add(Claim claim);

    public boolean update(String claimID);

    public void delete(String claimID);

    public Claim getOne(String claimID);

    public Set<Claim> getAll();
}
