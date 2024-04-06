import java.util.List;

/*
 @author <Pham Thanh The - S3981133>
*/

public interface DAO<T> {
    public void add(T t);
    public void update(T t);
    public void delete(T t);
    T getOne(String ID);
    public List<T> getAll();
}
