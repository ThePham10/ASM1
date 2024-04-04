import java.util.List;

public interface DependentList {
    public void addDependent(Dependent dependent);
    public void deleteDependent(Dependent dependent);
    public Dependent getOneDependent(String dependentID);
    public List<Dependent> getAllDependents();
}
