import java.io.*;

public class Basket {
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

    protected void saveTxt(File textFile) throws IOException {//метод сохранения корзины в текстовый файл
        try (PrintWriter out = new PrintWriter(textFile)) {
            for (long c : crate) {
                out.print(c + " ");
            }
            out.print("\n");
            for (long p : prices) {
                out.print(p + " ");
            }
            out.print("\n");
            for (String prod : productName) {
                out.print(prod + " ");
            }
        }
        System.out.println("Данные корзины сохранены в файле - basket.txt");
    }

    protected static Basket loadFromTxtFile(File file) throws IOException {//статич метод восстановления объекта из корзины
        try (BufferedReader buf = new BufferedReader(new FileReader(file))) {

            String[] reader1 = buf.readLine().split(" ");
            int[] crates = new int[reader1.length];
            for (int i = 0; i < reader1.length; i++) {
                crates[i] = Integer.parseInt(reader1[i]);
            }

            String[] reader2 = buf.readLine().split(" ");
            int[] prices = new int[reader2.length];
            for (int i = 0; i < reader2.length; i++) {
                prices[i] = Integer.parseInt(reader2[i]);
            }

            String[] product = buf.readLine().split(" ");

            Basket basket1 = new Basket(prices, product);
            for (int i = 0; i < crates.length; i++) {
                basket1.addToCart(i, crates[i]);
            }
            basket1.printCart();
            basket1.saveTxt(file);

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}