import java.util.ArrayList;
import java.util.List;

/**
 * Основной класс приложения для демонстрации его работы.
 */
public class Main {
    public static void main(String[] args) {
        // Создание магазина игрушек
        ToyShop toyShop = new ToyShop();

        // Добавление игрушек в магазин
        toyShop.addToy(new Toy(1, "Кукла", 0.3));
        toyShop.addToy(new Toy(2, "Машинка", 0.2));
        toyShop.addToy(new Toy(3, "Мяч", 0.5));
        toyShop.addToy(new Toy(4, "Пазлы", 0.4));
        toyShop.addToy(new Toy(5, "Набор для творчества", 0.6));
        toyShop.addToy(new Toy(6, "Конструктор", 0.7));
        toyShop.addToy(new Toy(7, "Мягкие игрушки", 0.8));
        toyShop.addToy(new Toy(8, "Музыкальные инструменты", 0.3));
        toyShop.addToy(new Toy(9, "Спортивные игры", 0.4));
        toyShop.addToy(new Toy(10, "Интерактивные игрушки", 0.6));

        // Проведение розыгрыша
        ToyDraw toyDraw = new ToyDraw();
        List<Toy> drawResults = toyDraw.drawToys(new ArrayList<>(toyShop.getToysQueue()), 10);

        // Вывод результатов розыгрыша
        System.out.println("Результаты розыгрыша:");
        for (Toy toy : drawResults) {
            System.out.println(toy);
        }

        // Запись результатов розыгрыша в файл
        toyShop.writeDrawResultsToFile(drawResults, "результаты_розыгрыша.txt");
    }
}
