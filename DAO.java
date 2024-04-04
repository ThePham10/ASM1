import java.util.List;

public interface DAO<T> {
    public void add(T t);
    public void update(T t);
    public void delete(T t);
    T getOne(String ID);
    public List<T> getAll();
}
