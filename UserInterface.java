package HWs.HW4.MyPlanner;

import java.util.Scanner;

public class UserInterface {
    private final Scanner scanner;
    private final Menu menu;
    private final Planner planner;
    private final Add add;
    protected static String csvPath = "C:\\Users\\arapo\\IdeaProjects\\OOP\\src\\main\\java" +
            "\\HWs\\HW4\\MyPlanner\\Planner.csv";
    protected static String jsonPath = "C:\\Users\\arapo\\IdeaProjects\\OOP\\src\\main\\java" +
            "\\HWs\\HW4\\MyPlanner\\Planner.json";
    protected static String xmlPath = "C:\\Users\\arapo\\IdeaProjects\\OOP\\src\\main\\java" +
            "\\HWs\\HW4\\MyPlanner\\Planner.xml";

    public UserInterface(Scanner scanner, Menu menu, Planner planner, Add add) {
        this.scanner = scanner;
        this.menu = menu;
        this.planner = planner;
        this.add = add;
    }
    public void start(){
        while (true){
            switch (menu.selectFunction()){
                case "1":
                    planner.sort();
                    planner.showAll();
                    break;
                case "2":
                    System.out.print("Введите тему задачи: ");
                    System.out.println(planner.getBySub(scanner.nextLine()));
                    break;
                case "3":
                    System.out.println("Введите имя автора: ");
                    planner.totalSearch(scanner.nextLine());
                    break;
                case "4":
                    System.out.println("Сначала показаны задачи с высоким приоритетом: ");
                    planner.sortByPrior();
                    planner.showAll();
                    break;
                case "5":
                    saveFile();
                    break;
                case "6":
                    planner.add(add.makeNewTask());
                    break;
                case "7":
                    System.out.println("Введите Id задачи, которую меняем: ");
                    changeTask(planner.getById(scanner.nextInt()));
                case "0":
                    System.exit(0);
                    break;
                default:
                    System.out.println("неверный ввод");
            }
        }
    }
    public void saveFile(){
        PlannerIterator plannerIterator = new PlannerIterator(planner);
        while (true){
            switch (menu.selectSaveType()){
                case "1" ->
                {
                    while (plannerIterator.hasNext()){
                        SaveModel<Task> saved = new SaveModel<>(plannerIterator.next());
                        saved.setFormat(new CsvWriter());
                        saved.setPath(csvPath);
                        saved.save();
                    }
                    System.out.println("Сохранено в CSV");
                }
                case "2" ->
                {
                    while (plannerIterator.hasNext()){
                        SaveModel<Task> saved = new SaveModel<>(plannerIterator.next());
                        saved.setFormat(new JsonWriter());
                        saved.setPath(jsonPath);
                        saved.save();
                    }
                    System.out.println("Сохранено в JSON");
                }
                case "3" ->
                {
                    while (plannerIterator.hasNext()){
                        SaveModel<Task> saved = new SaveModel<>(plannerIterator.next());
                        saved.setFormat(new XmlWriter());
                        saved.setPath(xmlPath);
                        saved.save();
                    }
                    System.out.println("Сохранено в XML");
                }
                case "4" ->
                    start();
                case "0" ->
                    System.exit(0);
                default -> System.out.println("Неверный ввод");
            }
        }
    }
    public void changeTask(Task changing){
        while (true){
            switch (menu.selectTaskMeth()){
                case "1" ->{
                    System.out.println("Введите новую тему");
                    changing.setSubject(scanner.nextLine());
                }
                case "2" ->{
                    System.out.println("Введите нового автора");
                    changing.setAuthor(scanner.nextLine());
                }
                case "3" -> {
                    System.out.println("1 - низкий, 2 - средний, 3 - высокий");
                    changing.setPriority(scanner.nextInt());
                }
                case "4" -> {
                    System.out.println("Введите новый дедлайн");
                    changing.setEndOfTask(scanner.nextLine());
                }
                case "5" ->
                    start();
                case "0" ->
                    System.exit(0);
                default -> System.out.println("Неверный ввод");
            }
        }
    }
}
