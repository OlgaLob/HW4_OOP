package HWs.HW4.MyPlanner;

import java.util.Scanner;

public class Menu {
    private final Scanner scanner;

    public Menu(Scanner scanner) {
        this.scanner = scanner;
    }

    public String selectFunction() {
        System.out.print("""
                ---------------------------------------
                Выберите действие:
                1. показать все задачи;
                2. найти задачу по теме;
                3. найти задачу по автору;
                4. отсортировать задачи по приоритету;
                5. выполнить запись планера в файл;
                6. добавить новую задачу;
                7. изменить существующую задачу;
                --------------------------------------
                0. Выход             
                """);
        return scanner.nextLine();
    }

    public String selectSaveType() {
        System.out.print("""
                Выберите тип файла для записи:
                1. CSV
                2. JSON
                3. XML
                --------------------------------------
                4. Вернуться в меню
                --------------------------------------
                0. Выход
                """);
        return scanner.nextLine();
    }

    public String selectTaskMeth() {
        System.out.print("""
                Что Вы хотите изменить в задаче:
                1. Тему
                2. Имя автора
                3. Приоритет
                4. Дедлайн
                --------------------------------------
                5. Вернуться в меню
                --------------------------------------
                0. Выход
                """);
        return scanner.nextLine();
    }
}
