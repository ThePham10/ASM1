import java.util.List;

/*
 @author <Pham Thanh The - S3981133>
*/

public interface ClaimDAO extends DAO<Claim> {
    @Override
    void add(Claim claim);
    @Override
    void update(Claim claim);
    @Override
    void delete(Claim claim);
    @Override
    Claim getOne(String claimID);
    @Override
    List<Claim> getAll();
}
