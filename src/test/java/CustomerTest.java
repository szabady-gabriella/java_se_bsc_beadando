import org.junit.Test;

import static org.junit.Assert.*;

public class CustomerTest {
    @Test
    public void vasarlasTeszt(){
        Customer vevo = new Customer(1L, "f", "d", "w", "e");
        Store raktar = new Store();

        //assertEquals(vevo.email, "e");
        assertNull(raktar);




    }
}