public class OrderOthers {
    ShoppingPlace vasarlasHelye;
    DeliveryMethod szallitasMod;
    PaymentMethod fizetesiMod;
    OrderStatus rendelesAllapot;
    String megjegyzes;

    public OrderOthers(ShoppingPlace vasarlasHelye, DeliveryMethod szallitasMod, PaymentMethod fizetesiMod) {
        this.vasarlasHelye = vasarlasHelye;
        this.szallitasMod = szallitasMod;
        this.fizetesiMod = fizetesiMod;
    }

    public OrderStatus getRendelesAllapot() {
        return rendelesAllapot;
    }

    public void setRendelesAllapot(OrderStatus rendelesAllapot) {
        this.rendelesAllapot = rendelesAllapot;
    }

    public String getMegjegyzes() {
        return megjegyzes;
    }

    public void setMegjegyzes(String megjegyzes) {
        this.megjegyzes = megjegyzes;
    }

    public void ellenorzes(ShoppingPlace vasarlasHelye, DeliveryMethod szallitasMod) {

        System.out.println( "vasarlasHelye=" + vasarlasHelye + " szallitasMod=" + szallitasMod);

        if (vasarlasHelye == ShoppingPlace.SHOP && szallitasMod != DeliveryMethod.PERSONAL) {
            throw new IllegalArgumentException("Üzletben történő vásárlás esetén nem lehet kiszállítást választani.");
        }

        if (vasarlasHelye == ShoppingPlace.ONLINE && szallitasMod != DeliveryMethod.SHIPPING) {
            throw new IllegalArgumentException("Online vásárlás esetén a kézbesítési mód csak kiszállítás lehet.");
        }
    }
}
