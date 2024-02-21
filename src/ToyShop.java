import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
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
     * Провести розыгрыш и вернуть список выпавших игрушек.
     *
     * @param numDraws Количество игрушек для розыгрыша
     * @return Список игрушек, выпавших в результате розыгрыша
     */
    public List<Toy> drawToys(int numDraws) {
        List<Toy> drawResults = new ArrayList<>();
        for (int i = 0; i < numDraws; i++) {
            Toy drawnToy = toysQueue.poll();
            if (drawnToy != null) {
                drawResults.add(drawnToy);
            }
        }
        return drawResults;
    }

    /**
     * Записать результаты розыгрыша в файл.
     *
     * @param drawResults Результаты розыгрыша
     * @param filename    Имя файла для записи результатов
     */
    public void writeDrawResultsToFile(List<Toy> drawResults, String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Toy toy : drawResults) {
                writer.write(toy.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
