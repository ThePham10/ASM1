import java.util.List;

/*
 @author <Pham Thanh The - S3981133>
*/

public interface DependentList {
    public void addDependent(Dependent dependent);
    public void deleteDependent(Dependent dependent);
    public Dependent getOneDependent(String dependentID);
    public List<Dependent> getAllDependents();
}
