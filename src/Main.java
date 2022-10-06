import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        Basket basket = new Basket(new int[]{50, 14, 80, 100}, new String[]{"Молоко", "Хлеб", "Гречневая крупа", "Сыр"});

        File file = new File("basket.txt");

        if (file.exists()) {
            System.out.println("Восстанавливаем корзину из файла: ");
            Basket.loadFromTxtFile(file);
        } else {
            System.out.println("Файл с данными не найден, заполните корзину вручную.");
            System.out.println("Список возможных товаров для покупки:");
            for (int i = 0; i < basket.getProductName().length; i++) {
                System.out.println((i + 1) + ". " + basket.getProductName()[i] + " по цене " + basket.getPrices()[i] + " руб/шт.");
            }

            while (true) {
                System.out.println("Выберите товар и количество или введите end");
                String input = scanner.nextLine();
                if ("end".equals(input)) {
                    break;
                }
                String[] userChoice = input.split(" ");
                basket.addToCart(Integer.parseInt(userChoice[0]) - 1, Integer.parseInt(userChoice[1]));
            }
            basket.printCart();

            basket.saveTxt(file);
        }
    }
}





