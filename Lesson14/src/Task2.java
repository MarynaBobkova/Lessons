import java.util.Arrays;

/* Задача 2
Найти элемент N в массиве из сгенерированных чисел и заменить его на минимальный
элемент в массиве. Если n не найден в массиве вывести сообщение, что элемент
не найден!
пример: дано: {10,4,2,3, 1}, n = 2;. Результат: {10,4,1,3, 1
 */
public class Task2 {
    //1. создать массив и заполнить его элементами (с рандомными числами)

    //2. указать значение числа N, n - это искомое число

    //3. найти индекс минимально числа в массиве и сохранить найденный индекс в переменную

    //4.  найти в массиве число n и если оно найдено, сохранить индекс найденного числа n в переменную.
    //4.1 если число n не найденно, вывести в консоль сообщение, о том что данного числа нет в массиве

    //5. заменить число n в массиве на минимальное число из массива.
    //6. распечатать массив используя (System.out.println(Arrays.toString(array)));

    public static void main(String[] args) {
        int[] array = {10, 4, 2, 3, 1};
        int n = 10;

        int minIndex = findMin(array);

        int searchNumberIndex = findIndex(array, n); // метод findIndex(...) может вернуть -1, если элемента нет в массиве

        if (searchNumberIndex >= 0) { // заменяем элемент, только если индекс больше либо равен 0
            // 5. заменить число n в массиве на минимальное число из массива.
               array[searchNumberIndex] = array [minIndex];
        }
        System.out.println(Arrays.toString(array));
    }


    //3. найти индекс минимально числа в массиве и сохранить найденный индекс в переменную
    private static int findMin(int[] array) {
        // int[] copy = Arrays.copyOf(array, array.length); // копирует массив весь array, в переменную copy. Сохраняя все элементы
        int minNumberIndex = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] < array[minNumberIndex]) {
                minNumberIndex = i;
            }
        }
        return minNumberIndex;

        /*
         Как найти минимальный элемнет в массиве:
         Шаг 1: Установка начального значения минимума
                Инициализируйте переменную minElement, которая будет хранить минимальный элемент. В качестве начального значения используют первый элемент массива
         Шаг 2: Обход массива
                Пройдитесь по всем элементам массива, начиная со второго (индекс 1), и сравните каждый элемент с текущим минимальным значением
         Шаг 3: Вывод результата
                После завершения цикла minElement будет содержать минимальный элемент массива. Выведите его:
         */
    }

    //4.  найти в массиве число n и если оно найдено, сохранить индекс найденного числа n в переменную.
    //4.1 если число n не найденно, вывести в консоль сообщение, о том что данного числа нет в массиве
    private static int findIndex(int[] array, int value) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == value) {
                return i;
            }
        }
        return -1;
    }
}
