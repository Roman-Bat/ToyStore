import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Класс, описывающий магазин игрушек.
 */
public class ToyShop {
    private PriorityQueue<Toy> toysQueue;    // Очередь игрушек в магазине

    /**
     * Конструктор класса ToyShop.
     */
    public ToyShop() {
        this.toysQueue = new PriorityQueue<>();
    }

    /**
     * Добавить новую игрушку в магазин.
     *
     * @param toy Новая игрушка
     */
    public void addToy(Toy toy) {
        toysQueue.add(toy);
    }

    /**
     * Удалить игрушку из магазина по ее ID.
     *
     * @param toyId ID игрушки, которую необходимо удалить
     */
    public void removeToy(int toyId) {
        toysQueue.removeIf(toy -> toy.getId() == toyId);
    }

    /**
     * Обновить информацию об игрушке в магазине.
     *
     * @param toyId      ID игрушки, которую необходимо обновить
     * @param updatedToy Обновленная информация об игрушке
     */
    public void updateToy(int toyId, Toy updatedToy) {
        removeToy(toyId);
        addToy(updatedToy);
    }

    /**
     * Провести розыгрыш и вывести список выпавших игрушек в консоль.
     *
     * @param numDraws Количество игрушек для розыгрыша
     */
    /**
     * Провести розыгрыш и вывести список выпавших игрушек в консоль.
     *
     * @param numDraws Количество игрушек для розыгрыша
     */
    public void drawToys(int numDraws) {
        List<Toy> drawResults = new ArrayList<>();
        System.out.println("Результаты розыгрыша:");
        for (int i = 0; i < numDraws; i++) {
            Toy drawnToy = toysQueue.poll();
            if (drawnToy != null) {
                System.out.printf("Выпала игрушка: ID=%d, Название=%s, Вес=%.2f%n", drawnToy.getId(), drawnToy.getName(), drawnToy.getWeight());
                drawResults.add(drawnToy);
            }
        }
        writeDrawResultsToFile(drawResults, "результаты_розыгрыша.txt");
    }

    /**
     * Записать результаты розыгрыша в файл.
     *
     * @param drawResults Результаты розыгрыша
     * @param filename    Имя файла для записи результатов
     */
    public void writeDrawResultsToFile(List<Toy> drawResults, String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true))) {
            // Записываем заголовок с текущей датой и временем
            LocalDateTime currentTime = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            writer.write(String.format("Результаты розыгрыша (%s):\n", currentTime.format(formatter)));

            // Записываем данные о каждой игрушке в файл
            for (Toy toy : drawResults) {
                writer.write(String.format("ID: %d, Название: %s, Вес: %.2f%n", toy.getId(), toy.getName(), toy.getWeight()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Получить очередь игрушек в магазине.
     *
     * @return Очередь игрушек в магазине
     */
    public PriorityQueue<Toy> getToysQueue() {
        return toysQueue;
    }
}
