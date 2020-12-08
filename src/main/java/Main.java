public class Main {

    public static void main(String[] args) {

        Product termekRepa = new Product("001", "Répa");
        Product termekAlma = new Product("002", "Alma");

        Store raktar = new Store();
        raktar.mennyisegNovel(termekRepa, 5);
        raktar.mennyisegNovel(termekAlma, 10);

        ShoppingPlace vasarlasHelye = ShoppingPlace.SHOP;
        DeliveryMethod szallitasModja = DeliveryMethod.SHIPPING;
        PaymentMethod fizetesModja = PaymentMethod.CREDITCARD;

        OrderOthers vasarlashozEgyebInfok = new OrderOthers(vasarlasHelye, szallitasModja, fizetesModja);
        vasarlashozEgyebInfok.ellenorzes(vasarlasHelye, szallitasModja);

        ShoppingCart kosarGabi = new ShoppingCart();
        kosarGabi.kosarTartalomNovel(termekRepa, 1, raktar);
        kosarGabi.kosarTartalomNovel(termekAlma, 2, raktar);

        kosarGabi.kosarLezarasa();

        Customer vevoGabi = new Customer(1L, "SzGabi", "Bp, 1084, LDV utca 8.", "12/3456789", "s@gmail.com");

        Order rendeles = vevoGabi.vasarlas(raktar, kosarGabi, vasarlashozEgyebInfok);



        if (szallitasModja== DeliveryMethod.SHIPPING) {
            rendeles.kiszallitas();
            boolean sikeres = true;
            if (sikeres) {
                rendeles.veglegesites(sikeres, "");
            } else rendeles.veglegesites(sikeres, "Rossz cím.");
        }
    }
}
