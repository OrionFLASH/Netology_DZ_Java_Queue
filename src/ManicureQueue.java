import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Класс для обработки очереди клиентов маникюрного салона.
 * 
 * Каждый клиент обрабатывается в порядке очереди. После обработки клиента
 * с вероятностью 50% в очередь добавляется его друг.
 * 
 * @author Netology Student
 * @version 1.0.0
 */
public class ManicureQueue {
    
    /**
     * Основной метод программы.
     * 
     * Создает очередь из списка первых клиентов и обрабатывает их,
     * добавляя друзей с вероятностью 50% после обработки каждого клиента.
     * 
     * @param args аргументы командной строки (не используются)
     */
    public static void main(String[] args) {
        // Список первых клиентов маникюрного салона
        List<String> firstClients = List.of(
            "Anya", 
            "Sveta", 
            "Olya", 
            "Alexandra", 
            "Ruslana", 
            "Olesya", 
            "Vika"
        );
        
        // Создание пустой очереди для хранения клиентов
        Queue<String> clientQueue = new LinkedList<>();
        
        // Заполнение очереди из списка первых клиентов
        for (String client : firstClients) {
            clientQueue.offer(client);
        }
        
        // Цикл обработки очереди клиентов
        // Продолжаем пока очередь не пуста
        while (!clientQueue.isEmpty()) {
            // Извлечение следующего клиента из начала очереди
            String currentClient = clientQueue.poll();
            
            // Обработка клиента - выполнение маникюра
            System.out.println(currentClient + " сделал новый маникюр.");
            
            // Проверка вероятности 50% для добавления друга клиента
            if (Math.random() < 0.5) {
                // Друг записался - формируем его имя
                String friendName = "a friend of " + currentClient;
                
                // Добавление друга в конец очереди
                clientQueue.offer(friendName);
            }
            // Если условие не выполнилось, друг не записался - ничего не делаем
        }
        
        // Сообщение о завершении обработки всех клиентов
        System.out.println("\nВсе клиенты обработаны. Очередь пуста.");
    }
}

