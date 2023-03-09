package HWs.HW4.MyPlanner;

import java.util.Comparator;

public class TaskComparator implements Comparator<Task> {
    public int compare(Task o1, Task o2){
        return o2.getPriorCode() - o1.getPriorCode();
    }
}
