package HWs.HW4.MyPlanner;

import java.util.Scanner;

public class Controller {
    public static void run(){
        Task t1 = new Task("Купить хлеб", "Ольга", 3, "07.03");
        Task t2 = new Task();
        Task t3 = new Task("Сделать домашнее задание", "Ольга", 3, "10.03");
        Task t4 = new Task("Купить подарки", "Ольга", 2, "08.03");
        Task t5 = new Task("Позвонить в химчистку", "Ольга", 1, "10.03");
        Planner myP = new Planner();
        myP.add(t1);
        myP.add(t2);
        myP.add(t3);
        myP.add(t4);
        myP.add(t5);
        Scanner scanner = new Scanner(System.in);
        Menu menu = new Menu(scanner);
        Add add = new Add(scanner);
        UserInterface userInterface = new UserInterface(scanner, menu, myP, add);
        userInterface.start();
    }

}
