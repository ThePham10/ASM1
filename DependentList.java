import java.util.List;

public interface DependentList {
    public boolean addDependent(Customer dependent);

    public void deleteDependent(String customerID);

    public Customer getOneDependent(String dependentID);

    public List<Customer> getAllDependents();
}
