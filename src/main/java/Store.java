import java.util.HashMap;
import java.util.Map;

public class Store extends ProductList {

    public Store() {
        super();
    }

    public void mennyisegNovel(Product termek, Integer mennyiseg) {
        if (mennyiseg < 1) {
            throw new IllegalArgumentException("Érvénytelen bejövő paraméter (mennyiség).");
        }

        if (super.termekLista.containsKey(termek)) {
            super.termekLista.put(termek, super.termekLista.get(termek) + mennyiseg);
        } else {
            super.termekLista.put(termek, mennyiseg);
        }
    }

    public void mennyisegCsokkent(Product termek, int mennyiseg) {
        if (mennyiseg < 1) {
            throw new IllegalArgumentException("Érvénytelen bejövő paraméter (mennyiség).");
        }

        super.termekLista.put(termek, super.termekLista.get(termek) + mennyiseg);
    }

}
