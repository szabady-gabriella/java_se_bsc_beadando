import java.util.HashMap;
import java.util.Map;

public class ProductList {
    Map<Product, Integer> termekLista;

    public ProductList() {
        this.termekLista = new HashMap<Product, Integer>();
    }



    public Map<Product, Integer> getTermekLista() {
        return termekLista;
    }

    public void setTermekLista(Map<Product, Integer> termekLista) {
        this.termekLista = termekLista;
    }
}
