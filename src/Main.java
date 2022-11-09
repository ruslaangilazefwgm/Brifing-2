import java.util.*;

public class Main {
    public static void main(String[] args) {
//        Необходимо реализовать следующий метод:
//        1. На вход получаем список названий книг
//        2. Распределяем книги по полкам так, чтобы на каждой полке было примерно одинаковое количество книг
//        3. Все книги должны быть отсортированы по алфавиту с первой до последней полки
//        4. Количество полок константное - 5 штук
//        5. Вернуть книги распределенные по полкам
//
//        Напишите пример перехвата и обработки исключения с использованием собственных исключений.
        try {
            List<String> books = List.of(null);
            System.out.println(fillShelves(books));
        } catch (NullPointerException e) {
            System.out.println("Нет книг");
        }
    }

    private static Map<Integer, List<String>> fillShelves(List<String> books) {
        Map<Integer,List<String>> shelves = new HashMap<>();
        for (int i = 0; i < books.size(); i++) {
            int shelveNumber = i % 5;
            if (!shelves.containsKey(shelveNumber)) {
                shelves.put(shelveNumber, new ArrayList<>());
            }
            shelves.get(shelveNumber).add(books.get(i));
        }
        for (Map.Entry<Integer, List<String>> entry : shelves.entrySet()) {
            Collections.sort(entry.getValue());
        }
        return shelves;
    }
}