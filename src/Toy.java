import java.util.Objects;

/**
 * Класс, представляющий игрушку.
 */
public class Toy implements Comparable<Toy> {
    private int id;             // ID игрушки
    private String name;        // Название игрушки
    private double weight;      // Вес игрушки для определения частоты выпадения

    /**
     * Конструктор класса Toy.
     *
     * @param id     ID игрушки
     * @param name   Название игрушки
     * @param weight Вес игрушки для определения частоты выпадения
     */
    public Toy(int id, String name, double weight) {
        this.id = id;
        this.name = name;
        this.weight = weight;
    }

    /**
     * Получить ID игрушки.
     *
     * @return ID игрушки
     */
    public int getId() {
        return id;
    }

    /**
     * Получить название игрушки.
     *
     * @return Название игрушки
     */
    public String getName() {
        return name;
    }

    /**
     * Получить вес игрушки.
     *
     * @return Вес игрушки
     */
    public double getWeight() {
        return weight;
    }

    /**
     * Сравнение игрушек на основе их веса.
     *
     * @param other Игрушка, с которой производится сравнение
     * @return Отрицательное число, если текущая игрушка имеет меньший вес,
     *         положительное число, если текущая игрушка имеет больший вес,
     *         ноль, если веса игрушек равны
     */
    @Override
    public int compareTo(Toy other) {
        return Double.compare(this.weight, other.weight);
    }

    /**
     * Переопределение метода toString для вывода информации об игрушке.
     *
     * @return Строка с информацией об игрушке
     */
    @Override
    public String toString() {
        return "Toy{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", weight=" + weight +
                '}';
    }

    /**
     * Переопределение метода equals для сравнения игрушек по их ID.
     *
     * @param o Объект, с которым производится сравнение
     * @return true, если объекты равны по ID, false в противном случае
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Toy toy = (Toy) o;
        return id == toy.id;
    }

    /**
     * Переопределение метода hashCode для корректного хэширования игрушек.
     *
     * @return Хэш-код объекта
     */
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
