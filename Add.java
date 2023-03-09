package HWs.HW4.MyPlanner;

import java.util.Scanner;

public class Add {
    private final Scanner scanner;

    public Add(Scanner scanner) {
        this.scanner = scanner;
    }
    public  Task makeNewTask(){
        System.out.println("добавляем новую задачу в планнер.\n Введите тему");
        String sabj = scanner.nextLine();
        System.out.println("Введите время окончания");
        String endOfTask = scanner.nextLine();
        System.out.println("введите автора");
        String author = scanner.nextLine();
        System.out.println("\nУстановите приоритет: 1 - низкий; 2 - средний; 3 - высокий");
        String prior = scanner.nextLine();
        int priority = 0;
        if (prior.equals("1") | prior.equals("2") | prior.equals("3")){
            priority = Integer.parseInt(prior);
        }else {
            System.out.println("Приоритет не установлен");
        }
        return new Task(sabj, author, priority, endOfTask);
    }
}
