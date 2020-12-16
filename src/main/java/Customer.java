public class Customer {

    Long azonosito;
    String nev;
    String lakcim;
    String telefonszam;
    String email;

    public Customer(Long azonosito, String nev, String lakcim, String telefonszam, String email) {
        this.azonosito = azonosito;
        this.nev = nev;
        this.lakcim = lakcim;
        this.telefonszam = telefonszam;
        this.email = email;
    }

    public Order vasarlas(Store raktar, ShoppingChart kosar, OrderOthers egyebInfok) {
        if (raktar == null) {
            throw new IllegalArgumentException("Érvénytelen bejövő paraméter (raktár).");
        }

        if (kosar == null) {
            throw new IllegalArgumentException("Érvénytelen bejövő paraméter (kosár).");
        }

        if (kosar.allapot == ShoppingChartState.IN_PROGRESS) {
            throw new IllegalArgumentException("A vásárláshoz a Kosár lezárása szükséges.");
        }

        OrderStatus rendelesStatus = OrderStatus.BOOKED;
        if (egyebInfok.vasarlasHelye == ShoppingPlace.SHOP) {
            rendelesStatus = OrderStatus.DELIVERIED;
        }

        return new Order(raktar, kosar, egyebInfok, rendelesStatus);
    }

}

