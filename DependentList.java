import java.util.List;

public interface DependentList {
    public boolean addDependent(Dependent dependent);
    public void deleteDependent(String dependentID);
    public Dependent getOneDependent(String dependentID);
    public List<Dependent> getAllDependents();
}
