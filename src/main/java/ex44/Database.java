package ex44;

import java.util.ArrayList;
import java.util.List;

public class Database<T> {
    private List<T> dbObjects;

    public Database(List<T> dbObjects) {
        this.dbObjects = dbObjects;
    }

    public Database() {
        this.dbObjects = new ArrayList<>();
    }

    public List<T> getProducts() {
        return dbObjects;
    }

    public void setProducts(List<T> dbObjects) {
        this.dbObjects = dbObjects;
    }
}
