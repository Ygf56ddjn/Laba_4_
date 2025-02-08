import java.util.Arrays;

public class Main  {

    // Функция для преобразования массива в кучу
    public static void heapify(int arr[], int n, int i) {
        int bolshikoren = i; // Изначально считаем, что наибольший элемент - это текущий корень
        int levidocherni = 2 * i + 1; // Индекс левого дочернего элемента
        int pravidocherni = 2 * i + 2; // Индекс правого дочернего элемента

        // Если левый потомок больше корня, то запоминаем его индекс
        if (levidocherni < n && arr[levidocherni] > arr[bolshikoren]) {
            bolshikoren = levidocherni;
        }

        // Если правый потомок больше текущего наибольшего элемента, то запоминаем его индекс
        if (pravidocherni < n && arr[pravidocherni] > arr[bolshikoren]) {
            bolshikoren = pravidocherni;
        }

        // Если наибольший элемент не корень, меняем местами
        if (bolshikoren != i) {
            int swap = arr[i];
            arr[i] = arr[bolshikoren];
            arr[bolshikoren] = swap;

            // Рекурсивно применяем heapify к измененному поддереву
            heapify(arr, n, bolshikoren);
        }
    }

    // Функция для сортировки массива с использованием пирамидальной сортировки
    public static void heapSort(int arr[]) {
        int size = arr.length; // Определяем размер массива

        // Построение кучи (перегруппируем массив)
        for (int i = size / 2 - 1; i >= 0; i--) {
            heapify(arr, size, i);
        }

        // Один за другим извлекаем элементы из кучи
        for (int i = size - 1; i > 0; i--) {
            int temp = arr[0]; // Перемещаем текущий корень в конец массива
            arr[0] = arr[i];
            arr[i] = temp;

            // Вызываем heapify на уменьшенной куче
            heapify(arr, i, 0);
        }
    }

    public static void main(String[] args) {
        // Двумерный массив чисел
        int[][] numbers = {
                {7, 2, 9, 3, 6},
                {4, 1, 8, 5, 2},
                {3, 7, 5, 9, 1},
                {6, 8, 4, 2, 0}
        };

        // Применяем сортировку к каждой строке массива
        for (int i = 0; i < numbers.length; i++) {
            heapSort(numbers[i]);
        }

        // Выводим отсортированные строки
        for (int i = 0; i < numbers.length; i++) {
            System.out.println(Arrays.toString(numbers[i]));
        }
    }
}
