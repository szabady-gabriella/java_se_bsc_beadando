import java.util.Map;

public class Order {
    Store raktar;
    //Customer vevo;
    ShoppingCart rendeles;
    OrderOthers rendeleshezEgyebek;
    OrderStatus rendelesStatus;
    String megjegyzes;

    public Order(Store raktar, ShoppingCart rendeles, OrderOthers rendeleshezEgyebek, OrderStatus rendelesStatus) {
        this.raktar = raktar;
        this.rendeles = rendeles;
        this.rendeleshezEgyebek = rendeleshezEgyebek;
        this.rendelesStatus = rendelesStatus;
    }

    public OrderStatus getRendelesStatus() {
        return rendelesStatus;
    }

    public void setRendelesStatus(OrderStatus rendelesStatus) {
        this.rendelesStatus = rendelesStatus;
    }

    public String getMegjegyzes() {
        return megjegyzes;
    }

    public void setMegjegyzes(String megjegyzes) {
        this.megjegyzes = megjegyzes;
    }

    public void kiszallitas() {
        this.setRendelesStatus(OrderStatus.IN_PROGRESS);
    }

    public void veglegesites(boolean sikeresKiszallitas, String megjegyzes) {
        if (sikeresKiszallitas) {
            this.setRendelesStatus(OrderStatus.DELIVERIED);
        } else {
            this.setRendelesStatus(OrderStatus.FAILED_DELIVERIED);
            this.setMegjegyzes(megjegyzes);
        }
    }
}
