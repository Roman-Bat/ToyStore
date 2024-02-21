import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Класс, отвечающий за проведение розыгрыша и выбор случайных игрушек на основе их частоты выпадения.
 */
public class ToyDraw {
    private Random random;  // Генератор случайных чисел

    /**
     * Конструктор класса ToyDraw.
     */
    public ToyDraw() {
        this.random = new Random();
    }

    /**
     * Провести розыгрыш и выбрать случайные игрушки на основе их частоты выпадения.
     *
     * @param toys       Список игрушек, из которого производится выбор
     * @param numDraws   Количество игрушек для розыгрыша
     * @return Список выбранных игрушек
     */
    public List<Toy> drawToys(List<Toy> toys, int numDraws) {
        List<Toy> drawResults = new ArrayList<>();
        double totalWeight = toys.stream().mapToDouble(Toy::getWeight).sum();

        for (int i = 0; i < numDraws; i++) {
            double randomWeight = random.nextDouble() * totalWeight;
            double currentWeight = 0;

            for (Toy toy : toys) {
                currentWeight += toy.getWeight();
                if (randomWeight <= currentWeight) {
                    drawResults.add(toy);
                    break;
                }
            }
        }
        return drawResults;
    }
}
