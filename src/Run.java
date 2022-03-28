import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class Run {
    public static void main(String[] args) {
//      Создаем колекцию строк
     Collection<String> stringCollection = Arrays.asList("Иванов", "Петров", "Сидоров", "Васечкин", "Кузнецов", "Cмирнов", "Попов", "Лебедев","Козлов",
             "Соловьев", "Иванов", "Артемов");

        System.out.println("_______________Операции со строками______________");
        //Найти количество вхождений строки в коллекцию
        System.out.println(List.of(stringCollection.stream().filter("Иванов"::equals).count()));
        //Вывести только уникальные значения
        System.out.println(stringCollection.stream().distinct().collect(Collectors.toList()));
        //Прибавить к каждой строке нижнее подчеркивание
        System.out.println(stringCollection.stream().map((s) -> s + "_").collect(Collectors.toList()));
        //Возвращает тот же стрим, но применяет функцию к каждому элементу стрима и приводит к верхнему регистру
        System.out.println(stringCollection.stream().map(String::toUpperCase).peek((e) -> System.out.print(" " + e)).
                collect(Collectors.toList()));
        //Выводит первые два элемента
        System.out.println(stringCollection.stream().limit(2).collect(Collectors.toList()));
        //Сортирует по количеству элементов в строке
        System.out.println(stringCollection.stream().sorted().collect(Collectors.toList()));
        //Возвращает первый элемент коллекции
        System.out.println(List.of(stringCollection.stream().findFirst().orElse("0")));
        //Проверяет на вхождение элемента в коллекцию
        System.out.println(List.of(stringCollection.stream().anyMatch("Артемов"::equals)));
        //Возвращает самый длинный элемент
        System.out.println(List.of(stringCollection.stream().max(String::compareTo).get()));
        //Возращает самый короткий элемент
        System.out.println(List.of(stringCollection.stream().min(String::compareTo).get()));

        System.out.println("_______________Операции с числами______________");
        //Создаем коллекцию чисел
        Collection<Integer> integerCollection = Arrays.asList(1,2,3,4,418,479,755,505,83,592,399,115,768,410,406,611,101);
        //Отсортировать числа в списке в порядке возрастания
        System.out.println(integerCollection.stream().sorted().collect(Collectors.toList()));
        //Прибавить к каждому числу строку "- следующее число"
        System.out.println(integerCollection.stream().map((s) -> s + "- следующее число").collect(Collectors.toList()));
        //Вывести первые 5 элементов
        System.out.println(integerCollection.stream().limit(5).collect(Collectors.toList()));
        //Перевести все числа в тип Double
        System.out.println(Arrays.toString(integerCollection.stream().mapToDouble((s) -> Double.parseDouble(String.valueOf(s))).toArray()));
        //Получить сумму
        System.out.println(List.of(integerCollection.stream().mapToInt((s) -> Integer.parseInt(String.valueOf(s))).sum()));
        //Получить среднее арифметическое
        System.out.println(List.of(integerCollection.stream().mapToInt((s) -> Integer.parseInt(String.valueOf(s))).average()));
        //Получить максимальное значение
        System.out.println(List.of(integerCollection.stream().max(Integer::compareTo).get()));
        //Получить минимальное значение
        System.out.println(List.of(integerCollection.stream().min(Integer::compareTo).get()));
        //Сумма не четных чисел
        System.out.println(List.of(integerCollection.stream().mapToInt(((p) -> p % 2 == 1 ? p : 0)).sum()));
        //Вычесть от каждого элемента 1 и получить среднее арифметическое
        System.out.println(List.of(integerCollection.stream().collect(Collectors.averagingInt((p) -> p - 1))));
        //Разделить числа на четные и нечетные
        System.out.println(List.of(integerCollection.stream().collect(Collectors.partitioningBy((p) -> p % 2 == 0))));

    }
}
