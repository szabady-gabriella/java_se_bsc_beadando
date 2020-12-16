import java.util.HashMap;
import java.util.Map;

public class Store extends ProductList {

    public Store() {
        super();
    }

    public void mennyisegNovel(Product termek, Integer mennyiseg) {
        if (termek == null) {
            throw new IllegalArgumentException("Érvénytelen bejövő paraméter (termék).");
        }
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
        if (termek == null) {
            throw new IllegalArgumentException("Érvénytelen bejövő paraméter (termék).");
        }
        if (mennyiseg < 1) {
            throw new IllegalArgumentException("Érvénytelen bejövő paraméter (mennyiség).");
        }
        if (!super.termekLista.containsKey(termek)) {
            throw new IllegalArgumentException("Ez a termék nincs a raktárban, mennyisége nem csökkenthető.");
        }
        if (super.termekLista.get(termek) < mennyiseg) {
            super.termekLista.put(termek, 0);
        } else {
            super.termekLista.put(termek, super.termekLista.get(termek) - mennyiseg);
        }
    }

}
