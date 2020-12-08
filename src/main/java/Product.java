public class Product {
    String cikkszam;
    String megnevezes;

    public Product(String cikkszam, String megnevezes) {
        this.cikkszam = cikkszam;
        this.megnevezes = megnevezes;
    }

    public String getCikkszam() {
        return cikkszam;
    }

    public String getMegnevezes() {
        return megnevezes;
    }
}
