import org.junit.Assert;
import org.junit.Test;

public class StoreTest {

    Product termekRepa = new Product("001", "Répa");
    Store raktar = new Store();

    @Test
    public void mennyisegNovelTest () {
        Assert.assertNull(raktar);

    }
}
