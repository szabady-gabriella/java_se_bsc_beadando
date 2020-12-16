import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class MainTest {

    Product termekRepa = new Product("001", "Répa");
    Product termekAlma = new Product("002", "Alma");

    Store raktar = new Store();

    @Test
    public void raktarLetezik () {
        assertNotNull(raktar);
    }

    @Test(expected = IllegalArgumentException.class)
    public void mennyisegNovelPar1 () {
        raktar.mennyisegNovel(null, 5);
    }

    int mennyiseg;
    @Test(expected = IllegalArgumentException.class)
        public void mennyisegNovelPar2 () {
          raktar.mennyisegNovel(termekAlma, mennyiseg);
    }

    @Test
    public void mennyisegNovelJo() {
        raktar.mennyisegNovel(termekRepa, 10);
    }

    @Test(expected = IllegalArgumentException.class)
    public void mennyisegCsokkentPar1 () {
        raktar.mennyisegCsokkent(null, 5);
    }

    @Test(expected = IllegalArgumentException.class)
    public void mennyisegCsokkentPar2 () {
        raktar.mennyisegCsokkent(termekAlma, mennyiseg);
    }

    @Test(expected = IllegalArgumentException.class)
    public void mennyisegCsokkentTermekhiany () {
        raktar.mennyisegCsokkent(termekRepa, 10);
    }

    @Test
    public void mennyisegCsokkentFo () {
        raktar.mennyisegNovel(termekRepa, 5);
        raktar.mennyisegCsokkent(termekRepa, 10);
    }

    @Test
    public void mennyisegCsokkentJo () {
        raktar.mennyisegNovel(termekRepa, 15);
        raktar.mennyisegCsokkent(termekRepa, 10);
        Integer r = raktar.termekLista.get(termekRepa);
        assertEquals(r,Integer.valueOf(5));

    }

    OrderOthers vasarlashozEgyebInfok = new OrderOthers(ShoppingPlace.SHOP, DeliveryMethod.SHIPPING, PaymentMethod.CREDITCARD);

    @Test
    public void vasarlashozEgyebInfokLetezik () {
        assertNotNull(vasarlashozEgyebInfok);
    }

    @Test(expected = IllegalArgumentException.class)
    public void egyebEllenorzesTesztf () {
        vasarlashozEgyebInfok.ellenorzes(ShoppingPlace.SHOP, DeliveryMethod.SHIPPING);
    }

    @Test(expected = IllegalArgumentException.class)
    public void egyebEllenorzesTeszts () {
        vasarlashozEgyebInfok.ellenorzes(ShoppingPlace.ONLINE, DeliveryMethod.PERSONAL);
    }

    ShoppingChart kosarGabi = new ShoppingChart();
    @Test
    public  void kosarLetezik () {
        assertNotNull(kosarGabi);
    }

    @Test(expected = IllegalArgumentException.class)
    public void kosarTartalomNovelTesztf (){
        kosarGabi.allapot = ShoppingChartState.CLOSED;
        kosarGabi.kosarTartalomNovel(termekAlma,1,raktar);
    }

    @Test(expected = IllegalArgumentException.class)
    public void kosarTartalomNovelTeszts (){
        kosarGabi.kosarTartalomCsokkent(termekAlma,100,raktar);
    }

    @Test
    public void kosarLezarasaTeszt () {
        kosarGabi.kosarLezarasa();
        assertThat(kosarGabi.getAllapot(), is(ShoppingChartState.CLOSED));
    }

    Customer vevoGabi = new Customer(1L, "SzGabi", "Bp, 1084, LDV utca 8.", "12/3456789", "s@gmail.com");
    @Test
    public  void vevoLetezikTeszt () {
        assertNotNull(vevoGabi);
    }

    @Test
    public void vasarlasTeszt () {
        raktar.mennyisegNovel(termekRepa,5);
        raktar.mennyisegNovel(termekAlma, 10);

        kosarGabi.kosarTartalomNovel(termekRepa, 1, raktar);
        kosarGabi.kosarTartalomNovel(termekAlma, 2, raktar);

        kosarGabi.kosarLezarasa();

        Order rendeles = vevoGabi.vasarlas(raktar, kosarGabi, vasarlashozEgyebInfok);
        assertNotNull(rendeles);

        rendeles.kiszallitas();
        assertThat(rendeles.getRendelesStatus(), is(OrderStatus.IN_PROGRESS));

        String megjegyzesSikeres = new String();
        String megjegyzesSikertelen = "Rossz cím.";
        rendeles.veglegesites(true, megjegyzesSikeres);
        assertThat(rendeles.getRendelesStatus(), is(OrderStatus.DELIVERIED));


        rendeles.veglegesites(false, megjegyzesSikertelen);
        assertThat(rendeles.getRendelesStatus(), is(OrderStatus.valueOf("FAILED_DELIVERIED")));
        assertThat(rendeles.getMegjegyzes(), is(megjegyzesSikertelen));

    }
}