import java.util.Random;

/**
 * Конкурс по съеданию пиццы
 * У нас проводится конкурс по съеданию пиццы с участием группы из 5 до 8 человек.
 * Каждый участник принимает участие в конкурсе и съедает случайное количество кусков пиццы, которое может быть от 0 до 6.
 * Нам нужно провести анализ результатов конкурса и определить следующее:
 * <p>
 * Количество съеденных кусков: Необходимо определить, сколько кусков пиццы съел каждый участник.
 * <p>
 * Победитель: Определить, кто из участников съел наибольшее количество кусков пиццы и стал победителем конкурса.
 * <p>
 * Второе и третье место: Определить участников, занявших второе и третье место в конкурсе.
 * <p>
 * Использованные пиццы: Рассчитать общее количество пицц, которые были использованы для конкурса, учитывая,
 * что каждая пицца была разрезана на 8 кусков.
 * <p>
 * Не съеденные куски: Определить, сколько кусков пиццы осталось несъеденными после завершения конкурса.
 * <p>
 * Награды: Вручить награды победителям с первого по третье место в соответствии с призами:
 * первому месту - золотую медаль и сертификат на бесплатную пиццу,
 * второму месту - серебряную медаль и сертификат на скидку 50% на следующую пиццу,
 * третьему месту - бронзовую медаль и сертификат на скидку 25% на следующую пиццу.
 */

public class Main {
    public static void main(String[] args) {
        // 1. нужны участники (Person) - определить его поля
        // 2. определить от 5 до 8 участников (Person) конкурса - рандомно
        //        int persons = ....
        // 3. создать массив с количесвом участников из 2 пункта
        //    Person[] peoples = new Person[persons];
        // 4. заполнить массив участниками.
        //      4.1 перебираем массив, и в каждую ячейку устанвливаем Person
        // 5. определить для каждого участника количесвто съеденых пиц
        //      5.1 при необходимости нужно добавить в класс Person поле которе хранит сколько пиц съел участник
        //      5.2 создать setter для этого поля.
        //      5.3 установить каждому участнику (перебрав массив участников) рандомное значение количества съеденых пиц(0-6)
        // 6. написать метод, который распечатает количесвто съеденых кусков пицы участником
        // 7. ...
        Person[] peoples = new Person[8]; // желающие учавствовать в конкурсе
        peoples[0] = new Person(1, "Name1");
        peoples[1] = new Person(2, "Name2");
        peoples[2] = new Person(3, "Name3");
        peoples[3] = new Person(4, "Name4");
        peoples[4] = new Person(5, "Name5");
        peoples[5] = new Person(6, "Name6");
        peoples[6] = new Person(7, "Name7");
        peoples[7] = new Person(8, "Name8");

        // 2. определить от 5 до 8 участников (Person) конкурса - рандомно
        Random random = new Random();
//        int arraySize = random.nextInt(9 - 5) + 5; // генерирует случайное число от 5 до 8 включительно
        int arraySize = (int) (Math.random() * (8 - 5 + 1) + 5); // генерирует случайное число от 5 до 8

        // 3. создать массив с количесвом участников из 2 пункта
        Person[] participants = new Person[arraySize]; // список отобранных участников

        // 4. заполнить массив участниками.
        for (int i = 0; i < participants.length; i++) {
            // 4.1 перебираем массив, и в каждую ячейку устанвливаем Person
            participants[i] = peoples[i];
        }

        // 5.3 установить каждому участнику (перебрав массив участников) рандомное значение количества съеденых пиц(0-6)
        generateSlicePizza(participants);

        for (int i = 0; i < participants.length; i++) {
            participants[i].sayResult();
        }
        System.out.println();

        //отсортируем участников по кол ву съеденных кусков
        bubbleSort(participants);

        //напечатаем победителя
        System.out.println("First place: ");
        participants[0].sayResult();

        //напечатаем 2 и 3 место
        System.out.println("Second place: ");
        participants[1].sayResult();
        System.out.println("Third place: ");
        participants[2].sayResult();
        System.out.println();

        //считаем, сколько всего пицц было съедено
        float counterSlices = 0;
        for (int i = 0; i < participants.length; i++) {
            counterSlices += participants [i].getPizzaSlices();
        }
        System.out.println("Total slices: " + counterSlices);

        int counterPizza = (int)Math.ceil(counterSlices / 8);
        System.out.println("Total pizzas: "+ counterPizza);

        //Не съеденные куски: Определить, сколько кусков пиццы осталось несъеденными после завершения конкурса.
        //используй оператор %
        float residue = counterSlices % 8;
        System.out.println("Residue slices: " + residue);



        //напечатаем награды
//         * Награды: Вручить награды победителям с первого по третье место в соответствии с призами:
// * первому месту - золотую медаль и сертификат на бесплатную пиццу,
// * второму месту - серебряную медаль и сертификат на скидку 50% на следующую пиццу,
// * третьему месту - бронзовую медаль и сертификат на скидку 25% на следующую пиццу.

    }
    /**
     * Устанавливает для каждого участника количесвто съеденых пиц. Используется рандомное значение от 0 до 6
     *
     * @param peoples массив (список) участников
     */
    public static void generateSlicePizza(Person[] peoples) {
        Random random = new Random();
        for (int i = 0; i < peoples.length; i++) { // перебераю массив участников
            Person currentPerson = peoples[i]; // достаю участника из массива по индексу i
            int slices = random.nextInt(7); // 0 - 6
            currentPerson.setPizzaSlices(slices); // устнавливаю количесвто съеденных пиц
            // peoples[i].setPizzaSlices(random.nextInt(7));
        }
    }
    public static void bubbleSort(Person[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) { // правый конец будет двигаться к началу
                Person currentPerson = arr[j];
                Person nextPerson = arr[j + 1];
                if (currentPerson.getPizzaSlices() < nextPerson.getPizzaSlices()) { // если левый из соседей больше правого, то их меняем местами
                    Person tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
    }
}