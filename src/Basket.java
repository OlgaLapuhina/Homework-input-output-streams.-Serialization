import java.io.*;

public class Basket implements Serializable {
    protected int[] prices;
    protected String[] productName;
    protected int[] crate;
    protected int sumProducts = 0;

    protected Basket(int[] prices, String[] productName) {
        this.prices = prices;
        this.productName = productName;
        crate = new int[productName.length];
    }

    protected void addToCart(int productNumber, int productCount) {
        crate[productNumber] += productCount;
    }

    public int[] getPrices() {
        return prices;
    }

    public String[] getProductName() {
        return productName;
    }

    protected void printCart() {
        System.out.println("Ваша корзина: ");
        for (int i = 0; i < productName.length; i++) {
            if (crate[i] > 0) {
                System.out.println(productName[i] + " " + crate[i] + " шт. " + prices[i] + " руб/шт в сумме "
                        + (crate[i] * prices[i]) + " руб.");
                sumProducts += (crate[i] * prices[i]);
            }
        }
        System.out.println("Общая стоимость всех покупок: " + sumProducts + " руб.");
    }

    public void saveBin(File file) throws IOException {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file))) {
            out.writeObject(this);
        }
    }

    public static Basket loadFromBinFile(File file) throws IOException, ClassNotFoundException {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))) {
            Basket basket = (Basket) in.readObject();
            return basket;
        }
    }
}