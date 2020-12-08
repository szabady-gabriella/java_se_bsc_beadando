import java.util.Map;

public class ShoppingCart extends ProductList {

    ShoppingChartState allapot;

    public ShoppingCart() {
        super();
        allapot = ShoppingChartState.IN_PROGRESS;
    }

    @Override
    public Map<Product, Integer> getTermekLista() {
        return super.getTermekLista();
    }

    @Override
    public void setTermekLista(Map<Product, Integer> termekLista) {
        super.setTermekLista(termekLista);
    }

    public ShoppingChartState getAllapot() {
        return allapot;
    }

    public void setAllapot(ShoppingChartState allapot) {
        this.allapot = allapot;
    }

    public void kosarTartalomNovel(Product termek, int mennyiseg, Store raktar) {
        if (this.allapot == ShoppingChartState.CLOSED) {
            throw new IllegalArgumentException("A kosár már korábban lezárásra került.");
        }

        if (termek == null) {
            throw new IllegalArgumentException("Érvénytelen bejövő paraméter (termék).");
        }

        if (mennyiseg < 1) {
            throw new IllegalArgumentException("Érvénytelen bejövő paraméter (mennyiség).");
        }

        if (raktar == null) {
            throw new IllegalArgumentException("Érvénytelen bejövő paraméter (raktár).");
        }

        if (raktar.termekLista.get(termek) < mennyiseg) {
            throw new IllegalArgumentException("A megadott termékből a raktárkészlet kisebb, mint a megadott mennyiség.");
        }

        if (super.termekLista.containsKey(termek)) {
            super.termekLista.put(termek, super.termekLista.get(termek) + mennyiseg);
        } else {
            super.termekLista.put(termek, mennyiseg);
        }
    }

    public void kosarTartalomCsokkent(Product termek, int mennyiseg, Store raktar) {
        if (this.allapot == ShoppingChartState.CLOSED) {
            throw new IllegalArgumentException("A kosár már korábban lezárásra került.");
        }

        if (termek == null || !super.termekLista.containsKey(termek)) {
            throw new IllegalArgumentException("Érvénytelen bejövő paraméter (termék).");
        }

        if (mennyiseg < 1) {
            throw new IllegalArgumentException("Érvénytelen bejövő paraméter (mennyiség).");
        }

        if (raktar == null) {
            throw new IllegalArgumentException("Érvénytelen bejövő paraméter (raktár).");
        }

        super.termekLista.put(termek, super.termekLista.get(termek) + mennyiseg);
    }

    public void kosarLezarasa() {
        this.allapot = ShoppingChartState.CLOSED;
    }
}


